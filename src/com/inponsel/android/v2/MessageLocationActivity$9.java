// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.widget.Toast;
import com.android.volley.VolleyError;
import com.inponsel.android.utils.Log;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;

// Referenced classes of package com.inponsel.android.v2:
//            MessageLocationActivity

class this._cls0
    implements com.android.volley.ty._cls9
{

    final MessageLocationActivity this$0;

    public void onErrorResponse(VolleyError volleyerror)
    {
        Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
        progbar_location.setVisibility(8);
        Toast.makeText(getApplicationContext(), "Gagal mengirim lokasi", 1).show();
    }

    ressBar()
    {
        this$0 = MessageLocationActivity.this;
        super();
    }
}
