// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

// Referenced classes of package com.google.android.gms.location.places:
//            PlaceFilter

public static final class <init>
{

    private boolean zzanC;
    private Collection zzanH;
    private Collection zzanI;
    private String zzanJ[];

    public PlaceFilter zzpK()
    {
        java.util.List list = null;
        ArrayList arraylist;
        ArrayList arraylist1;
        if (zzanH != null)
        {
            arraylist = new ArrayList(zzanH);
        } else
        {
            arraylist = null;
        }
        if (zzanI != null)
        {
            arraylist1 = new ArrayList(zzanI);
        } else
        {
            arraylist1 = null;
        }
        if (zzanJ != null)
        {
            list = Arrays.asList(zzanJ);
        }
        return new PlaceFilter(arraylist, zzanC, list, arraylist1);
    }

    private ()
    {
        zzanH = null;
        zzanC = false;
        zzanI = null;
        zzanJ = null;
    }

    zzanJ(zzanJ zzanj)
    {
        this();
    }
}
