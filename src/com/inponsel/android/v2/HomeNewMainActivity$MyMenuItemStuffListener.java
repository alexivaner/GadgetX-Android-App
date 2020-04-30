// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Toast;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewMainActivity

static abstract class hint
    implements android.view.ffListener, android.view.ffListener
{

    private String hint;
    private View view;

    public abstract void onClick(View view1);

    public boolean onLongClick(View view1)
    {
        view1 = new int[2];
        Rect rect = new Rect();
        view.getLocationOnScreen(view1);
        view.getWindowVisibleDisplayFrame(rect);
        Object obj = view.getContext();
        int i = view.getWidth();
        int j = view.getHeight();
        int k = view1[1];
        int l = j / 2;
        int i1 = ((Context) (obj)).getResources().getDisplayMetrics().widthPixels;
        obj = Toast.makeText(((Context) (obj)), hint, 0);
        if (k + l < rect.height())
        {
            ((Toast) (obj)).setGravity(53, i1 - view1[0] - i / 2, j);
        } else
        {
            ((Toast) (obj)).setGravity(81, 0, j);
        }
        ((Toast) (obj)).show();
        return true;
    }

    I(View view1, String s)
    {
        view = view1;
        hint = s;
        view1.setOnClickListener(this);
        view1.setOnLongClickListener(this);
    }
}
