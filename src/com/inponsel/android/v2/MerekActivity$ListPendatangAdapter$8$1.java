// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.details.TwitterInPonsel;

// Referenced classes of package com.inponsel.android.v2:
//            MerekActivity

class this._cls2
    implements android.content.ter._cls8._cls1
{

    final  this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(ss._mth1(_fld1).getApplicationContext(), com/inponsel/android/details/TwitterInPonsel);
        dialoginterface.putExtra("twitter", rray[i].replace(" ", ""));
        ss._mth1(_fld1).startActivityForResult(dialoginterface, 0);
        ss._mth1(_fld1).overridePendingTransition(0x7f040003, 0x7f040004);
    }

    l.position()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/MerekActivity$ListPendatangAdapter$8

/* anonymous class */
    class MerekActivity.ListPendatangAdapter._cls8
        implements android.view.View.OnClickListener
    {

        final MerekActivity.ListPendatangAdapter this$1;
        private final int val$position;

        public void onClick(View view)
        {
label0:
            {
                str_sc_twitter = getListModel(position).getTwitter().toString();
                tw_array = str_sc_twitter.split(",");
                if (!str_sc_twitter.equals("") && !str_sc_twitter.equals("-"))
                {
                    if (tw_array.length <= 1)
                    {
                        break label0;
                    }
                    view = new android.app.AlertDialog.Builder(MerekActivity.ListPendatangAdapter.access$1(MerekActivity.ListPendatangAdapter.this));
                    view.setTitle("Pilih Twitter");
                    view.setSingleChoiceItems(tw_array, -1, new MerekActivity.ListPendatangAdapter._cls8._cls1());
                    view.show();
                }
                return;
            }
            MerekActivity.ListPendatangAdapter.access$1(MerekActivity.ListPendatangAdapter.this).startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://twitter.com/")).append(str_sc_twitter).toString())));
        }


            
            {
                this$1 = final_listpendatangadapter;
                position = I.this;
                super();
            }
    }

}
