// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.scdetail;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.v2.AddKomentarPicture;

// Referenced classes of package com.inponsel.android.scdetail:
//            Hal1SCDetail

class this._cls0
    implements android.view.ener
{

    final Hal1SCDetail this$0;

    public void onClick(View view)
    {
        view = new Intent(getActivity(), com/inponsel/android/v2/AddKomentarPicture);
        view.putExtra("komen_type", "servicecenter");
        view.putExtra("id_sc", str_SC_ID);
        view.putExtra("sc_nama", str_SC_NAMA);
        view.putExtra("top_id", top_id);
        Log.e("top_id", top_id);
        startActivityForResult(view, Hal1SCDetail.access$6());
    }

    ()
    {
        this$0 = Hal1SCDetail.this;
        super();
    }
}
