// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;

public class ImageViewRounded extends ImageView
{

    public ImageViewRounded(Context context)
    {
        super(context);
    }

    public ImageViewRounded(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public ImageViewRounded(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public Bitmap getRoundedCornerBitmap(Context context, Bitmap bitmap, int i, int j, int k, boolean flag, boolean flag1, 
            boolean flag2, boolean flag3)
    {
        Bitmap bitmap1 = Bitmap.createBitmap(j, k, android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap1);
        float f = context.getResources().getDisplayMetrics().density;
        context = new Paint();
        RectF rectf = new RectF(new Rect(0, 0, j, k));
        f = (float)i * f;
        context.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        context.setColor(0xff424242);
        canvas.drawRoundRect(rectf, f, f, context);
        if (flag)
        {
            canvas.drawRect(0.0F, 0.0F, j / 2, k / 2, context);
        }
        if (flag1)
        {
            canvas.drawRect(j / 2, 0.0F, j, k / 2, context);
        }
        if (flag2)
        {
            canvas.drawRect(0.0F, k / 2, j / 2, k, context);
        }
        if (flag3)
        {
            canvas.drawRect(j / 2, k / 2, j, k, context);
        }
        context.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, 0.0F, 0.0F, context);
        return bitmap1;
    }

    Bitmap getRoundedCornerBitmap(Bitmap bitmap)
    {
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap1);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectf = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(0xff0000ff);
        canvas.drawRoundRect(rectf, 12F, 12F, paint);
        paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return bitmap1;
    }

    protected void onDraw(Canvas canvas)
    {
        Object obj;
        for (obj = (BitmapDrawable)getDrawable(); obj == null || getWidth() == 0 || getHeight() == 0;)
        {
            return;
        }

        obj = ((BitmapDrawable) (obj)).getBitmap();
        int i = getMeasuredWidth();
        int j = getMeasuredHeight();
        if (i != ((Bitmap) (obj)).getWidth() || j != ((Bitmap) (obj)).getHeight())
        {
            obj = Bitmap.createScaledBitmap(((Bitmap) (obj)), i, j, true);
        }
        canvas.drawBitmap(getRoundedCornerBitmap(getContext(), ((Bitmap) (obj)), 10, i, j, false, false, false, false), 0.0F, 0.0F, null);
    }
}
