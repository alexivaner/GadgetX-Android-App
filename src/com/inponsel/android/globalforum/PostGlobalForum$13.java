// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.globalforum;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import com.inponsel.android.adapter.ListAdapter;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.RoomPostArtikel;
import com.inponsel.android.v2.RoomPostBenchmark;
import com.inponsel.android.v2.RoomPostHasilFotoNoCrop;
import com.inponsel.android.v2.RoomPostPertanyaan;

// Referenced classes of package com.inponsel.android.globalforum:
//            PostGlobalForum

class this._cls0
    implements android.widget.lickListener
{

    final PostGlobalForum this$0;

    public void onItemClick(final AdapterView id_hp, final View codename, int i, long l)
    {
        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edtAuto.getWindowToken(), 0);
        id_hp = listAdapter.getListModel(i).getId_hp();
        codename = listAdapter.getListModel(i).getCodename();
        final String merk = listAdapter.getListModel(i).getMerk();
        final String model = listAdapter.getListModel(i).getModel();
        final String gambar = listAdapter.getListModel(i).getGambar();
        final String namalengkap = (new StringBuilder(String.valueOf(merk))).append(" ").append(model).toString();
        dialog.dismiss();
        if (userFunctions.isUserLoggedIn(PostGlobalForum.this))
        {
            android.app.  = new android.app.(PostGlobalForum.this);
            .setTitle((new StringBuilder("Kirim Konten ")).append(merk).append(" ").append(model).toString());
            .setItems(tambah_artikel, new android.content.DialogInterface.OnClickListener() {

                final PostGlobalForum._cls13 this$1;
                private final String val$codename;
                private final String val$gambar;
                private final String val$id_hp;
                private final String val$merk;
                private final String val$model;
                private final String val$namalengkap;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    j;
                    JVM INSTR tableswitch 0 5: default 40
                //                               0 47
                //                               1 195
                //                               2 343
                //                               3 473
                //                               4 603
                //                               5 751;
                       goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
                    dialoginterface.dismiss();
                    return;
_L2:
                    Intent intent = new Intent(this$0, com/inponsel/android/v2/RoomPostArtikel);
                    intent.putExtra("action", "post");
                    intent.putExtra("id_hph", id_hp);
                    intent.putExtra("namalengkap", namalengkap);
                    intent.putExtra("codename", codename);
                    intent.putExtra("model", model);
                    intent.putExtra("merk", merk);
                    intent.putExtra("gambar", gambar);
                    intent.putExtra("from", "apps");
                    intent.putExtra("tl_type", "artikel");
                    intent.putExtra("tl_tag", "umum");
                    startActivityForResult(intent, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                    continue; /* Loop/switch isn't completed */
_L3:
                    Intent intent1 = new Intent(this$0, com/inponsel/android/v2/RoomPostArtikel);
                    intent1.putExtra("action", "post");
                    intent1.putExtra("id_hph", id_hp);
                    intent1.putExtra("namalengkap", namalengkap);
                    intent1.putExtra("codename", codename);
                    intent1.putExtra("model", model);
                    intent1.putExtra("merk", merk);
                    intent1.putExtra("gambar", gambar);
                    intent1.putExtra("from", "apps");
                    intent1.putExtra("tl_type", "artikel");
                    intent1.putExtra("tl_tag", "tips");
                    startActivityForResult(intent1, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                    continue; /* Loop/switch isn't completed */
_L4:
                    Intent intent2 = new Intent(this$0, com/inponsel/android/v2/RoomPostHasilFotoNoCrop);
                    intent2.putExtra("id_hph", id_hp);
                    intent2.putExtra("namalengkap", namalengkap);
                    intent2.putExtra("codename", codename);
                    intent2.putExtra("model", model);
                    intent2.putExtra("merk", merk);
                    intent2.putExtra("gambar", gambar);
                    intent2.putExtra("from", "apps");
                    intent2.putExtra("type", "fotokamera");
                    startActivityForResult(intent2, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                    continue; /* Loop/switch isn't completed */
_L5:
                    Intent intent3 = new Intent(this$0, com/inponsel/android/v2/RoomPostBenchmark);
                    intent3.putExtra("id_hph", id_hp);
                    intent3.putExtra("namalengkap", namalengkap);
                    intent3.putExtra("codename", codename);
                    intent3.putExtra("model", model);
                    intent3.putExtra("merk", merk);
                    intent3.putExtra("gambar", gambar);
                    intent3.putExtra("from", "apps");
                    intent3.putExtra("type", "benchmark");
                    startActivityForResult(intent3, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                    continue; /* Loop/switch isn't completed */
_L6:
                    Intent intent4 = new Intent(this$0, com/inponsel/android/v2/RoomPostArtikel);
                    intent4.putExtra("action", "post");
                    intent4.putExtra("id_hph", id_hp);
                    intent4.putExtra("namalengkap", namalengkap);
                    intent4.putExtra("codename", codename);
                    intent4.putExtra("model", model);
                    intent4.putExtra("merk", merk);
                    intent4.putExtra("gambar", gambar);
                    intent4.putExtra("from", "apps");
                    intent4.putExtra("tl_type", "artikel");
                    intent4.putExtra("tl_tag", "aksesoris");
                    startActivityForResult(intent4, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                    continue; /* Loop/switch isn't completed */
_L7:
                    Intent intent5 = new Intent(this$0, com/inponsel/android/v2/RoomPostPertanyaan);
                    intent5.putExtra("id_hph", id_hp);
                    intent5.putExtra("namalengkap", namalengkap);
                    intent5.putExtra("codename", codename);
                    intent5.putExtra("model", model);
                    intent5.putExtra("merk", merk);
                    intent5.putExtra("gambar", gambar);
                    intent5.putExtra("from", "apps");
                    intent5.putExtra("type", "faqhp");
                    startActivityForResult(intent5, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                    if (true) goto _L1; else goto _L8
_L8:
                }

            
            {
                this$1 = PostGlobalForum._cls13.this;
                id_hp = s;
                namalengkap = s1;
                codename = s2;
                model = s3;
                merk = s4;
                gambar = s5;
                super();
            }
            });
            .show();
            return;
        } else
        {
            PostGlobalForum.access$1(PostGlobalForum.this, "Perhatian", "Untuk mengirim artikel diharuskan login terlebih dahulu");
            return;
        }
    }


    _cls1.val.gambar()
    {
        this$0 = PostGlobalForum.this;
        super();
    }
}
