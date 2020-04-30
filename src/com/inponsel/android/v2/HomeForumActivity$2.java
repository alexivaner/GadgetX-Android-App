// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.Dialog;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.tlforum.ForumHPActivity;
import com.inponsel.android.utils.ExpandedGridView;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.widget.ExpandableHeightGridView;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.v2:
//            HomeForumActivity

class this._cls0
    implements android.view.
{

    final HomeForumActivity this$0;

    public void onClick(View view)
    {
        view = getLayoutInflater().inflate(0x7f0300ad, null);
        android.app.mClickListener mclicklistener = new android.app.<init>(wrapper);
        mclicklistener.setView(view);
        ((LinearLayout)view.findViewById(0x7f0b05bc)).setVisibility(8);
        view.findViewById(0x7f0b03d3).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeForumActivity._cls2 this$1;

            public void onClick(View view1)
            {
                dialog.dismiss();
                tag_timeline = "terbaru";
                TimelineTask();
            }

            
            {
                this$1 = HomeForumActivity._cls2.this;
                super();
            }
        });
        view.findViewById(0x7f0b03d4).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeForumActivity._cls2 this$1;

            public void onClick(View view1)
            {
                dialog.dismiss();
                tag_timeline = "terpopuler";
                TimelineTask();
            }

            
            {
                this$1 = HomeForumActivity._cls2.this;
                super();
            }
        });
        view.findViewById(0x7f0b03d5).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeForumActivity._cls2 this$1;

            public void onClick(View view1)
            {
                dialog.dismiss();
                tag_timeline = "terkomentari";
                TimelineTask();
            }

            
            {
                this$1 = HomeForumActivity._cls2.this;
                super();
            }
        });
        view.findViewById(0x7f0b05bd).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeForumActivity._cls2 this$1;

            public void onClick(View view1)
            {
                dialog.dismiss();
                tag_timeline = "android";
                TimelineTask();
            }

            
            {
                this$1 = HomeForumActivity._cls2.this;
                super();
            }
        });
        view.findViewById(0x7f0b05c0).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeForumActivity._cls2 this$1;

            public void onClick(View view1)
            {
                dialog.dismiss();
                tag_timeline = "blackberry";
                TimelineTask();
            }

            
            {
                this$1 = HomeForumActivity._cls2.this;
                super();
            }
        });
        view.findViewById(0x7f0b05c3).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeForumActivity._cls2 this$1;

            public void onClick(View view1)
            {
                dialog.dismiss();
                tag_timeline = "ios";
                TimelineTask();
            }

            
            {
                this$1 = HomeForumActivity._cls2.this;
                super();
            }
        });
        view.findViewById(0x7f0b05c6).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeForumActivity._cls2 this$1;

            public void onClick(View view1)
            {
                dialog.dismiss();
                tag_timeline = "windowsphone";
                TimelineTask();
            }

            
            {
                this$1 = HomeForumActivity._cls2.this;
                super();
            }
        });
        view.findViewById(0x7f0b05c9).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeForumActivity._cls2 this$1;

            public void onClick(View view1)
            {
                dialog.dismiss();
                tag_timeline = "tipsumum";
                TimelineTask();
            }

            
            {
                this$1 = HomeForumActivity._cls2.this;
                super();
            }
        });
        view.findViewById(0x7f0b05d5).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeForumActivity._cls2 this$1;

            public void onClick(View view1)
            {
                dialog.dismiss();
                tag_timeline = "opini";
                TimelineTask();
            }

            
            {
                this$1 = HomeForumActivity._cls2.this;
                super();
            }
        });
        view.findViewById(0x7f0b05cc).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeForumActivity._cls2 this$1;

            public void onClick(View view1)
            {
                dialog.dismiss();
                tag_timeline = "tanya";
                TimelineTask();
            }

            
            {
                this$1 = HomeForumActivity._cls2.this;
                super();
            }
        });
        view.findViewById(0x7f0b05cf).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeForumActivity._cls2 this$1;

            public void onClick(View view1)
            {
                img_empty.setVisibility(8);
                pop_txt_empty.setVisibility(8);
                dialog.dismiss();
                tag_timeline = "hasilkamera";
                ll_forumlist.setVisibility(8);
                grid_benchmark.setVisibility(8);
                ll_forumlistbenchmark.setVisibility(8);
                HomeForumActivity.access$1(this$0, "now");
            }

            
            {
                this$1 = HomeForumActivity._cls2.this;
                super();
            }
        });
        listHpForum = (ExpandableHeightGridView)view.findViewById(0x7f0b05dc);
        progbar_roomhp = (ProgressBar)view.findViewById(0x7f0b05db);
        ponselMerekArray = new ArrayList();
        ponselOsAdapter = new stPendatangAdapter(HomeForumActivity.this, HomeForumActivity.this, 0x7f030119, ponselMerekArray);
        listHpForum.setAdapter(ponselOsAdapter);
        listHpForum.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final HomeForumActivity._cls2 this$1;

            public void onItemClick(AdapterView adapterview, View view1, int i, long l)
            {
                adapterview = ponselOsAdapter.getListModel(i).getId_hp();
                view1 = ponselOsAdapter.getListModel(i).getMerk();
                String s = ponselOsAdapter.getListModel(i).getModel();
                String s1 = ponselOsAdapter.getListModel(i).getCodename();
                String s2 = ponselOsAdapter.getListModel(i).getGambar();
                Intent intent = new Intent(this$0, com/inponsel/android/tlforum/ForumHPActivity);
                intent.putExtra("id_hph", adapterview);
                intent.putExtra("namalengkap", (new StringBuilder(String.valueOf(view1))).append(" ").append(s).toString());
                intent.putExtra("codename", s1);
                intent.putExtra("model", s);
                intent.putExtra("merk", view1);
                intent.putExtra("gambar", s2);
                startActivityForResult(intent, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$1 = HomeForumActivity._cls2.this;
                super();
            }
        });
        cm = (ConnectivityManager)getSystemService("connectivity");
        if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected())
        {
            dataPonsel = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("user_forum_hp").append(Utility.BASE_FORMAT).append("?t=").append(t).append("&id_user=").append(HomeForumActivity.user_id).toString();
            Log.e("data", dataPonsel);
            PonselMerkTask();
        }
        dialog = mclicklistener.create();
        dialog.show();
    }


    _cls9.this._cls1()
    {
        this$0 = HomeForumActivity.this;
        super();
    }
}
