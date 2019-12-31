// 
// Decompiled by Procyon v0.5.36
// 

package listenerFrameSegreteria;

import frameFunzionali.FrameModificaMedico;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JTable;
import frameFunzionali.WindowModificaRimuoviAnnullaMedico;
import oggetti.Medico;
import java.awt.event.MouseListener;

public class ClickPerAprireFrameModificaMedico implements MouseListener
{
    private Medico medico;
    private WindowModificaRimuoviAnnullaMedico windowDaChiudere;
    private JTable table;
    private JFrame frame;
    
    public ClickPerAprireFrameModificaMedico(final Medico medico, final WindowModificaRimuoviAnnullaMedico windowDaChiudere, final JTable table, final JFrame frame) {
        this.table = table;
        this.medico = medico;
        this.windowDaChiudere = windowDaChiudere;
        this.frame = frame;
    }
    
    @Override
    public void mouseClicked(final MouseEvent e) {
        if (e.getButton() == 1) {
            this.windowDaChiudere.dispose();
            new FrameModificaMedico(this.medico, this.table, this.frame).setVisible(true);
        }
    }
    
    @Override
    public void mousePressed(final MouseEvent e) {
    }
    
    @Override
    public void mouseReleased(final MouseEvent e) {
    }
    
    @Override
    public void mouseEntered(final MouseEvent e) {
    }
    
    @Override
    public void mouseExited(final MouseEvent e) {
    }
}
