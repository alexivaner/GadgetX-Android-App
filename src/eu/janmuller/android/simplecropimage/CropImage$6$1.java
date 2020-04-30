// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package eu.janmuller.android.simplecropimage;

import android.graphics.Bitmap;
import android.os.Handler;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package eu.janmuller.android.simplecropimage:
//            CropImage, CropImageView

class val.latch
    implements Runnable
{

    final val.latch this$1;
    private final Bitmap val$b;
    private final CountDownLatch val$latch;

    public void run()
    {
        if (val$b != CropImage.access$1(_fld0) && val$b != null)
        {
            CropImage.access$0(_fld0).setImageBitmapResetBase(val$b, true);
            CropImage.access$1(_fld0).recycle();
            CropImage.access$8(_fld0, val$b);
        }
        if (CropImage.access$0(_fld0).getScale() == 1.0F)
        {
            CropImage.access$0(_fld0).center(true, true);
        }
        val$latch.countDown();
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$b = bitmap;
        val$latch = CountDownLatch.this;
        super();
    }

    // Unreferenced inner class eu/janmuller/android/simplecropimage/CropImage$6

/* anonymous class */
    class CropImage._cls6
        implements Runnable
    {

        final CropImage this$0;

        public void run()
        {
            CountDownLatch countdownlatch = new CountDownLatch(1);
            final Bitmap b = CropImage.access$1(CropImage.this);
            CropImage.access$6(CropImage.this).post(countdownlatch. new CropImage._cls6._cls1());
            try
            {
                countdownlatch.await();
            }
            catch (InterruptedException interruptedexception)
            {
                throw new RuntimeException(interruptedexception);
            }
            mRunFaceDetection.run();
        }


            
            {
                this$0 = CropImage.this;
                super();
            }
    }

}
