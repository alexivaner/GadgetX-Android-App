// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.animation;

import android.view.View;
import com.nineoldandroids.util.Property;
import com.nineoldandroids.view.animation.AnimatorProxy;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.nineoldandroids.animation:
//            ValueAnimator, PreHoneycombCompat, PropertyValuesHolder, TypeEvaluator

public final class ObjectAnimator extends ValueAnimator
{

    private static final boolean DBG = false;
    private static final Map PROXY_PROPERTIES;
    private Property mProperty;
    private String mPropertyName;
    private Object mTarget;

    public ObjectAnimator()
    {
    }

    private ObjectAnimator(Object obj, Property property)
    {
        mTarget = obj;
        setProperty(property);
    }

    private ObjectAnimator(Object obj, String s)
    {
        mTarget = obj;
        setPropertyName(s);
    }

    public static transient ObjectAnimator ofFloat(Object obj, Property property, float af[])
    {
        obj = new ObjectAnimator(obj, property);
        ((ObjectAnimator) (obj)).setFloatValues(af);
        return ((ObjectAnimator) (obj));
    }

    public static transient ObjectAnimator ofFloat(Object obj, String s, float af[])
    {
        obj = new ObjectAnimator(obj, s);
        ((ObjectAnimator) (obj)).setFloatValues(af);
        return ((ObjectAnimator) (obj));
    }

    public static transient ObjectAnimator ofInt(Object obj, Property property, int ai[])
    {
        obj = new ObjectAnimator(obj, property);
        ((ObjectAnimator) (obj)).setIntValues(ai);
        return ((ObjectAnimator) (obj));
    }

    public static transient ObjectAnimator ofInt(Object obj, String s, int ai[])
    {
        obj = new ObjectAnimator(obj, s);
        ((ObjectAnimator) (obj)).setIntValues(ai);
        return ((ObjectAnimator) (obj));
    }

    public static transient ObjectAnimator ofObject(Object obj, Property property, TypeEvaluator typeevaluator, Object aobj[])
    {
        obj = new ObjectAnimator(obj, property);
        ((ObjectAnimator) (obj)).setObjectValues(aobj);
        ((ObjectAnimator) (obj)).setEvaluator(typeevaluator);
        return ((ObjectAnimator) (obj));
    }

    public static transient ObjectAnimator ofObject(Object obj, String s, TypeEvaluator typeevaluator, Object aobj[])
    {
        obj = new ObjectAnimator(obj, s);
        ((ObjectAnimator) (obj)).setObjectValues(aobj);
        ((ObjectAnimator) (obj)).setEvaluator(typeevaluator);
        return ((ObjectAnimator) (obj));
    }

    public static transient ObjectAnimator ofPropertyValuesHolder(Object obj, PropertyValuesHolder apropertyvaluesholder[])
    {
        ObjectAnimator objectanimator = new ObjectAnimator();
        objectanimator.mTarget = obj;
        objectanimator.setValues(apropertyvaluesholder);
        return objectanimator;
    }

