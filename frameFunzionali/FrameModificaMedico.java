// 
// Decompiled by Procyon v0.5.36
// 

package frameFunzionali;

import listenerFrameSegreteria.ClickSxPerResetCampi;
import java.awt.event.MouseListener;
import listenerFrameSegreteria.ClickSxPerModificareMedico;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import frame.FrameSegreteria;
import java.util.Date;
import calendar.JDateChooser;
import javax.swing.text.Document;
import utility.LimitedTextField;
import javax.swing.JLabel;
import javax.swing.Box;
import java.awt.LayoutManager;
import java.awt.Container;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTable;
import oggetti.Medico;
import javax.swing.JTextField;
import javax.swing.JFrame;

public class FrameModificaMedico extends JFrame
{
    private JTextField textFieldNome;
    private JTextField textFieldCognome;
    private JTextField textFieldCodFiscale;
    private JTextField textFieldData;
    
    public FrameModificaMedico(final Medico medico, final JTable table, final JFrame frame) {
        this.setSize(500, 250);
        this.setResizable(false);
        this.setTitle("Modifica " + medico.getNome() + " " + medico.getCognome());
        final String nome = medico.getNome();
        final String cognome = medico.getCognome();
        final String codFiscale = medico.getCodFiscale();
        final String dataDiNascita = medico.getDataDiNascita();
        final JPanel panel = new JPanel();
        this.getContentPane().add(panel, "West");
        panel.setLayout(new BoxLayout(panel, 1));
        final Component verticalStrut = Box.createVerticalStrut(20);
        panel.add(verticalStrut);
        final JPanel panel_2 = new JPanel();
        panel.add(panel_2);
        final JLabel lblNome = new JLabel("Nome : ");
        panel_2.add(lblNome);
        (this.textFieldNome = new JTextField(nome)).setDocument(new LimitedTextField(20));
        panel_2.add(this.textFieldNome);
        this.textFieldNome.setColumns(10);
        final Component verticalStrut_1 = Box.createVerticalStrut(20);
        panel.add(verticalStrut_1);
        final JPanel panel_3 = new JPanel();
        panel.add(panel_3);
        final JLabel lblCodFiscale = new JLabel("Cod Fiscale : ");
        panel_3.add(lblCodFiscale);
        (this.textFieldCodFiscale = new JTextField(codFiscale)).setDocument(new LimitedTextField(16));
        panel_3.add(this.textFieldCodFiscale);
        this.textFieldCodFiscale.setColumns(10);
        final Component verticalStrut_2 = Box.createVerticalStrut(20);
        panel.add(verticalStrut_2);
        final JPanel panel_4 = new JPanel();
        this.getContentPane().add(panel_4, "East");
        panel_4.setLayout(new BoxLayout(panel_4, 1));
        final Component verticalStrut_3 = Box.createVerticalStrut(20);
        panel_4.add(verticalStrut_3);
        final JPanel panel_5 = new JPanel();
        panel_4.add(panel_5);
        final JLabel lblCognome = new JLabel("Cognome : ");
        panel_5.add(lblCognome);
        (this.textFieldCognome = new JTextField(cognome)).setDocument(new LimitedTextField(20));
        panel_5.add(this.textFieldCognome);
        this.textFieldCognome.setColumns(10);
        final Component verticalStrut_4 = Box.createVerticalStrut(20);
        panel_4.add(verticalStrut_4);
        final JPanel panel_6 = new JPanel();
        panel_4.add(panel_6);
        final JLabel lblData = new JLabel("Data di nascita : ");
        panel_6.add(lblData);
        final JDateChooser dateChooser = new JDateChooser();
        dateChooser.setMaxSelectableDate(new Date());
        ((JTextField)dateChooser.getDateEditor().getUiComponent()).setEditable(false);
        ((JTextField)dateChooser.getDateEditor().getUiComponent()).setText(medico.getDataDiNascita());
        dateChooser.getCalendarButton().setIcon(new ImageIcon(FrameSegreteria.class.getResource("/com/toedter/calendar/demo/images/JDateChooserColor16.gif")));
        panel_6.add(dateChooser);
        final Component verticalStrut_5 = Box.createVerticalStrut(20);
        panel_4.add(verticalStrut_5);
        final JPanel panel_SudPerBottone = new JPanel();
        this.getContentPane().add(panel_SudPerBottone, "South");
        final Component verticalStrut_6 = Box.createVerticalStrut(80);
        panel_SudPerBottone.add(verticalStrut_6);
        final JButton btnSalva = new JButton("Salva");
        btnSalva.addMouseListener(new ClickSxPerModificareMedico(medico, this.textFieldNome, this.textFieldCognome, this.textFieldCodFiscale, dateChooser, table, frame));
        panel_SudPerBottone.add(btnSalva);
        final Component horizontalStrut_1 = Box.createHorizontalStrut(20);
        panel_SudPerBottone.add(horizontalStrut_1);
        final JButton btnReset = new JButton("Reset");
        btnReset.addMouseListener(new ClickSxPerResetCampi(this.textFieldNome, this.textFieldCognome, this.textFieldCodFiscale, (JTextField)dateChooser.getDateEditor().getUiComponent()));
        panel_SudPerBottone.add(btnReset);
        final Component horizontalStrut = Box.createHorizontalStrut(15);
        this.getContentPane().add(horizontalStrut, "Center");
    }
}
