// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.Locale;

public final class zzjv
{

    public static boolean zza(Object obj, Object obj1)
    {
        return obj == null && obj1 == null || obj != null && obj1 != null && obj.equals(obj1);
    }

    public static void zzaK(String s)
        throws IllegalArgumentException
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("Namespace cannot be null or empty");
        }
        if (s.length() > 128)
        {
            throw new IllegalArgumentException("Invalid namespace length");
        }
        if (!s.startsWith("urn:x-cast:"))
        {
            throw new IllegalArgumentException("Namespace must begin with the prefix \"urn:x-cast:\"");
        }
        if (s.length() == "urn:x-cast:".length())
        {
            throw new IllegalArgumentException("Namespace must begin with the prefix \"urn:x-cast:\" and have non-empty suffix");
        } else
        {
            return;
        }
    }

    public static String zzaL(String s)
    {
        return (new StringBuilder()).append("urn:x-cast:").append(s).toString();
    }

    public static long zzb(double d)
    {
        return (long)(1000D * d);
    }

    public static String zzb(Locale locale)
    {
        StringBuilder stringbuilder = new StringBuilder(20);
        stringbuilder.append(locale.getLanguage());
        String s = locale.getCountry();
        if (!TextUtils.isEmpty(s))
        {
            stringbuilder.append('-').append(s);
        }
        locale = locale.getVariant();
        if (!TextUtils.isEmpty(locale))
        {
            stringbuilder.append('-').append(locale);
        }
        return stringbuilder.toString();
    }

    public static double zzp(long l)
    {
        return (double)l / 1000D;
    }
}
