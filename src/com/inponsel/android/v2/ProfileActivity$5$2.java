// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

// Referenced classes of package com.inponsel.android.v2:
//            ProfileActivity, RegisterActivity

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

    // Unreferenced inner class com/inponsel/android/v2/ProfileActivity$5

/* anonymous class */
    class ProfileActivity._cls5
        implements android.view.View.OnClickListener
    {

        final ProfileActivity this$0;

        public void onClick(View view)
        {
            view = new android.app.AlertDialog.Builder(ProfileActivity.this);
            view.setTitle("Ganti Email");
            view.setMessage("Masukkan email baru :");
            final EditText input = new EditText(ProfileActivity.this);
            view.setView(input);
            view.setPositiveButton("Ganti", new ProfileActivity._cls5._cls1());
            view.setNegativeButton("Batal", new ProfileActivity._cls5._cls2());
            view.show();
        }


            
            {
                this$0 = ProfileActivity.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/ProfileActivity$5$1

/* anonymous class */
        class ProfileActivity._cls5._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final ProfileActivity._cls5 this$1;
            private final EditText val$input;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = input.getText().toString();
                if (!RegisterActivity.checkEmail(dialoginterface))
                {
                    Toast.makeText(this$0, "email tidak valid", 0).show();
                    return;
                } else
                {
                    ProfileActivity.access$7(this$0, dialoginterface);
                    return;
                }
            }

                    
                    {
                        this$1 = ProfileActivity._cls5.this;
                        input = edittext;
                        super();
                    }
        }

    }

}
