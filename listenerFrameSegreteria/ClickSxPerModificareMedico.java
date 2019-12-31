// 
// Decompiled by Procyon v0.5.36
// 

package listenerFrameSegreteria;

import frameFunzionali.WindowNonEsiste;
import frameFunzionali.WindowCreato;
import avvio.App;
import utility.ControlloStringhe;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JTable;
import oggetti.Medico;
import calendar.JDateChooser;
import javax.swing.JTextField;
import java.awt.event.MouseListener;

public class ClickSxPerModificareMedico implements MouseListener
{
    private JTextField nome;
    private JTextField cognome;
    private JTextField codFiscale;
    private JDateChooser date;
    private Medico medico;
    private JTable table;
    private JFrame frame;
    
    public ClickSxPerModificareMedico(final Medico medicoDaModificare, final JTextField textFieldNome, final JTextField textFieldCognome, final JTextField textFieldCodFiscale, final JDateChooser date, final JTable table, final JFrame frame) {
        this.nome = textFieldNome;
        this.cognome = textFieldCognome;
        this.codFiscale = textFieldCodFiscale;
        this.date = date;
        this.medico = medicoDaModificare;
        this.table = table;
        this.frame = frame;
    }
    
    @Override
    public void mouseClicked(final MouseEvent arg0) {
        if (arg0.getButton() == 1) {
            System.out.println("Generato");
            try {
                final String data = ((JTextField)this.date.getDateEditor().getUiComponent()).getText();
                if (ControlloStringhe.controllaCodFiscale(this.nome.getText(), this.cognome.getText(), this.codFiscale.getText(), data, this.medico.getGender())) {
                    System.out.println("C.F. corretto");
                    this.medico.getTipoReparto().deserializzazioneArrayListMedico();
                    App.login.deserializzaMappaLoginMedico();
                    App.login.getMappaLoginMedico().remove(this.medico.getCodFiscale());
                    this.medico.getTipoReparto().rimuoviMedicoDaLista(this.medico);
                    new Medico(this.nome.getText(), this.cognome.getText(), this.medico.getGender(), this.codFiscale.getText(), data, this.medico.getTipoReparto());
                    System.out.println(this.medico.toStringCompleto());
                    this.medico.getTipoReparto().serializzaArrayListMedico(this.medico.getTipoReparto().getListaMedici());
                    App.login.serializzaMappaLoginMedico(App.login.getMappaLoginMedico());
                    new WindowCreato("Medico", 0, this.frame);
                    this.table.repaint();
                }
                else {
                    System.out.println("C.F. errato");
                    new WindowNonEsiste(" Codice fiscale ");
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
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
