// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.view.View;

// Referenced classes of package com.inponsel.android.v2:
//            BaseDrawer

class this._cls1
    implements Runnable
{

    final this._cls1 this$1;

    public void run()
    {
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/BaseDrawer$14

/* anonymous class */
    class BaseDrawer._cls14
        implements android.view.View.OnClickListener
    {

        final BaseDrawer this$0;

        public void onClick(View view)
        {
            mDrawerLayout.closeDrawers();
            (new Handler()).postDelayed(new BaseDrawer._cls14._cls1(), 250L);
        }

            
            {
                this$0 = BaseDrawer.this;
                super();
            }
    }

}
