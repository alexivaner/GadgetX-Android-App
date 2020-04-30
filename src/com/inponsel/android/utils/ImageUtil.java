// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

// Referenced classes of package com.inponsel.android.utils:
//            ErrorUtil

public class ImageUtil
{

    public ImageUtil()
    {
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, float f, int i, int j, boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        Bitmap bitmap1 = Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap1);
        Paint paint = new Paint();
        RectF rectf = new RectF(new Rect(0, 0, i, j));
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(0xff424242);
        canvas.drawRoundRect(rectf, f, f, paint);
        if (flag)
        {
            canvas.drawRect(0.0F, 0.0F, i / 2, j / 2, paint);
        }
        if (flag1)
        {
            canvas.drawRect(i / 2, 0.0F, i, j / 2, paint);
        }
        if (flag2)
        {
            canvas.drawRect(0.0F, j / 2, i / 2, j, paint);
        }
        if (flag3)
        {
            canvas.drawRect(i / 2, j / 2, i, j, paint);
        }
        paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, 0.0F, 0.0F, paint);
        return bitmap1;
    }

    public static Bitmap loadBitmapFromAsset(Context context, String s)
        throws IOException
    {
        return BitmapFactory.decodeStream(context.getAssets().open(s));
    }

    public static Bitmap loadBitmapFromAssetNoThrow(Context context, String s)
    {
        try
        {
            context = loadBitmapFromAsset(context, s);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw ErrorUtil.runtimeException(context);
        }
        return context;
    }

    public static Bitmap loadBitmapFromInternet(String s)
        throws IOException
    {
        return BitmapFactory.decodeStream((new URL(s)).openConnection().getInputStream());
    }

    public static Bitmap loadBitmapFromInternet(String s, Bitmap bitmap)
    {
        try
        {
            s = loadBitmapFromInternet(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return bitmap;
        }
        return s;
    }

    public static Bitmap loadBitmapFromResource(Resources resources, int i)
    {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inScaled = false;
        resources = BitmapFactory.decodeResource(resources, i, options);
        resources.setDensity(0);
        return resources;
    }

    public static Bitmap scaleImage(Bitmap bitmap, float f)
    {
        Bitmap bitmap1 = bitmap;
        if (f != 1.0F)
        {
            bitmap1 = Bitmap.createScaledBitmap(bitmap, (int)((float)bitmap.getWidth() * f), (int)((float)bitmap.getHeight() * f), true);
        }
        return bitmap1;
    }

    public static Bitmap scaleToFitFrame(Bitmap bitmap, int i, int j)
    {
        return scaleImage(bitmap, sizeFitRatio(bitmap.getWidth(), bitmap.getHeight(), i, j));
    }

    public static float sizeFitRatio(int i, int j, int k, int l)
    {
        float f2 = 1.0F;
        float f1 = f2;
        if (i != 0)
        {
            f1 = f2;
            if (j != 0)
            {
                float f = (float)k / (float)i;
                f1 = (float)l / (float)j;
                if (f >= f1)
                {
                    f = f1;
                }
                f1 = f2;
                if (f > 0.0F)
                {
                    f1 = f;
                }
            }
        }
        return f1;
    }
}
