// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.SessionsApi;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.zzai;
import com.google.android.gms.fitness.request.zzak;
import com.google.android.gms.fitness.request.zzam;
import com.google.android.gms.fitness.request.zzao;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.internal:
//            zznf, zzoh, zznp

public class zzog
    implements SessionsApi
{
    private static class zza extends zznt.zza
    {

        private final com.google.android.gms.common.api.zza.zzb zzHa;

        public void zza(SessionReadResult sessionreadresult)
            throws RemoteException
        {
            zzHa.zzd(sessionreadresult);
        }

        private zza(com.google.android.gms.common.api.zza.zzb zzb1)
        {
            zzHa = zzb1;
        }

    }

    private static class zzb extends zznu.zza
    {

        private final com.google.android.gms.common.api.zza.zzb zzHa;

        public void zza(SessionStopResult sessionstopresult)
        {
            zzHa.zzd(sessionstopresult);
        }

        private zzb(com.google.android.gms.common.api.zza.zzb zzb1)
        {
            zzHa = zzb1;
        }

    }


    public zzog()
    {
    }

    private PendingResult zza(final GoogleApiClient final_googleapiclient, String s, String s1)
    {
        return final_googleapiclient.zzb(new zznf.zza(s, s1) {

            final String val$name;
            final zzog zzaaD;
            final String zzaaE;

            protected Result createFailedResult(Status status)
            {
                return zzz(status);
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zznf)zza1);
            }

            protected void zza(zznf zznf1)
                throws RemoteException
            {
                zzb zzb1 = new zzb(this);
                String s2 = zznf1.getContext().getPackageName();
                ((zznp)zznf1.zzjb()).zza(new zzam(name, zzaaE, zzb1, s2));
            }

            protected SessionStopResult zzz(Status status)
            {
                return SessionStopResult.zzG(status);
            }

            
            {
                zzaaD = zzog.this;
                name = s;
                zzaaE = s1;
                super(final_googleapiclient);
            }
        });
    }

    public PendingResult insertSession(GoogleApiClient googleapiclient, SessionInsertRequest sessioninsertrequest)
    {
        return googleapiclient.zza(new zznf.zzc(googleapiclient, sessioninsertrequest) {

            final zzog zzaaD;
            final SessionInsertRequest zzaaF;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zznf)zza1);
            }

            protected void zza(zznf zznf1)
                throws RemoteException
            {
                zzoh zzoh1 = new zzoh(this);
                String s = zznf1.getContext().getPackageName();
                ((zznp)zznf1.zzjb()).zza(new SessionInsertRequest(zzaaF, zzoh1, s));
            }

            
            {
                zzaaD = zzog.this;
                zzaaF = sessioninsertrequest;
                super(googleapiclient);
            }
        });
    }

    public PendingResult readSession(GoogleApiClient googleapiclient, SessionReadRequest sessionreadrequest)
    {
        return googleapiclient.zza(new zznf.zza(googleapiclient, sessionreadrequest) {

            final zzog zzaaD;
            final SessionReadRequest zzaaG;

            protected Result createFailedResult(Status status)
            {
                return zzA(status);
            }

            protected SessionReadResult zzA(Status status)
            {
                return SessionReadResult.zzF(status);
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zznf)zza1);
            }

            protected void zza(zznf zznf1)
                throws RemoteException
            {
                zza zza1 = new zza(this);
                String s = zznf1.getContext().getPackageName();
                ((zznp)zznf1.zzjb()).zza(new SessionReadRequest(zzaaG, zza1, s));
            }

            
            {
                zzaaD = zzog.this;
                zzaaG = sessionreadrequest;
                super(googleapiclient);
            }
        });
    }

    public PendingResult registerForSessions(GoogleApiClient googleapiclient, PendingIntent pendingintent)
    {
        return googleapiclient.zzb(new zznf.zzc(googleapiclient, pendingintent) {

            final zzog zzaaD;
            final PendingIntent zzaaw;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zznf)zza1);
            }

            protected void zza(zznf zznf1)
                throws RemoteException
            {
                zzoh zzoh1 = new zzoh(this);
                String s = zznf1.getContext().getPackageName();
                ((zznp)zznf1.zzjb()).zza(new zzai(zzaaw, zzoh1, s));
            }

            
            {
                zzaaD = zzog.this;
                zzaaw = pendingintent;
                super(googleapiclient);
            }
        });
    }

    public PendingResult startSession(GoogleApiClient googleapiclient, Session session)
    {
        zzx.zzb(session, "Session cannot be null");
        boolean flag;
        if (session.getEndTime(TimeUnit.MILLISECONDS) == 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Cannot start a session which has already ended");
        return googleapiclient.zzb(new zznf.zzc(googleapiclient, session) {

            final Session zzaaC;
            final zzog zzaaD;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zznf)zza1);
            }

            protected void zza(zznf zznf1)
                throws RemoteException
            {
                zzoh zzoh1 = new zzoh(this);
                String s = zznf1.getContext().getPackageName();
                ((zznp)zznf1.zzjb()).zza(new zzak(zzaaC, zzoh1, s));
            }

            
            {
                zzaaD = zzog.this;
                zzaaC = session;
                super(googleapiclient);
            }
        });
    }

    public PendingResult stopSession(GoogleApiClient googleapiclient, String s)
    {
        return zza(googleapiclient, null, s);
    }

    public PendingResult unregisterForSessions(GoogleApiClient googleapiclient, PendingIntent pendingintent)
    {
        return googleapiclient.zzb(new zznf.zzc(googleapiclient, pendingintent) {

            final zzog zzaaD;
            final PendingIntent zzaaw;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zznf)zza1);
            }

            protected void zza(zznf zznf1)
                throws RemoteException
            {
                zzoh zzoh1 = new zzoh(this);
                String s = zznf1.getContext().getPackageName();
                ((zznp)zznf1.zzjb()).zza(new zzao(zzaaw, zzoh1, s));
            }

            
            {
                zzaaD = zzog.this;
                zzaaw = pendingintent;
                super(googleapiclient);
            }
        });
    }
}
