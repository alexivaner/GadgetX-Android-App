// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dobmob.dobsliding.controllers;

import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

// Referenced classes of package com.dobmob.dobsliding.controllers:
//            VSlidingMenuController

class this._cls0
    implements android.view.LayoutListener
{

    final VSlidingMenuController this$0;

    public void onGlobalLayout()
    {
        hideSlidingLayout();
        ViewTreeObserver viewtreeobserver = VSlidingMenuController.access$0(VSlidingMenuController.this).getViewTreeObserver();
        if (android.os.eeObserver >= 16)
        {
            viewtreeobserver.removeOnGlobalLayoutListener(this);
            return;
        } else
        {
            viewtreeobserver.removeGlobalOnLayoutListener(this);
            return;
        }
    }

    ()
    {
        this$0 = VSlidingMenuController.this;
        super();
    }
}
