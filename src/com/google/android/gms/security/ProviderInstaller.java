// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;
import java.lang.reflect.Method;

public class ProviderInstaller
{
    public static interface ProviderInstallListener
    {

        public abstract void onProviderInstallFailed(int i, Intent intent);

        public abstract void onProviderInstalled();
    }


    public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
    private static Method zzawM = null;
    private static final Object zzmz = new Object();

    public ProviderInstaller()
    {
    }

    public static void installIfNeeded(Context context)
        throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
    {
        Context context1;
        zzx.zzb(context, "Context must not be null");
        GooglePlayServicesUtil.zzI(context);
        context1 = GooglePlayServicesUtil.getRemoteContext(context);
        if (context1 == null)
        {
            Log.e("ProviderInstaller", "Failed to get remote context");
            throw new GooglePlayServicesNotAvailableException(8);
        }
        if (true) goto _L2; else goto _L1
_L1:
        context;
        JVM INSTR monitorenter ;
_L2:
        synchronized (zzmz)
        {
            if (zzawM == null)
            {
                zzai(context1);
            }
            zzawM.invoke(null, new Object[] {
                context1
            });
        }
        return;
        Exception exception;
        exception;
        Log.e("ProviderInstaller", (new StringBuilder()).append("Failed to install provider: ").append(exception.getMessage()).toString());
        throw new GooglePlayServicesNotAvailableException(8);
        exception1;
        context;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    public static void installIfNeededAsync(Context context, ProviderInstallListener providerinstalllistener)
    {
        zzx.zzb(context, "Context must not be null");
        zzx.zzb(providerinstalllistener, "Listener must not be null");
        zzx.zzbd("Must be called on the UI thread");
        (new AsyncTask(context, providerinstalllistener) {

            final ProviderInstallListener zzawN;
            final Context zznK;

            protected Object doInBackground(Object aobj[])
            {
                return zzb((Void[])aobj);
            }

            protected void onPostExecute(Object obj)
            {
                zze((Integer)obj);
            }

            protected transient Integer zzb(Void avoid[])
            {
                try
                {
                    ProviderInstaller.installIfNeeded(zznK);
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    return Integer.valueOf(avoid.getConnectionStatusCode());
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    return Integer.valueOf(((GooglePlayServicesNotAvailableException) (avoid)).errorCode);
                }
                return Integer.valueOf(0);
            }

            protected void zze(Integer integer)
            {
                if (integer.intValue() == 0)
                {
                    zzawN.onProviderInstalled();
                    return;
                } else
                {
                    Intent intent = GooglePlayServicesUtil.zzan(integer.intValue());
                    zzawN.onProviderInstallFailed(integer.intValue(), intent);
                    return;
                }
            }

            
            {
                zznK = context;
                zzawN = providerinstalllistener;
                super();
            }
        }).execute(new Void[0]);
    }

    private static void zzai(Context context)
        throws ClassNotFoundException, NoSuchMethodException
    {
        zzawM = context.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", new Class[] {
            android/content/Context
        });
    }

}
