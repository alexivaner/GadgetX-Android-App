// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.cast:
//            Cast, CastDevice

public static final class Builder
    implements com.google.android.gms.common.api.sOptions
{
    public static final class Builder
    {

        CastDevice zzIA;
        Cast.Listener zzIB;
        private int zzIC;

        static int zza(Builder builder1)
        {
            return builder1.zzIC;
        }

        public Cast.CastOptions build()
        {
            return new Cast.CastOptions(this, null);
        }

        public Builder setVerboseLoggingEnabled(boolean flag)
        {
            if (flag)
            {
                zzIC = zzIC | 1;
                return this;
            } else
            {
                zzIC = zzIC & -2;
                return this;
            }
        }

        private Builder(CastDevice castdevice, Cast.Listener listener)
        {
            zzx.zzb(castdevice, "CastDevice parameter cannot be null");
            zzx.zzb(listener, "CastListener parameter cannot be null");
            zzIA = castdevice;
            zzIB = listener;
            zzIC = 0;
        }

        Builder(CastDevice castdevice, Cast.Listener listener, Cast._cls1 _pcls1)
        {
            this(castdevice, listener);
        }
    }


    final CastDevice zzIx;
    final zzIz zzIy;
    private final int zzIz;

    public static Builder builder(CastDevice castdevice, Builder.zzIC zzic)
    {
        return new Builder(castdevice, zzic, null);
    }

    static int zza(Builder builder1)
    {
        return builder1.zzIz;
    }

    private Builder(Builder builder1)
    {
        zzIx = builder1.zzIA;
        zzIy = builder1.zzIB;
        zzIz = Builder.zza(builder1);
    }

    Builder(Builder builder1, Builder builder2)
    {
        this(builder1);
    }
}
