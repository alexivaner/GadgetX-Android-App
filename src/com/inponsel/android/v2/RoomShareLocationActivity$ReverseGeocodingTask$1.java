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

class this._cls1
    implements com.google.android.gms.maps.._cls1
{

    final _cls2 this$1;

    public void onInfoWindowClick(Marker marker)
    {
        meAddress = marker.getTitle();
        marker = new android.app.odingTask.nameAddress(cess._mth2(this._cls1.this));
        marker.odingTask("Kirim Lokasi");
        if (meAddress.equals(""))
        {
            meAddress = String.valueOf((new StringBuilder()).append(cess._mth2(this._cls1.this).getlatitude).append(",").append(cess._mth2(this._cls1.this).getlongitude).toString());
            marker.e(meAddress);
        } else
        {
            marker.nameAddress((new StringBuilder(String.valueOf(meAddress))).append("\n").append(String.valueOf((new StringBuilder()).append(cess._mth2(this._cls1.this).getlatitude).append(",").append(cess._mth2(this._cls1.this).getlongitude).toString())).toString());
        }
        marker.e("Kirim", new android.content.DialogInterface.OnClickListener() {

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
        });
        marker._mth1("Batal", new android.content.DialogInterface.OnClickListener() {

            final RoomShareLocationActivity.ReverseGeocodingTask._cls1 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$2 = RoomShareLocationActivity.ReverseGeocodingTask._cls1.this;
                super();
            }
        });
        marker._mth1();
    }


    _cls2.this._cls2()
    {
        this$1 = this._cls1.this;
        super();
    }
}
