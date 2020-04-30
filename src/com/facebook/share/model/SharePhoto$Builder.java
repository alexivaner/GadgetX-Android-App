// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.facebook.share.model:
//            ShareModelBuilder, SharePhoto, ShareModel

public static final class 
    implements ShareModelBuilder
{

    private Bitmap bitmap;
    private Uri imageUrl;
    private boolean userGenerated;

    public static List readListFrom(Parcel parcel)
    {
        ArrayList arraylist = new ArrayList();
        parcel.readTypedList(arraylist, SharePhoto.CREATOR);
        return arraylist;
    }

    public static void writeListTo(Parcel parcel, List list)
    {
        ArrayList arraylist = new ArrayList();
        for (list = list.iterator(); list.hasNext(); arraylist.add((SharePhoto)list.next())) { }
        parcel.writeTypedList(arraylist);
    }

    public SharePhoto build()
    {
        return new SharePhoto(this, null);
    }

    public volatile Object build()
    {
        return build();
    }

    Bitmap getBitmap()
    {
        return bitmap;
    }

    Uri getImageUrl()
    {
        return imageUrl;
    }

    public volatile ShareModelBuilder readFrom(Parcel parcel)
    {
        return readFrom(parcel);
    }

    public volatile ShareModelBuilder readFrom(ShareModel sharemodel)
    {
        return readFrom((SharePhoto)sharemodel);
    }

    public readFrom readFrom(Parcel parcel)
    {
        return readFrom((SharePhoto)parcel.readParcelable(com/facebook/share/model/SharePhoto.getClassLoader()));
    }

    public readFrom readFrom(SharePhoto sharephoto)
    {
        if (sharephoto == null)
        {
            return this;
        } else
        {
            return setBitmap(sharephoto.getBitmap()).setImageUrl(sharephoto.getImageUrl()).setUserGenerated(sharephoto.getUserGenerated());
        }
    }

    public enerated setBitmap(Bitmap bitmap1)
    {
        bitmap = bitmap1;
        return this;
    }

    public bitmap setImageUrl(Uri uri)
    {
        imageUrl = uri;
        return this;
    }

    public imageUrl setUserGenerated(boolean flag)
    {
        userGenerated = flag;
        return this;
    }




    public ()
    {
    }
}
