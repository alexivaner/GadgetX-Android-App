// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.view.View;
import android.widget.Toast;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.io.File;

// Referenced classes of package com.inponsel.android.v2:
//            ProfileActivity

class this._cls0
    implements android.view.er
{

    final ProfileActivity this$0;

    public void onClick(View view)
    {
        view = new android.app.r(wrapper);
        view.setMessage("Hapus cache?");
        view.setPositiveButton("Gambar", new android.content.DialogInterface.OnClickListener() {

            final ProfileActivity._cls7 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                imageLoader2.clearMemoryCache();
                Toast.makeText(getApplicationContext(), "Cache gambar berhasil di hapus", 1).show();
            }

            
            {
                this$1 = ProfileActivity._cls7.this;
                super();
            }
        });
        view.setNegativeButton("Data", new android.content.DialogInterface.OnClickListener() {

            final ProfileActivity._cls7 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                (new File("/data/data/com.inponsel.android/shared_prefs/inponsel_preference.xml")).delete();
                dialoginterface.dismiss();
                Toast.makeText(getApplicationContext(), "Cache data berhasil di hapus", 1).show();
            }

            
            {
                this$1 = ProfileActivity._cls7.this;
                super();
            }
        });
        view.show();
    }


    _cls2.this._cls1()
    {
        this$0 = ProfileActivity.this;
        super();
    }
}
