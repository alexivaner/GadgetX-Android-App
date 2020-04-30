// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zze;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.connection.AppMetadata;

// Referenced classes of package com.google.android.gms.internal:
//            zzrn, zzrj

public final class zzrk extends zzk
{
    private static final class zza extends zzb
    {

        private final com.google.android.gms.common.api.zza.zzb zzHa;

        public void zzgv(int i)
            throws RemoteException
        {
            zzHa.zzd(new Status(i));
        }

        public zza(com.google.android.gms.common.api.zza.zzb zzb1, com.google.android.gms.common.api.zze zze1)
        {
            super(zze1);
            zzHa = (com.google.android.gms.common.api.zza.zzb)zzx.zzl(zzb1);
        }
    }

    private static class zzb extends zzrj
    {

        private final com.google.android.gms.common.api.zze zzasI;

        public void onDisconnected(String s)
            throws RemoteException
        {
            zzasI.zza(new com.google.android.gms.common.api.zze.zzb(this, s) {

                final String zzasJ;
                final zzb zzasL;

                public void zza(com.google.android.gms.nearby.connection.Connections.MessageListener messagelistener)
                {
                    messagelistener.onDisconnected(zzasJ);
                }

                public void zze(Object obj)
                {
                    zza((com.google.android.gms.nearby.connection.Connections.MessageListener)obj);
                }

                public void zzhX()
                {
                }

            
            {
                zzasL = zzb1;
                zzasJ = s;
                super();
            }
            });
        }

        public void onMessageReceived(String s, byte abyte0[], boolean flag)
            throws RemoteException
        {
            zzasI.zza(new com.google.android.gms.common.api.zze.zzb(this, s, abyte0, flag) {

                final byte zzahb[];
                final String zzasJ;
                final boolean zzasK;
                final zzb zzasL;

                public void zza(com.google.android.gms.nearby.connection.Connections.MessageListener messagelistener)
                {
                    messagelistener.onMessageReceived(zzasJ, zzahb, zzasK);
                }

                public void zze(Object obj)
                {
                    zza((com.google.android.gms.nearby.connection.Connections.MessageListener)obj);
                }

                public void zzhX()
                {
                }

            
            {
                zzasL = zzb1;
                zzasJ = s;
                zzahb = abyte0;
                zzasK = flag;
                super();
            }
            });
        }

        zzb(com.google.android.gms.common.api.zze zze1)
        {
            zzasI = zze1;
        }
    }

    private static final class zzc extends zzb
    {

        private final com.google.android.gms.common.api.zza.zzb zzHa;
        private final com.google.android.gms.common.api.zze zzasM;

        public void zza(String s, int i, byte abyte0[])
            throws RemoteException
        {
            zzasM.zza(new com.google.android.gms.common.api.zze.zzb(this, s, i, abyte0) {

                final int zzKJ;
                final byte zzahb[];
                final String zzasJ;
                final zzc zzasN;

                public void zza(com.google.android.gms.nearby.connection.Connections.ConnectionResponseCallback connectionresponsecallback)
                {
                    connectionresponsecallback.onConnectionResponse(zzasJ, new Status(zzKJ), zzahb);
                }

                public void zze(Object obj)
                {
                    zza((com.google.android.gms.nearby.connection.Connections.ConnectionResponseCallback)obj);
                }

                public void zzhX()
                {
                }

            
            {
                zzasN = zzc1;
                zzasJ = s;
                zzKJ = i;
                zzahb = abyte0;
                super();
            }
            });
        }

        public void zzgu(int i)
            throws RemoteException
        {
            zzHa.zzd(new Status(i));
        }

        public zzc(com.google.android.gms.common.api.zza.zzb zzb1, com.google.android.gms.common.api.zze zze1, com.google.android.gms.common.api.zze zze2)
        {
            super(zze2);
            zzHa = (com.google.android.gms.common.api.zza.zzb)zzx.zzl(zzb1);
            zzasM = (com.google.android.gms.common.api.zze)zzx.zzl(zze1);
        }
    }

    private static final class zzd extends zzrj
    {

        private final com.google.android.gms.common.api.zza.zzb zzHa;
        private final com.google.android.gms.common.api.zze zzasO;

