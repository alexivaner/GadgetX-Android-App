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
//            MessageLocationActivity

class this._cls1
    implements android.content.ner
{

    final this._cls1 this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/MessageLocationActivity$3

/* anonymous class */
    class MessageLocationActivity._cls3
        implements android.widget.AdapterView.OnItemClickListener
    {

        final MessageLocationActivity this$0;

        public void onItemClick(final AdapterView message, View view, int i, long l)
        {
            message = (new StringBuilder(String.valueOf(userJoinAdapter.getListModel(i).getPlaces()))).append("\n").append(userJoinAdapter.getListModel(i).getAddress()).append("\n").append(userJoinAdapter.getListModel(i).getLatitude()).append(",").append(userJoinAdapter.getListModel(i).getLongitude()).toString();
            view = new android.app.AlertDialog.Builder(MessageLocationActivity.this);
            view.setTitle("Kirim Lokasi");
            view.setMessage(message);
            view.setPositiveButton("Kirim", new MessageLocationActivity._cls3._cls1());
            view.setNegativeButton("Batal", new MessageLocationActivity._cls3._cls2());
            view.show();
        }


            
            {
                this$0 = MessageLocationActivity.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/MessageLocationActivity$3$1

/* anonymous class */
        class MessageLocationActivity._cls3._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final MessageLocationActivity._cls3 this$1;
            private final String val$message;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                try
                {
                    progbar_location.setVisibility(0);
                    MessageLocationActivity.access$1(this$0, id_from, id_to, message, "", t, bottom_id);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (DialogInterface dialoginterface)
                {
                    dialoginterface.printStackTrace();
                }
            }

                    
                    {
                        this$1 = MessageLocationActivity._cls3.this;
                        message = s;
                        super();
                    }
        }

    }

}
