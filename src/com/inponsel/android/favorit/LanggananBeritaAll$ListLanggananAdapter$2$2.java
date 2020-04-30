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
    implements android.content.nAdapter._cls2._cls2
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

    // Unreferenced inner class com/inponsel/android/favorit/LanggananBeritaAll$ListLanggananAdapter$2

/* anonymous class */
    class LanggananBeritaAll.ListLanggananAdapter._cls2
        implements android.view.View.OnClickListener
    {

        final LanggananBeritaAll.ListLanggananAdapter this$1;
        private final int val$position;

        public void onClick(View view)
        {
            LanggananBeritaAll.ListLanggananAdapter.access$0(LanggananBeritaAll.ListLanggananAdapter.this).id_hp_del = getListModel(position).getId_hp();
            Log.e("id_hp_del", LanggananBeritaAll.ListLanggananAdapter.access$0(LanggananBeritaAll.ListLanggananAdapter.this).id_hp_del);
            view = new android.app.AlertDialog.Builder(LanggananBeritaAll.ListLanggananAdapter.access$0(LanggananBeritaAll.ListLanggananAdapter.this));
            view.setTitle("Peringatan");
            view.setMessage("Berhenti berlangganan?");
            view.setPositiveButton("Ya", new LanggananBeritaAll.ListLanggananAdapter._cls2._cls1());
            view.setNegativeButton("Tidak", new LanggananBeritaAll.ListLanggananAdapter._cls2._cls2());
            view.show();
        }


            
            {
                this$1 = final_listlanggananadapter;
                position = I.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/favorit/LanggananBeritaAll$ListLanggananAdapter$2$1

/* anonymous class */
        class LanggananBeritaAll.ListLanggananAdapter._cls2._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final LanggananBeritaAll.ListLanggananAdapter._cls2 this$2;
            private final int val$position;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                LanggananBeritaAll.ListLanggananAdapter.access$0(this$1).statdel = "0";
                if (getListModel(position).getType().equals("hp"))
                {
                    LanggananBeritaAll.ListLanggananAdapter.access$0(this$1).type = "hp";
                } else
                {
                    LanggananBeritaAll.ListLanggananAdapter.access$0(this$1).type = "brand";
                }
                if (LanggananBeritaAll.ListLanggananAdapter.access$0(this$1).netInfo != null && LanggananBeritaAll.ListLanggananAdapter.access$0(this$1).netInfo.isConnected())
                {
                    (new LanggananBeritaAll.DelLanggananTask(LanggananBeritaAll.ListLanggananAdapter.access$0(this$1))).execute(new Void[0]);
                    return;
                } else
                {
                    Toast.makeText(LanggananBeritaAll.ListLanggananAdapter.access$0(this$1), "Tidak ada koneksi internet", 0).show();
                    return;
                }
            }

                    
                    {
                        this$2 = LanggananBeritaAll.ListLanggananAdapter._cls2.this;
                        position = i;
                        super();
                    }
        }

    }

}
