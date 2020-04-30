// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzjr;
import com.google.android.gms.internal.zzju;
import com.google.android.gms.internal.zzjy;
import com.google.android.gms.internal.zzkb;
import java.io.IOException;

// Referenced classes of package com.google.android.gms.cast:
//            ApplicationMetadata, LaunchOptions, CastDevice

public final class Cast
{
    public static interface ApplicationConnectionResult
        extends Result
    {

        public abstract ApplicationMetadata getApplicationMetadata();

        public abstract String getApplicationStatus();

        public abstract String getSessionId();

        public abstract boolean getWasLaunched();
    }

    public static interface CastApi
    {

        public abstract ApplicationMetadata getApplicationMetadata(GoogleApiClient googleapiclient)
            throws IllegalStateException;

        public abstract String getApplicationStatus(GoogleApiClient googleapiclient)
            throws IllegalStateException;

        public abstract double getVolume(GoogleApiClient googleapiclient)
            throws IllegalStateException;

        public abstract boolean isMute(GoogleApiClient googleapiclient)
            throws IllegalStateException;

        public abstract PendingResult joinApplication(GoogleApiClient googleapiclient);

        public abstract PendingResult joinApplication(GoogleApiClient googleapiclient, String s);

        public abstract PendingResult joinApplication(GoogleApiClient googleapiclient, String s, String s1);

        public abstract PendingResult launchApplication(GoogleApiClient googleapiclient, String s);

        public abstract PendingResult launchApplication(GoogleApiClient googleapiclient, String s, LaunchOptions launchoptions);

        public abstract PendingResult launchApplication(GoogleApiClient googleapiclient, String s, boolean flag);

        public abstract PendingResult leaveApplication(GoogleApiClient googleapiclient);

        public abstract void removeMessageReceivedCallbacks(GoogleApiClient googleapiclient, String s)
            throws IOException, IllegalArgumentException;

        public abstract void requestStatus(GoogleApiClient googleapiclient)
            throws IOException, IllegalStateException;

        public abstract PendingResult sendMessage(GoogleApiClient googleapiclient, String s, String s1);

        public abstract void setMessageReceivedCallbacks(GoogleApiClient googleapiclient, String s, MessageReceivedCallback messagereceivedcallback)
            throws IOException, IllegalStateException;

        public abstract void setMute(GoogleApiClient googleapiclient, boolean flag)
            throws IOException, IllegalStateException;

        public abstract void setVolume(GoogleApiClient googleapiclient, double d)
            throws IOException, IllegalArgumentException, IllegalStateException;

        public abstract PendingResult stopApplication(GoogleApiClient googleapiclient);

        public abstract PendingResult stopApplication(GoogleApiClient googleapiclient, String s);
    }

