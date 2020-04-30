// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.imagezoom.easing;


// Referenced classes of package it.sephiroth.android.library.imagezoom.easing:
//            Easing

public class Linear
    implements Easing
{

    public Linear()
    {
    }

    public double easeIn(double d, double d1, double d2, double d3)
    {
        return (d2 * d) / d3 + d1;
    }

    public double easeInOut(double d, double d1, double d2, double d3)
    {
        return (d2 * d) / d3 + d1;
    }

    public double easeNone(double d, double d1, double d2, double d3)
    {
        return (d2 * d) / d3 + d1;
    }

    public double easeOut(double d, double d1, double d2, double d3)
    {
        return (d2 * d) / d3 + d1;
    }
}
