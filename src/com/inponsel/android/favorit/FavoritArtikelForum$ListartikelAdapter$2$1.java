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
    implements android.content.lAdapter._cls2._cls1
{

    final is._cls1 this$2;
    private final int val$position;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        ss._mth0(_fld1).statdel = "0";
        ss._mth0(_fld1).id_tl = istModel(val$position).getId_content();
        ss._mth0(_fld1).id_type = istModel(val$position).getTl_type();
        (new val.position(ss._mth0(_fld1)))._mth1(new Void[0]);
        ss._mth0(_fld1).onResume();
    }

    l.position()
    {
        this$2 = final_position1;
        val$position = I.this;
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
            view.setPositiveButton("Ya", position. new FavoritArtikelForum.ListartikelAdapter._cls2._cls1());
            view.setNegativeButton("Tidak", new FavoritArtikelForum.ListartikelAdapter._cls2._cls2());
            view.show();
        }


            
            {
                this$1 = final_listartikeladapter;
                position = I.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/favorit/FavoritArtikelForum$ListartikelAdapter$2$2

/* anonymous class */
        class FavoritArtikelForum.ListartikelAdapter._cls2._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final FavoritArtikelForum.ListartikelAdapter._cls2 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = FavoritArtikelForum.ListartikelAdapter._cls2.this;
                        super();
                    }
        }

    }

}
