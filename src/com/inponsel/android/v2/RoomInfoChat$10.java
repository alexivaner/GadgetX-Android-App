// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.res.Resources;
import android.widget.Button;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.Log;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            RoomInfoChat

class this._cls0
    implements com.android.volley.r
{

    final RoomInfoChat this$0;

    public volatile void onResponse(Object obj)
    {
        onResponse((JSONObject)obj);
    }

    public void onResponse(JSONObject jsonobject)
    {
        Log.e("responseGroup", jsonobject.toString());
        if (jsonobject.toString().trim().equals("{\"response\":1}"))
        {
            btn_AktifkanNotifikasi.setBackgroundResource(0x7f02013b);
            btn_AktifkanNotifikasi.setText("Hapus");
            btn_AktifkanNotifikasi.setTextColor(getResources().getColor(0x7f080182));
            return;
        } else
        {
            db.delete_groupchat(codename);
            btn_AktifkanNotifikasi.setBackgroundResource(0x7f02013a);
            btn_AktifkanNotifikasi.setText("Ikuti");
            btn_AktifkanNotifikasi.setTextColor(getResources().getColor(0x7f080181));
            return;
        }
    }

    er()
    {
        this$0 = RoomInfoChat.this;
        super();
    }
}
