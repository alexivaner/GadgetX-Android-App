// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.view.View;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.v2:
//            RoomMyDraftPost

class val.position
    implements android.view.aAdapter._cls1
{

    final _cls2 this$1;
    private final int val$position;

    public void onClick(View view)
    {
        cess._mth0(this._cls1.this).id_del = tListModel(val$position).getId_content();
        Log.e("id_hp_del", cess._mth0(this._cls1.this).id_del);
        view = new android.app.yaAdapter(cess._mth0(this._cls1.this));
        view.yaAdapter("Peringatan");
        view.yaAdapter("Hapus pertanyaan ini?");
        view.on("Ya", new android.content.DialogInterface.OnClickListener() {

            final RoomMyDraftPost.ListTanyaAdapter._cls1 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                RoomMyDraftPost.ListTanyaAdapter.access$0(this$1).statdel = "0";
                db.delete_byARTID(lms.getRoom_date(), lms.getRoom_title());
                RoomMyDraftPost.ListTanyaAdapter.access$0(this$1).onResume();
            }

            
            {
                this$2 = RoomMyDraftPost.ListTanyaAdapter._cls1.this;
                super();
            }
        });
        view.on("Tidak", new android.content.DialogInterface.OnClickListener() {

            final RoomMyDraftPost.ListTanyaAdapter._cls1 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$2 = RoomMyDraftPost.ListTanyaAdapter._cls1.this;
                super();
            }
        });
        view._mth1();
    }


    _cls2.this._cls2()
    {
        this$1 = final__pcls2;
        val$position = I.this;
        super();
    }
}
