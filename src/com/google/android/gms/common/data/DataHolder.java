// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.android.gms.common.data:
//            zzf

public final class DataHolder
    implements SafeParcelable
{
    public static class zza
    {

        private final String zzNU[];
        private final ArrayList zzOd;
        private final String zzOe;
        private final HashMap zzOf;
        private boolean zzOg;
        private String zzOh;

        static String[] zza(zza zza1)
        {
            return zza1.zzNU;
        }

        static ArrayList zzb(zza zza1)
        {
            return zza1.zzOd;
        }

        private zza(String as[], String s)
        {
            zzNU = (String[])zzx.zzl(as);
            zzOd = new ArrayList();
            zzOe = s;
            zzOf = new HashMap();
            zzOg = false;
            zzOh = null;
        }

    }

    public static class zzb extends RuntimeException
    {

        public zzb(String s)
        {
            super(s);
        }
    }


    public static final zzf CREATOR = new zzf();
    private static final zza zzOc = new zza(new String[0], null) {

    };
    boolean mClosed;
    private final int zzFG;
    private final int zzLs;
    private final String zzNU[];
    Bundle zzNV;
    private final CursorWindow zzNW[];
    private final Bundle zzNX;
    int zzNY[];
    int zzNZ;
    private Object zzOa;
    private boolean zzOb;

    DataHolder(int i, String as[], CursorWindow acursorwindow[], int j, Bundle bundle)
    {
        mClosed = false;
        zzOb = true;
        zzFG = i;
        zzNU = as;
        zzNW = acursorwindow;
        zzLs = j;
        zzNX = bundle;
    }

    private DataHolder(zza zza1, int i, Bundle bundle)
    {
        this(zza.zza(zza1), zza(zza1, -1), i, bundle);
    }

    public DataHolder(String as[], CursorWindow acursorwindow[], int i, Bundle bundle)
    {
        mClosed = false;
        zzOb = true;
        zzFG = 1;
        zzNU = (String[])zzx.zzl(as);
        zzNW = (CursorWindow[])zzx.zzl(acursorwindow);
        zzLs = i;
        zzNX = bundle;
        zziy();
    }

    public static DataHolder zza(int i, Bundle bundle)
    {
        return new DataHolder(zzOc, i, bundle);
    }

    private static CursorWindow[] zza(zza zza1, int i)
    {
        CursorWindow cursorwindow;
        Object obj;
        Object obj1;
        ArrayList arraylist;
        int j;
        boolean flag;
        flag = false;
        if (zza.zza(zza1).length == 0)
        {
            return new CursorWindow[0];
        }
        int l;
        if (i < 0 || i >= zza.zzb(zza1).size())
        {
            obj1 = zza.zzb(zza1);
        } else
        {
            obj1 = zza.zzb(zza1).subList(0, i);
        }
        l = ((List) (obj1)).size();
        obj = new CursorWindow(false);
        arraylist = new ArrayList();
        arraylist.add(obj);
        ((CursorWindow) (obj)).setNumColumns(zza.zza(zza1).length);
        i = 0;
        j = 0;
_L4:
        if (i >= l)
        {
            break; /* Loop/switch isn't completed */
        }
        cursorwindow = ((CursorWindow) (obj));
        if (((CursorWindow) (obj)).allocRow())
        {
            break MISSING_BLOCK_LABEL_219;
        }
        Log.d("DataHolder", (new StringBuilder()).append("Allocating additional cursor window for large data set (row ").append(i).append(")").toString());
        obj = new CursorWindow(false);
        ((CursorWindow) (obj)).setStartPosition(i);
        ((CursorWindow) (obj)).setNumColumns(zza.zza(zza1).length);
        arraylist.add(obj);
        cursorwindow = ((CursorWindow) (obj));
        if (((CursorWindow) (obj)).allocRow())
        {
            break MISSING_BLOCK_LABEL_219;
        }
        Log.e("DataHolder", "Unable to allocate row to hold data.");
        arraylist.remove(obj);
        zza1 = (CursorWindow[])arraylist.toArray(new CursorWindow[arraylist.size()]);
        return zza1;
        obj = (Map)((List) (obj1)).get(i);
        int k;
        k = 0;
        String s;
        Object obj2;
        long l1;
        for (boolean flag1 = true; k >= zza.zza(zza1).length || !flag1; k++)
        {
            break MISSING_BLOCK_LABEL_565;
        }

        s = zza.zza(zza1)[k];
        obj2 = ((Map) (obj)).get(s);
        if (obj2 != null)
        {
            break MISSING_BLOCK_LABEL_288;
        }
        flag1 = cursorwindow.putNull(i, k);
        break MISSING_BLOCK_LABEL_705;
        if (obj2 instanceof String)
        {
            flag1 = cursorwindow.putString((String)obj2, i, k);
            break MISSING_BLOCK_LABEL_705;
        }
        if (obj2 instanceof Long)
        {
            flag1 = cursorwindow.putLong(((Long)obj2).longValue(), i, k);
            break MISSING_BLOCK_LABEL_705;
        }
        if (obj2 instanceof Integer)
        {
            flag1 = cursorwindow.putLong(((Integer)obj2).intValue(), i, k);
            break MISSING_BLOCK_LABEL_705;
        }
        if (!(obj2 instanceof Boolean))
        {
            break MISSING_BLOCK_LABEL_406;
        }
        if (((Boolean)obj2).booleanValue())
        {
            l1 = 1L;
        } else
        {
            l1 = 0L;
        }
        flag1 = cursorwindow.putLong(l1, i, k);
        break MISSING_BLOCK_LABEL_705;
        if (obj2 instanceof byte[])
        {
            flag1 = cursorwindow.putBlob((byte[])(byte[])obj2, i, k);
            break MISSING_BLOCK_LABEL_705;
        }
        if (obj2 instanceof Double)
        {
            flag1 = cursorwindow.putDouble(((Double)obj2).doubleValue(), i, k);
            break MISSING_BLOCK_LABEL_705;
        }
        if (obj2 instanceof Float)
        {
            flag1 = cursorwindow.putDouble(((Float)obj2).floatValue(), i, k);
            break MISSING_BLOCK_LABEL_705;
        }
        try
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Unsupported object for column ").append(s).append(": ").append(obj2).toString());
        }
        // Misplaced declaration of an exception variable
        catch (zza zza1)
        {
            j = arraylist.size();
        }
        for (i = ((flag) ? 1 : 0); i < j; i++)
        {
            ((CursorWindow)arraylist.get(i)).close();
        }

        break MISSING_BLOCK_LABEL_686;
        if (flag1)
        {
            break MISSING_BLOCK_LABEL_674;
        }
        if (j == 0)
        {
            break MISSING_BLOCK_LABEL_585;
        }
        throw new zzb("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
        Log.d("DataHolder", (new StringBuilder()).append("Couldn't populate window data for row ").append(i).append(" - allocating new window.").toString());
        cursorwindow.freeLastRow();
        cursorwindow = new CursorWindow(false);
        cursorwindow.setStartPosition(i);
        cursorwindow.setNumColumns(zza.zza(zza1).length);
        arraylist.add(cursorwindow);
        j = i - 1;
        i = 1;
_L2:
        k = i;
        i = j + 1;
        obj = cursorwindow;
        j = k;
        continue; /* Loop/switch isn't completed */
        k = 0;
        j = i;
        i = k;
        if (true) goto _L2; else goto _L1
_L1:
        throw zza1;
        if (true) goto _L4; else goto _L3
_L3:
        return (CursorWindow[])arraylist.toArray(new CursorWindow[arraylist.size()]);
    }

    public static DataHolder zzay(int i)
    {
        return zza(i, ((Bundle) (null)));
    }

    private void zzg(String s, int i)
    {
        if (zzNV == null || !zzNV.containsKey(s))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("No such column: ").append(s).toString());
        }
        if (isClosed())
        {
            throw new IllegalArgumentException("Buffer is closed.");
        }
        if (i < 0 || i >= zzNZ)
        {
            throw new CursorIndexOutOfBoundsException(i, zzNZ);
        } else
        {
            return;
        }
    }

    public void close()
    {
        this;
        JVM INSTR monitorenter ;
        if (mClosed) goto _L2; else goto _L1
_L1:
        mClosed = true;
        int i = 0;
_L3:
        if (i >= zzNW.length)
        {
            break; /* Loop/switch isn't completed */
        }
        zzNW[i].close();
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int describeContents()
    {
        return 0;
    }

    protected void finalize()
        throws Throwable
    {
        if (!zzOb || zzNW.length <= 0 || isClosed()) goto _L2; else goto _L1
_L1:
        String s;
        if (zzOa != null)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        s = (new StringBuilder()).append("internal object: ").append(toString()).toString();
_L3:
        Log.e("DataBuffer", (new StringBuilder()).append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (").append(s).append(")").toString());
        close();
_L2:
        super.finalize();
        return;
        s = zzOa.toString();
          goto _L3
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public int getCount()
    {
        return zzNZ;
    }

    public int getStatusCode()
    {
        return zzLs;
    }

    int getVersionCode()
    {
        return zzFG;
    }

    public boolean isClosed()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mClosed;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.common.data.zzf.zza(this, parcel, i);
    }

    public long zza(String s, int i, int j)
    {
        zzg(s, i);
        return zzNW[j].getLong(i, zzNV.getInt(s));
    }

    public void zza(String s, int i, int j, CharArrayBuffer chararraybuffer)
    {
        zzg(s, i);
        zzNW[j].copyStringToBuffer(i, zzNV.getInt(s), chararraybuffer);
    }

    public int zzax(int i)
    {
        int k = 0;
        boolean flag;
        if (i >= 0 && i < zzNZ)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzN(flag);
        do
        {
label0:
            {
                int j = k;
                if (k < zzNY.length)
                {
                    if (i >= zzNY[k])
                    {
                        break label0;
                    }
                    j = k - 1;
                }
                i = j;
                if (j == zzNY.length)
                {
                    i = j - 1;
                }
                return i;
            }
            k++;
        } while (true);
    }

    public int zzb(String s, int i, int j)
    {
        zzg(s, i);
        return zzNW[j].getInt(i, zzNV.getInt(s));
    }

    public boolean zzba(String s)
    {
        return zzNV.containsKey(s);
    }

    public String zzc(String s, int i, int j)
    {
        zzg(s, i);
        return zzNW[j].getString(i, zzNV.getInt(s));
    }

    public boolean zzd(String s, int i, int j)
    {
        zzg(s, i);
        return Long.valueOf(zzNW[j].getLong(i, zzNV.getInt(s))).longValue() == 1L;
    }

    public float zze(String s, int i, int j)
    {
        zzg(s, i);
        return zzNW[j].getFloat(i, zzNV.getInt(s));
    }

    public byte[] zzf(String s, int i, int j)
    {
        zzg(s, i);
        return zzNW[j].getBlob(i, zzNV.getInt(s));
    }

    public Uri zzg(String s, int i, int j)
    {
        s = zzc(s, i, j);
        if (s == null)
        {
            return null;
        } else
        {
            return Uri.parse(s);
        }
    }

    public void zzg(Object obj)
    {
        zzOa = obj;
    }

    public boolean zzh(String s, int i, int j)
    {
        zzg(s, i);
        return zzNW[j].isNull(i, zzNV.getInt(s));
    }

    CursorWindow[] zziA()
    {
        return zzNW;
    }

    public Bundle zziu()
    {
        return zzNX;
    }

    public void zziy()
    {
        int k = 0;
        zzNV = new Bundle();
        for (int i = 0; i < zzNU.length; i++)
        {
            zzNV.putInt(zzNU[i], i);
        }

        zzNY = new int[zzNW.length];
        boolean flag = false;
        int j = k;
        k = ((flag) ? 1 : 0);
        for (; j < zzNW.length; j++)
        {
            zzNY[j] = k;
            int l = zzNW[j].getStartPosition();
            k += zzNW[j].getNumRows() - (k - l);
        }

        zzNZ = k;
    }

    String[] zziz()
    {
        return zzNU;
    }

}
