// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package fr.castorflex.android.smoothprogressbar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;

// Referenced classes of package fr.castorflex.android.smoothprogressbar:
//            SmoothProgressDrawable, SmoothProgressBarUtils

public class SmoothProgressBar extends ProgressBar
{

    private static final int INTERPOLATOR_ACCELERATE = 0;
    private static final int INTERPOLATOR_ACCELERATEDECELERATE = 2;
    private static final int INTERPOLATOR_DECELERATE = 3;
    private static final int INTERPOLATOR_LINEAR = 1;

    public SmoothProgressBar(Context context)
    {
        this(context, null);
    }

    public SmoothProgressBar(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, R.attr.spbStyle);
    }

    public SmoothProgressBar(Context context, AttributeSet attributeset, int i)
    {
        float f;
        float f1;
        float f2;
        float f3;
        Interpolator interpolator;
        Drawable drawable;
        Resources resources;
        int j;
        int k;
        int l;
        int i1;
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        super(context, attributeset, i);
        if (isInEditMode())
        {
            setIndeterminateDrawable((new SmoothProgressDrawable.Builder(context, true)).build());
            return;
        }
        resources = context.getResources();
        attributeset = context.obtainStyledAttributes(attributeset, R.styleable.SmoothProgressBar, i, 0);
        i = attributeset.getColor(R.styleable.SmoothProgressBar_spb_color, resources.getColor(R.color.spb_default_color));
        j = attributeset.getInteger(R.styleable.SmoothProgressBar_spb_sections_count, resources.getInteger(R.integer.spb_default_sections_count));
        k = attributeset.getDimensionPixelSize(R.styleable.SmoothProgressBar_spb_stroke_separator_length, resources.getDimensionPixelSize(R.dimen.spb_default_stroke_separator_length));
        f = attributeset.getDimension(R.styleable.SmoothProgressBar_spb_stroke_width, resources.getDimension(R.dimen.spb_default_stroke_width));
        f1 = attributeset.getFloat(R.styleable.SmoothProgressBar_spb_speed, Float.parseFloat(resources.getString(R.string.spb_default_speed)));
        f2 = attributeset.getFloat(R.styleable.SmoothProgressBar_spb_progressiveStart_speed, f1);
        f3 = attributeset.getFloat(R.styleable.SmoothProgressBar_spb_progressiveStop_speed, f1);
        l = attributeset.getInteger(R.styleable.SmoothProgressBar_spb_interpolator, -1);
        flag = attributeset.getBoolean(R.styleable.SmoothProgressBar_spb_reversed, resources.getBoolean(R.bool.spb_default_reversed));
        flag1 = attributeset.getBoolean(R.styleable.SmoothProgressBar_spb_mirror_mode, resources.getBoolean(R.bool.spb_default_mirror_mode));
        i1 = attributeset.getResourceId(R.styleable.SmoothProgressBar_spb_colors, 0);
        flag2 = attributeset.getBoolean(R.styleable.SmoothProgressBar_spb_progressiveStart_activated, resources.getBoolean(R.bool.spb_default_progressiveStart_activated));
        drawable = attributeset.getDrawable(R.styleable.SmoothProgressBar_spb_background);
        flag3 = attributeset.getBoolean(R.styleable.SmoothProgressBar_spb_generate_background_with_colors, false);
        flag4 = attributeset.getBoolean(R.styleable.SmoothProgressBar_spb_gradients, false);
        attributeset.recycle();
        interpolator = null;
        if (l == -1)
        {
            interpolator = getInterpolator();
        }
        attributeset = interpolator;
        if (interpolator != null) goto _L2; else goto _L1
_L1:
        l;
        JVM INSTR tableswitch 1 3: default 312
    //                   1 471
    //                   2 449
    //                   3 460;
           goto _L3 _L4 _L5 _L6
_L4:
        break MISSING_BLOCK_LABEL_471;
_L3:
        attributeset = new AccelerateInterpolator();
_L2:
        int ai[] = null;
        if (i1 != 0)
        {
            ai = resources.getIntArray(i1);
        }
        context = (new SmoothProgressDrawable.Builder(context)).speed(f1).progressiveStartSpeed(f2).progressiveStopSpeed(f3).interpolator(attributeset).sectionsCount(j).separatorLength(k).strokeWidth(f).reversed(flag).mirrorMode(flag1).progressiveStart(flag2).gradients(flag4);
        if (drawable != null)
        {
            context.backgroundDrawable(drawable);
        }
        if (flag3)
        {
            context.generateBackgroundUsingColors();
        }
        if (ai != null && ai.length > 0)
        {
            context.colors(ai);
        } else
        {
            context.color(i);
        }
        setIndeterminateDrawable(context.build());
        return;
_L5:
        attributeset = new AccelerateDecelerateInterpolator();
          goto _L2
_L6:
        attributeset = new DecelerateInterpolator();
          goto _L2
        attributeset = new LinearInterpolator();
          goto _L2
    }

    private SmoothProgressDrawable checkIndeterminateDrawable()
    {
        Drawable drawable = getIndeterminateDrawable();
        if (drawable == null || !(drawable instanceof SmoothProgressDrawable))
        {
            throw new RuntimeException("The drawable is not a SmoothProgressDrawable");
        } else
        {
            return (SmoothProgressDrawable)drawable;
        }
    }

    public void applyStyle(int i)
    {
        TypedArray typedarray;
        typedarray = getContext().obtainStyledAttributes(null, R.styleable.SmoothProgressBar, 0, i);
        if (typedarray.hasValue(R.styleable.SmoothProgressBar_spb_color))
        {
            setSmoothProgressDrawableColor(typedarray.getColor(R.styleable.SmoothProgressBar_spb_color, 0));
        }
        if (typedarray.hasValue(R.styleable.SmoothProgressBar_spb_colors))
        {
            i = typedarray.getResourceId(R.styleable.SmoothProgressBar_spb_colors, 0);
            if (i != 0)
            {
                int ai[] = getResources().getIntArray(i);
                if (ai != null && ai.length > 0)
                {
                    setSmoothProgressDrawableColors(ai);
                }
            }
        }
        if (typedarray.hasValue(R.styleable.SmoothProgressBar_spb_sections_count))
        {
            setSmoothProgressDrawableSectionsCount(typedarray.getInteger(R.styleable.SmoothProgressBar_spb_sections_count, 0));
        }
        if (typedarray.hasValue(R.styleable.SmoothProgressBar_spb_stroke_separator_length))
        {
            setSmoothProgressDrawableSeparatorLength(typedarray.getDimensionPixelSize(R.styleable.SmoothProgressBar_spb_stroke_separator_length, 0));
        }
        if (typedarray.hasValue(R.styleable.SmoothProgressBar_spb_stroke_width))
        {
            setSmoothProgressDrawableStrokeWidth(typedarray.getDimension(R.styleable.SmoothProgressBar_spb_stroke_width, 0.0F));
        }
        if (typedarray.hasValue(R.styleable.SmoothProgressBar_spb_speed))
        {
            setSmoothProgressDrawableSpeed(typedarray.getFloat(R.styleable.SmoothProgressBar_spb_speed, 0.0F));
        }
        if (typedarray.hasValue(R.styleable.SmoothProgressBar_spb_progressiveStart_speed))
        {
            setSmoothProgressDrawableProgressiveStartSpeed(typedarray.getFloat(R.styleable.SmoothProgressBar_spb_progressiveStart_speed, 0.0F));
        }
        if (typedarray.hasValue(R.styleable.SmoothProgressBar_spb_progressiveStop_speed))
        {
            setSmoothProgressDrawableProgressiveStopSpeed(typedarray.getFloat(R.styleable.SmoothProgressBar_spb_progressiveStop_speed, 0.0F));
        }
        if (typedarray.hasValue(R.styleable.SmoothProgressBar_spb_reversed))
        {
            setSmoothProgressDrawableReversed(typedarray.getBoolean(R.styleable.SmoothProgressBar_spb_reversed, false));
        }
        if (typedarray.hasValue(R.styleable.SmoothProgressBar_spb_mirror_mode))
        {
            setSmoothProgressDrawableMirrorMode(typedarray.getBoolean(R.styleable.SmoothProgressBar_spb_mirror_mode, false));
        }
        if (typedarray.hasValue(R.styleable.SmoothProgressBar_spb_progressiveStart_activated))
        {
            setProgressiveStartActivated(typedarray.getBoolean(R.styleable.SmoothProgressBar_spb_progressiveStart_activated, false));
        }
        if (typedarray.hasValue(R.styleable.SmoothProgressBar_spb_progressiveStart_activated))
        {
            setProgressiveStartActivated(typedarray.getBoolean(R.styleable.SmoothProgressBar_spb_progressiveStart_activated, false));
        }
        if (typedarray.hasValue(R.styleable.SmoothProgressBar_spb_gradients))
        {
            setSmoothProgressDrawableUseGradients(typedarray.getBoolean(R.styleable.SmoothProgressBar_spb_gradients, false));
        }
        if (typedarray.hasValue(R.styleable.SmoothProgressBar_spb_generate_background_with_colors) && typedarray.getBoolean(R.styleable.SmoothProgressBar_spb_generate_background_with_colors, false))
        {
            setSmoothProgressDrawableBackgroundDrawable(SmoothProgressBarUtils.generateDrawableWithColors(checkIndeterminateDrawable().getColors(), checkIndeterminateDrawable().getStrokeWidth()));
        }
        if (!typedarray.hasValue(R.styleable.SmoothProgressBar_spb_interpolator)) goto _L2; else goto _L1
_L1:
        typedarray.getInteger(R.styleable.SmoothProgressBar_spb_interpolator, -1);
        JVM INSTR tableswitch 0 3: default 416
    //                   0 465
    //                   1 454
    //                   2 432
    //                   3 443;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        Object obj = null;
_L9:
        if (obj != null)
        {
            setInterpolator(((Interpolator) (obj)));
        }
_L2:
        typedarray.recycle();
        return;
_L6:
        obj = new AccelerateDecelerateInterpolator();
        continue; /* Loop/switch isn't completed */
_L7:
        obj = new DecelerateInterpolator();
        continue; /* Loop/switch isn't completed */
_L5:
        obj = new LinearInterpolator();
        continue; /* Loop/switch isn't completed */
_L4:
        obj = new AccelerateInterpolator();
        if (true) goto _L9; else goto _L8
_L8:
    }

    protected void onDraw(Canvas canvas)
    {
        this;
        JVM INSTR monitorenter ;
        super.onDraw(canvas);
        if (isIndeterminate() && (getIndeterminateDrawable() instanceof SmoothProgressDrawable) && !((SmoothProgressDrawable)getIndeterminateDrawable()).isRunning())
        {
            getIndeterminateDrawable().draw(canvas);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        canvas;
        throw canvas;
    }

    public void progressiveStart()
    {
        checkIndeterminateDrawable().progressiveStart();
    }

    public void progressiveStop()
    {
        checkIndeterminateDrawable().progressiveStop();
    }

    public void setInterpolator(Interpolator interpolator)
    {
        super.setInterpolator(interpolator);
        Drawable drawable = getIndeterminateDrawable();
        if (drawable != null && (drawable instanceof SmoothProgressDrawable))
        {
            ((SmoothProgressDrawable)drawable).setInterpolator(interpolator);
        }
    }

    public void setProgressiveStartActivated(boolean flag)
    {
        checkIndeterminateDrawable().setProgressiveStartActivated(flag);
    }

    public void setSmoothProgressDrawableBackgroundDrawable(Drawable drawable)
    {
        checkIndeterminateDrawable().setBackgroundDrawable(drawable);
    }

    public void setSmoothProgressDrawableCallbacks(SmoothProgressDrawable.Callbacks callbacks)
    {
        checkIndeterminateDrawable().setCallbacks(callbacks);
    }

    public void setSmoothProgressDrawableColor(int i)
    {
        checkIndeterminateDrawable().setColor(i);
    }

    public void setSmoothProgressDrawableColors(int ai[])
    {
        checkIndeterminateDrawable().setColors(ai);
    }

    public void setSmoothProgressDrawableInterpolator(Interpolator interpolator)
    {
        checkIndeterminateDrawable().setInterpolator(interpolator);
    }

    public void setSmoothProgressDrawableMirrorMode(boolean flag)
    {
        checkIndeterminateDrawable().setMirrorMode(flag);
    }

    public void setSmoothProgressDrawableProgressiveStartSpeed(float f)
    {
        checkIndeterminateDrawable().setProgressiveStartSpeed(f);
    }

    public void setSmoothProgressDrawableProgressiveStopSpeed(float f)
    {
        checkIndeterminateDrawable().setProgressiveStopSpeed(f);
    }

    public void setSmoothProgressDrawableReversed(boolean flag)
    {
        checkIndeterminateDrawable().setReversed(flag);
    }

    public void setSmoothProgressDrawableSectionsCount(int i)
    {
        checkIndeterminateDrawable().setSectionsCount(i);
    }

    public void setSmoothProgressDrawableSeparatorLength(int i)
    {
        checkIndeterminateDrawable().setSeparatorLength(i);
    }

    public void setSmoothProgressDrawableSpeed(float f)
    {
        checkIndeterminateDrawable().setSpeed(f);
    }

    public void setSmoothProgressDrawableStrokeWidth(float f)
    {
        checkIndeterminateDrawable().setStrokeWidth(f);
    }

    public void setSmoothProgressDrawableUseGradients(boolean flag)
    {
        checkIndeterminateDrawable().setUseGradients(flag);
    }
}
