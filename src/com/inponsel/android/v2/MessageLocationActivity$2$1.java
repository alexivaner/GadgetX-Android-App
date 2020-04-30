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

class val.name
    implements android.content.ner
{

    final  this$1;
    private final String val$name;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        try
        {
            progbar_location.setVisibility(0);
            MessageLocationActivity.access$1(_fld0, id_from, id_to, val$name, "", t, bottom_id);
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
        val$name = String.this;
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
            String s = marker.getTitle();
            marker = marker.getSnippet().split("-")[0];
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(MessageLocationActivity.this);
            builder.setTitle("Kirim Lokasi");
            builder.setMessage((new StringBuilder(String.valueOf(s))).append("\n").append(marker).append("\n").append(String.valueOf((new StringBuilder()).append(getlatitude).append(",").append(getlongitude).toString())).toString());
            builder.setPositiveButton("Kirim", s. new MessageLocationActivity._cls2._cls1());
            builder.setNegativeButton("Batal", new MessageLocationActivity._cls2._cls2());
            builder.show();
        }


            
            {
                this$0 = MessageLocationActivity.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/MessageLocationActivity$2$2

/* anonymous class */
        class MessageLocationActivity._cls2._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final MessageLocationActivity._cls2 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = MessageLocationActivity._cls2.this;
                        super();
                    }
        }

    }

}
