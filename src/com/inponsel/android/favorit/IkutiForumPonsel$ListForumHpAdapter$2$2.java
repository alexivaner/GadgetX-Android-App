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
//            IkutiForumPonsel

class this._cls2
    implements android.content.pAdapter._cls2._cls2
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

    // Unreferenced inner class com/inponsel/android/favorit/IkutiForumPonsel$ListForumHpAdapter$2

/* anonymous class */
    class IkutiForumPonsel.ListForumHpAdapter._cls2
        implements android.view.View.OnClickListener
    {

        final IkutiForumPonsel.ListForumHpAdapter this$1;
        private final int val$position;

        public void onClick(View view)
        {
            IkutiForumPonsel.ListForumHpAdapter.access$0(IkutiForumPonsel.ListForumHpAdapter.this).id_hp_del = getListModel(position).getId_hp();
            IkutiForumPonsel.ListForumHpAdapter.access$0(IkutiForumPonsel.ListForumHpAdapter.this).codename = getListModel(position).getCodename();
            Log.e("id_hp_del", IkutiForumPonsel.ListForumHpAdapter.access$0(IkutiForumPonsel.ListForumHpAdapter.this).id_hp_del);
            view = new android.app.AlertDialog.Builder(IkutiForumPonsel.ListForumHpAdapter.access$0(IkutiForumPonsel.ListForumHpAdapter.this));
            view.setTitle("Peringatan");
            view.setMessage("Hapus perangkat ini dari favorit?");
            view.setPositiveButton("Ya", new IkutiForumPonsel.ListForumHpAdapter._cls2._cls1());
            view.setNegativeButton("Tidak", new IkutiForumPonsel.ListForumHpAdapter._cls2._cls2());
            view.show();
        }


            
            {
                this$1 = final_listforumhpadapter;
                position = I.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/favorit/IkutiForumPonsel$ListForumHpAdapter$2$1

/* anonymous class */
        class IkutiForumPonsel.ListForumHpAdapter._cls2._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final IkutiForumPonsel.ListForumHpAdapter._cls2 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                IkutiForumPonsel.ListForumHpAdapter.access$0(this$1).statdel = "0";
                if (IkutiForumPonsel.ListForumHpAdapter.access$0(this$1).netInfo != null && IkutiForumPonsel.ListForumHpAdapter.access$0(this$1).netInfo.isConnected())
                {
                    (new IkutiForumPonsel.ListForumHpAdapter.AddDelFavoritHPTask(this$1)).execute(new Void[0]);
                    return;
                } else
                {
                    Toast.makeText(IkutiForumPonsel.ListForumHpAdapter.access$0(this$1), "Tidak ada koneksi internet", 1).show();
                    return;
                }
            }

                    
                    {
                        this$2 = IkutiForumPonsel.ListForumHpAdapter._cls2.this;
                        super();
                    }
        }

    }

}
