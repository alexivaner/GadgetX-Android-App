// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.zzaa;
import com.google.android.gms.maps.model.internal.zzo;

// Referenced classes of package com.google.android.gms.maps.model:
//            zzw, zzx, TileProvider, Tile

public final class TileOverlayOptions
    implements SafeParcelable
{

    public static final zzw CREATOR = new zzw();
    private final int zzFG;
    private zzo zzarH;
    private TileProvider zzarI;
    private boolean zzarJ;
    private float zzarb;
    private boolean zzarc;

    public TileOverlayOptions()
    {
        zzarc = true;
        zzarJ = true;
        zzFG = 1;
    }

    TileOverlayOptions(int i, IBinder ibinder, boolean flag, float f, boolean flag1)
    {
        zzarc = true;
        zzarJ = true;
        zzFG = i;
        zzarH = com.google.android.gms.maps.model.internal.zzo.zza.zzcf(ibinder);
        if (zzarH == null)
        {
            ibinder = null;
        } else
        {
            ibinder = new TileProvider() {

                private final zzo zzarK;
                final TileOverlayOptions zzarL;

                public Tile getTile(int j, int k, int l)
                {
                    Tile tile;
                    try
                    {
                        tile = zzarK.getTile(j, k, l);
                    }
                    catch (RemoteException remoteexception)
                    {
                        return null;
                    }
                    return tile;
                }

            
            {
                zzarL = TileOverlayOptions.this;
                super();
                zzarK = TileOverlayOptions.zza(zzarL);
            }
            };
        }
        zzarI = ibinder;
        zzarc = flag;
        zzarb = f;
        zzarJ = flag1;
    }

    static zzo zza(TileOverlayOptions tileoverlayoptions)
    {
        return tileoverlayoptions.zzarH;
    }

    public int describeContents()
    {
        return 0;
    }

    public TileOverlayOptions fadeIn(boolean flag)
    {
        zzarJ = flag;
        return this;
    }

    public boolean getFadeIn()
    {
        return zzarJ;
    }

    public TileProvider getTileProvider()
    {
        return zzarI;
    }

    int getVersionCode()
    {
        return zzFG;
    }

    public float getZIndex()
    {
        return zzarb;
    }

    public boolean isVisible()
    {
        return zzarc;
    }

    public TileOverlayOptions tileProvider(TileProvider tileprovider)
    {
        zzarI = tileprovider;
        if (zzarI == null)
        {
            tileprovider = null;
        } else
        {
            tileprovider = new com.google.android.gms.maps.model.internal.zzo.zza(tileprovider) {

                final TileOverlayOptions zzarL;
                final TileProvider zzarM;

                public Tile getTile(int i, int j, int k)
                {
                    return zzarM.getTile(i, j, k);
                }

            
            {
                zzarL = TileOverlayOptions.this;
                zzarM = tileprovider;
                super();
            }
            };
        }
        zzarH = tileprovider;
        return this;
    }

    public TileOverlayOptions visible(boolean flag)
    {
        zzarc = flag;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (zzaa.zzqF())
        {
            zzx.zza(this, parcel, i);
            return;
        } else
        {
            zzw.zza(this, parcel, i);
            return;
        }
    }

    public TileOverlayOptions zIndex(float f)
    {
        zzarb = f;
        return this;
    }

    IBinder zzqK()
    {
        return zzarH.asBinder();
    }

}
