// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.view.View;
import android.widget.PopupWindow;

// Referenced classes of package com.inponsel.android.v2:
//            MessageActivity, MessageLocationActivity

class this._cls0
    implements android.view.er
{

    final MessageActivity this$0;

    public void onClick(View view)
    {
        view = new Intent(getApplicationContext(), com/inponsel/android/v2/MessageLocationActivity);
        view.putExtra("id_msg", id_msg);
        view.putExtra("id_from", id_from);
        view.putExtra("from_name", from_name);
        view.putExtra("from_photo", from_photo);
        view.putExtra("id_to", id_to);
        view.putExtra("to_name", to_name);
        view.putExtra("to_photo", to_photo);
        view.putExtra("last_message", last_message);
        view.putExtra("message_type", message_type);
        view.putExtra("unread_msg", unread_msg);
        view.putExtra("msg_date", msg_date);
        view.putExtra("bottom_id", bottom_id);
        startActivityForResult(view, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
        popupWindow.dismiss();
    }

    ivity()
    {
        this$0 = MessageActivity.this;
        super();
    }
}
