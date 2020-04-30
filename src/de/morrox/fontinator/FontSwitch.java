// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.morrox.fontinator;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Pair;
import android.widget.Switch;
import de.morrox.fontinator.utilities.TypefaceLoader;
import de.morrox.fontinator.utilities.Typefaceable;

public class FontSwitch extends Switch
    implements Typefaceable
{

    private TypefaceLoader typefaceLoader;

    public FontSwitch(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        typefaceLoader = TypefaceLoader.get(this, context, attributeset);
    }

    public void setText(CharSequence charsequence, android.widget.TextView.BufferType buffertype)
    {
        charsequence = TypefaceLoader.inject(typefaceLoader, charsequence, buffertype);
        super.setText((CharSequence)((Pair) (charsequence)).first, (android.widget.TextView.BufferType)((Pair) (charsequence)).second);
    }
}
