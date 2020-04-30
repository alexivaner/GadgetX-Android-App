// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.imagezoom.easing;


// Referenced classes of package it.sephiroth.android.library.imagezoom.easing:
//            Easing

public class Elastic
    implements Easing
{

    public Elastic()
    {
    }

    public double easeIn(double d, double d1, double d2, double d3)
    {
        return easeIn(d, d1, d2, d3, d1 + d2, d3);
    }

    public double easeIn(double d, double d1, double d2, double d3, double d4, double d5)
    {
        if (d == 0.0D)
        {
            return d1;
        }
        double d6 = d / d3;
        if (d6 == 1.0D)
        {
            return d1 + d2;
        }
        d = d5;
        if (d5 <= 0.0D)
        {
            d = d3 * 0.29999999999999999D;
        }
        if (d4 <= 0.0D || d4 < Math.abs(d2))
        {
            d5 = d / 4D;
            d4 = d2;
            d2 = d5;
        } else
        {
            d2 = (d / 6.2831853071795862D) * Math.asin(d2 / d4);
        }
        d5 = d6 - 1.0D;
        return d1 + -(Math.pow(2D, 10D * d5) * d4 * Math.sin(((d5 * d3 - d2) * 6.2831853071795862D) / d));
    }

    public double easeInOut(double d, double d1, double d2, double d3)
    {
        return easeInOut(d, d1, d2, d3, d1 + d2, d3);
    }

    public double easeInOut(double d, double d1, double d2, double d3, double d4, double d5)
    {
        if (d == 0.0D)
        {
            return d1;
        }
        double d6 = d / (d3 / 2D);
        if (d6 == 2D)
        {
            return d1 + d2;
        }
        d = d5;
        if (d5 <= 0.0D)
        {
            d = d3 * 0.44999999999999996D;
        }
        if (d4 <= 0.0D || d4 < Math.abs(d2))
        {
            d4 = d2;
            d5 = d / 4D;
        } else
        {
            d5 = (d / 6.2831853071795862D) * Math.asin(d2 / d4);
        }
        if (d6 < 1.0D)
        {
            d2 = d6 - 1.0D;
            return d1 + -0.5D * (Math.pow(2D, 10D * d2) * d4 * Math.sin(((d2 * d3 - d5) * 6.2831853071795862D) / d));
        } else
        {
            d6--;
            return d1 + (Math.pow(2D, -10D * d6) * d4 * Math.sin(((d6 * d3 - d5) * 6.2831853071795862D) / d) * 0.5D + d2);
        }
    }

    public double easeOut(double d, double d1, double d2, double d3)
    {
        return easeOut(d, d1, d2, d3, d1 + d2, d3);
    }

    public double easeOut(double d, double d1, double d2, double d3, double d4, double d5)
    {
        if (d == 0.0D)
        {
            return d1;
        }
        double d6 = d / d3;
        if (d6 == 1.0D)
        {
            return d1 + d2;
        }
        d = d5;
        if (d5 <= 0.0D)
        {
            d = d3 * 0.29999999999999999D;
        }
        if (d4 <= 0.0D || d4 < Math.abs(d2))
        {
            d4 = d2;
            d5 = d / 4D;
        } else
        {
            d5 = (d / 6.2831853071795862D) * Math.asin(d2 / d4);
        }
        return d1 + (Math.pow(2D, -10D * d6) * d4 * Math.sin(((d6 * d3 - d5) * 6.2831853071795862D) / d) + d2);
    }
}