    void animateValue(float f)
    {
        super.animateValue(f);
        int j = mValues.length;
        int i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            mValues[i].setAnimatedValue(mTarget);
            i++;
        } while (true);
    }

    public ObjectAnimator clone()
    {
        return (ObjectAnimator)super.clone();
    }

    public volatile ValueAnimator clone()
    {
        return clone();
    }

    public String getPropertyName()
    {
        return mPropertyName;
    }

    public Object getTarget()
    {
        return mTarget;
    }

    void initAnimation()
    {
        if (mInitialized) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        if (mProperty == null && AnimatorProxy.NEEDS_PROXY && (mTarget instanceof View) && PROXY_PROPERTIES.containsKey(mPropertyName))
        {
            setProperty((Property)PROXY_PROPERTIES.get(mPropertyName));
        }
        j = mValues.length;
        i = 0;
_L6:
        if (i < j) goto _L4; else goto _L3
_L3:
        super.initAnimation();
_L2:
        return;
_L4:
        mValues[i].setupSetterAndGetter(mTarget);
        i++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public ObjectAnimator setDuration(long l)
    {
        super.setDuration(l);
        return this;
    }

    public volatile ValueAnimator setDuration(long l)
    {
        return setDuration(l);
    }

    public transient void setFloatValues(float af[])
    {
        if (mValues == null || mValues.length == 0)
        {
            if (mProperty != null)
            {
                setValues(new PropertyValuesHolder[] {
                    PropertyValuesHolder.ofFloat(mProperty, af)
                });
                return;
            } else
            {
                setValues(new PropertyValuesHolder[] {
                    PropertyValuesHolder.ofFloat(mPropertyName, af)
                });
                return;
            }
        } else
        {
            super.setFloatValues(af);
            return;
        }
    }

    public transient void setIntValues(int ai[])
    {
        if (mValues == null || mValues.length == 0)
        {
            if (mProperty != null)
            {
                setValues(new PropertyValuesHolder[] {
                    PropertyValuesHolder.ofInt(mProperty, ai)
                });
                return;
            } else
            {
                setValues(new PropertyValuesHolder[] {
                    PropertyValuesHolder.ofInt(mPropertyName, ai)
                });
                return;
            }
        } else
        {
            super.setIntValues(ai);
            return;
        }
    }

    public transient void setObjectValues(Object aobj[])
    {
        if (mValues == null || mValues.length == 0)
        {
            if (mProperty != null)
            {
                setValues(new PropertyValuesHolder[] {
                    PropertyValuesHolder.ofObject(mProperty, null, aobj)
                });
                return;
            } else
            {
                setValues(new PropertyValuesHolder[] {
                    PropertyValuesHolder.ofObject(mPropertyName, null, aobj)
                });
                return;
            }
        } else
        {
            super.setObjectValues(aobj);
            return;
        }
    }

    public void setProperty(Property property)
    {
        if (mValues != null)
        {
            PropertyValuesHolder propertyvaluesholder = mValues[0];
            String s = propertyvaluesholder.getPropertyName();
            propertyvaluesholder.setProperty(property);
            mValuesMap.remove(s);
            mValuesMap.put(mPropertyName, propertyvaluesholder);
        }
        if (mProperty != null)
        {
            mPropertyName = property.getName();
        }
        mProperty = property;
        mInitialized = false;
    }

    public void setPropertyName(String s)
    {
        if (mValues != null)
        {
            PropertyValuesHolder propertyvaluesholder = mValues[0];
            String s1 = propertyvaluesholder.getPropertyName();
            propertyvaluesholder.setPropertyName(s);
            mValuesMap.remove(s1);
            mValuesMap.put(s, propertyvaluesholder);
        }
        mPropertyName = s;
        mInitialized = false;
    }

    public void setTarget(Object obj)
    {
label0:
        {
            if (mTarget != obj)
            {
                Object obj1 = mTarget;
                mTarget = obj;
                if (obj1 == null || obj == null || obj1.getClass() != obj.getClass())
                {
                    break label0;
                }
            }
            return;
        }
        mInitialized = false;
    }

    public void setupEndValues()
    {
        initAnimation();
        int j = mValues.length;
        int i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            mValues[i].setupEndValue(mTarget);
            i++;
        } while (true);
    }

    public void setupStartValues()
    {
        initAnimation();
        int j = mValues.length;
        int i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            mValues[i].setupStartValue(mTarget);
            i++;
        } while (true);
    }

    public void start()
    {
        super.start();
    }

    public String toString()
    {
        String s;
        String s1;
        s = (new StringBuilder("ObjectAnimator@")).append(Integer.toHexString(hashCode())).append(", target ").append(mTarget).toString();
        s1 = s;
        if (mValues == null) goto _L2; else goto _L1
_L1:
        int i = 0;
_L6:
        if (i < mValues.length) goto _L4; else goto _L3
_L3:
        s1 = s;
_L2:
        return s1;
_L4:
        s = (new StringBuilder(String.valueOf(s))).append("\n    ").append(mValues[i].toString()).toString();
        i++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    static 
    {
        PROXY_PROPERTIES = new HashMap();
        PROXY_PROPERTIES.put("alpha", PreHoneycombCompat.ALPHA);
        PROXY_PROPERTIES.put("pivotX", PreHoneycombCompat.PIVOT_X);
        PROXY_PROPERTIES.put("pivotY", PreHoneycombCompat.PIVOT_Y);
        PROXY_PROPERTIES.put("translationX", PreHoneycombCompat.TRANSLATION_X);
        PROXY_PROPERTIES.put("translationY", PreHoneycombCompat.TRANSLATION_Y);
        PROXY_PROPERTIES.put("rotation", PreHoneycombCompat.ROTATION);
        PROXY_PROPERTIES.put("rotationX", PreHoneycombCompat.ROTATION_X);
        PROXY_PROPERTIES.put("rotationY", PreHoneycombCompat.ROTATION_Y);
        PROXY_PROPERTIES.put("scaleX", PreHoneycombCompat.SCALE_X);
        PROXY_PROPERTIES.put("scaleY", PreHoneycombCompat.SCALE_Y);
        PROXY_PROPERTIES.put("scrollX", PreHoneycombCompat.SCROLL_X);
        PROXY_PROPERTIES.put("scrollY", PreHoneycombCompat.SCROLL_Y);
        PROXY_PROPERTIES.put("x", PreHoneycombCompat.X);
        PROXY_PROPERTIES.put("y", PreHoneycombCompat.Y);
    }
}
