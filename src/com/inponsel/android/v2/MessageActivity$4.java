// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.PopupWindow;
import com.inponsel.android.widget.DroidWriterEditText;

// Referenced classes of package com.inponsel.android.v2:
//            MessageActivity

class this._cls0
    implements android.view.er
{

    final MessageActivity this$0;

    public void onClick(View view)
    {
        popupWindow.dismiss();
        imm = (InputMethodManager)getSystemService("input_method");
        imm.hideSoftInputFromWindow(edt_pop_komen.getWindowToken(), 0);
        MessageActivity.access$6(MessageActivity.this, MessageActivity.access$5(MessageActivity.this));
        MessageActivity.access$6(MessageActivity.this, MessageActivity.access$7(MessageActivity.this));
        MessageActivity.access$9(MessageActivity.this);
    }

    tText()
    {
        this$0 = MessageActivity.this;
        super();
    }
}
