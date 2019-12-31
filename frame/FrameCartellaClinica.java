// 
// Decompiled by Procyon v0.5.36
// 

package frame;

import java.util.Iterator;
import listenerFrameDoc.ClickSalvaCc;
import listenerFrameCartellaClinica.ClickCambioScheda;
import javax.swing.JScrollPane;
import java.awt.event.MouseListener;
import listenerFrameCartellaClinica.AggiungiATableDiarioClinico;
import javax.swing.JButton;
import javax.swing.table.TableModel;
import utility.JTableModelMia;
import javax.swing.text.Document;
import utility.LimitedTextField;
import java.util.Date;
import java.awt.Dimension;
import calendar.JDateChooser;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.Box;
import utility.CartellaClinica;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.Component;
import javax.swing.JList;
import java.awt.LayoutManager;
import java.awt.Container;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;
import oggetti.Paziente;
import java.awt.Font;
import oggetti.Reparto;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.CardLayout;
import java.io.Serializable;
import javax.swing.JFrame;

public class FrameCartellaClinica extends JFrame implements Serializable
{
    private final CardLayout cardLayout;
    private JTable table;
    private JPanel panel_Accettazione;
    private JPanel panel_ValutazioneInizialeInfermieristica;
    private JPanel panel_ValutazioneClinicaIniziale;
    private JPanel panel_TerapiaDomiciliare;
    private JPanel panel_EsameObiettivo;
    private JPanel panel_DiarioClinico;
    private JTextField textFieldAggiungiVoce;
    private JTextField textFieldAggiungiData;
    private Object[][] data;
    
    public FrameCartellaClinica(final Reparto reparto, final String codFiscale) {
        this.cardLayout = new CardLayout();
        this.setFont(new Font("Tahoma", 1, 14));
        Paziente p1 = null;
        for (final Paziente paziente : reparto.getListaPazienti()) {
            if (paziente.getCodFiscale().equalsIgnoreCase(codFiscale)) {
                p1 = paziente;
            }
        }
        if (p1 == null) {
            return;
        }
        this.setTitle("Cartella Clinica");
        this.setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 35);
        final JPanel panel = new JPanel();
        panel.setBackground(SystemColor.activeCaptionBorder);
        final String[] arrayVoci = { "Accettazione", "Valutazione infermieristica iniziale", "Valutazione clinica iniziale", "Terapia domiciliare", "Esame obiettivo", "Diario clinico" };
        panel.setLayout(new BoxLayout(panel, 1));
        final JList<String> list = new JList<String>(arrayVoci);
        list.setFont(new Font("Tahomi", 1, 13));
        list.setBackground(Color.LIGHT_GRAY);
        panel.add(list);
        this.getContentPane().add(panel, "West");
        final JPanel panel_3 = new JPanel();
        panel_3.setBorder(new LineBorder(Color.BLACK, 2));
        this.getContentPane().add(panel_3, "Center");
        panel_3.setLayout(this.cardLayout);
        panel_3.add(this.panel_Accettazione = CartellaClinica.deserializzaPannelloAccettazione(p1), "1");
        panel_3.add(this.panel_ValutazioneInizialeInfermieristica = CartellaClinica.deserializzaPannelloValutazioneInfermieristica(p1), "2");
        panel_3.add(this.panel_ValutazioneClinicaIniziale = CartellaClinica.deserializzaPannelloValutazioneClinica(p1), "3");
        final Component verticalStrut_4 = Box.createVerticalStrut(20);
        this.panel_ValutazioneClinicaIniziale.add(verticalStrut_4);
        panel_3.add(this.panel_TerapiaDomiciliare = CartellaClinica.deserializzaPannelloTerapiaDomiciliare(p1), "4");
        panel_3.add(this.panel_EsameObiettivo = CartellaClinica.deserializzaPannelloEsameObiettivo(p1), "5");
        (this.panel_DiarioClinico = new JPanel()).setLayout(new BorderLayout(0, 0));
        final JPanel panel_4 = new JPanel();
        this.panel_DiarioClinico.add(panel_4, "North");
        final JLabel lblData = new JLabel("Data:  ");
        lblData.setFont(new Font("Tahoma", 1, 11));
        panel_4.add(lblData);
        final JDateChooser dataChooser = new JDateChooser();
        ((JTextField)dataChooser.getDateEditor().getUiComponent()).setEditable(false);
        dataChooser.setPreferredSize(new Dimension(200, 32));
        dataChooser.setMinSelectableDate(new Date());
        this.textFieldAggiungiData = (JTextField)dataChooser.getDateEditor().getUiComponent();
        panel_4.add(dataChooser);
        final Component horizontalStrut = Box.createHorizontalStrut(20);
        panel_4.add(horizontalStrut);
        final JLabel lblDecorso = new JLabel("Decorso:");
        lblDecorso.setFont(new Font("Tahoma", 1, 11));
        panel_4.add(lblDecorso);
        (this.textFieldAggiungiVoce = new JTextField()).setDocument(new LimitedTextField(30));
        this.textFieldAggiungiVoce.setPreferredSize(new Dimension(6, 32));
        panel_4.add(this.textFieldAggiungiVoce);
        this.textFieldAggiungiVoce.setColumns(50);
        final Component horizontalStrut_1 = Box.createHorizontalStrut(20);
        panel_4.add(horizontalStrut_1);
        final String[] testata = { "DATA E ORA (es. gg-mm-aaaa : hh-mm)", "DECORSO" };
        this.data = CartellaClinica.deserializzaMatriceDiarioClinico(p1);
        (this.table = new JTable(new JTableModelMia(this.data, testata))).setBackground(Color.WHITE);
        final JButton btnAggiungi = new JButton("Aggiungi");
        btnAggiungi.setFont(new Font("Tahoma", 1, 11));
        btnAggiungi.addMouseListener(new AggiungiATableDiarioClinico((JTableModelMia)this.table.getModel(), this.data, this.textFieldAggiungiVoce, this.textFieldAggiungiData, p1, this));
        panel_4.add(btnAggiungi);
        final JPanel panel_5 = new JPanel();
        this.panel_DiarioClinico.add(panel_5, "Center");
        panel_5.setLayout(new BoxLayout(panel_5, 0));
        final JScrollPane scrollPane_7 = new JScrollPane(this.table);
        panel_5.add(scrollPane_7);
        panel_3.add(this.panel_DiarioClinico, "6");
        final JPanel panel_6 = new JPanel();
        panel_6.setBackground(SystemColor.activeCaptionBorder);
        this.getContentPane().add(panel_6, "North");
        final Component verticalStrut = Box.createVerticalStrut(20);
        panel_6.add(verticalStrut);
        list.addMouseListener(new ClickCambioScheda(this.cardLayout, panel_3, list));
        final JPanel panel_7 = new JPanel();
        panel_7.setBackground(SystemColor.activeCaptionBorder);
        this.getContentPane().add(panel_7, "South");
        final JButton btnSalva = new JButton("Salva");
        btnSalva.addMouseListener(new ClickSalvaCc(this.panel_Accettazione, this.panel_ValutazioneInizialeInfermieristica, this.panel_ValutazioneClinicaIniziale, this.panel_TerapiaDomiciliare, this.panel_EsameObiettivo, reparto, codFiscale, p1, this));
        panel_7.add(btnSalva);
    }
    
    public Object[][] getData() {
        return this.data;
    }
    
    public void setData(final Object[][] data) {
        this.data = data;
    }
}
