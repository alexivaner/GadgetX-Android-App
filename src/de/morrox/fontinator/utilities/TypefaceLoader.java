// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.morrox.fontinator.utilities;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ScaleXSpan;
import android.util.AttributeSet;
import android.util.LruCache;
import android.util.Pair;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class TypefaceLoader
{
    public static final class TRANSFORM extends Enum
    {

        private static final TRANSFORM ENUM$VALUES[];
        public static final TRANSFORM LOWERCASE;
        public static final TRANSFORM NONE;
        public static final TRANSFORM UPPERCASE;
        private static Map map;
        private final int value;

        static TRANSFORM findByValue(int i)
        {
            return (TRANSFORM)map.get(Integer.valueOf(i));
        }

        public static TRANSFORM valueOf(String s)
        {
            return (TRANSFORM)Enum.valueOf(de/morrox/fontinator/utilities/TypefaceLoader$TRANSFORM, s);
        }

        public static TRANSFORM[] values()
        {
            TRANSFORM atransform[] = ENUM$VALUES;
            int i = atransform.length;
            TRANSFORM atransform1[] = new TRANSFORM[i];
            System.arraycopy(atransform, 0, atransform1, 0, i);
            return atransform1;
        }

        static 
        {
            int i = 0;
            NONE = new TRANSFORM("NONE", 0, 0);
            UPPERCASE = new TRANSFORM("UPPERCASE", 1, 1);
            LOWERCASE = new TRANSFORM("LOWERCASE", 2, 2);
            ENUM$VALUES = (new TRANSFORM[] {
                NONE, UPPERCASE, LOWERCASE
            });
            map = new HashMap();
            TRANSFORM atransform[] = values();
            int j = atransform.length;
            do
            {
                if (i >= j)
                {
                    return;
                }
                TRANSFORM transform = atransform[i];
                map.put(Integer.valueOf(transform.value), transform);
                i++;
            } while (true);
        }


        private TRANSFORM(String s, int i, int j)
        {
            super(s, i);
            value = j;
        }
    }


    private static int $SWITCH_TABLE$de$morrox$fontinator$utilities$TypefaceLoader$TRANSFORM[];
    public static final float NO_LETTER_SPACE = -9999F;
    private static LruCache sTypefaceCache = new LruCache(12);
    private boolean isHtml;
    private float letterSpace;
    private TRANSFORM textTransform;
    private final WeakReference view;

    static int[] $SWITCH_TABLE$de$morrox$fontinator$utilities$TypefaceLoader$TRANSFORM()
    {
        int ai[] = $SWITCH_TABLE$de$morrox$fontinator$utilities$TypefaceLoader$TRANSFORM;
        if (ai != null)
        {
            return ai;
        }
        ai = new int[TRANSFORM.values().length];
        try
        {
            ai[TRANSFORM.LOWERCASE.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            ai[TRANSFORM.NONE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            ai[TRANSFORM.UPPERCASE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        $SWITCH_TABLE$de$morrox$fontinator$utilities$TypefaceLoader$TRANSFORM = ai;
        return ai;
    }

    public TypefaceLoader(TextView textview, Context context, AttributeSet attributeset)
    {
        letterSpace = -9999F;
        textTransform = null;
        isHtml = false;
        view = new WeakReference(textview);
        setTypeFace(context, attributeset);
    }

    public static TypefaceLoader get(TextView textview, Context context, AttributeSet attributeset)
    {
        return new TypefaceLoader(textview, context, attributeset);
    }

    private static Typeface getTypeface(Context context, String s)
    {
        Typeface typeface;
        Typeface typeface1;
        try
        {
            typeface1 = (Typeface)sTypefaceCache.get(s);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        typeface = typeface1;
        if (typeface1 != null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        typeface = Typeface.createFromAsset(context.getAssets(), String.format("fonts/%s", new Object[] {
            s
        }));
        sTypefaceCache.put(s, typeface);
        return typeface;
    }

    public static Pair inject(TypefaceLoader typefaceloader, CharSequence charsequence, android.widget.TextView.BufferType buffertype)
    {
        if (typefaceloader == null)
        {
            return new Pair(charsequence, buffertype);
        } else
        {
            return typefaceloader.createLetterSpacing(charsequence, buffertype);
        }
    }

    private void setTypeFace(Context context, AttributeSet attributeset)
    {
        TextView textview;
        textview = (TextView)view.get();
        attributeset = context.getTheme().obtainStyledAttributes(attributeset, de.morrox.fontinator.R.styleable.Typefaceable, 0, 0);
        String s;
        isHtml = attributeset.getBoolean(de.morrox.fontinator.R.styleable.Typefaceable_html, false);
        letterSpace = attributeset.getFloat(de.morrox.fontinator.R.styleable.Typefaceable_letterSpace, -9999F);
        textTransform = TRANSFORM.findByValue(attributeset.getInt(de.morrox.fontinator.R.styleable.Typefaceable_textTransform, TRANSFORM.NONE.value));
        s = attributeset.getString(de.morrox.fontinator.R.styleable.Typefaceable_font);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        if (!TextUtils.isEmpty(s))
        {
            textview.setTypeface(getTypeface(context, s));
            textview.setPaintFlags(textview.getPaintFlags() | 0x80);
        }
        attributeset.recycle();
        context = createLetterSpacing(textview.getText(), android.widget.TextView.BufferType.NORMAL);
        textview.setText((CharSequence)((Pair) (context)).first, (android.widget.TextView.BufferType)((Pair) (context)).second);
        return;
        context;
        attributeset.recycle();
        throw context;
    }

    public Pair createLetterSpacing(CharSequence charsequence, android.widget.TextView.BufferType buffertype)
    {
        TextView textview = (TextView)view.get();
        $SWITCH_TABLE$de$morrox$fontinator$utilities$TypefaceLoader$TRANSFORM()[textTransform.ordinal()];
        JVM INSTR tableswitch 2 3: default 44
    //                   2 140
    //                   3 127;
           goto _L1 _L2 _L3
_L1:
        if (letterSpace == -9999F || charsequence == null) goto _L5; else goto _L4
_L4:
        if (charsequence.length() <= 1) goto _L7; else goto _L6
_L6:
        int i;
        if (charsequence instanceof SpannableStringBuilder)
        {
            buffertype = (SpannableStringBuilder)charsequence;
        } else
        {
            if (isHtml)
            {
                buffertype = Html.fromHtml(charsequence.toString());
            } else
            {
                buffertype = charsequence;
            }
            buffertype = new SpannableStringBuilder(buffertype);
        }
        i = charsequence.length() - 1;
_L8:
        if (i < 1)
        {
            if (android.os.Build.VERSION.SDK_INT >= 14)
            {
                textview.setAllCaps(false);
            }
            textview.setLayerType(1, null);
            return new Pair(buffertype, android.widget.TextView.BufferType.SPANNABLE);
        }
        buffertype.insert(i, "\240");
        buffertype.setSpan(new ScaleXSpan(letterSpace), i, i + 1, 33);
        i--;
        continue; /* Loop/switch isn't completed */
_L3:
        charsequence = charsequence.toString().toLowerCase();
        continue; /* Loop/switch isn't completed */
_L2:
        charsequence = charsequence.toString().toUpperCase();
        continue; /* Loop/switch isn't completed */
        if (true) goto _L8; else goto _L5
_L5:
        if (charsequence != null)
        {
            if (isHtml)
            {
                textview.setLayerType(1, null);
                return new Pair(Html.fromHtml(charsequence.toString()), android.widget.TextView.BufferType.SPANNABLE);
            }
            if (textTransform != null && textTransform != TRANSFORM.NONE)
            {
                textview.setLayerType(1, null);
                return new Pair(charsequence, android.widget.TextView.BufferType.SPANNABLE);
            }
        }
_L7:
        return new Pair(charsequence, buffertype);
        if (true) goto _L1; else goto _L9
_L9:
    }

}
