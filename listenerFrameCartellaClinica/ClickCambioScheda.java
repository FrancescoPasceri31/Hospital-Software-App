// 
// Decompiled by Procyon v0.5.36
// 

package listenerFrameCartellaClinica;

import java.awt.Container;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.io.Serializable;
import java.awt.event.MouseListener;

public class ClickCambioScheda implements MouseListener, Serializable
{
    private JPanel panel;
    private CardLayout cardLayout;
    private JList<String> list;
    
    public ClickCambioScheda(final CardLayout cardLayout, final JPanel panel_3, final JList<String> list) {
        this.list = list;
        this.cardLayout = cardLayout;
        this.panel = panel_3;
    }
    
    @Override
    public void mouseClicked(final MouseEvent e) {
        if (e.getButton() == 1) {
            final int numPg = this.list.locationToIndex(e.getPoint()) + 1;
            final String numPgToString = new StringBuilder().append(numPg).toString();
            this.cardLayout.show(this.panel, numPgToString);
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
