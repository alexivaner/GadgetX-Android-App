// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.timelinedetail;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.inponsel.android.timelinedetail:
//            Hal1TLDetailActivity, TLKomenTab

class this._cls0
    implements android.view.al1TLDetailActivity._cls14
{

    final Hal1TLDetailActivity this$0;

    public void onClick(View view)
    {
        view = new Intent(Hal1TLDetailActivity.this, com/inponsel/android/timelinedetail/TLKomenTab);
        view.putExtra("id_artanya", id_artikel);
        view.putExtra("act", "komen");
        view.putExtra("tl_judul", tl_judul);
        view.putExtra("tl_content", tl_content);
        view.putExtra("tl_content_ext", tl_content_ext);
        view.putExtra("tl_codename", tl_codename);
        view.putExtra("tl_date", tl_date);
        view.putExtra("tl_id", tl_id);
        view.putExtra("tl_id_hp", tl_id_hp);
        view.putExtra("tl_id_user", tl_id_user);
        view.putExtra("tl_img_url", tl_img_url);
        view.putExtra("tl_tag", tl_tag);
        view.putExtra("tl_type", tl_type);
        view.putExtra("tl_username", tl_username);
        view.putExtra("tl_userphoto", tl_userphoto);
        view.putExtra("total_like", total_like);
        view.putExtra("fav_stat", fav_stat);
        view.putExtra("like_stat", like_stat);
        view.putExtra("namalengkap", namalengkap);
        startActivityForResult(view, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    A()
    {
        this$0 = Hal1TLDetailActivity.this;
        super();
    }
}
