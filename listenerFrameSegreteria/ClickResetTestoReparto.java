// 
// Decompiled by Procyon v0.5.36
// 

package listenerFrameSegreteria;

import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.awt.event.MouseListener;

public class ClickResetTestoReparto implements MouseListener
{
    private JTextField textField;
    
    public ClickResetTestoReparto(final JTextField textField) {
        this.textField = textField;
    }
    
    @Override
    public void mouseClicked(final MouseEvent arg0) {
        if (arg0.getButton() == 1) {
            this.textField.setText("");
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
