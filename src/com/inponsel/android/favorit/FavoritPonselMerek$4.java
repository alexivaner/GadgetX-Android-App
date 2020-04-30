// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.favorit;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.v2.ImagePagerActivity;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.favorit:
//            FavoritPonselMerek

class val.rss_img
    implements android.view.itPonselMerek._cls4
{

    final FavoritPonselMerek this$0;
    private final String val$rss_img;

    public void onClick(View view)
    {
        view = new ArrayList();
        view.add(val$rss_img);
        view = (String[])view.toArray(new String[view.size()]);
        Intent intent = new Intent(FavoritPonselMerek.this, com/inponsel/android/v2/ImagePagerActivity);
        intent.putExtra("imgUrl", view);
        intent.putExtra("pos", 0);
        startActivity(intent);
    }

    ()
    {
        this$0 = final_favoritponselmerek;
        val$rss_img = String.this;
        super();
    }
}
