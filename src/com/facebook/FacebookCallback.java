// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;


// Referenced classes of package com.facebook:
//            FacebookException

public interface FacebookCallback
{

    public abstract void onCancel();

    public abstract void onError(FacebookException facebookexception);

    public abstract void onSuccess(Object obj);
}
