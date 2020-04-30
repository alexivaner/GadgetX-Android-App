// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.location.Address;
import android.view.View;
import com.inponsel.android.utils.Log;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import java.io.UnsupportedEncodingException;
import java.util.List;

// Referenced classes of package com.inponsel.android.v2:
//            RoomShareLocationActivity

class this._cls0
    implements android.view.Activity._cls5
{

    String address;
    final RoomShareLocationActivity this$0;

    public void onClick(final View latlng)
    {
        Object obj;
        if (addresses != null && addresses.size() > 0)
        {
            obj = (Address)addresses.get(0);
            RoomShareLocationActivity roomsharelocationactivity = RoomShareLocationActivity.this;
            if (((Address) (obj)).getMaxAddressLineIndex() > 0)
            {
                latlng = ((Address) (obj)).getAddressLine(0);
            } else
            {
                latlng = "";
            }
            roomsharelocationactivity.addressText = String.format("%s, %s, %s", new Object[] {
                latlng, ((Address) (obj)).getLocality(), ((Address) (obj)).getCountryName()
            });
        }
        address = addressText;
        latlng = String.valueOf((new StringBuilder(String.valueOf(latitude))).append(",").append(longitude).toString());
        Log.e("url", (new StringBuilder(String.valueOf(id_from))).append("-").append(codename).append("-").append(address).append("\n").append(latlng).append("-").append(latlng).append("-").append(t).append("-").append(bottom_id).toString());
        obj = new android.app.nActivity.bottom_id(RoomShareLocationActivity.this);
        ((android.app.nActivity) (obj)).("Kirim Lokasi");
        if (address.equals("") || address.toLowerCase().contains("unknown"))
        {
            ((android.app.nActivity._cls5.address) (obj)).ge(latlng);
            address = String.valueOf((new StringBuilder()).append(getlatitude).append(",").append(getlongitude).toString());
        } else
        {
            ((android.app.nActivity.getlongitude) (obj)).ge((new StringBuilder(String.valueOf(address))).append("\n").append(latlng).toString());
        }
        ((android.app.nActivity._cls5.address) (obj)).iveButton("Kirim", new android.content.DialogInterface.OnClickListener() {

            final RoomShareLocationActivity._cls5 this$1;
            private final String val$latlng;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                progbar_location.setVisibility(0);
                if (address.equals("") || address.toLowerCase().contains("unknown"))
                {
                    RoomShareLocationActivity.access$1(this$0, id_from, codename, latlng, "", t, bottom_id);
                    return;
                }
                try
                {
                    RoomShareLocationActivity.access$1(this$0, id_from, codename, (new StringBuilder(String.valueOf(address))).append("\n").append(latlng).toString(), "", t, bottom_id);
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
                this$1 = RoomShareLocationActivity._cls5.this;
                latlng = s;
                super();
            }
        });
        ((android.app.nActivity._cls5) (obj)).iveButton("Batal", new android.content.DialogInterface.OnClickListener() {

            final RoomShareLocationActivity._cls5 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$1 = RoomShareLocationActivity._cls5.this;
                super();
            }
        });
        ((android.app.nActivity._cls5) (obj))._mth5();
    }


    _cls2.this._cls1()
    {
        this$0 = RoomShareLocationActivity.this;
        super();
    }
}
