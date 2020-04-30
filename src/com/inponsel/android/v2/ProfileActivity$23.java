// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.view.View;
import java.util.Calendar;

// Referenced classes of package com.inponsel.android.v2:
//            ProfileActivity

class this._cls0
    implements android.view.r
{

    final ProfileActivity this$0;

    public void onClick(View view)
    {
        c = Calendar.getInstance();
        ProfileActivity.access$3(ProfileActivity.this, c.get(1));
        ProfileActivity.access$0(ProfileActivity.this, c.get(2));
        ProfileActivity.access$1(ProfileActivity.this, c.get(5));
        showDialog(999);
    }

    ()
    {
        this$0 = ProfileActivity.this;
        super();
    }
}
