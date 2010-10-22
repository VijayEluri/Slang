/* This file was generated by SableCC (http://www.sablecc.org/). */

package glossaeditor.export.htmlgenerator.node;

import glossaeditor.export.htmlgenerator.analysis.*;

@SuppressWarnings("nls")
public final class TDifferent extends Token
{
    public TDifferent()
    {
        super.setText("<>");
    }

    public TDifferent(int line, int pos)
    {
        super.setText("<>");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TDifferent(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTDifferent(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TDifferent text.");
    }
}