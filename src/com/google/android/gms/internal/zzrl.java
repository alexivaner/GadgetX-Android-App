// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zze;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.connection.AppMetadata;
import com.google.android.gms.nearby.connection.Connections;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzrk

public final class zzrl
    implements Connections
{
    private static abstract class zza extends com.google.android.gms.common.api.zza.zza
    {

        public zza(GoogleApiClient googleapiclient)
        {
            super(zzrl.zzGR, googleapiclient);
        }
    }

    private static abstract class zzb extends zza
    {

        public Result createFailedResult(Status status)
        {
            return zzaF(status);
        }

        public com.google.android.gms.nearby.connection.Connections.StartAdvertisingResult zzaF(Status status)
        {
            return new com.google.android.gms.nearby.connection.Connections.StartAdvertisingResult(this, status) {

                final Status zzGT;
                final zzb zzate;

                public String getLocalEndpointName()
                {
                    return null;
                }

                public Status getStatus()
                {
                    return zzGT;
                }

            
            {
                zzate = zzb1;
                zzGT = status;
                super();
            }
            };
        }

        private zzb(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }

    private static abstract class zzc extends zza
    {

        public Result createFailedResult(Status status)
        {
            return zzb(status);
        }

        public Status zzb(Status status)
        {
            return status;
        }

        private zzc(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }


    public static final com.google.android.gms.common.api.Api.zzc zzGR = new com.google.android.gms.common.api.Api.zzc();
    public static final com.google.android.gms.common.api.Api.zzb zzGS = new com.google.android.gms.common.api.Api.zzb() {

        public int getPriority()
        {
            return 0x7fffffff;
        }

        public com.google.android.gms.common.api.Api.zza zza(Context context, Looper looper, zzf zzf, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return zzl(context, looper, zzf, (com.google.android.gms.common.api.Api.ApiOptions.NoOptions)obj, connectioncallbacks, onconnectionfailedlistener);
        }

        public zzrk zzl(Context context, Looper looper, zzf zzf, com.google.android.gms.common.api.Api.ApiOptions.NoOptions nooptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return new zzrk(context, looper, connectioncallbacks, onconnectionfailedlistener);
        }

    };

    public zzrl()
    {
    }

    public static zzrk zzd(GoogleApiClient googleapiclient, boolean flag)
    {
        boolean flag1;
        if (googleapiclient != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        zzx.zzb(flag1, "GoogleApiClient parameter is required.");
        zzx.zza(googleapiclient.isConnected(), "GoogleApiClient must be connected.");
        return zze(googleapiclient, flag);
    }

    public static zzrk zze(GoogleApiClient googleapiclient, boolean flag)
    {
        zzx.zza(googleapiclient.zza(Nearby.CONNECTIONS_API), "GoogleApiClient is not configured to use the Nearby Connections Api. Pass Nearby.CONNECTIONS_API into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean flag1 = googleapiclient.zzb(Nearby.CONNECTIONS_API);
        if (flag && !flag1)
        {
            throw new IllegalStateException("GoogleApiClient has an optional Nearby.CONNECTIONS_API and is not connected to Nearby Connections. Use GoogleApiClient.hasConnectedApi(Nearby.CONNECTIONS_API) to guard this call.");
        }
        if (flag1)
        {
            return (zzrk)googleapiclient.zza(zzGR);
        } else
        {
            return null;
        }
    }

    public PendingResult acceptConnectionRequest(GoogleApiClient googleapiclient, String s, byte abyte0[], com.google.android.gms.nearby.connection.Connections.MessageListener messagelistener)
    {
        return googleapiclient.zzb(new zzc(googleapiclient, s, abyte0, googleapiclient.zzf(messagelistener)) {

            final byte zzahb[];
            final String zzasJ;
            final zzrl zzata;
            final zze zzatd;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzrk)zza1);
            }

            protected void zza(zzrk zzrk1)
                throws RemoteException
            {
                zzrk1.zza(this, zzasJ, zzahb, zzatd);
            }

            
            {
                zzata = zzrl.this;
                zzasJ = s;
                zzahb = abyte0;
                zzatd = zze1;
                super(googleapiclient);
            }
        });
    }

    public void disconnectFromEndpoint(GoogleApiClient googleapiclient, String s)
    {
        zzd(googleapiclient, false).zzcy(s);
    }

    public String getLocalDeviceId(GoogleApiClient googleapiclient)
    {
        return zzd(googleapiclient, true).zzrl();
    }

    public String getLocalEndpointId(GoogleApiClient googleapiclient)
    {
        return zzd(googleapiclient, true).zzrk();
    }

    public PendingResult rejectConnectionRequest(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.zzb(new zzc(googleapiclient, s) {

            final String zzasJ;
            final zzrl zzata;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzrk)zza1);
            }

            protected void zza(zzrk zzrk1)
                throws RemoteException
            {
                zzrk1.zzq(this, zzasJ);
            }

            
            {
                zzata = zzrl.this;
                zzasJ = s;
                super(googleapiclient);
            }
        });
    }

    public PendingResult sendConnectionRequest(final GoogleApiClient final_googleapiclient, String s, String s1, byte abyte0[], com.google.android.gms.nearby.connection.Connections.ConnectionResponseCallback connectionresponsecallback, com.google.android.gms.nearby.connection.Connections.MessageListener messagelistener)
    {
        return final_googleapiclient.zzb(new zzc(s, s1, abyte0, final_googleapiclient.zzf(connectionresponsecallback), final_googleapiclient.zzf(messagelistener)) {

            final String val$name;
            final byte zzahb[];
            final String zzasJ;
            final zzrl zzata;
            final zze zzatc;
            final zze zzatd;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzrk)zza1);
            }

            protected void zza(zzrk zzrk1)
                throws RemoteException
            {
                zzrk1.zza(this, name, zzasJ, zzahb, zzatc, zzatd);
            }

            
            {
                zzata = zzrl.this;
                name = s;
                zzasJ = s1;
                zzahb = abyte0;
                zzatc = zze1;
                zzatd = zze2;
                super(final_googleapiclient);
            }
        });
    }

    public void sendReliableMessage(GoogleApiClient googleapiclient, String s, byte abyte0[])
    {
        zzd(googleapiclient, false).zza(new String[] {
            s
        }, abyte0);
    }

    public void sendReliableMessage(GoogleApiClient googleapiclient, List list, byte abyte0[])
    {
        zzd(googleapiclient, false).zza((String[])list.toArray(new String[list.size()]), abyte0);
    }

    public void sendUnreliableMessage(GoogleApiClient googleapiclient, String s, byte abyte0[])
    {
        zzd(googleapiclient, false).zzb(new String[] {
            s
        }, abyte0);
    }

    public void sendUnreliableMessage(GoogleApiClient googleapiclient, List list, byte abyte0[])
    {
        zzd(googleapiclient, false).zzb((String[])list.toArray(new String[list.size()]), abyte0);
    }

    public PendingResult startAdvertising(final GoogleApiClient final_googleapiclient, String s, AppMetadata appmetadata, long l, com.google.android.gms.nearby.connection.Connections.ConnectionRequestListener connectionrequestlistener)
    {
        return final_googleapiclient.zzb(new zzb(s, appmetadata, l, final_googleapiclient.zzf(connectionrequestlistener)) {

            final String val$name;
            final AppMetadata zzasX;
            final long zzasY;
            final zze zzasZ;
            final zzrl zzata;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzrk)zza1);
            }

            protected void zza(zzrk zzrk1)
                throws RemoteException
            {
                zzrk1.zza(this, name, zzasX, zzasY, zzasZ);
            }

            
            {
                zzata = zzrl.this;
                name = s;
                zzasX = appmetadata;
                zzasY = l;
                zzasZ = zze1;
                super(final_googleapiclient);
            }
        });
    }

    public PendingResult startDiscovery(GoogleApiClient googleapiclient, String s, long l, com.google.android.gms.nearby.connection.Connections.EndpointDiscoveryListener endpointdiscoverylistener)
    {
        return googleapiclient.zzb(new zzc(googleapiclient, s, l, googleapiclient.zzf(endpointdiscoverylistener)) {

            final String zzasV;
            final long zzasY;
            final zzrl zzata;
            final zze zzatb;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzrk)zza1);
            }

            protected void zza(zzrk zzrk1)
                throws RemoteException
            {
                zzrk1.zza(this, zzasV, zzasY, zzatb);
            }

            
            {
                zzata = zzrl.this;
                zzasV = s;
                zzasY = l;
                zzatb = zze1;
                super(googleapiclient);
            }
        });
    }

    public void stopAdvertising(GoogleApiClient googleapiclient)
    {
        zzd(googleapiclient, false).zzrm();
    }

    public void stopAllEndpoints(GoogleApiClient googleapiclient)
    {
        zzd(googleapiclient, false).zzrn();
    }

    public void stopDiscovery(GoogleApiClient googleapiclient, String s)
    {
        zzd(googleapiclient, false).zzcx(s);
    }

}
