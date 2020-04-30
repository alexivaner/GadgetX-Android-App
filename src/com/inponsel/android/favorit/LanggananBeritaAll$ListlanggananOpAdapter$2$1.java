// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.favorit;

import android.content.DialogInterface;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.Toast;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.favorit:
//            LanggananBeritaAll

class this._cls2
    implements android.content.pAdapter._cls2._cls1
{

    final is._cls1 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        ss._mth0(_fld1).statdel = "0";
        if (ss._mth0(_fld1).netInfo != null && ss._mth0(_fld1).netInfo.isConnected())
        {
            (new elLanggananOpTask(_fld1)).execute(new Void[0]);
            return;
        } else
        {
            Toast.makeText(ss._mth0(_fld1), "Tidak ada koneksi internet", 0).show();
            return;
        }
    }

    l.position()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/favorit/LanggananBeritaAll$ListlanggananOpAdapter$2

/* anonymous class */
    class LanggananBeritaAll.ListlanggananOpAdapter._cls2
        implements android.view.View.OnClickListener
    {

        final LanggananBeritaAll.ListlanggananOpAdapter this$1;
        private final int val$position;

        public void onClick(View view)
        {
            LanggananBeritaAll.ListlanggananOpAdapter.access$0(LanggananBeritaAll.ListlanggananOpAdapter.this).id_hp_del = getListModel(position).getId_hp();
            Log.e("id_hp_del", LanggananBeritaAll.ListlanggananOpAdapter.access$0(LanggananBeritaAll.ListlanggananOpAdapter.this).id_hp_del);
            view = new android.app.AlertDialog.Builder(LanggananBeritaAll.ListlanggananOpAdapter.access$0(LanggananBeritaAll.ListlanggananOpAdapter.this));
            view.setTitle("Peringatan");
            view.setMessage("Berhenti berlangganan berita operator ini?");
            view.setPositiveButton("Ya", new LanggananBeritaAll.ListlanggananOpAdapter._cls2._cls1());
            view.setNegativeButton("Tidak", new LanggananBeritaAll.ListlanggananOpAdapter._cls2._cls2());
            view.show();
        }


            
            {
                this$1 = final_listlanggananopadapter;
                position = I.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/favorit/LanggananBeritaAll$ListlanggananOpAdapter$2$2

/* anonymous class */
        class LanggananBeritaAll.ListlanggananOpAdapter._cls2._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final LanggananBeritaAll.ListlanggananOpAdapter._cls2 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = LanggananBeritaAll.ListlanggananOpAdapter._cls2.this;
                        super();
                    }
        }

    }

}
