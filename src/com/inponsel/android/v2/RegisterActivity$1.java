// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.widget.Button;
import android.widget.DatePicker;
import com.inponsel.android.utils.Log;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

// Referenced classes of package com.inponsel.android.v2:
//            RegisterActivity

class this._cls0
    implements android.app.DateSetListener
{

    final RegisterActivity this$0;

    public void onDateSet(DatePicker datepicker, int i, int j, int k)
    {
        RegisterActivity.access$0(RegisterActivity.this, j + 1);
        RegisterActivity.access$1(RegisterActivity.this, k);
        Log.e("range", (new StringBuilder(String.valueOf(String.valueOf(i)))).append(">").append(String.valueOf(RegisterActivity.access$2(RegisterActivity.this) - 17)).toString());
        if (i <= c.get(1) - 17)
        {
            break MISSING_BLOCK_LABEL_343;
        }
        RegisterActivity.access$3(RegisterActivity.this, c.get(1) - 17);
_L1:
        selectDate = String.valueOf((new StringBuilder(String.valueOf(RegisterActivity.access$2(RegisterActivity.this)))).append("-").append(RegisterActivity.access$4(RegisterActivity.this)).append("-").append(RegisterActivity.access$5(RegisterActivity.this)).toString());
        datepicker = (new SimpleDateFormat("yyyy-MM-dd")).parse(selectDate);
        datepicker = (new SimpleDateFormat("E, dd MMM yyyy", Locale.US)).format(datepicker).replace("Jan", "Januari").replace("Feb", "Februari").replace("Mar", "Maret").replace("Apr", "April").replace("May", "Mei").replace("Jun", "Juni").replace("Jul", "Juli").replace("Aug", "Agustus").replace("Sept", "September").replace("Oct", "Oktober").replace("Nov", "November").replace("Dec", "Desember").replace("Mon", "Senin").replace("Tue", "Selasa").replace("Wed", "Rabu").replace("Thu", "Kamis").replace("Fri", "Jum'at").replace("Sat", "Sabtu").replace("Sun", "Minggu");
        btnTTL.setText(datepicker);
        return;
        try
        {
            RegisterActivity.access$3(RegisterActivity.this, i);
        }
        // Misplaced declaration of an exception variable
        catch (DatePicker datepicker)
        {
            return;
        }
          goto _L1
    }

    ner()
    {
        this$0 = RegisterActivity.this;
        super();
    }
}
