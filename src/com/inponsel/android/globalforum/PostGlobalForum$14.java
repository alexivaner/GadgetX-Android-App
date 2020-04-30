// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.globalforum;

import android.app.Dialog;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

// Referenced classes of package com.inponsel.android.globalforum:
//            PostGlobalForum

class this._cls0
    implements android.view.r
{

    final PostGlobalForum this$0;

    public void onClick(View view)
    {
        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edtAuto.getWindowToken(), 0);
        dialog.dismiss();
    }

    _cls9()
    {
        this$0 = PostGlobalForum.this;
        super();
    }
}
