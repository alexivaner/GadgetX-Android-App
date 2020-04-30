// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.view;

import java.util.ArrayList;

// Referenced classes of package com.nineoldandroids.view:
//            ViewPropertyAnimatorHC

private static class mNameValuesHolder
{

    ArrayList mNameValuesHolder;
    int mPropertyMask;

    boolean cancel(int i)
    {
        if ((mPropertyMask & i) == 0 || mNameValuesHolder == null) goto _L2; else goto _L1
_L1:
        int j;
        int k;
        k = mNameValuesHolder.size();
        j = 0;
_L5:
        if (j < k) goto _L3; else goto _L2
_L2:
        return false;
_L3:
        if (((r)mNameValuesHolder.get(j)).mNameConstant == i)
        {
            mNameValuesHolder.remove(j);
            mPropertyMask = mPropertyMask & ~i;
            return true;
        }
        j++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    r(int i, ArrayList arraylist)
    {
        mPropertyMask = i;
        mNameValuesHolder = arraylist;
    }
}
