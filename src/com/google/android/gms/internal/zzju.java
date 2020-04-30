// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.zzk;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package com.google.android.gms.internal:
//            zzkc, zzjp, zzjv, zzjw, 
//            zzjz

public final class zzju extends zzk
{
    private static final class zza
        implements com.google.android.gms.cast.Cast.ApplicationConnectionResult
    {

        private final Status zzHb;
        private final ApplicationMetadata zzKD;
        private final String zzKE;
        private final boolean zzKF;
        private final String zzyL;

        public ApplicationMetadata getApplicationMetadata()
        {
            return zzKD;
        }

        public String getApplicationStatus()
        {
            return zzKE;
        }

        public String getSessionId()
        {
            return zzyL;
        }

        public Status getStatus()
        {
            return zzHb;
        }

        public boolean getWasLaunched()
        {
            return zzKF;
        }

        public zza(Status status)
        {
            this(status, null, null, null, false);
        }

        public zza(Status status, ApplicationMetadata applicationmetadata, String s, String s1, boolean flag)
        {
            zzHb = status;
            zzKD = applicationmetadata;
            zzKE = s;
            zzyL = s1;
            zzKF = flag;
        }
    }

    private class zzb
        implements com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    {

        final zzju zzKG;

        public void onConnectionFailed(ConnectionResult connectionresult)
        {
            zzju.zzb(zzKG);
        }

        private zzb()
        {
            zzKG = zzju.this;
            super();
        }

    }

    private static class zzc extends zzka.zza
    {

        private final Handler mHandler;
        private final AtomicReference zzKH;

        private void zza(zzju zzju1, long l, int i)
        {
            synchronized (zzju.zzh(zzju1))
            {
                zzju1 = (com.google.android.gms.common.api.zza.zzb)zzju.zzh(zzju1).remove(Long.valueOf(l));
            }
            if (zzju1 != null)
            {
                zzju1.zzd(new Status(i));
            }
            return;
            zzju1;
            map;
            JVM INSTR monitorexit ;
            throw zzju1;
        }

        private boolean zza(zzju zzju1, int i)
        {
            Object obj = zzju.zzhx();
            obj;
            JVM INSTR monitorenter ;
            if (zzju.zzi(zzju1) == null)
            {
                break MISSING_BLOCK_LABEL_40;
            }
            zzju.zzi(zzju1).zzd(new Status(i));
            zzju.zzb(zzju1, null);
            return true;
            obj;
            JVM INSTR monitorexit ;
            return false;
            zzju1;
            obj;
            JVM INSTR monitorexit ;
            throw zzju1;
        }

        public void onApplicationDisconnected(int i)
        {
            zzju zzju1 = (zzju)zzKH.get();
            if (zzju1 != null)
            {
                zzju.zza(zzju1, null);
                zzju.zzb(zzju1, null);
                zza(zzju1, i);
                if (zzju.zze(zzju1) != null)
                {
                    mHandler.post(new Runnable(this, zzju1, i) {

                        final zzju zzKI;
                        final int zzKJ;
                        final zzc zzKK;

                        public void run()
                        {
                            if (zzju.zze(zzKI) != null)
                            {
                                zzju.zze(zzKI).onApplicationDisconnected(zzKJ);
                            }
                        }

            
            {
                zzKK = zzc1;
                zzKI = zzju1;
                zzKJ = i;
                super();
            }
                    });
                    return;
                }
            }
        }

        public void zza(ApplicationMetadata applicationmetadata, String s, String s1, boolean flag)
        {
            zzju zzju1 = (zzju)zzKH.get();
            if (zzju1 == null)
            {
                return;
            }
            zzju.zza(zzju1, applicationmetadata);
            zzju.zza(zzju1, applicationmetadata.getApplicationId());
            zzju.zzb(zzju1, s1);
            synchronized (zzju.zzhw())
            {
                if (zzju.zzd(zzju1) != null)
                {
                    zzju.zzd(zzju1).zzd(new zza(new Status(0), applicationmetadata, s, s1, flag));
                    zzju.zza(zzju1, null);
                }
            }
            return;
            applicationmetadata;
            obj;
            JVM INSTR monitorexit ;
            throw applicationmetadata;
        }

