// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;

import android.widget.ImageView;
import com.squareup.picasso.Callback;

// Referenced classes of package com.inponsel.android.adapter:
//            ListKategoriApps3Adapter

class ewHolder
    implements Callback
{

    final ListKategoriApps3Adapter this$0;
    private final ewHolder val$holder;

    public void onError()
    {
    }

    public void onSuccess()
    {
        val$holder.img_kat_apps_1.setVisibility(0);
    }

    ewHolder()
    {
        this$0 = final_listkategoriapps3adapter;
        val$holder = ewHolder.this;
        super();
    }
}
