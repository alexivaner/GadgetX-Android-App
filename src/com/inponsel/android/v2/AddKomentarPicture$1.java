// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.widget.RadioButton;
import android.widget.RadioGroup;

// Referenced classes of package com.inponsel.android.v2:
//            AddKomentarPicture

class this._cls0
    implements android.widget.hangeListener
{

    final AddKomentarPicture this$0;

    public void onCheckedChanged(RadioGroup radiogroup, int i)
    {
        if (rbHasilFoto.isChecked())
        {
            str_tag_komen = "1";
            return;
        }
        if (rbBenchmark.isChecked())
        {
            str_tag_komen = "2";
            return;
        }
        if (rbLainnya.isChecked())
        {
            str_tag_komen = "3";
            return;
        }
        if (komen_type.equals("ponsel"))
        {
            str_tag_komen = "";
            return;
        }
        if (komen_type.equals("berita"))
        {
            str_tag_komen = "-";
            return;
        }
        if (komen_type.equals("forum"))
        {
            str_tag_komen = "-";
            return;
        }
        if (komen_type.equals("servicecenter"))
        {
            str_tag_komen = "-";
            return;
        }
        if (komen_type.contains("appskategori"))
        {
            str_tag_komen = "-";
            str_tag_komen = "appsgamekategori";
            return;
        }
        if (komen_type.equals("conversation"))
        {
            str_tag_komen = "-";
            return;
        } else
        {
            str_tag_komen = "-";
            return;
        }
    }

    ener()
    {
        this$0 = AddKomentarPicture.this;
        super();
    }
}
