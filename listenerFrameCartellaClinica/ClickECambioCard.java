// 
// Decompiled by Procyon v0.5.36
// 

package listenerFrameCartellaClinica;

import java.awt.Container;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.io.Serializable;
import java.awt.event.MouseListener;

public class ClickECambioCard implements MouseListener, Serializable
{
    private int tipoPagina;
    private CardLayout cardLayout;
    private JPanel panel_1;
    
    public ClickECambioCard(final CardLayout cardLayout, final int tipoPagina, final JPanel panel_1) {
        this.cardLayout = cardLayout;
        this.tipoPagina = tipoPagina;
        this.panel_1 = panel_1;
    }
    
    @Override
    public void mouseClicked(final MouseEvent arg0) {
        if (arg0.getButton() == 1) {
            if (this.tipoPagina == 1) {
                this.cardLayout.show(this.panel_1, "1");
            }
            else if (this.tipoPagina == 2) {
                this.cardLayout.show(this.panel_1, "2");
            }
            else if (this.tipoPagina == 3) {
                this.cardLayout.show(this.panel_1, "3");
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
