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
    implements com.google.android.gms.maps.._cls1
{

    final _cls2 this$1;

    public void onInfoWindowClick(Marker marker)
    {
        marker = new android.app.odingTask(cess._mth2(this._cls1.this));
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

            final MessageLocationActivity.ReverseGeocodingTask._cls1 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                MessageLocationActivity.ReverseGeocodingTask.access$2(this$1).progbar_location.setVisibility(0);
                if (nameAddress.equals(""))
                {
                    MessageLocationActivity.access$1(MessageLocationActivity.ReverseGeocodingTask.access$2(this$1), MessageLocationActivity.ReverseGeocodingTask.access$2(this$1).id_from, MessageLocationActivity.ReverseGeocodingTask.access$2(this$1).id_to, String.valueOf((new StringBuilder()).append(MessageLocationActivity.ReverseGeocodingTask.access$2(this$1).getlatitude).append(",").append(MessageLocationActivity.ReverseGeocodingTask.access$2(this$1).getlongitude).toString()), "", MessageLocationActivity.ReverseGeocodingTask.access$2(this$1).t, MessageLocationActivity.ReverseGeocodingTask.access$2(this$1).bottom_id);
                    return;
                }
                try
                {
                    MessageLocationActivity.access$1(MessageLocationActivity.ReverseGeocodingTask.access$2(this$1), MessageLocationActivity.ReverseGeocodingTask.access$2(this$1).id_from, MessageLocationActivity.ReverseGeocodingTask.access$2(this$1).id_to, (new StringBuilder(String.valueOf(nameAddress))).append("\n").append(String.valueOf((new StringBuilder()).append(MessageLocationActivity.ReverseGeocodingTask.access$2(this$1).getlatitude).append(",").append(MessageLocationActivity.ReverseGeocodingTask.access$2(this$1).getlongitude).toString())).toString(), "", MessageLocationActivity.ReverseGeocodingTask.access$2(this$1).t, MessageLocationActivity.ReverseGeocodingTask.access$2(this$1).bottom_id);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (DialogInterface dialoginterface)
                {
                    dialoginterface.printStackTrace();
                }
                return;
            }

            
            {
                this$2 = MessageLocationActivity.ReverseGeocodingTask._cls1.this;
                super();
            }
        });
        marker._mth1("Batal", new android.content.DialogInterface.OnClickListener() {

            final MessageLocationActivity.ReverseGeocodingTask._cls1 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$2 = MessageLocationActivity.ReverseGeocodingTask._cls1.this;
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
