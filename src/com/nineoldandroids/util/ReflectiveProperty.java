// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Referenced classes of package com.nineoldandroids.util:
//            Property, NoSuchPropertyException

class ReflectiveProperty extends Property
{

    private static final String PREFIX_GET = "get";
    private static final String PREFIX_IS = "is";
    private static final String PREFIX_SET = "set";
    private Field mField;
    private Method mGetter;
    private Method mSetter;

    public ReflectiveProperty(Class class1, Class class2, String s)
    {
        super(class2, s);
        char c = Character.toUpperCase(s.charAt(0));
        Object obj = s.substring(1);
        obj = (new StringBuilder(String.valueOf(c))).append(((String) (obj))).toString();
        String s1 = (new StringBuilder("get")).append(((String) (obj))).toString();
        try
        {
            mGetter = class1.getMethod(s1, null);
        }
        catch (NoSuchMethodException nosuchmethodexception1)
        {
            try
            {
                mGetter = class1.getDeclaredMethod(s1, null);
                mGetter.setAccessible(true);
            }
            catch (NoSuchMethodException nosuchmethodexception)
            {
                String s2 = (new StringBuilder("is")).append(((String) (obj))).toString();
                try
                {
                    mGetter = class1.getMethod(s2, null);
                }
                catch (NoSuchMethodException nosuchmethodexception2)
                {
                    try
                    {
                        mGetter = class1.getDeclaredMethod(s2, null);
                        mGetter.setAccessible(true);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        try
                        {
                            mField = class1.getField(s);
                            class1 = mField.getType();
                            if (!typesMatch(class2, class1))
                            {
                                throw new NoSuchPropertyException((new StringBuilder("Underlying type (")).append(class1).append(") ").append("does not match Property type (").append(class2).append(")").toString());
                            }
                        }
                        // Misplaced declaration of an exception variable
                        catch (Class class1)
                        {
                            throw new NoSuchPropertyException((new StringBuilder("No accessor method or field found for property with name ")).append(s).toString());
                        }
                        break MISSING_BLOCK_LABEL_357;
                    }
                }
            }
        }
        s = mGetter.getReturnType();
        if (!typesMatch(class2, s))
        {
            throw new NoSuchPropertyException((new StringBuilder("Underlying type (")).append(s).append(") ").append("does not match Property type (").append(class2).append(")").toString());
        }
        class2 = (new StringBuilder("set")).append(((String) (obj))).toString();
        mSetter = class1.getDeclaredMethod(class2, new Class[] {
            s
        });
        mSetter.setAccessible(true);
        return;
        class1;
    }

    private boolean typesMatch(Class class1, Class class2)
    {
        if (class2 != class1)
        {
            return class2.isPrimitive() && (class2 == Float.TYPE && class1 == java/lang/Float || class2 == Integer.TYPE && class1 == java/lang/Integer || class2 == Boolean.TYPE && class1 == java/lang/Boolean || class2 == Long.TYPE && class1 == java/lang/Long || class2 == Double.TYPE && class1 == java/lang/Double || class2 == Short.TYPE && class1 == java/lang/Short || class2 == Byte.TYPE && class1 == java/lang/Byte || class2 == Character.TYPE && class1 == java/lang/Character);
        } else
        {
            return true;
        }
    }

    public Object get(Object obj)
    {
        if (mGetter != null)
        {
            try
            {
                obj = mGetter.invoke(obj, null);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new AssertionError();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new RuntimeException(((InvocationTargetException) (obj)).getCause());
            }
            return obj;
        }
        if (mField != null)
        {
            try
            {
                obj = mField.get(obj);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new AssertionError();
            }
            return obj;
        } else
        {
            throw new AssertionError();
        }
    }

    public boolean isReadOnly()
    {
        return mSetter == null && mField == null;
    }

    public void set(Object obj, Object obj1)
    {
        if (mSetter != null)
        {
            try
            {
                mSetter.invoke(obj, new Object[] {
                    obj1
                });
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new AssertionError();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new RuntimeException(((InvocationTargetException) (obj)).getCause());
            }
        }
        if (mField != null)
        {
            try
            {
                mField.set(obj, obj1);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new AssertionError();
            }
        } else
        {
            throw new UnsupportedOperationException((new StringBuilder("Property ")).append(getName()).append(" is read-only").toString());
        }
    }
}
