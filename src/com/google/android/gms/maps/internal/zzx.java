// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.maps.model.RuntimeRemoteException;

// Referenced classes of package com.google.android.gms.maps.internal:
//            zzc

public class zzx
{

    private static Context zzaqM;
    private static zzc zzaqN;

    public zzx()
    {
    }

    private static Context getRemoteContext(Context context)
    {
        if (zzaqM == null)
        {
            if (zzqC())
            {
                zzaqM = context.getApplicationContext();
            } else
            {
                zzaqM = GooglePlayServicesUtil.getRemoteContext(context);
            }
        }
        return zzaqM;
    }

    private static Object zza(ClassLoader classloader, String s)
    {
        try
        {
            classloader = ((ClassLoader) (zzc(((ClassLoader)com.google.android.gms.common.internal.zzx.zzl(classloader)).loadClass(s))));
        }
        // Misplaced declaration of an exception variable
        catch (ClassLoader classloader)
        {
            throw new IllegalStateException((new StringBuilder()).append("Unable to find dynamic class ").append(s).toString());
        }
        return classloader;
    }

    public static zzc zzac(Context context)
        throws GooglePlayServicesNotAvailableException
    {
        com.google.android.gms.common.internal.zzx.zzl(context);
        if (zzaqN != null)
        {
            return zzaqN;
        }
        zzad(context);
        zzaqN = zzae(context);
        try
        {
            zzaqN.zzb(zze.zzn(getRemoteContext(context).getResources()), 0x6c42d8);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new RuntimeRemoteException(context);
        }
        return zzaqN;
    }

    private static void zzad(Context context)
        throws GooglePlayServicesNotAvailableException
    {
        int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        switch (i)
        {
        default:
            throw new GooglePlayServicesNotAvailableException(i);

        case 0: // '\0'
            return;
        }
    }

    private static zzc zzae(Context context)
    {
        if (zzqC())
        {
            Log.i(com/google/android/gms/maps/internal/zzx.getSimpleName(), "Making Creator statically");
            return (zzc)zzc(zzqD());
        } else
        {
            Log.i(com/google/android/gms/maps/internal/zzx.getSimpleName(), "Making Creator dynamically");
            return com.google.android.gms.maps.internal.zzc.zza.zzbt((IBinder)zza(getRemoteContext(context).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
        }
    }

    private static Object zzc(Class class1)
    {
        Object obj;
        try
        {
            obj = class1.newInstance();
        }
        catch (InstantiationException instantiationexception)
        {
            throw new IllegalStateException((new StringBuilder()).append("Unable to instantiate the dynamic class ").append(class1.getName()).toString());
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new IllegalStateException((new StringBuilder()).append("Unable to call the default constructor of ").append(class1.getName()).toString());
        }
        return obj;
    }

    public static boolean zzqC()
    {
        return false;
    }

    private static Class zzqD()
    {
        Class class1;
        try
        {
            if (android.os.Build.VERSION.SDK_INT < 15)
            {
                return Class.forName("com.google.android.gms.maps.internal.CreatorImplGmm6");
            }
            class1 = Class.forName("com.google.android.gms.maps.internal.CreatorImpl");
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            throw new RuntimeException(classnotfoundexception);
        }
        return class1;
    }
}
