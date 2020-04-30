// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.pencariangen;

import android.view.View;

// Referenced classes of package com.inponsel.android.pencariangen:
//            Hal3PencNews

class this._cls0
    implements android.view.tener
{

    final Hal3PencNews this$0;

    public void onClick(View view)
    {
        try
        {
            view = Hal3PencNews.this;
            view.limit = ((Hal3PencNews) (view)).limit + 1;
            SearchTask();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return;
        }
    }

    ()
    {
        this$0 = Hal3PencNews.this;
        super();
    }
}
