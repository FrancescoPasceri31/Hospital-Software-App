// 
// Decompiled by Procyon v0.5.36
// 

package listenerFrameSegreteria;

import frameFunzionali.WindowRimosso;
import avvio.App;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JTable;
import frameFunzionali.WindowModificaRimuoviAnnullaReparto;
import oggetti.Reparto;
import java.awt.event.MouseListener;

public class ClickSxPerEliminareReparto implements MouseListener
{
    private Reparto reparto;
    private WindowModificaRimuoviAnnullaReparto windowDaChiudere;
    private JTable table;
    private JFrame frame;
    
    public ClickSxPerEliminareReparto(final Reparto reparto, final WindowModificaRimuoviAnnullaReparto windowDaChiudere, final JTable table, final JFrame frame) {
        this.table = table;
        this.reparto = reparto;
        this.windowDaChiudere = windowDaChiudere;
        this.frame = frame;
    }
    
    @Override
    public void mouseClicked(final MouseEvent arg0) {
        if (arg0.getButton() == 1) {
            App.segreteria.rimuoviRepartoDaLista(this.reparto);
            this.windowDaChiudere.dispose();
            new WindowRimosso("Reparto", this.frame).setVisible(true);
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
