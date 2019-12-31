// 
// Decompiled by Procyon v0.5.36
// 

package listenerFrameDoc;

import frameFunzionali.FrameModificaPaziente;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import oggetti.Medico;
import javax.swing.JWindow;
import oggetti.Paziente;
import java.awt.event.MouseListener;

public class ClickPerModificarePaziente implements MouseListener
{
    private Paziente p;
    private JWindow w;
    private Medico medico;
    private JFrame frame;
    
    public ClickPerModificarePaziente(final Paziente p, final JWindow w, final JFrame frame, final Medico medico) {
        this.p = p;
        this.w = w;
        this.frame = frame;
        this.medico = medico;
    }
    
    @Override
    public void mouseClicked(final MouseEvent arg0) {
        if (arg0.getButton() == 1) {
            this.w.dispose();
            new FrameModificaPaziente(this.p, this.frame, this.medico).setVisible(true);
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
