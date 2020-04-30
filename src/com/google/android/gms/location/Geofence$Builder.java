// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.os.SystemClock;
import com.google.android.gms.internal.zzpk;

// Referenced classes of package com.google.android.gms.location:
//            Geofence

public static final class zzalU
{

    private int zzalN;
    private long zzalO;
    private short zzalP;
    private double zzalQ;
    private double zzalR;
    private float zzalS;
    private int zzalT;
    private int zzalU;
    private String zzxv;

    public Geofence build()
    {
        if (zzxv == null)
        {
            throw new IllegalArgumentException("Request ID not set.");
        }
        if (zzalN == 0)
        {
            throw new IllegalArgumentException("Transitions types not set.");
        }
        if ((zzalN & 4) != 0 && zzalU < 0)
        {
            throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
        }
        if (zzalO == 0x8000000000000000L)
        {
            throw new IllegalArgumentException("Expiration not set.");
        }
        if (zzalP == -1)
        {
            throw new IllegalArgumentException("Geofence region not set.");
        }
        if (zzalT < 0)
        {
            throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
        } else
        {
            return new zzpk(zzxv, zzalN, (short)1, zzalQ, zzalR, zzalS, zzalO, zzalT, zzalU);
        }
    }

    public zzalU setCircularRegion(double d, double d1, float f)
    {
        zzalP = 1;
        zzalQ = d;
        zzalR = d1;
        zzalS = f;
        return this;
    }

    public zzalS setExpirationDuration(long l)
    {
        if (l < 0L)
        {
            zzalO = -1L;
            return this;
        } else
        {
            zzalO = SystemClock.elapsedRealtime() + l;
            return this;
        }
    }

    public zzalO setLoiteringDelay(int i)
    {
        zzalU = i;
        return this;
    }

    public zzalU setNotificationResponsiveness(int i)
    {
        zzalT = i;
        return this;
    }

    public zzalT setRequestId(String s)
    {
        zzxv = s;
        return this;
    }

    public zzxv setTransitionTypes(int i)
    {
        zzalN = i;
        return this;
    }

    public ()
    {
        zzxv = null;
        zzalN = 0;
        zzalO = 0x8000000000000000L;
        zzalP = -1;
        zzalT = 0;
        zzalU = -1;
    }
}
