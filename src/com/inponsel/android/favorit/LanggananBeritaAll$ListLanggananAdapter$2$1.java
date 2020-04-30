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

class val.position
    implements android.content.nAdapter._cls2._cls1
{

    final is._cls1 this$2;
    private final int val$position;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        ss._mth0(_fld1).statdel = "0";
        if (istModel(val$position).getType().equals("hp"))
        {
            ss._mth0(_fld1).type = "hp";
        } else
        {
            ss._mth0(_fld1).type = "brand";
        }
        if (ss._mth0(_fld1).netInfo != null && ss._mth0(_fld1).netInfo.isConnected())
        {
            (new is._cls1(ss._mth0(_fld1)))._mth1(new Void[0]);
            return;
        } else
        {
            Toast.makeText(ss._mth0(_fld1), "Tidak ada koneksi internet", 0).show();
            return;
        }
    }

    l.position()
    {
        this$2 = final_position1;
        val$position = I.this;
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
            view.setPositiveButton("Ya", position. new LanggananBeritaAll.ListLanggananAdapter._cls2._cls1());
            view.setNegativeButton("Tidak", new LanggananBeritaAll.ListLanggananAdapter._cls2._cls2());
            view.show();
        }


            
            {
                this$1 = final_listlanggananadapter;
                position = I.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/favorit/LanggananBeritaAll$ListLanggananAdapter$2$2

/* anonymous class */
        class LanggananBeritaAll.ListLanggananAdapter._cls2._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final LanggananBeritaAll.ListLanggananAdapter._cls2 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = LanggananBeritaAll.ListLanggananAdapter._cls2.this;
                        super();
                    }
        }

    }

}
