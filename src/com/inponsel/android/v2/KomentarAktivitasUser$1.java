// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.inponsel.android.v2:
//            KomentarAktivitasUser, AktivitasLainPonselUser

class this._cls0
    implements android.view.itasUser._cls1
{

    final KomentarAktivitasUser this$0;

    public void onClick(View view)
    {
        view = new Intent(getApplicationContext(), com/inponsel/android/v2/AktivitasLainPonselUser);
        view.putExtra("str_id_user", str_id_user);
        startActivityForResult(view, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ()
    {
        this$0 = KomentarAktivitasUser.this;
        super();
    }
}
