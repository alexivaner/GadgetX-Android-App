// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.identity.intents;

import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.gms.identity.intents:
//            UserAddressRequest

public final class <init>
{

    final UserAddressRequest zzals;

    public <init> addAllowedCountrySpecification(CountrySpecification countryspecification)
    {
        if (zzals.zzalr == null)
        {
            zzals.zzalr = new ArrayList();
        }
        zzals.zzalr.add(countryspecification);
        return this;
    }

    public zzals addAllowedCountrySpecifications(Collection collection)
    {
        if (zzals.zzalr == null)
        {
            zzals.zzalr = new ArrayList();
        }
        zzals.zzalr.addAll(collection);
        return this;
    }

    public UserAddressRequest build()
    {
        if (zzals.zzalr != null)
        {
            zzals.zzalr = Collections.unmodifiableList(zzals.zzalr);
        }
        return zzals;
    }

    private (UserAddressRequest useraddressrequest)
    {
        zzals = useraddressrequest;
        super();
    }

    zzals(UserAddressRequest useraddressrequest, zzals zzals1)
    {
        this(useraddressrequest);
    }
}
