// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.conversation;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.Util;
import com.inponsel.android.v2.ImagePagerActivity;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.conversation:
//            ConversationDetailActivity

class this._cls0
    implements android.view.tionDetailActivity._cls4
{

    final ConversationDetailActivity this$0;

    public void onClick(View view)
    {
        view = new ArrayList();
        view.add((new StringBuilder(String.valueOf(Util.BASE_URL_THUMB_ORI))).append("w=").append(screenwidth).append("&src=").append(tl_img_url.trim()).toString());
        view = (String[])view.toArray(new String[view.size()]);
        Intent intent = new Intent(ConversationDetailActivity.this, com/inponsel/android/v2/ImagePagerActivity);
        intent.putExtra("imgUrl", view);
        intent.putExtra("pos", 0);
        startActivity(intent);
    }

    ()
    {
        this$0 = ConversationDetailActivity.this;
        super();
    }
}