        public void zza(String s, double d, boolean flag)
        {
            zzju.zzhv().zzb("Deprecated callback: \"onStatusreceived\"", new Object[0]);
        }

        public void zza(String s, long l)
        {
            s = (zzju)zzKH.get();
            if (s == null)
            {
                return;
            } else
            {
                zza(((zzju) (s)), l, 0);
                return;
            }
        }

        public void zza(String s, long l, int i)
        {
            s = (zzju)zzKH.get();
            if (s == null)
            {
                return;
            } else
            {
                zza(((zzju) (s)), l, i);
                return;
            }
        }

        public void zzai(int i)
        {
            zzju zzju1 = zzhy();
            if (zzju1 != null)
            {
                zzju.zzhv().zzb("ICastDeviceControllerListener.onDisconnected: %d", new Object[] {
                    Integer.valueOf(i)
                });
                if (i != 0)
                {
                    zzju1.zzaI(2);
                    return;
                }
            }
        }

        public void zzaj(int i)
        {
            zzju zzju1 = (zzju)zzKH.get();
            if (zzju1 == null)
            {
                return;
            }
            synchronized (zzju.zzhw())
            {
                if (zzju.zzd(zzju1) != null)
                {
                    zzju.zzd(zzju1).zzd(new zza(new Status(i)));
                    zzju.zza(zzju1, null);
                }
            }
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void zzak(int i)
        {
            zzju zzju1 = (zzju)zzKH.get();
            if (zzju1 == null)
            {
                return;
            } else
            {
                zza(zzju1, i);
                return;
            }
        }

        public void zzal(int i)
        {
            zzju zzju1 = (zzju)zzKH.get();
            if (zzju1 == null)
            {
                return;
            } else
            {
                zza(zzju1, i);
                return;
            }
        }

        public void zzb(zzjp zzjp1)
        {
            zzju zzju1 = (zzju)zzKH.get();
            if (zzju1 == null)
            {
                return;
            } else
            {
                zzju.zzhv().zzb("onApplicationStatusChanged", new Object[0]);
                mHandler.post(new Runnable(this, zzju1, zzjp1) {

                    final zzju zzKI;
                    final zzc zzKK;
                    final zzjp zzKM;

                    public void run()
                    {
                        zzju.zza(zzKI, zzKM);
                    }

            
            {
                zzKK = zzc1;
                zzKI = zzju1;
                zzKM = zzjp1;
                super();
            }
                });
                return;
            }
        }

        public void zzb(zzjw zzjw1)
        {
            zzju zzju1 = (zzju)zzKH.get();
            if (zzju1 == null)
            {
                return;
            } else
            {
                zzju.zzhv().zzb("onDeviceStatusChanged", new Object[0]);
                mHandler.post(new Runnable(this, zzju1, zzjw1) {

                    final zzju zzKI;
                    final zzc zzKK;
                    final zzjw zzKL;

                    public void run()
                    {
                        zzju.zza(zzKI, zzKL);
                    }

            
            {
                zzKK = zzc1;
                zzKI = zzju1;
                zzKL = zzjw1;
                super();
            }
                });
                return;
            }
        }

        public void zzb(String s, byte abyte0[])
        {
            if ((zzju)zzKH.get() == null)
            {
                return;
            } else
            {
                zzju.zzhv().zzb("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", new Object[] {
                    s, Integer.valueOf(abyte0.length)
                });
                return;
            }
        }

        public zzju zzhy()
        {
            zzju zzju1 = (zzju)zzKH.getAndSet(null);
            if (zzju1 == null)
            {
                return null;
            } else
            {
                zzju.zzc(zzju1);
                return zzju1;
            }
        }

        public boolean zzhz()
        {
            return zzKH.get() == null;
        }

        public void zzn(String s, String s1)
        {
            zzju zzju1 = (zzju)zzKH.get();
            if (zzju1 == null)
            {
                return;
            } else
            {
                zzju.zzhv().zzb("Receive (type=text, ns=%s) %s", new Object[] {
                    s, s1
                });
                mHandler.post(new Runnable(this, zzju1, s, s1) {

                    final String zzIr;
                    final zzju zzKI;
                    final zzc zzKK;
                    final String zzKN;

                    public void run()
                    {
                        com.google.android.gms.cast.Cast.MessageReceivedCallback messagereceivedcallback;
                        synchronized (zzju.zzf(zzKI))
                        {
                            messagereceivedcallback = (com.google.android.gms.cast.Cast.MessageReceivedCallback)zzju.zzf(zzKI).get(zzIr);
                        }
                        if (messagereceivedcallback != null)
                        {
                            messagereceivedcallback.onMessageReceived(zzju.zzg(zzKI), zzIr, zzKN);
                            return;
                        } else
                        {
                            zzju.zzhv().zzb("Discarded message for unknown namespace '%s'", new Object[] {
                                zzIr
                            });
                            return;
                        }
                        exception;
                        map;
                        JVM INSTR monitorexit ;
                        throw exception;
                    }

            
            {
                zzKK = zzc1;
                zzKI = zzju1;
                zzIr = s;
                zzKN = s1;
                super();
            }
                });
                return;
            }
        }

        public zzc(zzju zzju1)
        {
            zzKH = new AtomicReference(zzju1);
            mHandler = new Handler(zzju1.getLooper());
        }
    }


