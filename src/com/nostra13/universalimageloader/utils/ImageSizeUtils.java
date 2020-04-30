// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.utils;

import android.opengl.GLES10;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;

public final class ImageSizeUtils
{

    private static int $SWITCH_TABLE$com$nostra13$universalimageloader$core$assist$ViewScaleType[];
    private static final int DEFAULT_MAX_BITMAP_DIMENSION = 2048;
    private static ImageSize maxBitmapSize;

    static int[] $SWITCH_TABLE$com$nostra13$universalimageloader$core$assist$ViewScaleType()
    {
        int ai[] = $SWITCH_TABLE$com$nostra13$universalimageloader$core$assist$ViewScaleType;
        if (ai != null)
        {
            return ai;
        }
        ai = new int[ViewScaleType.values().length];
        try
        {
            ai[ViewScaleType.CROP.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            ai[ViewScaleType.FIT_INSIDE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        $SWITCH_TABLE$com$nostra13$universalimageloader$core$assist$ViewScaleType = ai;
        return ai;
    }

    private ImageSizeUtils()
    {
    }

    public static int computeImageSampleSize(ImageSize imagesize, ImageSize imagesize1, ViewScaleType viewscaletype, boolean flag)
    {
        int i;
        int j;
        boolean flag1;
        int j1;
        int k1;
        int l1;
        int i2;
        j1 = imagesize.getWidth();
        k1 = imagesize.getHeight();
        l1 = imagesize1.getWidth();
        i2 = imagesize1.getHeight();
        j = 1;
        i = 1;
        flag1 = true;
        $SWITCH_TABLE$com$nostra13$universalimageloader$core$assist$ViewScaleType()[viewscaletype.ordinal()];
        JVM INSTR tableswitch 1 2: default 64
    //                   1 92
    //                   2 159;
           goto _L1 _L2 _L3
_L1:
        i = ((flag1) ? 1 : 0);
_L5:
        j = i;
        if (i < 1)
        {
            j = 1;
        }
        return considerMaxTextureSize(j1, k1, j, flag);
_L2:
        if (flag)
        {
            int l = j1 / 2;
            int j2 = k1 / 2;
            do
            {
                if (l / j <= l1)
                {
                    i = j;
                    if (j2 / j <= i2)
                    {
                        continue; /* Loop/switch isn't completed */
                    }
                }
                j *= 2;
            } while (true);
        }
        i = Math.max(j1 / l1, k1 / i2);
        continue; /* Loop/switch isn't completed */
_L3:
        if (flag)
        {
            int i1 = j1 / 2;
            int k2 = k1 / 2;
            int k = i;
            do
            {
                i = k;
                if (i1 / k <= l1)
                {
                    continue; /* Loop/switch isn't completed */
                }
                i = k;
                if (k2 / k <= i2)
                {
                    continue; /* Loop/switch isn't completed */
                }
                k *= 2;
            } while (true);
        }
        i = Math.min(j1 / l1, k1 / i2);
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static float computeImageScale(ImageSize imagesize, ImageSize imagesize1, ViewScaleType viewscaletype, boolean flag)
    {
label0:
        {
            int k = imagesize.getWidth();
            int l = imagesize.getHeight();
            int j = imagesize1.getWidth();
            int i = imagesize1.getHeight();
            float f = (float)k / (float)j;
            float f1 = (float)l / (float)i;
            if (viewscaletype == ViewScaleType.FIT_INSIDE && f >= f1 || viewscaletype == ViewScaleType.CROP && f < f1)
            {
                i = (int)((float)l / f);
            } else
            {
                j = (int)((float)k / f1);
            }
            f1 = 1.0F;
            if (flag || j >= k || i >= l)
            {
                f = f1;
                if (!flag)
                {
                    break label0;
                }
                f = f1;
                if (j == k)
                {
                    break label0;
                }
                f = f1;
                if (i == l)
                {
                    break label0;
                }
            }
            f = (float)j / (float)k;
        }
        return f;
    }

    public static int computeMinImageSampleSize(ImageSize imagesize)
    {
        int i = imagesize.getWidth();
        int j = imagesize.getHeight();
        int k = maxBitmapSize.getWidth();
        int l = maxBitmapSize.getHeight();
        return Math.max((int)Math.ceil((float)i / (float)k), (int)Math.ceil((float)j / (float)l));
    }

    private static int considerMaxTextureSize(int i, int j, int k, boolean flag)
    {
        int l = maxBitmapSize.getWidth();
        int i1 = maxBitmapSize.getHeight();
        do
        {
            if (i / k <= l && j / k <= i1)
            {
                return k;
            }
            if (flag)
            {
                k *= 2;
            } else
            {
                k++;
            }
        } while (true);
    }

    public static ImageSize defineTargetSizeForView(ImageAware imageaware, ImageSize imagesize)
    {
        int j = imageaware.getWidth();
        int i = j;
        if (j <= 0)
        {
            i = imagesize.getWidth();
        }
        int k = imageaware.getHeight();
        j = k;
        if (k <= 0)
        {
            j = imagesize.getHeight();
        }
        return new ImageSize(i, j);
    }

    static 
    {
        int ai[] = new int[1];
        GLES10.glGetIntegerv(3379, ai, 0);
        int i = Math.max(ai[0], 2048);
        maxBitmapSize = new ImageSize(i, i);
    }
}
