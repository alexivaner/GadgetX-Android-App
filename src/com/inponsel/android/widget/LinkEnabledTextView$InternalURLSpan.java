// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.widget;

import android.text.style.ClickableSpan;
import android.view.View;

// Referenced classes of package com.inponsel.android.widget:
//            LinkEnabledTextView, TextLinkClickListener

public class clickedSpan extends ClickableSpan
{

    private String clickedSpan;
    final LinkEnabledTextView this$0;

    public void onClick(View view)
    {
        mListener.onTextLinkClick(view, clickedSpan);
    }

    public (String s)
    {
        this$0 = LinkEnabledTextView.this;
        super();
        clickedSpan = s;
    }
}
