// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.DatabaseHandler;

// Referenced classes of package com.inponsel.android.v2:
//            ProfileActivity, HomeNewMainActivity

class this._cls1
    implements android.content.ickListener
{

    final ner this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/ProfileActivity$8

/* anonymous class */
    class ProfileActivity._cls8
        implements android.view.View.OnClickListener
    {

        final ProfileActivity this$0;

        public void onClick(View view)
        {
            view = new android.app.AlertDialog.Builder(wrapper);
            view.setTitle("Logout InPonsel");
            view.setMessage("Ingin logout dari InPonsel?");
            view.setPositiveButton("Ya", new ProfileActivity._cls8._cls1());
            view.setNegativeButton("Tidak", new ProfileActivity._cls8._cls2());
            view.show();
        }


            
            {
                this$0 = ProfileActivity.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/ProfileActivity$8$1

/* anonymous class */
        class ProfileActivity._cls8._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final ProfileActivity._cls8 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                ProfileActivity.access$8(this$0, "0");
                notifManager.cancelAll();
                db.resetUnreadMSGTables();
                db.removeAll();
                dialoginterface = new Intent(getApplicationContext(), com/inponsel/android/v2/HomeNewMainActivity);
                dialoginterface.addFlags(0x4000000);
                dialoginterface.addFlags(32768);
                startActivity(dialoginterface);
                finish();
            }

                    
                    {
                        this$1 = ProfileActivity._cls8.this;
                        super();
                    }
        }

    }

}
