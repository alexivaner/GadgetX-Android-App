// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import android.text.Editable;
import android.text.style.BulletSpan;
import android.text.style.TypefaceSpan;
import java.util.Vector;
import org.xml.sax.XMLReader;

public class HtmlTagHandler
    implements android.text.Html.TagHandler
{
    private static class Center
    {

        private Center()
        {
        }

        Center(Center center)
        {
            this();
        }
    }

    private static class Code
    {

        private Code()
        {
        }

        Code(Code code)
        {
            this();
        }
    }


    private int mListItemCount;
    private Vector mListParents;

    public HtmlTagHandler()
    {
        mListItemCount = 0;
        mListParents = new Vector();
    }

    private void end(Editable editable, Class class1, Object obj, boolean flag)
    {
        class1 = ((Class) (getLast(editable, class1)));
        int k = editable.getSpanStart(class1);
        int j = editable.length();
        editable.removeSpan(class1);
        if (k != j)
        {
            int i = j;
            if (flag)
            {
                editable.append("\n");
                i = j + 1;
            }
            editable.setSpan(obj, k, i, 33);
        }
    }

    private Object getLast(Editable editable, Class class1)
    {
        class1 = ((Class) (editable.getSpans(0, editable.length(), class1)));
        if (class1.length != 0)
        {
            int i = class1.length;
            while (i > 0) 
            {
                if (editable.getSpanFlags(class1[i - 1]) == 17)
                {
                    return class1[i - 1];
                }
                i--;
            }
        }
        return null;
    }

    private void handleListTag(Editable editable)
    {
        if (((String)mListParents.lastElement()).equals("ul"))
        {
            editable.append("\n");
            String as[] = editable.toString().split("\n");
            int k = as.length;
            int i = editable.length();
            k = as[k - 1].length();
            editable.setSpan(new BulletSpan(mListParents.size() * 15), i - k - 1, editable.length(), 0);
        } else
        if (((String)mListParents.lastElement()).equals("ol"))
        {
            mListItemCount = mListItemCount + 1;
            editable.append("\n");
            String as1[] = editable.toString().split("\n");
            int j = as1.length;
            j = editable.length() - as1[j - 1].length() - 1;
            editable.insert(j, (new StringBuilder(String.valueOf(mListItemCount))).append(". ").toString());
            editable.setSpan(new android.text.style.LeadingMarginSpan.Standard(mListParents.size() * 15), j, editable.length(), 0);
            return;
        }
    }

    private void start(Editable editable, Object obj)
    {
        int i = editable.length();
        editable.setSpan(obj, i, i, 17);
    }

    public void handleTag(boolean flag, String s, Editable editable, XMLReader xmlreader)
    {
        if (!flag) goto _L2; else goto _L1
_L1:
        if (!s.equalsIgnoreCase("ul") && !s.equalsIgnoreCase("ol") && !s.equalsIgnoreCase("dd")) goto _L4; else goto _L3
_L3:
        mListParents.add(s);
        mListItemCount = 0;
_L6:
        return;
_L4:
        if (s.equalsIgnoreCase("code"))
        {
            start(editable, new Code(null));
            return;
        }
        if (s.equalsIgnoreCase("center"))
        {
            start(editable, new Center(null));
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (s.equalsIgnoreCase("ul") || s.equalsIgnoreCase("ol") || s.equalsIgnoreCase("dd"))
        {
            mListParents.remove(s);
            mListItemCount = 0;
            return;
        }
        if (s.equalsIgnoreCase("li"))
        {
            handleListTag(editable);
            return;
        }
        if (s.equalsIgnoreCase("code"))
        {
            end(editable, com/inponsel/android/utils/HtmlTagHandler$Code, new TypefaceSpan("monospace"), false);
            return;
        }
        if (s.equalsIgnoreCase("center"))
        {
            end(editable, com/inponsel/android/utils/HtmlTagHandler$Center, new android.text.style.AlignmentSpan.Standard(android.text.Layout.Alignment.ALIGN_CENTER), true);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }
}
