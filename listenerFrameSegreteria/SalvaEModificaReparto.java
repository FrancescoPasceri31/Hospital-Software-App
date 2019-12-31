// 
// Decompiled by Procyon v0.5.36
// 

package listenerFrameSegreteria;

import frameFunzionali.WindowCreato;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import oggetti.Reparto;
import javax.swing.JTextField;
import java.awt.event.MouseListener;

public class SalvaEModificaReparto implements MouseListener
{
    private JTextField textField;
    private Reparto reparto;
    private JFrame frame;
    
    public SalvaEModificaReparto(final JTextField textField, final Reparto reparto, final JFrame frame) {
        this.textField = textField;
        this.reparto = reparto;
        this.frame = frame;
    }
    
    @Override
    public void mouseClicked(final MouseEvent arg0) {
        if (arg0.getButton() == 1) {
            this.reparto.setNomeReparto(this.textField.getText());
            new WindowCreato("Reparto", 0, this.frame);
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
