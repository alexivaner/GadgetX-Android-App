// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.DeadObjectException;
import android.os.IInterface;

// Referenced classes of package com.google.android.gms.internal:
//            zzpm, zzow, zzpc

class zzamF
    implements zzpm
{

    final zzow zzamF;

    public void zzfc()
    {
        zzow.zza(zzamF);
    }

    public IInterface zzjb()
        throws DeadObjectException
    {
        return zzpu();
    }

    public zzpc zzpu()
        throws DeadObjectException
    {
        return (zzpc)zzamF.zzjb();
    }

    (zzow zzow1)
    {
        zzamF = zzow1;
        super();
    }
}
