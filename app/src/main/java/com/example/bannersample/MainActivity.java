package com.example.bannersample;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.ColorUtils;
import androidx.viewpager.widget.ViewPager;

import com.panda.sample.Banner;
import com.panda.sample.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String TAG = "AAA";
    private List<String> bannerList = new ArrayList<>();
    private List<ColorInfo> colorList = new ArrayList<>();
    private BannerImageLoader imageLoader;
    private ImageView ivBannerHeadBg;
    private Banner banner;
    private int count;
    private boolean isInit = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();
        initBanner();
    }

    private void initView() {
        ivBannerHeadBg = (ImageView) findViewById(R.id.iv_banner_head_bg);
        banner = (Banner) findViewById(R.id.banner);

        banner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (positionOffset > 1) {//会出现极个别大于1的数据
                    return;
                }
                //修正position，解决两头颜色错乱，来自Banner控件源码
                if (position == 0) {
                    position = count;
                }
                if (position > count) {
                    position = 1;
                }
                int pos = (position + 1) % count;//很关键

                int vibrantColor = ColorUtils.blendARGB(imageLoader.getVibrantColor(pos), imageLoader.getVibrantColor(pos + 1), positionOffset);
                ivBannerHeadBg.setBackgroundColor(vibrantColor);
                setStatusBarColor(MainActivity.this, vibrantColor);
            }

            @Override
            public void onPageSelected(final int position) {
                if(isInit){// 第一次,延时加载才能拿到颜色
                    isInit = false;
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            int vibrantColor = imageLoader.getVibrantColor(1);
                            ivBannerHeadBg.setBackgroundColor(vibrantColor);
                            setStatusBarColor(MainActivity.this, vibrantColor);
                        }
                    }, 200);

                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    /**
     * 初始化banner
     */
    private void initBanner() {
        bannerList.add("https://zwwh.cnki.net/zwwh/images/6295a8989b0f86154950aa2c");
        bannerList.add("https://zwwh.cnki.net/zwwh/images/6295a8369b0f86154950aa28");
        bannerList.add("https://zwwh.cnki.net/zwwh/images/6295a85d9b0f86154950aa2a");
        bannerList.add("https://zwwh.cnki.net/zwwh/images/6286137a9b0f86154950a9a5");
        bannerList.add("https://zwwh.cnki.net/zwwh/images/628613559b0f86154950a9a2");
        count = bannerList.size();
        colorList.clear();
        for (int i = 0; i <= count + 1; i++) {
            ColorInfo info = new ColorInfo();
            if (i == 0) {
                info.setImgUrl(bannerList.get(count - 1));
            } else if (i == count + 1) {
                info.setImgUrl(bannerList.get(0));
            } else {
                info.setImgUrl(bannerList.get(i - 1));
            }
            colorList.add(info);
        }

        imageLoader = new BannerImageLoader(colorList);
        banner.setImageLoader(imageLoader);
        //设置图片集合
        banner.setImages(bannerList);
        //设置banner动画效果
        // banner.setBannerAnimation(Transformer.DepthPage);
        //设置轮播时间
        banner.setDelayTime(3000);
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {

            }
        });
        //banner设置方法全部调用完毕时最后调用
        banner.start();

    }

    /**
     * 设置状态栏颜色
     *
     * @param activity
     */
    public static void setStatusBarColor(Activity activity, int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            //状态栏改变颜色。
            window.setStatusBarColor(color);
        }
    }
}
