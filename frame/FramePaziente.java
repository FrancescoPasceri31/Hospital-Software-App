// 
// Decompiled by Procyon v0.5.36
// 

package frame;

import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.JScrollPane;
import javax.swing.table.TableModel;
import javax.swing.JTable;
import utility.JTableModelMia;
import utility.CartellaClinica;
import listenerFramePaziente.SceltaPannello;
import javax.swing.JList;
import java.awt.SystemColor;
import java.awt.BorderLayout;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.Box;
import javax.swing.JLabel;
import listener.Logout;
import listenerFramePaziente.AscoltatoreAppuntamento;
import java.awt.Font;
import java.awt.event.MouseListener;
import listenerFramePaziente.AscoltatoreOrario;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.Container;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.event.WindowListener;
import listener.ConfermaUscita;
import oggetti.Paziente;
import java.awt.CardLayout;
import javax.swing.JFrame;

public class FramePaziente extends JFrame
{
    private final CardLayout cardLayout;
    private boolean cambioCard;
    
    public FramePaziente(final Paziente paziente) {
        this.setTitle("Frame Paziente");
        this.setDefaultCloseOperation(0);
        this.addWindowListener(new ConfermaUscita(this));
        this.setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 35);
        final JPanel panelLogout = new JPanel();
        panelLogout.setBackground(new Color(255, 140, 0));
        this.getContentPane().add(panelLogout, "South");
        panelLogout.setLayout(new BoxLayout(panelLogout, 0));
        final JPanel panel = new JPanel();
        final FlowLayout flowLayout_1 = (FlowLayout)panel.getLayout();
        flowLayout_1.setAlignment(3);
        panel.setBackground(new Color(255, 140, 0));
        panelLogout.add(panel);
        final JButton btnOrarioReparto = new JButton("Orario reparto");
        btnOrarioReparto.addMouseListener(new AscoltatoreOrario(btnOrarioReparto, paziente.getTipoReparto()));
        btnOrarioReparto.setFont(new Font("Tahoma", 1, 11));
        panel.add(btnOrarioReparto);
        final JButton btnVisualizzaNotifiche = new JButton("Visualizza notifiche");
        btnVisualizzaNotifiche.addMouseListener(new AscoltatoreAppuntamento(btnVisualizzaNotifiche, paziente));
        btnVisualizzaNotifiche.setFont(new Font("Tahoma", 1, 11));
        panel.add(btnVisualizzaNotifiche);
        final JButton btnLogout = new JButton("Logout");
        btnLogout.addMouseListener(new Logout(this));
        btnLogout.setFont(new Font("Tahoma", 1, 11));
        panelLogout.add(btnLogout);
        final JPanel panel_Dati = new JPanel();
        final FlowLayout flowLayout = (FlowLayout)panel_Dati.getLayout();
        flowLayout.setAlignment(3);
        panel_Dati.setBackground(new Color(255, 140, 0));
        this.getContentPane().add(panel_Dati, "North");
        final JLabel lblCognome = new JLabel(paziente.getCognome().toUpperCase());
        panel_Dati.add(lblCognome);
        final JLabel lblNome = new JLabel(paziente.getNome().toUpperCase());
        panel_Dati.add(lblNome);
        final Component horizontalStrut = Box.createHorizontalStrut(20);
        panel_Dati.add(horizontalStrut);
        final JLabel lblReparto = new JLabel("Reparto: ");
        lblReparto.setFont(new Font("Tahoma", 1, 11));
        panel_Dati.add(lblReparto);
        final JLabel lblRepartoNome = new JLabel(paziente.getTipoReparto().getNomeReparto().toUpperCase());
        panel_Dati.add(lblRepartoNome);
        final JPanel panel_Lista = new JPanel();
        panel_Lista.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        this.getContentPane().add(panel_Lista, "Center");
        panel_Lista.setLayout(new BorderLayout(0, 0));
        final JPanel panel_2 = new JPanel();
        panel_2.setBackground(SystemColor.activeCaption);
        panel_Lista.add(panel_2, "West");
        panel_2.setLayout(new BoxLayout(panel_2, 1));
        final String[] array = { "Accettazione", "Diario clinica" };
        final JList<String> list = new JList<String>(array);
        panel_2.add(list);
        final JPanel panel_3 = new JPanel();
        panel_3.setLayout(this.cardLayout = new CardLayout());
        this.cambioCard = false;
        list.addMouseListener(new SceltaPannello(this.cardLayout, panel_3, this.cambioCard));
        final JPanel panel_Accettazione = CartellaClinica.deserializzaPannelloAccettazione(paziente);
        this.disabilitaTutto(panel_Accettazione);
        panel_3.add(panel_Accettazione, "1");
        final Object[][] dataRow = CartellaClinica.deserializzaMatriceDiarioClinico(paziente);
        final JPanel panel_DiarioClinico = new JPanel();
        panel_DiarioClinico.setLayout(new BoxLayout(panel_DiarioClinico, 0));
        final String[] testate = { "DATA : ORA", "DECORSO" };
        final JTable tabellaDiario = new JTable(new JTableModelMia(dataRow, testate));
        final JScrollPane spTable = new JScrollPane(tabellaDiario);
        panel_DiarioClinico.add(spTable);
        panel_3.add(panel_DiarioClinico, "2");
        panel_Lista.add(panel_3, "Center");
    }
    
    private void disabilitaTutto(final JPanel panel) {
        for (int i = 0; i < panel.getComponentCount(); ++i) {
            if (panel.getComponent(i).getClass().equals(JPanel.class)) {
                this.disabilitaTutto((JPanel)panel.getComponent(i));
            }
            else if (!panel.getComponent(i).getClass().equals(JToggleButton.class)) {
                if (panel.getComponent(i).getClass().equals(JScrollPane.class)) {
                    final JScrollPane sp = (JScrollPane)panel.getComponent(i);
                    for (int j = 0; j < sp.getViewport().getComponentCount(); ++j) {
                        if (sp.getViewport().getComponent(j).getClass().equals(JTextArea.class)) {
                            ((JTextArea)sp.getViewport().getComponent(j)).setEditable(false);
                        }
                    }
                }
                panel.getComponent(i).setFont(new Font("Tahoma", 0, 11));
                panel.getComponent(i).setEnabled(false);
            }
        }
    }
}
