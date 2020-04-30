// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.imagezoom.easing;


// Referenced classes of package it.sephiroth.android.library.imagezoom.easing:
//            Easing

public class Bounce
    implements Easing
{

    public Bounce()
    {
    }

    public double easeIn(double d, double d1, double d2, double d3)
    {
        return (d2 - easeOut(d3 - d, 0.0D, d2, d3)) + d1;
    }

    public double easeInOut(double d, double d1, double d2, double d3)
    {
        if (d < d3 / 2D)
        {
            return easeIn(d * 2D, 0.0D, d2, d3) * 0.5D + d1;
        } else
        {
            return easeOut(2D * d - d3, 0.0D, d2, d3) * 0.5D + 0.5D * d2 + d1;
        }
    }

    public double easeOut(double d, double d1, double d2, double d3)
    {
        d /= d3;
        if (d < 0.36363636363636365D)
        {
            return 7.5625D * d * d * d2 + d1;
        }
        if (d < 0.72727272727272729D)
        {
            d -= 0.54545454545454541D;
            return (7.5625D * d * d + 0.75D) * d2 + d1;
        }
        if (d < 0.90909090909090906D)
        {
            d -= 0.81818181818181823D;
            return (7.5625D * d * d + 0.9375D) * d2 + d1;
        } else
        {
            d -= 0.95454545454545459D;
            return (7.5625D * d * d + 0.984375D) * d2 + d1;
        }
    }
}
