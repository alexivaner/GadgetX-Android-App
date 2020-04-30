// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.leakcanary;


// Referenced classes of package com.squareup.leakcanary:
//            GcTrigger

class 
    implements GcTrigger
{

    private void enqueueReferences()
    {
        try
        {
            Thread.sleep(100L);
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            throw new AssertionError();
        }
    }

    public void runGc()
    {
        Runtime.getRuntime().gc();
        enqueueReferences();
        System.runFinalization();
    }

    ()
    {
    }
}
