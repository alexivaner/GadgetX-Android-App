// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Html;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.CharacterStyle;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ToggleButton;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Utility;

public class DroidWriterEditText extends EditText
{
    private class DWTextWatcher
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
            if (boldToggle == null) goto _L6; else goto _L5
_L5:
            if (!boldToggle.isChecked() || stylespan != null) goto _L8; else goto _L7
_L7:
            editable.setSpan(new StyleSpan(1), i - 1, i, 34);
_L6:
            StyleSpan stylespan1;
            StyleSpan stylespan2;
            UnderlineSpan underlinespan;
            if (italicsToggle != null && italicsToggle.isChecked() && obj1 == null)
            {
                editable.setSpan(new StyleSpan(2), i - 1, i, 34);
            } else
            if (italicsToggle != null && !italicsToggle.isChecked() && obj1 != null)
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
            if (underlineToggle == null || !underlineToggle.isChecked() || obj != null) goto _L10; else goto _L9
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
            if (!boldToggle.isChecked() && stylespan != null)
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
            if (underlineToggle == null || underlineToggle.isChecked() || obj == null) goto _L2; else goto _L16
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

        private DWTextWatcher()
        {
            this$0 = DroidWriterEditText.this;
            super();
        }

        DWTextWatcher(DWTextWatcher dwtextwatcher)
        {
            this();
        }
    }


    private static final int STYLE_BOLD = 0;
    private static final int STYLE_ITALIC = 1;
    private static final int STYLE_UNDERLINED = 2;
    public static final String TAG = "DroidWriter";
    private ToggleButton boldToggle;
    private android.text.Html.ImageGetter imageGetter;
    private ToggleButton italicsToggle;
    private ToggleButton underlineToggle;

    public DroidWriterEditText(Context context)
    {
        super(context);
        initialize();
    }

    public DroidWriterEditText(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        initialize();
    }

    public DroidWriterEditText(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        initialize();
    }

    private void initialize()
    {
        imageGetter = new android.text.Html.ImageGetter() {

            final DroidWriterEditText this$0;

            public Drawable getDrawable(String s)
            {
                Log.e("drwa", s);
                int i = getResources().getIdentifier(s, "drawable", "com.inponsel.android");
                s = getResources().getDrawable(i);
                if (Utility.isTabletMDPI(getContext()))
                {
                    s.setBounds(0, 0, 25, 25);
                    Log.e("isTabletMDPI", "isTabletMDPI");
                    return s;
                }
                if (Utility.isXXHDPI(getContext()))
                {
                    Log.e("isXXHDPI", "isXXHDPI");
                    s.setBounds(0, 0, 80, 80);
                    return s;
                } else
                {
                    Log.e("else", "else");
                    s.setBounds(0, 0, 90, 90);
                    return s;
                }
            }

            
            {
                this$0 = DroidWriterEditText.this;
                super();
            }
        };
        addTextChangedListener(new DWTextWatcher(null));
    }

    private void toggleStyle(int i)
    {
        int j;
        int k;
        int i1 = getSelectionStart();
        int l = getSelectionEnd();
        k = l;
        j = i1;
        if (i1 > l)
        {
            k = i1;
            j = l;
        }
        if (k <= j) goto _L2; else goto _L1
_L1:
        Editable editable;
        boolean flag;
        boolean flag3;
        boolean flag4;
        editable = getText();
        flag3 = false;
        flag4 = false;
        flag = false;
        i;
        JVM INSTR tableswitch 0 2: default 84
    //                   0 85
    //                   1 172
    //                   2 263;
           goto _L2 _L3 _L4 _L5
_L2:
        return;
_L3:
        StyleSpan astylespan[] = (StyleSpan[])editable.getSpans(j, k, android/text/style/StyleSpan);
        i = 0;
        do
        {
            if (i >= astylespan.length)
            {
                if (!flag)
                {
                    editable.setSpan(new StyleSpan(1), j, k, 34);
                }
                setSelection(j, k);
                return;
            }
            if (astylespan[i].getStyle() == 1)
            {
                editable.removeSpan(astylespan[i]);
                flag = true;
            }
            i++;
        } while (true);
_L4:
        StyleSpan astylespan1[] = (StyleSpan[])editable.getSpans(j, k, android/text/style/StyleSpan);
        i = 0;
        boolean flag1 = flag3;
        do
        {
            if (i >= astylespan1.length)
            {
                if (!flag1)
                {
                    editable.setSpan(new StyleSpan(2), j, k, 34);
                }
                setSelection(j, k);
                return;
            }
            if (astylespan1[i].getStyle() == 2)
            {
                editable.removeSpan(astylespan1[i]);
                flag1 = true;
            }
            i++;
        } while (true);
_L5:
        UnderlineSpan aunderlinespan[] = (UnderlineSpan[])editable.getSpans(j, k, android/text/style/UnderlineSpan);
        i = 0;
        boolean flag2 = flag4;
        do
        {
            if (i >= aunderlinespan.length)
            {
                if (!flag2)
                {
                    editable.setSpan(new UnderlineSpan(), j, k, 34);
                }
                setSelection(j, k);
                return;
            }
            editable.removeSpan(aunderlinespan[i]);
            flag2 = true;
            i++;
        } while (true);
    }

    public Spanned getSpannedText()
    {
        return getText();
    }

    public String getStringText()
    {
        return getText().toString();
    }

    public String getTextHTML()
    {
        return Html.toHtml(getText());
    }

    public void gettter()
    {
    }

    public void onSelectionChanged(int i, int j)
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        int l;
        int i1;
        int j1;
        flag2 = false;
        flag1 = false;
        l = 0;
        flag = false;
        j1 = 0;
        i1 = 0;
        if (i <= 0 || i != j) goto _L2; else goto _L1
