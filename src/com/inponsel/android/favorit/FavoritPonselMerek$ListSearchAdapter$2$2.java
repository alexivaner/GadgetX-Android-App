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

    // Unreferenced inner class com/inponsel/android/favorit/FavoritPonselMerek$ListSearchAdapter$2

/* anonymous class */
    class FavoritPonselMerek.ListSearchAdapter._cls2
        implements android.view.View.OnClickListener
    {

        final FavoritPonselMerek.ListSearchAdapter this$1;
        private final int val$position;

        public void onClick(View view)
        {
            FavoritPonselMerek.ListSearchAdapter.access$1(FavoritPonselMerek.ListSearchAdapter.this).id_hp_del = getListModel(position).getUni_id();
            FavoritPonselMerek.ListSearchAdapter.access$1(FavoritPonselMerek.ListSearchAdapter.this).uni_type = getListModel(position).getUni_type();
            Log.e("id_hp_del", FavoritPonselMerek.ListSearchAdapter.access$1(FavoritPonselMerek.ListSearchAdapter.this).id_hp_del);
            view = new android.app.AlertDialog.Builder(FavoritPonselMerek.ListSearchAdapter.access$1(FavoritPonselMerek.ListSearchAdapter.this));
            view.setTitle("Peringatan");
            view.setMessage("Tambahkan ke favorit?");
            view.setPositiveButton("Ya", new FavoritPonselMerek.ListSearchAdapter._cls2._cls1());
            view.setNegativeButton("Tidak", new FavoritPonselMerek.ListSearchAdapter._cls2._cls2());
            view.show();
        }


            
            {
                this$1 = final_listsearchadapter;
                position = I.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/favorit/FavoritPonselMerek$ListSearchAdapter$2$1

/* anonymous class */
        class FavoritPonselMerek.ListSearchAdapter._cls2._cls1
            implements android.content.DialogInterface.OnClickListener
        {

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
        }

    }

}
