// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.favorit;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.Util;
import com.inponsel.android.v2.ImagePagerActivity;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.favorit:
//            FavoritArtikelBerita

class val.rss_img_ava
    implements android.view.avoritRSSTask._cls2
{

    final this._cls1 this$1;
    private final String val$rss_img_ava;

    public boolean onLongClick(View view)
    {
        view = new ArrayList();
        view.add((new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(val$rss_img_ava.toString().trim()).toString());
        view = (String[])view.toArray(new String[view.size()]);
        Intent intent = new Intent(cess._mth3(this._cls1.this), com/inponsel/android/v2/ImagePagerActivity);
        intent.putExtra("imgUrl", view);
        intent.putExtra("pos", 0);
        cess._mth3(this._cls1.this).startActivity(intent);
        return false;
    }

    ()
    {
        this$1 = final_;
        val$rss_img_ava = String.this;
        super();
    }
}
