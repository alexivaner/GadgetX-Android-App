// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import java.io.File;
import java.io.IOException;

// Referenced classes of package com.inponsel.android.v2:
//            RoomPostHasilFotoNoCrop

class this._cls0
    implements android.content.tener
{

    final RoomPostHasilFotoNoCrop this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (i == 0)
        {
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            try
            {
                File file = RoomPostHasilFotoNoCrop.access$5(RoomPostHasilFotoNoCrop.this);
                RoomPostHasilFotoNoCrop.access$6(RoomPostHasilFotoNoCrop.this, file.getAbsolutePath());
                intent.putExtra("output", Uri.fromFile(file));
            }
            catch (IOException ioexception)
            {
                ioexception.printStackTrace();
                RoomPostHasilFotoNoCrop.access$6(RoomPostHasilFotoNoCrop.this, null);
            }
            dialoginterface.cancel();
            startActivityForResult(intent, 1);
            return;
        } else
        {
            dialoginterface = new Intent("android.intent.action.PICK");
            dialoginterface.setType("image/*");
            startActivityForResult(Intent.createChooser(dialoginterface, "Complete action using"), 2);
            return;
        }
    }

    ()
    {
        this$0 = RoomPostHasilFotoNoCrop.this;
        super();
    }
}
