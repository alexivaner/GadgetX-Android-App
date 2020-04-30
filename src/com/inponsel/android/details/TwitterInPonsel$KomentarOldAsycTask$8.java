// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.inponsel.android.details:
//            TwitterInPonsel, KomentarTwitter

class val.screen_name
    implements android.view.arOldAsycTask._cls8
{

    final this._cls1 this$1;
    private final String val$avatar;
    private final String val$media_url;
    private final String val$screen_name;
    private final String val$since_id;
    private final String val$tweet_content;
    private final String val$tweet_time;

    public void onClick(View view)
    {
        cess._mth2(this._cls1.this).idkom_pos = val$since_id;
        view = new Intent(cess._mth2(this._cls1.this), com/inponsel/android/details/KomentarTwitter);
        view.putExtra("tw_name", cess._mth2(this._cls1.this).twitter);
        view.putExtra("id_tw", cess._mth2(this._cls1.this).idkom_pos);
        view.putExtra("tweet_content", val$tweet_content);
        view.putExtra("media_url", val$media_url);
        view.putExtra("avatar", val$avatar);
        view.putExtra("tweet_time", val$tweet_time);
        view.putExtra("screen_name", val$screen_name);
        cess._mth2(this._cls1.this).startActivity(view);
    }

    ()
    {
        this$1 = final_;
        val$since_id = s;
        val$tweet_content = s1;
        val$media_url = s2;
        val$avatar = s3;
        val$tweet_time = s4;
        val$screen_name = String.this;
        super();
    }
}
