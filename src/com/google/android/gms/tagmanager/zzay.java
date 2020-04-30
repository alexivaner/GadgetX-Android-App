// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzb;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzm, zzde

class zzay
{

    public static com.google.android.gms.internal.zzvl.zzc zzdd(String s)
        throws JSONException
    {
        s = zzq(new JSONObject(s));
        com.google.android.gms.internal.zzvl.zzd zzd = com.google.android.gms.internal.zzvl.zzc.zzux();
        for (int i = 0; i < ((com.google.android.gms.internal.zzd.zza) (s)).zzgx.length; i++)
        {
            zzd.zzc(com.google.android.gms.internal.zzvl.zza.zzuu().zzb(zzb.zzdf.toString(), ((com.google.android.gms.internal.zzd.zza) (s)).zzgx[i]).zzb(zzb.zzcU.toString(), zzde.zzdo(zzm.zzsG())).zzb(zzm.zzsH(), ((com.google.android.gms.internal.zzd.zza) (s)).zzgy[i]).zzuw());
        }

        return zzd.zzuA();
    }

    private static com.google.android.gms.internal.zzd.zza zzq(Object obj)
        throws JSONException
    {
        return zzde.zzx(zzr(obj));
    }

    static Object zzr(Object obj)
        throws JSONException
    {
        if (obj instanceof JSONArray)
        {
            throw new RuntimeException("JSONArrays are not supported");
        }
        if (JSONObject.NULL.equals(obj))
        {
            throw new RuntimeException("JSON nulls are not supported");
        }
        Object obj1 = obj;
        if (obj instanceof JSONObject)
        {
            obj = (JSONObject)obj;
            obj1 = new HashMap();
            String s;
            for (Iterator iterator = ((JSONObject) (obj)).keys(); iterator.hasNext(); ((Map) (obj1)).put(s, zzr(((JSONObject) (obj)).get(s))))
            {
                s = (String)iterator.next();
            }

        }
        return obj1;
    }
}
