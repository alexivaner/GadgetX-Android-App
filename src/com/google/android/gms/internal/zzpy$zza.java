// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzpy, zzqd

public static class zzFG
{

    private String mName;
    private String zzFA;
    private int zzFG;
    private String zzYy;
    private LatLng zzant;
    private String zzanv;
    private Uri zzanw;
    private String zzaoA;
    private boolean zzaoB;
    private float zzaoC;
    private int zzaoD;
    private long zzaoE;
    private String zzaoG;
    private List zzaoH;
    private boolean zzaoI;
    private Bundle zzaoM;
    private List zzaoN;
    private float zzaoy;
    private LatLngBounds zzaoz;

    public zzFG zzX(boolean flag)
    {
        zzaoB = flag;
        return this;
    }

    public zzaoB zzY(boolean flag)
    {
        zzaoI = flag;
        return this;
    }

    public zzaoI zza(LatLng latlng)
    {
        zzant = latlng;
        return this;
    }

    public ounds zza(LatLngBounds latlngbounds)
    {
        zzaoz = latlngbounds;
        return this;
    }

    public zzaoz zzc(float f)
    {
        zzaoy = f;
        return this;
    }

    public zzaoy zzco(String s)
    {
        zzFA = s;
        return this;
    }

    public zzFA zzcp(String s)
    {
        mName = s;
        return this;
    }

    public mName zzcq(String s)
    {
        zzYy = s;
        return this;
    }

    public zzYy zzcr(String s)
    {
        zzanv = s;
        return this;
    }

    public zzanv zzd(float f)
    {
        zzaoC = f;
        return this;
    }

    public zzaoC zzfH(int i)
    {
        zzaoD = i;
        return this;
    }

    public zzaoD zzk(Uri uri)
    {
        zzanw = uri;
        return this;
    }

    public zzanw zzo(List list)
    {
        zzaoN = list;
        return this;
    }

    public zzaoN zzp(List list)
    {
        zzaoH = list;
        return this;
    }

    public zzpy zzpW()
    {
        return new zzpy(zzFG, zzFA, zzaoN, Collections.emptyList(), zzaoM, mName, zzYy, zzanv, zzaoG, zzaoH, zzant, zzaoy, zzaoz, zzaoA, zzanw, zzaoB, zzaoC, zzaoD, zzaoE, zzaoI, zzqd.zza(mName, zzYy, zzanv, zzaoG, zzaoH));
    }

    public ounds()
    {
        zzFG = 0;
    }
}