    public static final class CastApi.zza
        implements CastApi
    {

        public ApplicationMetadata getApplicationMetadata(GoogleApiClient googleapiclient)
            throws IllegalStateException
        {
            return ((zzju)googleapiclient.zza(zzkb.zzGR)).getApplicationMetadata();
        }

        public String getApplicationStatus(GoogleApiClient googleapiclient)
            throws IllegalStateException
        {
            return ((zzju)googleapiclient.zza(zzkb.zzGR)).getApplicationStatus();
        }

        public double getVolume(GoogleApiClient googleapiclient)
            throws IllegalStateException
        {
            return ((zzju)googleapiclient.zza(zzkb.zzGR)).zzhs();
        }

        public boolean isMute(GoogleApiClient googleapiclient)
            throws IllegalStateException
        {
            return ((zzju)googleapiclient.zza(zzkb.zzGR)).isMute();
        }

        public PendingResult joinApplication(GoogleApiClient googleapiclient)
        {
            return googleapiclient.zzb(new zza(this, googleapiclient) {

                final CastApi.zza zzIt;

                protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                    throws RemoteException
                {
                    zza((zzju)zza1);
                }

                protected void zza(zzju zzju1)
                    throws RemoteException
                {
                    try
                    {
                        zzju1.zzb(null, null, this);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (zzju zzju1)
                    {
                        zzah(2001);
                    }
                }

            
            {
                zzIt = zza1;
                super(googleapiclient);
            }
            });
        }

        public PendingResult joinApplication(GoogleApiClient googleapiclient, String s)
        {
            return googleapiclient.zzb(new zza(this, googleapiclient, s) {

                final CastApi.zza zzIt;
                final String zzIu;

                protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                    throws RemoteException
                {
                    zza((zzju)zza1);
                }

                protected void zza(zzju zzju1)
                    throws RemoteException
                {
                    try
                    {
                        zzju1.zzb(zzIu, null, this);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (zzju zzju1)
                    {
                        zzah(2001);
                    }
                }

            
            {
                zzIt = zza1;
                zzIu = s;
                super(googleapiclient);
            }
            });
        }

        public PendingResult joinApplication(GoogleApiClient googleapiclient, String s, String s1)
        {
            return googleapiclient.zzb(new zza(this, googleapiclient, s, s1) {

                final CastApi.zza zzIt;
                final String zzIu;
                final String zzIw;

                protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                    throws RemoteException
                {
                    zza((zzju)zza1);
                }

                protected void zza(zzju zzju1)
                    throws RemoteException
                {
                    try
                    {
                        zzju1.zzb(zzIu, zzIw, this);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (zzju zzju1)
                    {
                        zzah(2001);
                    }
                }

            
            {
                zzIt = zza1;
                zzIu = s;
                zzIw = s1;
                super(googleapiclient);
            }
            });
        }

        public PendingResult launchApplication(GoogleApiClient googleapiclient, String s)
        {
            return googleapiclient.zzb(new zza(this, googleapiclient, s) {

                final CastApi.zza zzIt;
                final String zzIu;

                protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                    throws RemoteException
                {
                    zza((zzju)zza1);
                }

                protected void zza(zzju zzju1)
                    throws RemoteException
                {
                    try
                    {
                        zzju1.zza(zzIu, false, this);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (zzju zzju1)
                    {
                        zzah(2001);
                    }
                }

            
            {
                zzIt = zza1;
                zzIu = s;
                super(googleapiclient);
            }
            });
        }

        public PendingResult launchApplication(GoogleApiClient googleapiclient, String s, LaunchOptions launchoptions)
        {
            return googleapiclient.zzb(new zza(this, googleapiclient, s, launchoptions) {

                final CastApi.zza zzIt;
                final String zzIu;
                final LaunchOptions zzIv;

                protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                    throws RemoteException
                {
                    zza((zzju)zza1);
                }

                protected void zza(zzju zzju1)
                    throws RemoteException
                {
                    try
                    {
                        zzju1.zza(zzIu, zzIv, this);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (zzju zzju1)
                    {
                        zzah(2001);
                    }
                }

            
            {
                zzIt = zza1;
                zzIu = s;
                zzIv = launchoptions;
                super(googleapiclient);
            }
            });
        }

        public PendingResult launchApplication(GoogleApiClient googleapiclient, String s, boolean flag)
        {
            return launchApplication(googleapiclient, s, (new LaunchOptions.Builder()).setRelaunchIfRunning(flag).build());
        }

        public PendingResult leaveApplication(GoogleApiClient googleapiclient)
        {
            return googleapiclient.zzb(new zzjy(this, googleapiclient) {

                final CastApi.zza zzIt;

                protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                    throws RemoteException
                {
                    zza((zzju)zza1);
                }

                protected void zza(zzju zzju1)
                    throws RemoteException
                {
                    try
                    {
                        zzju1.zzd(this);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (zzju zzju1)
                    {
                        zzah(2001);
                    }
                }

            
            {
                zzIt = zza1;
                super(googleapiclient);
            }
            });
        }

        public void removeMessageReceivedCallbacks(GoogleApiClient googleapiclient, String s)
            throws IOException, IllegalArgumentException
        {
            try
            {
                ((zzju)googleapiclient.zza(zzkb.zzGR)).zzaJ(s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (GoogleApiClient googleapiclient)
            {
                throw new IOException("service error");
            }
        }

        public void requestStatus(GoogleApiClient googleapiclient)
            throws IOException, IllegalStateException
        {
            try
            {
                ((zzju)googleapiclient.zza(zzkb.zzGR)).zzhr();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (GoogleApiClient googleapiclient)
            {
                throw new IOException("service error");
            }
        }

        public PendingResult sendMessage(GoogleApiClient googleapiclient, String s, String s1)
        {
            return googleapiclient.zzb(new zzjy(this, googleapiclient, s, s1) {

                final String zzIr;
                final String zzIs;
                final CastApi.zza zzIt;

                protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                    throws RemoteException
                {
                    zza((zzju)zza1);
                }

                protected void zza(zzju zzju1)
                    throws RemoteException
                {
                    try
                    {
                        zzju1.zza(zzIr, zzIs, this);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (zzju zzju1)
                    {
                        zzah(2001);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (zzju zzju1)
                    {
                        zzah(2001);
                    }
                }

            
            {
                zzIt = zza1;
                zzIr = s;
                zzIs = s1;
                super(googleapiclient);
            }
            });
        }

        public void setMessageReceivedCallbacks(GoogleApiClient googleapiclient, String s, MessageReceivedCallback messagereceivedcallback)
            throws IOException, IllegalStateException
        {
            try
            {
                ((zzju)googleapiclient.zza(zzkb.zzGR)).zza(s, messagereceivedcallback);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (GoogleApiClient googleapiclient)
            {
                throw new IOException("service error");
            }
        }

        public void setMute(GoogleApiClient googleapiclient, boolean flag)
            throws IOException, IllegalStateException
        {
            try
            {
                ((zzju)googleapiclient.zza(zzkb.zzGR)).zzL(flag);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (GoogleApiClient googleapiclient)
            {
                throw new IOException("service error");
            }
        }

        public void setVolume(GoogleApiClient googleapiclient, double d)
            throws IOException, IllegalArgumentException, IllegalStateException
        {
            try
            {
                ((zzju)googleapiclient.zza(zzkb.zzGR)).zza(d);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (GoogleApiClient googleapiclient)
            {
                throw new IOException("service error");
            }
        }

        public PendingResult stopApplication(GoogleApiClient googleapiclient)
        {
            return googleapiclient.zzb(new zzjy(this, googleapiclient) {

                final CastApi.zza zzIt;

                protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                    throws RemoteException
                {
                    zza((zzju)zza1);
                }

                protected void zza(zzju zzju1)
                    throws RemoteException
                {
                    try
                    {
                        zzju1.zza("", this);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (zzju zzju1)
                    {
                        zzah(2001);
                    }
                }

            
            {
                zzIt = zza1;
                super(googleapiclient);
            }
            });
        }

        public PendingResult stopApplication(GoogleApiClient googleapiclient, String s)
        {
            return googleapiclient.zzb(new zzjy(this, googleapiclient, s) {

                final CastApi.zza zzIt;
                final String zzIw;

                protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                    throws RemoteException
                {
                    zza((zzju)zza1);
                }

                protected void zza(zzju zzju1)
                    throws RemoteException
                {
                    if (TextUtils.isEmpty(zzIw))
                    {
                        zzd(2001, "IllegalArgument: sessionId cannot be null or empty");
                        return;
                    }
                    try
                    {
                        zzju1.zza(zzIw, this);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (zzju zzju1)
                    {
                        zzah(2001);
                    }
                }

            
            {
                zzIt = zza1;
                zzIw = s;
                super(googleapiclient);
            }
            });
        }

        public CastApi.zza()
        {
        }
    }

    public static final class CastOptions
        implements com.google.android.gms.common.api.Api.ApiOptions.HasOptions
    {

        final CastDevice zzIx;
        final Listener zzIy;
        private final int zzIz;

        public static Builder builder(CastDevice castdevice, Listener listener)
        {
            return new Builder(castdevice, listener);
        }

        static int zza(CastOptions castoptions)
        {
            return castoptions.zzIz;
        }

        private CastOptions(Builder builder1)
        {
            zzIx = builder1.zzIA;
            zzIy = builder1.zzIB;
            zzIz = Builder.zza(builder1);
        }

    }

    public static final class CastOptions.Builder
    {

        CastDevice zzIA;
        Listener zzIB;
        private int zzIC;

        static int zza(CastOptions.Builder builder)
        {
            return builder.zzIC;
        }

        public CastOptions build()
        {
            return new CastOptions(this);
        }

        public CastOptions.Builder setVerboseLoggingEnabled(boolean flag)
        {
            if (flag)
            {
                zzIC = zzIC | 1;
                return this;
            } else
            {
                zzIC = zzIC & -2;
                return this;
            }
        }

        private CastOptions.Builder(CastDevice castdevice, Listener listener)
        {
            zzx.zzb(castdevice, "CastDevice parameter cannot be null");
            zzx.zzb(listener, "CastListener parameter cannot be null");
            zzIA = castdevice;
            zzIB = listener;
            zzIC = 0;
        }

    }

    public static class Listener
    {

        public void onApplicationDisconnected(int i)
        {
        }

        public void onApplicationMetadataChanged(ApplicationMetadata applicationmetadata)
        {
        }

        public void onApplicationStatusChanged()
        {
        }

        public void onVolumeChanged()
        {
        }

        public void zzab(int i)
        {
        }

        public void zzac(int i)
        {
        }

        public Listener()
        {
        }
    }

    public static interface MessageReceivedCallback
    {

        public abstract void onMessageReceived(CastDevice castdevice, String s, String s1);
    }

    private static abstract class zza extends zzjr
    {

        public Result createFailedResult(Status status)
        {
            return zzh(status);
        }

        public ApplicationConnectionResult zzh(Status status)
        {
            return new ApplicationConnectionResult(this, status) {

                final Status zzGT;
                final zza zzID;

                public ApplicationMetadata getApplicationMetadata()
                {
                    return null;
                }

                public String getApplicationStatus()
                {
                    return null;
                }

                public String getSessionId()
                {
                    return null;
                }

                public Status getStatus()
                {
                    return zzGT;
                }

                public boolean getWasLaunched()
                {
                    return false;
                }

            
            {
                zzID = zza1;
                zzGT = status;
                super();
            }
            };
        }

        public zza(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }
    }


    public static final Api API;
    public static final CastApi CastApi = new CastApi.zza();
    public static final String EXTRA_APP_NO_LONGER_RUNNING = "com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING";
    public static final int MAX_MESSAGE_LENGTH = 0x10000;
    public static final int MAX_NAMESPACE_LENGTH = 128;
    private static final com.google.android.gms.common.api.Api.zzb zzGS;

    private Cast()
    {
    }

    static 
    {
        zzGS = new com.google.android.gms.common.api.Api.zzb() {

            public int getPriority()
            {
                return 0x7fffffff;
            }

            public volatile com.google.android.gms.common.api.Api.zza zza(Context context, Looper looper, zzf zzf, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                return zza(context, looper, zzf, (CastOptions)obj, connectioncallbacks, onconnectionfailedlistener);
            }

            public zzju zza(Context context, Looper looper, zzf zzf, CastOptions castoptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                zzx.zzb(castoptions, "Setting the API options is required.");
                return new zzju(context, looper, castoptions.zzIx, CastOptions.zza(castoptions), castoptions.zzIy, connectioncallbacks, onconnectionfailedlistener);
            }

        };
        API = new Api(zzGS, zzkb.zzGR, new Scope[0]);
    }
}
