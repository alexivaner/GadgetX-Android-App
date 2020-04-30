// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.globalforum;

import android.text.Editable;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.inponsel.android.utils.DelayedTextWatcher;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// Referenced classes of package com.inponsel.android.globalforum:
//            PostGlobalForum

class  extends DelayedTextWatcher
{

    final PostGlobalForum this$0;

    public void afterTextChangedDelayed(Editable editable)
    {
        if (edtAuto.getText().length() == 0)
        {
            txtEmpty.setText("Masukan ponsel yang ingin dicari");
            return;
        }
        progressbar_search.setVisibility(0);
        editable = edtAuto.getText().toString();
        String s = URLEncoder.encode(editable, "utf-8");
        editable = s;
_L2:
        (new rchHpSync(PostGlobalForum.this, null)).execute(new String[] {
            (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("home_search").append(Utility.BASE_FORMAT).append("?lmt=0&key=").append(editable).append("&t=").append(t).toString()
        });
        return;
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        unsupportedencodingexception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

    rchHpSync(long l)
    {
        this$0 = PostGlobalForum.this;
        super(l);
    }
}
