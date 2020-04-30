// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;

// Referenced classes of package com.inponsel.android.v2:
//            LoginActivity

class this._cls0
    implements android.content.OnCancelListener
{

    final LoginActivity this$0;

    public void onCancel(DialogInterface dialoginterface)
    {
        if (loginTask != null && loginTask.getStatus() != android.os..FINISHED)
        {
            loginTask.cancel(true);
        }
    }

    ginTask()
    {
        this$0 = LoginActivity.this;
        super();
    }
}
