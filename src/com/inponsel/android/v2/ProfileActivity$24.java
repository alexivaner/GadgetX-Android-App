// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.os.AsyncTask;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

// Referenced classes of package com.inponsel.android.v2:
//            ProfileActivity

class this._cls0
    implements android.view.r
{

    final ProfileActivity this$0;

    public void onClick(View view)
    {
        if (!edtrePassProfileBaru.getText().toString().equals(edtPassProfileBaru.getText().toString()))
        {
            Toast.makeText(getApplicationContext(), "Password baru tidak cocok", 1).show();
            edtPassProfileBaru.startAnimation(animation);
            edtrePassProfileBaru.startAnimation(animation);
            return;
        }
        try
        {
            if (android.os.NT >= 11)
            {
                (new sTask(ProfileActivity.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return;
        }
        (new sTask(ProfileActivity.this)).execute(new Void[0]);
        return;
    }

    sTask()
    {
        this$0 = ProfileActivity.this;
        super();
    }
}
