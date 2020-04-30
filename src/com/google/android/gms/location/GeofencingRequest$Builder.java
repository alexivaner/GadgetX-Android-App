// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzpk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.location:
//            GeofencingRequest, Geofence

public static final class zzalZ
{

    private final List zzalY = new ArrayList();
    private int zzalZ;

    public static int zzfg(int i)
    {
        return i & 7;
    }

    public zzalZ addGeofence(Geofence geofence)
    {
        zzx.zzb(geofence, "geofence can't be null.");
        zzx.zzb(geofence instanceof zzpk, "Geofence must be created using Geofence.Builder.");
        zzalY.add((zzpk)geofence);
        return this;
    }

    public zzalY addGeofences(List list)
    {
        if (list != null && !list.isEmpty())
        {
            list = list.iterator();
            while (list.hasNext()) 
            {
                Geofence geofence = (Geofence)list.next();
                if (geofence != null)
                {
                    addGeofence(geofence);
                }
            }
        }
        return this;
    }

    public GeofencingRequest build()
    {
        boolean flag;
        if (!zzalY.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "No geofence has been added to this request.");
        return new GeofencingRequest(zzalY, zzalZ, null);
    }

    public zzalZ setInitialTrigger(int i)
    {
        zzalZ = zzfg(i);
        return this;
    }

    public ()
    {
        zzalZ = 5;
    }
}
