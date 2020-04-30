// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.favorit;

import android.content.DialogInterface;
import android.view.View;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.favorit:
//            FavoritArtikelForum

class val.position
    implements android.view.tTanyaAdapter._cls2
{

    final _cls2 this$1;
    private final int val$position;

    public void onClick(View view)
    {
        cess._mth0(this._cls1.this).id_del = tListModel(val$position).getId_content();
        Log.e("id_hp_del", cess._mth0(this._cls1.this).id_del);
        view = new android.app._del(cess._mth0(this._cls1.this));
        view.stTanyaAdapter("Peringatan");
        view.stTanyaAdapter("Hapus pertanyaan ini?");
        view.stTanyaAdapter("Ya", new android.content.DialogInterface.OnClickListener() {

            final FavoritArtikelForum.ListTanyaAdapter._cls2 this$2;
            private final int val$position;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                FavoritArtikelForum.ListTanyaAdapter.access$0(this$1).statdel = "0";
                FavoritArtikelForum.ListTanyaAdapter.access$0(this$1).id_tl = getListModel(position).getId_content();
                FavoritArtikelForum.ListTanyaAdapter.access$0(this$1).id_type = getListModel(position).getTl_type();
                (new FavoritArtikelForum.FavoritTask(FavoritArtikelForum.ListTanyaAdapter.access$0(this$1))).execute(new Void[0]);
                FavoritArtikelForum.ListTanyaAdapter.access$0(this$1).onResume();
            }

            
            {
                this$2 = FavoritArtikelForum.ListTanyaAdapter._cls2.this;
                position = i;
                super();
            }
        });
        view._mth2("Tidak", new android.content.DialogInterface.OnClickListener() {

            final FavoritArtikelForum.ListTanyaAdapter._cls2 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$2 = FavoritArtikelForum.ListTanyaAdapter._cls2.this;
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
