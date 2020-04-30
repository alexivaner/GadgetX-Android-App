// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.location.Address;
import android.view.View;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import java.io.UnsupportedEncodingException;
import java.util.List;

// Referenced classes of package com.inponsel.android.v2:
//            MessageLocationActivity

class this._cls0
    implements android.view.Activity._cls5
{

    String address;
    final MessageLocationActivity this$0;

    public void onClick(View view)
    {
        Object obj;
        if (addresses != null && addresses.size() > 0)
        {
            obj = (Address)addresses.get(0);
            MessageLocationActivity messagelocationactivity = MessageLocationActivity.this;
            if (((Address) (obj)).getMaxAddressLineIndex() > 0)
            {
                view = ((Address) (obj)).getAddressLine(0);
            } else
            {
                view = "";
            }
            messagelocationactivity.addressText = String.format("%s, %s, %s", new Object[] {
                view, ((Address) (obj)).getLocality(), ((Address) (obj)).getCountryName()
            });
        }
        address = addressText;
        view = String.valueOf((new StringBuilder(String.valueOf(latitude))).append(",").append(longitude).toString());
        obj = new android.app.(MessageLocationActivity.this);
        ((android.app.nActivity) (obj)).le("Kirim Lokasi");
        if (address.equals("") || address.toLowerCase().contains("unknown"))
        {
            ((android.app.nActivity._cls5.address) (obj)).sage(address);
        } else
        {
            ((android.app.nActivity._cls5.address) (obj)).sage((new StringBuilder(String.valueOf(address))).append("\n").append(view).toString());
        }
        ((android.app.nActivity._cls5.address) (obj)).itiveButton("Kirim", new android.content.DialogInterface.OnClickListener() {

            final MessageLocationActivity._cls5 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                progbar_location.setVisibility(0);
                if (address.equals("") || address.toLowerCase().contains("unknown"))
                {
                    MessageLocationActivity.access$1(this$0, id_from, id_to, String.valueOf((new StringBuilder()).append(getlatitude).append(",").append(getlongitude).toString()), "", t, bottom_id);
                    return;
                }
                try
                {
                    MessageLocationActivity.access$1(this$0, id_from, id_to, (new StringBuilder(String.valueOf(address))).append("\n").append(String.valueOf((new StringBuilder(String.valueOf(latitude))).append(",").append(longitude).toString())).toString(), "", t, bottom_id);
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
                this$1 = MessageLocationActivity._cls5.this;
                super();
            }
        });
        ((android.app.nActivity._cls5) (obj)).ativeButton("Batal", new android.content.DialogInterface.OnClickListener() {

            final MessageLocationActivity._cls5 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$1 = MessageLocationActivity._cls5.this;
                super();
            }
        });
        ((android.app.nActivity._cls5) (obj))._mth5();
    }


    _cls2.this._cls1()
    {
        this$0 = MessageLocationActivity.this;
        super();
    }
}
