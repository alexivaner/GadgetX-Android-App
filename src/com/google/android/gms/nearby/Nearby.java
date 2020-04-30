// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzrl;
import com.google.android.gms.internal.zzrq;
import com.google.android.gms.internal.zzrz;
import com.google.android.gms.internal.zzsk;
import com.google.android.gms.internal.zzsr;
import com.google.android.gms.nearby.connection.Connections;

public final class Nearby
{

    public static final Api CONNECTIONS_API;
    public static final Connections Connections = new zzrl();
    public static final Api zzasA;
    public static final zzrq zzasB = new zzrz();
    public static final Api zzasC;
    public static final zzsk zzasD = new zzsr();

    private Nearby()
    {
    }

    static 
    {
        CONNECTIONS_API = new Api(zzrl.zzGS, zzrl.zzGR, new Scope[0]);
        zzasA = new Api(zzrz.zzGS, zzrz.zzGR, new Scope[0]);
        zzasC = new Api(zzsr.zzGS, zzsr.zzGR, new Scope[0]);
    }
}
