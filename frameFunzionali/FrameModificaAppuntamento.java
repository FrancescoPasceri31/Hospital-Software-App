// 
// Decompiled by Procyon v0.5.36
// 

package frameFunzionali;

import java.awt.event.MouseListener;
import listenerFrameDoc.ClickPerSalvareAppuntamentoModificato;
import javax.swing.JButton;
import javax.swing.text.Document;
import utility.LimitedTextField;
import javax.swing.JTextField;
import java.awt.Color;
import java.util.Date;
import calendar.JDateChooser;
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
import oggetti.Reparto;
import utility.Appuntamento;
import javax.swing.JFrame;

public class FrameModificaAppuntamento extends JFrame
{
    public FrameModificaAppuntamento(final Appuntamento a, final Reparto r, final JFrame frame, final Medico m) {
        this.setTitle("modifica appuntamento");
        this.setSize(480, 170);
        this.setResizable(false);
        this.setDefaultCloseOperation(0);
        this.addWindowListener(new ConfermaUscita(this));
        final String tipoVisita = a.getTipologia();
        final String codFiscale = a.getCodFiscalePaziente();
        final String data = a.getData();
        final JPanel panel = new JPanel();
        this.getContentPane().add(panel, "Center");
        panel.setLayout(new BoxLayout(panel, 0));
        final Component horizontalStrut = Box.createHorizontalStrut(5);
        panel.add(horizontalStrut);
        final JPanel panel_1 = new JPanel();
        panel.add(panel_1);
        panel_1.setLayout(new BoxLayout(panel_1, 1));
        final Component verticalStrut_5 = Box.createVerticalStrut(20);
        panel_1.add(verticalStrut_5);
        final JPanel panel_2 = new JPanel();
        panel_1.add(panel_2);
        panel_2.setLayout(new BoxLayout(panel_2, 0));
        final Component horizontalStrut_3 = Box.createHorizontalStrut(20);
        panel_2.add(horizontalStrut_3);
        final JLabel lblData = new JLabel("Data : ");
        panel_2.add(lblData);
        final JDateChooser dataScelta = new JDateChooser();
        dataScelta.setMinSelectableDate(new Date());
        dataScelta.setBackground(Color.WHITE);
        ((JTextField)dataScelta.getDateEditor().getUiComponent()).setEditable(false);
        ((JTextField)dataScelta.getDateEditor().getUiComponent()).setText(data);
        panel_2.add(dataScelta);
        final Component horizontalStrut_4 = Box.createHorizontalStrut(20);
        panel_2.add(horizontalStrut_4);
        final Component verticalStrut_6 = Box.createVerticalStrut(20);
        panel_1.add(verticalStrut_6);
        final JPanel panel_3 = new JPanel();
        panel_1.add(panel_3);
        panel_3.setLayout(new BoxLayout(panel_3, 0));
        final Component horizontalStrut_5 = Box.createHorizontalStrut(25);
        panel_3.add(horizontalStrut_5);
        final JLabel lblCodiceFiscale = new JLabel("Codice Fiscale   ");
        panel_3.add(lblCodiceFiscale);
        final JTextField textFieldCodFisc = new JTextField(codFiscale.toUpperCase());
        textFieldCodFisc.setBackground(Color.WHITE);
        textFieldCodFisc.setEditable(false);
        panel_3.add(textFieldCodFisc);
        textFieldCodFisc.setColumns(20);
        final Component horizontalStrut_6 = Box.createHorizontalStrut(20);
        panel_3.add(horizontalStrut_6);
        final Component verticalStrut_7 = Box.createVerticalStrut(20);
        panel_1.add(verticalStrut_7);
        final JPanel panel_4 = new JPanel();
        panel_1.add(panel_4);
        panel_4.setLayout(new BoxLayout(panel_4, 0));
        final Component horizontalStrut_7 = Box.createHorizontalStrut(50);
        panel_4.add(horizontalStrut_7);
        final JLabel lblNewLabel = new JLabel("Tipologia di visita  ");
        panel_4.add(lblNewLabel);
        final JTextField textFieldTipoVisita = new JTextField(tipoVisita);
        textFieldTipoVisita.setDocument(new LimitedTextField(30));
        textFieldTipoVisita.setBackground(Color.WHITE);
        panel_4.add(textFieldTipoVisita);
        textFieldTipoVisita.setColumns(30);
        final Component horizontalStrut_8 = Box.createHorizontalStrut(20);
        panel_4.add(horizontalStrut_8);
        final Component verticalStrut_8 = Box.createVerticalStrut(20);
        panel_1.add(verticalStrut_8);
        final Component horizontalStrut_9 = Box.createHorizontalStrut(5);
        panel.add(horizontalStrut_9);
        final JPanel panel_5 = new JPanel();
        panel.add(panel_5);
        panel_5.setLayout(new BoxLayout(panel_5, 1));
        final Component verticalStrut_9 = Box.createVerticalStrut(50);
        panel_5.add(verticalStrut_9);
        final JPanel panel_6 = new JPanel();
        panel_5.add(panel_6);
        panel_6.setLayout(new BoxLayout(panel_6, 0));
        final JButton btnSalva = new JButton("Salva");
        panel_6.add(btnSalva);
        final String dataNuova = ((JTextField)dataScelta.getDateEditor().getUiComponent()).getText();
        btnSalva.addMouseListener(new ClickPerSalvareAppuntamentoModificato(a, textFieldCodFisc.getText(), textFieldTipoVisita, dataNuova, r, frame, m));
        final Component verticalStrut = Box.createVerticalStrut(20);
        panel_5.add(verticalStrut);
        final Component verticalStrut_10 = Box.createVerticalStrut(25);
        panel_5.add(verticalStrut_10);
        final Component horizontalStrut_10 = Box.createHorizontalStrut(5);
        panel.add(horizontalStrut_10);
    }
}
