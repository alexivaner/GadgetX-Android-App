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
//            RoomPostPertanyaan

class this._cls0
    implements android.view.rtanyaan._cls3
{

    final RoomPostPertanyaan this$0;

    public void onClick(View view)
    {
        DatabaseHandler databasehandler;
        String s;
        String s1;
        if (!db.checkARTJudulIfExist(curtime, edtJudulAskHp.getText().toString()))
        {
            break MISSING_BLOCK_LABEL_136;
        }
        Toast.makeText(getApplicationContext(), "Berhasil memperbaharui", 1).show();
        databasehandler = db;
        s = curtime;
        s1 = edtJudulAskHp.getText().toString();
        if (photo_upload == null)
        {
            view = "";
            break MISSING_BLOCK_LABEL_97;
        }
        view = path_image;
          goto _L1
        Toast.makeText(getApplicationContext(), "Berhasil menyimpan", 1).show();
        databasehandler = db;
        s = id_hp;
        s1 = codename;
        s2 = edtJudulAskHp.getText().toString();
        if (photo_upload != null)
        {
            break MISSING_BLOCK_LABEL_252;
        }
        view = "";
_L2:
        databasehandler.addArtUser(s, s1, "faqhp", s2, "0", view, edtPertanyaan.getText().toString(), "", curtime);
        return;
_L1:
        String s2;
        try
        {
            databasehandler.update_byARTID(s, s1, "0", view, edtPertanyaan.getText().toString(), "");
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
        this$0 = RoomPostPertanyaan.this;
        super();
    }
}