        public void onConnectionRequest(String s, String s1, String s2, byte abyte0[])
            throws RemoteException
        {
            zzasO.zza(new com.google.android.gms.common.api.zze.zzb(this, s, s1, s2, abyte0) {

                final byte zzahb[];
                final String zzasJ;
                final String zzasP;
                final String zzasQ;
                final zzd zzasR;

                public void zza(com.google.android.gms.nearby.connection.Connections.ConnectionRequestListener connectionrequestlistener)
                {
                    connectionrequestlistener.onConnectionRequest(zzasJ, zzasP, zzasQ, zzahb);
                }

                public void zze(Object obj)
                {
                    zza((com.google.android.gms.nearby.connection.Connections.ConnectionRequestListener)obj);
                }

                public void zzhX()
                {
                }

            
            {
                zzasR = zzd1;
                zzasJ = s;
                zzasP = s1;
                zzasQ = s2;
                zzahb = abyte0;
                super();
            }
            });
        }

        public void zzi(int i, String s)
            throws RemoteException
        {
            zzHa.zzd(new zze(new Status(i), s));
        }

        zzd(com.google.android.gms.common.api.zza.zzb zzb1, com.google.android.gms.common.api.zze zze1)
        {
            zzHa = (com.google.android.gms.common.api.zza.zzb)zzx.zzl(zzb1);
            zzasO = (com.google.android.gms.common.api.zze)zzx.zzl(zze1);
        }
    }

    private static final class zze
        implements com.google.android.gms.nearby.connection.Connections.StartAdvertisingResult
    {

        private final Status zzHb;
        private final String zzasS;

        public String getLocalEndpointName()
        {
            return zzasS;
        }

        public Status getStatus()
        {
            return zzHb;
        }

        zze(Status status, String s)
        {
            zzHb = status;
            zzasS = s;
        }
    }

    private static final class zzf extends zzrj
    {

        private final com.google.android.gms.common.api.zza.zzb zzHa;
        private final com.google.android.gms.common.api.zze zzasO;

        public void onEndpointFound(String s, String s1, String s2, String s3)
            throws RemoteException
        {
            zzasO.zza(new com.google.android.gms.common.api.zze.zzb(s, s1, s2, s3) {

                final String val$name;
                final String zzasT;
                final String zzasU;
                final String zzasV;
                final zzf zzasW;

                public void zza(com.google.android.gms.nearby.connection.Connections.EndpointDiscoveryListener endpointdiscoverylistener)
                {
                    endpointdiscoverylistener.onEndpointFound(zzasT, zzasU, zzasV, name);
                }

                public void zze(Object obj)
                {
                    zza((com.google.android.gms.nearby.connection.Connections.EndpointDiscoveryListener)obj);
                }

                public void zzhX()
                {
                }

            
            {
                zzasW = final_zzf1;
                zzasT = s;
                zzasU = s1;
                zzasV = s2;
                name = s3;
                super();
            }
            });
        }

        public void onEndpointLost(String s)
            throws RemoteException
        {
            zzasO.zza(new com.google.android.gms.common.api.zze.zzb(this, s) {

                final String zzasT;
                final zzf zzasW;

                public void zza(com.google.android.gms.nearby.connection.Connections.EndpointDiscoveryListener endpointdiscoverylistener)
                {
                    endpointdiscoverylistener.onEndpointLost(zzasT);
                }

                public void zze(Object obj)
                {
                    zza((com.google.android.gms.nearby.connection.Connections.EndpointDiscoveryListener)obj);
                }

                public void zzhX()
                {
                }

            
            {
                zzasW = zzf1;
                zzasT = s;
                super();
            }
            });
        }

        public void zzgs(int i)
            throws RemoteException
        {
            zzHa.zzd(new Status(i));
        }

        zzf(com.google.android.gms.common.api.zza.zzb zzb1, com.google.android.gms.common.api.zze zze1)
        {
            zzHa = (com.google.android.gms.common.api.zza.zzb)zzx.zzl(zzb1);
            zzasO = (com.google.android.gms.common.api.zze)zzx.zzl(zze1);
        }
    }


    private final long zzadW = (long)hashCode();

    public zzrk(Context context, Looper looper, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        super(context, looper, 54, connectioncallbacks, onconnectionfailedlistener);
    }

