// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.v2.AddKomentarPicture;

// Referenced classes of package com.inponsel.android.details:
//            Hal3KomentarPull

class this._cls0
    implements android.view.r
{

    final Hal3KomentarPull this$0;

    public void onClick(View view)
    {
        view = new Intent(getActivity(), com/inponsel/android/v2/AddKomentarPicture);
        view.putExtra("komen_type", "ponsel");
        view.putExtra("top_id", top_id);
        view.putExtra("id_hph", id_hp);
        view.putExtra("merk", merk);
        view.putExtra("model", model);
        view.putExtra("codename", codename);
        view.putExtra("top_id", top_id);
        startActivityForResult(view, Hal3KomentarPull.access$3());
    }

    ()
    {
        this$0 = Hal3KomentarPull.this;
        super();
    }
}
