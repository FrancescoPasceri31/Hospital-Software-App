// 
// Decompiled by Procyon v0.5.36
// 

package frameFunzionali;

import utility.ControlloWindowUnica;
import javax.swing.Box;
import java.awt.event.MouseListener;
import listener.RecuperaPassword;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Container;
import javax.swing.BoxLayout;
import java.util.Date;
import calendar.JDateChooser;
import javax.swing.text.Document;
import utility.LimitedTextField;
import java.awt.LayoutManager;
import java.awt.GridLayout;
import javax.swing.AbstractButton;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;

public class FrameRecuperaPassword extends JFrame
{
    private final ButtonGroup buttonGroup;
    private JTextField textFieldNome;
    private JTextField textFieldCognome;
    private JTextField textFieldCodiceFiscale;
    
    public FrameRecuperaPassword() {
        this.buttonGroup = new ButtonGroup();
        this.setTitle("Recupera password");
        final JPanel panel = new JPanel();
        this.getContentPane().add(panel, "North");
        final JLabel lblCompilaPerRecuperare = new JLabel("Compila per recuperare la password");
        lblCompilaPerRecuperare.setFont(new Font("Tahoma", 1, 15));
        panel.add(lblCompilaPerRecuperare);
        final JPanel panel_1 = new JPanel();
        this.getContentPane().add(panel_1, "South");
        final JCheckBox chckbxMedico = new JCheckBox("Medico");
        this.buttonGroup.add(chckbxMedico);
        panel_1.add(chckbxMedico);
        final JCheckBox chckbxPaziente = new JCheckBox("Paziente");
        this.buttonGroup.add(chckbxPaziente);
        panel_1.add(chckbxPaziente);
        final JPanel panel_2 = new JPanel();
        this.getContentPane().add(panel_2, "West");
        panel_2.setLayout(new GridLayout(5, 2, 0, 0));
        final JLabel lblNome = new JLabel(" Nome: ");
        lblNome.setFont(new Font("Tahoma", 1, 11));
        panel_2.add(lblNome);
        (this.textFieldNome = new JTextField()).setDocument(new LimitedTextField(20));
        panel_2.add(this.textFieldNome);
        this.textFieldNome.setColumns(10);
        final JLabel lblCognome = new JLabel(" Cognome: ");
        lblCognome.setFont(new Font("Tahoma", 1, 11));
        panel_2.add(lblCognome);
        (this.textFieldCognome = new JTextField()).setDocument(new LimitedTextField(20));
        panel_2.add(this.textFieldCognome);
        this.textFieldCognome.setColumns(10);
        final JLabel lblCodiceFiscale = new JLabel(" Codice Fiscale: ");
        lblCodiceFiscale.setFont(new Font("Tahoma", 1, 11));
        panel_2.add(lblCodiceFiscale);
        (this.textFieldCodiceFiscale = new JTextField()).setDocument(new LimitedTextField(16));
        panel_2.add(this.textFieldCodiceFiscale);
        this.textFieldCodiceFiscale.setColumns(10);
        final JLabel lblDataDiNascita = new JLabel(" Data di nascita: ");
        lblDataDiNascita.setFont(new Font("Tahoma", 1, 11));
        panel_2.add(lblDataDiNascita);
        final JDateChooser data = new JDateChooser();
        data.setMaxSelectableDate(new Date());
        ((JTextField)data.getDateEditor().getUiComponent()).setEditable(false);
        panel_2.add(data);
        final JPanel panel_3 = new JPanel();
        this.getContentPane().add(panel_3, "East");
        panel_3.setLayout(new BoxLayout(panel_3, 0));
        final JLabel lblSesso = new JLabel(" Sesso: ");
        lblSesso.setFont(new Font("Tahoma", 1, 11));
        panel_2.add(lblSesso);
        final String[] sessoArray = { "Maschio", "Femmina" };
        final JComboBox<String> comboBox = new JComboBox<String>(sessoArray);
        panel_2.add(comboBox);
        final JButton btnRecupera = new JButton(" Recupera ");
        btnRecupera.addMouseListener(new RecuperaPassword(this.textFieldNome, this.textFieldCognome, this.textFieldCodiceFiscale, (JTextField)data.getDateEditor().getUiComponent(), chckbxMedico, chckbxPaziente, this, (String)comboBox.getSelectedItem()));
        btnRecupera.setFont(new Font("Tahoma", 1, 11));
        panel_3.add(btnRecupera);
        final Component horizontalStrut = Box.createHorizontalStrut(50);
        this.getContentPane().add(horizontalStrut, "Center");
        ControlloWindowUnica.chiudiAltre(this);
        this.pack();
    }
}
