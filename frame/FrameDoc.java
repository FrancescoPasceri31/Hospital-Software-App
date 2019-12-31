// 
// Decompiled by Procyon v0.5.36
// 

package frame;

import listener.SelezioneCellaInUnFrameTable;
import java.util.Iterator;
import java.util.ArrayList;
import listenerFrameDoc.SelezionaCellaNotifica;
import java.awt.Point;
import javax.swing.table.TableModel;
import utility.JTableModelMia;
import oggetti.Paziente;
import utility.Appuntamento;
import javax.swing.JTable;
import java.awt.event.MouseEvent;
import javax.swing.event.DocumentListener;
import listenerFrameDoc.AscoltatoreFiltroJTableFrameDoc;
import listenerFrameDoc.ClickReturnHome;
import listenerFrameDoc.ClickConsultareAppuntamenti;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import java.awt.CardLayout;
import javax.swing.text.Document;
import utility.LimitedTextField;
import javax.swing.BorderFactory;
import listenerFrameDoc.ClickMostraOrario;
import listenerFrameDoc.ClickApreFrameNuovoAppuntamento;
import java.awt.event.ActionListener;
import listenerFrameDoc.AscoltatoreClickApreFrameNuovoPaziente;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import java.awt.event.MouseListener;
import listener.Logout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.Box;
import java.awt.Container;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import oggetti.Medico;
import javax.swing.JFrame;

public class FrameDoc extends JFrame
{
    private Medico medico;
    private JTextField textFieldCerca;
    private String[][] matricePaz;
    public boolean appuntamentiAperti;
    private FrameDoc frame;
    
