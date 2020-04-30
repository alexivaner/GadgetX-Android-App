// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package fr.castorflex.android.circularprogressbar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ProgressBar;

// Referenced classes of package fr.castorflex.android.circularprogressbar:
//            CircularProgressDrawable

public class CircularProgressBar extends ProgressBar
{

    public CircularProgressBar(Context context)
    {
        this(context, null);
    }

    public CircularProgressBar(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, R.attr.cpbStyle);
    }

    public CircularProgressBar(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        if (isInEditMode())
        {
            setIndeterminateDrawable((new CircularProgressDrawable.Builder(context, true)).build());
            return;
        }
        Resources resources = context.getResources();
        attributeset = context.obtainStyledAttributes(attributeset, R.styleable.CircularProgressBar, i, 0);
        i = attributeset.getColor(R.styleable.CircularProgressBar_cpb_color, resources.getColor(R.color.cpb_default_color));
        float f = attributeset.getDimension(R.styleable.CircularProgressBar_cpb_stroke_width, resources.getDimension(R.dimen.cpb_default_stroke_width));
        float f1 = attributeset.getFloat(R.styleable.CircularProgressBar_cpb_sweep_speed, Float.parseFloat(resources.getString(R.string.cpb_default_sweep_speed)));
        float f2 = attributeset.getFloat(R.styleable.CircularProgressBar_cpb_rotation_speed, Float.parseFloat(resources.getString(R.string.cpb_default_rotation_speed)));
        int j = attributeset.getResourceId(R.styleable.CircularProgressBar_cpb_colors, 0);
        int k = attributeset.getInteger(R.styleable.CircularProgressBar_cpb_min_sweep_angle, resources.getInteger(R.integer.cpb_default_min_sweep_angle));
        int l = attributeset.getInteger(R.styleable.CircularProgressBar_cpb_max_sweep_angle, resources.getInteger(R.integer.cpb_default_max_sweep_angle));
        attributeset.recycle();
        attributeset = null;
        if (j != 0)
        {
            attributeset = resources.getIntArray(j);
        }
        context = (new CircularProgressDrawable.Builder(context)).sweepSpeed(f1).rotationSpeed(f2).strokeWidth(f).minSweepAngle(k).maxSweepAngle(l);
        if (attributeset != null && attributeset.length > 0)
        {
            context.colors(attributeset);
        } else
        {
            context.color(i);
        }
        setIndeterminateDrawable(context.build());
    }

    private CircularProgressDrawable checkIndeterminateDrawable()
    {
        android.graphics.drawable.Drawable drawable = getIndeterminateDrawable();
        if (drawable == null || !(drawable instanceof CircularProgressDrawable))
        {
            throw new RuntimeException("The drawable is not a CircularProgressDrawable");
        } else
        {
            return (CircularProgressDrawable)drawable;
        }
    }

    public void progressiveStop()
    {
        checkIndeterminateDrawable().progressiveStop();
    }

    public void progressiveStop(CircularProgressDrawable.OnEndListener onendlistener)
    {
        checkIndeterminateDrawable().progressiveStop(onendlistener);
    }
}
