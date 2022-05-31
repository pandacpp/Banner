package com.panda.sample;


import androidx.viewpager.widget.ViewPager;

import com.panda.sample.transformer.AccordionTransformer;
import com.panda.sample.transformer.BackgroundToForegroundTransformer;
import com.panda.sample.transformer.CubeInTransformer;
import com.panda.sample.transformer.CubeOutTransformer;
import com.panda.sample.transformer.DefaultTransformer;
import com.panda.sample.transformer.DepthPageTransformer;
import com.panda.sample.transformer.FlipHorizontalTransformer;
import com.panda.sample.transformer.FlipVerticalTransformer;
import com.panda.sample.transformer.ForegroundToBackgroundTransformer;
import com.panda.sample.transformer.RotateDownTransformer;
import com.panda.sample.transformer.RotateUpTransformer;
import com.panda.sample.transformer.ScaleInOutTransformer;
import com.panda.sample.transformer.StackTransformer;
import com.panda.sample.transformer.TabletTransformer;
import com.panda.sample.transformer.ZoomInTransformer;
import com.panda.sample.transformer.ZoomOutSlideTransformer;
import com.panda.sample.transformer.ZoomOutTranformer;

public class Transformer {
    public static Class<? extends ViewPager.PageTransformer> Default = DefaultTransformer.class;
    public static Class<? extends ViewPager.PageTransformer> Accordion = AccordionTransformer.class;
    public static Class<? extends ViewPager.PageTransformer> BackgroundToForeground = BackgroundToForegroundTransformer.class;
    public static Class<? extends ViewPager.PageTransformer> ForegroundToBackground = ForegroundToBackgroundTransformer.class;
    public static Class<? extends ViewPager.PageTransformer> CubeIn = CubeInTransformer.class;
    public static Class<? extends ViewPager.PageTransformer> CubeOut = CubeOutTransformer.class;
    public static Class<? extends ViewPager.PageTransformer> DepthPage = DepthPageTransformer.class;
    public static Class<? extends ViewPager.PageTransformer> FlipHorizontal = FlipHorizontalTransformer.class;
    public static Class<? extends ViewPager.PageTransformer> FlipVertical = FlipVerticalTransformer.class;
    public static Class<? extends ViewPager.PageTransformer> RotateDown = RotateDownTransformer.class;
    public static Class<? extends ViewPager.PageTransformer> RotateUp = RotateUpTransformer.class;
    public static Class<? extends ViewPager.PageTransformer> ScaleInOut = ScaleInOutTransformer.class;
    public static Class<? extends ViewPager.PageTransformer> Stack = StackTransformer.class;
    public static Class<? extends ViewPager.PageTransformer> Tablet = TabletTransformer.class;
    public static Class<? extends ViewPager.PageTransformer> ZoomIn = ZoomInTransformer.class;
    public static Class<? extends ViewPager.PageTransformer> ZoomOut = ZoomOutTranformer.class;
    public static Class<? extends ViewPager.PageTransformer> ZoomOutSlide = ZoomOutSlideTransformer.class;
}
