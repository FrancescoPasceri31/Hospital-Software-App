// 
// Decompiled by Procyon v0.5.36
// 

package listenerFrameDoc;

import frameFunzionali.WindowCreato;
import utility.Appuntamento;
import frameFunzionali.WindowNonEsiste;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import oggetti.Medico;
import oggetti.Reparto;
import javax.swing.JTextField;
import java.awt.event.MouseListener;

public class ClickSalvaAppuntamento implements MouseListener
{
    private JTextField data;
    private JTextField tipologia;
    private Reparto r;
    private String paziente_cf;
    private Medico medico;
    private JFrame frame;
    
    public ClickSalvaAppuntamento(final String paziente_cf, final JTextField tipologia, final JTextField data, final Reparto r, final JFrame frame, final Medico medico) {
        this.tipologia = tipologia;
        this.paziente_cf = paziente_cf;
        this.data = data;
        this.r = r;
        this.medico = medico;
        this.frame = frame;
    }
    
    @Override
    public void mouseClicked(final MouseEvent arg0) {
        if (arg0.getButton() == 1) {
            if (this.tipologia.getText().trim().isEmpty() || this.data.getText().trim().isEmpty()) {
                new WindowNonEsiste("Inserimento ").setVisible(true);
                return;
            }
            new Appuntamento(this.data.getText(), this.paziente_cf, this.r, this.tipologia.getText());
            new WindowCreato("Appuntamento", this.frame, this.medico);
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
