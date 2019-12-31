// 
// Decompiled by Procyon v0.5.36
// 

package listenerFrameDoc;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.CardLayout;
import frame.FrameDoc;
import javax.swing.JPanel;
import java.awt.event.MouseListener;

public class ClickReturnHome implements MouseListener
{
    private JPanel panel_Center;
    private FrameDoc frameDoc;
    private CardLayout cardLayout;
    
    public ClickReturnHome(final JPanel panel_Center, final FrameDoc frameDoc, final CardLayout cardLayout) {
        this.panel_Center = panel_Center;
        this.frameDoc = frameDoc;
        this.cardLayout = cardLayout;
    }
    
    @Override
    public void mouseClicked(final MouseEvent arg0) {
        if (arg0.getButton() == 1 && this.frameDoc.getBooleanNotificheVisibili()) {
            this.cardLayout.previous(this.panel_Center);
            this.frameDoc.setBooleanNotificheVisibili(false);
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
