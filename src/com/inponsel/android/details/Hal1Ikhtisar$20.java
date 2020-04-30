// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;

// Referenced classes of package com.inponsel.android.details:
//            Hal1Ikhtisar

class this._cls0
    implements android.view.ener
{

    final Hal1Ikhtisar this$0;

    public void onClick(View view)
    {
        layout_empty.setVisibility(0);
        scrollIkhtisar.setVisibility(8);
        IkhtisarTask();
        try
        {
            view = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("my_vote_hp").append(Utility.BASE_FORMAT).append("?idhp=").append(id_hp).append("&email=").append(username).append("&t=").append(t).toString();
            Log.e("getnilai", view);
            (new MyNilai(Hal1Ikhtisar.this)).execute(new String[] {
                view
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return;
        }
    }

    MyNilai()
    {
        this$0 = Hal1Ikhtisar.this;
        super();
    }
}
