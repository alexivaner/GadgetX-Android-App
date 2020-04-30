// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.v2:
//            ProfileActivity

class this._cls0
    implements android.content.lickListener
{

    final ProfileActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        ProfileActivity.access$11(ProfileActivity.this, ProfileActivity.access$10(ProfileActivity.this));
        ProfileActivity.access$11(ProfileActivity.this, ProfileActivity.access$12(ProfileActivity.this));
        if (i == 0)
        {
            ProfileActivity.access$13(ProfileActivity.this);
        } else
        {
            ProfileActivity.access$14(ProfileActivity.this);
        }
        Log.e("startActivityForResult", String.valueOf(-1));
    }

    ener()
    {
        this$0 = ProfileActivity.this;
        super();
    }
}
