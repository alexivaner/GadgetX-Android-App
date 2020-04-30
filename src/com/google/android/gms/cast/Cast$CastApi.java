// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.internal.zzju;
import com.google.android.gms.internal.zzjy;
import com.google.android.gms.internal.zzkb;
import java.io.IOException;

// Referenced classes of package com.google.android.gms.cast:
//            Cast, ApplicationMetadata, LaunchOptions

public static interface zza
{
    public static final class zza
        implements Cast.CastApi
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
            return googleapiclient.zzb(new Cast.zza(this, googleapiclient) {

                final zza zzIt;

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
            return googleapiclient.zzb(new Cast.zza(this, googleapiclient, s) {

                final zza zzIt;
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
            return googleapiclient.zzb(new Cast.zza(this, googleapiclient, s, s1) {

                final zza zzIt;
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
            return googleapiclient.zzb(new Cast.zza(this, googleapiclient, s) {

                final zza zzIt;
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
            return googleapiclient.zzb(new Cast.zza(this, googleapiclient, s, launchoptions) {

                final zza zzIt;
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

                final zza zzIt;

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
                final zza zzIt;

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

        public void setMessageReceivedCallbacks(GoogleApiClient googleapiclient, String s, Cast.MessageReceivedCallback messagereceivedcallback)
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

                final zza zzIt;

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

                final zza zzIt;
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

        public zza()
        {
        }
    }


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

    public abstract void setMessageReceivedCallbacks(GoogleApiClient googleapiclient, String s, eceivedCallback eceivedcallback)
        throws IOException, IllegalStateException;

    public abstract void setMute(GoogleApiClient googleapiclient, boolean flag)
        throws IOException, IllegalStateException;

    public abstract void setVolume(GoogleApiClient googleapiclient, double d)
        throws IOException, IllegalArgumentException, IllegalStateException;

    public abstract PendingResult stopApplication(GoogleApiClient googleapiclient);

    public abstract PendingResult stopApplication(GoogleApiClient googleapiclient, String s);
}
