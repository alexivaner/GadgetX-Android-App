// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.pencariangen;

import android.widget.ImageView;
import android.widget.ProgressBar;
import com.inponsel.android.utils.Log;
import com.squareup.picasso.Callback;

// Referenced classes of package com.inponsel.android.pencariangen:
//            Hal4PencUser

class val.position
    implements Callback
{

    final val.position this$1;
    private final ewHolder val$holder;
    private final int val$position;

    public void onError()
    {
        val$holder.progressbar_item.setVisibility(8);
    }

    public void onSuccess()
    {
        val$holder.progressbar_item.setVisibility(8);
        val$holder.imageHp.setVisibility(0);
        Log.e("load", String.valueOf(val$position));
    }

    ewHolder()
    {
        this$1 = final_ewholder;
        val$holder = ewholder1;
        val$position = I.this;
        super();
    }
}
