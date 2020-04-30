// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.http.impl.io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.MessageConstraintException;
import org.apache.http.ParseException;
import org.apache.http.ProtocolException;
import org.apache.http.config.MessageConstraints;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.BasicLineParser;
import org.apache.http.message.LineParser;
import org.apache.http.params.HttpParamConfig;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

public abstract class AbstractMessageParser
    implements HttpMessageParser
{

    private static final int HEADERS = 1;
    private static final int HEAD_LINE = 0;
    private final List headerLines;
    protected final LineParser lineParser;
    private HttpMessage message;
    private final MessageConstraints messageConstraints;
    private final SessionInputBuffer sessionBuffer;
    private int state;

    public AbstractMessageParser(SessionInputBuffer sessioninputbuffer, LineParser lineparser, MessageConstraints messageconstraints)
    {
        sessionBuffer = (SessionInputBuffer)Args.notNull(sessioninputbuffer, "Session input buffer");
        if (lineparser == null)
        {
            lineparser = BasicLineParser.INSTANCE;
        }
        lineParser = lineparser;
        if (messageconstraints == null)
        {
            messageconstraints = MessageConstraints.DEFAULT;
        }
        messageConstraints = messageconstraints;
        headerLines = new ArrayList();
        state = 0;
    }

    public AbstractMessageParser(SessionInputBuffer sessioninputbuffer, LineParser lineparser, HttpParams httpparams)
    {
        Args.notNull(sessioninputbuffer, "Session input buffer");
        Args.notNull(httpparams, "HTTP parameters");
        sessionBuffer = sessioninputbuffer;
        messageConstraints = HttpParamConfig.getMessageConstraints(httpparams);
        if (lineparser == null)
        {
            lineparser = BasicLineParser.INSTANCE;
        }
        lineParser = lineparser;
        headerLines = new ArrayList();
        state = 0;
    }

    public static Header[] parseHeaders(SessionInputBuffer sessioninputbuffer, int i, int j, LineParser lineparser)
        throws HttpException, IOException
    {
        ArrayList arraylist = new ArrayList();
        if (lineparser == null)
        {
            lineparser = BasicLineParser.INSTANCE;
        }
        return parseHeaders(sessioninputbuffer, i, j, lineparser, ((List) (arraylist)));
    }

    public static Header[] parseHeaders(SessionInputBuffer sessioninputbuffer, int i, int j, LineParser lineparser, List list)
        throws HttpException, IOException
    {
        CharArrayBuffer chararraybuffer1;
        CharArrayBuffer chararraybuffer2;
        Args.notNull(sessioninputbuffer, "Session input buffer");
        Args.notNull(lineparser, "Line parser");
        Args.notNull(list, "Header line list");
        chararraybuffer1 = null;
        chararraybuffer2 = null;
_L2:
        CharArrayBuffer chararraybuffer;
        if (chararraybuffer1 == null)
        {
            chararraybuffer = new CharArrayBuffer(64);
        } else
        {
            chararraybuffer1.clear();
            chararraybuffer = chararraybuffer1;
        }
        if (sessioninputbuffer.readLine(chararraybuffer) == -1 || chararraybuffer.length() < 1)
        {
            sessioninputbuffer = new Header[list.size()];
            i = 0;
            while (i < list.size()) 
            {
                chararraybuffer = (CharArrayBuffer)list.get(i);
                CharArrayBuffer chararraybuffer3;
                int k;
                char c;
                try
                {
                    sessioninputbuffer[i] = lineparser.parseHeader(chararraybuffer);
                }
                // Misplaced declaration of an exception variable
                catch (SessionInputBuffer sessioninputbuffer)
                {
                    throw new ProtocolException(sessioninputbuffer.getMessage());
                }
                i++;
            }
            break MISSING_BLOCK_LABEL_340;
        }
        if (chararraybuffer.charAt(0) != ' ' && chararraybuffer.charAt(0) != '\t' || chararraybuffer2 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        k = 0;
label0:
        do
        {
label1:
            {
                if (k < chararraybuffer.length())
                {
                    c = chararraybuffer.charAt(k);
                    if (c == ' ' || c == '\t')
                    {
                        break label1;
                    }
                }
                if (j > 0 && (chararraybuffer2.length() + 1 + chararraybuffer.length()) - k > j)
                {
                    throw new MessageConstraintException("Maximum line length limit exceeded");
                }
                break label0;
            }
            k++;
        } while (true);
        chararraybuffer2.append(' ');
        chararraybuffer2.append(chararraybuffer, k, chararraybuffer.length() - k);
        chararraybuffer3 = chararraybuffer2;
_L3:
        chararraybuffer1 = chararraybuffer;
        chararraybuffer2 = chararraybuffer3;
        if (i > 0)
        {
            chararraybuffer1 = chararraybuffer;
            chararraybuffer2 = chararraybuffer3;
            if (list.size() >= i)
            {
                throw new MessageConstraintException("Maximum header count exceeded");
            }
        }
        if (true) goto _L2; else goto _L1
_L1:
        list.add(chararraybuffer);
        chararraybuffer3 = chararraybuffer;
        chararraybuffer = null;
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
        return sessioninputbuffer;
    }

    public HttpMessage parse()
        throws IOException, HttpException
    {
        switch (state)
        {
        default:
            throw new IllegalStateException("Inconsistent parser state");

        case 0: // '\0'
            Header aheader[];
            HttpMessage httpmessage;
            try
            {
                message = parseHead(sessionBuffer);
            }
            catch (ParseException parseexception)
            {
                throw new ProtocolException(parseexception.getMessage(), parseexception);
            }
            state = 1;
            // fall through

        case 1: // '\001'
            aheader = parseHeaders(sessionBuffer, messageConstraints.getMaxHeaderCount(), messageConstraints.getMaxLineLength(), lineParser, headerLines);
            message.setHeaders(aheader);
            httpmessage = message;
            message = null;
            headerLines.clear();
            state = 0;
            return httpmessage;
        }
    }

    protected abstract HttpMessage parseHead(SessionInputBuffer sessioninputbuffer)
        throws IOException, HttpException, ParseException;
}
