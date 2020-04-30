// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package eu.janmuller.android.simplecropimage;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Handler;
import android.view.Display;
import android.view.WindowManager;
import java.io.Closeable;

// Referenced classes of package eu.janmuller.android.simplecropimage:
//            MonitoredActivity

public class Util
{
    private static class BackgroundJob extends MonitoredActivity.LifeCycleAdapter
        implements Runnable
    {

        private final MonitoredActivity mActivity;
        private final Runnable mCleanupRunner = new _cls1();
        private final ProgressDialog mDialog;
        private final Handler mHandler;
        private final Runnable mJob;

        public void onActivityDestroyed(MonitoredActivity monitoredactivity)
        {
            mCleanupRunner.run();
            mHandler.removeCallbacks(mCleanupRunner);
        }

        public void onActivityStarted(MonitoredActivity monitoredactivity)
        {
            mDialog.show();
        }

        public void onActivityStopped(MonitoredActivity monitoredactivity)
        {
            mDialog.hide();
        }

        public void run()
        {
            mJob.run();
            mHandler.post(mCleanupRunner);
            return;
            Exception exception;
            exception;
            mHandler.post(mCleanupRunner);
            throw exception;
        }



        public BackgroundJob(MonitoredActivity monitoredactivity, Runnable runnable, ProgressDialog progressdialog, Handler handler)
        {
            mActivity = monitoredactivity;
            mDialog = progressdialog;
            mJob = runnable;
            mActivity.addLifeCycleListener(this);
            mHandler = handler;
        }
    }


    private static final String TAG = "db.Util";

    private Util()
    {
    }

    public static void closeSilently(Closeable closeable)
    {
        if (closeable == null)
        {
            return;
        }
        try
        {
            closeable.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Closeable closeable)
        {
            return;
        }
    }

    public static android.graphics.BitmapFactory.Options createNativeAllocOptions()
    {
        return new android.graphics.BitmapFactory.Options();
    }

    public static int getOrientationInDegree(Activity activity)
    {
        switch (activity.getWindowManager().getDefaultDisplay().getRotation())
        {
        default:
            return 0;

        case 0: // '\0'
            return 0;

        case 1: // '\001'
            return 90;

        case 2: // '\002'
            return 180;

        case 3: // '\003'
            return 270;
        }
    }

    public static Bitmap rotateImage(Bitmap bitmap, float f)
    {
        Matrix matrix = new Matrix();
        matrix.postRotate(f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static void startBackgroundJob(MonitoredActivity monitoredactivity, String s, String s1, Runnable runnable, Handler handler)
    {
        (new Thread(new BackgroundJob(monitoredactivity, runnable, ProgressDialog.show(monitoredactivity, s, s1, true, false), handler))).start();
    }

    public static Bitmap transform(Matrix matrix, Bitmap bitmap, int i, int j, boolean flag)
    {
        int i1 = bitmap.getWidth() - i;
        int k = bitmap.getHeight() - j;
        if (!flag && (i1 < 0 || k < 0))
        {
            matrix = Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(matrix);
            i1 = Math.max(0, i1 / 2);
            k = Math.max(0, k / 2);
            Rect rect = new Rect(i1, k, Math.min(i, bitmap.getWidth()) + i1, Math.min(j, bitmap.getHeight()) + k);
            k = (i - rect.width()) / 2;
            i1 = (j - rect.height()) / 2;
            canvas.drawBitmap(bitmap, rect, new Rect(k, i1, i - k, j - i1), null);
        } else
        {
            float f = bitmap.getWidth();
            float f1 = bitmap.getHeight();
            Bitmap bitmap1;
            if (f / f1 > (float)i / (float)j)
            {
                f = (float)j / f1;
                Bitmap bitmap2;
                int l;
                int j1;
                if (f < 0.9F || f > 1.0F)
                {
                    matrix.setScale(f, f);
                } else
                {
                    matrix = null;
                }
            } else
            {
                f = (float)i / f;
                if (f < 0.9F || f > 1.0F)
                {
                    matrix.setScale(f, f);
                } else
                {
                    matrix = null;
                }
            }
            if (matrix != null)
            {
                bitmap1 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } else
            {
                bitmap1 = bitmap;
            }
            l = Math.max(0, bitmap1.getWidth() - i);
            j1 = Math.max(0, bitmap1.getHeight() - j);
            bitmap2 = Bitmap.createBitmap(bitmap1, l / 2, j1 / 2, i, j);
            matrix = bitmap2;
            if (bitmap1 != bitmap)
            {
                bitmap1.recycle();
                return bitmap2;
            }
        }
        return matrix;
    }

    // Unreferenced inner class eu/janmuller/android/simplecropimage/Util$BackgroundJob$1

/* anonymous class */
    class BackgroundJob._cls1
        implements Runnable
    {

        final BackgroundJob this$1;

        public void run()
        {
            mActivity.removeLifeCycleListener(BackgroundJob.this);
            if (mDialog.getWindow() != null)
            {
                mDialog.dismiss();
            }
        }

            
            {
                this$1 = BackgroundJob.this;
                super();
            }
    }

}
