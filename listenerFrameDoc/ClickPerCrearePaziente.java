// 
// Decompiled by Procyon v0.5.36
// 

package listenerFrameDoc;

import frameFunzionali.WindowNonEsiste;
import frameFunzionali.WindowCreato;
import oggetti.Paziente;
import utility.ControlloStringhe;
import java.awt.event.MouseEvent;
import oggetti.Medico;
import calendar.JDateChooser;
import javax.swing.JFrame;
import oggetti.Reparto;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.MouseListener;

public class ClickPerCrearePaziente implements MouseListener
{
    private JTextField nome;
    private JTextField cognome;
    private JTextField codFiscale;
    private JComboBox<String> sesso;
    private Reparto reparto;
    private JFrame fr;
    private JDateChooser data;
    private Medico medico;
    private JFrame frameDoc;
    
    public ClickPerCrearePaziente(final JTextField nomeText, final JTextField codFiscaleText, final JTextField cognomeText, final JDateChooser dateChooser, final JComboBox<String> comboBoxSesso, final Reparto tipoReparto, final JFrame frameDoc, final Medico medico) {
        this.nome = nomeText;
        this.cognome = cognomeText;
        this.sesso = comboBoxSesso;
        this.codFiscale = codFiscaleText;
        this.data = dateChooser;
        this.reparto = tipoReparto;
        this.medico = medico;
        this.frameDoc = frameDoc;
    }
    
    @Override
    public void mouseClicked(final MouseEvent e) {
        if (e.getButton() == 1) {
            try {
                this.reparto.deserializzazioneArrayListPaziente();
                final String dataNascita = ((JTextField)this.data.getDateEditor().getUiComponent()).getText();
                final String sessoStringa = (String)this.sesso.getSelectedItem();
                if (ControlloStringhe.controllaCodFiscale(this.nome.getText(), this.cognome.getText(), this.codFiscale.getText(), dataNascita, sessoStringa)) {
                    try {
                        new Paziente(this.nome.getText(), this.cognome.getText(), sessoStringa, this.codFiscale.getText(), dataNascita, this.reparto);
                        new WindowCreato("Paziente", this.frameDoc, this.medico);
                    }
                    catch (Exception exception) {
                        new WindowNonEsiste(" Paziente ");
                    }
                }
                else {
                    new WindowNonEsiste(" Codice Fiscale ");
                }
            }
            catch (Exception ex) {
                ex.printStackTrace();
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
    
    public static boolean chiusoFrame() {
        return false;
    }
}
