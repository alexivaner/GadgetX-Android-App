// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.tlforum;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.RoomPostArtikel;
import com.inponsel.android.v2.RoomPostBenchmark;
import com.inponsel.android.v2.RoomPostHasilFotoNoCrop;
import com.inponsel.android.v2.RoomPostPertanyaan;
import java.net.URLDecoder;

// Referenced classes of package com.inponsel.android.tlforum:
//            ForumHPActivity

class this._cls1
    implements android.content.ickListener
{

    final ridePendingTransition this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        i;
        JVM INSTR tableswitch 0 5: default 40
    //                   0 47
    //                   1 231
    //                   2 415
    //                   3 581
    //                   4 747
    //                   5 931;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        dialoginterface.dismiss();
        return;
_L2:
        Intent intent = new Intent(_fld0, com/inponsel/android/v2/RoomPostArtikel);
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
        Intent intent1 = new Intent(_fld0, com/inponsel/android/v2/RoomPostArtikel);
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
        Intent intent2 = new Intent(_fld0, com/inponsel/android/v2/RoomPostHasilFotoNoCrop);
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
        Intent intent3 = new Intent(_fld0, com/inponsel/android/v2/RoomPostBenchmark);
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
        Intent intent4 = new Intent(_fld0, com/inponsel/android/v2/RoomPostArtikel);
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
        Intent intent5 = new Intent(_fld0, com/inponsel/android/v2/RoomPostPertanyaan);
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

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/tlforum/ForumHPActivity$7

/* anonymous class */
    class ForumHPActivity._cls7
        implements android.view.View.OnClickListener
    {

        final ForumHPActivity this$0;

        public void onClick(View view)
        {
            if (userFunctions.isUserLoggedIn(ForumHPActivity.this))
            {
                view = new android.app.AlertDialog.Builder(ForumHPActivity.this);
                view.setTitle(URLDecoder.decode((new StringBuilder("Kirim Konten ")).append(merk).append(" ").append(model).toString()));
                view.setItems(tambah_artikel, new ForumHPActivity._cls7._cls1());
                view.show();
                return;
            } else
            {
                ForumHPActivity.access$3(ForumHPActivity.this, "Perhatian", "Untuk mengirim artikel diharuskan login terlebih dahulu");
                return;
            }
        }


            
            {
                this$0 = ForumHPActivity.this;
                super();
            }
    }

}
