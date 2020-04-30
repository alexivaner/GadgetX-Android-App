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
    implements android.content.sAdapter._cls2._cls2
{

    final this._cls2 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    l.position()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/favorit/LanggananBeritaAll$ListlangganKatsusAdapter$2

/* anonymous class */
    class LanggananBeritaAll.ListlangganKatsusAdapter._cls2
        implements android.view.View.OnClickListener
    {

        final LanggananBeritaAll.ListlangganKatsusAdapter this$1;
        private final int val$position;

        public void onClick(View view)
        {
            LanggananBeritaAll.ListlangganKatsusAdapter.access$0(LanggananBeritaAll.ListlangganKatsusAdapter.this).id_hp_del = getListModel(position).getId_hp();
            Log.e("id_hp_del", LanggananBeritaAll.ListlangganKatsusAdapter.access$0(LanggananBeritaAll.ListlangganKatsusAdapter.this).id_hp_del);
            view = new android.app.AlertDialog.Builder(LanggananBeritaAll.ListlangganKatsusAdapter.access$0(LanggananBeritaAll.ListlangganKatsusAdapter.this));
            view.setTitle("Peringatan");
            view.setMessage("Berhenti berlangganan kategori ini?");
            view.setPositiveButton("Ya", new LanggananBeritaAll.ListlangganKatsusAdapter._cls2._cls1());
            view.setNegativeButton("Tidak", new LanggananBeritaAll.ListlangganKatsusAdapter._cls2._cls2());
            view.show();
        }


            
            {
                this$1 = final_listlanggankatsusadapter;
                position = I.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/favorit/LanggananBeritaAll$ListlangganKatsusAdapter$2$1

/* anonymous class */
        class LanggananBeritaAll.ListlangganKatsusAdapter._cls2._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final LanggananBeritaAll.ListlangganKatsusAdapter._cls2 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                LanggananBeritaAll.ListlangganKatsusAdapter.access$0(this$1).statdel = "0";
                if (LanggananBeritaAll.ListlangganKatsusAdapter.access$0(this$1).netInfo != null && LanggananBeritaAll.ListlangganKatsusAdapter.access$0(this$1).netInfo.isConnected())
                {
                    (new LanggananBeritaAll.ListlangganKatsusAdapter.AddDelLanggananKatsusTask(this$1)).execute(new Void[0]);
                    return;
                } else
                {
                    Toast.makeText(LanggananBeritaAll.ListlangganKatsusAdapter.access$0(this$1), "Tidak ada koneksi internet", 0).show();
                    return;
                }
            }

                    
                    {
                        this$2 = LanggananBeritaAll.ListlangganKatsusAdapter._cls2.this;
                        super();
                    }
        }

    }

}