    private static final Object zzKB = new Object();
    private static final Object zzKC = new Object();
    private static final zzkc zzKh = new zzkc("CastClientImpl");
    private final com.google.android.gms.cast.Cast.Listener zzIB;
    private double zzJm;
    private boolean zzJn;
    private com.google.android.gms.common.api.zza.zzb zzKA;
    private ApplicationMetadata zzKi;
    private final CastDevice zzKj;
    private final Map zzKk = new HashMap();
    private final long zzKl;
    private zzc zzKm;
    private String zzKn;
    private boolean zzKo;
    private boolean zzKp;
    private boolean zzKq;
    private int zzKr;
    private int zzKs;
    private final AtomicLong zzKt = new AtomicLong(0L);
    private String zzKu;
    private String zzKv;
    private Bundle zzKw;
    private final Map zzKx = new HashMap();
    private final zzb zzKy = new zzb();
    private com.google.android.gms.common.api.zza.zzb zzKz;

    public zzju(Context context, Looper looper, CastDevice castdevice, long l, com.google.android.gms.cast.Cast.Listener listener, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, 
            com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        super(context, looper, 10, connectioncallbacks, onconnectionfailedlistener);
        zzKj = castdevice;
        zzIB = listener;
        zzKl = l;
        zzho();
        registerConnectionFailedListener(zzKy);
    }

    static ApplicationMetadata zza(zzju zzju1, ApplicationMetadata applicationmetadata)
    {
        zzju1.zzKi = applicationmetadata;
        return applicationmetadata;
    }

    static com.google.android.gms.common.api.zza.zzb zza(zzju zzju1, com.google.android.gms.common.api.zza.zzb zzb1)
    {
        zzju1.zzKz = zzb1;
        return zzb1;
    }

    static String zza(zzju zzju1, String s)
    {
        zzju1.zzKu = s;
        return s;
    }

    private void zza(zzjp zzjp1)
    {
        zzjp1 = zzjp1.zzhl();
        boolean flag;
        if (!zzjv.zza(zzjp1, zzKn))
        {
            zzKn = zzjp1;
            flag = true;
        } else
        {
            flag = false;
        }
        zzKh.zzb("hasChanged=%b, mFirstApplicationStatusUpdate=%b", new Object[] {
            Boolean.valueOf(flag), Boolean.valueOf(zzKo)
        });
        if (zzIB != null && (flag || zzKo))
        {
            zzIB.onApplicationStatusChanged();
        }
        zzKo = false;
    }

