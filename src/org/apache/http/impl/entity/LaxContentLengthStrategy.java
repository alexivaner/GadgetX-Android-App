// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.http.impl.entity;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.ParseException;
import org.apache.http.ProtocolException;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.util.Args;

public class LaxContentLengthStrategy
    implements ContentLengthStrategy
{

    public static final LaxContentLengthStrategy INSTANCE = new LaxContentLengthStrategy();
    private final int implicitLen;

    public LaxContentLengthStrategy()
    {
        this(-1);
    }

    public LaxContentLengthStrategy(int i)
    {
        implicitLen = i;
    }

    public long determineLength(HttpMessage httpmessage)
        throws HttpException
    {
        Header header;
        Args.notNull(httpmessage, "HTTP message");
        header = httpmessage.getFirstHeader("Transfer-Encoding");
        if (header == null) goto _L2; else goto _L1
_L1:
        int i;
        long l1;
        try
        {
            httpmessage = header.getElements();
        }
        // Misplaced declaration of an exception variable
        catch (HttpMessage httpmessage)
        {
            throw new ProtocolException((new StringBuilder()).append("Invalid Transfer-Encoding header value: ").append(header).toString(), httpmessage);
        }
        i = httpmessage.length;
        if (!"identity".equalsIgnoreCase(header.getValue())) goto _L4; else goto _L3
_L3:
        l1 = -1L;
_L9:
        return l1;
_L4:
        return i <= 0 || !"chunked".equalsIgnoreCase(httpmessage[i - 1].getName()) ? -1L : -2L;
_L2:
        if (httpmessage.getFirstHeader("Content-Length") == null) goto _L6; else goto _L5
_L5:
        l1 = -1L;
        httpmessage = httpmessage.getHeaders("Content-Length");
        i = httpmessage.length - 1;
_L7:
        long l;
        l = l1;
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_164;
        }
        header = httpmessage[i];
        l = Long.parseLong(header.getValue());
        l1 = l;
        if (l < 0L)
        {
            return -1L;
        }
        continue; /* Loop/switch isn't completed */
        NumberFormatException numberformatexception;
        numberformatexception;
        i--;
        if (true) goto _L7; else goto _L6
_L6:
        return (long)implicitLen;
        if (true) goto _L9; else goto _L8
_L8:
    }

}
