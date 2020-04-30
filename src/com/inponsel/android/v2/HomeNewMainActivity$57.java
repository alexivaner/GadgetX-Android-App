// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.widget.LinearLayout;
import android.widget.TextView;
import fr.castorflex.android.circularprogressbar.CircularProgressBar;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewMainActivity

class this._cls0
    implements Runnable
{

    final HomeNewMainActivity this$0;

    public void run()
    {
        progressbar_segmen4.setVisibility(8);
        HomeNewMainActivity.access$4(HomeNewMainActivity.this);
        txt_home_inponsel.setVisibility(8);
        load_image_menu_bottom();
        ll_segmen_4.setVisibility(0);
    }

    larProgressBar()
    {
        this$0 = HomeNewMainActivity.this;
        super();
    }
}
