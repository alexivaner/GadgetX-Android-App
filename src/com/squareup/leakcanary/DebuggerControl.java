// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.leakcanary;


public interface DebuggerControl
{

    public static final DebuggerControl NONE = new DebuggerControl() {

        public boolean isDebuggerAttached()
        {
            return false;
        }

    };

    public abstract boolean isDebuggerAttached();

}
