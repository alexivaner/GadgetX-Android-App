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

// Referenced classes of package com.inponsel.android.v2:
//            BaseDrawer, RSSFeedByTag

class this._cls0
    implements android.widget.ItemClickListener
{

    final BaseDrawer this$0;

    public void onItemClick(final AdapterView i, View view, int j, long l)
    {
        i = new Intent(getApplicationContext(), com/inponsel/android/v2/RSSFeedByTag);
        i.putExtra("tag_code", "2");
        i.putExtra("tag_key", langganBrandAdapter.getListModel(j).getId_hp().toString());
        i.putExtra("kategori_tag", langganBrandAdapter.getListModel(j).getMerk().toString());
        mDrawerLayout.closeDrawers();
        (new Handler()).postDelayed(new Runnable() {

            final BaseDrawer._cls20 this$1;
            private final Intent val$i;

            public void run()
            {
                startActivityForResult(i, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$1 = BaseDrawer._cls20.this;
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
