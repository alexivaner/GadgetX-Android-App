// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.conversation;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

// Referenced classes of package com.inponsel.android.conversation:
//            ConversationPost

class this._cls0
    implements TextWatcher
{

    final ConversationPost this$0;

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        if (edtJudulAskHp.getText().length() > 5)
        {
            btnPostAskHp.setEnabled(true);
            btnSaveAskHp.setEnabled(true);
            return;
        } else
        {
            btnPostAskHp.setEnabled(false);
            btnSaveAskHp.setEnabled(false);
            return;
        }
    }

    ()
    {
        this$0 = ConversationPost.this;
        super();
    }
}
