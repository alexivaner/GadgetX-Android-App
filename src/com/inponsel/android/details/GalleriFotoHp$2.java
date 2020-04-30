// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.view.View;
import android.widget.ProgressBar;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;

// Referenced classes of package com.inponsel.android.details:
//            GalleriFotoHp

class this._cls0
    implements android.view.ener
{

    final GalleriFotoHp this$0;

    public void onClick(View view)
    {
        dataGallery = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("gallery_hp").append(Utility.BASE_FORMAT).append("?id_hp=").append(id_hp).append("&t=").append(t).toString();
        Log.e("dataGallery", dataGallery);
        midProgressBar.setVisibility(0);
        GalleryTask();
    }

    ()
    {
        this$0 = GalleriFotoHp.this;
        super();
    }
}
