// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzjv;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.cast:
//            zza

public final class ApplicationMetadata
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zza();
    String mName;
    private final int zzFG;
    String zzIm;
    List zzIn;
    List zzIo;
    String zzIp;
    Uri zzIq;

    private ApplicationMetadata()
    {
        zzFG = 1;
        zzIn = new ArrayList();
        zzIo = new ArrayList();
    }

    ApplicationMetadata(int i, String s, String s1, List list, List list1, String s2, Uri uri)
    {
        zzFG = i;
        zzIm = s;
        mName = s1;
        zzIn = list;
        zzIo = list1;
        zzIp = s2;
        zzIq = uri;
    }

    public boolean areNamespacesSupported(List list)
    {
        return zzIo != null && zzIo.containsAll(list);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof ApplicationMetadata))
            {
                return false;
            }
            obj = (ApplicationMetadata)obj;
            if (!zzjv.zza(zzIm, ((ApplicationMetadata) (obj)).zzIm) || !zzjv.zza(zzIn, ((ApplicationMetadata) (obj)).zzIn) || !zzjv.zza(mName, ((ApplicationMetadata) (obj)).mName) || !zzjv.zza(zzIo, ((ApplicationMetadata) (obj)).zzIo) || !zzjv.zza(zzIp, ((ApplicationMetadata) (obj)).zzIp) || !zzjv.zza(zzIq, ((ApplicationMetadata) (obj)).zzIq))
            {
                return false;
            }
        }
        return true;
    }

    public String getApplicationId()
    {
        return zzIm;
    }

    public List getImages()
    {
        return zzIn;
    }

    public String getName()
    {
        return mName;
    }

    public String getSenderAppIdentifier()
    {
        return zzIp;
    }

    int getVersionCode()
    {
        return zzFG;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Integer.valueOf(zzFG), zzIm, mName, zzIn, zzIo, zzIp, zzIq
        });
    }

    public boolean isNamespaceSupported(String s)
    {
        return zzIo != null && zzIo.contains(s);
    }

    public String toString()
    {
        boolean flag = false;
        StringBuilder stringbuilder = (new StringBuilder()).append("applicationId: ").append(zzIm).append(", name: ").append(mName).append(", images.count: ");
        int i;
        if (zzIn == null)
        {
            i = 0;
        } else
        {
            i = zzIn.size();
        }
        stringbuilder = stringbuilder.append(i).append(", namespaces.count: ");
        if (zzIo == null)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = zzIo.size();
        }
        return stringbuilder.append(i).append(", senderAppIdentifier: ").append(zzIp).append(", senderAppLaunchUrl: ").append(zzIq).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zza.zza(this, parcel, i);
    }

    public Uri zzhh()
    {
        return zzIq;
    }

}
