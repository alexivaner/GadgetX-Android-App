// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import com.inponsel.android.adapter.ListModel;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import java.io.UnsupportedEncodingException;

// Referenced classes of package com.inponsel.android.v2:
//            RoomShareLocationActivity

class val.message
    implements android.content.r
{

    final om_id this$1;
    private final String val$message;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        try
        {
            progbar_location.setVisibility(0);
            RoomShareLocationActivity.access$1(_fld0, id_from, codename, val$message, "", t, bottom_id);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (DialogInterface dialoginterface)
        {
            dialoginterface.printStackTrace();
        }
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$message = String.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/RoomShareLocationActivity$3

/* anonymous class */
    class RoomShareLocationActivity._cls3
        implements android.widget.AdapterView.OnItemClickListener
    {

        final RoomShareLocationActivity this$0;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            adapterview = (new StringBuilder(String.valueOf(userJoinAdapter.getListModel(i).getPlaces()))).append("\n").append(userJoinAdapter.getListModel(i).getAddress()).append("\n").append(userJoinAdapter.getListModel(i).getLatitude()).append(",").append(userJoinAdapter.getListModel(i).getLongitude()).toString();
            view = new android.app.AlertDialog.Builder(RoomShareLocationActivity.this);
            view.setTitle("Kirim Lokasi");
            view.setMessage(adapterview);
            view.setPositiveButton("Kirim", adapterview. new RoomShareLocationActivity._cls3._cls1());
            view.setNegativeButton("Batal", new RoomShareLocationActivity._cls3._cls2());
            view.show();
        }


            
            {
                this$0 = RoomShareLocationActivity.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/RoomShareLocationActivity$3$2

/* anonymous class */
        class RoomShareLocationActivity._cls3._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final RoomShareLocationActivity._cls3 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = RoomShareLocationActivity._cls3.this;
                        super();
                    }
        }

    }

}
