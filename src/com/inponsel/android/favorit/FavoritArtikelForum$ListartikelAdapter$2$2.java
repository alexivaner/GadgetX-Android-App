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

class this._cls2
    implements android.content.lAdapter._cls2._cls2
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

    // Unreferenced inner class com/inponsel/android/favorit/FavoritArtikelForum$ListartikelAdapter$2

/* anonymous class */
    class FavoritArtikelForum.ListartikelAdapter._cls2
        implements android.view.View.OnClickListener
    {

        final FavoritArtikelForum.ListartikelAdapter this$1;
        private final int val$position;

        public void onClick(View view)
        {
            FavoritArtikelForum.ListartikelAdapter.access$0(FavoritArtikelForum.ListartikelAdapter.this).id_del = getListModel(position).getId_content();
            Log.e("id_hp_del", FavoritArtikelForum.ListartikelAdapter.access$0(FavoritArtikelForum.ListartikelAdapter.this).id_del);
            view = new android.app.AlertDialog.Builder(FavoritArtikelForum.ListartikelAdapter.access$0(FavoritArtikelForum.ListartikelAdapter.this));
            view.setTitle("Peringatan");
            view.setMessage("Hapus artikel ini?");
            view.setPositiveButton("Ya", new FavoritArtikelForum.ListartikelAdapter._cls2._cls1());
            view.setNegativeButton("Tidak", new FavoritArtikelForum.ListartikelAdapter._cls2._cls2());
            view.show();
        }


            
            {
                this$1 = final_listartikeladapter;
                position = I.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/favorit/FavoritArtikelForum$ListartikelAdapter$2$1

/* anonymous class */
        class FavoritArtikelForum.ListartikelAdapter._cls2._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final FavoritArtikelForum.ListartikelAdapter._cls2 this$2;
            private final int val$position;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                FavoritArtikelForum.ListartikelAdapter.access$0(this$1).statdel = "0";
                FavoritArtikelForum.ListartikelAdapter.access$0(this$1).id_tl = getListModel(position).getId_content();
                FavoritArtikelForum.ListartikelAdapter.access$0(this$1).id_type = getListModel(position).getTl_type();
                (new FavoritArtikelForum.FavoritTask(FavoritArtikelForum.ListartikelAdapter.access$0(this$1))).execute(new Void[0]);
                FavoritArtikelForum.ListartikelAdapter.access$0(this$1).onResume();
            }

                    
                    {
                        this$2 = FavoritArtikelForum.ListartikelAdapter._cls2.this;
                        position = i;
                        super();
                    }
        }

    }

}
