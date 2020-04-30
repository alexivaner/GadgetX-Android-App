// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;

// Referenced classes of package com.google.android.gms.internal:
//            zzkj

static final class zzPd extends android.graphics.drawable.ConstantState
{

    int zzPc;
    int zzPd;

    public int getChangingConfigurations()
    {
        return zzPc;
    }

    public Drawable newDrawable()
    {
        return new zzkj(this);
    }

    ntState(ntState ntstate)
    {
        if (ntstate != null)
        {
            zzPc = ntstate.zzPc;
            zzPd = ntstate.zzPd;
        }
    }
}
