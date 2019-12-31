// 
// Decompiled by Procyon v0.5.36
// 

package listenerFrameDoc;

import java.util.ArrayList;
import frameFunzionali.WindowCreato;
import frameFunzionali.WindowNonEsiste;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import oggetti.Medico;
import utility.Appuntamento;
import oggetti.Reparto;
import javax.swing.JTextField;
import java.awt.event.MouseListener;

public class ClickPerSalvareAppuntamentoModificato implements MouseListener
{
    private JTextField tipologia;
    private Reparto reparto;
    private String data;
    private String paziente_cf;
    private Appuntamento appuntamento;
    private Medico medico;
    private JFrame frame;
    
    public ClickPerSalvareAppuntamentoModificato(final Appuntamento appuntamento, final String paziente_cf, final JTextField tipologia, final String data, final Reparto reparto, final JFrame frame, final Medico medico) {
        this.appuntamento = appuntamento;
        this.paziente_cf = paziente_cf;
        this.tipologia = tipologia;
        this.data = data;
        this.reparto = reparto;
        this.medico = medico;
        this.frame = frame;
    }
    
    @Override
    public void mouseClicked(final MouseEvent arg0) {
        if (arg0.getButton() == 1) {
            if (this.tipologia.getText().trim().isEmpty()) {
                new WindowNonEsiste("Inserimento ").setVisible(true);
                return;
            }
            this.reparto.deserializzazioneArrayListAppuntamento();
            final ArrayList<Appuntamento> ListaApp = this.reparto.getListaAppuntamento();
            for (int i = 0; i < ListaApp.size(); ++i) {
                if (ListaApp.get(i).getCodFiscalePaziente().equalsIgnoreCase(this.appuntamento.getCodFiscalePaziente()) && ListaApp.get(i).getData().equalsIgnoreCase(this.appuntamento.getData()) && ListaApp.get(i).getTipologia().equalsIgnoreCase(this.appuntamento.getTipologia())) {
                    ListaApp.get(i).setData(this.data);
                    ListaApp.get(i).setTipoVisita(this.tipologia.getText());
                    this.reparto.serializzaArrayListAppuntamento(ListaApp);
                    new WindowCreato("Appuntamento", 0, this.frame, this.medico);
                }
            }
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
