// 
// Decompiled by Procyon v0.5.36
// 

package listenerFrameSegreteria;

import frameFunzionali.WindowRimosso;
import avvio.App;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JTable;
import frameFunzionali.WindowModificaRimuoviAnnullaMedico;
import oggetti.Medico;
import java.awt.event.MouseListener;

public class ClickPerRimuovereMedico implements MouseListener
{
    private Medico medico;
    private WindowModificaRimuoviAnnullaMedico windowDaChiudere;
    private JTable table;
    private JFrame frame;
    
    public ClickPerRimuovereMedico(final Medico medico, final WindowModificaRimuoviAnnullaMedico windowModificaRimuoviAnnullaMedico, final JTable table, final JFrame frame) {
        this.frame = frame;
        this.table = table;
        this.medico = medico;
        this.windowDaChiudere = windowModificaRimuoviAnnullaMedico;
    }
    
    @Override
    public void mouseClicked(final MouseEvent arg0) {
        if (arg0.getButton() == 1) {
            this.medico.getTipoReparto().rimuoviMedicoDaLista(this.medico);
            App.login.getMappaLoginMedico().remove(this.medico.getCodFiscale());
            App.login.serializzaMappaLoginMedico(App.login.getMappaLoginMedico());
            this.windowDaChiudere.dispose();
            new WindowRimosso("Medico", this.frame).setVisible(true);
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
