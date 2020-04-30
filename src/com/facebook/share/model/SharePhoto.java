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
//            ShareModel, ShareModelBuilder

public final class SharePhoto
    implements ShareModel
{
    public static final class Builder
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
            return new SharePhoto(this);
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

        public Builder readFrom(Parcel parcel)
        {
            return readFrom((SharePhoto)parcel.readParcelable(com/facebook/share/model/SharePhoto.getClassLoader()));
        }

        public Builder readFrom(SharePhoto sharephoto)
        {
            if (sharephoto == null)
            {
                return this;
            } else
            {
                return setBitmap(sharephoto.getBitmap()).setImageUrl(sharephoto.getImageUrl()).setUserGenerated(sharephoto.getUserGenerated());
            }
        }

        public Builder setBitmap(Bitmap bitmap1)
        {
            bitmap = bitmap1;
            return this;
        }

        public Builder setImageUrl(Uri uri)
        {
            imageUrl = uri;
            return this;
        }

        public Builder setUserGenerated(boolean flag)
        {
            userGenerated = flag;
            return this;
        }




        public Builder()
        {
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public SharePhoto createFromParcel(Parcel parcel)
        {
            return new SharePhoto(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public SharePhoto[] newArray(int i)
        {
            return new SharePhoto[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private final Bitmap bitmap;
    private final Uri imageUrl;
    private final boolean userGenerated;

    SharePhoto(Parcel parcel)
    {
        bitmap = (Bitmap)parcel.readParcelable(android/graphics/Bitmap.getClassLoader());
        imageUrl = (Uri)parcel.readParcelable(android/net/Uri.getClassLoader());
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        userGenerated = flag;
    }

    private SharePhoto(Builder builder)
    {
        bitmap = builder.bitmap;
        imageUrl = builder.imageUrl;
        userGenerated = builder.userGenerated;
    }


    public int describeContents()
    {
        return 0;
    }

    public Bitmap getBitmap()
    {
        return bitmap;
    }

    public Uri getImageUrl()
    {
        return imageUrl;
    }

    public boolean getUserGenerated()
    {
        return userGenerated;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        i = 0;
        parcel.writeParcelable(bitmap, 0);
        parcel.writeParcelable(imageUrl, 0);
        if (userGenerated)
        {
            i = 1;
        }
        parcel.writeByte((byte)i);
    }

}
