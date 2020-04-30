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

class val.i
    implements Runnable
{

    final idePendingTransition this$1;
    private final Intent val$i;

    public void run()
    {
        startActivityForResult(val$i, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$i = Intent.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/BaseDrawer$20

/* anonymous class */
    class BaseDrawer._cls20
        implements android.widget.AdapterView.OnItemClickListener
    {

        final BaseDrawer this$0;

        public void onItemClick(AdapterView adapterview, View view, int j, long l)
        {
            adapterview = new Intent(getApplicationContext(), com/inponsel/android/v2/RSSFeedByTag);
            adapterview.putExtra("tag_code", "2");
            adapterview.putExtra("tag_key", langganBrandAdapter.getListModel(j).getId_hp().toString());
            adapterview.putExtra("kategori_tag", langganBrandAdapter.getListModel(j).getMerk().toString());
            mDrawerLayout.closeDrawers();
            (new Handler()).postDelayed(adapterview. new BaseDrawer._cls20._cls1(), 250L);
        }


            
            {
                this$0 = BaseDrawer.this;
                super();
            }
    }

}
