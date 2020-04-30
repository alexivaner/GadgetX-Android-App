// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.internal.zzlv;
import com.google.android.gms.internal.zzlx;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.analytics:
//            Tracker, GoogleAnalytics, zzy, zzam

private class zzmW
    implements ics.zza
{

    private boolean zzFk;
    private int zzFl;
    private long zzFm;
    private boolean zzFn;
    private long zzFo;
    final Tracker zzFp;
    private zzlv zzmW;

    private void zzgH()
    {
        if (zzFm >= 0L || zzFk)
        {
            Tracker.zzc(zzFp).zza(Tracker.zzb(zzFp));
            return;
        } else
        {
            Tracker.zzc(zzFp).zzb(Tracker.zzb(zzFp));
            return;
        }
    }

    public void enableAutoActivityTracking(boolean flag)
    {
        zzFk = flag;
        zzgH();
    }

    public void setSessionTimeout(long l)
    {
        zzFm = l;
        zzgH();
    }

    public long zzgE()
    {
        return zzFm;
    }

    public boolean zzgF()
    {
        return zzFk;
    }

    public boolean zzgG()
    {
        boolean flag = zzFn;
        zzFn = false;
        return flag;
    }

    boolean zzgI()
    {
        return zzmW.elapsedRealtime() >= zzFo + Math.max(1000L, zzFm);
    }

    public void zzn(Activity activity)
    {
        zzy.zzfV().zza();
        if (zzFl == 0 && zzgI())
        {
            zzFn = true;
        }
        zzFl = zzFl + 1;
        if (zzFk)
        {
            Object obj = activity.getIntent();
            if (obj != null)
            {
                zzFp.setCampaignParamsOnNextHit(((Intent) (obj)).getData());
            }
            HashMap hashmap = new HashMap();
            hashmap.put("&t", "screenview");
            zzy.zzfV().zzF(true);
            Tracker tracker = zzFp;
            if (Tracker.zzd(zzFp) != null)
            {
                obj = Tracker.zzd(zzFp).zzq(activity);
            } else
            {
                obj = activity.getClass().getCanonicalName();
            }
            tracker.set("&cd", ((String) (obj)));
            if (TextUtils.isEmpty((CharSequence)hashmap.get("&dr")))
            {
                activity = Tracker.zzp(activity);
                if (!TextUtils.isEmpty(activity))
                {
                    hashmap.put("&dr", activity);
                }
            }
            zzFp.send(hashmap);
            zzy.zzfV().zzF(false);
        }
    }

    public void zzo(Activity activity)
    {
        zzy.zzfV().zza();
        zzFl = zzFl - 1;
        zzFl = Math.max(0, zzFl);
        if (zzFl == 0)
        {
            zzFo = zzmW.elapsedRealtime();
        }
    }

    public ics(Tracker tracker)
    {
        zzFp = tracker;
        super();
        zzFm = -1L;
        zzmW = zzlx.zzkc();
    }
}
