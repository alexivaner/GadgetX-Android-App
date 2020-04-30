// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzvl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzbf, zzco, zzde, zzbv, 
//            zzca, zzbn, DataLayer, zzag

public class Container
{
    public static interface FunctionCallMacroCallback
    {

        public abstract Object getValue(String s, Map map);
    }

    public static interface FunctionCallTagCallback
    {

        public abstract void execute(String s, Map map);
    }

    private class zza
        implements zzs.zza
    {

        final Container zzaxD;

        public Object zzc(String s, Map map)
        {
            FunctionCallMacroCallback functioncallmacrocallback = zzaxD.zzcM(s);
            if (functioncallmacrocallback == null)
            {
                return null;
            } else
            {
                return functioncallmacrocallback.getValue(s, map);
            }
        }

        private zza()
        {
            zzaxD = Container.this;
            super();
        }

    }

    private class zzb
        implements zzs.zza
    {

        final Container zzaxD;

        public Object zzc(String s, Map map)
        {
            FunctionCallTagCallback functioncalltagcallback = zzaxD.zzcN(s);
            if (functioncalltagcallback != null)
            {
                functioncalltagcallback.execute(s, map);
            }
            return zzde.zzue();
        }

        private zzb()
        {
            zzaxD = Container.this;
            super();
        }

    }


    private final Context mContext;
    private Map zzaxA;
    private volatile long zzaxB;
    private volatile String zzaxC;
    private final String zzaxw;
    private final DataLayer zzaxx;
    private zzco zzaxy;
    private Map zzaxz;

    Container(Context context, DataLayer datalayer, String s, long l, com.google.android.gms.internal.zzc.zzj zzj)
    {
        zzaxz = new HashMap();
        zzaxA = new HashMap();
        zzaxC = "";
        mContext = context;
        zzaxx = datalayer;
        zzaxw = s;
        zzaxB = l;
        zza(zzj.zzgs);
        if (zzj.zzgr != null)
        {
            zza(zzj.zzgr);
        }
    }

    Container(Context context, DataLayer datalayer, String s, long l, com.google.android.gms.internal.zzvl.zzc zzc)
    {
        zzaxz = new HashMap();
        zzaxA = new HashMap();
        zzaxC = "";
        mContext = context;
        zzaxx = datalayer;
        zzaxw = s;
        zzaxB = l;
        zza(zzc);
    }

    private void zza(com.google.android.gms.internal.zzc.zzf zzf)
    {
        if (zzf == null)
        {
            throw new NullPointerException();
        }
        com.google.android.gms.internal.zzvl.zzc zzc;
        try
        {
            zzc = zzvl.zzb(zzf);
        }
        catch (com.google.android.gms.internal.zzvl.zzg zzg)
        {
            zzbf.zzZ((new StringBuilder()).append("Not loading resource: ").append(zzf).append(" because it is invalid: ").append(zzg.toString()).toString());
            return;
        }
        zza(zzc);
    }

    private void zza(com.google.android.gms.internal.zzvl.zzc zzc)
    {
        zzaxC = zzc.getVersion();
        zzag zzag = zzcP(zzaxC);
        zza(new zzco(mContext, zzc, zzaxx, new zza(), new zzb(), zzag));
    }

    private void zza(zzco zzco1)
    {
        this;
        JVM INSTR monitorenter ;
        zzaxy = zzco1;
        this;
        JVM INSTR monitorexit ;
        return;
        zzco1;
        throw zzco1;
    }

    private void zza(com.google.android.gms.internal.zzc.zzi azzi[])
    {
        ArrayList arraylist = new ArrayList();
        int j = azzi.length;
        for (int i = 0; i < j; i++)
        {
            arraylist.add(azzi[i]);
        }

        zzsJ().zzu(arraylist);
    }

