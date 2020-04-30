// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import java.io.InputStream;
import java.util.Scanner;

// Referenced classes of package com.inponsel.android.utils:
//            JellyBeanSpanFixTextView, LocalImageGetter, HtmlTagHandler, UrlImageGetter

public class HtmlTextView extends JellyBeanSpanFixTextView
{

    public static final boolean DEBUG = false;
    public static final String TAG = "HtmlTextView";

    public HtmlTextView(Context context)
    {
        super(context);
    }

    public HtmlTextView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public HtmlTextView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    private static String convertStreamToString(InputStream inputstream)
    {
        inputstream = (new Scanner(inputstream)).useDelimiter("\\A");
        if (inputstream.hasNext())
        {
            return inputstream.next();
        } else
        {
            return "";
        }
    }

    public void setHtmlFromRawResource(Context context, int i, boolean flag)
    {
        setHtmlFromString(convertStreamToString(context.getResources().openRawResource(i)), flag);
    }

    public void setHtmlFromString(String s, boolean flag)
    {
        Object obj;
        if (flag)
        {
            obj = new LocalImageGetter(getContext());
        } else
        {
            obj = new UrlImageGetter(this, getContext());
        }
        setText(Html.fromHtml(s, ((android.text.Html.ImageGetter) (obj)), new HtmlTagHandler()));
        setMovementMethod(LinkMovementMethod.getInstance());
    }
}