    public void disconnect()
    {
        if (isConnected())
        {
            try
            {
                ((zzrn)zzjb()).zzu(zzadW);
            }
            catch (RemoteException remoteexception)
            {
                Log.w("NearbyConnectionsClient", "Failed to notify client disconnect.", remoteexception);
            }
        }
        super.disconnect();
    }

    public void zza(com.google.android.gms.common.api.zza.zzb zzb1, String s, long l, com.google.android.gms.common.api.zze zze1)
        throws RemoteException
    {
        ((zzrn)zzjb()).zza(new zzf(zzb1, zze1), s, l, zzadW);
    }

    public void zza(com.google.android.gms.common.api.zza.zzb zzb1, String s, AppMetadata appmetadata, long l, com.google.android.gms.common.api.zze zze1)
        throws RemoteException
    {
        ((zzrn)zzjb()).zza(new zzd(zzb1, zze1), s, appmetadata, l, zzadW);
    }

    public void zza(com.google.android.gms.common.api.zza.zzb zzb1, String s, String s1, byte abyte0[], com.google.android.gms.common.api.zze zze1, com.google.android.gms.common.api.zze zze2)
        throws RemoteException
    {
        ((zzrn)zzjb()).zza(new zzc(zzb1, zze1, zze2), s, s1, abyte0, zzadW);
    }

    public void zza(com.google.android.gms.common.api.zza.zzb zzb1, String s, byte abyte0[], com.google.android.gms.common.api.zze zze1)
        throws RemoteException
    {
        ((zzrn)zzjb()).zza(new zza(zzb1, zze1), s, abyte0, zzadW);
    }

    public void zza(String as[], byte abyte0[])
    {
        try
        {
            ((zzrn)zzjb()).zza(as, abyte0, zzadW);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            Log.w("NearbyConnectionsClient", "Couldn't send reliable message", as);
        }
    }

    public void zzb(String as[], byte abyte0[])
    {
        try
        {
            ((zzrn)zzjb()).zzb(as, abyte0, zzadW);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            Log.w("NearbyConnectionsClient", "Couldn't send unreliable message", as);
        }
    }

    protected String zzcF()
    {
        return "com.google.android.gms.nearby.connection.service.START";
    }

    protected String zzcG()
    {
        return "com.google.android.gms.nearby.internal.connection.INearbyConnectionService";
    }

    protected zzrn zzcg(IBinder ibinder)
    {
        return com.google.android.gms.internal.zzrn.zza.zzci(ibinder);
    }

    public void zzcx(String s)
    {
        try
        {
            ((zzrn)zzjb()).zzb(s, zzadW);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.w("NearbyConnectionsClient", "Couldn't stop discovery", s);
        }
    }

    public void zzcy(String s)
    {
        try
        {
            ((zzrn)zzjb()).zzc(s, zzadW);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.w("NearbyConnectionsClient", "Couldn't disconnect from endpoint", s);
        }
    }

    protected IInterface zzp(IBinder ibinder)
    {
        return zzcg(ibinder);
    }

    public void zzq(com.google.android.gms.common.api.zza.zzb zzb1, String s)
        throws RemoteException
    {
        ((zzrn)zzjb()).zza(new zzrj(zzb1) {

            final com.google.android.gms.common.api.zza.zzb zzasG;
            final zzrk zzasH;

            public void zzgw(int i)
                throws RemoteException
            {
                zzasG.zzd(new Status(i));
            }

            
            {
                zzasH = zzrk.this;
                zzasG = zzb1;
                super();
            }
        }, s, zzadW);
    }

    public String zzrk()
    {
        String s;
        try
        {
            s = ((zzrn)zzjb()).zzE(zzadW);
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeException(remoteexception);
        }
        return s;
    }

    public String zzrl()
    {
        String s;
        try
        {
            s = ((zzrn)zzjb()).zzrl();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeException(remoteexception);
        }
        return s;
    }

    public void zzrm()
    {
        try
        {
            ((zzrn)zzjb()).zzB(zzadW);
            return;
        }
        catch (RemoteException remoteexception)
        {
            Log.w("NearbyConnectionsClient", "Couldn't stop advertising", remoteexception);
        }
    }

    public void zzrn()
    {
        try
        {
            ((zzrn)zzjb()).zzD(zzadW);
            return;
        }
        catch (RemoteException remoteexception)
        {
            Log.w("NearbyConnectionsClient", "Couldn't stop all endpoints", remoteexception);
        }
    }
}
