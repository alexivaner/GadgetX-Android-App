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
//            FavoritPonselMerek

class val.position
    implements android.view.SearchAdapter._cls2
{

    final _cls2 this$1;
    private final int val$position;

    public void onClick(View view)
    {
        cess._mth1(this._cls1.this).id_hp_del = tListModel(val$position).getUni_id();
        cess._mth1(this._cls1.this).uni_type = tListModel(val$position).getUni_type();
        Log.e("id_hp_del", cess._mth1(this._cls1.this).id_hp_del);
        view = new android.app.hp_del(cess._mth1(this._cls1.this));
        view.tSearchAdapter("Peringatan");
        view.tSearchAdapter("Tambahkan ke favorit?");
        view.tSearchAdapter("Ya", new android.content.DialogInterface.OnClickListener() {

            final FavoritPonselMerek.ListSearchAdapter._cls2 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                FavoritPonselMerek.ListSearchAdapter.access$1(this$1).statdel = "1";
                if (FavoritPonselMerek.ListSearchAdapter.access$1(this$1).netInfo != null && FavoritPonselMerek.ListSearchAdapter.access$1(this$1).netInfo.isConnected())
                {
                    (new FavoritPonselMerek.ListSearchAdapter.AddDelSearchTask(this$1)).execute(new Void[0]);
                    return;
                } else
                {
                    Toast.makeText(FavoritPonselMerek.ListSearchAdapter.access$1(this$1), "Tidak ada koneksi internet", 1).show();
                    return;
                }
            }

            
            {
                this$2 = FavoritPonselMerek.ListSearchAdapter._cls2.this;
                super();
            }
        });
        view._mth2("Tidak", new android.content.DialogInterface.OnClickListener() {

            final FavoritPonselMerek.ListSearchAdapter._cls2 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$2 = FavoritPonselMerek.ListSearchAdapter._cls2.this;
                super();
            }
        });
        view._mth2();
    }


    _cls2.this._cls2()
    {
        this$1 = final__pcls2;
        val$position = I.this;
        super();
    }
}
