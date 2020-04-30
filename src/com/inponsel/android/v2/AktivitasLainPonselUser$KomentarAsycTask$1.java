// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.Util;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.v2:
//            AktivitasLainPonselUser, ImagePagerActivity

class val.usr_pict_komen
    implements android.view.AsycTask._cls1
{

    final this._cls1 this$1;
    private final String val$usr_pict_komen;

    public boolean onLongClick(View view)
    {
        view = new ArrayList();
        view.add((new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(val$usr_pict_komen.toString().trim()).toString());
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
        val$usr_pict_komen = String.this;
        super();
    }
}
