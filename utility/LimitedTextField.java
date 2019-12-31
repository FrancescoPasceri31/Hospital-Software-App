// 
// Decompiled by Procyon v0.5.36
// 

package utility;

import javax.swing.text.BadLocationException;
import javax.swing.text.AttributeSet;
import javax.swing.text.PlainDocument;

public class LimitedTextField extends PlainDocument
{
    private StringBuffer cache;
    private int lunghezzaMax;
    
    public LimitedTextField(final int lunghezzaMax) {
        this.cache = new StringBuffer();
        this.lunghezzaMax = lunghezzaMax;
    }
    
    @Override
    public void insertString(final int off, final String s, final AttributeSet aset) {
        final int len = this.getLength();
        if (len >= this.lunghezzaMax) {
            return;
        }
        this.cache.setLength(0);
        for (int i = 0; i < s.length(); ++i) {
            final char c = s.charAt(i);
            this.cache.append(c);
            if (this.cache.length() >= this.lunghezzaMax - len) {
                break;
            }
        }
        if (this.cache.length() > 0) {
            try {
                super.insertString(off, this.cache.toString(), aset);
            }
            catch (BadLocationException e) {
                e.printStackTrace();
            }
        }
    }
}
