// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.inponsel.android.v2:
//            KomentarPonsel, AddKomentarPicture

class this._cls0
    implements android.view.ner
{

    final KomentarPonsel this$0;

    public void onClick(View view)
    {
        view = new Intent(KomentarPonsel.this, com/inponsel/android/v2/AddKomentarPicture);
        view.putExtra("komen_type", "ponsel");
        view.putExtra("top_id", top_id);
        view.putExtra("id_hph", id_hp);
        view.putExtra("merk", merk);
        view.putExtra("model", model);
        view.putExtra("codename", codename);
        view.putExtra("top_id", top_id);
        startActivityForResult(view, KomentarPonsel.access$5());
    }

    e()
    {
        this$0 = KomentarPonsel.this;
        super();
    }
}
