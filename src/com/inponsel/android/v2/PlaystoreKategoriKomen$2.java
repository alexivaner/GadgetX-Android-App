// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.v2:
//            PlaystoreKategoriKomen, AddKomentarPicture

class this._cls0
    implements android.view.oriKomen._cls2
{

    final PlaystoreKategoriKomen this$0;

    public void onClick(View view)
    {
        view = new Intent(PlaystoreKategoriKomen.this, com/inponsel/android/v2/AddKomentarPicture);
        view.putExtra("komen_type", (new StringBuilder("appskategori")).append(str_category).toString());
        view.putExtra("id_kat", id_kat);
        view.putExtra("sc_nama", title);
        view.putExtra("top_id", top_id);
        Log.e("top_id", top_id);
        startActivityForResult(view, PlaystoreKategoriKomen.access$5());
    }

    ()
    {
        this$0 = PlaystoreKategoriKomen.this;
        super();
    }
}
