// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.conversation;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.v2.RoomPostArtikel;

// Referenced classes of package com.inponsel.android.conversation:
//            ConversationDetailActivity

class this._cls0
    implements android.view.tionDetailActivity._cls5
{

    final ConversationDetailActivity this$0;

    public void onClick(View view)
    {
        view = new Intent(ConversationDetailActivity.this, com/inponsel/android/v2/RoomPostArtikel);
        view.putExtra("action", "edit");
        view.putExtra("namalengkap", namalengkap);
        view.putExtra("id_artanya", idkom_pos);
        view.putExtra("act", "first");
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
        view.putExtra("model", model);
        view.putExtra("merk", merk);
        Log.e("tl_judul", tl_judul);
        startActivityForResult(view, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
        finish();
    }

    ()
    {
        this$0 = ConversationDetailActivity.this;
        super();
    }
}
