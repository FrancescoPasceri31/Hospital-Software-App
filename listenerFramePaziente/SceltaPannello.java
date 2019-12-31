// 
// Decompiled by Procyon v0.5.36
// 

package listenerFramePaziente;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.event.MouseListener;

public class SceltaPannello implements MouseListener
{
    private JPanel panel_1;
    private CardLayout cardLayout;
    private boolean cambioCard;
    
    public SceltaPannello(final CardLayout cardLayout, final JPanel panel_1, final boolean cambioCard) {
        this.panel_1 = panel_1;
        this.cardLayout = cardLayout;
        this.cambioCard = cambioCard;
    }
    
    @Override
    public void mouseClicked(final MouseEvent arg0) {
        if (arg0.getButton() == 1) {
            if (this.cambioCard) {
                this.cardLayout.previous(this.panel_1);
            }
            else {
                this.cardLayout.next(this.panel_1);
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
