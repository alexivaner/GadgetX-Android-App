// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.widget:
//            RoundedDrawable

public class RoundedImageView extends ImageView
{

    private static int $SWITCH_TABLE$android$widget$ImageView$ScaleType[];
    static final boolean $assertionsDisabled;
    public static final float DEFAULT_BORDER_WIDTH = 0F;
    public static final float DEFAULT_RADIUS = 0F;
    public static final android.graphics.Shader.TileMode DEFAULT_TILE_MODE;
    private static final android.widget.ImageView.ScaleType SCALE_TYPES[];
    public static final String TAG = "RoundedImageView";
    private static final int TILE_MODE_CLAMP = 0;
    private static final int TILE_MODE_MIRROR = 2;
    private static final int TILE_MODE_REPEAT = 1;
    private static final int TILE_MODE_UNDEFINED = -2;
    private ColorStateList borderColor;
    private float borderWidth;
    private float cornerRadius;
    private boolean isOval;
    private Drawable mBackgroundDrawable;
    private ColorFilter mColorFilter;
    private boolean mColorMod;
    private Drawable mDrawable;
    private boolean mHasColorFilter;
    private int mResource;
    private android.widget.ImageView.ScaleType mScaleType;
    private boolean mutateBackground;
    private android.graphics.Shader.TileMode tileModeX;
    private android.graphics.Shader.TileMode tileModeY;

