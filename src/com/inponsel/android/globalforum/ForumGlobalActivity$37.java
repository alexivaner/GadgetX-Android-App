// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.globalforum;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.timelinedetail.TLKomenTab;

// Referenced classes of package com.inponsel.android.globalforum:
//            ForumGlobalActivity

class val.like_stat
    implements android.view.umGlobalActivity._cls37
{

    final ForumGlobalActivity this$0;
    private final String val$fav_stat;
    private final String val$like_stat;
    private final String val$tl_codename;
    private final String val$tl_content;
    private final String val$tl_content_ext;
    private final String val$tl_date;
    private final String val$tl_id;
    private final String val$tl_id_hp;
    private final String val$tl_id_user;
    private final String val$tl_img_url;
    private final String val$tl_judul;
    private final String val$tl_tag;
    private final String val$tl_type;
    private final String val$tl_username;
    private final String val$tl_userphoto;
    private final String val$total_like;

    public void onClick(View view)
    {
        idkom_pos = val$tl_id;
        view = new Intent(ForumGlobalActivity.this, com/inponsel/android/timelinedetail/TLKomenTab);
        view.putExtra("id_artanya", idkom_pos);
        view.putExtra("act", "komen");
        view.putExtra("tl_judul", val$tl_judul);
        view.putExtra("tl_content", val$tl_content);
        view.putExtra("tl_content_ext", val$tl_content_ext);
        view.putExtra("tl_codename", val$tl_codename);
        view.putExtra("tl_date", val$tl_date);
        view.putExtra("tl_id", val$tl_id);
        view.putExtra("tl_id_hp", val$tl_id_hp);
        view.putExtra("tl_id_user", val$tl_id_user);
        view.putExtra("tl_img_url", val$tl_img_url);
        view.putExtra("tl_tag", val$tl_tag);
        view.putExtra("tl_type", val$tl_type);
        view.putExtra("tl_username", val$tl_username);
        view.putExtra("tl_userphoto", val$tl_userphoto);
        view.putExtra("total_like", val$total_like);
        view.putExtra("fav_stat", val$fav_stat);
        view.putExtra("like_stat", val$like_stat);
        view.putExtra("namalengkap", namalengkap);
        startActivityForResult(view, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ()
    {
        this$0 = final_forumglobalactivity;
        val$tl_id = s;
        val$tl_judul = s1;
        val$tl_content = s2;
        val$tl_content_ext = s3;
        val$tl_codename = s4;
        val$tl_date = s5;
        val$tl_id_hp = s6;
        val$tl_id_user = s7;
        val$tl_img_url = s8;
        val$tl_tag = s9;
        val$tl_type = s10;
        val$tl_username = s11;
        val$tl_userphoto = s12;
        val$total_like = s13;
        val$fav_stat = s14;
        val$like_stat = String.this;
        super();
    }
}
