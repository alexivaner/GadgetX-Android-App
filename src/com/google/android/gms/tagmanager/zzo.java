// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.AbstractPendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlv;
import com.google.android.gms.internal.zzlx;
import com.google.android.gms.internal.zzvg;
import com.google.android.gms.internal.zzvk;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzca, zzcm, zzcl, zzbd, 
//            zzr, zzbf, Container, TagManager, 
//            zzn, zzcc, ContainerHolder, zzbe

public class zzo extends AbstractPendingResult
{
    static interface zza
    {

        public abstract boolean zzb(Container container);
    }

    private class zzb
        implements zzbe
    {

        final zzo zzaxX;

        public void zza(com.google.android.gms.internal.zzvd.zza zza1)
        {
            com.google.android.gms.internal.zzc.zzj zzj1;
            if (zza1.zzaBL != null)
            {
                zzj1 = zza1.zzaBL;
            } else
            {
                com.google.android.gms.internal.zzc.zzf zzf1 = zza1.zzgs;
                zzj1 = new com.google.android.gms.internal.zzc.zzj();
                zzj1.zzgs = zzf1;
                zzj1.zzgr = null;
                zzj1.zzgt = zzf1.version;
            }
            zzo.zza(zzaxX, zzj1, zza1.zzaBK, true);
        }

        public void zza(zzbe.zza zza1)
        {
            if (!zzo.zzh(zzaxX))
            {
                zzo.zza(zzaxX, 0L);
            }
        }

        public void zzo(Object obj)
        {
            zza((com.google.android.gms.internal.zzvd.zza)obj);
        }

        public void zzsR()
        {
        }

        private zzb()
        {
            zzaxX = zzo.this;
            super();
        }

    }

