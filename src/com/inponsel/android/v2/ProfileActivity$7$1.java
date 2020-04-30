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

class this._cls1
    implements android.content.ickListener
{

    final pplicationContext this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        imageLoader2.clearMemoryCache();
        Toast.makeText(getApplicationContext(), "Cache gambar berhasil di hapus", 1).show();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/ProfileActivity$7

/* anonymous class */
    class ProfileActivity._cls7
        implements android.view.View.OnClickListener
    {

        final ProfileActivity this$0;

        public void onClick(View view)
        {
            view = new android.app.AlertDialog.Builder(wrapper);
            view.setMessage("Hapus cache?");
            view.setPositiveButton("Gambar", new ProfileActivity._cls7._cls1());
            view.setNegativeButton("Data", new ProfileActivity._cls7._cls2());
            view.show();
        }


            
            {
                this$0 = ProfileActivity.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/ProfileActivity$7$2

/* anonymous class */
        class ProfileActivity._cls7._cls2
            implements android.content.DialogInterface.OnClickListener
        {

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
        }

    }

}
