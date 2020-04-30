// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.os.AsyncTask;

// Referenced classes of package com.inponsel.android.v2:
//            HomeGadgetActivity

private class cancellableTask
    implements android.content.istener
{

    AsyncTask cancellableTask;
    final HomeGadgetActivity this$0;

    public void onCancel(DialogInterface dialoginterface)
    {
        cancellableTask.cancel(true);
    }

    public (AsyncTask asynctask)
    {
        this$0 = HomeGadgetActivity.this;
        super();
        cancellableTask = asynctask;
    }
}
