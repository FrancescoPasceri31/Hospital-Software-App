// 
// Decompiled by Procyon v0.5.36
// 

package listenerFrameSegreteria;

import frameFunzionali.WindowModificaRimuoviAnnullaMedico;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JTable;
import oggetti.Medico;
import java.awt.event.MouseListener;

public class ClickPerAprireWindowPerModificareMedico implements MouseListener
{
    private Medico medico;
    private JTable table;
    private JFrame frame;
    
    public ClickPerAprireWindowPerModificareMedico(final Medico preso1, final JTable table, final JFrame frame) {
        this.frame = frame;
        this.table = table;
        this.medico = preso1;
    }
    
    @Override
    public void mouseClicked(final MouseEvent e) {
        if (e.getButton() == 1) {
            new WindowModificaRimuoviAnnullaMedico(this.medico, this.table, this.frame).setVisible(true);
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
