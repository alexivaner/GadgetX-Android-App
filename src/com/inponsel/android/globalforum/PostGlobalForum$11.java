// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.globalforum;

import android.text.Editable;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// Referenced classes of package com.inponsel.android.globalforum:
//            PostGlobalForum

class this._cls0
    implements android.widget.tionListener
{

    final PostGlobalForum this$0;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        if (i != 3) goto _L2; else goto _L1
_L1:
        if (edtAuto.getText().length() == 0)
        {
            txtEmpty.setText("Masukan ponsel yang ingin dicari");
            return true;
        }
        progressbar_search.setVisibility(0);
        textview = edtAuto.getText().toString();
        keyevent = URLEncoder.encode(textview, "utf-8");
        textview = keyevent;
_L3:
        (new rchHpSync(PostGlobalForum.this, null)).execute(new String[] {
            (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("home_search").append(Utility.BASE_FORMAT).append("?lmt=0&key=").append(textview).append("&t=").append(t).toString()
        });
        return true;
        keyevent;
        keyevent.printStackTrace();
        if (true) goto _L3; else goto _L2
_L2:
        return false;
    }

    rchHpSync()
    {
        this$0 = PostGlobalForum.this;
        super();
    }
}
