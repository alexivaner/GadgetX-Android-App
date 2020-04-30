// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.inponsel.android.utils.DatabaseHandler;

// Referenced classes of package com.inponsel.android.v2:
//            RoomPostHasilFotoNoCrop

class this._cls0
    implements android.view.toNoCrop._cls8
{

    final RoomPostHasilFotoNoCrop this$0;

    public void onClick(View view)
    {
        DatabaseHandler databasehandler;
        String s;
        String s1;
        String s2;
        if (!db.checkARTJudulIfExist(curtime, (new StringBuilder("Hasil kamera: ")).append(namalengkap).toString()))
        {
            break MISSING_BLOCK_LABEL_164;
        }
        Toast.makeText(getApplicationContext(), "Berhasil memperbaharui", 1).show();
        databasehandler = db;
        s = curtime;
        s1 = (new StringBuilder("Hasil kamera: ")).append(namalengkap).toString();
        s2 = cahaya_kond;
        if (photo_upload == null)
        {
            view = "";
            break MISSING_BLOCK_LABEL_120;
        }
        view = path_image;
          goto _L1
        Toast.makeText(getApplicationContext(), "Berhasil menyimpan", 1).show();
        databasehandler = db;
        s = id_hp;
        s1 = codename;
        s2 = (new StringBuilder("Hasil kamera: ")).append(namalengkap).toString();
        s3 = cahaya_kond;
        if (photo_upload != null)
        {
            break MISSING_BLOCK_LABEL_301;
        }
        view = "";
_L2:
        databasehandler.addArtUser(s, s1, "hasilkamera", s2, s3, view, edtPertanyaan.getText().toString(), led_flash, curtime);
        return;
_L1:
        String s3;
        try
        {
            databasehandler.update_byARTID(s, s1, s2, view, edtPertanyaan.getText().toString(), led_flash);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
        }
        return;
        view = path_image;
          goto _L2
    }

    ()
    {
        this$0 = RoomPostHasilFotoNoCrop.this;
        super();
    }
}
