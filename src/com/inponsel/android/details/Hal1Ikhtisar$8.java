// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.RoomChatActivity;

// Referenced classes of package com.inponsel.android.details:
//            Hal1Ikhtisar

class this._cls0
    implements android.view.tener
{

    final Hal1Ikhtisar this$0;

    public void onClick(View view)
    {
        if (userFunction.isUserLoggedIn(getActivity()))
        {
            view = new Intent(getActivity(), com/inponsel/android/v2/RoomChatActivity);
            view.putExtra("id_from", user_id);
            view.putExtra("from_name", username);
            view.putExtra("from_photo", user_photo);
            view.putExtra("to_photo", gambar);
            view.putExtra("merk", merk);
            view.putExtra("model", model);
            view.putExtra("codename", (new StringBuilder(String.valueOf(codename))).append("-").append(codename).toString());
            view.putExtra("id_hph", id_hp);
            Hal1Ikhtisar.access$0(Hal1Ikhtisar.this, user_id, codename, "1", t, "");
            startActivityForResult(view, 0);
            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            return;
        } else
        {
            Hal1Ikhtisar.access$1(Hal1Ikhtisar.this, "Perhatian", "Untuk masuk ke chat room diharuskan login dahulu");
            return;
        }
    }

    ()
    {
        this$0 = Hal1Ikhtisar.this;
        super();
    }
}