    public FrameDoc(final Medico medico) {
        this.medico = medico;
        this.setTitle("Medico");
        this.getContentPane().setLayout(new BorderLayout(0, 0));
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final int width = (int)screenSize.getWidth();
        final int height = (int)screenSize.getHeight();
        this.setLocation(width - 5 * width / 6, height - 5 * height / 6);
        this.appuntamentiAperti = false;
        final JPanel panel_South = new JPanel();
        panel_South.setBackground(new Color(255, 140, 0));
        this.getContentPane().add(panel_South, "South");
        panel_South.setLayout(new BoxLayout(panel_South, 0));
        final Component horizontalStrut_1 = Box.createHorizontalStrut(5);
        panel_South.add(horizontalStrut_1);
        final JLabel labelNome = new JLabel(medico.getNome().toUpperCase());
        labelNome.setFont(new Font("Tahoma", 1, 11));
        labelNome.setBackground(new Color(255, 140, 0));
        panel_South.add(labelNome);
        final Component horizontalStrut = Box.createHorizontalStrut(5);
        panel_South.add(horizontalStrut);
        final JLabel labelCognome = new JLabel(medico.getCognome().toUpperCase());
        labelCognome.setFont(new Font("Tahoma", 1, 11));
        panel_South.add(labelCognome);
        final JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 140, 0));
        final FlowLayout flowLayout = (FlowLayout)panel_1.getLayout();
        flowLayout.setAlignment(4);
        panel_South.add(panel_1);
        final JButton btnLogout = new JButton("Logout");
        btnLogout.setFont(new Font("Tahoma", 1, 11));
        btnLogout.addMouseListener(new Logout(this));
        panel_1.add(btnLogout);
        final JPanel panel_North = new JPanel();
        this.getContentPane().add(panel_North, "North");
        panel_North.setLayout(new BoxLayout(panel_North, 0));
        final JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(255, 140, 0));
        panel_North.add(menuBar);
        final JButton btnHomeButton = new JButton("");
        btnHomeButton.setForeground(new Color(255, 0, 0));
        btnHomeButton.setBackground(Color.RED);
        btnHomeButton.setIcon(new ImageIcon(FrameDoc.class.getResource("/javax/swing/plaf/metal/icons/ocean/homeFolder.gif")));
        menuBar.add(btnHomeButton);
        final JMenu mnAggiungi = new JMenu("Aggiungi");
        mnAggiungi.setFont(new Font("Segoe UI", 1, 12));
        menuBar.add(mnAggiungi);
        final JMenuItem mntmPaziente = new JMenuItem("Paziente");
        mntmPaziente.setFont(new Font("Segoe UI", 1, 12));
        mntmPaziente.addActionListener(new AscoltatoreClickApreFrameNuovoPaziente(this, medico));
        mntmPaziente.setIcon(new ImageIcon(FrameDoc.class.getResource("/javax/swing/plaf/basic/icons/JavaCup16.png")));
        mnAggiungi.add(mntmPaziente);
        final JMenuItem mntmAppuntamento = new JMenuItem("Appuntamento");
        mntmAppuntamento.setFont(new Font("Segoe UI", 1, 12));
        mntmAppuntamento.addActionListener(new ClickApreFrameNuovoAppuntamento(medico.getTipoReparto(), this, medico));
        mnAggiungi.add(mntmAppuntamento);
        final JMenu mnConsulta = new JMenu("Consulta");
        mnConsulta.setFont(new Font("Segoe UI", 1, 12));
        menuBar.add(mnConsulta);
        final JMenuItem mntmTurni = new JMenuItem("Turni");
        mntmTurni.setFont(new Font("Segoe UI", 1, 12));
        mntmTurni.addActionListener(new ClickMostraOrario(medico.getTipoReparto()));
        mnConsulta.add(mntmTurni);
        final JMenuItem mntmNotifiche = new JMenuItem("Notifiche");
        mntmNotifiche.setFont(new Font("Segoe UI", 1, 12));
        mnConsulta.add(mntmNotifiche);
        final JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(255, 140, 0));
        menuBar.add(panel_2);
        final FlowLayout flowLayout_1 = (FlowLayout)panel_2.getLayout();
        flowLayout_1.setAlignment(4);
        (this.textFieldCerca = new JTextField()).setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.textFieldCerca.setToolTipText("Cerca per cognome");
        this.textFieldCerca.setColumns(20);
        this.textFieldCerca.setDocument(new LimitedTextField(20));
        final JPanel panel_Center = new JPanel();
        final CardLayout cardLayout = new CardLayout();
        panel_Center.setLayout(cardLayout);
        final JPanel panel_3 = new JPanel();
        final JTable table = this.creaPannelloListaPazientiDelReparto();
        panel_3.setLayout(new BoxLayout(panel_3, 0));
        final JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setFont(new Font("Tahoma", 1, 11));
        scrollPane.setPreferredSize(new Dimension(panel_Center.getWidth(), panel_Center.getHeight()));
        panel_3.add(scrollPane);
        final JPanel panel_4 = new JPanel();
        final JTable tableAppuntamenti = this.creaPannelloListaNotificheDelReparto();
        panel_4.setLayout(new BoxLayout(panel_4, 0));
        final JScrollPane scrollPaneNotifiche = new JScrollPane(tableAppuntamenti);
        scrollPaneNotifiche.setPreferredSize(new Dimension(panel_Center.getWidth(), panel_Center.getHeight()));
        panel_4.add(scrollPaneNotifiche);
        panel_Center.add(panel_3, "panel1");
        panel_Center.add(panel_4, "panel2");
        this.getContentPane().add(panel_Center, "Center");
        mntmNotifiche.addActionListener(new ClickConsultareAppuntamenti(panel_Center, this, cardLayout));
        btnHomeButton.addMouseListener(new ClickReturnHome(panel_Center, this, cardLayout));
        this.textFieldCerca.getDocument().addDocumentListener(new AscoltatoreFiltroJTableFrameDoc(this.textFieldCerca, table));
        panel_2.add(this.textFieldCerca);
        final JPanel panel = new JPanel();
        panel_Center.add(panel, "North");
        panel.setLayout(new BoxLayout(panel, 0));
        final JPanel panel_5 = new JPanel();
        panel.add(panel_5);
        panel_5.setLayout(new FlowLayout(4, 5, 5));
        final JPanel panel_West = new JPanel();
        this.getContentPane().add(panel_West, "East");
        panel_West.setLayout(new BorderLayout(0, 0));
        final Component horizontalStrut_2 = Box.createHorizontalStrut(2);
        panel_West.add(horizontalStrut_2, "North");
        final JPanel panel_East = new JPanel();
        this.getContentPane().add(panel_East, "West");
        panel_East.setLayout(new BoxLayout(panel_East, 0));
        final Component horizontalStrut_3 = Box.createHorizontalStrut(2);
        panel_East.add(horizontalStrut_3);
        (this.frame = this).addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(final MouseEvent e) {
            }
            
            @Override
            public void mousePressed(final MouseEvent e) {
            }
            
            @Override
            public void mouseExited(final MouseEvent e) {
            }
            
            @Override
            public void mouseEntered(final MouseEvent e) {
            }
            
            @Override
            public void mouseClicked(final MouseEvent e) {
                if (e.getButton() == 3) {
                    FrameDoc.this.frame.dispose();
                    new FrameDoc(medico).setVisible(true);
                }
            }
        });
        this.setSize(800, 600);
    }
    
    public JTable creaPannelloListaNotificheDelReparto() {
        final ArrayList<Appuntamento> listaNotifiche = this.medico.getTipoReparto().getListaAppuntamento();
        final String[][] matrice = new String[listaNotifiche.size()][5];
        int pos = 0;
        for (final Appuntamento notifica : listaNotifiche) {
            Paziente paziente = null;
            for (final Paziente p1 : this.medico.getTipoReparto().getListaPazienti()) {
                if (p1.getCodFiscale().equalsIgnoreCase(notifica.getCodFiscalePaziente())) {
                    paziente = p1;
                }
            }
            if (paziente != null) {
                matrice[pos][0] = notifica.getTipologia().toUpperCase();
                matrice[pos][1] = paziente.getCognome();
                matrice[pos][2] = paziente.getNome();
                matrice[pos][3] = paziente.getCodFiscale().toUpperCase();
                matrice[pos][4] = notifica.getData();
                ++pos;
            }
        }
        final String[] testate = { "Tipologia", "Cognome", "Nome", "Cod.Fiscale", "Data Fissata" };
        final JTable table = new JTable(new JTableModelMia(matrice, testate)) {
            @Override
            public String getToolTipText(final MouseEvent e) {
                String tip = null;
                final Point p = e.getPoint();
                final int rowIndex = this.rowAtPoint(p);
                final int colIndex = this.columnAtPoint(p);
                try {
                    tip = this.getValueAt(rowIndex, colIndex).toString();
                }
                catch (RuntimeException ex) {}
                return tip;
            }
        };
        table.addMouseListener(new SelezionaCellaNotifica(matrice, table, this.medico, this));
        table.setAutoCreateRowSorter(true);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setBackground(Color.GREEN);
        table.getTableHeader().setFont(new Font("Tahoma", 1, 11));
        return table;
    }
    
    public JTable creaPannelloListaPazientiDelReparto() {
        final ArrayList<Paziente> listaPaz = this.medico.getTipoReparto().getListaPazienti();
        final String[][] matrice = new String[listaPaz.size()][4];
        int pos = 0;
        for (final Paziente paziente : listaPaz) {
            matrice[pos][0] = paziente.getCognome();
            matrice[pos][1] = paziente.getNome();
            matrice[pos][2] = paziente.getCodFiscale().toUpperCase();
            matrice[pos][3] = paziente.getDataDiNascita();
            ++pos;
        }
        final String[] arrayTestate = { "Cognome", "Nome", "Cod.Fiscale", "Data di nascita" };
        final JTable table = new JTable(new JTableModelMia(matrice, arrayTestate)) {
            @Override
            public String getToolTipText(final MouseEvent e) {
                String tip = null;
                final Point p = e.getPoint();
                final int rowIndex = this.rowAtPoint(p);
                final int colIndex = this.columnAtPoint(p);
                try {
                    tip = this.getValueAt(rowIndex, colIndex).toString();
                }
                catch (RuntimeException ex) {}
                return tip;
            }
        };
        table.addMouseListener(new SelezioneCellaInUnFrameTable(table, matrice, "Pazienti", this, this.medico));
        table.setAutoCreateRowSorter(true);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setBackground(Color.GREEN);
        table.getTableHeader().setFont(new Font("Tahoma", 1, 11));
        this.matricePaz = matrice;
        return table;
    }
    
    public boolean getBooleanNotificheVisibili() {
        return this.appuntamentiAperti;
    }
    
    public void setBooleanNotificheVisibili(final boolean appuntamentiAperti) {
        this.appuntamentiAperti = appuntamentiAperti;
    }
    
    public Medico getMedico() {
        return this.medico;
    }
}
