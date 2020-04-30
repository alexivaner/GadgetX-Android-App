// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import com.inponsel.android.favorit.IkutiForumPonsel;

// Referenced classes of package com.inponsel.android.v2:
//            BaseDrawer

class this._cls1
    implements Runnable
{

    final ridePendingTransition this$1;

    public void run()
    {
        i = new Intent(getApplicationContext(), com/inponsel/android/favorit/IkutiForumPonsel);
        startActivityForResult(i, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/BaseDrawer$3

/* anonymous class */
    class BaseDrawer._cls3
        implements android.view.View.OnClickListener
    {

        final BaseDrawer this$0;

        public void onClick(View view)
        {
            mDrawerLayout.closeDrawers();
            (new Handler()).postDelayed(new BaseDrawer._cls3._cls1(), 250L);
        }


            
            {
                this$0 = BaseDrawer.this;
                super();
            }
    }

}
