// 
// Decompiled by Procyon v0.5.36
// 

package listenerFrameSegreteria;

import java.util.Iterator;
import java.util.ArrayList;
import frameFunzionali.WindowCreato;
import frameFunzionali.WindowNonEsiste;
import oggetti.Medico;
import avvio.App;
import oggetti.Segreteria;
import utility.ControlloStringhe;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import calendar.JDateChooser;
import oggetti.Reparto;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseListener;

public class AscoltatoreCreaMedico implements MouseListener
{
    private JButton salva;
    private JTextField nome;
    private JTextField cognome;
    private JTextField codFiscale;
    private JComboBox<String> sessoScelta;
    private JComboBox<Reparto> reparto;
    private JDateChooser data;
    private JFrame frame;
    
    public AscoltatoreCreaMedico(final JButton btnSalva, final JTextField nomeText, final JTextField cognomeText, final JDateChooser dataText, final JComboBox<String> sessoText, final JTextField codFiscaleText, final JComboBox<Reparto> repartoText, final JFrame frame) {
        this.nome = nomeText;
        this.cognome = cognomeText;
        this.reparto = repartoText;
        this.sessoScelta = sessoText;
        this.codFiscale = codFiscaleText;
        this.data = dataText;
        this.salva = btnSalva;
        this.frame = frame;
    }
    
    @Override
    public void mouseClicked(final MouseEvent arg0) {
        final String patternCodFiscale = "[a-zA-Z]{6}\\d\\d[a-zA-Z]\\d\\d[a-zA-Z]\\d\\d\\d[a-zA-Z]";
        if (arg0.getButton() == 1) {
            try {
                Reparto repo = null;
                boolean repartoInLista = false;
                final String nomeS = this.nome.getText();
                final String cognomeS = this.cognome.getText();
                final String codFiscaleS = this.codFiscale.getText();
                final String sessoS = (String)this.sessoScelta.getSelectedItem();
                final String repartoS = ((Reparto)this.reparto.getSelectedItem()).getNomeReparto();
                final String dataS = ((JTextField)this.data.getDateEditor().getUiComponent()).getText();
                if (ControlloStringhe.controllaCodFiscale(nomeS, cognomeS, codFiscaleS, dataS, sessoS)) {
                    int i = 0;
                    Label_0162: {
                        break Label_0162;
                        int j;
                        do {
                            final Segreteria segreteria = App.segreteria;
                            if (Segreteria.getListaReparti().get(i).getNomeReparto().equalsIgnoreCase(repartoS)) {
                                repartoInLista = true;
                                final Segreteria segreteria2 = App.segreteria;
                                repo = Segreteria.getListaReparti().get(i);
                            }
                            ++i;
                            j = i;
                            final Segreteria segreteria3 = App.segreteria;
                        } while (j < Segreteria.getListaReparti().size());
                    }
                    if (repartoInLista) {
                        repo.deserializzazioneArrayListMedico();
                        final ArrayList<Medico> listaCopia = repo.getListaMedici();
                        boolean medicoGiaPresente = false;
                        for (final Medico medico : listaCopia) {
                            if (medico.getCodFiscale().equalsIgnoreCase(codFiscaleS) && medico.getNome().equalsIgnoreCase(nomeS) && medico.getCognome().equalsIgnoreCase(cognomeS) && medico.getDataDiNascita().equalsIgnoreCase(dataS)) {
                                medicoGiaPresente = true;
                                break;
                            }
                        }
                        if (medicoGiaPresente) {
                            new WindowNonEsiste(" Medico ", "giaEsiste").setVisible(true);
                        }
                        else {
                            final Medico m1 = new Medico(nomeS, cognomeS, sessoS, codFiscaleS, dataS, repo);
                            new WindowCreato("Medico", this.frame);
                        }
                    }
                    else {
                        new WindowNonEsiste(" Reparto ");
                    }
                }
                else {
                    new WindowNonEsiste(" Codice fiscale ");
                }
            }
            catch (Exception ex) {}
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
