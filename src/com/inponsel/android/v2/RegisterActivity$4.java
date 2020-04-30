// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.graphics.Color;
import android.os.AsyncTask;
import android.text.Editable;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.inponsel.android.utils.DelayedTextWatcher;

// Referenced classes of package com.inponsel.android.v2:
//            RegisterActivity

class er extends DelayedTextWatcher
{

    final RegisterActivity this$0;

    public void afterTextChangedDelayed(Editable editable)
    {
        if (!checkUsername(edtUserName.getText().toString()))
        {
            txtcekusername.setVisibility(0);
            txtcekusername.setText("Username harus diawali huruf, minimal 4 karakter, tanpa spasi dan karakter yang diperbolehkan hanya . atau _");
            txtcekusername.setTextColor(Color.parseColor("#db261e"));
            return;
        }
        if (edtUserName.getText().toString().contains("admin"))
        {
            Toast.makeText(RegisterActivity.this, "Username tidak boleh mengandung kata admin", 0).show();
            return;
        }
        if (android.os.NT >= 11)
        {
            (new erCheckTask(RegisterActivity.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            (new erCheckTask(RegisterActivity.this)).execute(new Void[0]);
            return;
        }
    }

    erCheckTask(long l)
    {
        this$0 = RegisterActivity.this;
        super(l);
    }
}
