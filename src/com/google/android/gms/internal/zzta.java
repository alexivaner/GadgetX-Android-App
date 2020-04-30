// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


public final class zzta
{
    public static final class zza
    {

        private String zzFr;
        private boolean zzatB;
        private boolean zzatC;
        private final String zzatD;

        static String zza(zza zza1)
        {
            return zza1.zzatD;
        }

        static boolean zzb(zza zza1)
        {
            return zza1.zzatB;
        }

        static boolean zzc(zza zza1)
        {
            return zza1.zzatC;
        }

        static String zzd(zza zza1)
        {
            return zza1.zzFr;
        }

        public zza zzab(boolean flag)
        {
            zzatB = flag;
            return this;
        }

        public zza zzac(boolean flag)
        {
            zzatC = flag;
            return this;
        }

        public zza zzcA(String s)
        {
            zzFr = s;
            return this;
        }

        public zzta zzrA()
        {
            return new zzta(this);
        }

        public zza(String s)
        {
            zzatB = true;
            zzatC = false;
            zzatD = s;
        }
    }


    private final String zzFr;
    private final boolean zzatB;
    private final boolean zzatC;
    private final String zzatD;

    private zzta(zza zza1)
    {
        zzatD = zza.zza(zza1);
        zzatB = zza.zzb(zza1);
        zzatC = zza.zzc(zza1);
        zzFr = zza.zzd(zza1);
    }


    public String zzgL()
    {
        return zzFr;
    }

    public String zzrx()
    {
        return zzatD;
    }

    public boolean zzry()
    {
        return zzatB;
    }

    public boolean zzrz()
    {
        return zzatC;
    }
}
