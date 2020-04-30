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
//            RoomPostBenchmark

class this._cls0
    implements android.view.
{

    final RoomPostBenchmark this$0;

    public void onClick(View view)
    {
        DatabaseHandler databasehandler;
        String s;
        String s1;
        String s2;
        if (!db.checkARTJudulIfExist(curtime, edtJudulAskHp.getText().toString().replace(".", "").trim()))
        {
            break MISSING_BLOCK_LABEL_188;
        }
        Toast.makeText(getApplicationContext(), "Berhasil memperbaharui", 1).show();
        databasehandler = db;
        s = curtime;
        s1 = edtJudulAskHp.getText().toString().replace(".", "").trim();
        s2 = benchmark_apps;
        if (photo_upload == null)
        {
            view = "";
            break MISSING_BLOCK_LABEL_126;
        }
        view = path_image;
          goto _L1
        Toast.makeText(getApplicationContext(), "Berhasil menyimpan", 1).show();
        databasehandler = db;
        s = id_hp;
        s1 = codename;
        s2 = (new StringBuilder("Benchmark ")).append(namalengkap).append(" - ").append(benchmark_apps).toString();
        s3 = benchmark_apps;
        if (photo_upload != null)
        {
            break MISSING_BLOCK_LABEL_335;
        }
        view = "";
_L2:
        databasehandler.addArtUser(s, s1, "benchmark", s2, s3, view, "", edtPertanyaan.getText().toString(), curtime);
        return;
_L1:
        String s3;
        try
        {
            databasehandler.update_byARTID(s, s1, s2, view, edtPertanyaan.getText().toString(), edtJudulAskHp.getText().toString().replace(".", "").trim());
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
        this$0 = RoomPostBenchmark.this;
        super();
    }
}
