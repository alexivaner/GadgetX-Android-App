// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.os.Parcel;

// Referenced classes of package com.google.android.gms.common.internal:
//            BinderWrapper

static final class 
    implements android.os.or
{

    public Object createFromParcel(Parcel parcel)
    {
        return zzD(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzaG(i);
    }

    public BinderWrapper zzD(Parcel parcel)
    {
        return new BinderWrapper(parcel, null);
    }

    public BinderWrapper[] zzaG(int i)
    {
        return new BinderWrapper[i];
    }

    ()
    {
    }
}
