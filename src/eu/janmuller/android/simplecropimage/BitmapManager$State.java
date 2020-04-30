// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package eu.janmuller.android.simplecropimage;


// Referenced classes of package eu.janmuller.android.simplecropimage:
//            BitmapManager

private static final class  extends Enum
{

    public static final ALLOW ALLOW;
    public static final ALLOW CANCEL;
    private static final ALLOW ENUM$VALUES[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(eu/janmuller/android/simplecropimage/BitmapManager$State, s);
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
        CANCEL = new <init>("CANCEL", 0);
        ALLOW = new <init>("ALLOW", 1);
        ENUM$VALUES = (new ENUM.VALUES[] {
            CANCEL, ALLOW
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
