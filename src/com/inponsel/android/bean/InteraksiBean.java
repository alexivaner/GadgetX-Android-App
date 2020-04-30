// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class InteraksiBean
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public InteraksiBean createFromParcel(Parcel parcel)
        {
            return new InteraksiBean(parcel, null);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public InteraksiBean[] newArray(int i)
        {
            return new InteraksiBean[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private String codename;
    private int id;
    private String id_hp;
    String komentar;
    private String nama_komentar;
    private String namalengkap;
    private String tanggal_komentar;
    private String user_avatar;

    public InteraksiBean()
    {
    }

    private InteraksiBean(Parcel parcel)
    {
        id = parcel.readInt();
        id_hp = parcel.readString();
        codename = parcel.readString();
        namalengkap = parcel.readString();
        nama_komentar = parcel.readString();
        komentar = parcel.readString();
        tanggal_komentar = parcel.readString();
        user_avatar = parcel.readString();
    }

    InteraksiBean(Parcel parcel, InteraksiBean interaksibean)
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
            obj = (InteraksiBean)obj;
            if (id != ((InteraksiBean) (obj)).id)
            {
                return false;
            }
        }
        return true;
    }

    public String getCodename()
    {
        return codename;
    }

    public int getId()
    {
        return id;
    }

    public String getId_hp()
    {
        return id_hp;
    }

    public String getKomentar()
    {
        return komentar;
    }

    public String getNama_komentar()
    {
        return nama_komentar;
    }

    public String getNamalengkap()
    {
        return namalengkap;
    }

    public String getTanggal_komentar()
    {
        return tanggal_komentar;
    }

    public String getUser_avatar()
    {
        return user_avatar;
    }

    public int hashCode()
    {
        return id + 31;
    }

    public void setCodename(String s)
    {
        codename = s;
    }

    public void setId(int i)
    {
        id = i;
    }

    public void setId_hp(String s)
    {
        id_hp = s;
    }

    public void setKomentar(String s)
    {
        komentar = s;
    }

    public void setNama_komentar(String s)
    {
        nama_komentar = s;
    }

    public void setNamalengkap(String s)
    {
        namalengkap = s;
    }

    public void setTanggal_komentar(String s)
    {
        tanggal_komentar = s;
    }

    public void setUser_avatar(String s)
    {
        user_avatar = s;
    }

    public String toString()
    {
        return (new StringBuilder("Product [id=")).append(id).append(", id_hp=").append(id_hp).append(", codename=").append(codename).append(", namalengkap=").append(namalengkap).append(", nama_komentar=").append(nama_komentar).append(", tanggal_komentar=").append(tanggal_komentar).append(", komentar=").append(komentar).append(", user_avatar=").append(user_avatar).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(getId());
        parcel.writeString(getId_hp());
        parcel.writeString(getCodename());
        parcel.writeString(getNamalengkap());
        parcel.writeString(getNama_komentar());
        parcel.writeString(getKomentar());
        parcel.writeString(getTanggal_komentar());
        parcel.writeString(getUser_avatar());
    }

}
