// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Locale;

// Referenced classes of package com.google.android.gms.internal:
//            zzqi

public class zzqh
    implements SafeParcelable
{

    public static final zzqi CREATOR = new zzqi();
    public static final zzqh zzapa = new zzqh("com.google.android.gms", Locale.getDefault(), null);
    public final int versionCode;
    public final String zzaob;
    public final String zzapb;
    public final String zzapc;
    public final String zzapd;
    public final String zzape;

    public zzqh(int i, String s, String s1, String s2, String s3, String s4)
    {
        versionCode = i;
        zzapb = s;
        zzapc = s1;
        zzapd = s2;
        zzaob = s3;
        zzape = s4;
    }

    public zzqh(String s, Locale locale, String s1)
    {
        this(1, s, locale.toString(), s1, null, null);
    }

    public zzqh(String s, Locale locale, String s1, String s2, String s3)
    {
        this(1, s, locale.toString(), s1, s2, s3);
    }

    public int describeContents()
    {
        zzqi zzqi1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || !(obj instanceof zzqh))
            {
                return false;
            }
            obj = (zzqh)obj;
            if (!zzapc.equals(((zzqh) (obj)).zzapc) || !zzapb.equals(((zzqh) (obj)).zzapb) || !zzw.equal(zzapd, ((zzqh) (obj)).zzapd) || !zzw.equal(zzaob, ((zzqh) (obj)).zzaob) || !zzw.equal(zzape, ((zzqh) (obj)).zzape))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzapb, zzapc, zzapd, zzaob, zzape
        });
    }

    public String toString()
    {
        return zzw.zzk(this).zza("clientPackageName", zzapb).zza("locale", zzapc).zza("accountName", zzapd).zza("gCoreClientName", zzaob).zza("chargedPackageName", zzape).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzqi zzqi1 = CREATOR;
        zzqi.zza(this, parcel, i);
    }

}
