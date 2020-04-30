// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.PopupWindow;
import com.inponsel.android.widget.DroidWriterEditText;

// Referenced classes of package com.inponsel.android.v2:
//            RoomChatActivity

class this._cls0
    implements android.view.r
{

    final RoomChatActivity this$0;

    public void onClick(View view)
    {
        popupWindow.dismiss();
        imm = (InputMethodManager)getSystemService("input_method");
        imm.hideSoftInputFromWindow(edt_pop_komen.getWindowToken(), 0);
        RoomChatActivity.access$10(RoomChatActivity.this, RoomChatActivity.access$9(RoomChatActivity.this));
        RoomChatActivity.access$10(RoomChatActivity.this, RoomChatActivity.access$11(RoomChatActivity.this));
        RoomChatActivity.access$13(RoomChatActivity.this);
    }

    Text()
    {
        this$0 = RoomChatActivity.this;
        super();
    }
}
