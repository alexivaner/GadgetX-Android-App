// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.view.View;
import android.widget.ImageView;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.v2:
//            RoomPostHasilFotoNoCrop

class this._cls0
    implements android.view.toNoCrop._cls3
{

    final RoomPostHasilFotoNoCrop this$0;

    public void onClick(View view)
    {
        photo_upload = Bitmap.createBitmap(photo_upload);
        Log.e("photo_uploadRight", String.valueOf(photo_upload));
        int i = photo_upload.getWidth();
        int j = photo_upload.getHeight();
        Log.e("width", String.valueOf(i));
        Log.e("width", String.valueOf(i));
        try
        {
            Log.e("rotate", String.valueOf(rotate));
            int k = (new ExifInterface(camera_path)).getAttributeInt("Orientation", 1);
            rotate = RoomPostHasilFotoNoCrop.access$4(k);
            view = new Matrix();
            view.postRotate(rotate);
            photo_upload = Bitmap.createBitmap(photo_upload, 0, 0, i, j, view, true);
            imgAskHp.setImageBitmap(photo_upload);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
        }
    }

    ()
    {
        this$0 = RoomPostHasilFotoNoCrop.this;
        super();
    }
}
