// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.res.Resources;
import android.widget.Button;
import com.actionbarsherlock.view.MenuItem;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.Log;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            RoomChatActivity

class this._cls0
    implements com.android.volley.y._cls36
{

    final RoomChatActivity this$0;

    public volatile void onResponse(Object obj)
    {
        onResponse((JSONObject)obj);
    }

    public void onResponse(JSONObject jsonobject)
    {
        Log.e("responseGroup", jsonobject.toString());
        if (jsonobject.toString().trim().equals("{\"response\":1}"))
        {
            btn_JoinGroupChat.setBackgroundResource(0x7f02013b);
            btn_JoinGroupChat.setText("Hapus");
            btn_JoinGroupChat.setTextColor(getResources().getColor(0x7f080182));
            itemTurnNotif.setChecked(true);
        } else
        {
            db.delete_groupchat(codename);
            btn_JoinGroupChat.setBackgroundResource(0x7f02013a);
            btn_JoinGroupChat.setText("Ikuti");
            btn_JoinGroupChat.setTextColor(getResources().getColor(0x7f080181));
            itemTurnNotif.setChecked(false);
        }
        ponselBaseApp.getObserver().setLoginStat("1");
    }

    ()
    {
        this$0 = RoomChatActivity.this;
        super();
    }
}
