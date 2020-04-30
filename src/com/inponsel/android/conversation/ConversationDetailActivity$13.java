// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.conversation;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.v2.AddKomentarPicture;

// Referenced classes of package com.inponsel.android.conversation:
//            ConversationDetailActivity

class this._cls0
    implements android.view.ionDetailActivity._cls13
{

    final ConversationDetailActivity this$0;

    public void onClick(View view)
    {
        view = new Intent(ConversationDetailActivity.this, com/inponsel/android/v2/AddKomentarPicture);
        view.putExtra("komen_type", "conversation");
        view.putExtra("forum_id", tl_id);
        view.putExtra("tl_judul", tl_judul);
        view.putExtra("top_id", top_id);
        view.putExtra("tl_type", tl_type);
        startActivityForResult(view, ConversationDetailActivity.access$6());
    }

    ()
    {
        this$0 = ConversationDetailActivity.this;
        super();
    }
}
