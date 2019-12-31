// 
// Decompiled by Procyon v0.5.36
// 

package listenerFrameDoc;

import frameFunzionali.FrameCreaPaziente;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import oggetti.Medico;
import java.awt.event.MouseListener;

public class ClickApreFrameNuovoPaziente implements MouseListener
{
    private Medico medico;
    private JFrame frame;
    
    public ClickApreFrameNuovoPaziente(final JFrame frame, final Medico medico) {
        this.medico = medico;
        this.frame = frame;
    }
    
    @Override
    public void mouseClicked(final MouseEvent e) {
        if (e.getButton() == 1) {
            final FrameCreaPaziente frameCrea = new FrameCreaPaziente(this.frame, this.medico);
            frameCrea.setVisible(true);
        }
    }
    
    @Override
    public void mouseEntered(final MouseEvent e) {
    }
    
    @Override
    public void mouseExited(final MouseEvent e) {
    }
    
    @Override
    public void mousePressed(final MouseEvent e) {
    }
    
    @Override
    public void mouseReleased(final MouseEvent e) {
    }
}
