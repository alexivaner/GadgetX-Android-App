// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.imagezoom;


// Referenced classes of package it.sephiroth.android.library.imagezoom:
//            ImageViewTouchBase

public static final class  extends Enum
{

    private static final FIT_IF_BIGGER ENUM$VALUES[];
    public static final FIT_IF_BIGGER FIT_IF_BIGGER;
    public static final FIT_IF_BIGGER FIT_TO_SCREEN;
    public static final FIT_IF_BIGGER NONE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(it/sephiroth/android/library/imagezoom/ImageViewTouchBase$DisplayType, s);
    }

    public static [] values()
    {
         a[] = ENUM$VALUES;
        int i = a.length;
         a1[] = new ENUM.VALUES[i];
        System.arraycopy(a, 0, a1, 0, i);
        return a1;
    }

    static 
    {
        NONE = new <init>("NONE", 0);
        FIT_TO_SCREEN = new <init>("FIT_TO_SCREEN", 1);
        FIT_IF_BIGGER = new <init>("FIT_IF_BIGGER", 2);
        ENUM$VALUES = (new ENUM.VALUES[] {
            NONE, FIT_TO_SCREEN, FIT_IF_BIGGER
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
