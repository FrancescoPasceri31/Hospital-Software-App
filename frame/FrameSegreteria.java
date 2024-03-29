// 
// Decompiled by Procyon v0.5.36
// 

package frame;

import listenerFrameSegreteria.AscoltatoreVisualizzaPazienti;
import listenerFrameSegreteria.AscoltatoreVisualizzaMedici;
import listenerFrameSegreteria.AscoltatoreVisualizzaReparto;
import javax.swing.JToggleButton;
import listenerFrameSegreteria.AscoltatoreResetMedico;
import listenerFrameSegreteria.AscoltatoreCreaMedico;
import oggetti.Segreteria;
import oggetti.Reparto;
import avvio.App;
import java.util.Date;
import calendar.JDateChooser;
import java.awt.Dimension;
import javax.swing.JSeparator;
import listenerFrameSegreteria.ClickResetTestoReparto;
import listenerFrameSegreteria.AscoltatoreNuovoReparto;
import javax.swing.text.Document;
import utility.LimitedTextField;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.MouseListener;
import listener.Logout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.Box;
import java.awt.LayoutManager;
import java.awt.Container;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JPanel;
import java.awt.event.WindowListener;
import listener.ConfermaUscita;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JFrame;

public class FrameSegreteria extends JFrame
{
    private JTextField textField;
    private JTextField nomeText;
    private JTextField codFiscaleText;
    private JTextField cognomeText;
    private JComboBox<String> sesso;
    private FrameSegreteria frame;
    
