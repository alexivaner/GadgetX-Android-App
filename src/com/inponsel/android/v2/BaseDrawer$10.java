// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.view.View;

// Referenced classes of package com.inponsel.android.v2:
//            BaseDrawer

class this._cls0
    implements android.view.stener
{

    final BaseDrawer this$0;

    public void onClick(View view)
    {
        mDrawerLayout.closeDrawers();
        (new Handler()).postDelayed(new Runnable() {

            final BaseDrawer._cls10 this$1;

            public void run()
            {
            }

            
            {
                this$1 = BaseDrawer._cls10.this;
                super();
            }
        }, 250L);
    }

    _cls1.this._cls1()
    {
        this$0 = BaseDrawer.this;
        super();
    }
}
