// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.andraskindler.quickscroll;


public interface Scrollable
{

    public abstract String getIndicatorForPosition(int i, int j);

    public abstract int getScrollPosition(int i, int j);
}
