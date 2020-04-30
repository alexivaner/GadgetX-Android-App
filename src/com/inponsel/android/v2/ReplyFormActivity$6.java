// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.Util;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.v2:
//            ReplyFormActivity, ImagePagerActivity

class this._cls0
    implements android.view.ener
{

    final ReplyFormActivity this$0;

    public boolean onLongClick(View view)
    {
        view = new ArrayList();
        view.add((new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(userpict.toString().trim()).toString());
        view = (String[])view.toArray(new String[view.size()]);
        Intent intent = new Intent(ReplyFormActivity.this, com/inponsel/android/v2/ImagePagerActivity);
        intent.putExtra("imgUrl", view);
        intent.putExtra("pos", 0);
        startActivity(intent);
        return false;
    }

    ()
    {
        this$0 = ReplyFormActivity.this;
        super();
    }
}
