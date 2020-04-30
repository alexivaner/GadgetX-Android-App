// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.tlforum;

import android.widget.ProgressBar;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.tlforum:
//            ForumHPActivity

class this._cls0
    implements com.android.volley.tivity._cls28
{

    final ForumHPActivity this$0;

    public volatile void onResponse(Object obj)
    {
        onResponse((JSONObject)obj);
    }

    public void onResponse(JSONObject jsonobject)
    {
        parseJSON(jsonobject.toString());
        ForumHPActivity.access$6(ForumHPActivity.this);
        ForumHPActivity.access$7(ForumHPActivity.this);
        Picasso.with(ForumHPActivity.this).load(str_img_cover).into(img_cover, new Callback() {

            final ForumHPActivity._cls28 this$1;

            public void onError()
            {
                progressbar_cover.setVisibility(8);
            }

            public void onSuccess()
            {
                progressbar_cover.setVisibility(8);
            }

            
            {
                this$1 = ForumHPActivity._cls28.this;
                super();
            }
        });
        Picasso.with(ForumHPActivity.this).load(gambar_hp).into(imgAvatar, new Callback() {

            final ForumHPActivity._cls28 this$1;

            public void onError()
            {
            }

            public void onSuccess()
            {
            }

            
            {
                this$1 = ForumHPActivity._cls28.this;
                super();
            }
        });
        ponselBaseApp.getObserver().setLoginStat("1");
    }


    _cls2.this._cls1()
    {
        this$0 = ForumHPActivity.this;
        super();
    }
}
