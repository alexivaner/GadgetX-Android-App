// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.assist;


public final class ImageScaleType extends Enum
{

    private static final ImageScaleType ENUM$VALUES[];
    public static final ImageScaleType EXACTLY;
    public static final ImageScaleType EXACTLY_STRETCHED;
    public static final ImageScaleType IN_SAMPLE_INT;
    public static final ImageScaleType IN_SAMPLE_POWER_OF_2;
    public static final ImageScaleType NONE;
    public static final ImageScaleType NONE_SAFE;

    private ImageScaleType(String s, int i)
    {
        super(s, i);
    }

    public static ImageScaleType valueOf(String s)
    {
        return (ImageScaleType)Enum.valueOf(com/nostra13/universalimageloader/core/assist/ImageScaleType, s);
    }

    public static ImageScaleType[] values()
    {
        ImageScaleType aimagescaletype[] = ENUM$VALUES;
        int i = aimagescaletype.length;
        ImageScaleType aimagescaletype1[] = new ImageScaleType[i];
        System.arraycopy(aimagescaletype, 0, aimagescaletype1, 0, i);
        return aimagescaletype1;
    }

    static 
    {
        NONE = new ImageScaleType("NONE", 0);
        NONE_SAFE = new ImageScaleType("NONE_SAFE", 1);
        IN_SAMPLE_POWER_OF_2 = new ImageScaleType("IN_SAMPLE_POWER_OF_2", 2);
        IN_SAMPLE_INT = new ImageScaleType("IN_SAMPLE_INT", 3);
        EXACTLY = new ImageScaleType("EXACTLY", 4);
        EXACTLY_STRETCHED = new ImageScaleType("EXACTLY_STRETCHED", 5);
        ENUM$VALUES = (new ImageScaleType[] {
            NONE, NONE_SAFE, IN_SAMPLE_POWER_OF_2, IN_SAMPLE_INT, EXACTLY, EXACTLY_STRETCHED
        });
    }
}
