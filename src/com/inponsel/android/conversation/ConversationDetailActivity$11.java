// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.conversation;

import android.os.AsyncTask;
import android.text.Editable;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.widget.DroidWriterEditText;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// Referenced classes of package com.inponsel.android.conversation:
//            ConversationDetailActivity

class this._cls0
    implements android.view.ionDetailActivity._cls11
{

    final ConversationDetailActivity this$0;

    public void onClick(View view)
    {
        try
        {
            view = URLEncoder.encode(edt_pop_komen.getText().toString(), "utf-8");
            Log.e("top_id", "0");
            querypopkomen = (new StringBuilder("rplto=0&komen=")).append(view).append("&tl_id=").append(tl_id).append("&type=").append(tl_type).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).toString();
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
        }
        if (android.os.tStackTrace >= 11)
        {
            (new tKomen(ConversationDetailActivity.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            (new tKomen(ConversationDetailActivity.this)).execute(new Void[0]);
            return;
        }
    }

    tKomen()
    {
        this$0 = ConversationDetailActivity.this;
        super();
    }
}
