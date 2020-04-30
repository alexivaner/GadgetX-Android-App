// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.common.api:
//            PendingResult, Api, Scope, zze, 
//            zzh, zzd

public interface GoogleApiClient
{
    public static final class Builder
    {

        private final Context mContext;
        private Account zzFN;
        private Looper zzMc;
        private final Set zzMe;
        private int zzMf;
        private View zzMg;
        private String zzMh;
        private String zzMi;
        private final Map zzMj;
        private final Map zzMk;
        private FragmentActivity zzMl;
        private int zzMm;
        private OnConnectionFailedListener zzMn;
        private Api.zzb zzMo;
        private final Set zzMp;
        private final Set zzMq;
        private com.google.android.gms.internal.zzus.zza zzMr;

        private GoogleApiClient zzhZ()
        {
            zzh zzh1 = zzh.zza(zzMl);
            GoogleApiClient googleapiclient = zzh1.zzar(zzMm);
            Object obj = googleapiclient;
            if (googleapiclient == null)
            {
                obj = new zzd(mContext.getApplicationContext(), zzMc, zzhY(), zzMo, zzMj, zzMk, zzMp, zzMq, zzMm);
            }
            zzh1.zza(zzMm, ((GoogleApiClient) (obj)), zzMn);
            return ((GoogleApiClient) (obj));
        }

        public Builder addApi(Api api)
        {
            zzMj.put(api, null);
            api = api.zzhU();
            int j = api.size();
            for (int i = 0; i < j; i++)
            {
                zzMe.add(((Scope)api.get(i)).zzio());
            }

            return this;
        }

        public Builder addApi(Api api, Api.ApiOptions.HasOptions hasoptions)
        {
            zzx.zzb(hasoptions, "Null options are not permitted for this Api");
            zzMj.put(api, hasoptions);
            api = api.zzhU();
            int j = api.size();
            for (int i = 0; i < j; i++)
            {
                zzMe.add(((Scope)api.get(i)).zzio());
            }

            return this;
        }

        public Builder addConnectionCallbacks(ConnectionCallbacks connectioncallbacks)
        {
            zzMp.add(connectioncallbacks);
            return this;
        }

        public Builder addOnConnectionFailedListener(OnConnectionFailedListener onconnectionfailedlistener)
        {
            zzMq.add(onconnectionfailedlistener);
            return this;
        }

        public Builder addScope(Scope scope)
        {
            zzMe.add(scope.zzio());
            return this;
        }

        public GoogleApiClient build()
        {
            boolean flag;
            if (!zzMj.isEmpty())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "must call addApi() to add at least one API");
            if (zzMm >= 0)
            {
                return zzhZ();
            } else
            {
                return new zzd(mContext, zzMc, zzhY(), zzMo, zzMj, zzMk, zzMp, zzMq, -1);
            }
        }

        public Builder enableAutoManage(FragmentActivity fragmentactivity, int i, OnConnectionFailedListener onconnectionfailedlistener)
        {
            boolean flag;
            if (i >= 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "clientId must be non-negative");
            zzMm = i;
            zzMl = (FragmentActivity)zzx.zzb(fragmentactivity, "Null activity is not permitted.");
            zzMn = onconnectionfailedlistener;
            return this;
        }

        public Builder requestServerAuthCode(String s, ServerAuthCodeCallbacks serverauthcodecallbacks)
        {
            zzMr.zza(s, serverauthcodecallbacks);
            return this;
        }

        public Builder setAccountName(String s)
        {
            if (s == null)
            {
                s = null;
            } else
            {
                s = new Account(s, "com.google");
            }
            zzFN = s;
            return this;
        }

        public Builder setGravityForPopups(int i)
        {
            zzMf = i;
            return this;
        }

        public Builder setHandler(Handler handler)
        {
            zzx.zzb(handler, "Handler must not be null");
            zzMc = handler.getLooper();
            return this;
        }

        public Builder setViewForPopups(View view)
        {
            zzMg = view;
            return this;
        }

