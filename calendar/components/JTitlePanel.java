// 
// Decompiled by Procyon v0.5.36
// 

package calendar.components;

import java.awt.Paint;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import java.awt.Component;
import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import javax.swing.border.Border;
import javax.swing.JComponent;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JTitlePanel extends JPanel
{
    private static final long serialVersionUID = 9104873267039717087L;
    protected JPanel northPanel;
    protected JLabel label;
    
    public JTitlePanel(final String title, final Icon icon, final JComponent content, final Border outerBorder) {
        this.setLayout(new BorderLayout());
        (this.label = new JLabel(title, icon, 10)).setForeground(Color.WHITE);
        final GradientPanel titlePanel = new GradientPanel(Color.BLACK, null);
        titlePanel.setLayout(new BorderLayout());
        titlePanel.add(this.label, "West");
        int borderOffset = 2;
        if (icon == null) {
            ++borderOffset;
        }
        titlePanel.setBorder(BorderFactory.createEmptyBorder(borderOffset, 4, borderOffset, 1));
        this.add(titlePanel, "North");
        final JPanel northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());
        northPanel.add(content, "North");
        northPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        this.add(northPanel, "Center");
        if (outerBorder == null) {
            this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }
        else {
            this.setBorder(BorderFactory.createCompoundBorder(outerBorder, BorderFactory.createLineBorder(Color.GRAY)));
        }
    }
    
    public void setTitle(final String label, final Icon icon) {
        this.label.setText(label);
        this.label.setIcon(icon);
    }
    
    private static class GradientPanel extends JPanel
    {
        private static final long serialVersionUID = -6385751027379193053L;
        
        private GradientPanel(final Color background) {
            this.setBackground(background);
        }
        
        public void paintComponent(final Graphics g) {
            super.paintComponent(g);
            if (this.isOpaque()) {
                final Color controlColor = new Color(165, 201, 215);
                final int width = this.getWidth();
                final int height = this.getHeight();
                final Graphics2D g2 = (Graphics2D)g;
                final Paint oldPaint = g2.getPaint();
                g2.setPaint(new GradientPaint(0.0f, 0.0f, this.getBackground(), (float)width, 0.0f, controlColor));
                g2.fillRect(0, 0, width, height);
                g2.setPaint(oldPaint);
            }
        }
    }
}
