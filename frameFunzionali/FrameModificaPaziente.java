// 
// Decompiled by Procyon v0.5.36
// 

package frameFunzionali;

import listenerFrameDoc.ClickPerReset;
import java.awt.event.MouseListener;
import listenerFrameDoc.ClickPerSalvarePazienteModificato;
import javax.swing.JButton;
import java.util.Date;
import calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.text.Document;
import utility.LimitedTextField;
import javax.swing.JLabel;
import javax.swing.Box;
import java.awt.LayoutManager;
import java.awt.Container;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JPanel;
import java.awt.event.WindowListener;
import listener.ConfermaUscita;
import oggetti.Medico;
import oggetti.Paziente;
import javax.swing.JTextField;
import javax.swing.JFrame;

public class FrameModificaPaziente extends JFrame
{
    private JTextField nomeText;
    private JTextField cognomeText;
    private JTextField codFiscaleText;
    
    public FrameModificaPaziente(final Paziente p, final JFrame frame, final Medico medico) {
        this.setTitle("Paziente :" + p.getNome() + " " + p.getCognome());
        this.setSize(590, 400);
        this.setResizable(false);
        this.setDefaultCloseOperation(0);
        this.addWindowListener(new ConfermaUscita(this));
        final JPanel panel = new JPanel();
        this.getContentPane().add(panel, "Center");
        panel.setLayout(new BoxLayout(panel, 1));
        final JPanel panel_Dati = new JPanel();
        panel.add(panel_Dati);
        panel_Dati.setLayout(new BoxLayout(panel_Dati, 0));
        final Component horizontalStrut_2 = Box.createHorizontalStrut(10);
        panel_Dati.add(horizontalStrut_2);
        final JPanel panel_nomeSessoCodFiscale = new JPanel();
        panel_Dati.add(panel_nomeSessoCodFiscale);
        panel_nomeSessoCodFiscale.setLayout(new BoxLayout(panel_nomeSessoCodFiscale, 1));
        final Component verticalStrut = Box.createVerticalStrut(50);
        panel_nomeSessoCodFiscale.add(verticalStrut);
        final JPanel panel_nome = new JPanel();
        panel_nomeSessoCodFiscale.add(panel_nome);
        panel_nome.setLayout(new BoxLayout(panel_nome, 0));
        final Component horizontalStrut_3 = Box.createHorizontalStrut(2);
        panel_nome.add(horizontalStrut_3);
        final JLabel lblNome = new JLabel(" Nome : ");
        panel_nome.add(lblNome);
        final Component horizontalStrut_4 = Box.createHorizontalStrut(28);
        panel_nome.add(horizontalStrut_4);
        (this.nomeText = new JTextField(p.getNome())).setDocument(new LimitedTextField(20));
        panel_nome.add(this.nomeText);
        this.nomeText.setColumns(20);
        final Component verticalStrut_1 = Box.createVerticalStrut(15);
        panel_nomeSessoCodFiscale.add(verticalStrut_1);
        final JPanel panel_sesso = new JPanel();
        panel_nomeSessoCodFiscale.add(panel_sesso);
        panel_sesso.setLayout(new BoxLayout(panel_sesso, 0));
        final JLabel lblSesso = new JLabel(" Sesso : ");
        panel_sesso.add(lblSesso);
        final Component horizontalStrut_5 = Box.createHorizontalStrut(30);
        panel_sesso.add(horizontalStrut_5);
        final String[] sceltaSesso = { "Maschio", "Femmina" };
        final JComboBox<String> comboBoxSesso = new JComboBox<String>(sceltaSesso);
        if (p.getGender().equalsIgnoreCase("Maschio")) {
            comboBoxSesso.setSelectedIndex(0);
        }
        else {
            comboBoxSesso.setSelectedIndex(1);
        }
        panel_sesso.add(comboBoxSesso);
        final Component verticalStrut_2 = Box.createVerticalStrut(15);
        panel_nomeSessoCodFiscale.add(verticalStrut_2);
        final JPanel panel_CodFiscale = new JPanel();
        panel_nomeSessoCodFiscale.add(panel_CodFiscale);
        panel_CodFiscale.setLayout(new BoxLayout(panel_CodFiscale, 0));
        final JLabel lblCodFiscale = new JLabel(" Cod. Fiscale : ");
        panel_CodFiscale.add(lblCodFiscale);
        (this.codFiscaleText = new JTextField(p.getCodFiscale())).setDocument(new LimitedTextField(16));
        panel_CodFiscale.add(this.codFiscaleText);
        this.codFiscaleText.setColumns(20);
        final Component verticalStrut_3 = Box.createVerticalStrut(50);
        panel_nomeSessoCodFiscale.add(verticalStrut_3);
        final Component horizontalStrut = Box.createHorizontalStrut(30);
        panel_Dati.add(horizontalStrut);
        final JPanel panel_cognomeDataReparto = new JPanel();
        panel_Dati.add(panel_cognomeDataReparto);
        panel_cognomeDataReparto.setLayout(new BoxLayout(panel_cognomeDataReparto, 1));
        final Component verticalStrut_4 = Box.createVerticalStrut(70);
        panel_cognomeDataReparto.add(verticalStrut_4);
        final JPanel panel_cognome = new JPanel();
        panel_cognomeDataReparto.add(panel_cognome);
        panel_cognome.setLayout(new BoxLayout(panel_cognome, 0));
        final JLabel lblCognome = new JLabel(" Cognome :");
        panel_cognome.add(lblCognome);
        final Component horizontalStrut_6 = Box.createHorizontalStrut(30);
        panel_cognome.add(horizontalStrut_6);
        (this.cognomeText = new JTextField(p.getCognome())).setDocument(new LimitedTextField(20));
        panel_cognome.add(this.cognomeText);
        this.cognomeText.setColumns(20);
        final Component verticalStrut_5 = Box.createVerticalStrut(15);
        panel_cognomeDataReparto.add(verticalStrut_5);
        final JPanel panel_Data = new JPanel();
        panel_cognomeDataReparto.add(panel_Data);
        panel_Data.setLayout(new BoxLayout(panel_Data, 0));
        final JLabel lblDataDiNascita = new JLabel(" Data di Nascita : ");
        panel_Data.add(lblDataDiNascita);
        final JDateChooser dateChooser = new JDateChooser();
        dateChooser.setMaxSelectableDate(new Date());
        ((JTextField)dateChooser.getDateEditor().getUiComponent()).setEditable(false);
        ((JTextField)dateChooser.getDateEditor().getUiComponent()).setText(p.getDataDiNascita());
        panel_Data.add(dateChooser);
        final Component verticalStrut_6 = Box.createVerticalStrut(75);
        panel_cognomeDataReparto.add(verticalStrut_6);
        final Component horizontalStrut_7 = Box.createHorizontalStrut(10);
        panel_Dati.add(horizontalStrut_7);
        final JPanel panel_Bottoni = new JPanel();
        panel.add(panel_Bottoni);
        panel_Bottoni.setLayout(new BoxLayout(panel_Bottoni, 0));
        final Component verticalStrut_7 = Box.createVerticalStrut(150);
        panel_Bottoni.add(verticalStrut_7);
        final JPanel panel_1 = new JPanel();
        panel_Bottoni.add(panel_1);
        panel_1.setLayout(new BoxLayout(panel_1, 1));
        final Component verticalStrut_8 = Box.createVerticalStrut(50);
        panel_1.add(verticalStrut_8);
        final JPanel panel_2 = new JPanel();
        panel_1.add(panel_2);
        final JButton btnSalva = new JButton("Salva");
        btnSalva.addMouseListener(new ClickPerSalvarePazienteModificato(p, this.nomeText, this.codFiscaleText, this.cognomeText, dateChooser, comboBoxSesso, p.getTipoReparto(), frame, medico));
        panel_2.add(btnSalva);
        final JButton btnResetta = new JButton("Reset");
        btnResetta.addMouseListener(new ClickPerReset(this.nomeText, this.cognomeText, this.codFiscaleText, (JTextField)dateChooser.getDateEditor().getUiComponent()));
        panel_2.add(btnResetta);
        final Component verticalStrut_9 = Box.createVerticalStrut(150);
        panel_Bottoni.add(verticalStrut_9);
    }
}
