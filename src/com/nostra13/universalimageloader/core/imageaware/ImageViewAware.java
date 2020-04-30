// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.imageaware;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.utils.L;
import java.lang.ref.Reference;
import java.lang.reflect.Field;

// Referenced classes of package com.nostra13.universalimageloader.core.imageaware:
//            ViewAware

public class ImageViewAware extends ViewAware
{

    public ImageViewAware(ImageView imageview)
    {
        super(imageview);
    }

    public ImageViewAware(ImageView imageview, boolean flag)
    {
        super(imageview, flag);
    }

    private static int getImageViewFieldValue(Object obj, String s)
    {
        boolean flag = false;
        int i;
        int j;
        try
        {
            s = android/widget/ImageView.getDeclaredField(s);
            s.setAccessible(true);
            j = ((Integer)s.get(obj)).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            L.e(((Throwable) (obj)));
            return 0;
        }
        i = ((flag) ? 1 : 0);
        if (j > 0)
        {
            i = ((flag) ? 1 : 0);
            if (j < 0x7fffffff)
            {
                i = j;
            }
        }
        return i;
    }

    public int getHeight()
    {
        int j = super.getHeight();
        int i = j;
        if (j <= 0)
        {
            ImageView imageview = (ImageView)viewRef.get();
            i = j;
            if (imageview != null)
            {
                i = getImageViewFieldValue(imageview, "mMaxHeight");
            }
        }
        return i;
    }

    public ViewScaleType getScaleType()
    {
        ImageView imageview = (ImageView)viewRef.get();
        if (imageview != null)
        {
            return ViewScaleType.fromImageView(imageview);
        } else
        {
            return super.getScaleType();
        }
    }

    public int getWidth()
    {
        int j = super.getWidth();
        int i = j;
        if (j <= 0)
        {
            ImageView imageview = (ImageView)viewRef.get();
            i = j;
            if (imageview != null)
            {
                i = getImageViewFieldValue(imageview, "mMaxWidth");
            }
        }
        return i;
    }

    public volatile View getWrappedView()
    {
        return getWrappedView();
    }

    public ImageView getWrappedView()
    {
        return (ImageView)super.getWrappedView();
    }

    protected void setImageBitmapInto(Bitmap bitmap, View view)
    {
        ((ImageView)view).setImageBitmap(bitmap);
    }

    protected void setImageDrawableInto(Drawable drawable, View view)
    {
        ((ImageView)view).setImageDrawable(drawable);
        if (drawable instanceof AnimationDrawable)
        {
            ((AnimationDrawable)drawable).start();
        }
    }
}
