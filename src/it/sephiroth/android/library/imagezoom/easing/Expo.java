// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.imagezoom.easing;


// Referenced classes of package it.sephiroth.android.library.imagezoom.easing:
//            Easing

public class Expo
    implements Easing
{

    public Expo()
    {
    }

    public double easeIn(double d, double d1, double d2, double d3)
    {
        if (d == 0.0D)
        {
            return d1;
        } else
        {
            return d1 + Math.pow(2D, 10D * (d / d3 - 1.0D)) * d2;
        }
    }

    public double easeInOut(double d, double d1, double d2, double d3)
    {
        if (d == 0.0D)
        {
            return d1;
        }
        if (d == d3)
        {
            return d1 + d2;
        }
        d /= d3 / 2D;
        if (d < 1.0D)
        {
            return d1 + (d2 / 2D) * Math.pow(2D, 10D * (d - 1.0D));
        } else
        {
            return d1 + (d2 / 2D) * (-Math.pow(2D, -10D * (d - 1.0D)) + 2D);
        }
    }

    public double easeOut(double d, double d1, double d2, double d3)
    {
        if (d == d3)
        {
            return d1 + d2;
        } else
        {
            return (-Math.pow(2D, (-10D * d) / d3) + 1.0D) * d2 + d1;
        }
    }
}
