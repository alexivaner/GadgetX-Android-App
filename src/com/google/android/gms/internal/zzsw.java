// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.panorama.Panorama;
import com.google.android.gms.panorama.PanoramaApi;

// Referenced classes of package com.google.android.gms.internal:
//            zzsv, zzsu, zzsy, zzsx

public class zzsw
    implements PanoramaApi
{
    private static abstract class zza extends zzc
    {

        protected Result createFailedResult(Status status)
        {
            return zzaH(status);
        }

        protected com.google.android.gms.panorama.PanoramaApi.PanoramaResult zzaH(Status status)
        {
            return new zzsy(status, null);
        }

        public zza(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }
    }

    private static final class zzb extends zzsu.zza
    {

        private final com.google.android.gms.common.api.zza.zzb zzHa;

        public void zza(int i, Bundle bundle, int j, Intent intent)
        {
            if (bundle != null)
            {
                bundle = (PendingIntent)bundle.getParcelable("pendingIntent");
            } else
            {
                bundle = null;
            }
            bundle = new Status(i, null, bundle);
            zzHa.zzd(new zzsy(bundle, intent));
        }

        public zzb(com.google.android.gms.common.api.zza.zzb zzb1)
        {
            zzHa = zzb1;
        }
    }

    private static abstract class zzc extends com.google.android.gms.common.api.zza.zza
    {

        protected abstract void zza(Context context, zzsv zzsv1)
            throws RemoteException;

        protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
            throws RemoteException
        {
            zza((zzsx)zza1);
        }

        protected final void zza(zzsx zzsx1)
            throws RemoteException
        {
            zza(zzsx1.getContext(), (zzsv)zzsx1.zzjb());
        }

        protected zzc(GoogleApiClient googleapiclient)
        {
            super(Panorama.zzGR, googleapiclient);
        }
    }


    public zzsw()
    {
    }

    private static void zza(Context context, Uri uri)
    {
        context.revokeUriPermission(uri, 1);
    }

    private static void zza(Context context, zzsv zzsv1, zzsu zzsu, Uri uri, Bundle bundle)
        throws RemoteException
    {
        context.grantUriPermission("com.google.android.gms", uri, 1);
        zzsu = new zzsu.zza(context, uri, zzsu) {

            final Uri zzatx;
            final zzsu zzatz;
            final Context zznK;

            public void zza(int i, Bundle bundle1, int j, Intent intent)
                throws RemoteException
            {
                zzsw.zzb(zznK, zzatx);
                zzatz.zza(i, bundle1, j, intent);
            }

            
            {
                zznK = context;
                zzatx = uri;
                zzatz = zzsu1;
                super();
            }
        };
        try
        {
            zzsv1.zza(zzsu, uri, bundle, true);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzsv zzsv1)
        {
            zza(context, uri);
            throw zzsv1;
        }
        // Misplaced declaration of an exception variable
        catch (zzsv zzsv1)
        {
            zza(context, uri);
        }
        throw zzsv1;
    }

    static void zzb(Context context, Uri uri)
    {
        zza(context, uri);
    }

    static void zzb(Context context, zzsv zzsv1, zzsu zzsu, Uri uri, Bundle bundle)
        throws RemoteException
    {
        zza(context, zzsv1, zzsu, uri, bundle);
    }

    public PendingResult loadPanoramaInfo(GoogleApiClient googleapiclient, Uri uri)
    {
        return googleapiclient.zza(new zza(googleapiclient, uri) {

            final Uri zzatx;
            final zzsw zzaty;

            protected void zza(Context context, zzsv zzsv1)
                throws RemoteException
            {
                zzsv1.zza(new zzb(this), zzatx, null, false);
            }

            
            {
                zzaty = zzsw.this;
                zzatx = uri;
                super(googleapiclient);
            }
        });
    }

    public PendingResult loadPanoramaInfoAndGrantAccess(GoogleApiClient googleapiclient, Uri uri)
    {
        return googleapiclient.zza(new zza(googleapiclient, uri) {

            final Uri zzatx;
            final zzsw zzaty;

            protected void zza(Context context, zzsv zzsv1)
                throws RemoteException
            {
                zzsw.zzb(context, zzsv1, new zzb(this), zzatx, null);
            }

            
            {
                zzaty = zzsw.this;
                zzatx = uri;
                super(googleapiclient);
            }
        });
    }
}
