// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzx;

public final class zzus
    implements com.google.android.gms.common.api.Api.ApiOptions.Optional
{
    public static final class zza
    {

        private String zzauh;
        private boolean zzawU;
        private boolean zzawV;
        private com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks zzawW;

        private String zzcH(String s)
        {
            zzx.zzl(s);
            boolean flag;
            if (zzauh == null || zzauh.equals(s))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "two different server client ids provided");
            return s;
        }

        public zza zza(String s, com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks serverauthcodecallbacks)
        {
            zzawU = true;
            zzawV = true;
            zzauh = zzcH(s);
            zzawW = (com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks)zzx.zzl(serverauthcodecallbacks);
            return this;
        }

        public zzus zzsy()
        {
            return new zzus(zzawU, zzawV, zzauh, zzawW);
        }

        public zza()
        {
        }
    }


    public static final zzus zzawP = (new zza()).zzsy();
    private final boolean zzawQ;
    private final boolean zzawR;
    private final String zzawS;
    private final com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks zzawT;

    private zzus(boolean flag, boolean flag1, String s, com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks serverauthcodecallbacks)
    {
        zzawQ = flag;
        zzawR = flag1;
        zzawS = s;
        zzawT = serverauthcodecallbacks;
    }


    public String zzrN()
    {
        return zzawS;
    }

    public boolean zzsv()
    {
        return zzawQ;
    }

    public boolean zzsw()
    {
        return zzawR;
    }

    public com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks zzsx()
    {
        return zzawT;
    }

}
