// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.tagmanager.zzbf;
import org.json.JSONException;

// Referenced classes of package com.google.android.gms.internal:
//            zzvh, zzvi, zzvf

static final class g
    implements zzvh
{

    public Object zzn(byte abyte0[])
        throws g
    {
        if (abyte0 == null)
        {
            throw new g("Cannot parse a null byte[]");
        }
        if (abyte0.length == 0)
        {
            throw new g("Cannot parse a 0 length byte[]");
        }
        try
        {
            abyte0 = zzvf.zzdd(new String(abyte0));
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new g("The resource data is corrupted. The container cannot be extracted from the binary data");
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new g("The resource data is invalid. The container cannot be extracted from the binary data");
        }
        if (abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        zzbf.zzab("The container was successfully parsed from the resource");
        return abyte0;
    }

    g()
    {
    }
}
