// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.widget.ImageView;
import com.squareup.picasso.Callback;

// Referenced classes of package com.inponsel.android.details:
//            SCTerdekatActivity

class ewHolder
    implements Callback
{

    final ewHolder.imageHp this$1;
    private final ewHolder val$holder;

    public void onError()
    {
    }

    public void onSuccess()
    {
        val$holder.imageHp.setVisibility(0);
    }

    ewHolder()
    {
        this$1 = final_ewholder;
        val$holder = ewHolder.this;
        super();
    }
}
