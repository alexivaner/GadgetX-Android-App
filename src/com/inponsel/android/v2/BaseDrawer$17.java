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
import com.inponsel.android.details.DetailsPonsel;

// Referenced classes of package com.inponsel.android.v2:
//            BaseDrawer

class this._cls0
    implements android.widget.ItemClickListener
{

    final BaseDrawer this$0;

    public void onItemClick(final AdapterView i, View view, int j, long l)
    {
        i = new Intent(BaseDrawer.this, com/inponsel/android/details/DetailsPonsel);
        i.putExtra("id_hph", favHpAdapter.getListModel(j).getId_hp());
        i.putExtra("namalengkap", (new StringBuilder(String.valueOf(favHpAdapter.getListModel(j).getMerk()))).append(" ").append(favHpAdapter.getListModel(j).getModel()).toString());
        i.putExtra("codename", "");
        i.putExtra("model", favHpAdapter.getListModel(j).getModel());
        i.putExtra("merk", favHpAdapter.getListModel(j).getMerk());
        i.putExtra("gambar", favHpAdapter.getListModel(j).getGambar());
        i.putExtra("hrg_baru", "");
        i.putExtra("hrg_bekas", "");
        i.putExtra("tot_like", "");
        i.putExtra("tot_dislike", "");
        i.putExtra("tot_komen", "");
        mDrawerLayout.closeDrawers();
        (new Handler()).postDelayed(new Runnable() {

            final BaseDrawer._cls17 this$1;
            private final Intent val$i;

            public void run()
            {
                startActivityForResult(i, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$1 = BaseDrawer._cls17.this;
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
