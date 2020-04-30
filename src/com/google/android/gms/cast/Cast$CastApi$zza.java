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

public static final class ient
    implements ient
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
        return googleapiclient.zzb(new Cast.zza(googleapiclient) {

            final Cast.CastApi.zza zzIt;

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
                zzIt = Cast.CastApi.zza.this;
                super(googleapiclient);
            }
        });
    }

    public PendingResult joinApplication(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.zzb(new Cast.zza(googleapiclient, s) {

            final Cast.CastApi.zza zzIt;
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
                zzIt = Cast.CastApi.zza.this;
                zzIu = s;
                super(googleapiclient);
            }
        });
    }

    public PendingResult joinApplication(GoogleApiClient googleapiclient, String s, String s1)
    {
        return googleapiclient.zzb(new Cast.zza(googleapiclient, s, s1) {

            final Cast.CastApi.zza zzIt;
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
                zzIt = Cast.CastApi.zza.this;
                zzIu = s;
                zzIw = s1;
                super(googleapiclient);
            }
        });
    }

    public PendingResult launchApplication(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.zzb(new Cast.zza(googleapiclient, s) {

            final Cast.CastApi.zza zzIt;
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
                zzIt = Cast.CastApi.zza.this;
                zzIu = s;
                super(googleapiclient);
            }
        });
    }

    public PendingResult launchApplication(GoogleApiClient googleapiclient, String s, LaunchOptions launchoptions)
    {
        return googleapiclient.zzb(new Cast.zza(googleapiclient, s, launchoptions) {

            final Cast.CastApi.zza zzIt;
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
                zzIt = Cast.CastApi.zza.this;
                zzIu = s;
                zzIv = launchoptions;
                super(googleapiclient);
            }
        });
    }

    public PendingResult launchApplication(GoogleApiClient googleapiclient, String s, boolean flag)
    {
        return launchApplication(googleapiclient, s, (new lder()).setRelaunchIfRunning(flag).build());
    }

    public PendingResult leaveApplication(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zzb(new zzjy(googleapiclient) {

            final Cast.CastApi.zza zzIt;

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
                zzIt = Cast.CastApi.zza.this;
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
        return googleapiclient.zzb(new zzjy(googleapiclient, s, s1) {

            final String zzIr;
            final String zzIs;
            final Cast.CastApi.zza zzIt;

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
                zzIt = Cast.CastApi.zza.this;
                zzIr = s;
                zzIs = s1;
                super(googleapiclient);
            }
        });
    }

    public void setMessageReceivedCallbacks(GoogleApiClient googleapiclient, String s, vedCallback vedcallback)
        throws IOException, IllegalStateException
    {
        try
        {
            ((zzju)googleapiclient.zza(zzkb.zzGR)).zza(s, vedcallback);
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
        return googleapiclient.zzb(new zzjy(googleapiclient) {

            final Cast.CastApi.zza zzIt;

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
                zzIt = Cast.CastApi.zza.this;
                super(googleapiclient);
            }
        });
    }

    public PendingResult stopApplication(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.zzb(new zzjy(googleapiclient, s) {

            final Cast.CastApi.zza zzIt;
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
                zzIt = Cast.CastApi.zza.this;
                zzIw = s;
                super(googleapiclient);
            }
        });
    }

    public ient()
    {
    }
}
