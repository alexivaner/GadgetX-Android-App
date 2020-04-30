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

class this._cls0
    implements com.google.android.gms.maps.kListener
{

    final MessageLocationActivity this$0;

    public void onInfoWindowClick(Marker marker)
    {
        final String name = marker.getTitle();
        marker = marker.getSnippet().split("-")[0];
        android.app.kListener klistener = new android.app.(MessageLocationActivity.this);
        klistener.le("Kirim Lokasi");
        klistener.sage((new StringBuilder(String.valueOf(name))).append("\n").append(marker).append("\n").append(String.valueOf((new StringBuilder()).append(getlatitude).append(",").append(getlongitude).toString())).toString());
        klistener.itiveButton("Kirim", new android.content.DialogInterface.OnClickListener() {

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
        });
        klistener.ativeButton("Batal", new android.content.DialogInterface.OnClickListener() {

            final MessageLocationActivity._cls2 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$1 = MessageLocationActivity._cls2.this;
                super();
            }
        });
        klistener._mth2();
    }


    _cls2.this._cls1()
    {
        this$0 = MessageLocationActivity.this;
        super();
    }
}
