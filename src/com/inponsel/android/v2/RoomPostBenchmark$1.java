// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;

// Referenced classes of package com.inponsel.android.v2:
//            RoomPostBenchmark

class this._cls0
    implements TextWatcher
{

    final RoomPostBenchmark this$0;

    public void afterTextChanged(Editable editable)
    {
        edtJudulAskHp.removeTextChangedListener(this);
        int i;
        int j;
        i = edtJudulAskHp.getText().length();
        v = editable.toString().substring(0, i);
        v = v.replace(".", ",");
        v = v.replace(String.valueOf(RoomPostBenchmark.access$3(RoomPostBenchmark.this).getDecimalFormatSymbols().getGroupingSeparator()), "");
        editable = RoomPostBenchmark.access$3(RoomPostBenchmark.this).parse(v);
        j = edtJudulAskHp.getSelectionStart();
        if (!RoomPostBenchmark.access$5(RoomPostBenchmark.this)) goto _L2; else goto _L1
_L1:
        display = RoomPostBenchmark.access$3(RoomPostBenchmark.this).format(editable);
        display = display.replace(",", ".");
        display = display.substring(0, display.length() - 1);
        edtJudulAskHp.setText(display);
_L3:
        i = j + (edtJudulAskHp.getText().length() - i);
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_351;
        }
        if (i > edtJudulAskHp.getText().length())
        {
            break MISSING_BLOCK_LABEL_351;
        }
        edtJudulAskHp.setSelection(i);
_L4:
        edtJudulAskHp.addTextChangedListener(this);
        return;
_L2:
        display = RoomPostBenchmark.access$6(RoomPostBenchmark.this).format(editable);
        display = display.replace(",", ".");
        edtJudulAskHp.setText(display);
          goto _L3
        try
        {
            edtJudulAskHp.setSelection(edtJudulAskHp.getText().length() - 1);
        }
        // Misplaced declaration of an exception variable
        catch (Editable editable) { }
        // Misplaced declaration of an exception variable
        catch (Editable editable) { }
          goto _L4
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        if (charsequence.toString().contains(String.valueOf(RoomPostBenchmark.access$3(RoomPostBenchmark.this).getDecimalFormatSymbols().getDecimalSeparator())))
        {
            RoomPostBenchmark.access$4(RoomPostBenchmark.this, true);
            return;
        } else
        {
            RoomPostBenchmark.access$4(RoomPostBenchmark.this, false);
            return;
        }
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        if (edtJudulAskHp.getText().length() > 0)
        {
            btnPostAskHp.setEnabled(true);
            btnSaveAskHp.setEnabled(true);
            return;
        } else
        {
            btnPostAskHp.setEnabled(false);
            btnSaveAskHp.setEnabled(false);
            return;
        }
    }

    ()
    {
        this$0 = RoomPostBenchmark.this;
        super();
    }
}
