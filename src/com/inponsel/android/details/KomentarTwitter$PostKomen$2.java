// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.Util;
import com.inponsel.android.v2.ImagePagerActivity;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.details:
//            KomentarTwitter

class val.user_photo
    implements android.view.ter.PostKomen._cls2
{

    final y this$1;
    private final String val$user_photo;

    public boolean onLongClick(View view)
    {
        view = new ArrayList();
        view.add((new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(val$user_photo.toString().trim()).toString());
        view = (String[])view.toArray(new String[view.size()]);
        Intent intent = new Intent(cess._mth2(this._cls1.this), com/inponsel/android/v2/ImagePagerActivity);
        intent.putExtra("imgUrl", view);
        intent.putExtra("pos", 0);
        cess._mth2(this._cls1.this).startActivity(intent);
        return false;
    }

    ()
    {
        this$1 = final_;
        val$user_photo = String.this;
        super();
    }
}
