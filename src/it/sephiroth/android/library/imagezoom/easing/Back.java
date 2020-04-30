// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.imagezoom.easing;


// Referenced classes of package it.sephiroth.android.library.imagezoom.easing:
//            Easing

public class Back
    implements Easing
{

    public Back()
    {
    }

    public double easeIn(double d, double d1, double d2, double d3)
    {
        return easeIn(d, d1, d2, d3, 0.0D);
    }

    public double easeIn(double d, double d1, double d2, double d3, double d4)
    {
        double d5 = d4;
        if (d4 == 0.0D)
        {
            d5 = 1.7015800000000001D;
        }
        d /= d3;
        return d2 * d * d * ((1.0D + d5) * d - d5) + d1;
    }

    public double easeInOut(double d, double d1, double d2, double d3)
    {
        return easeInOut(d, d1, d2, d3, 0.90000000000000002D);
    }

    public double easeInOut(double d, double d1, double d2, double d3, double d4)
    {
        double d5 = d4;
        if (d4 == 0.0D)
        {
            d5 = 1.7015800000000001D;
        }
        d /= d3 / 2D;
        if (d < 1.0D)
        {
            d2 /= 2D;
            d3 = d5 * 1.5249999999999999D;
            return d2 * (d * d * ((1.0D + d3) * d - d3)) + d1;
        } else
        {
            d2 /= 2D;
            d -= 2D;
            d3 = d5 * 1.5249999999999999D;
            return d2 * (d * d * ((1.0D + d3) * d + d3) + 2D) + d1;
        }
    }

    public double easeOut(double d, double d1, double d2, double d3)
    {
        return easeOut(d, d1, d2, d3, 0.0D);
    }

    public double easeOut(double d, double d1, double d2, double d3, double d4)
    {
        double d5 = d4;
        if (d4 == 0.0D)
        {
            d5 = 1.7015800000000001D;
        }
        d = d / d3 - 1.0D;
        return (d * d * ((1.0D + d5) * d + d5) + 1.0D) * d2 + d1;
    }
}
