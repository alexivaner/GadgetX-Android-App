// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.http.entity.mime.content;

import java.nio.charset.Charset;
import org.apache.http.entity.ContentType;
import org.apache.http.util.Args;

// Referenced classes of package org.apache.http.entity.mime.content:
//            ContentBody

public abstract class AbstractContentBody
    implements ContentBody
{

    private final ContentType contentType;

    public AbstractContentBody(String s)
    {
        this(ContentType.parse(s));
    }

    public AbstractContentBody(ContentType contenttype)
    {
        Args.notNull(contenttype, "Content type");
        contentType = contenttype;
    }

    public String getCharset()
    {
        Charset charset = contentType.getCharset();
        if (charset != null)
        {
            return charset.name();
        } else
        {
            return null;
        }
    }

    public ContentType getContentType()
    {
        return contentType;
    }

    public String getMediaType()
    {
        String s1 = contentType.getMimeType();
        int i = s1.indexOf('/');
        String s = s1;
        if (i != -1)
        {
            s = s1.substring(0, i);
        }
        return s;
    }

    public String getMimeType()
    {
        return contentType.getMimeType();
    }

    public String getSubType()
    {
        String s = contentType.getMimeType();
        int i = s.indexOf('/');
        if (i != -1)
        {
            return s.substring(i + 1);
        } else
        {
            return null;
        }
    }
}