    public FrameSegreteria() {
        this.setTitle("Segreteria");
        this.setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 100, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 100);
        this.setDefaultCloseOperation(0);
        this.addWindowListener(new ConfermaUscita(this));
        this.setLocation(20, 20);
        this.setResizable(false);
        this.frame = this;
        final JPanel panel_South = new JPanel();
        this.getContentPane().add(panel_South, "South");
        panel_South.setLayout(new BoxLayout(panel_South, 1));
        final JPanel panel_8 = new JPanel();
        panel_South.add(panel_8);
        final Component verticalStrut = Box.createVerticalStrut(45);
        panel_8.add(verticalStrut);
        final JPanel panel_9 = new JPanel();
        panel_South.add(panel_9);
        panel_9.setLayout(new FlowLayout(1, 5, 5));
        final JButton btnNewButton_1 = new JButton("Logout");
        panel_9.add(btnNewButton_1);
        btnNewButton_1.addMouseListener(new Logout(this));
        final JPanel panel_Ovest = new JPanel();
        this.getContentPane().add(panel_Ovest, "West");
        panel_Ovest.setLayout(new BoxLayout(panel_Ovest, 1));
        panel_Ovest.setSize(200, 200);
        final Component horizontalStrut_11 = Box.createHorizontalStrut(80);
        panel_Ovest.add(horizontalStrut_11);
        final JPanel panel_Est = new JPanel();
        this.getContentPane().add(panel_Est, "East");
        panel_Est.setLayout(new BoxLayout(panel_Est, 1));
        panel_Est.setSize(200, 200);
        final Component horizontalStrut_12 = Box.createHorizontalStrut(80);
        panel_Est.add(horizontalStrut_12);
        final JPanel panel_Center = new JPanel();
        this.getContentPane().add(panel_Center, "Center");
        panel_Center.setLayout(new BoxLayout(panel_Center, 1));
        panel_Center.setSize(200, 200);
        final JPanel panel_CreaReparto = new JPanel();
        panel_Center.add(panel_CreaReparto);
        panel_CreaReparto.setLayout(new BoxLayout(panel_CreaReparto, 1));
        final Component verticalStrut_13 = Box.createVerticalStrut(20);
        panel_CreaReparto.add(verticalStrut_13);
        final JPanel panel_10 = new JPanel();
        panel_CreaReparto.add(panel_10);
        final JLabel lblNewLabel = new JLabel("Aggiungi Reparto");
        panel_10.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Tahoma", 1, 15));
        final Component verticalStrut_14 = Box.createVerticalStrut(20);
        panel_CreaReparto.add(verticalStrut_14);
        final JPanel newReparto = new JPanel();
        panel_CreaReparto.add(newReparto);
        final JLabel lblReparto = new JLabel("Reparto : ");
        lblReparto.setFont(new Font("Tahoma", 1, 11));
        newReparto.add(lblReparto);
        final Component horizontalStrut_13 = Box.createHorizontalStrut(5);
        newReparto.add(horizontalStrut_13);
        (this.textField = new JTextField()).setDocument(new LimitedTextField(20));
        newReparto.add(this.textField);
        this.textField.setColumns(30);
        final Component horizontalStrut_14 = Box.createHorizontalStrut(10);
        newReparto.add(horizontalStrut_14);
        final JButton btnNewButton = new JButton("Salva");
        btnNewButton.addMouseListener(new AscoltatoreNuovoReparto(btnNewButton, this.textField, this));
        newReparto.add(btnNewButton);
        final JButton btnReset = new JButton("Reset");
        btnReset.addMouseListener(new ClickResetTestoReparto(this.textField));
        newReparto.add(btnReset);
        final Component verticalStrut_15 = Box.createVerticalStrut(30);
        panel_CreaReparto.add(verticalStrut_15);
        final JPanel panel = new JPanel();
        panel_CreaReparto.add(panel);
        final Component verticalStrut_16 = Box.createVerticalStrut(3);
        panel_Center.add(verticalStrut_16);
        final JPanel panel_11 = new JPanel();
        panel_Center.add(panel_11);
        panel_11.setLayout(new BoxLayout(panel_11, 0));
        final JSeparator separator = new JSeparator();
        panel_11.add(separator);
        final Component verticalStrut_17 = Box.createVerticalStrut(3);
        panel_Center.add(verticalStrut_17);
        final JPanel panel_CreaMedico = new JPanel();
        panel_Center.add(panel_CreaMedico);
        panel_CreaMedico.setLayout(new BoxLayout(panel_CreaMedico, 1));
        final Component verticalStrut_18 = Box.createVerticalStrut(45);
        panel_CreaMedico.add(verticalStrut_18);
        final JPanel panel_12 = new JPanel();
        panel_CreaMedico.add(panel_12);
        final JLabel lblCreazioneMedico = new JLabel("Aggiungi Medico");
        lblCreazioneMedico.setFont(new Font("Tahoma", 1, 15));
        panel_12.add(lblCreazioneMedico);
        final JPanel panel_Dati = new JPanel();
        panel_CreaMedico.add(panel_Dati);
        panel_Dati.setLayout(new BoxLayout(panel_Dati, 0));
        final Component horizontalStrut_15 = Box.createHorizontalStrut(10);
        panel_Dati.add(horizontalStrut_15);
        final JPanel panel_nomeSessoCodFiscale = new JPanel();
        panel_Dati.add(panel_nomeSessoCodFiscale);
        panel_nomeSessoCodFiscale.setLayout(new BoxLayout(panel_nomeSessoCodFiscale, 1));
        final Component verticalStrut2 = Box.createVerticalStrut(70);
        panel_nomeSessoCodFiscale.add(verticalStrut2);
        final JPanel panel_nome = new JPanel();
        panel_nomeSessoCodFiscale.add(panel_nome);
        panel_nome.setLayout(new BoxLayout(panel_nome, 0));
        final Component horizontalStrut_16 = Box.createHorizontalStrut(2);
        panel_nome.add(horizontalStrut_16);
        final JLabel lblNome = new JLabel(" Nome : ");
        lblNome.setFont(new Font("Tahoma", 1, 11));
        panel_nome.add(lblNome);
        final Component horizontalStrut_17 = Box.createHorizontalStrut(48);
        panel_nome.add(horizontalStrut_17);
        (this.nomeText = new JTextField()).setDocument(new LimitedTextField(20));
        this.nomeText.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        panel_nome.add(this.nomeText);
        this.nomeText.setColumns(20);
        final Component verticalStrut_19 = Box.createVerticalStrut(30);
        panel_nomeSessoCodFiscale.add(verticalStrut_19);
        final JPanel panel_Sesso = new JPanel();
        panel_nomeSessoCodFiscale.add(panel_Sesso);
        panel_Sesso.setLayout(new BoxLayout(panel_Sesso, 0));
        final JLabel lblSesso = new JLabel("Sesso : ");
        lblSesso.setFont(new Font("Tahoma", 1, 11));
        panel_Sesso.add(lblSesso);
        final Component horizontalStrut_18 = Box.createHorizontalStrut(52);
        panel_Sesso.add(horizontalStrut_18);
        final String[] sceltaSesso = { "Maschio", "Femmina" };
        final JComboBox<String> comboBoxSesso = new JComboBox<String>(sceltaSesso);
        panel_Sesso.add(comboBoxSesso);
        final Component verticalStrut_20 = Box.createVerticalStrut(30);
        panel_nomeSessoCodFiscale.add(verticalStrut_20);
        final JPanel panel_CodFiscale = new JPanel();
        panel_nomeSessoCodFiscale.add(panel_CodFiscale);
        panel_CodFiscale.setLayout(new BoxLayout(panel_CodFiscale, 0));
        final JLabel lblCodFiscale = new JLabel(" Cod. Fiscale : ");
        lblCodFiscale.setFont(new Font("Tahoma", 1, 11));
        panel_CodFiscale.add(lblCodFiscale);
        final Component horizontalStrut_19 = Box.createHorizontalStrut(20);
        panel_CodFiscale.add(horizontalStrut_19);
        (this.codFiscaleText = new JTextField()).setDocument(new LimitedTextField(16));
        this.codFiscaleText.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        panel_CodFiscale.add(this.codFiscaleText);
        this.codFiscaleText.setColumns(20);
        final Component verticalStrut_21 = Box.createVerticalStrut(55);
        panel_nomeSessoCodFiscale.add(verticalStrut_21);
        final Component horizontalStrut = Box.createHorizontalStrut(30);
        panel_Dati.add(horizontalStrut);
        final JPanel panel_cognomeDataReparto = new JPanel();
        panel_Dati.add(panel_cognomeDataReparto);
        panel_cognomeDataReparto.setLayout(new BoxLayout(panel_cognomeDataReparto, 1));
        final Component verticalStrut_22 = Box.createVerticalStrut(70);
        panel_cognomeDataReparto.add(verticalStrut_22);
        final JPanel panel_cognome = new JPanel();
        panel_cognomeDataReparto.add(panel_cognome);
        panel_cognome.setLayout(new BoxLayout(panel_cognome, 0));
        final JLabel lblCognome = new JLabel(" Cognome :");
        lblCognome.setFont(new Font("Tahoma", 1, 11));
        panel_cognome.add(lblCognome);
        final Component horizontalStrut_20 = Box.createHorizontalStrut(48);
        panel_cognome.add(horizontalStrut_20);
        (this.cognomeText = new JTextField()).setDocument(new LimitedTextField(20));
        this.cognomeText.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        panel_cognome.add(this.cognomeText);
        this.cognomeText.setColumns(20);
        final Component verticalStrut_23 = Box.createVerticalStrut(30);
        panel_cognomeDataReparto.add(verticalStrut_23);
        final JPanel panel_Data = new JPanel();
        panel_cognomeDataReparto.add(panel_Data);
        panel_Data.setLayout(new BoxLayout(panel_Data, 0));
        final JPanel panel_13 = new JPanel();
        panel_Data.add(panel_13);
        panel_13.setLayout(new BoxLayout(panel_13, 1));
        final JLabel lblDataDiNascita = new JLabel(" Data di Nascita : ");
        lblDataDiNascita.setFont(new Font("Tahoma", 1, 11));
        panel_13.add(lblDataDiNascita);
        final JLabel lblggmmmaaaa = new JLabel(" (gg-mmm-aaaa)");
        panel_13.add(lblggmmmaaaa);
        final Component horizontalStrut_21 = Box.createHorizontalStrut(20);
        panel_Data.add(horizontalStrut_21);
        final JDateChooser dateChooser = new JDateChooser();
        dateChooser.setMaxSelectableDate(new Date());
        ((JTextField)dateChooser.getDateEditor().getUiComponent()).setEditable(false);
        dateChooser.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
        panel_Data.add(dateChooser);
        final Component verticalStrut_24 = Box.createVerticalStrut(30);
        panel_cognomeDataReparto.add(verticalStrut_24);
        final JPanel panel_14 = new JPanel();
        panel_cognomeDataReparto.add(panel_14);
        panel_14.setLayout(new BoxLayout(panel_14, 0));
        final JLabel lblReparto_1 = new JLabel(" Reparto :   ");
        lblReparto_1.setFont(new Font("Tahoma", 1, 11));
        panel_14.add(lblReparto_1);
        final Component horizontalStrut_22 = Box.createHorizontalStrut(48);
        panel_14.add(horizontalStrut_22);
        final Segreteria segreteria = App.segreteria;
        final Reparto[] sceltaReparto = new Reparto[Segreteria.getListaReparti().size()];
        int i = 0;
        Label_2015: {
            break Label_2015;
            int j;
            do {
                final Reparto[] array = sceltaReparto;
                final int n = i;
                final Segreteria segreteria2 = App.segreteria;
                array[n] = Segreteria.getListaReparti().get(i);
                ++i;
                j = i;
                final Segreteria segreteria3 = App.segreteria;
            } while (j < Segreteria.getListaReparti().size());
        }
        final JComboBox<Reparto> comboBoxReparto = new JComboBox<Reparto>(sceltaReparto);
        panel_14.add(comboBoxReparto);
        final Component verticalStrut_25 = Box.createVerticalStrut(55);
        panel_cognomeDataReparto.add(verticalStrut_25);
        final Component horizontalStrut_23 = Box.createHorizontalStrut(10);
        panel_Dati.add(horizontalStrut_23);
        final JPanel panel_15 = new JPanel();
        panel_CreaMedico.add(panel_15);
        panel_15.setLayout(new BoxLayout(panel_15, 0));
        final JButton btnSalva = new JButton("Salva");
        btnSalva.addMouseListener(new AscoltatoreCreaMedico(btnSalva, this.nomeText, this.cognomeText, dateChooser, comboBoxSesso, this.codFiscaleText, comboBoxReparto, this));
        panel_15.add(btnSalva);
        final JButton btnReset_1 = new JButton("Reset");
        btnReset_1.addMouseListener(new AscoltatoreResetMedico(this.nomeText, this.cognomeText, this.codFiscaleText));
        final Component horizontalStrut_24 = Box.createHorizontalStrut(20);
        panel_15.add(horizontalStrut_24);
        panel_15.add(btnReset_1);
        final JPanel panel_North = new JPanel();
        this.getContentPane().add(panel_North, "North");
        panel_North.setLayout(new BoxLayout(panel_North, 0));
        final Component verticalStrut_26 = Box.createVerticalStrut(20);
        panel_North.add(verticalStrut_26);
        final JPanel panel_16 = new JPanel();
        panel_North.add(panel_16);
        panel_16.setLayout(new BoxLayout(panel_16, 2));
        final JLabel lblInfoSelect = new JLabel("Seleziona per visualizzare : ");
        lblInfoSelect.setFont(new Font("Tahoma", 1, 11));
        panel_16.add(lblInfoSelect);
        final JToggleButton tglbtnReparti = new JToggleButton("Reparti");
        tglbtnReparti.addMouseListener(new AscoltatoreVisualizzaReparto(tglbtnReparti, this));
        panel_16.add(tglbtnReparti);
        final JToggleButton tglbtnMedici = new JToggleButton("Medici");
        tglbtnMedici.addMouseListener(new AscoltatoreVisualizzaMedici(tglbtnMedici, this));
        panel_16.add(tglbtnMedici);
        final JToggleButton tglbtnPazienti = new JToggleButton("Pazienti");
        tglbtnPazienti.addMouseListener(new AscoltatoreVisualizzaPazienti(tglbtnPazienti));
        panel_16.add(tglbtnPazienti);
        final Component verticalStrut_27 = Box.createVerticalStrut(20);
        panel_North.add(verticalStrut_27);
    }
}
