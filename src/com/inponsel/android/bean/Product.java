// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class Product
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Product createFromParcel(Parcel parcel)
        {
            return new Product(parcel, null);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Product[] newArray(int i)
        {
            return new Product[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private int id;
    private String imageUrl;
    private String name;
    private String sumber;

    public Product()
    {
    }

    private Product(Parcel parcel)
    {
        id = parcel.readInt();
        name = parcel.readString();
        sumber = parcel.readString();
        imageUrl = parcel.readString();
    }

    Product(Parcel parcel, Product product)
    {
        this(parcel);
    }

    public static android.os.Parcelable.Creator getCreator()
    {
        return CREATOR;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null)
            {
                return false;
            }
            if (getClass() != obj.getClass())
            {
                return false;
            }
            obj = (Product)obj;
            if (id != ((Product) (obj)).id)
            {
                return false;
            }
        }
        return true;
    }

    public int getId()
    {
        return id;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public String getName()
    {
        return name;
    }

    public String getSumber()
    {
        return sumber;
    }

    public int hashCode()
    {
        return id + 31;
    }

    public void setId(int i)
    {
        id = i;
    }

    public void setImageUrl(String s)
    {
        imageUrl = s;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setSumber(String s)
    {
        sumber = s;
    }

    public String toString()
    {
        return (new StringBuilder("Product [id=")).append(id).append(", name=").append(name).append(", sumber=").append(sumber).append(", imageUrl=").append(imageUrl).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(getId());
        parcel.writeString(getName());
        parcel.writeString(getSumber());
        parcel.writeString(getImageUrl());
    }

}
