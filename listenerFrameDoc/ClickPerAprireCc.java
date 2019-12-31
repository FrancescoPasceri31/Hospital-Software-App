// 
// Decompiled by Procyon v0.5.36
// 

package listenerFrameDoc;

import frame.FrameCartellaClinica;
import java.awt.event.MouseEvent;
import javax.swing.JWindow;
import oggetti.Paziente;
import java.io.Serializable;
import java.awt.event.MouseListener;

public class ClickPerAprireCc implements MouseListener, Serializable
{
    private Paziente p;
    private JWindow w;
    
    public ClickPerAprireCc(final Paziente p, final JWindow w) {
        this.p = p;
        this.w = w;
    }
    
    @Override
    public void mouseClicked(final MouseEvent arg0) {
        if (arg0.getButton() == 1) {
            this.w.dispose();
            final FrameCartellaClinica fcc = new FrameCartellaClinica(this.p.getTipoReparto(), this.p.getCodFiscale());
            fcc.setVisible(true);
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
