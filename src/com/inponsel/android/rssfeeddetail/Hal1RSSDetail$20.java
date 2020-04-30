// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rssfeeddetail;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.inponsel.android.details.DetailsPonsel;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.rssfeeddetail:
//            Hal1RSSDetail

class val.codeName
    implements android.view.ner
{

    final Hal1RSSDetail this$0;
    private final String val$codeName;
    private final String val$fName;
    private final String val$lName;

    public void onClick(View view)
    {
        view = new Intent(getActivity(), com/inponsel/android/details/DetailsPonsel);
        view.putExtra("id_hph", val$lName);
        view.putExtra("namalengkap", val$fName);
        view.putExtra("codename", "");
        view.putExtra("model", "");
        view.putExtra("merk", "");
        view.putExtra("gambar", "");
        view.putExtra("hrg_baru", "");
        view.putExtra("hrg_bekas", "");
        view.putExtra("tot_like", "");
        view.putExtra("tot_dislike", "");
        view.putExtra("tot_komen", "");
        view.putExtra("actfrom", "spek");
        Log.e("codeName", val$codeName);
        startActivityForResult(view, 0);
        getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
    }

    _cls9()
    {
        this$0 = final_hal1rssdetail;
        val$lName = s;
        val$fName = s1;
        val$codeName = String.this;
        super();
    }
}
