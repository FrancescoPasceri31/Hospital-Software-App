// 
// Decompiled by Procyon v0.5.36
// 

package listenerFramePaziente;

import frame.FrameAppuntamento;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import oggetti.Paziente;
import java.awt.event.MouseListener;

public class AscoltatoreAppuntamento implements MouseListener
{
    Paziente p;
    JButton j;
    
    public AscoltatoreAppuntamento(final JButton j, final Paziente p) {
        this.p = p;
        this.j = j;
    }
    
    @Override
    public void mouseClicked(final MouseEvent e) {
        if (e.getButton() == 1) {
            new FrameAppuntamento(String.valueOf(this.p.getCodFiscale()), this.p.getTipoReparto()).setVisible(true);
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
