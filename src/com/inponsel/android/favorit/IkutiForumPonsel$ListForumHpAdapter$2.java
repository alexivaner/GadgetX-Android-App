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

class val.position
    implements android.view.orumHpAdapter._cls2
{

    final _cls2 this$1;
    private final int val$position;

    public void onClick(View view)
    {
        cess._mth0(this._cls1.this).id_hp_del = tListModel(val$position).getId_hp();
        cess._mth0(this._cls1.this).codename = tListModel(val$position).getCodename();
        Log.e("id_hp_del", cess._mth0(this._cls1.this).id_hp_del);
        view = new android.app.p_del(cess._mth0(this._cls1.this));
        view.ForumHpAdapter("Peringatan");
        view.ForumHpAdapter("Hapus perangkat ini dari favorit?");
        view.ForumHpAdapter("Ya", new android.content.DialogInterface.OnClickListener() {

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
        });
        view._mth2("Tidak", new android.content.DialogInterface.OnClickListener() {

            final IkutiForumPonsel.ListForumHpAdapter._cls2 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$2 = IkutiForumPonsel.ListForumHpAdapter._cls2.this;
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
