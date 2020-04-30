// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzqr;

// Referenced classes of package com.google.android.gms.location.places:
//            zzi

public static abstract class  extends 
{

    protected Result createFailedResult(Status status)
    {
        return zzaD(status);
    }

    protected zzqr zzaD(Status status)
    {
        return zzqr.zzaE(status);
    }
}
