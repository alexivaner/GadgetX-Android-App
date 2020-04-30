// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.Device;

// Referenced classes of package com.google.android.gms.internal:
//            zzmc

public class zznz
{

    private static final ThreadLocal zzZY = new ThreadLocal();

    private static Device zzb(Device device)
    {
        return new Device(zzbM(device.getManufacturer()), zzbM(device.getModel()), zzbM(device.getVersion()), device.getUid(), device.getType());
    }

    public static String zzbM(String s)
    {
        return zzu(s, (String)zzZY.get());
    }

    public static DataSource zzc(DataSource datasource)
    {
        String s = (String)zzZY.get();
        if (zzlM() || s.equals(datasource.getAppPackageName()))
        {
            return datasource;
        } else
        {
            return zzd(datasource);
        }
    }

    private static DataSource zzd(DataSource datasource)
    {
        Device device;
        if (datasource.getDevice() == null)
        {
            device = null;
        } else
        {
            device = zzb(datasource.getDevice());
        }
        return (new com.google.android.gms.fitness.data.DataSource.Builder()).setDataType(datasource.getDataType()).setName(datasource.getName()).setType(datasource.getType()).setDevice(device).zzb(datasource.zzlz()).setStreamName(datasource.getStreamName()).build();
    }

    public static boolean zzlM()
    {
        String s = (String)zzZY.get();
        return s == null || s.startsWith("com.google");
    }

    private static String zzu(String s, String s1)
    {
        if (s == null || s1 == null)
        {
            return s;
        } else
        {
            byte abyte0[] = new byte[s.length() + s1.length()];
            System.arraycopy(s.getBytes(), 0, abyte0, 0, s.length());
            System.arraycopy(s1.getBytes(), 0, abyte0, s.length(), s1.length());
            return Integer.toHexString(zzmc.zza(abyte0, 0, abyte0.length, 0));
        }
    }

}
