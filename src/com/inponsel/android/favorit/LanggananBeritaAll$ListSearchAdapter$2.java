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
    implements android.view.SearchAdapter._cls2
{

    final this._cls1 this$1;
    private final int val$position;

    public void onClick(View view)
    {
        cess._mth0(this._cls1.this).id_hp_del = tListModel(val$position).getUni_id();
        cess._mth0(this._cls1.this).uni_type = tListModel(val$position).getUni_type();
        Log.e("id_hp_del", cess._mth0(this._cls1.this).id_hp_del);
        view = new android.app.hp_del(cess._mth0(this._cls1.this));
        view.tSearchAdapter("Peringatan");
        if (!cess._mth0(this._cls1.this).uni_type.equals("hp")) goto _L2; else goto _L1
_L1:
        view._type("Langganan berita ponsel ini?");
_L4:
        view._type("Ya", new android.content.DialogInterface.OnClickListener() {

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
        });
        view._mth2("Tidak", new android.content.DialogInterface.OnClickListener() {

            final LanggananBeritaAll.ListSearchAdapter._cls2 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$2 = LanggananBeritaAll.ListSearchAdapter._cls2.this;
                super();
            }
        });
        view._mth2();
        return;
_L2:
        if (cess._mth0(this._cls1.this).uni_type.equals("merk"))
        {
            view._type("Langganan berita merek ini?");
        } else
        if (cess._mth0(this._cls1.this).uni_type.equals("operator"))
        {
            view._type("Langganan berita operator ini?");
        } else
        if (cess._mth0(this._cls1.this).uni_type.equals("general"))
        {
            view._type("Langganan berita kategori ini?");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }


    _cls2.this._cls2()
    {
        this$1 = final__pcls2;
        val$position = I.this;
        super();
    }
}
