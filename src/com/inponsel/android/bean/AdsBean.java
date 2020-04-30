// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class AdsBean
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public AdsBean createFromParcel(Parcel parcel)
        {
            return new AdsBean(parcel, null);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public AdsBean[] newArray(int i)
        {
            return new AdsBean[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    String ads_back_color;
    String ads_btn_text_action;
    String ads_btn_text_color;
    private String ads_campaign;
    String ads_campaign_color;
    private String ads_cover;
    private String ads_icon;
    private String ads_link;
    private String ads_method;
    private String ads_title;
    String ads_title_color;
    private String ads_type;
    private int id;

    public AdsBean()
    {
    }

    private AdsBean(Parcel parcel)
    {
        id = parcel.readInt();
        ads_title = parcel.readString();
        ads_cover = parcel.readString();
        ads_campaign = parcel.readString();
        ads_type = parcel.readString();
        ads_icon = parcel.readString();
        ads_link = parcel.readString();
        ads_method = parcel.readString();
        ads_title_color = parcel.readString();
        ads_campaign_color = parcel.readString();
        ads_back_color = parcel.readString();
        ads_btn_text_color = parcel.readString();
        ads_btn_text_action = parcel.readString();
    }

    AdsBean(Parcel parcel, AdsBean adsbean)
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
            obj = (AdsBean)obj;
            if (id != ((AdsBean) (obj)).id)
            {
                return false;
            }
        }
        return true;
    }

    public String getAds_back_color()
    {
        return ads_back_color;
    }

    public String getAds_btn_text_action()
    {
        return ads_btn_text_action;
    }

    public String getAds_btn_text_color()
    {
        return ads_btn_text_color;
    }

    public String getAds_campaign()
    {
        return ads_campaign;
    }

    public String getAds_campaign_color()
    {
        return ads_campaign_color;
    }

    public String getAds_cover()
    {
        return ads_cover;
    }

    public String getAds_icon()
    {
        return ads_icon;
    }

    public String getAds_link()
    {
        return ads_link;
    }

    public String getAds_method()
    {
        return ads_method;
    }

    public String getAds_title()
    {
        return ads_title;
    }

    public String getAds_title_color()
    {
        return ads_title_color;
    }

    public String getAds_type()
    {
        return ads_type;
    }

    public int getId()
    {
        return id;
    }

    public int hashCode()
    {
        return id + 31;
    }

    public void setAds_back_color(String s)
    {
        ads_back_color = s;
    }

    public void setAds_btn_text_action(String s)
    {
        ads_btn_text_action = s;
    }

    public void setAds_btn_text_color(String s)
    {
        ads_btn_text_color = s;
    }

    public void setAds_campaign(String s)
    {
        ads_campaign = s;
    }

    public void setAds_campaign_color(String s)
    {
        ads_campaign_color = s;
    }

    public void setAds_cover(String s)
    {
        ads_cover = s;
    }

    public void setAds_icon(String s)
    {
        ads_icon = s;
    }

    public void setAds_link(String s)
    {
        ads_link = s;
    }

    public void setAds_method(String s)
    {
        ads_method = s;
    }

    public void setAds_title(String s)
    {
        ads_title = s;
    }

    public void setAds_title_color(String s)
    {
        ads_title_color = s;
    }

    public void setAds_type(String s)
    {
        ads_type = s;
    }

    public void setId(int i)
    {
        id = i;
    }

    public String toString()
    {
        return (new StringBuilder("Product [id=")).append(id).append(", ads_title=").append(ads_title).append(", ads_campaign=").append(ads_campaign).append(", ads_cover=").append(ads_cover).append(", ads_title_color=").append(ads_title_color).append(", ads_campaign_color=").append(ads_campaign_color).append(", ads_btn_text_color=").append(ads_btn_text_color).append(", ads_btn_text_action=").append(ads_btn_text_action).append(", ads_back_color=").append(ads_back_color).append(", ads_icon=").append(ads_icon).append(", ads_link=").append(ads_link).append(", ads_method=").append(ads_method).append(", ads_type=").append(ads_type).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(getId());
        parcel.writeString(getAds_title());
        parcel.writeString(getAds_cover());
        parcel.writeString(getAds_icon());
        parcel.writeString(getAds_campaign());
        parcel.writeString(getAds_type());
        parcel.writeString(getAds_link());
        parcel.writeString(getAds_method());
        parcel.writeString(getAds_title_color());
        parcel.writeString(getAds_campaign_color());
        parcel.writeString(getAds_back_color());
        parcel.writeString(getAds_btn_text_color());
        parcel.writeString(getAds_btn_text_action());
    }

}
