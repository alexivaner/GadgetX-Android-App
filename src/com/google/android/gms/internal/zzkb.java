// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;

// Referenced classes of package com.google.android.gms.internal:
//            zzjv

public final class zzkb
{

    public static final com.google.android.gms.common.api.Api.zzc zzGR;
    public static final String zzKO;
    public static final String zzKP;
    public static final Charset zzKQ;

    static 
    {
        Charset charset;
        zzGR = new com.google.android.gms.common.api.Api.zzc();
        zzKO = zzjv.zzaL("com.google.cast.receiver");
        zzKP = zzjv.zzaL("com.google.cast.tp.connection");
        charset = null;
        Charset charset1 = Charset.forName("UTF-8");
        charset = charset1;
_L2:
        zzKQ = charset;
        return;
        Object obj;
        obj;
        continue; /* Loop/switch isn't completed */
        obj;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
