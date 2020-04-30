// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places;

import android.net.Uri;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.location.places:
//            zza

public class AddPlaceRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zza();
    private final String mName;
    final int zzFG;
    private final String zzYy;
    private final LatLng zzant;
    private final List zzanu;
    private final String zzanv;
    private final Uri zzanw;

    AddPlaceRequest(int i, String s, LatLng latlng, String s1, List list, String s2, Uri uri)
    {
        zzFG = i;
        mName = zzx.zzbn(s);
        zzant = (LatLng)zzx.zzl(latlng);
        zzYy = s1;
        zzanu = new ArrayList(list);
        boolean flag;
        if (!TextUtils.isEmpty(s2) || uri != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "One of phone number or URI should be provided.");
        zzanv = s2;
        zzanw = uri;
    }

    public AddPlaceRequest(String s, LatLng latlng, String s1, List list, Uri uri)
    {
        this(s, latlng, s1, list, null, (Uri)zzx.zzl(uri));
    }

    public AddPlaceRequest(String s, LatLng latlng, String s1, List list, String s2)
    {
        this(s, latlng, s1, list, zzx.zzbn(s2), null);
    }

    public AddPlaceRequest(String s, LatLng latlng, String s1, List list, String s2, Uri uri)
    {
        this(0, s, latlng, s1, list, s2, uri);
    }

    public int describeContents()
    {
        return 0;
    }

    public String getAddress()
    {
        return zzYy;
    }

    public LatLng getLatLng()
    {
        return zzant;
    }

    public String getName()
    {
        return mName;
    }

    public String getPhoneNumber()
    {
        return zzanv;
    }

    public List getPlaceTypes()
    {
        return zzanu;
    }

    public Uri getWebsiteUri()
    {
        return zzanw;
    }

    public String toString()
    {
        return zzw.zzk(this).zza("name", mName).zza("latLng", zzant).zza("address", zzYy).zza("placeTypes", zzanu).zza("phoneNumer", zzanv).zza("websiteUri", zzanw).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zza.zza(this, parcel, i);
    }

}
