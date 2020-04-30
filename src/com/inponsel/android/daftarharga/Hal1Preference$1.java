// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.daftarharga;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.inponsel.android.pencarianrinci.PencarianRinciPonsel;

// Referenced classes of package com.inponsel.android.daftarharga:
//            Hal1Preference

class this._cls0
    implements com.inponsel.android.utils.Listener
{

    final Hal1Preference this$0;

    public void onClick()
    {
        Intent intent = new Intent(getActivity(), com/inponsel/android/pencarianrinci/PencarianRinciPonsel);
        startActivityForResult(intent, 0);
        getActivity().overridePendingTransition(0x7f040001, 0x7f040002);
    }

    Ponsel()
    {
        this$0 = Hal1Preference.this;
        super();
    }
}
