// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzjv;
import java.util.Locale;

// Referenced classes of package com.google.android.gms.cast:
//            zzc

public class LaunchOptions
    implements SafeParcelable
{
    public static final class Builder
    {

        private LaunchOptions zzIP;

        public LaunchOptions build()
        {
            return zzIP;
        }

        public Builder setLocale(Locale locale)
        {
            zzIP.setLanguage(zzjv.zzb(locale));
            return this;
        }

        public Builder setRelaunchIfRunning(boolean flag)
        {
            zzIP.setRelaunchIfRunning(flag);
            return this;
        }

        public Builder()
        {
            zzIP = new LaunchOptions();
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new zzc();
    private final int zzFG;
    private boolean zzIN;
    private String zzIO;

    public LaunchOptions()
    {
        this(1, false, zzjv.zzb(Locale.getDefault()));
    }

    LaunchOptions(int i, boolean flag, String s)
    {
        zzFG = i;
        zzIN = flag;
        zzIO = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof LaunchOptions))
            {
                return false;
            }
            obj = (LaunchOptions)obj;
            if (zzIN != ((LaunchOptions) (obj)).zzIN || !zzjv.zza(zzIO, ((LaunchOptions) (obj)).zzIO))
            {
                return false;
            }
        }
        return true;
    }

    public String getLanguage()
    {
        return zzIO;
    }

    public boolean getRelaunchIfRunning()
    {
        return zzIN;
    }

    int getVersionCode()
    {
        return zzFG;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Boolean.valueOf(zzIN), zzIO
        });
    }

    public void setLanguage(String s)
    {
        zzIO = s;
    }

    public void setRelaunchIfRunning(boolean flag)
    {
        zzIN = flag;
    }

    public String toString()
    {
        return String.format("LaunchOptions(relaunchIfRunning=%b, language=%s)", new Object[] {
            Boolean.valueOf(zzIN), zzIO
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzc.zza(this, parcel, i);
    }

}
