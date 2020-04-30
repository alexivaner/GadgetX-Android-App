// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.assist;

import android.widget.ImageView;

public final class ViewScaleType extends Enum
{

    private static int $SWITCH_TABLE$android$widget$ImageView$ScaleType[];
    public static final ViewScaleType CROP;
    private static final ViewScaleType ENUM$VALUES[];
    public static final ViewScaleType FIT_INSIDE;

    static int[] $SWITCH_TABLE$android$widget$ImageView$ScaleType()
    {
        int ai[] = $SWITCH_TABLE$android$widget$ImageView$ScaleType;
        if (ai != null)
        {
            return ai;
        }
        ai = new int[android.widget.ImageView.ScaleType.values().length];
        try
        {
            ai[android.widget.ImageView.ScaleType.CENTER.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            ai[android.widget.ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            ai[android.widget.ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            ai[android.widget.ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            ai[android.widget.ImageView.ScaleType.FIT_END.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            ai[android.widget.ImageView.ScaleType.FIT_START.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            ai[android.widget.ImageView.ScaleType.FIT_XY.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            ai[android.widget.ImageView.ScaleType.MATRIX.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        $SWITCH_TABLE$android$widget$ImageView$ScaleType = ai;
        return ai;
    }

    private ViewScaleType(String s, int i)
    {
        super(s, i);
    }

    public static ViewScaleType fromImageView(ImageView imageview)
    {
        switch ($SWITCH_TABLE$android$widget$ImageView$ScaleType()[imageview.getScaleType().ordinal()])
        {
        default:
            return CROP;

        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
            return FIT_INSIDE;
        }
    }

    public static ViewScaleType valueOf(String s)
    {
        return (ViewScaleType)Enum.valueOf(com/nostra13/universalimageloader/core/assist/ViewScaleType, s);
    }

    public static ViewScaleType[] values()
    {
        ViewScaleType aviewscaletype[] = ENUM$VALUES;
        int i = aviewscaletype.length;
        ViewScaleType aviewscaletype1[] = new ViewScaleType[i];
        System.arraycopy(aviewscaletype, 0, aviewscaletype1, 0, i);
        return aviewscaletype1;
    }

    static 
    {
        FIT_INSIDE = new ViewScaleType("FIT_INSIDE", 0);
        CROP = new ViewScaleType("CROP", 1);
        ENUM$VALUES = (new ViewScaleType[] {
            FIT_INSIDE, CROP
        });
    }
}
