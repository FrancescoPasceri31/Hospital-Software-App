// 
// Decompiled by Procyon v0.5.36
// 

package calendar.components;

import java.awt.event.FocusEvent;
import javax.swing.JFrame;
import javax.swing.UIManager;
import java.awt.event.ActionEvent;
import javax.swing.event.CaretEvent;
import java.awt.Font;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import java.awt.Component;
import javax.swing.JComponent;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.event.FocusListener;
import java.awt.event.ActionListener;
import javax.swing.event.CaretListener;
import javax.swing.event.ChangeListener;
import javax.swing.JPanel;

public class JSpinField extends JPanel implements ChangeListener, CaretListener, ActionListener, FocusListener
{
    private static final long serialVersionUID = 1694904792717740650L;
    protected JSpinner spinner;
    protected JTextField textField;
    protected int min;
    protected int max;
    protected int value;
    protected Color darkGreen;
    
    public JSpinField() {
        this(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public JSpinField(final int min, int max) {
        this.setName("JSpinField");
        this.min = min;
        if (max < min) {
            max = min;
        }
        this.max = max;
        this.value = 0;
        if (this.value < min) {
            this.value = min;
        }
        if (this.value > max) {
            this.value = max;
        }
        this.darkGreen = new Color(0, 150, 0);
        this.setLayout(new BorderLayout());
        (this.textField = new JTextField()).addCaretListener(this);
        this.textField.addActionListener(this);
        this.textField.setHorizontalAlignment(4);
        this.textField.setBorder(BorderFactory.createEmptyBorder());
        this.textField.setText(Integer.toString(this.value));
        this.textField.addFocusListener(this);
        (this.spinner = new JSpinner() {
            private static final long serialVersionUID = -6287709243342021172L;
            private JTextField textField = new JTextField();
            
            @Override
            public Dimension getPreferredSize() {
                final Dimension size = super.getPreferredSize();
                return new Dimension(size.width, this.textField.getPreferredSize().height);
            }
        }).setEditor(this.textField);
        this.spinner.addChangeListener(this);
        this.add(this.spinner, "Center");
    }
    
    public void adjustWidthToMaximumValue() {
        final JTextField testTextField = new JTextField(Integer.toString(this.max));
        final int width = testTextField.getPreferredSize().width;
        final int height = testTextField.getPreferredSize().height;
        this.textField.setPreferredSize(new Dimension(width, height));
        this.textField.revalidate();
    }
    
    @Override
    public void stateChanged(final ChangeEvent e) {
        final SpinnerNumberModel model = (SpinnerNumberModel)this.spinner.getModel();
        final int value = model.getNumber().intValue();
        this.setValue(value);
    }
    
    protected void setValue(final int newValue, final boolean updateTextField, final boolean firePropertyChange) {
        final int oldValue = this.value;
        if (newValue < this.min) {
            this.value = this.min;
        }
        else if (newValue > this.max) {
            this.value = this.max;
        }
        else {
            this.value = newValue;
        }
        if (updateTextField) {
            this.textField.setText(Integer.toString(this.value));
            this.textField.setForeground(Color.black);
        }
        if (firePropertyChange) {
            this.firePropertyChange("value", oldValue, this.value);
        }
    }
    
    public void setValue(final int newValue) {
        this.setValue(newValue, true, true);
        this.spinner.setValue(new Integer(this.value));
    }
    
    public int getValue() {
        return this.value;
    }
    
    public void setMinimum(final int newMinimum) {
        this.min = newMinimum;
    }
    
    public int getMinimum() {
        return this.min;
    }
    
    public void setMaximum(final int newMaximum) {
        this.max = newMaximum;
    }
    
    public void setHorizontalAlignment(final int alignment) {
        this.textField.setHorizontalAlignment(alignment);
    }
    
    public int getMaximum() {
        return this.max;
    }
    
    @Override
    public void setFont(final Font font) {
        if (this.textField != null) {
            this.textField.setFont(font);
        }
    }
    
    @Override
    public void setForeground(final Color fg) {
        if (this.textField != null) {
            this.textField.setForeground(fg);
        }
    }
    
    @Override
    public void caretUpdate(final CaretEvent e) {
        try {
            final int testValue = Integer.valueOf(this.textField.getText());
            if (testValue >= this.min && testValue <= this.max) {
                this.textField.setForeground(this.darkGreen);
                this.setValue(testValue, false, true);
            }
            else {
                this.textField.setForeground(Color.red);
            }
        }
        catch (Exception ex) {
            if (ex instanceof NumberFormatException) {
                this.textField.setForeground(Color.red);
            }
        }
        this.textField.repaint();
    }
    
    @Override
    public void actionPerformed(final ActionEvent e) {
        if (this.textField.getForeground().equals(this.darkGreen)) {
            this.setValue(Integer.valueOf(this.textField.getText()));
        }
    }
    
    @Override
    public void setEnabled(final boolean enabled) {
        super.setEnabled(enabled);
        this.spinner.setEnabled(enabled);
        this.textField.setEnabled(enabled);
        if (!enabled) {
            this.textField.setBackground(UIManager.getColor("TextField.inactiveBackground"));
        }
    }
    
    public Component getSpinner() {
        return this.spinner;
    }
    
    public static void main(final String[] s) {
        final JFrame frame = new JFrame("JSpinField");
        frame.getContentPane().add(new JSpinField());
        frame.pack();
        frame.setVisible(true);
    }
    
    @Override
    public void focusGained(final FocusEvent e) {
    }
    
    @Override
    public void focusLost(final FocusEvent e) {
        this.actionPerformed(null);
    }
}
