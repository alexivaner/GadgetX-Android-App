// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.text.Editable;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.widget.DroidWriterEditText;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// Referenced classes of package com.inponsel.android.v2:
//            MessageActivity

class this._cls0
    implements android.view.er
{

    final MessageActivity this$0;

    public void onClick(View view)
    {
        try
        {
            Log.e("id_from", id_from);
            Log.e("id_to", id_to);
            edt_pop_komen.requestFocus();
            edt_pop_komen.setFocusable(true);
            MessageActivity.access$10(MessageActivity.this, id_from, id_to, URLEncoder.encode(edt_pop_komen.getText().toString(), "utf-8"), t, bottom_id);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
        }
    }

    tText()
    {
        this$0 = MessageActivity.this;
        super();
    }
}
