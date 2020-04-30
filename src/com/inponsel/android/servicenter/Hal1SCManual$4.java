// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.servicenter;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;

// Referenced classes of package com.inponsel.android.servicenter:
//            Hal1SCManual, SCPencarian, Hal2SCHasil

class this._cls0
    implements android.view.tener
{

    final Hal1SCManual this$0;

    public void onClick(View view)
    {
        view = ((SCPencarian)getActivity()).getHal2SCHasil();
        view = (Hal2SCHasil)getActivity().getSupportFragmentManager().findFragmentByTag(view);
        view.sc_updateParam(strPencMerek, provinsi_id, kota_id);
        view.SearchManualTask();
        SCPencarian.mViewPager.setCurrentItem(1, true);
    }

    ()
    {
        this$0 = Hal1SCManual.this;
        super();
    }
}