    static void zza(zzju zzju1, zzjp zzjp1)
    {
        zzju1.zza(zzjp1);
    }

    static void zza(zzju zzju1, zzjw zzjw1)
    {
        zzju1.zza(zzjw1);
    }

    private void zza(zzjw zzjw1)
    {
        ApplicationMetadata applicationmetadata = zzjw1.getApplicationMetadata();
        if (!zzjv.zza(applicationmetadata, zzKi))
        {
            zzKi = applicationmetadata;
            zzIB.onApplicationMetadataChanged(zzKi);
        }
        double d = zzjw1.zzhs();
        int i;
        boolean flag;
        boolean flag1;
        if (d != (0.0D / 0.0D) && Math.abs(d - zzJm) > 9.9999999999999995E-08D)
        {
            zzJm = d;
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = zzjw1.zzhA();
        if (flag1 != zzJn)
        {
            zzJn = flag1;
            flag = true;
        }
        zzKh.zzb("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", new Object[] {
            Boolean.valueOf(flag), Boolean.valueOf(zzKp)
        });
        if (zzIB != null && (flag || zzKp))
        {
            zzIB.onVolumeChanged();
        }
        i = zzjw1.zzhB();
        if (i != zzKr)
        {
            zzKr = i;
            flag = true;
        } else
        {
            flag = false;
        }
        zzKh.zzb("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", new Object[] {
            Boolean.valueOf(flag), Boolean.valueOf(zzKp)
        });
        if (zzIB != null && (flag || zzKp))
        {
            zzIB.zzab(zzKr);
        }
        i = zzjw1.zzhC();
        if (i != zzKs)
        {
            zzKs = i;
            flag = true;
        } else
        {
            flag = false;
        }
        zzKh.zzb("hasStandbyStateChanged=%b, mFirstDeviceStatusUpdate=%b", new Object[] {
            Boolean.valueOf(flag), Boolean.valueOf(zzKp)
        });
        if (zzIB != null && (flag || zzKp))
        {
            zzIB.zzac(zzKs);
        }
        zzKp = false;
    }

    static com.google.android.gms.common.api.zza.zzb zzb(zzju zzju1, com.google.android.gms.common.api.zza.zzb zzb1)
    {
        zzju1.zzKA = zzb1;
        return zzb1;
    }

    static String zzb(zzju zzju1, String s)
    {
        zzju1.zzKv = s;
        return s;
    }

    static void zzb(zzju zzju1)
    {
        zzju1.zzht();
    }

    private void zzc(com.google.android.gms.common.api.zza.zzb zzb1)
    {
        synchronized (zzKB)
        {
            if (zzKz != null)
            {
                zzKz.zzd(new zza(new Status(2002)));
            }
            zzKz = zzb1;
        }
        return;
        zzb1;
        obj;
        JVM INSTR monitorexit ;
        throw zzb1;
    }

    static void zzc(zzju zzju1)
    {
        zzju1.zzho();
    }

    static com.google.android.gms.common.api.zza.zzb zzd(zzju zzju1)
    {
        return zzju1.zzKz;
    }

    static com.google.android.gms.cast.Cast.Listener zze(zzju zzju1)
    {
        return zzju1.zzIB;
    }

    private void zze(com.google.android.gms.common.api.zza.zzb zzb1)
    {
label0:
        {
            synchronized (zzKC)
            {
                if (zzKA == null)
                {
                    break label0;
                }
                zzb1.zzd(new Status(2001));
            }
            return;
        }
        zzKA = zzb1;
        obj;
        JVM INSTR monitorexit ;
        return;
        zzb1;
        obj;
        JVM INSTR monitorexit ;
        throw zzb1;
    }

    static Map zzf(zzju zzju1)
    {
        return zzju1.zzKk;
    }

    static CastDevice zzg(zzju zzju1)
    {
        return zzju1.zzKj;
    }

    static Map zzh(zzju zzju1)
    {
        return zzju1.zzKx;
    }

    private void zzho()
    {
        zzKq = false;
        zzKr = -1;
        zzKs = -1;
        zzKi = null;
        zzKn = null;
        zzJm = 0.0D;
        zzJn = false;
    }

    private void zzht()
    {
        zzKh.zzb("removing all MessageReceivedCallbacks", new Object[0]);
        synchronized (zzKk)
        {
            zzKk.clear();
        }
        return;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void zzhu()
        throws IllegalStateException
    {
        if (!zzKq || zzKm == null || zzKm.zzhz())
        {
            throw new IllegalStateException("Not connected to a device");
        } else
        {
            return;
        }
    }

    static zzkc zzhv()
    {
        return zzKh;
    }

    static Object zzhw()
    {
        return zzKB;
    }

    static Object zzhx()
    {
        return zzKC;
    }

    static com.google.android.gms.common.api.zza.zzb zzi(zzju zzju1)
    {
        return zzju1.zzKA;
    }

    public void disconnect()
    {
        zzKh.zzb("disconnect(); ServiceListener=%s, isConnected=%b", new Object[] {
            zzKm, Boolean.valueOf(isConnected())
        });
        zzc zzc1 = zzKm;
        zzKm = null;
        if (zzc1 == null || zzc1.zzhy() == null)
        {
            zzKh.zzb("already disposed, so short-circuiting", new Object[0]);
            return;
        }
        zzht();
        if (isConnected() || isConnecting())
        {
            ((zzjz)zzjb()).disconnect();
        }
        super.disconnect();
        return;
        Object obj;
        obj;
        zzKh.zza(((Throwable) (obj)), "Error while disconnecting the controller interface: %s", new Object[] {
            ((RemoteException) (obj)).getMessage()
        });
        super.disconnect();
        return;
        obj;
        super.disconnect();
        throw obj;
    }

    public ApplicationMetadata getApplicationMetadata()
        throws IllegalStateException
    {
        zzhu();
        return zzKi;
    }

    public String getApplicationStatus()
        throws IllegalStateException
    {
        zzhu();
        return zzKn;
    }

    public boolean isMute()
        throws IllegalStateException
    {
        zzhu();
        return zzJn;
    }

    public void zzL(boolean flag)
        throws IllegalStateException, RemoteException
    {
        ((zzjz)zzjb()).zza(flag, zzJm, zzJn);
    }

    protected zzjz zzO(IBinder ibinder)
    {
        return zzjz.zza.zzP(ibinder);
    }

    public void zza(double d)
        throws IllegalArgumentException, IllegalStateException, RemoteException
    {
        if (Double.isInfinite(d) || Double.isNaN(d))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Volume cannot be ").append(d).toString());
        } else
        {
            ((zzjz)zzjb()).zza(d, zzJm, zzJn);
            return;
        }
    }

    protected void zza(int i, IBinder ibinder, Bundle bundle)
    {
        zzKh.zzb("in onPostInitHandler; statusCode=%d", new Object[] {
            Integer.valueOf(i)
        });
        int j;
        if (i == 0 || i == 1001)
        {
            zzKq = true;
            zzKo = true;
            zzKp = true;
        } else
        {
            zzKq = false;
        }
        j = i;
        if (i == 1001)
        {
            zzKw = new Bundle();
            zzKw.putBoolean("com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING", true);
            j = 0;
        }
        super.zza(j, ibinder, bundle);
    }

    public void zza(String s, com.google.android.gms.cast.Cast.MessageReceivedCallback messagereceivedcallback)
        throws IllegalArgumentException, IllegalStateException, RemoteException
    {
        zzjv.zzaK(s);
        zzaJ(s);
        if (messagereceivedcallback != null)
        {
            synchronized (zzKk)
            {
                zzKk.put(s, messagereceivedcallback);
            }
            ((zzjz)zzjb()).zzaN(s);
        }
        return;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void zza(String s, LaunchOptions launchoptions, com.google.android.gms.common.api.zza.zzb zzb1)
        throws IllegalStateException, RemoteException
    {
        zzc(zzb1);
        ((zzjz)zzjb()).zza(s, launchoptions);
    }

    public void zza(String s, com.google.android.gms.common.api.zza.zzb zzb1)
        throws IllegalStateException, RemoteException
    {
        zze(zzb1);
        ((zzjz)zzjb()).zzaM(s);
    }

    public void zza(String s, String s1, com.google.android.gms.common.api.zza.zzb zzb1)
        throws IllegalArgumentException, IllegalStateException, RemoteException
    {
        if (TextUtils.isEmpty(s1))
        {
            throw new IllegalArgumentException("The message payload cannot be null or empty");
        }
        if (s1.length() > 0x10000)
        {
            throw new IllegalArgumentException("Message exceeds maximum size");
        }
        zzjv.zzaK(s);
        zzhu();
        long l = zzKt.incrementAndGet();
        try
        {
            zzKx.put(Long.valueOf(l), zzb1);
            ((zzjz)zzjb()).zza(s, s1, l);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            zzKx.remove(Long.valueOf(l));
        }
        throw s;
    }

    public void zza(String s, boolean flag, com.google.android.gms.common.api.zza.zzb zzb1)
        throws IllegalStateException, RemoteException
    {
        zzc(zzb1);
        ((zzjz)zzjb()).zzf(s, flag);
    }

    public void zzaJ(String s)
        throws IllegalArgumentException, RemoteException
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("Channel namespace cannot be null or empty");
        }
        com.google.android.gms.cast.Cast.MessageReceivedCallback messagereceivedcallback;
        synchronized (zzKk)
        {
            messagereceivedcallback = (com.google.android.gms.cast.Cast.MessageReceivedCallback)zzKk.remove(s);
        }
        if (messagereceivedcallback == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        ((zzjz)zzjb()).zzaO(s);
        return;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
        IllegalStateException illegalstateexception;
        illegalstateexception;
        zzKh.zza(illegalstateexception, "Error unregistering namespace (%s): %s", new Object[] {
            s, illegalstateexception.getMessage()
        });
        return;
    }

    public void zzb(String s, String s1, com.google.android.gms.common.api.zza.zzb zzb1)
        throws IllegalStateException, RemoteException
    {
        zzc(zzb1);
        ((zzjz)zzjb()).zzo(s, s1);
    }

    protected String zzcF()
    {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }

    protected String zzcG()
    {
        return "com.google.android.gms.cast.internal.ICastDeviceController";
    }

    public void zzd(com.google.android.gms.common.api.zza.zzb zzb1)
        throws IllegalStateException, RemoteException
    {
        zze(zzb1);
        ((zzjz)zzjb()).zzhD();
    }

    public Bundle zzhp()
    {
        if (zzKw != null)
        {
            Bundle bundle = zzKw;
            zzKw = null;
            return bundle;
        } else
        {
            return super.zzhp();
        }
    }

    protected Bundle zzhq()
    {
        Bundle bundle = new Bundle();
        zzKh.zzb("getRemoteService(): mLastApplicationId=%s, mLastSessionId=%s", new Object[] {
            zzKu, zzKv
        });
        zzKj.putInBundle(bundle);
        bundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", zzKl);
        zzKm = new zzc(this);
        bundle.putParcelable("listener", new BinderWrapper(zzKm.asBinder()));
        if (zzKu != null)
        {
            bundle.putString("last_application_id", zzKu);
            if (zzKv != null)
            {
                bundle.putString("last_session_id", zzKv);
            }
        }
        return bundle;
    }

    public void zzhr()
        throws IllegalStateException, RemoteException
    {
        ((zzjz)zzjb()).zzhr();
    }

    public double zzhs()
        throws IllegalStateException
    {
        zzhu();
        return zzJm;
    }

    protected IInterface zzp(IBinder ibinder)
    {
        return zzO(ibinder);
    }

}
