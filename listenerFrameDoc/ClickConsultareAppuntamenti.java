// 
// Decompiled by Procyon v0.5.36
// 

package listenerFrameDoc;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import frame.FrameDoc;
import javax.swing.JPanel;
import java.awt.event.ActionListener;

public class ClickConsultareAppuntamenti implements ActionListener
{
    private JPanel panelInCuiInserire;
    private FrameDoc frameDoc;
    private CardLayout cardLayout;
    
    public ClickConsultareAppuntamenti(final JPanel panelInCuiInserire, final FrameDoc frameDoc, final CardLayout cardLayout) {
        this.frameDoc = frameDoc;
        this.panelInCuiInserire = panelInCuiInserire;
        this.cardLayout = cardLayout;
    }
    
    @Override
    public void actionPerformed(final ActionEvent arg0) {
        if (arg0.getModifiers() == 16 && !this.frameDoc.getBooleanNotificheVisibili()) {
            this.cardLayout.next(this.panelInCuiInserire);
            this.frameDoc.setBooleanNotificheVisibili(true);
        }
    }
}