_L1:
        CharacterStyle acharacterstyle[];
        acharacterstyle = (CharacterStyle[])getText().getSpans(i - 1, i, android/text/style/CharacterStyle);
        l = 0;
        i = i1;
        j = ((flag1) ? 1 : 0);
_L13:
        if (l < acharacterstyle.length) goto _L4; else goto _L3
_L3:
        int k1;
        l = i;
        i1 = ((flag) ? 1 : 0);
        k1 = j;
_L11:
        int k;
        if (boldToggle != null)
        {
            if (k1 != 0)
            {
                boldToggle.setChecked(true);
            } else
            {
                boldToggle.setChecked(false);
            }
        }
        if (italicsToggle != null)
        {
            if (i1 != 0)
            {
                italicsToggle.setChecked(true);
            } else
            {
                italicsToggle.setChecked(false);
            }
        }
        if (underlineToggle != null)
        {
            if (l == 0)
            {
                break; /* Loop/switch isn't completed */
            }
            underlineToggle.setChecked(true);
        }
        return;
_L4:
        if (!(acharacterstyle[l] instanceof StyleSpan)) goto _L6; else goto _L5
_L5:
        if (((StyleSpan)acharacterstyle[l]).getStyle() != 1) goto _L8; else goto _L7
_L7:
        k = 1;
        i1 = i;
        flag2 = flag;
_L9:
        l++;
        j = k;
        flag = flag2;
        i = i1;
        continue; /* Loop/switch isn't completed */
_L8:
        if (((StyleSpan)acharacterstyle[l]).getStyle() == 2)
        {
            flag2 = true;
            k = j;
            i1 = i;
        } else
        {
            k = j;
            flag2 = flag;
            i1 = i;
            if (((StyleSpan)acharacterstyle[l]).getStyle() == 3)
            {
                flag2 = true;
                k = 1;
                i1 = i;
            }
        }
        continue; /* Loop/switch isn't completed */
_L6:
        k = j;
        flag2 = flag;
        i1 = i;
        if (acharacterstyle[l] instanceof UnderlineSpan)
        {
            i1 = 1;
            k = j;
            flag2 = flag;
        }
        if (true) goto _L9; else goto _L2
_L2:
        acharacterstyle = (CharacterStyle[])getText().getSpans(i, j, android/text/style/CharacterStyle);
        i1 = 0;
        flag = j1;
        k = l;
        j1 = i1;
        do
        {
            k1 = ((flag2) ? 1 : 0);
            i1 = k;
            l = ((flag) ? 1 : 0);
            if (j1 >= acharacterstyle.length)
            {
                break;
            }
            if (acharacterstyle[j1] instanceof StyleSpan)
            {
                if (((StyleSpan)acharacterstyle[j1]).getStyle() == 1)
                {
                    l = ((flag2) ? 1 : 0);
                    i1 = k;
                    k1 = ((flag) ? 1 : 0);
                    if (getText().getSpanStart(acharacterstyle[j1]) <= i)
                    {
                        l = ((flag2) ? 1 : 0);
                        i1 = k;
                        k1 = ((flag) ? 1 : 0);
                        if (getText().getSpanEnd(acharacterstyle[j1]) >= j)
                        {
                            l = 1;
                            k1 = ((flag) ? 1 : 0);
                            i1 = k;
                        }
                    }
                } else
                if (((StyleSpan)acharacterstyle[j1]).getStyle() == 2)
                {
                    l = ((flag2) ? 1 : 0);
                    i1 = k;
                    k1 = ((flag) ? 1 : 0);
                    if (getText().getSpanStart(acharacterstyle[j1]) <= i)
                    {
                        l = ((flag2) ? 1 : 0);
                        i1 = k;
                        k1 = ((flag) ? 1 : 0);
                        if (getText().getSpanEnd(acharacterstyle[j1]) >= j)
                        {
                            i1 = 1;
                            l = ((flag2) ? 1 : 0);
                            k1 = ((flag) ? 1 : 0);
                        }
                    }
                } else
                {
                    l = ((flag2) ? 1 : 0);
                    i1 = k;
                    k1 = ((flag) ? 1 : 0);
                    if (((StyleSpan)acharacterstyle[j1]).getStyle() == 3)
                    {
                        l = ((flag2) ? 1 : 0);
                        i1 = k;
                        k1 = ((flag) ? 1 : 0);
                        if (getText().getSpanStart(acharacterstyle[j1]) <= i)
                        {
                            l = ((flag2) ? 1 : 0);
                            i1 = k;
                            k1 = ((flag) ? 1 : 0);
                            if (getText().getSpanEnd(acharacterstyle[j1]) >= j)
                            {
                                i1 = 1;
                                l = 1;
                                k1 = ((flag) ? 1 : 0);
                            }
                        }
                    }
                }
            } else
            {
                l = ((flag2) ? 1 : 0);
                i1 = k;
                k1 = ((flag) ? 1 : 0);
                if (acharacterstyle[j1] instanceof UnderlineSpan)
                {
                    l = ((flag2) ? 1 : 0);
                    i1 = k;
                    k1 = ((flag) ? 1 : 0);
                    if (getText().getSpanStart(acharacterstyle[j1]) <= i)
                    {
                        l = ((flag2) ? 1 : 0);
                        i1 = k;
                        k1 = ((flag) ? 1 : 0);
                        if (getText().getSpanEnd(acharacterstyle[j1]) >= j)
                        {
                            k1 = 1;
                            l = ((flag2) ? 1 : 0);
                            i1 = k;
                        }
                    }
                }
            }
            j1++;
            flag2 = l;
            k = i1;
            flag = k1;
        } while (true);
        if (true) goto _L11; else goto _L10
