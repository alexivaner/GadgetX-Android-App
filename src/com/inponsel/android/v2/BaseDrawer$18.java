// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.details.ProfilPTActivity;

// Referenced classes of package com.inponsel.android.v2:
//            BaseDrawer

class this._cls0
    implements android.widget.ItemClickListener
{

    final BaseDrawer this$0;

    public void onItemClick(final AdapterView i, View view, int j, long l)
    {
        i = new Intent(BaseDrawer.this, com/inponsel/android/details/ProfilPTActivity);
        i.putExtra("id_merk", favBrandAdapter.getListModel(j).getId_hp());
        i.putExtra("titlemerek", favBrandAdapter.getListModel(j).getMerk());
        mDrawerLayout.closeDrawers();
        (new Handler()).postDelayed(new Runnable() {

            final BaseDrawer._cls18 this$1;
            private final Intent val$i;

            public void run()
            {
                startActivityForResult(i, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$1 = BaseDrawer._cls18.this;
                i = intent;
                super();
            }
        }, 250L);
    }


    _cls1.val.i()
    {
        this$0 = BaseDrawer.this;
        super();
    }
}
