// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

// Referenced classes of package com.inponsel.android.v2:
//            SCUserActivity

class this._cls1
    implements ImageLoadingListener
{

    final this._cls1 this$1;

    public void onLoadingCancelled(String s, View view)
    {
    }

    public void onLoadingComplete(String s, View view, Bitmap bitmap)
    {
        cess._mth3(this._cls1.this).progressbar_item.setVisibility(8);
        cess._mth3(this._cls1.this).imgHp.setVisibility(0);
    }

    public void onLoadingFailed(String s, View view, FailReason failreason)
    {
        cess._mth3(this._cls1.this).progressbar_item.setVisibility(8);
        cess._mth3(this._cls1.this).imgHp.setVisibility(0);
    }

    public void onLoadingStarted(String s, View view)
    {
        cess._mth3(this._cls1.this).progressbar_item.setVisibility(0);
        cess._mth3(this._cls1.this).imgHp.setVisibility(8);
    }

    ason()
    {
        this$1 = this._cls1.this;
        super();
    }
}
