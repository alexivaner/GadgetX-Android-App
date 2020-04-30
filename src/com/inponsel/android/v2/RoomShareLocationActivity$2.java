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

class this._cls0
    implements com.google.android.gms.maps.istener
{

    final RoomShareLocationActivity this$0;

    public void onInfoWindowClick(final Marker latlng)
    {
        final String name = latlng.getTitle();
        final String address = latlng.getSnippet().split("\n")[0];
        latlng = latlng.getSnippet().split("\n")[1];
        Log.e("url", (new StringBuilder(String.valueOf(id_from))).append("-").append(codename).append("-").append(name).append("\n").append(address).append("\n").append(latlng).append("-").append(latlng).append("-").append(t).append("-").append(bottom_id).toString());
        android.app.istener istener = new android.app.nActivity.bottom_id(RoomShareLocationActivity.this);
        istener.("Kirim Lokasi");
        istener.ge((new StringBuilder(String.valueOf(name))).append("\n").append(address).append("\n").append(latlng).toString());
        istener.iveButton("Kirim", new android.content.DialogInterface.OnClickListener() {

            final RoomShareLocationActivity._cls2 this$1;
            private final String val$address;
            private final String val$latlng;
            private final String val$name;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                try
                {
                    progbar_location.setVisibility(0);
                    RoomShareLocationActivity.access$1(this$0, id_from, codename, (new StringBuilder(String.valueOf(name))).append("\n").append(address).append("\n").append(latlng).toString(), "", t, bottom_id);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (DialogInterface dialoginterface)
                {
                    dialoginterface.printStackTrace();
                }
            }

            
            {
                this$1 = RoomShareLocationActivity._cls2.this;
                name = s;
                address = s1;
                latlng = s2;
                super();
            }
        });
        istener.iveButton("Batal", new android.content.DialogInterface.OnClickListener() {

            final RoomShareLocationActivity._cls2 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$1 = RoomShareLocationActivity._cls2.this;
                super();
            }
        });
        istener._mth2();
    }


    _cls2.this._cls1()
    {
        this$0 = RoomShareLocationActivity.this;
        super();
    }
}
