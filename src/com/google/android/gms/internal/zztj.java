// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.internal:
//            zztk

public class zztj
    implements SafeParcelable
{

    public static final zztk CREATOR = new zztk();
    public final String packageName;
    public final int versionCode;
    public final int zzatW;
    public final int zzatX;
    public final String zzatY;
    public final String zzatZ;
    public final boolean zzaua;
    public final String zzaub;

    public zztj(int i, String s, int j, int k, String s1, String s2, boolean flag, 
            String s3)
    {
        versionCode = i;
        packageName = s;
        zzatW = j;
        zzatX = k;
        zzatY = s1;
        zzatZ = s2;
        zzaua = flag;
        zzaub = s3;
    }

    public zztj(String s, int i, int j, String s1, String s2, boolean flag)
    {
        versionCode = 1;
        packageName = (String)zzx.zzl(s);
        zzatW = i;
        zzatX = j;
        zzaub = null;
        zzatY = s1;
        zzatZ = s2;
        zzaua = flag;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj instanceof zztj)
            {
                if (!packageName.equals(((zztj) (obj = (zztj)obj)).packageName) || zzatW != ((zztj) (obj)).zzatW || zzatX != ((zztj) (obj)).zzatX || !zzw.equal(zzaub, ((zztj) (obj)).zzaub) || !zzw.equal(zzatY, ((zztj) (obj)).zzatY) || !zzw.equal(zzatZ, ((zztj) (obj)).zzatZ) || zzaua != ((zztj) (obj)).zzaua)
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            packageName, Integer.valueOf(zzatW), Integer.valueOf(zzatX), zzatY, zzatZ, Boolean.valueOf(zzaua)
        });
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("PlayLoggerContext[");
        stringbuilder.append("package=").append(packageName).append(',');
        stringbuilder.append("versionCode=").append(versionCode).append(',');
        stringbuilder.append("logSource=").append(zzatX).append(',');
        stringbuilder.append("logSourceName=").append(zzaub).append(',');
        stringbuilder.append("uploadAccount=").append(zzatY).append(',');
        stringbuilder.append("loggingId=").append(zzatZ).append(',');
        stringbuilder.append("logAndroidId=").append(zzaua);
        stringbuilder.append("]");
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zztk.zza(this, parcel, i);
    }

}
