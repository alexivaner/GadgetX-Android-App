// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.widget;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.inponsel.android.widget:
//            TextLinkClickListener

public class LinkEnabledTextView extends TextView
{
    class Hyperlink
    {

        int end;
        InternalURLSpan span;
        int start;
        CharSequence textSpan;
        final LinkEnabledTextView this$0;

        Hyperlink()
        {
            this$0 = LinkEnabledTextView.this;
            super();
        }
    }

    public class InternalURLSpan extends ClickableSpan
    {

        private String clickedSpan;
        final LinkEnabledTextView this$0;

        public void onClick(View view)
        {
            mListener.onTextLinkClick(view, clickedSpan);
        }

        public InternalURLSpan(String s)
        {
            this$0 = LinkEnabledTextView.this;
            super();
            clickedSpan = s;
        }
    }


    Pattern hashTagsPattern;
    Pattern hyperLinksPattern;
    SpannableString linkableText;
    private ArrayList listOfLinks;
    TextLinkClickListener mListener;
    Pattern screenNamePattern;

    public LinkEnabledTextView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        screenNamePattern = Pattern.compile("(@[a-zA-Z0-9_]+)");
        hashTagsPattern = Pattern.compile("(#[a-zA-Z0-9_-]+)");
        hyperLinksPattern = Pattern.compile("([Hh][tT][tT][pP][sS]?:\\/\\/[^ ,''>\\]\\)]*[^\\. ,''>\\]\\)])");
        listOfLinks = new ArrayList();
    }

    private final void gatherLinks(ArrayList arraylist, Spannable spannable, Pattern pattern)
    {
        pattern = pattern.matcher(spannable);
        do
        {
            if (!pattern.find())
            {
                return;
            }
            int i = pattern.start();
            int j = pattern.end();
            Hyperlink hyperlink = new Hyperlink();
            hyperlink.textSpan = spannable.subSequence(i, j);
            hyperlink.span = new InternalURLSpan(hyperlink.textSpan.toString());
            hyperlink.start = i;
            hyperlink.end = j;
            arraylist.add(hyperlink);
        } while (true);
    }

    public void gatherLinksForText(String s)
    {
        linkableText = new SpannableString(s.replace("#", ""));
        gatherLinks(listOfLinks, linkableText, screenNamePattern);
        gatherLinks(listOfLinks, linkableText, hashTagsPattern);
        gatherLinks(listOfLinks, linkableText, hyperLinksPattern);
        int i = 0;
        do
        {
            if (i >= listOfLinks.size())
            {
                setText(linkableText);
                return;
            }
            s = (Hyperlink)listOfLinks.get(i);
            Log.v((new StringBuilder("listOfLinks :: ")).append(((Hyperlink) (s)).textSpan).toString(), (new StringBuilder("listOfLinks :: ")).append(((Hyperlink) (s)).textSpan).toString());
            linkableText.setSpan(((Hyperlink) (s)).span, ((Hyperlink) (s)).start, ((Hyperlink) (s)).end, 33);
            i++;
        } while (true);
    }

    public void setOnTextLinkClickListener(TextLinkClickListener textlinkclicklistener)
    {
        mListener = textlinkclicklistener;
    }
}
