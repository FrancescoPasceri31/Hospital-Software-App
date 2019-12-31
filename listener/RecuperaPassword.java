// 
// Decompiled by Procyon v0.5.36
// 

package listener;

import frameFunzionali.WindowMostraPassword;
import avvio.App;
import frameFunzionali.WindowNonEsiste;
import utility.ControlloStringhe;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.event.MouseListener;

public class RecuperaPassword implements MouseListener
{
    private JTextField textFieldNome;
    private JTextField textFieldCognome;
    private JTextField textFieldCodiceFiscale;
    private JTextField uiComponent;
    private JCheckBox chckbxMedico;
    private JCheckBox chckbxPaziente;
    private JFrame frame;
    private String sesso;
    
    public RecuperaPassword(final JTextField textFieldNome, final JTextField textFieldCognome, final JTextField textFieldCodiceFiscale, final JTextField uiComponent, final JCheckBox chckbxMedico, final JCheckBox chckbxPaziente, final JFrame frame, final String sesso) {
        this.textFieldNome = textFieldNome;
        this.textFieldCognome = textFieldCognome;
        this.textFieldCodiceFiscale = textFieldCodiceFiscale;
        this.uiComponent = uiComponent;
        this.chckbxMedico = chckbxMedico;
        this.chckbxPaziente = chckbxPaziente;
        this.frame = frame;
        this.sesso = sesso;
    }
    
    @Override
    public void mouseClicked(final MouseEvent arg0) {
        if (arg0.getButton() == 1) {
            if (!ControlloStringhe.controllaCodFiscale(this.textFieldNome.getText(), this.textFieldCognome.getText(), this.textFieldCodiceFiscale.getText(), this.uiComponent.getText(), this.sesso)) {
                new WindowNonEsiste("Inserimento ").setVisible(true);
                return;
            }
            if (this.chckbxPaziente.isSelected()) {
                if (App.login.getPaziente(this.textFieldCodiceFiscale.getText()) != null && App.login.getPaziente(this.textFieldCodiceFiscale.getText()).getNome().equalsIgnoreCase(this.textFieldNome.getText()) && App.login.getPaziente(this.textFieldCodiceFiscale.getText()).getCognome().equalsIgnoreCase(this.textFieldCognome.getText()) && App.login.getPaziente(this.textFieldCodiceFiscale.getText()).getDataDiNascita().equalsIgnoreCase(this.uiComponent.getText())) {
                    this.frame.dispose();
                    new WindowMostraPassword(App.login.getPaziente(this.textFieldCodiceFiscale.getText())).setVisible(true);
                }
                else {
                    new WindowNonEsiste("Inserimento ").setVisible(true);
                }
            }
            else if (this.chckbxMedico.isSelected()) {
                if (App.login.getMedico(this.textFieldCodiceFiscale.getText()) != null && App.login.getMedico(this.textFieldCodiceFiscale.getText()).getNome().toLowerCase().equalsIgnoreCase(this.textFieldNome.getText().toUpperCase()) && App.login.getMedico(this.textFieldCodiceFiscale.getText()).getCognome().equalsIgnoreCase(this.textFieldCognome.getText()) && App.login.getMedico(this.textFieldCodiceFiscale.getText()).getDataDiNascita().equalsIgnoreCase(this.uiComponent.getText())) {
                    this.frame.dispose();
                    new WindowMostraPassword(App.login.getMedico(this.textFieldCodiceFiscale.getText())).setVisible(true);
                }
                else {
                    new WindowNonEsiste("Inserimento ").setVisible(true);
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
