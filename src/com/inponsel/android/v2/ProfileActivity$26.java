// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.os.AsyncTask;
import android.view.View;
import java.net.URL;

// Referenced classes of package com.inponsel.android.v2:
//            ProfileActivity

class this._cls0
    implements android.view.r
{

    final ProfileActivity this$0;

    public void onClick(View view)
    {
        if (android.os.NT >= 11)
        {
            (new oadImage(ProfileActivity.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new URL[0]);
            return;
        } else
        {
            (new oadImage(ProfileActivity.this)).execute(new URL[0]);
            return;
        }
    }

    oadImage()
    {
        this$0 = ProfileActivity.this;
        super();
    }
}
