// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.reflect.Field;

public abstract class zzh
    implements SafeParcelable
{

    private static final Object zzPv = new Object();
    private static ClassLoader zzPw = null;
    private static Integer zzPx = null;
    private boolean zzPy;

    public zzh()
    {
        zzPy = false;
    }

    private static boolean zza(Class class1)
    {
        boolean flag;
        try
        {
            flag = "SAFE_PARCELABLE_NULL_STRING".equals(class1.getField("NULL").get(null));
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            return false;
        }
        return flag;
    }

    protected static boolean zzbf(String s)
    {
        ClassLoader classloader = zziW();
        if (classloader == null)
        {
            return true;
        }
        boolean flag;
        try
        {
            flag = zza(classloader.loadClass(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        return flag;
    }

    protected static ClassLoader zziW()
    {
        ClassLoader classloader;
        synchronized (zzPv)
        {
            classloader = zzPw;
        }
        return classloader;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected static Integer zziX()
    {
        Integer integer;
        synchronized (zzPv)
        {
            integer = zzPx;
        }
        return integer;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected boolean zziY()
    {
        return zzPy;
    }

}
