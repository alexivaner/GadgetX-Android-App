// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.http.message;

import java.util.NoSuchElementException;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.ParseException;
import org.apache.http.TokenIterator;
import org.apache.http.util.Args;

public class BasicTokenIterator
    implements TokenIterator
{

    public static final String HTTP_SEPARATORS = " ,;=()<>@:\\\"/[]?{}\t";
    protected String currentHeader;
    protected String currentToken;
    protected final HeaderIterator headerIt;
    protected int searchPos;

    public BasicTokenIterator(HeaderIterator headeriterator)
    {
        headerIt = (HeaderIterator)Args.notNull(headeriterator, "Header iterator");
        searchPos = findNext(-1);
    }

    protected String createToken(String s, int i, int j)
    {
        return s.substring(i, j);
    }

    protected int findNext(int i)
        throws ParseException
    {
        if (i < 0)
        {
            if (!headerIt.hasNext())
            {
                return -1;
            }
            currentHeader = headerIt.nextHeader().getValue();
            i = 0;
        } else
        {
            i = findTokenSeparator(i);
        }
        i = findTokenStart(i);
        if (i < 0)
        {
            currentToken = null;
            return -1;
        } else
        {
            int j = findTokenEnd(i);
            currentToken = createToken(currentHeader, i, j);
            return j;
        }
    }

    protected int findTokenEnd(int i)
    {
        Args.notNegative(i, "Search position");
        int j = currentHeader.length();
        for (i++; i < j && isTokenChar(currentHeader.charAt(i)); i++) { }
        return i;
    }

    protected int findTokenSeparator(int i)
    {
        i = Args.notNegative(i, "Search position");
        boolean flag = false;
        for (int j = currentHeader.length(); !flag && i < j;)
        {
            char c = currentHeader.charAt(i);
            if (isTokenSeparator(c))
            {
                flag = true;
            } else
            if (isWhitespace(c))
            {
                i++;
            } else
            if (isTokenChar(c))
            {
                throw new ParseException((new StringBuilder()).append("Tokens without separator (pos ").append(i).append("): ").append(currentHeader).toString());
            } else
            {
                throw new ParseException((new StringBuilder()).append("Invalid character after token (pos ").append(i).append("): ").append(currentHeader).toString());
            }
        }

        return i;
    }

    protected int findTokenStart(int i)
    {
        i = Args.notNegative(i, "Search position");
        boolean flag1 = false;
        do
        {
            if (flag1 || currentHeader == null)
            {
                break;
            }
            int k = currentHeader.length();
            int j = i;
            boolean flag;
            for (flag = flag1; !flag && j < k;)
            {
                char c = currentHeader.charAt(j);
                if (isTokenSeparator(c) || isWhitespace(c))
                {
                    j++;
                } else
                if (isTokenChar(currentHeader.charAt(j)))
                {
                    flag = true;
                } else
                {
                    throw new ParseException((new StringBuilder()).append("Invalid character before token (pos ").append(j).append("): ").append(currentHeader).toString());
                }
            }

            flag1 = flag;
            i = j;
            if (!flag)
            {
                if (headerIt.hasNext())
                {
                    currentHeader = headerIt.nextHeader().getValue();
                    i = 0;
                    flag1 = flag;
                } else
                {
                    currentHeader = null;
                    flag1 = flag;
                    i = j;
                }
            }
        } while (true);
        if (flag1)
        {
            return i;
        } else
        {
            return -1;
        }
    }

    public boolean hasNext()
    {
        return currentToken != null;
    }

    protected boolean isHttpSeparator(char c)
    {
        return " ,;=()<>@:\\\"/[]?{}\t".indexOf(c) >= 0;
    }

    protected boolean isTokenChar(char c)
    {
        if (!Character.isLetterOrDigit(c))
        {
            if (Character.isISOControl(c))
            {
                return false;
            }
            if (isHttpSeparator(c))
            {
                return false;
            }
        }
        return true;
    }

    protected boolean isTokenSeparator(char c)
    {
        return c == ',';
    }

    protected boolean isWhitespace(char c)
    {
        return c == '\t' || Character.isSpaceChar(c);
    }

    public final Object next()
        throws NoSuchElementException, ParseException
    {
        return nextToken();
    }

    public String nextToken()
        throws NoSuchElementException, ParseException
    {
        if (currentToken == null)
        {
            throw new NoSuchElementException("Iteration already finished.");
        } else
        {
            String s = currentToken;
            searchPos = findNext(searchPos);
            return s;
        }
    }

    public final void remove()
        throws UnsupportedOperationException
    {
        throw new UnsupportedOperationException("Removing tokens is not supported.");
    }
}