        public Builder useDefaultAccount()
        {
            return setAccountName("<<default account>>");
        }

        public zzf zzhY()
        {
            return new zzf(zzFN, zzMe, zzMf, zzMg, zzMh, zzMi, zzMr.zzsy());
        }

        public Builder(Context context)
        {
            zzMe = new HashSet();
            zzMj = new HashMap();
            zzMk = new HashMap();
            zzMm = -1;
            zzMp = new HashSet();
            zzMq = new HashSet();
            zzMr = new com.google.android.gms.internal.zzus.zza();
            mContext = context;
            zzMc = context.getMainLooper();
            zzMh = context.getPackageName();
            zzMi = context.getClass().getName();
            zzMo = zzup.zzGS;
        }

        public Builder(Context context, ConnectionCallbacks connectioncallbacks, OnConnectionFailedListener onconnectionfailedlistener)
        {
            this(context);
            zzx.zzb(connectioncallbacks, "Must provide a connected listener");
            zzMp.add(connectioncallbacks);
            zzx.zzb(onconnectionfailedlistener, "Must provide a connection failed listener");
            zzMq.add(onconnectionfailedlistener);
        }
    }

    public static interface ConnectionCallbacks
    {

        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        public abstract void onConnected(Bundle bundle);

        public abstract void onConnectionSuspended(int i);
    }

    public static interface OnConnectionFailedListener
    {

        public abstract void onConnectionFailed(ConnectionResult connectionresult);
    }

    public static interface ServerAuthCodeCallbacks
    {

        public abstract CheckResult onCheckServerAuthorization(String s, Set set);

        public abstract boolean onUploadServerAuthCode(String s, String s1);
    }

    public static class ServerAuthCodeCallbacks.CheckResult
    {

        private Set zzMe;
        private boolean zzMs;

        public static ServerAuthCodeCallbacks.CheckResult newAuthNotRequiredResult()
        {
            return new ServerAuthCodeCallbacks.CheckResult(false, null);
        }

        public static ServerAuthCodeCallbacks.CheckResult newAuthRequiredResult(Set set)
        {
            boolean flag;
            if (set != null && !set.isEmpty())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "A non-empty scope set is required if further auth is needed.");
            return new ServerAuthCodeCallbacks.CheckResult(true, set);
        }

        public boolean zzic()
        {
            return zzMs;
        }

        public Set zzid()
        {
            return zzMe;
        }

        private ServerAuthCodeCallbacks.CheckResult(boolean flag, Set set)
        {
            zzMs = flag;
            zzMe = set;
        }
    }

    public static interface zza
    {

        public abstract void zzia();

        public abstract void zzib();
    }


    public abstract ConnectionResult blockingConnect();

    public abstract ConnectionResult blockingConnect(long l, TimeUnit timeunit);

    public abstract PendingResult clearDefaultAccountAndReconnect();

    public abstract void connect();

    public abstract void disconnect();

    public abstract void dump(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[]);

    public abstract Context getContext();

    public abstract Looper getLooper();

    public abstract int getSessionId();

    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract boolean isConnectionCallbacksRegistered(ConnectionCallbacks connectioncallbacks);

    public abstract boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener onconnectionfailedlistener);

    public abstract void reconnect();

    public abstract void registerConnectionCallbacks(ConnectionCallbacks connectioncallbacks);

    public abstract void registerConnectionFailedListener(OnConnectionFailedListener onconnectionfailedlistener);

    public abstract void stopAutoManage(FragmentActivity fragmentactivity);

    public abstract void unregisterConnectionCallbacks(ConnectionCallbacks connectioncallbacks);

    public abstract void unregisterConnectionFailedListener(OnConnectionFailedListener onconnectionfailedlistener);

    public abstract Api.zza zza(Api.zzc zzc);

    public abstract zza.zza zza(zza.zza zza1);

    public abstract boolean zza(Api api);

    public abstract boolean zza(Scope scope);

    public abstract zza.zza zzb(zza.zza zza1);

    public abstract boolean zzb(Api api);

    public abstract zze zzf(Object obj);
}
