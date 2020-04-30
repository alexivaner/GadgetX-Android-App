// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import com.google.android.gms.maps.model.Marker;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import java.io.UnsupportedEncodingException;

// Referenced classes of package com.inponsel.android.v2:
//            RoomShareLocationActivity

class this._cls2
    implements android.content.ask._cls1._cls2
{

    final this._cls2 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    is._cls1()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/RoomShareLocationActivity$ReverseGeocodingTask$1

/* anonymous class */
    class RoomShareLocationActivity.ReverseGeocodingTask._cls1
        implements com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener
    {

        final RoomShareLocationActivity.ReverseGeocodingTask this$1;

        public void onInfoWindowClick(Marker marker)
        {
            nameAddress = marker.getTitle();
            marker = new android.app.AlertDialog.Builder(RoomShareLocationActivity.ReverseGeocodingTask.access$2(RoomShareLocationActivity.ReverseGeocodingTask.this));
            marker.setTitle("Kirim Lokasi");
            if (nameAddress.equals(""))
            {
                nameAddress = String.valueOf((new StringBuilder()).append(RoomShareLocationActivity.ReverseGeocodingTask.access$2(RoomShareLocationActivity.ReverseGeocodingTask.this).getlatitude).append(",").append(RoomShareLocationActivity.ReverseGeocodingTask.access$2(RoomShareLocationActivity.ReverseGeocodingTask.this).getlongitude).toString());
                marker.setMessage(nameAddress);
            } else
            {
                marker.setMessage((new StringBuilder(String.valueOf(nameAddress))).append("\n").append(String.valueOf((new StringBuilder()).append(RoomShareLocationActivity.ReverseGeocodingTask.access$2(RoomShareLocationActivity.ReverseGeocodingTask.this).getlatitude).append(",").append(RoomShareLocationActivity.ReverseGeocodingTask.access$2(RoomShareLocationActivity.ReverseGeocodingTask.this).getlongitude).toString())).toString());
            }
            marker.setPositiveButton("Kirim", new RoomShareLocationActivity.ReverseGeocodingTask._cls1._cls1());
            marker.setNegativeButton("Batal", new RoomShareLocationActivity.ReverseGeocodingTask._cls1._cls2());
            marker.show();
        }


            
            {
                this$1 = RoomShareLocationActivity.ReverseGeocodingTask.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/RoomShareLocationActivity$ReverseGeocodingTask$1$1

/* anonymous class */
        class RoomShareLocationActivity.ReverseGeocodingTask._cls1._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final RoomShareLocationActivity.ReverseGeocodingTask._cls1 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                try
                {
                    RoomShareLocationActivity.ReverseGeocodingTask.access$2(this$1).progbar_location.setVisibility(0);
                    RoomShareLocationActivity.access$1(RoomShareLocationActivity.ReverseGeocodingTask.access$2(this$1), RoomShareLocationActivity.ReverseGeocodingTask.access$2(this$1).id_from, RoomShareLocationActivity.ReverseGeocodingTask.access$2(this$1).codename, (new StringBuilder(String.valueOf(nameAddress))).append("\n").append(String.valueOf((new StringBuilder()).append(RoomShareLocationActivity.ReverseGeocodingTask.access$2(this$1).getlatitude).append(",").append(RoomShareLocationActivity.ReverseGeocodingTask.access$2(this$1).getlongitude).toString())).toString(), "", RoomShareLocationActivity.ReverseGeocodingTask.access$2(this$1).t, RoomShareLocationActivity.ReverseGeocodingTask.access$2(this$1).bottom_id);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (DialogInterface dialoginterface)
                {
                    dialoginterface.printStackTrace();
                }
            }

                    
                    {
                        this$2 = RoomShareLocationActivity.ReverseGeocodingTask._cls1.this;
                        super();
                    }
        }

    }

}
