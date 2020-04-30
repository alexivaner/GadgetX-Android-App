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

class val.position
    implements android.view.gAdapter._cls8
{

    final r_sc_twitter this$1;
    private final int val$position;

    public void onClick(View view)
    {
label0:
        {
            r_sc_twitter = tListModel(val$position).getTwitter().toString();
            _array = r_sc_twitter.split(",");
            if (!r_sc_twitter.equals("") && !r_sc_twitter.equals("-"))
            {
                if (_array.length <= 1)
                {
                    break label0;
                }
                view = new android.app.ngAdapter.tw_array(cess._mth1(this._cls1.this));
                view.ngAdapter("Pilih Twitter");
                view.ems(_array, -1, new android.content.DialogInterface.OnClickListener() {

                    final MerekActivity.ListPendatangAdapter._cls8 this$2;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface = new Intent(MerekActivity.ListPendatangAdapter.access$1(this$1).getApplicationContext(), com/inponsel/android/details/TwitterInPonsel);
                        dialoginterface.putExtra("twitter", tw_array[i].replace(" ", ""));
                        MerekActivity.ListPendatangAdapter.access$1(this$1).startActivityForResult(dialoginterface, 0);
                        MerekActivity.ListPendatangAdapter.access$1(this$1).overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$2 = MerekActivity.ListPendatangAdapter._cls8.this;
                super();
            }
                });
                view._mth8();
            }
            return;
        }
        cess._mth1(this._cls1.this).startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://twitter.com/")).append(r_sc_twitter).toString())));
    }


    _cls1.this._cls2()
    {
        this$1 = final__pcls2;
        val$position = I.this;
        super();
    }
}
