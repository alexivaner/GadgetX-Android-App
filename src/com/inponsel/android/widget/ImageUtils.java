// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.widget;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.inponsel.android.utils.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageUtils
{

    private static final String TAG = "ImageUtils";

    public ImageUtils()
    {
    }

    public static int getScreenHeight(Activity activity)
    {
        activity = activity.getWindowManager().getDefaultDisplay();
        if (android.os.Build.VERSION.SDK_INT >= 13)
        {
            Point point = new Point();
            activity.getSize(point);
            return point.y;
        } else
        {
            return activity.getHeight();
        }
    }

    public static int getScreenWidth(Activity activity)
    {
        activity = activity.getWindowManager().getDefaultDisplay();
        if (android.os.Build.VERSION.SDK_INT >= 13)
        {
            Point point = new Point();
            activity.getSize(point);
            return point.x;
        } else
        {
            return activity.getWidth();
        }
    }

    public static void storeImage(Bitmap bitmap, File file)
    {
        if (file == null)
        {
            Log.d("ImageUtils", "Error creating media file, check storage permissions: ");
            return;
        }
        try
        {
            file = new FileOutputStream(file);
            bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 90, file);
            file.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            Log.d("ImageUtils", (new StringBuilder("File not found: ")).append(bitmap.getMessage()).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            Log.d("ImageUtils", (new StringBuilder("Error accessing file: ")).append(bitmap.getMessage()).toString());
        }
    }
}