    private zzco zzsJ()
    {
        this;
        JVM INSTR monitorenter ;
        zzco zzco1 = zzaxy;
        this;
        JVM INSTR monitorexit ;
        return zzco1;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean getBoolean(String s)
    {
        zzco zzco1 = zzsJ();
        if (zzco1 == null)
        {
            zzbf.zzZ("getBoolean called for closed container.");
            return zzde.zzuc().booleanValue();
        }
        boolean flag;
        try
        {
            flag = zzde.zzk((com.google.android.gms.internal.zzd.zza)zzco1.zzdi(s).getObject()).booleanValue();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            zzbf.zzZ((new StringBuilder()).append("Calling getBoolean() threw an exception: ").append(s.getMessage()).append(" Returning default value.").toString());
            return zzde.zzuc().booleanValue();
        }
        return flag;
    }

    public String getContainerId()
    {
        return zzaxw;
    }

    public double getDouble(String s)
    {
        zzco zzco1 = zzsJ();
        if (zzco1 == null)
        {
            zzbf.zzZ("getDouble called for closed container.");
            return zzde.zzub().doubleValue();
        }
        double d;
        try
        {
            d = zzde.zzj((com.google.android.gms.internal.zzd.zza)zzco1.zzdi(s).getObject()).doubleValue();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            zzbf.zzZ((new StringBuilder()).append("Calling getDouble() threw an exception: ").append(s.getMessage()).append(" Returning default value.").toString());
            return zzde.zzub().doubleValue();
        }
        return d;
    }

    public long getLastRefreshTime()
    {
        return zzaxB;
    }

    public long getLong(String s)
    {
        zzco zzco1 = zzsJ();
        if (zzco1 == null)
        {
            zzbf.zzZ("getLong called for closed container.");
            return zzde.zzua().longValue();
        }
        long l;
        try
        {
            l = zzde.zzi((com.google.android.gms.internal.zzd.zza)zzco1.zzdi(s).getObject()).longValue();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            zzbf.zzZ((new StringBuilder()).append("Calling getLong() threw an exception: ").append(s.getMessage()).append(" Returning default value.").toString());
            return zzde.zzua().longValue();
        }
        return l;
    }

    public String getString(String s)
    {
        zzco zzco1 = zzsJ();
        if (zzco1 == null)
        {
            zzbf.zzZ("getString called for closed container.");
            return zzde.zzue();
        }
        try
        {
            s = zzde.zzg((com.google.android.gms.internal.zzd.zza)zzco1.zzdi(s).getObject());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            zzbf.zzZ((new StringBuilder()).append("Calling getString() threw an exception: ").append(s.getMessage()).append(" Returning default value.").toString());
            return zzde.zzue();
        }
        return s;
    }

    public boolean isDefault()
    {
        return getLastRefreshTime() == 0L;
    }

    public void registerFunctionCallMacroCallback(String s, FunctionCallMacroCallback functioncallmacrocallback)
    {
        if (functioncallmacrocallback == null)
        {
            throw new NullPointerException("Macro handler must be non-null");
        }
        synchronized (zzaxz)
        {
            zzaxz.put(s, functioncallmacrocallback);
        }
        return;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void registerFunctionCallTagCallback(String s, FunctionCallTagCallback functioncalltagcallback)
    {
        if (functioncalltagcallback == null)
        {
            throw new NullPointerException("Tag callback must be non-null");
        }
        synchronized (zzaxA)
        {
            zzaxA.put(s, functioncalltagcallback);
        }
        return;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    void release()
    {
        zzaxy = null;
    }

    public void unregisterFunctionCallMacroCallback(String s)
    {
        synchronized (zzaxz)
        {
            zzaxz.remove(s);
        }
        return;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void unregisterFunctionCallTagCallback(String s)
    {
        synchronized (zzaxA)
        {
            zzaxA.remove(s);
        }
        return;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    FunctionCallMacroCallback zzcM(String s)
    {
        synchronized (zzaxz)
        {
            s = (FunctionCallMacroCallback)zzaxz.get(s);
        }
        return s;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    FunctionCallTagCallback zzcN(String s)
    {
        synchronized (zzaxA)
        {
            s = (FunctionCallTagCallback)zzaxA.get(s);
        }
        return s;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    void zzcO(String s)
    {
        zzsJ().zzcO(s);
    }

    zzag zzcP(String s)
    {
        if (!zzca.zztx().zzty().equals(zzca.zza.zzazD));
        return new zzbn();
    }

    String zzsI()
    {
        return zzaxC;
    }
}
