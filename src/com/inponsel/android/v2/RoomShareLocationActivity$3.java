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

class this._cls0
    implements android.widget.ner
{

    final RoomShareLocationActivity this$0;

    public void onItemClick(final AdapterView message, View view, int i, long l)
    {
        message = (new StringBuilder(String.valueOf(userJoinAdapter.getListModel(i).getPlaces()))).append("\n").append(userJoinAdapter.getListModel(i).getAddress()).append("\n").append(userJoinAdapter.getListModel(i).getLatitude()).append(",").append(userJoinAdapter.getListModel(i).getLongitude()).toString();
        view = new android.app.etLongitude(RoomShareLocationActivity.this);
        view.("Kirim Lokasi");
        view.ge(message);
        view.iveButton("Kirim", new android.content.DialogInterface.OnClickListener() {

            final RoomShareLocationActivity._cls3 this$1;
            private final String val$message;

            public void onClick(DialogInterface dialoginterface, int j)
            {
                try
                {
                    progbar_location.setVisibility(0);
                    RoomShareLocationActivity.access$1(this$0, id_from, codename, message, "", t, bottom_id);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (DialogInterface dialoginterface)
                {
                    dialoginterface.printStackTrace();
                }
            }

            
            {
                this$1 = RoomShareLocationActivity._cls3.this;
                message = s;
                super();
            }
        });
        view.iveButton("Batal", new android.content.DialogInterface.OnClickListener() {

            final RoomShareLocationActivity._cls3 this$1;

            public void onClick(DialogInterface dialoginterface, int j)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$1 = RoomShareLocationActivity._cls3.this;
                super();
            }
        });
        view._mth3();
    }


    _cls2.this._cls1()
    {
        this$0 = RoomShareLocationActivity.this;
        super();
    }
}
