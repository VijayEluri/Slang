/* This file was generated by SableCC (http://www.sablecc.org/). */

package glossaeditor.export.htmlgenerator.node;

import glossaeditor.export.htmlgenerator.analysis.*;

@SuppressWarnings("nls")
public final class TKeyword extends Token
{
    public TKeyword(String text)
    {
        setText(text);
    }

    public TKeyword(String text, int line, int pos)
    {
        setText(text);
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TKeyword(getText(), getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTKeyword(this);
    }
}
