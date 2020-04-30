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
//            RegisterActivity, ProfileActivity

class val.input
    implements android.content.ickListener
{

    final is._cls0 this$1;
    private final EditText val$input;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = val$input.getText().toString();
        if (!RegisterActivity.checkEmail(dialoginterface))
        {
            Toast.makeText(_fld0, "email tidak valid", 0).show();
            return;
        } else
        {
            ProfileActivity.access$7(_fld0, dialoginterface);
            return;
        }
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$input = EditText.this;
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
            EditText edittext = new EditText(ProfileActivity.this);
            view.setView(edittext);
            view.setPositiveButton("Ganti", edittext. new ProfileActivity._cls5._cls1());
            view.setNegativeButton("Batal", new ProfileActivity._cls5._cls2());
            view.show();
        }


            
            {
                this$0 = ProfileActivity.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/ProfileActivity$5$2

/* anonymous class */
        class ProfileActivity._cls5._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final ProfileActivity._cls5 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = ProfileActivity._cls5.this;
                        super();
                    }
        }

    }

}
