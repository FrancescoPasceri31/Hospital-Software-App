// 
// Decompiled by Procyon v0.5.36
// 

package frameFunzionali;

import java.util.Iterator;
import java.awt.event.MouseListener;
import listenerFrameDoc.ClickSalvaAppuntamento;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.util.Date;
import calendar.JDateChooser;
import javax.swing.text.Document;
import utility.LimitedTextField;
import javax.swing.JComboBox;
import oggetti.Paziente;
import javax.swing.JLabel;
import javax.swing.Box;
import java.awt.Container;
import javax.swing.BoxLayout;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.UIManager;
import javax.swing.JPanel;
import java.awt.event.WindowListener;
import listener.ConfermaUscita;
import oggetti.Medico;
import oggetti.Reparto;
import javax.swing.JTextField;
import javax.swing.JFrame;

public class FrameCreaAppuntamento extends JFrame
{
    private JTextField textFieldTipologia;
    
    public FrameCreaAppuntamento(final Reparto r, final JFrame frame, final Medico medico) {
        this.setTitle("Nuovo Appuntamento");
        this.setSize(500, 350);
        this.setResizable(false);
        this.setDefaultCloseOperation(0);
        this.addWindowListener(new ConfermaUscita(this));
        final JPanel panel = new JPanel();
        panel.setBackground(UIManager.getColor("Button.background"));
        this.getContentPane().add(panel, "Center");
        panel.setLayout(new BorderLayout(0, 0));
        final JPanel panello_dati = new JPanel();
        panel.add(panello_dati);
        panello_dati.setLayout(new BoxLayout(panello_dati, 1));
        final Component verticalStrut = Box.createVerticalStrut(50);
        panello_dati.add(verticalStrut);
        final JPanel panel_1 = new JPanel();
        panello_dati.add(panel_1);
        panel_1.setLayout(new BoxLayout(panel_1, 0));
        final JLabel lblPaziente = new JLabel("Paziente : ");
        panel_1.add(lblPaziente);
        String[] codFiscaliPaz;
        if (r.getListaPazienti().size() == 0) {
            codFiscaliPaz = new String[] { "Nessun paziente in reparto" };
        }
        else {
            codFiscaliPaz = new String[r.getListaPazienti().size()];
            int pos = 0;
            for (final Paziente paz : r.getListaPazienti()) {
                final String tmp = String.valueOf(paz.getNome()) + " " + paz.getCognome() + ", " + paz.getCodFiscale();
                codFiscaliPaz[pos] = tmp;
                ++pos;
            }
        }
        final JComboBox<String> comboBox = new JComboBox<String>(codFiscaliPaz);
        panel_1.add(comboBox);
        final Component verticalStrut_1 = Box.createVerticalStrut(20);
        panello_dati.add(verticalStrut_1);
        final JPanel panel_2 = new JPanel();
        panello_dati.add(panel_2);
        panel_2.setLayout(new BoxLayout(panel_2, 0));
        final JLabel lblTipologia = new JLabel("Tipologia di visita : ");
        panel_2.add(lblTipologia);
        (this.textFieldTipologia = new JTextField()).setDocument(new LimitedTextField(30));
        panel_2.add(this.textFieldTipologia);
        this.textFieldTipologia.setColumns(30);
        final Component verticalStrut_2 = Box.createVerticalStrut(20);
        panello_dati.add(verticalStrut_2);
        final JPanel panel_3 = new JPanel();
        panello_dati.add(panel_3);
        panel_3.setLayout(new BoxLayout(panel_3, 0));
        final JLabel lblData = new JLabel("Data : ");
        panel_3.add(lblData);
        final JDateChooser data = new JDateChooser();
        data.setMinSelectableDate(new Date());
        ((JTextField)data.getDateEditor().getUiComponent()).setEditable(false);
        panel_3.add(data);
        final Component verticalStrut_3 = Box.createVerticalStrut(120);
        panello_dati.add(verticalStrut_3);
        final JPanel panello_btnSalva = new JPanel();
        panel.add(panello_btnSalva, "South");
        panello_btnSalva.setLayout(new FlowLayout(1, 5, 5));
        String pazSelezionato = (String)comboBox.getSelectedItem();
        int inizio_cf = 0;
        final int fine_cf = pazSelezionato.length();
        for (int i = 0; i < fine_cf; ++i) {
            if (pazSelezionato.charAt(i) == ',') {
                inizio_cf = i + 2;
                break;
            }
            inizio_cf = fine_cf;
        }
        pazSelezionato = pazSelezionato.substring(inizio_cf, fine_cf);
        final JButton btnSalva = new JButton("Salva");
        btnSalva.addMouseListener(new ClickSalvaAppuntamento(pazSelezionato, this.textFieldTipologia, (JTextField)data.getDateEditor().getUiComponent(), r, frame, medico));
        panello_btnSalva.add(btnSalva);
        final Component horizontalStrut = Box.createHorizontalStrut(80);
        panel.add(horizontalStrut, "West");
        final Component horizontalStrut_1 = Box.createHorizontalStrut(80);
        panel.add(horizontalStrut_1, "East");
        this.setVisible(true);
    }
}
