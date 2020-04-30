// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.bean;

import android.os.Parcel;

// Referenced classes of package com.inponsel.android.bean:
//            InteraksiBean

class 
    implements android.os.or
{

    public InteraksiBean createFromParcel(Parcel parcel)
    {
        return new InteraksiBean(parcel, null);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public InteraksiBean[] newArray(int i)
    {
        return new InteraksiBean[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ()
    {
    }
}
