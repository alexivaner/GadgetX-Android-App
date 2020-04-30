// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package eu.janmuller.android.simplecropimage;

import android.graphics.Bitmap;
import android.os.Handler;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package eu.janmuller.android.simplecropimage:
//            CropImage, CropImageView

class this._cls0
    implements Runnable
{

    final CropImage this$0;

    public void run()
    {
        final CountDownLatch latch = new CountDownLatch(1);
        final Bitmap b = CropImage.access$1(CropImage.this);
        CropImage.access$6(CropImage.this).post(new Runnable() {

            final CropImage._cls6 this$1;
            private final Bitmap val$b;
            private final CountDownLatch val$latch;

            public void run()
            {
                if (b != CropImage.access$1(this$0) && b != null)
                {
                    CropImage.access$0(this$0).setImageBitmapResetBase(b, true);
                    CropImage.access$1(this$0).recycle();
                    CropImage.access$8(this$0, b);
                }
                if (CropImage.access$0(this$0).getScale() == 1.0F)
                {
                    CropImage.access$0(this$0).center(true, true);
                }
                latch.countDown();
            }

            
            {
                this$1 = CropImage._cls6.this;
                b = bitmap;
                latch = countdownlatch;
                super();
            }
        });
        try
        {
            latch.await();
        }
        catch (InterruptedException interruptedexception)
        {
            throw new RuntimeException(interruptedexception);
        }
        mRunFaceDetection.run();
    }


    _cls1.val.latch()
    {
        this$0 = CropImage.this;
        super();
    }
}
