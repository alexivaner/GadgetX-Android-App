// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.internal;

import android.content.Intent;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;

// Referenced classes of package com.facebook.share.internal:
//            LikeActionController

static final class val.data
    implements eationCallback
{

    final Intent val$data;
    final int val$requestCode;
    final int val$resultCode;

    public void onComplete(LikeActionController likeactioncontroller, FacebookException facebookexception)
    {
        if (facebookexception == null)
        {
            LikeActionController.access$000(likeactioncontroller, val$requestCode, val$resultCode, val$data);
            return;
        } else
        {
            Utility.logd(LikeActionController.access$100(), facebookexception);
            return;
        }
    }

    eationCallback(int i, int j, Intent intent)
    {
        val$requestCode = i;
        val$resultCode = j;
        val$data = intent;
        super();
    }
}
