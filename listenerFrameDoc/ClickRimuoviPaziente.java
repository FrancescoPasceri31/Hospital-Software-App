// 
// Decompiled by Procyon v0.5.36
// 

package listenerFrameDoc;

import java.util.Iterator;
import frameFunzionali.WindowRimosso;
import utility.Appuntamento;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import oggetti.Medico;
import javax.swing.JWindow;
import oggetti.Paziente;
import java.util.ArrayList;
import java.awt.event.MouseListener;

public class ClickRimuoviPaziente implements MouseListener
{
    private ArrayList<Paziente> listaPazienti;
    private Paziente paziente;
    private JWindow w;
    private Medico medico;
    private JFrame frame;
    
    public ClickRimuoviPaziente(final ArrayList<Paziente> listaPazienti, final Paziente paziente, final JWindow windowScelta, final JFrame frame, final Medico medico) {
        this.listaPazienti = listaPazienti;
        this.w = windowScelta;
        this.paziente = paziente;
        this.medico = medico;
        this.frame = frame;
    }
    
    @Override
    public void mouseClicked(final MouseEvent arg0) {
        if (arg0.getButton() == 1) {
            for (int i = 0; i < this.listaPazienti.size(); ++i) {
                this.w.dispose();
                for (final Paziente pazienteLista : this.listaPazienti) {
                    if (pazienteLista.equals(this.paziente)) {
                        for (final Appuntamento appuntamento : this.paziente.getTipoReparto().getListaAppuntamento()) {
                            if (this.paziente.getCodFiscale().equals(appuntamento.getCodFiscalePaziente())) {
                                this.paziente.getTipoReparto().rimuoviAppuntamentoDaLista(appuntamento);
                            }
                        }
                        this.paziente.getTipoReparto().rimuoviPazienteDaLista(this.paziente);
                        break;
                    }
                }
                this.listaPazienti.trimToSize();
                new WindowRimosso(" Paziente ", this.frame, this.medico).setVisible(true);
            }
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
