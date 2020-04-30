// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlv;
import com.google.android.gms.internal.zzlx;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;

// Referenced classes of package com.google.android.gms.analytics:
//            zzad, GoogleAnalytics, ExceptionReporter, zzae, 
//            zzy, zzan, zzk, zzai, 
//            zzg, zzah, TrackerHandler, zzam

public class Tracker
{
    private class zza
        implements GoogleAnalytics.zza
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
            zzy.zzfV().zza(zzy.zza.zzEd);
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
            zzy.zzfV().zza(zzy.zza.zzEe);
            zzFl = zzFl - 1;
            zzFl = Math.max(0, zzFl);
            if (zzFl == 0)
            {
                zzFo = zzmW.elapsedRealtime();
            }
        }

        public zza()
        {
            zzFp = Tracker.this;
            super();
            zzFm = -1L;
            zzmW = zzlx.zzkc();
        }
    }


    private final GoogleAnalytics zzBN;
    private final TrackerHandler zzFe;
    private final Map zzFf = new HashMap();
    private final zzah zzFg;
    private final zza zzFh = new zza();
    private ExceptionReporter zzFi;
    private zzam zzFj;
    private final Map zzsZ = new HashMap();

    Tracker(GoogleAnalytics googleanalytics, String s, TrackerHandler trackerhandler, zzah zzah1)
    {
        zzx.zzl(googleanalytics);
        zzBN = googleanalytics;
        if (trackerhandler == null)
        {
            zzFe = googleanalytics;
        } else
        {
            zzFe = trackerhandler;
        }
        if (s != null)
        {
            zzsZ.put("&tid", s);
        }
        zzsZ.put("useSecure", "1");
        zzsZ.put("&a", Integer.toString((new Random()).nextInt(0x7fffffff) + 1));
        if (zzah1 == null)
        {
            zzFg = new zzad("tracking");
        } else
        {
            zzFg = zzah1;
        }
        enableAdvertisingIdCollection(false);
    }

    static zza zzb(Tracker tracker)
    {
        return tracker.zzFh;
    }

    static GoogleAnalytics zzc(Tracker tracker)
    {
        return tracker.zzBN;
    }

    static zzam zzd(Tracker tracker)
    {
        return tracker.zzFj;
    }

    private boolean zzgD()
    {
        return zzFi != null;
    }

    static String zzp(Activity activity)
    {
        zzx.zzl(activity);
        activity = activity.getIntent();
        if (activity != null)
        {
            if (!TextUtils.isEmpty(activity = activity.getStringExtra("android.intent.extra.REFERRER_NAME")))
            {
                return activity;
            }
        }
        return null;
    }

    public void enableAdvertisingIdCollection(boolean flag)
    {
        if (!flag)
        {
            zzsZ.put("&ate", null);
            zzsZ.put("&adid", null);
        } else
        {
            if (zzsZ.containsKey("&ate"))
            {
                zzsZ.remove("&ate");
            }
            if (zzsZ.containsKey("&adid"))
            {
                zzsZ.remove("&adid");
                return;
            }
        }
    }

    public void enableAutoActivityTracking(boolean flag)
    {
        zzFh.enableAutoActivityTracking(flag);
    }

    public void enableExceptionReporting(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (zzgD() != flag)
        {
            break MISSING_BLOCK_LABEL_13;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        android.content.Context context = zzBN.getContext();
        zzFi = new ExceptionReporter(this, Thread.getDefaultUncaughtExceptionHandler(), context);
        Thread.setDefaultUncaughtExceptionHandler(zzFi);
        zzae.zzab("Uncaught exceptions will be reported to Google Analytics.");
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        Thread.setDefaultUncaughtExceptionHandler(zzFi.zzfD());
        zzae.zzab("Uncaught exceptions will not be reported to Google Analytics.");
          goto _L1
    }

    public String get(String s)
    {
        zzy.zzfV().zza(zzy.zza.zzDe);
        if (!TextUtils.isEmpty(s))
        {
            if (zzsZ.containsKey(s))
            {
                return (String)zzsZ.get(s);
            }
            if (s.equals("&ul"))
            {
                return zzan.zza(Locale.getDefault());
            }
            Object obj = zzBN.zzgp();
            if (((zzk) (obj)).zzaj(s))
            {
                return ((zzk) (obj)).getValue(s);
            }
            obj = zzBN.zzgn();
            if (((zzai) (obj)).zzaj(s))
            {
                return ((zzai) (obj)).getValue(s);
            }
            obj = zzBN.zzgo();
            if (((zzg) (obj)).zzaj(s))
            {
                return ((zzg) (obj)).getValue(s);
            }
        }
        return null;
    }

    public void send(Map map)
    {
        zzy.zzfV().zza(zzy.zza.zzDg);
        HashMap hashmap = new HashMap();
        hashmap.putAll(zzsZ);
        if (map != null)
        {
            hashmap.putAll(map);
        }
        map = zzFf.keySet().iterator();
        do
        {
            if (!map.hasNext())
            {
                break;
            }
            String s = (String)map.next();
            if (!hashmap.containsKey(s))
            {
                hashmap.put(s, zzFf.get(s));
            }
        } while (true);
        zzFf.clear();
        if (TextUtils.isEmpty((CharSequence)hashmap.get("&tid")))
        {
            zzae.zzac(String.format("Missing tracking id (%s) parameter.", new Object[] {
                "&tid"
            }));
        }
        String s1 = (String)hashmap.get("&t");
        map = s1;
        if (TextUtils.isEmpty(s1))
        {
            zzae.zzac(String.format("Missing hit type (%s) parameter.", new Object[] {
                "&t"
            }));
            map = "";
        }
        if (zzFh.zzgG())
        {
            hashmap.put("&sc", "start");
        }
        map = map.toLowerCase();
        if ("screenview".equals(map) || "pageview".equals(map) || "appview".equals(map) || TextUtils.isEmpty(map))
        {
            int j = Integer.parseInt((String)zzsZ.get("&a")) + 1;
            int i = j;
            if (j >= 0x7fffffff)
            {
                i = 1;
            }
            zzsZ.put("&a", Integer.toString(i));
        }
        if (!map.equals("transaction") && !map.equals("item") && !zzFg.zzgv())
        {
            zzae.zzac("Too many hits sent too quickly, rate limiting invoked.");
            return;
        } else
        {
            zzFe.zzx(hashmap);
            return;
        }
    }

    public void set(String s, String s1)
    {
        zzx.zzb(s, "Key should be non-null");
        zzy.zzfV().zza(zzy.zza.zzDf);
        zzsZ.put(s, s1);
    }

    public void setAnonymizeIp(boolean flag)
    {
        set("&aip", zzan.zzG(flag));
    }

    public void setAppId(String s)
    {
        set("&aid", s);
    }

    public void setAppInstallerId(String s)
    {
        set("&aiid", s);
    }

    public void setAppName(String s)
    {
        set("&an", s);
    }

    public void setAppVersion(String s)
    {
        set("&av", s);
    }

    public void setCampaignParamsOnNextHit(Uri uri)
    {
        if (uri != null && !uri.isOpaque())
        {
            if (!TextUtils.isEmpty(uri = uri.getQueryParameter("referrer")))
            {
                uri = Uri.parse((new StringBuilder()).append("http://hostname/?").append(uri).toString());
                String s = uri.getQueryParameter("utm_id");
                if (s != null)
                {
                    zzFf.put("&ci", s);
                }
                s = uri.getQueryParameter("utm_campaign");
                if (s != null)
                {
                    zzFf.put("&cn", s);
                }
                s = uri.getQueryParameter("utm_content");
                if (s != null)
                {
                    zzFf.put("&cc", s);
                }
                s = uri.getQueryParameter("utm_medium");
                if (s != null)
                {
                    zzFf.put("&cm", s);
                }
                s = uri.getQueryParameter("utm_source");
                if (s != null)
                {
                    zzFf.put("&cs", s);
                }
                s = uri.getQueryParameter("utm_term");
                if (s != null)
                {
                    zzFf.put("&ck", s);
                }
                s = uri.getQueryParameter("dclid");
                if (s != null)
                {
                    zzFf.put("&dclid", s);
                }
                uri = uri.getQueryParameter("gclid");
                if (uri != null)
                {
                    zzFf.put("&gclid", uri);
                    return;
                }
            }
        }
    }

    public void setClientId(String s)
    {
        set("&cid", s);
    }

    public void setEncoding(String s)
    {
        set("&de", s);
    }

    public void setHostname(String s)
    {
        set("&dh", s);
    }

    public void setLanguage(String s)
    {
        set("&ul", s);
    }

    public void setLocation(String s)
    {
        set("&dl", s);
    }

    public void setPage(String s)
    {
        set("&dp", s);
    }

    public void setReferrer(String s)
    {
        set("&dr", s);
    }

    public void setSampleRate(double d)
    {
        set("&sf", Double.toString(d));
    }

    public void setScreenColors(String s)
    {
        set("&sd", s);
    }

    public void setScreenName(String s)
    {
        set("&cd", s);
    }

    public void setScreenResolution(int i, int j)
    {
        if (i < 0 && j < 0)
        {
            zzae.zzac("Invalid width or height. The values should be non-negative.");
            return;
        } else
        {
            set("&sr", (new StringBuilder()).append(i).append("x").append(j).toString());
            return;
        }
    }

    public void setSessionTimeout(long l)
    {
        zzFh.setSessionTimeout(1000L * l);
    }

    public void setTitle(String s)
    {
        set("&dt", s);
    }

    public void setUseSecure(boolean flag)
    {
        set("useSecure", zzan.zzG(flag));
    }

    public void setViewportSize(String s)
    {
        set("&vp", s);
    }

    void zza(zzam zzam1)
    {
        zzae.zzab("Loading Tracker config values.");
        zzFj = zzam1;
        if (zzFj.zzgK())
        {
            zzam1 = zzFj.zzgL();
            set("&tid", zzam1);
            zzae.zzab((new StringBuilder()).append("[Tracker] trackingId loaded: ").append(zzam1).toString());
        }
        if (zzFj.zzgM())
        {
            zzam1 = Double.toString(zzFj.zzgN());
            set("&sf", zzam1);
            zzae.zzab((new StringBuilder()).append("[Tracker] sample frequency loaded: ").append(zzam1).toString());
        }
        if (zzFj.zzgO())
        {
            setSessionTimeout(zzFj.getSessionTimeout());
            zzae.zzab((new StringBuilder()).append("[Tracker] session timeout loaded: ").append(zzgE()).toString());
        }
        if (zzFj.zzgP())
        {
            enableAutoActivityTracking(zzFj.zzgQ());
            zzae.zzab((new StringBuilder()).append("[Tracker] auto activity tracking loaded: ").append(zzgF()).toString());
        }
        if (zzFj.zzgR())
        {
            if (zzFj.zzgS())
            {
                set("&aip", "1");
                zzae.zzab("[Tracker] anonymize ip loaded: true");
            }
            zzae.zzab("[Tracker] anonymize ip loaded: false");
        }
        enableExceptionReporting(zzFj.zzgT());
    }

    long zzgE()
    {
        return zzFh.zzgE();
    }

    boolean zzgF()
    {
        return zzFh.zzgF();
    }
}
