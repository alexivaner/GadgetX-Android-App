// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.imagezoom.easing;


// Referenced classes of package it.sephiroth.android.library.imagezoom.easing:
//            Easing

public class Quad
    implements Easing
{

    public Quad()
    {
    }

    public double easeIn(double d, double d1, double d2, double d3)
    {
        d /= d3;
        return d2 * d * d + d1;
    }

    public double easeInOut(double d, double d1, double d2, double d3)
    {
        d /= d3 / 2D;
        if (d < 1.0D)
        {
            return (d2 / 2D) * d * d + d1;
        } else
        {
            d2 = -d2 / 2D;
            d--;
            return d2 * ((d - 2D) * d - 1.0D) + d1;
        }
    }

    public double easeOut(double d, double d1, double d2, double d3)
    {
        d2 = -d2;
        d /= d3;
        return d2 * d * (d - 2D) + d1;
    }
}
