// 
// Decompiled by Procyon v0.5.36
// 

package listenerFrameSegreteria;

import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.awt.event.MouseListener;

public class AscoltatoreResetMedico implements MouseListener
{
    private JTextField a;
    private JTextField b;
    private JTextField c;
    
    public AscoltatoreResetMedico(final JTextField nomeText, final JTextField cognomeText, final JTextField codFiscaleText) {
        this.a = nomeText;
        this.b = cognomeText;
        this.c = codFiscaleText;
    }
    
    @Override
    public void mouseClicked(final MouseEvent e) {
        if (e.getButton() == 1) {
            this.a.setText("");
            this.b.setText("");
            this.c.setText("");
        }
    }
    
    @Override
    public void mousePressed(final MouseEvent e) {
    }
    
    @Override
    public void mouseReleased(final MouseEvent e) {
    }
    
    @Override
    public void mouseEntered(final MouseEvent e) {
    }
    
    @Override
    public void mouseExited(final MouseEvent e) {
    }
}