    private class zzc
        implements zzbe
    {

        final zzo zzaxX;

        public void zza(zzbe.zza zza1)
        {
            zza1 = zzaxX;
            zza1;
            JVM INSTR monitorenter ;
            if (!zzaxX.isReady())
            {
                if (zzo.zzf(zzaxX) == null)
                {
                    break MISSING_BLOCK_LABEL_54;
                }
                zzaxX.setResult(zzo.zzf(zzaxX));
            }
_L2:
            zzo.zza(zzaxX, 0x36ee80L);
            return;
            zzaxX.setResult(zzaxX.zzaN(Status.zzNr));
            if (true) goto _L2; else goto _L1
_L1:
            Exception exception;
            exception;
            zza1;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void zzb(com.google.android.gms.internal.zzc.zzj zzj1)
        {
label0:
            {
                synchronized (zzaxX)
                {
                    if (zzj1.zzgs != null)
                    {
                        break MISSING_BLOCK_LABEL_59;
                    }
                    if (zzo.zzi(zzaxX).zzgs != null)
                    {
                        break label0;
                    }
                    zzbf.zzZ("Current resource is null; network resource is also null");
                    zzo.zza(zzaxX, 0x36ee80L);
                }
                return;
            }
            zzj1.zzgs = zzo.zzi(zzaxX).zzgs;
            zzo.zza(zzaxX, zzj1, zzo.zzg(zzaxX).currentTimeMillis(), false);
            zzbf.zzab((new StringBuilder()).append("setting refresh time to current time: ").append(zzo.zzj(zzaxX)).toString());
            if (!zzo.zzk(zzaxX))
            {
                zzo.zza(zzaxX, zzj1);
            }
            zzo1;
            JVM INSTR monitorexit ;
            return;
            zzj1;
            zzo1;
            JVM INSTR monitorexit ;
            throw zzj1;
        }

        public void zzo(Object obj)
        {
            zzb((com.google.android.gms.internal.zzc.zzj)obj);
        }

        public void zzsR()
        {
        }

        private zzc()
        {
            zzaxX = zzo.this;
            super();
        }

    }

    private class zzd
        implements zzn.zza
    {

        final zzo zzaxX;

        public void zzcQ(String s)
        {
            zzaxX.zzcQ(s);
        }

        public String zzsK()
        {
            return zzaxX.zzsK();
        }

        public void zzsM()
        {
            if (zzo.zze(zzaxX).zzgv())
            {
                zzo.zza(zzaxX, 0L);
            }
        }

        private zzd()
        {
            zzaxX = zzo.this;
            super();
        }

    }

    static interface zze
        extends Releasable
    {

        public abstract void zza(zzbe zzbe);

        public abstract void zzcT(String s);

        public abstract void zze(long l, String s);
    }

    static interface zzf
        extends Releasable
    {

        public abstract void zza(zzbe zzbe);

        public abstract void zzb(com.google.android.gms.internal.zzvd.zza zza1);

        public abstract com.google.android.gms.internal.zzvl.zzc zzhc(int i);

        public abstract void zzsS();
    }


    private final Context mContext;
    private final Looper zzMc;
    private long zzaxB;
    private final TagManager zzaxI;
    private final zzd zzaxL;
    private final zzcc zzaxM;
    private final int zzaxN;
    private zzf zzaxO;
    private zzvg zzaxP;
    private volatile zzn zzaxQ;
    private volatile boolean zzaxR;
    private com.google.android.gms.internal.zzc.zzj zzaxS;
    private String zzaxT;
    private zze zzaxU;
    private zza zzaxV;
    private final String zzaxw;
    private final zzlv zzmW;

    zzo(Context context, TagManager tagmanager, Looper looper, String s, int i, zzf zzf1, zze zze1, 
            zzvg zzvg1, zzlv zzlv1, zzcc zzcc)
    {
        Looper looper1;
        if (looper == null)
        {
            looper1 = Looper.getMainLooper();
        } else
        {
            looper1 = looper;
        }
        super(looper1);
        mContext = context;
        zzaxI = tagmanager;
        context = looper;
        if (looper == null)
        {
            context = Looper.getMainLooper();
        }
        zzMc = context;
        zzaxw = s;
        zzaxN = i;
        zzaxO = zzf1;
        zzaxU = zze1;
        zzaxP = zzvg1;
        zzaxL = new zzd();
        zzaxS = new com.google.android.gms.internal.zzc.zzj();
        zzmW = zzlv1;
        zzaxM = zzcc;
        if (zzsQ())
        {
            zzcQ(zzca.zztx().zztz());
        }
    }

    public zzo(Context context, TagManager tagmanager, Looper looper, String s, int i, zzr zzr1)
    {
        this(context, tagmanager, looper, s, i, ((zzf) (new zzcm(context, s))), ((zze) (new zzcl(context, s, zzr1))), new zzvg(context), zzlx.zzkc(), ((zzcc) (new zzbd(30, 0xdbba0L, 5000L, "refreshing", zzlx.zzkc()))));
        zzaxP.zzdx(zzr1.zzsT());
    }

    private void zzF(long l)
    {
        this;
        JVM INSTR monitorenter ;
        if (zzaxU != null) goto _L2; else goto _L1
_L1:
        zzbf.zzac("Refresh requested, but no network load scheduler.");
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        zzaxU.zze(l, zzaxS.zzgt);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    static zzn zza(zzo zzo1, zzn zzn1)
    {
        zzo1.zzaxQ = zzn1;
        return zzn1;
    }

    static String zza(zzo zzo1)
    {
        return zzo1.zzaxw;
    }

    private void zza(com.google.android.gms.internal.zzc.zzj zzj1)
    {
        this;
        JVM INSTR monitorenter ;
        if (zzaxO != null)
        {
            com.google.android.gms.internal.zzvd.zza zza1 = new com.google.android.gms.internal.zzvd.zza();
            zza1.zzaBK = zzaxB;
            zza1.zzgs = new com.google.android.gms.internal.zzc.zzf();
            zza1.zzaBL = zzj1;
            zzaxO.zzb(zza1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        zzj1;
        throw zzj1;
    }

    private void zza(com.google.android.gms.internal.zzc.zzj zzj1, long l, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (!flag) goto _L2; else goto _L1
_L1:
        flag = zzaxR;
        if (!flag) goto _L2; else goto _L3
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (isReady())
        {
            if (zzaxQ != null);
        }
        zzaxS = zzj1;
        zzaxB = l;
        zzF(Math.max(0L, Math.min(0x2932e00L, (zzaxB + 0x2932e00L) - zzmW.currentTimeMillis())));
        zzj1 = new Container(mContext, zzaxI.getDataLayer(), zzaxw, l, zzj1);
        if (zzaxQ != null)
        {
            break; /* Loop/switch isn't completed */
        }
        zzaxQ = new zzn(zzaxI, zzMc, zzj1, zzaxL);
_L5:
        if (!isReady() && zzaxV.zzb(zzj1))
        {
            setResult(zzaxQ);
        }
        if (true) goto _L3; else goto _L4
        zzj1;
        throw zzj1;
_L4:
        zzaxQ.zza(zzj1);
          goto _L5
    }

    static void zza(zzo zzo1, long l)
    {
        zzo1.zzF(l);
    }

    static void zza(zzo zzo1, com.google.android.gms.internal.zzc.zzj zzj1)
    {
        zzo1.zza(zzj1);
    }

    static void zza(zzo zzo1, com.google.android.gms.internal.zzc.zzj zzj1, long l, boolean flag)
    {
        zzo1.zza(zzj1, l, flag);
    }

    private void zzag(boolean flag)
    {
        zzaxO.zza(new zzb());
        zzaxU.zza(new zzc());
        com.google.android.gms.internal.zzvl.zzc zzc1 = zzaxO.zzhc(zzaxN);
        if (zzc1 != null)
        {
            zzaxQ = new zzn(zzaxI, zzMc, new Container(mContext, zzaxI.getDataLayer(), zzaxw, 0L, zzc1), zzaxL);
        }
        zzaxV = new zza(flag) {

            final zzo zzaxX;
            final boolean zzaxZ;

            public boolean zzb(Container container)
            {
                if (!zzaxZ) goto _L2; else goto _L1
_L1:
                if (container.getLastRefreshTime() + 0x2932e00L < zzo.zzg(zzaxX).currentTimeMillis()) goto _L4; else goto _L3
_L3:
                return true;
_L4:
                return false;
_L2:
                if (container.isDefault())
                {
                    return false;
                }
                if (true) goto _L3; else goto _L5
_L5:
            }

            
            {
                zzaxX = zzo.this;
                zzaxZ = flag;
                super();
            }
        };
        if (zzsQ())
        {
            zzaxU.zze(0L, "");
            return;
        } else
        {
            zzaxO.zzsS();
            return;
        }
    }

    static TagManager zzb(zzo zzo1)
    {
        return zzo1.zzaxI;
    }

    static Looper zzc(zzo zzo1)
    {
        return zzo1.zzMc;
    }

    static Context zzd(zzo zzo1)
    {
        return zzo1.mContext;
    }

    static zzcc zze(zzo zzo1)
    {
        return zzo1.zzaxM;
    }

    static zzn zzf(zzo zzo1)
    {
        return zzo1.zzaxQ;
    }

    static zzlv zzg(zzo zzo1)
    {
        return zzo1.zzmW;
    }

    static boolean zzh(zzo zzo1)
    {
        return zzo1.zzaxR;
    }

    static com.google.android.gms.internal.zzc.zzj zzi(zzo zzo1)
    {
        return zzo1.zzaxS;
    }

    static long zzj(zzo zzo1)
    {
        return zzo1.zzaxB;
    }

    static boolean zzk(zzo zzo1)
    {
        return zzo1.zzsQ();
    }

    private boolean zzsQ()
    {
        zzca zzca1 = zzca.zztx();
        return (zzca1.zzty() == zzca.zza.zzazC || zzca1.zzty() == zzca.zza.zzazD) && zzaxw.equals(zzca1.getContainerId());
    }

    protected Result createFailedResult(Status status)
    {
        return zzaN(status);
    }

    public void load(String s)
    {
        Integer integer;
        if (zzaxN != -1)
        {
            integer = Integer.valueOf(zzaxN);
        } else
        {
            integer = null;
        }
        zzaxP.zza(zzaxw, integer, s, new com.google.android.gms.internal.zzvg.zza(s) {

            final String zzaxW;
            final zzo zzaxX;

            public void zza(zzvk zzvk1)
            {
                if (zzvk1.getStatus() != Status.zzNo)
                {
                    zzbf.zzZ((new StringBuilder()).append("Load request failed for the container ").append(zzo.zza(zzaxX)).toString());
                    zzaxX.setResult(zzaxX.zzaN(Status.zzNq));
                    return;
                }
                com.google.android.gms.internal.zzvl.zzc zzc1 = zzvk1.zzuo().zzus();
                if (zzc1 == null)
                {
                    zzbf.zzZ("Response doesn't have the requested container");
                    zzaxX.setResult(zzaxX.zzaN(new Status(8, "Response doesn't have the requested container", null)));
                    return;
                } else
                {
                    long l = zzvk1.zzuo().zzut();
                    zzo.zza(zzaxX, new zzn(zzo.zzb(zzaxX), zzo.zzc(zzaxX), new Container(zzo.zzd(zzaxX), zzo.zzb(zzaxX).getDataLayer(), zzo.zza(zzaxX), l, zzc1), new zzn.zza(this) {

                        final _cls1 zzaxY;

                        public void zzcQ(String s)
                        {
                            zzaxY.zzaxX.zzcQ(s);
                        }

                        public String zzsK()
                        {
                            return zzaxY.zzaxX.zzsK();
                        }

                        public void zzsM()
                        {
                            if (zzo.zze(zzaxY.zzaxX).zzgv())
                            {
                                zzaxY.zzaxX.load(zzaxY.zzaxW);
                            }
                        }

            
            {
                zzaxY = _pcls1;
                super();
            }
                    }));
                    zzaxX.setResult(zzo.zzf(zzaxX));
                    return;
                }
            }

            
            {
                zzaxX = zzo.this;
                zzaxW = s;
                super();
            }
        });
    }

    protected ContainerHolder zzaN(Status status)
    {
        if (zzaxQ != null)
        {
            return zzaxQ;
        }
        if (status == Status.zzNr)
        {
            zzbf.zzZ("timer expired: setting result to failure");
        }
        return new zzn(status);
    }

    void zzcQ(String s)
    {
        this;
        JVM INSTR monitorenter ;
        zzaxT = s;
        if (zzaxU != null)
        {
            zzaxU.zzcT(s);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    String zzsK()
    {
        this;
        JVM INSTR monitorenter ;
        String s = zzaxT;
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public void zzsN()
    {
        Object obj = zzaxO.zzhc(zzaxN);
        if (obj != null)
        {
            obj = new Container(mContext, zzaxI.getDataLayer(), zzaxw, 0L, ((com.google.android.gms.internal.zzvl.zzc) (obj)));
            setResult(new zzn(zzaxI, zzMc, ((Container) (obj)), new zzn.zza() {

                final zzo zzaxX;

                public void zzcQ(String s)
                {
                    zzaxX.zzcQ(s);
                }

                public String zzsK()
                {
                    return zzaxX.zzsK();
                }

                public void zzsM()
                {
                    zzbf.zzac("Refresh ignored: container loaded as default only.");
                }

            
            {
                zzaxX = zzo.this;
                super();
            }
            }));
        } else
        {
            zzbf.zzZ("Default was requested, but no default container was found");
            setResult(zzaN(new Status(10, "Default was requested, but no default container was found", null)));
        }
        zzaxU = null;
        zzaxO = null;
    }

    public void zzsO()
    {
        zzag(false);
    }

    public void zzsP()
    {
        zzag(true);
    }
}
