// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.graphics.Color;
import android.os.AsyncTask;
import android.text.Editable;
import android.widget.EditText;
import android.widget.TextView;
import com.inponsel.android.utils.DelayedTextWatcher;

// Referenced classes of package com.inponsel.android.v2:
//            RegisterActivity

class er extends DelayedTextWatcher
{

    final RegisterActivity this$0;

    public void afterTextChangedDelayed(Editable editable)
    {
        if (!RegisterActivity.checkEmail(edtEmail.getText().toString()))
        {
            txtcekemail.setVisibility(0);
            txtcekemail.setText("Alamat email salah");
            txtcekemail.setTextColor(Color.parseColor("#db261e"));
            txtcekemail.startAnimation(animation);
            return;
        }
        if (android.os.NT >= 11)
        {
            (new ailCheckTask(RegisterActivity.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            (new ailCheckTask(RegisterActivity.this)).execute(new Void[0]);
            return;
        }
    }

    ailCheckTask(long l)
    {
        this$0 = RegisterActivity.this;
        super(l);
    }
}
