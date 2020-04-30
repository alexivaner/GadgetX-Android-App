// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.internal.zzvl;
import com.google.android.gms.internal.zzwx;
import com.google.android.gms.internal.zzwy;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzay, zzbf, zzbe, zzca

class zzcm
    implements zzo.zzf
{

    private final Context mContext;
    private final String zzaxw;
    private zzbe zzazN;
    private final ExecutorService zzazT = Executors.newSingleThreadExecutor();

    zzcm(Context context, String s)
    {
        mContext = context;
        zzaxw = s;
    }

    private com.google.android.gms.internal.zzvl.zzc zza(ByteArrayOutputStream bytearrayoutputstream)
    {
        try
        {
            bytearrayoutputstream = zzay.zzdd(bytearrayoutputstream.toString("UTF-8"));
        }
        // Misplaced declaration of an exception variable
        catch (ByteArrayOutputStream bytearrayoutputstream)
        {
            zzbf.zzY("Failed to convert binary resource to string for JSON parsing; the file format is not UTF-8 format.");
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (ByteArrayOutputStream bytearrayoutputstream)
        {
            zzbf.zzac("Failed to extract the container from the resource file. Resource is a UTF-8 encoded string but doesn't contain a JSON container");
            return null;
        }
        return bytearrayoutputstream;
    }

    private void zzd(com.google.android.gms.internal.zzvd.zza zza1)
        throws IllegalArgumentException
    {
        if (zza1.zzgs == null && zza1.zzaBL == null)
        {
            throw new IllegalArgumentException("Resource and SupplementedResource are NULL.");
        } else
        {
            return;
        }
    }

    private com.google.android.gms.internal.zzvl.zzc zzl(byte abyte0[])
    {
        try
        {
            abyte0 = zzvl.zzb(com.google.android.gms.internal.zzc.zzf.zza(abyte0));
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            zzbf.zzZ("The resource file is corrupted. The container cannot be extracted from the binary file");
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            zzbf.zzac("The resource file is invalid. The container from the binary file is invalid");
            return null;
        }
        if (abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_17;
        }
        zzbf.zzab("The container was successfully loaded from the resource (using binary file)");
        return abyte0;
    }

    public void release()
    {
        this;
        JVM INSTR monitorenter ;
        zzazT.shutdown();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void zza(zzbe zzbe1)
    {
        zzazN = zzbe1;
    }

    public void zzb(com.google.android.gms.internal.zzvd.zza zza1)
    {
        zzazT.execute(new Runnable(zza1) {

            final zzcm zzazU;
            final com.google.android.gms.internal.zzvd.zza zzazV;

            public void run()
            {
                zzazU.zzc(zzazV);
            }

            
            {
                zzazU = zzcm.this;
                zzazV = zza1;
                super();
            }
        });
    }

    boolean zzc(com.google.android.gms.internal.zzvd.zza zza1)
    {
        FileOutputStream fileoutputstream;
        File file;
        file = zztG();
        try
        {
            fileoutputstream = new FileOutputStream(file);
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.internal.zzvd.zza zza1)
        {
            zzbf.zzZ("Error opening resource file for writing");
            return false;
        }
        fileoutputstream.write(zzwy.zzf(zza1));
        try
        {
            fileoutputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.internal.zzvd.zza zza1)
        {
            zzbf.zzac("error closing stream for writing resource to disk");
            return true;
        }
        return true;
        zza1;
        zzbf.zzac("Error writing resource to disk. Removing resource from disk.");
        file.delete();
        try
        {
            fileoutputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.internal.zzvd.zza zza1)
        {
            zzbf.zzac("error closing stream for writing resource to disk");
            return false;
        }
        return false;
        zza1;
        try
        {
            fileoutputstream.close();
        }
        catch (IOException ioexception)
        {
            zzbf.zzac("error closing stream for writing resource to disk");
        }
        throw zza1;
    }

    public com.google.android.gms.internal.zzvl.zzc zzhc(int i)
    {
        Object obj;
        Object obj1;
        try
        {
            obj1 = mContext.getResources().openRawResource(i);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            zzbf.zzac((new StringBuilder()).append("Failed to load the container. No default container resource found with the resource ID ").append(i).toString());
            return null;
        }
        zzbf.zzab((new StringBuilder()).append("Attempting to load a container from the resource ID ").append(i).append(" (").append(mContext.getResources().getResourceName(i)).append(")").toString());
        try
        {
            obj = new ByteArrayOutputStream();
            zzvl.zzc(((java.io.InputStream) (obj1)), ((java.io.OutputStream) (obj)));
            obj1 = zza(((ByteArrayOutputStream) (obj)));
        }
        catch (IOException ioexception)
        {
            zzbf.zzac((new StringBuilder()).append("Error reading the default container with resource ID ").append(i).append(" (").append(mContext.getResources().getResourceName(i)).append(")").toString());
            return null;
        }
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        zzbf.zzab("The container was successfully loaded from the resource (using JSON file format)");
        return ((com.google.android.gms.internal.zzvl.zzc) (obj1));
        obj = zzl(((ByteArrayOutputStream) (obj)).toByteArray());
        return ((com.google.android.gms.internal.zzvl.zzc) (obj));
    }

    public void zzsS()
    {
        zzazT.execute(new Runnable() {

            final zzcm zzazU;

            public void run()
            {
                zzazU.zztF();
            }

            
            {
                zzazU = zzcm.this;
                super();
            }
        });
    }

    void zztF()
    {
        Object obj;
        if (zzazN == null)
        {
            throw new IllegalStateException("Callback must be set before execute");
        }
        zzazN.zzsR();
        zzbf.zzab("Attempting to load resource from disk");
        if ((zzca.zztx().zzty() == zzca.zza.zzazC || zzca.zztx().zzty() == zzca.zza.zzazD) && zzaxw.equals(zzca.zztx().getContainerId()))
        {
            zzazN.zza(zzbe.zza.zzazg);
            return;
        }
        Object obj1;
        try
        {
            obj = new FileInputStream(zztG());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            zzbf.zzY("Failed to find the resource in the disk");
            zzazN.zza(zzbe.zza.zzazg);
            return;
        }
        obj1 = new ByteArrayOutputStream();
        zzvl.zzc(((java.io.InputStream) (obj)), ((java.io.OutputStream) (obj1)));
        obj1 = com.google.android.gms.internal.zzvd.zza.zzm(((ByteArrayOutputStream) (obj1)).toByteArray());
        zzd(((com.google.android.gms.internal.zzvd.zza) (obj1)));
        zzazN.zzo(obj1);
        try
        {
            ((FileInputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            zzbf.zzac("Error closing stream for reading resource from disk");
        }
_L1:
        zzbf.zzab("The Disk resource was successfully read.");
        return;
        Object obj2;
        obj2;
        zzazN.zza(zzbe.zza.zzazh);
        zzbf.zzac("Failed to read the resource from disk");
        try
        {
            ((FileInputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            zzbf.zzac("Error closing stream for reading resource from disk");
        }
          goto _L1
        obj2;
        zzazN.zza(zzbe.zza.zzazh);
        zzbf.zzac("Failed to read the resource from disk. The resource is inconsistent");
        try
        {
            ((FileInputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            zzbf.zzac("Error closing stream for reading resource from disk");
        }
          goto _L1
        obj2;
        try
        {
            ((FileInputStream) (obj)).close();
        }
        catch (IOException ioexception)
        {
            zzbf.zzac("Error closing stream for reading resource from disk");
        }
        throw obj2;
    }

    File zztG()
    {
        String s = (new StringBuilder()).append("resource_").append(zzaxw).toString();
        return new File(mContext.getDir("google_tagmanager", 0), s);
    }
}
