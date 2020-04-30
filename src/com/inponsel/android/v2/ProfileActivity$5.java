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

class this._cls0
    implements android.view.er
{

    final ProfileActivity this$0;

    public void onClick(View view)
    {
        view = new android.app.r(ProfileActivity.this);
        view.setTitle("Ganti Email");
        view.setMessage("Masukkan email baru :");
        final EditText input = new EditText(ProfileActivity.this);
        view.setView(input);
        view.setPositiveButton("Ganti", new android.content.DialogInterface.OnClickListener() {

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
        });
        view.setNegativeButton("Batal", new android.content.DialogInterface.OnClickListener() {

            final ProfileActivity._cls5 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$1 = ProfileActivity._cls5.this;
                super();
            }
        });
        view.show();
    }


    _cls2.this._cls1()
    {
        this$0 = ProfileActivity.this;
        super();
    }
}
