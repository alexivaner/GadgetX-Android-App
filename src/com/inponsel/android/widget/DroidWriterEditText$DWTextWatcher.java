// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.widget;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.text.style.CharacterStyle;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.widget.ToggleButton;

// Referenced classes of package com.inponsel.android.widget:
//            DroidWriterEditText

private class <init>
    implements TextWatcher
{

    final DroidWriterEditText this$0;

    public void afterTextChanged(Editable editable)
    {
        int i;
        int j = Selection.getSelectionStart(getText());
        i = j;
        if (j < 0)
        {
            i = 0;
        }
        if (i <= 0) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        StyleSpan stylespan;
        CharacterStyle acharacterstyle[];
        int k;
        acharacterstyle = (CharacterStyle[])editable.getSpans(i - 1, i, android/text/style/CharacterStyle);
        stylespan = null;
        obj1 = null;
        obj = null;
        k = 0;
_L19:
        if (k < acharacterstyle.length) goto _L4; else goto _L3
_L3:
        if (DroidWriterEditText.access$0(DroidWriterEditText.this) == null) goto _L6; else goto _L5
_L5:
        if (!DroidWriterEditText.access$0(DroidWriterEditText.this).isChecked() || stylespan != null) goto _L8; else goto _L7
_L7:
        editable.setSpan(new StyleSpan(1), i - 1, i, 34);
_L6:
        StyleSpan stylespan1;
        StyleSpan stylespan2;
        UnderlineSpan underlinespan;
        if (DroidWriterEditText.access$1(DroidWriterEditText.this) != null && DroidWriterEditText.access$1(DroidWriterEditText.this).isChecked() && obj1 == null)
        {
            editable.setSpan(new StyleSpan(2), i - 1, i, 34);
        } else
        if (DroidWriterEditText.access$1(DroidWriterEditText.this) != null && !DroidWriterEditText.access$1(DroidWriterEditText.this).isChecked() && obj1 != null)
        {
            int i1 = editable.getSpanStart(obj1);
            int l1 = editable.getSpanEnd(obj1);
            editable.removeSpan(obj1);
            if (i1 <= i - 1)
            {
                editable.setSpan(new StyleSpan(2), i1, i - 1, 34);
            }
            if (l1 > i)
            {
                editable.setSpan(new StyleSpan(2), i, l1, 34);
            }
        }
        if (DroidWriterEditText.access$2(DroidWriterEditText.this) == null || !DroidWriterEditText.access$2(DroidWriterEditText.this).isChecked() || obj != null) goto _L10; else goto _L9
_L9:
        editable.setSpan(new UnderlineSpan(), i - 1, i, 34);
_L2:
        return;
_L4:
        if (!(acharacterstyle[k] instanceof StyleSpan)) goto _L12; else goto _L11
_L11:
        if (((StyleSpan)acharacterstyle[k]).getStyle() != 1) goto _L14; else goto _L13
_L13:
        stylespan1 = (StyleSpan)acharacterstyle[k];
        underlinespan = obj;
        stylespan2 = obj1;
_L15:
        k++;
        stylespan = stylespan1;
        obj1 = stylespan2;
        obj = underlinespan;
        continue; /* Loop/switch isn't completed */
_L14:
        stylespan1 = stylespan;
        stylespan2 = obj1;
        underlinespan = obj;
        if (((StyleSpan)acharacterstyle[k]).getStyle() == 2)
        {
            stylespan2 = (StyleSpan)acharacterstyle[k];
            stylespan1 = stylespan;
            underlinespan = obj;
        }
        continue; /* Loop/switch isn't completed */
_L12:
        stylespan1 = stylespan;
        stylespan2 = obj1;
        underlinespan = obj;
        if (acharacterstyle[k] instanceof UnderlineSpan)
        {
            underlinespan = (UnderlineSpan)acharacterstyle[k];
            stylespan1 = stylespan;
            stylespan2 = obj1;
        }
        if (true) goto _L15; else goto _L8
_L8:
        if (!DroidWriterEditText.access$0(DroidWriterEditText.this).isChecked() && stylespan != null)
        {
            int l = editable.getSpanStart(stylespan);
            int k1 = editable.getSpanEnd(stylespan);
            editable.removeSpan(stylespan);
            if (l <= i - 1)
            {
                editable.setSpan(new StyleSpan(1), l, i - 1, 34);
            }
            if (k1 > i)
            {
                editable.setSpan(new StyleSpan(1), i, k1, 34);
            }
        }
          goto _L6
_L10:
        if (DroidWriterEditText.access$2(DroidWriterEditText.this) == null || DroidWriterEditText.access$2(DroidWriterEditText.this).isChecked() || obj == null) goto _L2; else goto _L16
_L16:
        int i2;
        int j1 = editable.getSpanStart(obj);
        i2 = editable.getSpanEnd(obj);
        editable.removeSpan(obj);
        if (j1 <= i - 1)
        {
            editable.setSpan(new UnderlineSpan(), j1, i - 1, 34);
        }
        if (i2 <= i) goto _L2; else goto _L17
_L17:
        editable.setSpan(new UnderlineSpan(), i, i2, 34);
        return;
        if (true) goto _L19; else goto _L18
_L18:
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    private ()
    {
        this$0 = DroidWriterEditText.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
