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
//            ProfileActivity

class this._cls0
    implements android.app.nDateSetListener
{

    final ProfileActivity this$0;

    public void onDateSet(DatePicker datepicker, int i, int j, int k)
    {
        ProfileActivity.access$0(ProfileActivity.this, j + 1);
        ProfileActivity.access$1(ProfileActivity.this, k);
        Log.e("range", (new StringBuilder(String.valueOf(String.valueOf(i)))).append(">").append(String.valueOf(ProfileActivity.access$2(ProfileActivity.this) - 17)).toString());
        if (i <= c.get(1) - 17)
        {
            break MISSING_BLOCK_LABEL_343;
        }
        ProfileActivity.access$3(ProfileActivity.this, c.get(1) - 17);
_L1:
        selectDate = String.valueOf((new StringBuilder(String.valueOf(ProfileActivity.access$2(ProfileActivity.this)))).append("-").append(ProfileActivity.access$4(ProfileActivity.this)).append("-").append(ProfileActivity.access$5(ProfileActivity.this)).toString());
        datepicker = (new SimpleDateFormat("yyyy-MM-dd")).parse(selectDate);
        datepicker = (new SimpleDateFormat("E, dd MMM yyyy", Locale.US)).format(datepicker).replace("Jan", "Januari").replace("Feb", "Februari").replace("Mar", "Maret").replace("Apr", "April").replace("May", "Mei").replace("Jun", "Juni").replace("Jul", "Juli").replace("Aug", "Agustus").replace("Sept", "September").replace("Oct", "Oktober").replace("Nov", "November").replace("Dec", "Desember").replace("Mon", "Senin").replace("Tue", "Selasa").replace("Wed", "Rabu").replace("Thu", "Kamis").replace("Fri", "Jum'at").replace("Sat", "Sabtu").replace("Sun", "Minggu");
        btnTTLProfile.setText(datepicker);
        return;
        try
        {
            ProfileActivity.access$3(ProfileActivity.this, i);
        }
        // Misplaced declaration of an exception variable
        catch (DatePicker datepicker)
        {
            return;
        }
          goto _L1
    }

    ener()
    {
        this$0 = ProfileActivity.this;
        super();
    }
}
