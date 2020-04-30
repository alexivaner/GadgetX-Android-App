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
    implements android.content.hAdapter._cls2._cls2
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

    // Unreferenced inner class com/inponsel/android/favorit/LanggananBeritaAll$ListSearchAdapter$2

/* anonymous class */
    class LanggananBeritaAll.ListSearchAdapter._cls2
        implements android.view.View.OnClickListener
    {

        final LanggananBeritaAll.ListSearchAdapter this$1;
        private final int val$position;

        public void onClick(View view)
        {
            LanggananBeritaAll.ListSearchAdapter.access$0(LanggananBeritaAll.ListSearchAdapter.this).id_hp_del = getListModel(position).getUni_id();
            LanggananBeritaAll.ListSearchAdapter.access$0(LanggananBeritaAll.ListSearchAdapter.this).uni_type = getListModel(position).getUni_type();
            Log.e("id_hp_del", LanggananBeritaAll.ListSearchAdapter.access$0(LanggananBeritaAll.ListSearchAdapter.this).id_hp_del);
            view = new android.app.AlertDialog.Builder(LanggananBeritaAll.ListSearchAdapter.access$0(LanggananBeritaAll.ListSearchAdapter.this));
            view.setTitle("Peringatan");
            if (!LanggananBeritaAll.ListSearchAdapter.access$0(LanggananBeritaAll.ListSearchAdapter.this).uni_type.equals("hp")) goto _L2; else goto _L1
_L1:
            view.setMessage("Langganan berita ponsel ini?");
_L4:
            view.setPositiveButton("Ya", new LanggananBeritaAll.ListSearchAdapter._cls2._cls1());
            view.setNegativeButton("Tidak", new LanggananBeritaAll.ListSearchAdapter._cls2._cls2());
            view.show();
            return;
_L2:
            if (LanggananBeritaAll.ListSearchAdapter.access$0(LanggananBeritaAll.ListSearchAdapter.this).uni_type.equals("merk"))
            {
                view.setMessage("Langganan berita merek ini?");
            } else
            if (LanggananBeritaAll.ListSearchAdapter.access$0(LanggananBeritaAll.ListSearchAdapter.this).uni_type.equals("operator"))
            {
                view.setMessage("Langganan berita operator ini?");
            } else
            if (LanggananBeritaAll.ListSearchAdapter.access$0(LanggananBeritaAll.ListSearchAdapter.this).uni_type.equals("general"))
            {
                view.setMessage("Langganan berita kategori ini?");
            }
            if (true) goto _L4; else goto _L3
_L3:
        }


            
            {
                this$1 = final_listsearchadapter;
                position = I.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/favorit/LanggananBeritaAll$ListSearchAdapter$2$1

/* anonymous class */
        class LanggananBeritaAll.ListSearchAdapter._cls2._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final LanggananBeritaAll.ListSearchAdapter._cls2 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                LanggananBeritaAll.ListSearchAdapter.access$0(this$1).statdel = "1";
                if (LanggananBeritaAll.ListSearchAdapter.access$0(this$1).netInfo != null && LanggananBeritaAll.ListSearchAdapter.access$0(this$1).netInfo.isConnected())
                {
                    (new LanggananBeritaAll.ListSearchAdapter.AddDelSearchTask(this$1)).execute(new Void[0]);
                    return;
                } else
                {
                    Toast.makeText(LanggananBeritaAll.ListSearchAdapter.access$0(this$1), "Tidak ada koneksi internet", 0).show();
                    return;
                }
            }

                    
                    {
                        this$2 = LanggananBeritaAll.ListSearchAdapter._cls2.this;
                        super();
                    }
        }

    }

}
