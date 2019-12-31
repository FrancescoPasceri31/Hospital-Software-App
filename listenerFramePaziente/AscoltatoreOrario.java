// 
// Decompiled by Procyon v0.5.36
// 

package listenerFramePaziente;

import frameFunzionali.FrameRicordaNonEsistenzaOrario;
import frame.FrameOrario;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import oggetti.Reparto;
import java.awt.event.MouseListener;

public class AscoltatoreOrario implements MouseListener
{
    Reparto reparto;
    JButton j;
    
    public AscoltatoreOrario(final JButton j, final Reparto reparto) {
        this.reparto = reparto;
        this.j = j;
    }
    
    @Override
    public void mouseClicked(final MouseEvent e) {
        if (e.getButton() == 1) {
            if (this.reparto.getOrario() != null) {
                final FrameOrario orario = new FrameOrario(this.reparto.getOrario());
            }
            else {
                new FrameRicordaNonEsistenzaOrario().setVisible(true);
            }
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
