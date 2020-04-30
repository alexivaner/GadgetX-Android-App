// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

// Referenced classes of package com.google.android.gms.internal:
//            zzsj

public class zzsi
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzsj();
    private String mimeType;
    private String type;
    private final int versionCode;
    private int zzato;
    private String zzatp;
    private String zzatq;
    private byte zzatr[];

    private zzsi()
    {
        versionCode = 1;
    }

    zzsi(int i, int j, String s, String s1, String s2, String s3, byte abyte0[])
    {
        versionCode = i;
        zzato = j;
        zzatp = s;
        mimeType = s1;
        zzatq = s2;
        type = s3;
        zzatr = abyte0;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof zzsi))
            {
                return false;
            }
            obj = (zzsi)obj;
            if (!zzw.equal(Integer.valueOf(zzato), Integer.valueOf(((zzsi) (obj)).zzato)) || !zzw.equal(zzatp, ((zzsi) (obj)).zzatp) || !zzw.equal(mimeType, ((zzsi) (obj)).mimeType) || !zzw.equal(zzatq, ((zzsi) (obj)).zzatq) || !zzw.equal(type, ((zzsi) (obj)).type) || !zzw.equal(zzatr, ((zzsi) (obj)).zzatr))
            {
                return false;
            }
        }
        return true;
    }

    public int getContentType()
    {
        return zzato;
    }

    public String getDomain()
    {
        return zzatq;
    }

    public String getMimeType()
    {
        return mimeType;
    }

    public byte[] getPayload()
    {
        return zzatr;
    }

    public String getType()
    {
        return type;
    }

    public String getUri()
    {
        return zzatp;
    }

    int getVersionCode()
    {
        return versionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Integer.valueOf(zzato), zzatp, mimeType, zzatq, type, zzatr
        });
    }

    public String toString()
    {
        return (new StringBuilder()).append("ShardContent[uri=").append(zzatp).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzsj.zza(this, parcel, i);
    }

}
