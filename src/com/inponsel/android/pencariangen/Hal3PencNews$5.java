// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.pencariangen;

import com.android.volley.VolleyError;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.pencariangen:
//            Hal3PencNews

class this._cls0
    implements com.android.volley.istener
{

    final Hal3PencNews this$0;

    public void onErrorResponse(VolleyError volleyerror)
    {
        Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
        Hal3PencNews.access$2(Hal3PencNews.this);
    }

    ()
    {
        this$0 = Hal3PencNews.this;
        super();
    }
}