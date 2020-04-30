// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.internal:
//            zztj, zztf

public class zztg
{
    public static class zza
    {

        public final zztj zzatR;
        public final zztf zzatS;
        public final zzxf.zzd zzatT;

        private zza(zztj zztj1, zztf zztf1)
        {
            zzatR = (zztj)zzx.zzl(zztj1);
            zzatS = (zztf)zzx.zzl(zztf1);
            zzatT = null;
        }

    }


    private final ArrayList zzatP;
    private int zzatQ;

    public zztg()
    {
        this(100);
    }

    public zztg(int i)
    {
        zzatP = new ArrayList();
        zzatQ = i;
    }

    private void zzrH()
    {
        for (; getSize() > getCapacity(); zzatP.remove(0)) { }
    }

    public void clear()
    {
        zzatP.clear();
    }

    public int getCapacity()
    {
        return zzatQ;
    }

    public int getSize()
    {
        return zzatP.size();
    }

    public boolean isEmpty()
    {
        return zzatP.isEmpty();
    }

    public void zza(zztj zztj, zztf zztf)
    {
        zzatP.add(new zza(zztj, zztf));
        zzrH();
    }

    public ArrayList zzrG()
    {
        return zzatP;
    }
}
