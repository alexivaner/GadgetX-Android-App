// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;

// Referenced classes of package com.google.android.gms.internal:
//            zzme

public final class zzkj extends Drawable
    implements android.graphics.drawable.Drawable.Callback
{
    private static final class zza extends Drawable
    {

        private static final zza zzPa = new zza();
        private static final zza zzPb = new zza();

        static zza zziJ()
        {
            return zzPa;
        }

        public void draw(Canvas canvas)
        {
        }

        public android.graphics.drawable.Drawable.ConstantState getConstantState()
        {
            return zzPb;
        }

        public int getOpacity()
        {
            return -2;
        }

        public void setAlpha(int i)
        {
        }

        public void setColorFilter(ColorFilter colorfilter)
        {
        }


        private zza()
        {
        }
    }

    private static final class zza.zza extends android.graphics.drawable.Drawable.ConstantState
    {

        public int getChangingConfigurations()
        {
            return 0;
        }

        public Drawable newDrawable()
        {
            return zza.zziJ();
        }

        private zza.zza()
        {
        }

    }

    static final class zzb extends android.graphics.drawable.Drawable.ConstantState
    {

        int zzPc;
        int zzPd;

        public int getChangingConfigurations()
        {
            return zzPc;
        }

        public Drawable newDrawable()
        {
            return new zzkj(this);
        }

        zzb(zzb zzb1)
        {
            if (zzb1 != null)
            {
                zzPc = zzb1.zzPc;
                zzPd = zzb1.zzPd;
            }
        }
    }


    private int mFrom;
    private boolean zzOF;
    private int zzOM;
    private long zzON;
    private int zzOO;
    private int zzOP;
    private int zzOQ;
    private int zzOR;
    private boolean zzOS;
    private zzb zzOT;
    private Drawable zzOU;
    private Drawable zzOV;
    private boolean zzOW;
    private boolean zzOX;
    private boolean zzOY;
    private int zzOZ;

    public zzkj(Drawable drawable, Drawable drawable1)
    {
        this(null);
        Object obj = drawable;
        if (drawable == null)
        {
            obj = zza.zziJ();
        }
        zzOU = ((Drawable) (obj));
        ((Drawable) (obj)).setCallback(this);
        drawable = zzOT;
        drawable.zzPd = ((zzb) (drawable)).zzPd | ((Drawable) (obj)).getChangingConfigurations();
        drawable = drawable1;
        if (drawable1 == null)
        {
            drawable = zza.zziJ();
        }
        zzOV = drawable;
        drawable.setCallback(this);
        drawable1 = zzOT;
        drawable1.zzPd = ((zzb) (drawable1)).zzPd | drawable.getChangingConfigurations();
    }

    zzkj(zzb zzb1)
    {
        zzOM = 0;
        zzOP = 255;
        zzOR = 0;
        zzOF = true;
        zzOT = new zzb(zzb1);
    }

    public boolean canConstantState()
    {
        if (!zzOW)
        {
            boolean flag;
            if (zzOU.getConstantState() != null && zzOV.getConstantState() != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzOX = flag;
            zzOW = true;
        }
        return zzOX;
    }

    public void draw(Canvas canvas)
    {
        int i;
        int j;
        boolean flag;
        j = 1;
        i = 1;
        flag = false;
        zzOM;
        JVM INSTR tableswitch 1 2: default 36
    //                   1 106
    //                   2 125;
           goto _L1 _L2 _L3
_L1:
        Drawable drawable;
        Drawable drawable1;
        boolean flag1;
        j = zzOR;
        flag1 = zzOF;
        drawable = zzOU;
        drawable1 = zzOV;
        if (i != 0)
        {
            if (!flag1 || j == 0)
            {
                drawable.draw(canvas);
            }
            if (j == zzOP)
            {
                drawable1.setAlpha(zzOP);
                drawable1.draw(canvas);
            }
            return;
        }
        break; /* Loop/switch isn't completed */
_L2:
        zzON = SystemClock.uptimeMillis();
        zzOM = 2;
        i = ((flag) ? 1 : 0);
        continue; /* Loop/switch isn't completed */
_L3:
        if (zzON >= 0L)
        {
            float f = (float)(SystemClock.uptimeMillis() - zzON) / (float)zzOQ;
            float f1;
            if (f >= 1.0F)
            {
                i = j;
            } else
            {
                i = 0;
            }
            if (i != 0)
            {
                zzOM = 0;
            }
            f = Math.min(f, 1.0F);
            f1 = mFrom;
            zzOR = (int)(f * (float)(zzOO - mFrom) + f1);
        }
        continue; /* Loop/switch isn't completed */
        if (flag1)
        {
            drawable.setAlpha(zzOP - j);
        }
        drawable.draw(canvas);
        if (flag1)
        {
            drawable.setAlpha(zzOP);
        }
        if (j > 0)
        {
            drawable1.setAlpha(j);
            drawable1.draw(canvas);
            drawable1.setAlpha(zzOP);
        }
        invalidateSelf();
        return;
        if (true) goto _L1; else goto _L4
_L4:
    }

    public int getChangingConfigurations()
    {
        return super.getChangingConfigurations() | zzOT.zzPc | zzOT.zzPd;
    }

    public android.graphics.drawable.Drawable.ConstantState getConstantState()
    {
        if (canConstantState())
        {
            zzOT.zzPc = getChangingConfigurations();
            return zzOT;
        } else
        {
            return null;
        }
    }

    public int getIntrinsicHeight()
    {
        return Math.max(zzOU.getIntrinsicHeight(), zzOV.getIntrinsicHeight());
    }

    public int getIntrinsicWidth()
    {
        return Math.max(zzOU.getIntrinsicWidth(), zzOV.getIntrinsicWidth());
    }

    public int getOpacity()
    {
        if (!zzOY)
        {
            zzOZ = Drawable.resolveOpacity(zzOU.getOpacity(), zzOV.getOpacity());
            zzOY = true;
        }
        return zzOZ;
    }

    public void invalidateDrawable(Drawable drawable)
    {
        if (zzme.zzkd())
        {
            drawable = getCallback();
            if (drawable != null)
            {
                drawable.invalidateDrawable(this);
            }
        }
    }

    public Drawable mutate()
    {
        if (!zzOS && super.mutate() == this)
        {
            if (!canConstantState())
            {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
            zzOU.mutate();
            zzOV.mutate();
            zzOS = true;
        }
        return this;
    }

    protected void onBoundsChange(Rect rect)
    {
        zzOU.setBounds(rect);
        zzOV.setBounds(rect);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long l)
    {
        if (zzme.zzkd())
        {
            drawable = getCallback();
            if (drawable != null)
            {
                drawable.scheduleDrawable(this, runnable, l);
            }
        }
    }

    public void setAlpha(int i)
    {
        if (zzOR == zzOP)
        {
            zzOR = i;
        }
        zzOP = i;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
        zzOU.setColorFilter(colorfilter);
        zzOV.setColorFilter(colorfilter);
    }

    public void startTransition(int i)
    {
        mFrom = 0;
        zzOO = zzOP;
        zzOR = 0;
        zzOQ = i;
        zzOM = 1;
        invalidateSelf();
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable)
    {
        if (zzme.zzkd())
        {
            drawable = getCallback();
            if (drawable != null)
            {
                drawable.unscheduleDrawable(this, runnable);
            }
        }
    }

    public Drawable zziI()
    {
        return zzOV;
    }
}
