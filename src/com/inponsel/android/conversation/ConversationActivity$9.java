// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.conversation;

import android.widget.Button;
import android.widget.TextView;
import com.android.volley.VolleyError;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.conversation:
//            ConversationActivity

class this._cls0
    implements com.android.volley.tionActivity._cls9
{

    final ConversationActivity this$0;

    public void onErrorResponse(VolleyError volleyerror)
    {
        Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
        btnRefresh.setVisibility(0);
        pop_txt_empty.setVisibility(0);
        pop_txt_empty.setText("Gagal memuat");
        ConversationActivity.access$4(ConversationActivity.this);
    }

    ()
    {
        this$0 = ConversationActivity.this;
        super();
    }
}
