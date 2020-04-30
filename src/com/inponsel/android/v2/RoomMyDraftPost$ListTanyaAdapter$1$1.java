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

class this._cls2
    implements android.content.ter._cls1._cls1
{

    final is._cls1 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        ss._mth0(_fld1).statdel = "0";
        _fld1.delete_byARTID(_fld1.getRoom_date(), _fld1.getRoom_title());
        ss._mth0(_fld1).onResume();
    }

    l.position()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/RoomMyDraftPost$ListTanyaAdapter$1

/* anonymous class */
    class RoomMyDraftPost.ListTanyaAdapter._cls1
        implements android.view.View.OnClickListener
    {

        final RoomMyDraftPost.ListTanyaAdapter this$1;
        private final int val$position;

        public void onClick(View view)
        {
            RoomMyDraftPost.ListTanyaAdapter.access$0(RoomMyDraftPost.ListTanyaAdapter.this).id_del = getListModel(position).getId_content();
            Log.e("id_hp_del", RoomMyDraftPost.ListTanyaAdapter.access$0(RoomMyDraftPost.ListTanyaAdapter.this).id_del);
            view = new android.app.AlertDialog.Builder(RoomMyDraftPost.ListTanyaAdapter.access$0(RoomMyDraftPost.ListTanyaAdapter.this));
            view.setTitle("Peringatan");
            view.setMessage("Hapus pertanyaan ini?");
            view.setPositiveButton("Ya", new RoomMyDraftPost.ListTanyaAdapter._cls1._cls1());
            view.setNegativeButton("Tidak", new RoomMyDraftPost.ListTanyaAdapter._cls1._cls2());
            view.show();
        }


            
            {
                this$1 = final_listtanyaadapter;
                position = I.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/RoomMyDraftPost$ListTanyaAdapter$1$2

/* anonymous class */
        class RoomMyDraftPost.ListTanyaAdapter._cls1._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final RoomMyDraftPost.ListTanyaAdapter._cls1 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = RoomMyDraftPost.ListTanyaAdapter._cls1.this;
                        super();
                    }
        }

    }

}
