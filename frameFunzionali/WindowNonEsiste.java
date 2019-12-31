// 
// Decompiled by Procyon v0.5.36
// 

package frameFunzionali;

import javax.swing.BorderFactory;
import utility.ControlloWindowUnica;
import javax.swing.Box;
import java.awt.event.MouseListener;
import listener.ContinuaNo;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.Container;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JPanel;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import javax.swing.JWindow;

public class WindowNonEsiste extends JWindow
{
    public WindowNonEsiste(final String nomeNonEsistente) {
        this.setSize(300, 100);
        this.getContentPane().setLayout(new BorderLayout(0, 0));
        final JPanel panel_2 = new JPanel();
        this.getContentPane().add(panel_2);
        panel_2.setLayout(new BoxLayout(panel_2, 1));
        final JPanel panel = new JPanel();
        panel.setBackground(UIManager.getColor("List.selectionBackground"));
        panel_2.add(panel);
        final JLabel lblNewLabel = new JLabel(String.valueOf(nomeNonEsistente) + "errato.");
        lblNewLabel.setForeground(new Color(0, 0, 0));
        panel.add(lblNewLabel);
        final JPanel panel_3 = new JPanel();
        panel_3.setBackground(UIManager.getColor("Menu.selectionBackground"));
        panel_2.add(panel_3);
        final JButton btnOk = new JButton("Ok");
        btnOk.setForeground(new Color(0, 0, 0));
        btnOk.addMouseListener(new ContinuaNo(this));
        panel_3.add(btnOk);
        final JPanel panel_4 = new JPanel();
        panel_4.setBackground(UIManager.getColor("MenuBar.shadow"));
        this.getContentPane().add(panel_4, "North");
        final Component verticalStrut_1 = Box.createVerticalStrut(2);
        panel_4.add(verticalStrut_1);
        final JPanel panel_5 = new JPanel();
        panel_5.setBackground(UIManager.getColor("MenuBar.shadow"));
        this.getContentPane().add(panel_5, "South");
        final Component verticalStrut = Box.createVerticalStrut(2);
        panel_5.add(verticalStrut);
        final JPanel panel_6 = new JPanel();
        panel_6.setBackground(UIManager.getColor("MenuBar.shadow"));
        this.getContentPane().add(panel_6, "West");
        final Component horizontalStrut = Box.createHorizontalStrut(2);
        panel_6.add(horizontalStrut);
        final JPanel panel_7 = new JPanel();
        panel_7.setBackground(UIManager.getColor("MenuBar.shadow"));
        this.getContentPane().add(panel_7, "East");
        final Component horizontalStrut_1 = Box.createHorizontalStrut(2);
        panel_7.add(horizontalStrut_1);
        this.setLocation(456, 240);
        ControlloWindowUnica.controlloWindowUnica(this);
        this.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        this.setVisible(true);
    }
    
    public WindowNonEsiste(final String nomeNonEsistente, final String giaEsiste) {
        this.setSize(300, 100);
        this.getContentPane().setLayout(new BorderLayout(0, 0));
        final JPanel panel_2 = new JPanel();
        this.getContentPane().add(panel_2);
        panel_2.setLayout(new BoxLayout(panel_2, 1));
        final JPanel panel = new JPanel();
        panel.setBackground(UIManager.getColor("Menu.selectionBackground"));
        panel_2.add(panel);
        final JLabel lblNewLabel = new JLabel(String.valueOf(nomeNonEsistente) + "gia' esistente.");
        lblNewLabel.setForeground(UIManager.getColor("List.foreground"));
        panel.add(lblNewLabel);
        final JPanel panel_3 = new JPanel();
        panel_3.setBackground(UIManager.getColor("Menu.selectionBackground"));
        panel_2.add(panel_3);
        final JButton btnOk = new JButton("Ok");
        btnOk.setForeground(UIManager.getColor("Menu.foreground"));
        btnOk.addMouseListener(new ContinuaNo(this));
        panel_3.add(btnOk);
        final JPanel panel_4 = new JPanel();
        panel_4.setBackground(UIManager.getColor("MenuBar.shadow"));
        this.getContentPane().add(panel_4, "North");
        final Component verticalStrut_1 = Box.createVerticalStrut(2);
        panel_4.add(verticalStrut_1);
        final JPanel panel_5 = new JPanel();
        panel_5.setBackground(UIManager.getColor("MenuBar.shadow"));
        this.getContentPane().add(panel_5, "South");
        final Component verticalStrut = Box.createVerticalStrut(2);
        panel_5.add(verticalStrut);
        final JPanel panel_6 = new JPanel();
        panel_6.setBackground(UIManager.getColor("MenuBar.shadow"));
        this.getContentPane().add(panel_6, "West");
        final Component horizontalStrut = Box.createHorizontalStrut(2);
        panel_6.add(horizontalStrut);
        final JPanel panel_7 = new JPanel();
        panel_7.setBackground(UIManager.getColor("MenuBar.shadow"));
        this.getContentPane().add(panel_7, "East");
        final Component horizontalStrut_1 = Box.createHorizontalStrut(2);
        panel_7.add(horizontalStrut_1);
        this.setLocation(456, 240);
        ControlloWindowUnica.controlloWindowUnica(this);
        this.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        this.setVisible(true);
    }
}
