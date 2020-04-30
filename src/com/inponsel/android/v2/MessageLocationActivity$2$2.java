// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import com.google.android.gms.maps.model.Marker;
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

    // Unreferenced inner class com/inponsel/android/v2/MessageLocationActivity$2

/* anonymous class */
    class MessageLocationActivity._cls2
        implements com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener
    {

        final MessageLocationActivity this$0;

        public void onInfoWindowClick(Marker marker)
        {
            final String name = marker.getTitle();
            marker = marker.getSnippet().split("-")[0];
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(MessageLocationActivity.this);
            builder.setTitle("Kirim Lokasi");
            builder.setMessage((new StringBuilder(String.valueOf(name))).append("\n").append(marker).append("\n").append(String.valueOf((new StringBuilder()).append(getlatitude).append(",").append(getlongitude).toString())).toString());
            builder.setPositiveButton("Kirim", new MessageLocationActivity._cls2._cls1());
            builder.setNegativeButton("Batal", new MessageLocationActivity._cls2._cls2());
            builder.show();
        }


            
            {
                this$0 = MessageLocationActivity.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/MessageLocationActivity$2$1

/* anonymous class */
        class MessageLocationActivity._cls2._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final MessageLocationActivity._cls2 this$1;
            private final String val$name;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                try
                {
                    progbar_location.setVisibility(0);
                    MessageLocationActivity.access$1(this$0, id_from, id_to, name, "", t, bottom_id);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (DialogInterface dialoginterface)
                {
                    dialoginterface.printStackTrace();
                }
            }

                    
                    {
                        this$1 = MessageLocationActivity._cls2.this;
                        name = s;
                        super();
                    }
        }

    }

}
