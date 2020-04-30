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

class this._cls1
    implements android.content.lickListener
{

    final Activity this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
        startActivity(dialoginterface);
    }

    l.lName()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/rssfeeddetail/Hal1RSSDetail$25

/* anonymous class */
    class Hal1RSSDetail._cls25
        implements android.view.View.OnClickListener
    {

        final Hal1RSSDetail this$0;
        private final String val$lName;
        private final String val$tag_name;
        private final String val$title;
        private final TextView val$txt_sub_status;

        public void onClick(View view)
        {
            Log.e("txt_sub_status", txt_sub_status.getText().toString());
            if (userFunctions.isUserLoggedIn(getActivity()))
            {
                Log.e("txt_sub_status", txt_sub_status.getText().toString());
                if (txt_sub_status.getText().toString().equals("1"))
                {
                    subs_status_push = "0";
                } else
                {
                    subs_status_push = "1";
                }
                Log.e("subs_statusbtn", subs_status_push);
                Hal1RSSDetail.access$16(Hal1RSSDetail.this, title, tag_name, lName, subs_status_push, "os");
                return;
            } else
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setMessage("Untuk menambahkan ke favorit harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new Hal1RSSDetail._cls25._cls1());
                view.setNeutralButton("Register", new Hal1RSSDetail._cls25._cls2());
                view.setNegativeButton("Login", new Hal1RSSDetail._cls25._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$0 = final_hal1rssdetail;
                txt_sub_status = textview;
                title = s;
                tag_name = s1;
                lName = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/rssfeeddetail/Hal1RSSDetail$25$1

/* anonymous class */
        class Hal1RSSDetail._cls25._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal1RSSDetail._cls25 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = Hal1RSSDetail._cls25.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/rssfeeddetail/Hal1RSSDetail$25$3

/* anonymous class */
        class Hal1RSSDetail._cls25._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal1RSSDetail._cls25 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                startActivity(dialoginterface);
            }

                    
                    {
                        this$1 = Hal1RSSDetail._cls25.this;
                        super();
                    }
        }

    }

}
