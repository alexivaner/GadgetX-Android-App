// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.model;

import android.os.Parcel;

// Referenced classes of package com.facebook.share.model:
//            ShareOpenGraphValueContainer, ShareModelBuilder, ShareModel

public final class ShareOpenGraphAction extends ShareOpenGraphValueContainer
{
    public static final class Builder extends ShareOpenGraphValueContainer.Builder
    {

        private static final String ACTION_TYPE_KEY = "og:type";

        public ShareOpenGraphAction build()
        {
            return new ShareOpenGraphAction(this);
        }

        public volatile Object build()
        {
            return build();
        }

        public volatile ShareModelBuilder readFrom(Parcel parcel)
        {
            return readFrom(parcel);
        }

        public volatile ShareModelBuilder readFrom(ShareModel sharemodel)
        {
            return readFrom((ShareOpenGraphAction)sharemodel);
        }

        public Builder readFrom(Parcel parcel)
        {
            return readFrom((ShareOpenGraphAction)parcel.readParcelable(com/facebook/share/model/ShareOpenGraphAction.getClassLoader()));
        }

        public Builder readFrom(ShareOpenGraphAction shareopengraphaction)
        {
            if (shareopengraphaction == null)
            {
                return this;
            } else
            {
                return ((Builder)super.readFrom(shareopengraphaction)).setActionType(shareopengraphaction.getActionType());
            }
        }

        public volatile ShareOpenGraphValueContainer.Builder readFrom(ShareOpenGraphValueContainer shareopengraphvaluecontainer)
        {
            return readFrom((ShareOpenGraphAction)shareopengraphvaluecontainer);
        }

        public Builder setActionType(String s)
        {
            putString("og:type", s);
            return this;
        }

        public Builder()
        {
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ShareOpenGraphAction createFromParcel(Parcel parcel)
        {
            return new ShareOpenGraphAction(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ShareOpenGraphAction[] newArray(int i)
        {
            return new ShareOpenGraphAction[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };

    ShareOpenGraphAction(Parcel parcel)
    {
        super(parcel);
    }

    private ShareOpenGraphAction(Builder builder)
    {
        super(builder);
    }


    public String getActionType()
    {
        return getString("og:type");
    }

}
