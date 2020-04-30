// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.inponsel.android.v2:
//            AppsByCategory, PlaystoreKategoriKomen

class this._cls0
    implements android.view.er
{

    final AppsByCategory this$0;

    public void onClick(View view)
    {
        view = new Intent(AppsByCategory.this, com/inponsel/android/v2/PlaystoreKategoriKomen);
        view.putExtra("id_kat", str_id);
        view.putExtra("type", str_category);
        view.putExtra("title", str_title_cat);
        startActivityForResult(view, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    omen()
    {
        this$0 = AppsByCategory.this;
        super();
    }
}
