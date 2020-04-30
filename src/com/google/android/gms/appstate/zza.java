// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appstate;

import com.google.android.gms.common.internal.zzw;

// Referenced classes of package com.google.android.gms.appstate:
//            AppState

public final class zza
    implements AppState
{

    private final int zzGL;
    private final String zzGM;
    private final byte zzGN[];
    private final boolean zzGO;
    private final String zzGP;
    private final byte zzGQ[];

    public zza(AppState appstate)
    {
        zzGL = appstate.getKey();
        zzGM = appstate.getLocalVersion();
        zzGN = appstate.getLocalData();
        zzGO = appstate.hasConflict();
        zzGP = appstate.getConflictVersion();
        zzGQ = appstate.getConflictData();
    }

    static int zza(AppState appstate)
    {
        return zzw.hashCode(new Object[] {
            Integer.valueOf(appstate.getKey()), appstate.getLocalVersion(), appstate.getLocalData(), Boolean.valueOf(appstate.hasConflict()), appstate.getConflictVersion(), appstate.getConflictData()
        });
    }

    static boolean zza(AppState appstate, Object obj)
    {
        boolean flag1 = true;
        if (obj instanceof AppState) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (appstate == obj) goto _L4; else goto _L3
_L3:
        obj = (AppState)obj;
        if (!zzw.equal(Integer.valueOf(((AppState) (obj)).getKey()), Integer.valueOf(appstate.getKey())) || !zzw.equal(((AppState) (obj)).getLocalVersion(), appstate.getLocalVersion()) || !zzw.equal(((AppState) (obj)).getLocalData(), appstate.getLocalData()) || !zzw.equal(Boolean.valueOf(((AppState) (obj)).hasConflict()), Boolean.valueOf(appstate.hasConflict())) || !zzw.equal(((AppState) (obj)).getConflictVersion(), appstate.getConflictVersion()))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (zzw.equal(((AppState) (obj)).getConflictData(), appstate.getConflictData())) goto _L4; else goto _L5
_L5:
        return false;
    }

    static String zzb(AppState appstate)
    {
        return zzw.zzk(appstate).zza("Key", Integer.valueOf(appstate.getKey())).zza("LocalVersion", appstate.getLocalVersion()).zza("LocalData", appstate.getLocalData()).zza("HasConflict", Boolean.valueOf(appstate.hasConflict())).zza("ConflictVersion", appstate.getConflictVersion()).zza("ConflictData", appstate.getConflictData()).toString();
    }

    public boolean equals(Object obj)
    {
        return zza(this, obj);
    }

    public Object freeze()
    {
        return zzha();
    }

    public byte[] getConflictData()
    {
        return zzGQ;
    }

    public String getConflictVersion()
    {
        return zzGP;
    }

    public int getKey()
    {
        return zzGL;
    }

    public byte[] getLocalData()
    {
        return zzGN;
    }

    public String getLocalVersion()
    {
        return zzGM;
    }

    public boolean hasConflict()
    {
        return zzGO;
    }

    public int hashCode()
    {
        return zza(this);
    }

    public boolean isDataValid()
    {
        return true;
    }

    public String toString()
    {
        return zzb(this);
    }

    public AppState zzha()
    {
        return this;
    }
}