_L10:
        underlineToggle.setChecked(false);
        return;
        if (true) goto _L13; else goto _L12
_L12:
    }

    public void setBoldToggleButton(ToggleButton togglebutton)
    {
        boldToggle = togglebutton;
        boldToggle.setOnClickListener(new android.view.View.OnClickListener() {

            final DroidWriterEditText this$0;

            public void onClick(View view)
            {
                toggleStyle(0);
            }

            
            {
                this$0 = DroidWriterEditText.this;
                super();
            }
        });
    }

    public void setClearButton(View view)
    {
        view.setOnClickListener(new android.view.View.OnClickListener() {

            final DroidWriterEditText this$0;

            public void onClick(View view1)
            {
                setText("");
            }

            
            {
                this$0 = DroidWriterEditText.this;
                super();
            }
        });
    }

    public void setImageGetter(android.text.Html.ImageGetter imagegetter)
    {
        imageGetter = imagegetter;
    }

    public void setImageInsertButton(View view, final String imageResource)
    {
        view.setOnClickListener(new android.view.View.OnClickListener() {

            final DroidWriterEditText this$0;
            private final String val$imageResource;

            public void onClick(View view1)
            {
                int i = Selection.getSelectionStart(getText());
                view1 = Html.fromHtml((new StringBuilder("<img src=\"")).append(imageResource).append("\">").toString(), imageGetter, null);
                getText().insert(i, view1);
            }

            
            {
                this$0 = DroidWriterEditText.this;
                imageResource = s;
                super();
            }
        });
    }

    public void setImageInsertGrid(String s)
    {
        int i = Selection.getSelectionStart(getText());
        s = Html.fromHtml((new StringBuilder("<img src=\"")).append(s).append("\">").toString(), new android.text.Html.ImageGetter() {

            final DroidWriterEditText this$0;

            public Drawable getDrawable(String s1)
            {
                int j = getResources().getIdentifier(s1, "drawable", getContext().getPackageName());
                s1 = getResources().getDrawable(j);
                s1.setBounds(0, 0, 25, 25);
                return s1;
            }

            
            {
                this$0 = DroidWriterEditText.this;
                super();
            }
        }, null);
        getText().insert(i, s);
    }

    public void setItalicsToggleButton(ToggleButton togglebutton)
    {
        italicsToggle = togglebutton;
        italicsToggle.setOnClickListener(new android.view.View.OnClickListener() {

            final DroidWriterEditText this$0;

            public void onClick(View view)
            {
                toggleStyle(1);
            }

            
            {
                this$0 = DroidWriterEditText.this;
                super();
            }
        });
    }

    public void setSpannedText(Spanned spanned)
    {
        setText(spanned);
    }

    public void setStringText(String s)
    {
        setText(s);
    }

    public void setTextHTML(String s)
    {
        setText(Html.fromHtml(s, imageGetter, null));
    }

    public void setUnderlineToggleButton(ToggleButton togglebutton)
    {
        underlineToggle = togglebutton;
        underlineToggle.setOnClickListener(new android.view.View.OnClickListener() {

            final DroidWriterEditText this$0;

            public void onClick(View view)
            {
                toggleStyle(2);
            }

            
            {
                this$0 = DroidWriterEditText.this;
                super();
            }
        });
    }





}
