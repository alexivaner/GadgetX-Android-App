// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import com.google.android.gms.maps.model.Marker;
import com.inponsel.android.utils.Log;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import java.io.UnsupportedEncodingException;

// Referenced classes of package com.inponsel.android.v2:
//            RoomShareLocationActivity

class val.latlng
    implements android.content.r
{

    final om_id this$1;
    private final String val$address;
    private final String val$latlng;
    private final String val$name;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        try
        {
            progbar_location.setVisibility(0);
            RoomShareLocationActivity.access$1(_fld0, id_from, codename, (new StringBuilder(String.valueOf(val$name))).append("\n").append(val$address).append("\n").append(val$latlng).toString(), "", t, bottom_id);
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
        val$name = s;
        val$address = s1;
        val$latlng = String.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/RoomShareLocationActivity$2

/* anonymous class */
    class RoomShareLocationActivity._cls2
        implements com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener
    {

        final RoomShareLocationActivity this$0;

        public void onInfoWindowClick(Marker marker)
        {
            final String name = marker.getTitle();
            final String address = marker.getSnippet().split("\n")[0];
            marker = marker.getSnippet().split("\n")[1];
            Log.e("url", (new StringBuilder(String.valueOf(id_from))).append("-").append(codename).append("-").append(name).append("\n").append(address).append("\n").append(marker).append("-").append(marker).append("-").append(t).append("-").append(bottom_id).toString());
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(RoomShareLocationActivity.this);
            builder.setTitle("Kirim Lokasi");
            builder.setMessage((new StringBuilder(String.valueOf(name))).append("\n").append(address).append("\n").append(marker).toString());
            builder.setPositiveButton("Kirim", marker. new RoomShareLocationActivity._cls2._cls1());
            builder.setNegativeButton("Batal", new RoomShareLocationActivity._cls2._cls2());
            builder.show();
        }


            
            {
                this$0 = RoomShareLocationActivity.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/RoomShareLocationActivity$2$2

/* anonymous class */
        class RoomShareLocationActivity._cls2._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final RoomShareLocationActivity._cls2 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = RoomShareLocationActivity._cls2.this;
                        super();
                    }
        }

    }

}
