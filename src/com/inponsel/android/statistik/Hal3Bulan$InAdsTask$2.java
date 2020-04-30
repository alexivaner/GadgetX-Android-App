// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.statistik;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.v2.ImagePagerActivity;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.statistik:
//            Hal3Bulan

class this._cls1
    implements android.view.Bulan.InAdsTask._cls2
{

    final y this$1;

    public void onClick(View view)
    {
        view = new ArrayList();
        view.add(cess._mth3(this._cls1.this).image_ads.replaceAll(" ", "").trim());
        view = (String[])view.toArray(new String[view.size()]);
        Intent intent = new Intent(cess._mth3(this._cls1.this).getActivity(), com/inponsel/android/v2/ImagePagerActivity);
        intent.putExtra("imgUrl", view);
        intent.putExtra("pos", 0);
        cess._mth3(this._cls1.this).startActivity(intent);
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
