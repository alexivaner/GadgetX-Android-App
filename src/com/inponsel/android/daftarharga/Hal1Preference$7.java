// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.daftarharga;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageButton;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;

// Referenced classes of package com.inponsel.android.daftarharga:
//            Hal1Preference

class this._cls0
    implements TextWatcher
{

    final Hal1Preference this$0;

    public void afterTextChanged(Editable editable)
    {
        int i;
        int j;
        if (edtHarga.getText().toString().length() < 6)
        {
            btnCari.setEnabled(false);
        } else
        {
            btnCari.setEnabled(true);
        }
        edtHarga.removeTextChangedListener(this);
        i = edtHarga.getText().length();
        v = editable.toString().substring(0, i);
        v = v.replace(".", ",");
        v = v.replace(String.valueOf(Hal1Preference.access$0(Hal1Preference.this).getDecimalFormatSymbols().getGroupingSeparator()), "");
        editable = Hal1Preference.access$0(Hal1Preference.this).parse(v);
        j = edtHarga.getSelectionStart();
        if (!Hal1Preference.access$2(Hal1Preference.this)) goto _L2; else goto _L1
_L1:
        display = Hal1Preference.access$0(Hal1Preference.this).format(editable);
        display = display.replace(",", ".");
        display = display.substring(0, display.length() - 1);
        edtHarga.setText(display);
_L3:
        i = j + (edtHarga.getText().length() - i);
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_399;
        }
        if (i > edtHarga.getText().length())
        {
            break MISSING_BLOCK_LABEL_399;
        }
        edtHarga.setSelection(i);
_L4:
        edtHarga.addTextChangedListener(this);
        return;
_L2:
        display = Hal1Preference.access$3(Hal1Preference.this).format(editable);
        display = display.replace(",", ".");
        edtHarga.setText(display);
          goto _L3
        try
        {
            edtHarga.setSelection(edtHarga.getText().length() - 1);
        }
        // Misplaced declaration of an exception variable
        catch (Editable editable) { }
        // Misplaced declaration of an exception variable
        catch (Editable editable) { }
          goto _L4
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        if (edtHarga.getText().toString().length() < 6)
        {
            btnCari.setEnabled(false);
        } else
        {
            btnCari.setEnabled(true);
        }
        if (charsequence.toString().contains(String.valueOf(Hal1Preference.access$0(Hal1Preference.this).getDecimalFormatSymbols().getDecimalSeparator())))
        {
            Hal1Preference.access$1(Hal1Preference.this, true);
            return;
        } else
        {
            Hal1Preference.access$1(Hal1Preference.this, false);
            return;
        }
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        if (edtHarga.getText().toString().length() < 6)
        {
            btnCari.setEnabled(false);
            return;
        } else
        {
            btnCari.setEnabled(true);
            return;
        }
    }

    ()
    {
        this$0 = Hal1Preference.this;
        super();
    }
}
