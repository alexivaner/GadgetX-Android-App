// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rssfeeddetail;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.rssfeeddetail:
//            Hal1RSSDetail

class val.lName
    implements android.view.ner
{

    final Hal1RSSDetail this$0;
    private final String val$lName;
    private final String val$tag_name;
    private final String val$title;
    private final TextView val$txt_sub_status;

    public void onClick(View view)
    {
        if (userFunctions.isUserLoggedIn(getActivity()))
        {
            Log.e("txt_sub_status", val$txt_sub_status.getText().toString());
            if (val$txt_sub_status.getText().toString().equals("1"))
            {
                subs_status_push = "0";
            } else
            {
                subs_status_push = "1";
            }
            Log.e("subs_statusbtn", subs_status_push);
            Hal1RSSDetail.access$16(Hal1RSSDetail.this, val$title, val$tag_name, val$lName, subs_status_push, "general");
            return;
        } else
        {
            view = new android.app.er(getActivity());
            view.setMessage("Untuk menambahkan ke favorit harus login terlebih dahulu.");
            view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final Hal1RSSDetail._cls16 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = Hal1RSSDetail._cls16.this;
                super();
            }
            });
            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                final Hal1RSSDetail._cls16 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                    startActivity(dialoginterface);
                }

            
            {
                this$1 = Hal1RSSDetail._cls16.this;
                super();
            }
            });
            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                final Hal1RSSDetail._cls16 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    startActivity(dialoginterface);
                }

            
            {
                this$1 = Hal1RSSDetail._cls16.this;
                super();
            }
            });
            view.show();
            return;
        }
    }


    _cls3.this._cls1()
    {
        this$0 = final_hal1rssdetail;
        val$txt_sub_status = textview;
        val$title = s;
        val$tag_name = s1;
        val$lName = String.this;
        super();
    }
}
