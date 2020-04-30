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

class this._cls1
    implements android.content.r
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

    // Unreferenced inner class com/inponsel/android/v2/RoomShareLocationActivity$5

/* anonymous class */
    class RoomShareLocationActivity._cls5
        implements android.view.View.OnClickListener
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
            obj = new android.app.AlertDialog.Builder(RoomShareLocationActivity.this);
            ((android.app.AlertDialog.Builder) (obj)).setTitle("Kirim Lokasi");
            if (address.equals("") || address.toLowerCase().contains("unknown"))
            {
                ((android.app.AlertDialog.Builder) (obj)).setMessage(latlng);
                address = String.valueOf((new StringBuilder()).append(getlatitude).append(",").append(getlongitude).toString());
            } else
            {
                ((android.app.AlertDialog.Builder) (obj)).setMessage((new StringBuilder(String.valueOf(address))).append("\n").append(latlng).toString());
            }
            ((android.app.AlertDialog.Builder) (obj)).setPositiveButton("Kirim", new RoomShareLocationActivity._cls5._cls1());
            ((android.app.AlertDialog.Builder) (obj)).setNegativeButton("Batal", new RoomShareLocationActivity._cls5._cls2());
            ((android.app.AlertDialog.Builder) (obj)).show();
        }


            
            {
                this$0 = RoomShareLocationActivity.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/RoomShareLocationActivity$5$1

/* anonymous class */
        class RoomShareLocationActivity._cls5._cls1
            implements android.content.DialogInterface.OnClickListener
        {

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
        }

    }

}
