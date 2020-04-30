// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.graphics.Bitmap;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;

// Referenced classes of package com.inponsel.android.v2:
//            ImageFullActivity

class val.imageView
    implements ImageLoadingListener
{

    final val.spinner this$1;
    private final ImageViewTouch val$imageView;
    private final ProgressBar val$spinner;

    public void onLoadingCancelled(String s, View view)
    {
    }

    public void onLoadingComplete(String s, View view, Bitmap bitmap)
    {
        val$spinner.setVisibility(8);
        s = AnimationUtils.loadAnimation(cess._mth0(this._cls1.this), 0x7f040009);
        val$imageView.setAnimation(s);
        s.start();
    }

    public void onLoadingFailed(String s, View view, FailReason failreason)
    {
        Toast.makeText(cess._mth0(this._cls1.this), "Gagal memuat gambar", 0).show();
        val$spinner.setVisibility(8);
        val$imageView.setImageResource(0x108001d);
    }

    public void onLoadingStarted(String s, View view)
    {
        val$spinner.setVisibility(0);
    }

    stener()
    {
        this$1 = final_stener;
        val$spinner = progressbar;
        val$imageView = ImageViewTouch.this;
        super();
    }
}
