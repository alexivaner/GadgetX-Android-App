// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.inponsel.android.details.DetailsPonsel;
import com.inponsel.android.details.SCTerdekatActivity;
import com.inponsel.android.tlforum.ForumHPActivity;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.net.URLDecoder;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            RoomPostArtikel, ProfilePonselUserActivity, RoomPostHasilFotoNoCrop, RoomPostBenchmark, 
//            RoomPostPertanyaan, RSSFeedByTag, RoomPenggunaHp, KomentarPonsel, 
//            RoomChatActivity

class this._cls2
    implements android.content.y._cls2._cls8._cls1
{

    final dePendingTransition this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        i;
        JVM INSTR tableswitch 0 5: default 40
    //                   0 47
    //                   1 258
    //                   2 469
    //                   3 662
    //                   4 855
    //                   5 1066;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        dialoginterface.dismiss();
        return;
_L2:
        Intent intent = new Intent(_fld0, com/inponsel/android/v2/RoomPostArtikel);
        intent.putExtra("action", "post");
        intent.putExtra("id_hph", id_hp_1);
        intent.putExtra("namalengkap", nama_hp_1);
        intent.putExtra("codename", code_hp_1);
        intent.putExtra("model", model_1);
        intent.putExtra("merk", merk_1);
        intent.putExtra("gambar", gambar_hp_1);
        intent.putExtra("from", "apps");
        intent.putExtra("tl_type", "artikel");
        intent.putExtra("tl_tag", "umum");
        startActivityForResult(intent, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
        continue; /* Loop/switch isn't completed */
_L3:
        Intent intent1 = new Intent(_fld0, com/inponsel/android/v2/RoomPostArtikel);
        intent1.putExtra("action", "post");
        intent1.putExtra("id_hph", id_hp_1);
        intent1.putExtra("namalengkap", nama_hp_1);
        intent1.putExtra("codename", code_hp_1);
        intent1.putExtra("model", model_1);
        intent1.putExtra("merk", merk_1);
        intent1.putExtra("gambar", gambar_hp_1);
        intent1.putExtra("from", "apps");
        intent1.putExtra("tl_type", "artikel");
        intent1.putExtra("tl_tag", "tips");
        startActivityForResult(intent1, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
        continue; /* Loop/switch isn't completed */
_L4:
        Intent intent2 = new Intent(_fld0, com/inponsel/android/v2/RoomPostHasilFotoNoCrop);
        intent2.putExtra("id_hph", id_hp_1);
        intent2.putExtra("namalengkap", nama_hp_1);
        intent2.putExtra("codename", code_hp_1);
        intent2.putExtra("model", model_1);
        intent2.putExtra("merk", merk_1);
        intent2.putExtra("gambar", gambar_hp_1);
        intent2.putExtra("from", "apps");
        intent2.putExtra("type", "fotokamera");
        startActivityForResult(intent2, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
        continue; /* Loop/switch isn't completed */
_L5:
        Intent intent3 = new Intent(_fld0, com/inponsel/android/v2/RoomPostBenchmark);
        intent3.putExtra("id_hph", id_hp_1);
        intent3.putExtra("namalengkap", nama_hp_1);
        intent3.putExtra("codename", code_hp_1);
        intent3.putExtra("model", model_1);
        intent3.putExtra("merk", merk_1);
        intent3.putExtra("gambar", gambar_hp_1);
        intent3.putExtra("from", "apps");
        intent3.putExtra("type", "benchmark");
        startActivityForResult(intent3, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
        continue; /* Loop/switch isn't completed */
_L6:
        Intent intent4 = new Intent(_fld0, com/inponsel/android/v2/RoomPostArtikel);
        intent4.putExtra("action", "post");
        intent4.putExtra("id_hph", id_hp_1);
        intent4.putExtra("namalengkap", nama_hp_1);
        intent4.putExtra("codename", code_hp_1);
        intent4.putExtra("model", model_1);
        intent4.putExtra("merk", merk_1);
        intent4.putExtra("gambar", gambar_hp_1);
        intent4.putExtra("from", "apps");
        intent4.putExtra("tl_type", "artikel");
        intent4.putExtra("tl_tag", "aksesoris");
        startActivityForResult(intent4, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
        continue; /* Loop/switch isn't completed */
_L7:
        Intent intent5 = new Intent(_fld0, com/inponsel/android/v2/RoomPostPertanyaan);
        intent5.putExtra("id_hph", id_hp_1);
        intent5.putExtra("namalengkap", nama_hp_1);
        intent5.putExtra("codename", code_hp_1);
        intent5.putExtra("model", model_1);
        intent5.putExtra("merk", merk_1);
        intent5.putExtra("gambar", gambar_hp_1);
        intent5.putExtra("from", "apps");
        intent5.putExtra("type", "faqhp");
        startActivityForResult(intent5, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
        if (true) goto _L1; else goto _L8
_L8:
    }

    ._cls0()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/ProfilePonselUserActivity$2

/* anonymous class */
    class ProfilePonselUserActivity._cls2 extends AsyncHttpResponseHandler
    {

        final ProfilePonselUserActivity this$0;

        public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
        {
        }

        public void onRetry(int i)
        {
        }

        public void onStart()
        {
        }

        public void onSuccess(int i, Header aheader[], byte abyte0[])
        {
            abyte0 = new JSONObject(new String(abyte0));
            aheader = abyte0.getJSONArray("InPonsel");
            str_img_banner = abyte0.getString("img_banner");
            i = 0;
_L3:
            int j = aheader.length();
            if (i < j) goto _L2; else goto _L1
_L1:
            Log.e("gambar_hp_1", gambar_hp_1);
            if (statSubNews.equals("1"))
            {
                if (sdk < 16)
                {
                    detail_favoritenews.setBackgroundDrawable(drwKurang);
                } else
                {
                    detail_favoritenews.setBackground(drwKurang);
                }
            } else
            if (sdk < 16)
            {
                detail_favoritenews.setBackgroundDrawable(drw);
            } else
            {
                detail_favoritenews.setBackground(drw);
            }
            ll_ppu_ikhtisar.setOnClickListener(new ProfilePonselUserActivity._cls2._cls1());
            ll_ppu_news.setOnClickListener(new ProfilePonselUserActivity._cls2._cls2());
            ll_ppu_sc.setOnClickListener(new ProfilePonselUserActivity._cls2._cls3());
            ll_ppu_pengguna.setOnClickListener(new ProfilePonselUserActivity._cls2._cls4());
            ll_ppu_komentar.setOnClickListener(new ProfilePonselUserActivity._cls2._cls5());
            ll_ppu_Chatroom.setOnClickListener(new ProfilePonselUserActivity._cls2._cls6());
            ll_ppu_Forum.setOnClickListener(new ProfilePonselUserActivity._cls2._cls7());
            ll_ppu_postForum.setOnClickListener(new ProfilePonselUserActivity._cls2._cls8());
            Picasso.with(ProfilePonselUserActivity.this).load(gambar_hp_1).into(imgHp, new ProfilePonselUserActivity._cls2._cls9());
            Picasso.with(ProfilePonselUserActivity.this).load(str_img_banner).into(imgHpBackground, new ProfilePonselUserActivity._cls2._cls10());
            return;
_L2:
            abyte0 = aheader.getJSONObject(i);
            id_merk_1 = abyte0.getString("id_merk_1");
            id_merk_2 = abyte0.getString("id_merk_2");
            merk_1 = abyte0.getString("merk_1");
            merk_2 = abyte0.getString("merk_2");
            model_1 = abyte0.getString("model_1");
            model_2 = abyte0.getString("model_2");
            id_hp_1 = abyte0.getString("id_hp_1");
            id_hp_2 = abyte0.getString("id_hp_2");
            nama_hp_1 = abyte0.getString("nama_hp_1");
            nama_hp_2 = abyte0.getString("nama_hp_2");
            code_hp_1 = abyte0.getString("code_hp_1");
            code_hp_2 = abyte0.getString("code_hp_2");
            gambar_hp_1 = abyte0.getString("gambar_hp_1");
            gambar_hp_2 = abyte0.getString("gambar_hp_2");
            statSubNews = abyte0.getString("subs_status");
            i++;
              goto _L3
            aheader;
            aheader.printStackTrace();
              goto _L1
        }


            
            {
                this$0 = ProfilePonselUserActivity.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/ProfilePonselUserActivity$2$1

/* anonymous class */
        class ProfilePonselUserActivity._cls2._cls1
            implements android.view.View.OnClickListener
        {

            final ProfilePonselUserActivity._cls2 this$1;

            public void onClick(View view)
            {
                view = new Intent(this$0, com/inponsel/android/details/DetailsPonsel);
                view.putExtra("id_hph", id_hp_1);
                view.putExtra("namalengkap", nama_hp_1);
                view.putExtra("codename", code_hp_1);
                view.putExtra("model", "");
                view.putExtra("merk", "");
                view.putExtra("gambar", "");
                view.putExtra("hrg_baru", "");
                view.putExtra("hrg_bekas", "");
                view.putExtra("tot_like", "");
                view.putExtra("tot_dislike", "");
                view.putExtra("tot_komen", "");
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$1 = ProfilePonselUserActivity._cls2.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/ProfilePonselUserActivity$2$10

/* anonymous class */
        class ProfilePonselUserActivity._cls2._cls10
            implements Callback
        {

            final ProfilePonselUserActivity._cls2 this$1;

            public void onError()
            {
            }

            public void onSuccess()
            {
            }

                    
                    {
                        this$1 = ProfilePonselUserActivity._cls2.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/ProfilePonselUserActivity$2$2

/* anonymous class */
        class ProfilePonselUserActivity._cls2._cls2
            implements android.view.View.OnClickListener
        {

            final ProfilePonselUserActivity._cls2 this$1;

            public void onClick(View view)
            {
                view = new Intent(this$0, com/inponsel/android/v2/RSSFeedByTag);
                view.putExtra("tag_code", "5");
                view.putExtra("tag_key", (new StringBuilder("hp:")).append(id_hp_1).toString());
                view.putExtra("kategori_tag", nama_hp_1);
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$1 = ProfilePonselUserActivity._cls2.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/ProfilePonselUserActivity$2$3

/* anonymous class */
        class ProfilePonselUserActivity._cls2._cls3
            implements android.view.View.OnClickListener
        {

            final ProfilePonselUserActivity._cls2 this$1;

            public void onClick(View view)
            {
                view = new Intent(this$0, com/inponsel/android/details/SCTerdekatActivity);
                view.putExtra("id_merk", id_merk_1);
                view.putExtra("titlemerek", merk_1);
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$1 = ProfilePonselUserActivity._cls2.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/ProfilePonselUserActivity$2$4

/* anonymous class */
        class ProfilePonselUserActivity._cls2._cls4
            implements android.view.View.OnClickListener
        {

            final ProfilePonselUserActivity._cls2 this$1;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(this$0))
                {
                    view = new Intent(this$0, com/inponsel/android/v2/RoomPenggunaHp);
                    view.putExtra("kota", "");
                    view.putExtra("kota_id", "");
                    view.putExtra("prov", "");
                    view.putExtra("merk", merk_1);
                    view.putExtra("model", model_1);
                    view.putExtra("codename", code_hp_1);
                    startActivityForResult(view, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }
            }

                    
                    {
                        this$1 = ProfilePonselUserActivity._cls2.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/ProfilePonselUserActivity$2$5

/* anonymous class */
        class ProfilePonselUserActivity._cls2._cls5
            implements android.view.View.OnClickListener
        {

            final ProfilePonselUserActivity._cls2 this$1;

            public void onClick(View view)
            {
                view = new Intent(getApplicationContext(), com/inponsel/android/v2/KomentarPonsel);
                view.putExtra("id_hph", id_hp_1);
                view.putExtra("namalengkap", nama_hp_1);
                view.putExtra("codename", code_hp_1);
                view.putExtra("model", model_1);
                view.putExtra("merk", merk_1);
                view.putExtra("gambar", "");
                view.putExtra("tot_komen", "");
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$1 = ProfilePonselUserActivity._cls2.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/ProfilePonselUserActivity$2$6

/* anonymous class */
        class ProfilePonselUserActivity._cls2._cls6
            implements android.view.View.OnClickListener
        {

            final ProfilePonselUserActivity._cls2 this$1;

            public void onClick(View view)
            {
                view = new Intent(this$0, com/inponsel/android/v2/RoomChatActivity);
                view.putExtra("id_from", user_id);
                view.putExtra("from_name", username);
                view.putExtra("from_photo", user_photo);
                view.putExtra("to_photo", gambar_hp_1);
                view.putExtra("merk", merk_1);
                view.putExtra("model", model_1);
                view.putExtra("codename", (new StringBuilder(String.valueOf(code_hp_1))).append("-").append(code_hp_1).toString());
                view.putExtra("id_hph", id_hp_1);
                ProfilePonselUserActivity.access$0(this$0, user_id, code_hp_1, "1", t, "");
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$1 = ProfilePonselUserActivity._cls2.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/ProfilePonselUserActivity$2$7

/* anonymous class */
        class ProfilePonselUserActivity._cls2._cls7
            implements android.view.View.OnClickListener
        {

            final ProfilePonselUserActivity._cls2 this$1;

            public void onClick(View view)
            {
                view = new Intent(this$0, com/inponsel/android/tlforum/ForumHPActivity);
                view.putExtra("id_hph", id_hp_1);
                view.putExtra("namalengkap", nama_hp_1);
                view.putExtra("codename", code_hp_1);
                view.putExtra("model", model_1);
                view.putExtra("merk", merk_1);
                view.putExtra("gambar", gambar_hp_1);
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$1 = ProfilePonselUserActivity._cls2.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/ProfilePonselUserActivity$2$9

/* anonymous class */
        class ProfilePonselUserActivity._cls2._cls9
            implements Callback
        {

            final ProfilePonselUserActivity._cls2 this$1;

            public void onError()
            {
                imgHp.setImageResource(0x7f020297);
            }

            public void onSuccess()
            {
                imgHp.setVisibility(0);
                progressbar_item.setVisibility(8);
            }

                    
                    {
                        this$1 = ProfilePonselUserActivity._cls2.this;
                        super();
                    }
        }

    }


    // Unreferenced inner class com/inponsel/android/v2/ProfilePonselUserActivity$2$8

/* anonymous class */
    class ProfilePonselUserActivity._cls2._cls8
        implements android.view.View.OnClickListener
    {

        final ProfilePonselUserActivity._cls2 this$1;

        public void onClick(View view)
        {
            view = new android.app.AlertDialog.Builder(this$0);
            view.setTitle(URLDecoder.decode((new StringBuilder("Kirim Konten ")).append(merk_1).append(" ").append(model_1).toString()));
            view.setItems(tambah_artikel, new ProfilePonselUserActivity._cls2._cls8._cls1());
            view.show();
        }


            
            {
                this$1 = ProfilePonselUserActivity._cls2.this;
                super();
            }
    }

}
