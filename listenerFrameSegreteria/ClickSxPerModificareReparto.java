// 
// Decompiled by Procyon v0.5.36
// 

package listenerFrameSegreteria;

import frameFunzionali.FrameModificaReparto;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JWindow;
import oggetti.Reparto;
import java.awt.event.MouseListener;

public class ClickSxPerModificareReparto implements MouseListener
{
    private Reparto reparto;
    private JWindow windowDaChiudere;
    private JTable table;
    private JFrame frame;
    
    public ClickSxPerModificareReparto(final Reparto reparto, final JWindow windowDaChiudere, final JTable table, final JFrame frame) {
        this.reparto = reparto;
        this.windowDaChiudere = windowDaChiudere;
        this.table = table;
        this.frame = frame;
    }
    
    @Override
    public void mouseClicked(final MouseEvent arg0) {
        if (arg0.getButton() == 1) {
            this.windowDaChiudere.dispose();
            new FrameModificaReparto(this.reparto, this.frame).setVisible(true);
            this.table.repaint();
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