    static int[] $SWITCH_TABLE$android$widget$ImageView$ScaleType()
    {
        int ai[] = $SWITCH_TABLE$android$widget$ImageView$ScaleType;
        if (ai != null)
        {
            return ai;
        }
        ai = new int[android.widget.ImageView.ScaleType.values().length];
        try
        {
            ai[android.widget.ImageView.ScaleType.CENTER.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            ai[android.widget.ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            ai[android.widget.ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            ai[android.widget.ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            ai[android.widget.ImageView.ScaleType.FIT_END.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            ai[android.widget.ImageView.ScaleType.FIT_START.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            ai[android.widget.ImageView.ScaleType.FIT_XY.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            ai[android.widget.ImageView.ScaleType.MATRIX.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        $SWITCH_TABLE$android$widget$ImageView$ScaleType = ai;
        return ai;
    }

    public RoundedImageView(Context context)
    {
        super(context);
        cornerRadius = 0.0F;
        borderWidth = 0.0F;
        borderColor = ColorStateList.valueOf(0xff000000);
        isOval = false;
        mutateBackground = false;
        tileModeX = DEFAULT_TILE_MODE;
        tileModeY = DEFAULT_TILE_MODE;
        mColorFilter = null;
        mHasColorFilter = false;
        mColorMod = false;
    }

    public RoundedImageView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public RoundedImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        cornerRadius = 0.0F;
        borderWidth = 0.0F;
        borderColor = ColorStateList.valueOf(0xff000000);
        isOval = false;
        mutateBackground = false;
        tileModeX = DEFAULT_TILE_MODE;
        tileModeY = DEFAULT_TILE_MODE;
        mColorFilter = null;
        mHasColorFilter = false;
        mColorMod = false;
        context = context.obtainStyledAttributes(attributeset, com.inponsel.android.R.styleable.RoundedImageView, i, 0);
        i = context.getInt(0, -1);
        if (i >= 0)
        {
            setScaleType(SCALE_TYPES[i]);
        } else
        {
            setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
        }
        cornerRadius = context.getDimensionPixelSize(2, -1);
        borderWidth = context.getDimensionPixelSize(3, -1);
        if (cornerRadius < 0.0F)
        {
            cornerRadius = 0.0F;
        }
        if (borderWidth < 0.0F)
        {
            borderWidth = 0.0F;
        }
        borderColor = context.getColorStateList(4);
        if (borderColor == null)
        {
            borderColor = ColorStateList.valueOf(0xff000000);
        }
        mutateBackground = context.getBoolean(5, false);
        isOval = context.getBoolean(6, false);
        i = context.getInt(7, -2);
        if (i != -2)
        {
            setTileModeX(parseTileMode(i));
            setTileModeY(parseTileMode(i));
        }
        i = context.getInt(8, -2);
        if (i != -2)
        {
            setTileModeX(parseTileMode(i));
        }
        i = context.getInt(9, -2);
        if (i != -2)
        {
            setTileModeY(parseTileMode(i));
        }
        updateDrawableAttrs();
        updateBackgroundDrawableAttrs(true);
        context.recycle();
    }

    private void applyColorMod()
    {
        if (mDrawable != null && mColorMod)
        {
            mDrawable = mDrawable.mutate();
            if (mHasColorFilter)
            {
                mDrawable.setColorFilter(mColorFilter);
            }
        }
    }

    private static android.graphics.Shader.TileMode parseTileMode(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return android.graphics.Shader.TileMode.CLAMP;

        case 1: // '\001'
            return android.graphics.Shader.TileMode.REPEAT;

        case 2: // '\002'
            return android.graphics.Shader.TileMode.MIRROR;
        }
    }

    private Drawable resolveResource()
    {
        Resources resources = getResources();
        if (resources == null)
        {
            return null;
        }
        Object obj = null;
        Drawable drawable = obj;
        if (mResource != 0)
        {
            try
            {
                drawable = resources.getDrawable(mResource);
            }
            catch (Exception exception)
            {
                Log.w("RoundedImageView", (new StringBuilder("Unable to find resource: ")).append(mResource).toString());
                mResource = 0;
                exception = obj;
            }
        }
        return RoundedDrawable.fromDrawable(drawable);
    }

    private void updateAttrs(Drawable drawable)
    {
        if (drawable != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (drawable instanceof RoundedDrawable)
        {
            ((RoundedDrawable)drawable).setScaleType(mScaleType).setCornerRadius(cornerRadius).setBorderWidth(borderWidth).setBorderColor(borderColor).setOval(isOval).setTileModeX(tileModeX).setTileModeY(tileModeY);
            applyColorMod();
            return;
        }
        if (drawable instanceof LayerDrawable)
        {
            drawable = (LayerDrawable)drawable;
            int i = 0;
            int j = drawable.getNumberOfLayers();
            while (i < j) 
            {
                updateAttrs(drawable.getDrawable(i));
                i++;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    private void updateBackgroundDrawableAttrs(boolean flag)
    {
        if (mutateBackground)
        {
            if (flag)
            {
                mBackgroundDrawable = RoundedDrawable.fromDrawable(mBackgroundDrawable);
            }
            updateAttrs(mBackgroundDrawable);
        }
    }

    private void updateDrawableAttrs()
    {
        updateAttrs(mDrawable);
    }

    protected void drawableStateChanged()
    {
        super.drawableStateChanged();
        invalidate();
    }

    public int getBorderColor()
    {
        return borderColor.getDefaultColor();
    }

    public ColorStateList getBorderColors()
    {
        return borderColor;
    }

    public float getBorderWidth()
    {
        return borderWidth;
    }

    public float getCornerRadius()
    {
        return cornerRadius;
    }

    public android.widget.ImageView.ScaleType getScaleType()
    {
        return mScaleType;
    }

    public android.graphics.Shader.TileMode getTileModeX()
    {
        return tileModeX;
    }

    public android.graphics.Shader.TileMode getTileModeY()
    {
        return tileModeY;
    }

    public boolean isOval()
    {
        return isOval;
    }

    public void mutateBackground(boolean flag)
    {
        if (mutateBackground == flag)
        {
            return;
        } else
        {
            mutateBackground = flag;
            updateBackgroundDrawableAttrs(true);
            invalidate();
            return;
        }
    }

    public boolean mutatesBackground()
    {
        return mutateBackground;
    }

    public void setBackground(Drawable drawable)
    {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundDrawable(Drawable drawable)
    {
        mBackgroundDrawable = drawable;
        updateBackgroundDrawableAttrs(true);
        super.setBackgroundDrawable(mBackgroundDrawable);
    }

    public void setBorderColor(int i)
    {
        setBorderColor(ColorStateList.valueOf(i));
    }

    public void setBorderColor(ColorStateList colorstatelist)
    {
        if (!borderColor.equals(colorstatelist))
        {
            if (colorstatelist == null)
            {
                colorstatelist = ColorStateList.valueOf(0xff000000);
            }
            borderColor = colorstatelist;
            updateDrawableAttrs();
            updateBackgroundDrawableAttrs(false);
            if (borderWidth > 0.0F)
            {
                invalidate();
                return;
            }
        }
    }

    public void setBorderWidth(float f)
    {
        if (borderWidth == f)
        {
            return;
        } else
        {
            borderWidth = f;
            updateDrawableAttrs();
            updateBackgroundDrawableAttrs(false);
            invalidate();
            return;
        }
    }

    public void setBorderWidth(int i)
    {
        setBorderWidth(getResources().getDimension(i));
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
        if (mColorFilter != colorfilter)
        {
            mColorFilter = colorfilter;
            mHasColorFilter = true;
            mColorMod = true;
            applyColorMod();
            invalidate();
        }
    }

    public void setCornerRadius(float f)
    {
        if (cornerRadius == f)
        {
            return;
        } else
        {
            cornerRadius = f;
            updateDrawableAttrs();
            updateBackgroundDrawableAttrs(false);
            invalidate();
            return;
        }
    }

    public void setCornerRadiusDimen(int i)
    {
        setCornerRadius(getResources().getDimension(i));
    }

    public void setImageBitmap(Bitmap bitmap)
    {
        mResource = 0;
        mDrawable = RoundedDrawable.fromBitmap(bitmap);
        updateDrawableAttrs();
        super.setImageDrawable(mDrawable);
    }

    public void setImageDrawable(Drawable drawable)
    {
        mResource = 0;
        mDrawable = RoundedDrawable.fromDrawable(drawable);
        updateDrawableAttrs();
        super.setImageDrawable(mDrawable);
    }

    public void setImageResource(int i)
    {
        if (mResource != i)
        {
            mResource = i;
            mDrawable = resolveResource();
            updateDrawableAttrs();
            super.setImageDrawable(mDrawable);
        }
    }

    public void setImageURI(Uri uri)
    {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    public void setOval(boolean flag)
    {
        isOval = flag;
        updateDrawableAttrs();
        updateBackgroundDrawableAttrs(false);
        invalidate();
    }

    public void setScaleType(android.widget.ImageView.ScaleType scaletype)
    {
        if (!$assertionsDisabled && scaletype == null)
        {
            throw new AssertionError();
        }
        if (mScaleType == scaletype) goto _L2; else goto _L1
_L1:
        mScaleType = scaletype;
        $SWITCH_TABLE$android$widget$ImageView$ScaleType()[scaletype.ordinal()];
        JVM INSTR tableswitch 1 7: default 80
    //                   1 99
    //                   2 99
    //                   3 99
    //                   4 99
    //                   5 99
    //                   6 99
    //                   7 99;
           goto _L3 _L4 _L4 _L4 _L4 _L4 _L4 _L4
_L3:
        super.setScaleType(scaletype);
_L6:
        updateDrawableAttrs();
        updateBackgroundDrawableAttrs(false);
        invalidate();
_L2:
        return;
_L4:
        super.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void setTileModeX(android.graphics.Shader.TileMode tilemode)
    {
        if (tileModeX == tilemode)
        {
            return;
        } else
        {
            tileModeX = tilemode;
            updateDrawableAttrs();
            updateBackgroundDrawableAttrs(false);
            invalidate();
            return;
        }
    }

    public void setTileModeY(android.graphics.Shader.TileMode tilemode)
    {
        if (tileModeY == tilemode)
        {
            return;
        } else
        {
            tileModeY = tilemode;
            updateDrawableAttrs();
            updateBackgroundDrawableAttrs(false);
            invalidate();
            return;
        }
    }

    static 
    {
        boolean flag;
        if (!com/inponsel/android/widget/RoundedImageView.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
        DEFAULT_TILE_MODE = android.graphics.Shader.TileMode.CLAMP;
        SCALE_TYPES = (new android.widget.ImageView.ScaleType[] {
            android.widget.ImageView.ScaleType.MATRIX, android.widget.ImageView.ScaleType.FIT_XY, android.widget.ImageView.ScaleType.FIT_START, android.widget.ImageView.ScaleType.FIT_CENTER, android.widget.ImageView.ScaleType.FIT_END, android.widget.ImageView.ScaleType.CENTER, android.widget.ImageView.ScaleType.CENTER_CROP, android.widget.ImageView.ScaleType.CENTER_INSIDE
        });
    }
}
