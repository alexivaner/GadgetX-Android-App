// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.AttributeSet;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JellyBeanSpanFixTextView extends TextView
{
    private static class FixingResult
    {

        public final boolean fixed;
        public final List spansWithSpacesAfter;
        public final List spansWithSpacesBefore;

        public static FixingResult fixed(List list, List list1)
        {
            return new FixingResult(true, list, list1);
        }

        public static FixingResult notFixed()
        {
            return new FixingResult(false, null, null);
        }

        private FixingResult(boolean flag, List list, List list1)
        {
            fixed = flag;
            spansWithSpacesBefore = list;
            spansWithSpacesAfter = list1;
        }
    }


    public JellyBeanSpanFixTextView(Context context)
    {
        super(context);
    }

    public JellyBeanSpanFixTextView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public JellyBeanSpanFixTextView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    private FixingResult addSpacesAroundSpansUntilFixed(SpannableStringBuilder spannablestringbuilder, int i, int j)
    {
        Object aobj[];
        ArrayList arraylist;
        ArrayList arraylist1;
        int k;
        int l;
        k = 0;
        aobj = spannablestringbuilder.getSpans(0, spannablestringbuilder.length(), java/lang/Object);
        arraylist = new ArrayList(aobj.length);
        arraylist1 = new ArrayList(aobj.length);
        l = aobj.length;
_L2:
        if (k >= l)
        {
            return FixingResult.notFixed();
        }
        Object obj = aobj[k];
        int i1 = spannablestringbuilder.getSpanStart(obj);
        if (isNotSpace(spannablestringbuilder, i1 - 1))
        {
            spannablestringbuilder.insert(i1, " ");
            arraylist.add(obj);
        }
        i1 = spannablestringbuilder.getSpanEnd(obj);
        if (isNotSpace(spannablestringbuilder, i1))
        {
            spannablestringbuilder.insert(i1, " ");
            arraylist1.add(obj);
        }
        FixingResult fixingresult;
        setTextAndMeasure(spannablestringbuilder, i, j);
        fixingresult = FixingResult.fixed(arraylist, arraylist1);
        return fixingresult;
        IndexOutOfBoundsException indexoutofboundsexception;
        indexoutofboundsexception;
        k++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void fallbackToString(int i, int j)
    {
        setTextAndMeasure(getText().toString(), i, j);
    }

    private void fixOnMeasure(int i, int j)
    {
        CharSequence charsequence = getText();
        if (charsequence instanceof Spanned)
        {
            fixSpannedWithSpaces(new SpannableStringBuilder(charsequence), i, j);
            return;
        } else
        {
            fallbackToString(i, j);
            return;
        }
    }

    private void fixSpannedWithSpaces(SpannableStringBuilder spannablestringbuilder, int i, int j)
    {
        System.currentTimeMillis();
        FixingResult fixingresult = addSpacesAroundSpansUntilFixed(spannablestringbuilder, i, j);
        if (fixingresult.fixed)
        {
            removeUnneededSpaces(i, j, spannablestringbuilder, fixingresult);
            return;
        } else
        {
            fallbackToString(i, j);
            return;
        }
    }

    private boolean isNotSpace(CharSequence charsequence, int i)
    {
        while (i < 0 || charsequence.charAt(i) != ' ') 
        {
            return true;
        }
        return false;
    }

    private void removeUnneededSpaces(int i, int j, SpannableStringBuilder spannablestringbuilder, FixingResult fixingresult)
    {
        int k;
        Iterator iterator = fixingresult.spansWithSpacesAfter.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                k = 1;
                fixingresult = fixingresult.spansWithSpacesBefore.iterator();
                break MISSING_BLOCK_LABEL_37;
            }
            k = spannablestringbuilder.getSpanEnd(iterator.next());
            spannablestringbuilder.delete(k, k + 1);
            try
            {
                setTextAndMeasure(spannablestringbuilder, i, j);
            }
            catch (IndexOutOfBoundsException indexoutofboundsexception1)
            {
                spannablestringbuilder.insert(k, " ");
            }
        } while (true);
_L2:
        int l;
        if (!fixingresult.hasNext())
        {
            if (k != 0)
            {
                setText(spannablestringbuilder);
                super.onMeasure(i, j);
            }
            return;
        }
        l = spannablestringbuilder.getSpanStart(fixingresult.next());
        spannablestringbuilder.delete(l - 1, l);
        setTextAndMeasure(spannablestringbuilder, i, j);
        k = 0;
        continue; /* Loop/switch isn't completed */
        IndexOutOfBoundsException indexoutofboundsexception;
        indexoutofboundsexception;
        k = 1;
        spannablestringbuilder.insert(l - 1, " ");
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void setTextAndMeasure(CharSequence charsequence, int i, int j)
    {
        setText(charsequence);
        super.onMeasure(i, j);
    }

    protected void onMeasure(int i, int j)
    {
        try
        {
            super.onMeasure(i, j);
            return;
        }
        catch (IndexOutOfBoundsException indexoutofboundsexception)
        {
            fixOnMeasure(i, j);
        }
    }
}
