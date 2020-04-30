// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.imagezoom.easing;


// Referenced classes of package it.sephiroth.android.library.imagezoom.easing:
//            Easing

public class Sine
    implements Easing
{

    public Sine()
    {
    }

    public double easeIn(double d, double d1, double d2, double d3)
    {
        return -d2 * Math.cos((d / d3) * 1.5707963267948966D) + d2 + d1;
    }

    public double easeInOut(double d, double d1, double d2, double d3)
    {
        return (-d2 / 2D) * (Math.cos((3.1415926535897931D * d) / d3) - 1.0D) + d1;
    }

    public double easeOut(double d, double d1, double d2, double d3)
    {
        return Math.sin((d / d3) * 1.5707963267948966D) * d2 + d1;
    }
}
