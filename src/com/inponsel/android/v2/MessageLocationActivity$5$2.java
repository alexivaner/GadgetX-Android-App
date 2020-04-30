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

    // Unreferenced inner class com/inponsel/android/v2/MessageLocationActivity$5

/* anonymous class */
    class MessageLocationActivity._cls5
        implements android.view.View.OnClickListener
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
            obj = new android.app.AlertDialog.Builder(MessageLocationActivity.this);
            ((android.app.AlertDialog.Builder) (obj)).setTitle("Kirim Lokasi");
            if (address.equals("") || address.toLowerCase().contains("unknown"))
            {
                ((android.app.AlertDialog.Builder) (obj)).setMessage(address);
            } else
            {
                ((android.app.AlertDialog.Builder) (obj)).setMessage((new StringBuilder(String.valueOf(address))).append("\n").append(view).toString());
            }
            ((android.app.AlertDialog.Builder) (obj)).setPositiveButton("Kirim", new MessageLocationActivity._cls5._cls1());
            ((android.app.AlertDialog.Builder) (obj)).setNegativeButton("Batal", new MessageLocationActivity._cls5._cls2());
            ((android.app.AlertDialog.Builder) (obj)).show();
        }


            
            {
                this$0 = MessageLocationActivity.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/MessageLocationActivity$5$1

/* anonymous class */
        class MessageLocationActivity._cls5._cls1
            implements android.content.DialogInterface.OnClickListener
        {

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
        }

    }

}
