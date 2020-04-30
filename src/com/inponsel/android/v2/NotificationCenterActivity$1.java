// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.conversation.ConversationDetailActivity;
import com.inponsel.android.details.KomentarTwitter;
import com.inponsel.android.rssfeeddetail.RSSDetailTab;
import com.inponsel.android.scdetail.SCDetailPager;
import com.inponsel.android.timelinedetail.Hal1TLDetailActivity;

// Referenced classes of package com.inponsel.android.v2:
//            NotificationCenterActivity, KomentarPonsel

class this._cls0
    implements android.widget.er
{

    final NotificationCenterActivity this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = selengkapAdapter.getListModel(i).getActv_type();
        view = selengkapAdapter.getListModel(i).getActv_content_type_id();
        if (!adapterview.equals("like")) goto _L2; else goto _L1
_L1:
        if (!view.equals("6")) goto _L4; else goto _L3
_L3:
        adapterview = new Intent();
        if (selengkapAdapter.getListModel(i).getType().toLowerCase().equals("conversation"))
        {
            adapterview.setClass(getApplicationContext(), com/inponsel/android/conversation/ConversationDetailActivity);
        } else
        {
            adapterview.setClass(getApplicationContext(), com/inponsel/android/timelinedetail/Hal1TLDetailActivity);
        }
        adapterview.putExtra("tl_id", selengkapAdapter.getListModel(i).getId_hp());
        adapterview.putExtra("act", "gcm");
        adapterview.putExtra("tl_judul", selengkapAdapter.getListModel(i).getMerk());
        adapterview.putExtra("namalengkap", selengkapAdapter.getListModel(i).getCodename());
        startActivityForResult(adapterview, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
_L6:
        return;
_L4:
        if (view.equals("1"))
        {
            adapterview = new Intent(getApplicationContext(), com/inponsel/android/v2/KomentarPonsel);
            adapterview.putExtra("id_hph", selengkapAdapter.getListModel(i).getId_hp());
            adapterview.putExtra("namalengkap", (new StringBuilder(String.valueOf(selengkapAdapter.getListModel(i).getMerk()))).append(" ").append(selengkapAdapter.getListModel(i).getModel()).toString());
            adapterview.putExtra("codename", selengkapAdapter.getListModel(i).getCodename());
            adapterview.putExtra("model", selengkapAdapter.getListModel(i).getModel());
            adapterview.putExtra("merk", selengkapAdapter.getListModel(i).getMerk());
            adapterview.putExtra("gambar", "");
            adapterview.putExtra("hrg_baru", "");
            adapterview.putExtra("hrg_bekas", "");
            adapterview.putExtra("tot_like", "");
            adapterview.putExtra("tot_dislike", "");
            adapterview.putExtra("tot_komen", "");
            adapterview.putExtra("actfrom", "komen");
            startActivityForResult(adapterview, 0);
            overridePendingTransition(0x7f040003, 0x7f040004);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (!adapterview.equals("reply"))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (view.equals("1"))
        {
            adapterview = new Intent(getApplicationContext(), com/inponsel/android/v2/KomentarPonsel);
            adapterview.putExtra("id_hph", selengkapAdapter.getListModel(i).getId_hp());
            adapterview.putExtra("namalengkap", (new StringBuilder(String.valueOf(selengkapAdapter.getListModel(i).getMerk()))).append(" ").append(selengkapAdapter.getListModel(i).getModel()).toString());
            adapterview.putExtra("codename", selengkapAdapter.getListModel(i).getCodename());
            adapterview.putExtra("model", selengkapAdapter.getListModel(i).getModel());
            adapterview.putExtra("merk", selengkapAdapter.getListModel(i).getMerk());
            adapterview.putExtra("gambar", "");
            adapterview.putExtra("hrg_baru", "");
            adapterview.putExtra("hrg_bekas", "");
            adapterview.putExtra("tot_like", "");
            adapterview.putExtra("tot_dislike", "");
            adapterview.putExtra("tot_komen", "");
            adapterview.putExtra("actfrom", "komen");
            startActivityForResult(adapterview, 0);
            overridePendingTransition(0x7f040003, 0x7f040004);
            return;
        }
        if (view.equals("2"))
        {
            adapterview = new Intent();
            adapterview.setClass(getApplicationContext(), com/inponsel/android/rssfeeddetail/RSSDetailTab);
            adapterview.putExtra("id_rss", selengkapAdapter.getListModel(i).getId_hp());
            adapterview.putExtra("rss_title", selengkapAdapter.getListModel(i).getMerk());
            adapterview.putExtra("notif", "gcm");
            adapterview.putExtra("actfrom", "rssfeed");
            adapterview.putExtra("act", "firsttab");
            startActivityForResult(adapterview, 0);
            overridePendingTransition(0x7f040003, 0x7f040004);
            return;
        }
        if (view.equals("3"))
        {
            adapterview = new Intent(getApplicationContext(), com/inponsel/android/scdetail/SCDetailPager);
            adapterview.putExtra("sc_id", selengkapAdapter.getListModel(i).getId_sc());
            adapterview.putExtra("sc_logo", selengkapAdapter.getListModel(i).getSc_logo());
            adapterview.putExtra("sc_c_center", selengkapAdapter.getListModel(i).getSc_c_center());
            adapterview.putExtra("sc_ven_center", selengkapAdapter.getListModel(i).getSc_ven_center());
            adapterview.putExtra("sc_nama", selengkapAdapter.getListModel(i).getSc_nama());
            adapterview.putExtra("sc_merk", selengkapAdapter.getListModel(i).getSc_merk());
            adapterview.putExtra("sc_fb", selengkapAdapter.getListModel(i).getSc_fb());
            adapterview.putExtra("sc_ytube", selengkapAdapter.getListModel(i).getSc_ytube());
            adapterview.putExtra("sc_fb_id", selengkapAdapter.getListModel(i).getSc_fb_id());
            adapterview.putExtra("sc_tw", selengkapAdapter.getListModel(i).getSc_tw());
            adapterview.putExtra("sc_alamat", selengkapAdapter.getListModel(i).getSc_alamat());
            adapterview.putExtra("sc_no_telp", selengkapAdapter.getListModel(i).getSc_no_telp());
            adapterview.putExtra("sc_no_telp_ket", selengkapAdapter.getListModel(i).getSc_no_telp_ket());
            adapterview.putExtra("sc_email", selengkapAdapter.getListModel(i).getSc_email());
            adapterview.putExtra("sc_web", selengkapAdapter.getListModel(i).getSc_web_url());
            adapterview.putExtra("sc_rateAvg", selengkapAdapter.getListModel(i).getSc_rate());
            adapterview.putExtra("sc_rate1", selengkapAdapter.getListModel(i).getSc_rate1());
            adapterview.putExtra("sc_rate2", selengkapAdapter.getListModel(i).getSc_rate2());
            adapterview.putExtra("sc_rate3", selengkapAdapter.getListModel(i).getSc_rate3());
            adapterview.putExtra("sc_rate4", selengkapAdapter.getListModel(i).getSc_rate4());
            adapterview.putExtra("sc_rate5", selengkapAdapter.getListModel(i).getSc_rate5());
            adapterview.putExtra("sc_total_rate", selengkapAdapter.getListModel(i).getSc_total_rate());
            startActivityForResult(adapterview, 0);
            overridePendingTransition(0x7f040003, 0x7f040004);
            return;
        }
        if (view.equals("4"))
        {
            adapterview = new Intent(NotificationCenterActivity.this, com/inponsel/android/details/KomentarTwitter);
            adapterview.putExtra("tw_name", selengkapAdapter.getListModel(i).getScreen_nametw());
            adapterview.putExtra("id_tw", selengkapAdapter.getListModel(i).getId_hp());
            adapterview.putExtra("tweet_content", selengkapAdapter.getListModel(i).getTweet_content());
            adapterview.putExtra("media_url", selengkapAdapter.getListModel(i).getMedia_urltw());
            adapterview.putExtra("avatar", selengkapAdapter.getListModel(i).getAvatartw());
            adapterview.putExtra("tweet_time", selengkapAdapter.getListModel(i).getTweet_time());
            adapterview.putExtra("screen_name", selengkapAdapter.getListModel(i).getReal_nametw());
            startActivityForResult(adapterview, 0);
            overridePendingTransition(0x7f040003, 0x7f040004);
            return;
        }
        if (view.equals("5"))
        {
            adapterview = new Intent();
            if (selengkapAdapter.getListModel(i).getType().toLowerCase().equals("conversation"))
            {
                adapterview.setClass(getApplicationContext(), com/inponsel/android/conversation/ConversationDetailActivity);
            } else
            {
                adapterview.setClass(getApplicationContext(), com/inponsel/android/timelinedetail/Hal1TLDetailActivity);
            }
            adapterview.putExtra("tl_id", selengkapAdapter.getListModel(i).getId_hp());
            adapterview.putExtra("act", "gcm");
            adapterview.putExtra("tl_judul", selengkapAdapter.getListModel(i).getMerk());
            adapterview.putExtra("namalengkap", selengkapAdapter.getListModel(i).getCodename());
            startActivityForResult(adapterview, 0);
            overridePendingTransition(0x7f040003, 0x7f040004);
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (!adapterview.equals("comment")) goto _L6; else goto _L5
_L5:
        if (view.equals("1"))
        {
            adapterview = new Intent(getApplicationContext(), com/inponsel/android/v2/KomentarPonsel);
            adapterview.putExtra("id_hph", selengkapAdapter.getListModel(i).getId_hp());
            adapterview.putExtra("namalengkap", (new StringBuilder(String.valueOf(selengkapAdapter.getListModel(i).getMerk()))).append(" ").append(selengkapAdapter.getListModel(i).getModel()).toString());
            adapterview.putExtra("codename", selengkapAdapter.getListModel(i).getCodename());
            adapterview.putExtra("model", selengkapAdapter.getListModel(i).getModel());
            adapterview.putExtra("merk", selengkapAdapter.getListModel(i).getMerk());
            adapterview.putExtra("gambar", "");
            adapterview.putExtra("hrg_baru", "");
            adapterview.putExtra("hrg_bekas", "");
            adapterview.putExtra("tot_like", "");
            adapterview.putExtra("tot_dislike", "");
            adapterview.putExtra("tot_komen", "");
            adapterview.putExtra("actfrom", "komen");
            startActivityForResult(adapterview, 0);
            overridePendingTransition(0x7f040003, 0x7f040004);
            return;
        }
        if (view.equals("2"))
        {
            adapterview = new Intent();
            adapterview.setClass(getApplicationContext(), com/inponsel/android/rssfeeddetail/RSSDetailTab);
            adapterview.putExtra("id_rss", selengkapAdapter.getListModel(i).getId_hp());
            adapterview.putExtra("rss_title", selengkapAdapter.getListModel(i).getMerk());
            adapterview.putExtra("notif", "gcm");
            adapterview.putExtra("actfrom", "rssfeed");
            adapterview.putExtra("act", "firsttab");
            startActivityForResult(adapterview, 0);
            overridePendingTransition(0x7f040003, 0x7f040004);
            return;
        }
        if (view.equals("3"))
        {
            adapterview = new Intent(getApplicationContext(), com/inponsel/android/scdetail/SCDetailPager);
            adapterview.putExtra("sc_id", selengkapAdapter.getListModel(i).getId_sc());
            adapterview.putExtra("sc_logo", selengkapAdapter.getListModel(i).getSc_logo());
            adapterview.putExtra("sc_c_center", selengkapAdapter.getListModel(i).getSc_c_center());
            adapterview.putExtra("sc_ven_center", selengkapAdapter.getListModel(i).getSc_ven_center());
            adapterview.putExtra("sc_nama", selengkapAdapter.getListModel(i).getSc_nama());
            adapterview.putExtra("sc_merk", selengkapAdapter.getListModel(i).getSc_merk());
            adapterview.putExtra("sc_fb", selengkapAdapter.getListModel(i).getSc_fb());
            adapterview.putExtra("sc_ytube", selengkapAdapter.getListModel(i).getSc_ytube());
            adapterview.putExtra("sc_fb_id", selengkapAdapter.getListModel(i).getSc_fb_id());
            adapterview.putExtra("sc_tw", selengkapAdapter.getListModel(i).getSc_tw());
            adapterview.putExtra("sc_alamat", selengkapAdapter.getListModel(i).getSc_alamat());
            adapterview.putExtra("sc_no_telp", selengkapAdapter.getListModel(i).getSc_no_telp());
            adapterview.putExtra("sc_no_telp_ket", selengkapAdapter.getListModel(i).getSc_no_telp_ket());
            adapterview.putExtra("sc_email", selengkapAdapter.getListModel(i).getSc_email());
            adapterview.putExtra("sc_web", selengkapAdapter.getListModel(i).getSc_web_url());
            adapterview.putExtra("sc_rateAvg", selengkapAdapter.getListModel(i).getSc_rate());
            adapterview.putExtra("sc_rate1", selengkapAdapter.getListModel(i).getSc_rate1());
            adapterview.putExtra("sc_rate2", selengkapAdapter.getListModel(i).getSc_rate2());
            adapterview.putExtra("sc_rate3", selengkapAdapter.getListModel(i).getSc_rate3());
            adapterview.putExtra("sc_rate4", selengkapAdapter.getListModel(i).getSc_rate4());
            adapterview.putExtra("sc_rate5", selengkapAdapter.getListModel(i).getSc_rate5());
            adapterview.putExtra("sc_total_rate", selengkapAdapter.getListModel(i).getSc_total_rate());
            startActivityForResult(adapterview, 0);
            overridePendingTransition(0x7f040003, 0x7f040004);
            return;
        }
        if (view.equals("4"))
        {
            adapterview = new Intent(NotificationCenterActivity.this, com/inponsel/android/details/KomentarTwitter);
            adapterview.putExtra("tw_name", selengkapAdapter.getListModel(i).getScreen_nametw());
            adapterview.putExtra("id_tw", selengkapAdapter.getListModel(i).getId_hp());
            adapterview.putExtra("tweet_content", selengkapAdapter.getListModel(i).getTweet_content());
            adapterview.putExtra("media_url", selengkapAdapter.getListModel(i).getMedia_urltw());
            adapterview.putExtra("avatar", selengkapAdapter.getListModel(i).getAvatartw());
            adapterview.putExtra("tweet_time", selengkapAdapter.getListModel(i).getTweet_time());
            adapterview.putExtra("screen_name", selengkapAdapter.getListModel(i).getReal_nametw());
            startActivityForResult(adapterview, 0);
            overridePendingTransition(0x7f040003, 0x7f040004);
            return;
        }
        if (view.equals("5"))
        {
            adapterview = new Intent();
            if (selengkapAdapter.getListModel(i).getType().toLowerCase().equals("conversation"))
            {
                adapterview.setClass(getApplicationContext(), com/inponsel/android/conversation/ConversationDetailActivity);
            } else
            {
                adapterview.setClass(getApplicationContext(), com/inponsel/android/timelinedetail/Hal1TLDetailActivity);
            }
            adapterview.putExtra("tl_id", selengkapAdapter.getListModel(i).getId_hp());
            adapterview.putExtra("act", "gcm");
            adapterview.putExtra("tl_judul", selengkapAdapter.getListModel(i).getMerk());
            adapterview.putExtra("namalengkap", selengkapAdapter.getListModel(i).getCodename());
            startActivityForResult(adapterview, 0);
            overridePendingTransition(0x7f040003, 0x7f040004);
            return;
        }
        if (true) goto _L6; else goto _L7
_L7:
    }

    ity()
    {
        this$0 = NotificationCenterActivity.this;
        super();
    }
}
