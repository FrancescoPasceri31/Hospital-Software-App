// 
// Decompiled by Procyon v0.5.36
// 

package listenerFrameDoc;

import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.awt.event.MouseListener;

public class ClickPerReset implements MouseListener
{
    JTextField a;
    JTextField b;
    JTextField c;
    JTextField d;
    
    public ClickPerReset(final JTextField textField, final JTextField textField_2, final JTextField textField_3, final JTextField textField_4) {
        this.a = textField;
        this.b = textField_2;
        this.c = textField_3;
        this.d = textField_4;
    }
    
    @Override
    public void mouseClicked(final MouseEvent arg0) {
        if (arg0.getButton() == 1) {
            this.a.setText("");
            this.b.setText("");
            this.c.setText("");
            this.d.setText("");
        }
    }
    
    @Override
    public void mouseEntered(final MouseEvent arg0) {
    }
    
    @Override
    public void mouseExited(final MouseEvent arg0) {
    }
    
    @Override
    public void mousePressed(final MouseEvent arg0) {
    }
    
    @Override
    public void mouseReleased(final MouseEvent arg0) {
    }
}
