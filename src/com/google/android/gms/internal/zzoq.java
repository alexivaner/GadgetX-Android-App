// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.identity.intents.UserAddressRequest;

// Referenced classes of package com.google.android.gms.internal:
//            zzos

public class zzoq extends zzk
{
    public static final class zza extends zzor.zza
    {

        private final int zzPu;
        private Activity zzoi;

        private void setActivity(Activity activity)
        {
            zzoi = activity;
        }

        static void zza(zza zza1, Activity activity)
        {
            zza1.setActivity(activity);
        }

        public void zzi(int i, Bundle bundle)
        {
            if (i != 1) goto _L2; else goto _L1
_L1:
            Intent intent = new Intent();
            intent.putExtras(bundle);
            bundle = zzoi.createPendingResult(zzPu, intent, 0x40000000);
            if (bundle != null) goto _L4; else goto _L3
_L3:
            return;
_L4:
            try
            {
                bundle.send(1);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                Log.w("AddressClientImpl", "Exception settng pending result", bundle);
            }
            return;
_L2:
            PendingIntent pendingintent = null;
            if (bundle != null)
            {
                pendingintent = (PendingIntent)bundle.getParcelable("com.google.android.gms.identity.intents.EXTRA_PENDING_INTENT");
            }
            bundle = new ConnectionResult(i, pendingintent);
            if (bundle.hasResolution())
            {
                try
                {
                    bundle.startResolutionForResult(zzoi, zzPu);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Bundle bundle)
                {
                    Log.w("AddressClientImpl", "Exception starting pending intent", bundle);
                }
                return;
            }
            bundle = zzoi.createPendingResult(zzPu, new Intent(), 0x40000000);
            if (bundle != null)
            {
                try
                {
                    bundle.send(1);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Bundle bundle)
                {
                    Log.w("AddressClientImpl", "Exception setting pending result", bundle);
                }
                return;
            }
            if (true) goto _L3; else goto _L5
_L5:
        }

        public zza(int i, Activity activity)
        {
            zzPu = i;
            zzoi = activity;
        }
    }


    private final int mTheme;
    private final String zzHg;
    private zza zzalt;
    private Activity zzoi;

    public zzoq(Activity activity, Looper looper, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, String s, int i)
    {
        super(activity, looper, 12, connectioncallbacks, onconnectionfailedlistener);
        zzHg = s;
        zzoi = activity;
        mTheme = i;
    }

    public void disconnect()
    {
        super.disconnect();
        if (zzalt != null)
        {
            zza.zza(zzalt, null);
            zzalt = null;
        }
    }

    public void zza(UserAddressRequest useraddressrequest, int i)
    {
        zzpn();
        zzalt = new zza(i, zzoi);
        try
        {
            Bundle bundle = new Bundle();
            bundle.putString("com.google.android.gms.identity.intents.EXTRA_CALLING_PACKAGE_NAME", getContext().getPackageName());
            if (!TextUtils.isEmpty(zzHg))
            {
                bundle.putParcelable("com.google.android.gms.identity.intents.EXTRA_ACCOUNT", new Account(zzHg, "com.google"));
            }
            bundle.putInt("com.google.android.gms.identity.intents.EXTRA_THEME", mTheme);
            zzpm().zza(zzalt, useraddressrequest, bundle);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (UserAddressRequest useraddressrequest)
        {
            Log.e("AddressClientImpl", "Exception requesting user address", useraddressrequest);
        }
        useraddressrequest = new Bundle();
        useraddressrequest.putInt("com.google.android.gms.identity.intents.EXTRA_ERROR_CODE", 555);
        zzalt.zzi(1, useraddressrequest);
    }

    protected zzos zzbd(IBinder ibinder)
    {
        return zzos.zza.zzbf(ibinder);
    }

    protected String zzcF()
    {
        return "com.google.android.gms.identity.service.BIND";
    }

    protected String zzcG()
    {
        return "com.google.android.gms.identity.intents.internal.IAddressService";
    }

    protected IInterface zzp(IBinder ibinder)
    {
        return zzbd(ibinder);
    }

    protected zzos zzpm()
        throws DeadObjectException
    {
        return (zzos)super.zzjb();
    }

    protected void zzpn()
    {
        super.zzfc();
    }
}
