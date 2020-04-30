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

    // Unreferenced inner class com/inponsel/android/favorit/IkutiForumPonsel$ListSearchAdapter$2

/* anonymous class */
    class IkutiForumPonsel.ListSearchAdapter._cls2
        implements android.view.View.OnClickListener
    {

        final IkutiForumPonsel.ListSearchAdapter this$1;
        private final int val$position;

        public void onClick(View view)
        {
            IkutiForumPonsel.ListSearchAdapter.access$0(IkutiForumPonsel.ListSearchAdapter.this).id_hp_del = getListModel(position).getUni_id();
            IkutiForumPonsel.ListSearchAdapter.access$0(IkutiForumPonsel.ListSearchAdapter.this).uni_type = getListModel(position).getUni_type();
            Log.e("id_hp_del", IkutiForumPonsel.ListSearchAdapter.access$0(IkutiForumPonsel.ListSearchAdapter.this).id_hp_del);
            view = new android.app.AlertDialog.Builder(IkutiForumPonsel.ListSearchAdapter.access$0(IkutiForumPonsel.ListSearchAdapter.this));
            view.setTitle("Peringatan");
            view.setMessage("Ikuti aktifitas forum ponsel ini?");
            view.setPositiveButton("Ya", new IkutiForumPonsel.ListSearchAdapter._cls2._cls1());
            view.setNegativeButton("Tidak", new IkutiForumPonsel.ListSearchAdapter._cls2._cls2());
            view.show();
        }


            
            {
                this$1 = final_listsearchadapter;
                position = I.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/favorit/IkutiForumPonsel$ListSearchAdapter$2$1

/* anonymous class */
        class IkutiForumPonsel.ListSearchAdapter._cls2._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final IkutiForumPonsel.ListSearchAdapter._cls2 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                IkutiForumPonsel.ListSearchAdapter.access$0(this$1).statdel = "1";
                if (IkutiForumPonsel.ListSearchAdapter.access$0(this$1).netInfo != null && IkutiForumPonsel.ListSearchAdapter.access$0(this$1).netInfo.isConnected())
                {
                    (new IkutiForumPonsel.ListSearchAdapter.AddDelSearchTask(this$1)).execute(new Void[0]);
                    return;
                } else
                {
                    Toast.makeText(IkutiForumPonsel.ListSearchAdapter.access$0(this$1), "Tidak ada koneksi internet", 1).show();
                    return;
                }
            }

                    
                    {
                        this$2 = IkutiForumPonsel.ListSearchAdapter._cls2.this;
                        super();
                    }
        }

    }

}
