// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.view.View;
import android.widget.PopupWindow;

// Referenced classes of package com.inponsel.android.v2:
//            RoomChatActivity, RoomShareLocationActivity

class this._cls0
    implements android.view.r
{

    final RoomChatActivity this$0;

    public void onClick(View view)
    {
        view = new Intent(getApplicationContext(), com/inponsel/android/v2/RoomShareLocationActivity);
        view.putExtra("id_from", RoomChatActivity.user_id);
        view.putExtra("from_name", RoomChatActivity.username);
        view.putExtra("from_photo", RoomChatActivity.user_photo);
        view.putExtra("to_photo", gambar);
        view.putExtra("merk", merk);
        view.putExtra("model", model);
        view.putExtra("codename", codename);
        view.putExtra("id_hph", id_hp);
        view.putExtra("bottom_id", bottom_id);
        startActivityForResult(view, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
        popupWindow.dismiss();
    }

    tivity()
    {
        this$0 = RoomChatActivity.this;
        super();
    }
}
