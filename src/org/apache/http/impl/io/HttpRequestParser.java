// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.http.impl.io;

import java.io.IOException;
import org.apache.http.ConnectionClosedException;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.HttpRequestFactory;
import org.apache.http.ParseException;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.LineParser;
import org.apache.http.message.ParserCursor;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

// Referenced classes of package org.apache.http.impl.io:
//            AbstractMessageParser

public class HttpRequestParser extends AbstractMessageParser
{

    private final CharArrayBuffer lineBuf = new CharArrayBuffer(128);
    private final HttpRequestFactory requestFactory;

    public HttpRequestParser(SessionInputBuffer sessioninputbuffer, LineParser lineparser, HttpRequestFactory httprequestfactory, HttpParams httpparams)
    {
        super(sessioninputbuffer, lineparser, httpparams);
        requestFactory = (HttpRequestFactory)Args.notNull(httprequestfactory, "Request factory");
    }

    protected HttpMessage parseHead(SessionInputBuffer sessioninputbuffer)
        throws IOException, HttpException, ParseException
    {
        lineBuf.clear();
        if (sessioninputbuffer.readLine(lineBuf) == -1)
        {
            throw new ConnectionClosedException("Client closed connection");
        } else
        {
            sessioninputbuffer = new ParserCursor(0, lineBuf.length());
            sessioninputbuffer = lineParser.parseRequestLine(lineBuf, sessioninputbuffer);
            return requestFactory.newHttpRequest(sessioninputbuffer);
        }
    }
}
