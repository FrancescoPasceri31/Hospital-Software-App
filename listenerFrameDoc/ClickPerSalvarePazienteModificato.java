// 
// Decompiled by Procyon v0.5.36
// 

package listenerFrameDoc;

import listenerFrameCartellaClinica.FrameCartellaClinicaModel;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.ArrayList;
import frameFunzionali.WindowCreato;
import oggetti.Segreteria;
import java.util.Map;
import java.io.File;
import utility.ControlloOs;
import avvio.App;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import oggetti.Medico;
import oggetti.Paziente;
import oggetti.Reparto;
import javax.swing.JComboBox;
import calendar.JDateChooser;
import javax.swing.JTextField;
import java.awt.event.MouseListener;

public class ClickPerSalvarePazienteModificato implements MouseListener
{
    private JTextField nomeText;
    private JTextField codFiscaleText;
    private JTextField cognomeText;
    private JDateChooser data;
    private JComboBox<String> sesso;
    private Reparto reparto;
    private Paziente paz;
    private Medico medico;
    private JFrame frameDoc;
    
    public ClickPerSalvarePazienteModificato(final Paziente paz, final JTextField nomeText, final JTextField codFiscaleText, final JTextField cognomeText, final JDateChooser dateChooser, final JComboBox<String> comboBoxSesso, final Reparto reparto, final JFrame frame, final Medico medico) {
        this.nomeText = nomeText;
        this.codFiscaleText = codFiscaleText;
        this.cognomeText = cognomeText;
        this.data = dateChooser;
        this.sesso = comboBoxSesso;
        this.reparto = reparto;
        this.paz = paz;
        this.medico = medico;
        this.frameDoc = frame;
    }
    
    @Override
    public void mouseClicked(final MouseEvent arg0) {
        if (arg0.getButton() == 1) {
            this.reparto.deserializzazioneArrayListPaziente();
            App.login.deserializzaMappaLoginPaziente();
            final ArrayList<Paziente> copiaListaTmp = this.reparto.getListaPazienti();
            final TreeMap<String, Paziente> copiaLoginTmp = App.login.getMappaLoginPaziente();
            for (int i = 0; i < copiaListaTmp.size(); ++i) {
                if (copiaListaTmp.get(i).getCodFiscale().equalsIgnoreCase(this.paz.getCodFiscale())) {
                    final String codFiscaleVecchio = this.paz.getCodFiscale();
                    copiaListaTmp.get(i).setNome(this.nomeText.getText());
                    copiaListaTmp.get(i).setCognome(this.cognomeText.getText());
                    copiaListaTmp.get(i).setCodFiscale(this.codFiscaleText.getText());
                    copiaListaTmp.get(i).setDataDiNascita(((JTextField)this.data.getDateEditor().getUiComponent()).getText());
                    copiaListaTmp.get(i).setGender((String)this.sesso.getSelectedItem());
                    final String pathCc = String.valueOf(ControlloOs.controlloOs()) + "Ospedale//" + this.reparto.getNomeReparto() + "//" + codFiscaleVecchio;
                    final File ccVecchia = new File(pathCc);
                    final File ccNuova = new File(String.valueOf(ControlloOs.controlloOs()) + "Ospedale//" + this.reparto.getNomeReparto() + "//" + this.codFiscaleText.getText());
                    final boolean rename = ccVecchia.renameTo(ccNuova);
                    this.cambiaFrameCc(copiaListaTmp.get(i));
                    for (final Map.Entry<String, Paziente> entry : copiaLoginTmp.entrySet()) {
                        if (entry.getKey().equalsIgnoreCase(this.paz.getCodFiscale())) {
                            copiaLoginTmp.remove(entry.getKey());
                            copiaLoginTmp.put(this.codFiscaleText.getText(), this.reparto.getListaPazienti().get(i));
                            break;
                        }
                    }
                    App.segreteria.deserializzaListaRepartiTrascorsi();
                    final Segreteria segreteria = App.segreteria;
                    final ArrayList<Paziente> copiaArchivio = Segreteria.getArchivioPazienti();
                    for (int j = 0; j < copiaArchivio.size(); ++j) {
                        if (copiaArchivio.get(j).getCodFiscale().equalsIgnoreCase(this.paz.getCodFiscale())) {
                            copiaArchivio.get(j).setNome(this.nomeText.getText());
                            copiaArchivio.get(j).setCognome(this.cognomeText.getText());
                            copiaArchivio.get(j).setCodFiscale(this.codFiscaleText.getText());
                            copiaArchivio.get(j).setDataDiNascita(((JTextField)this.data.getDateEditor().getUiComponent()).getText());
                            copiaArchivio.get(j).setGender((String)this.sesso.getSelectedItem());
                            break;
                        }
                    }
                    break;
                }
            }
            this.reparto.serializzaArrayListPaziente(copiaListaTmp);
            App.login.serializzaMappaLoginPaziente(copiaLoginTmp);
            new WindowCreato(" Paziente ", 0, this.frameDoc, this.medico);
        }
    }
    
    public void cambiaFrameCc(final Paziente paziente) {
        new FrameCartellaClinicaModel(paziente);
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
