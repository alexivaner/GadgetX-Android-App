// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.identity.intents;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.gms.identity.intents:
//            zza

public final class UserAddressRequest
    implements SafeParcelable
{
    public final class Builder
    {

        final UserAddressRequest zzals;

        public Builder addAllowedCountrySpecification(CountrySpecification countryspecification)
        {
            if (zzals.zzalr == null)
            {
                zzals.zzalr = new ArrayList();
            }
            zzals.zzalr.add(countryspecification);
            return this;
        }

        public Builder addAllowedCountrySpecifications(Collection collection)
        {
            if (zzals.zzalr == null)
            {
                zzals.zzalr = new ArrayList();
            }
            zzals.zzalr.addAll(collection);
            return this;
        }

        public UserAddressRequest build()
        {
            if (zzals.zzalr != null)
            {
                zzals.zzalr = Collections.unmodifiableList(zzals.zzalr);
            }
            return zzals;
        }

        private Builder()
        {
            zzals = UserAddressRequest.this;
            super();
        }

    }


    public static final android.os.Parcelable.Creator CREATOR = new zza();
    private final int zzFG;
    List zzalr;

    UserAddressRequest()
    {
        zzFG = 1;
    }

    UserAddressRequest(int i, List list)
    {
        zzFG = i;
        zzalr = list;
    }

    public static Builder newBuilder()
    {
        UserAddressRequest useraddressrequest = new UserAddressRequest();
        useraddressrequest.getClass();
        return useraddressrequest. new Builder();
    }

    public int describeContents()
    {
        return 0;
    }

    public int getVersionCode()
    {
        return zzFG;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zza.zza(this, parcel, i);
    }

}
