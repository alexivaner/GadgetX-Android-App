// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package eu.janmuller.android.simplecropimage;


// Referenced classes of package eu.janmuller.android.simplecropimage:
//            HighlightView

static final class  extends Enum
{

    private static final Grow ENUM$VALUES[];
    public static final Grow Grow;
    public static final Grow Move;
    public static final Grow None;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(eu/janmuller/android/simplecropimage/HighlightView$ModifyMode, s);
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
        None = new <init>("None", 0);
        Move = new <init>("Move", 1);
        Grow = new <init>("Grow", 2);
        ENUM$VALUES = (new ENUM.VALUES[] {
            None, Move, Grow
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
