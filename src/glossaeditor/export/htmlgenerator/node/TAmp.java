/* This file was generated by SableCC (http://www.sablecc.org/). */

package glossaeditor.export.htmlgenerator.node;

import glossaeditor.export.htmlgenerator.analysis.*;

@SuppressWarnings("nls")
public final class TAmp extends Token
{
    public TAmp()
    {
        super.setText("&");
    }

    public TAmp(int line, int pos)
    {
        super.setText("&");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TAmp(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTAmp(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TAmp text.");
    }
}
