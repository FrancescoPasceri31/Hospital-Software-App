// 
// Decompiled by Procyon v0.5.36
// 

package calendar;

import javax.swing.JFrame;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.ItemEvent;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.awt.Component;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JComponent;
import java.awt.Dimension;
import javax.swing.JTextField;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import java.util.Locale;
import javax.swing.event.ChangeListener;
import java.awt.event.ItemListener;
import javax.swing.JPanel;

public class JMonthChooser extends JPanel implements ItemListener, ChangeListener
{
    private static final long serialVersionUID = -2028361332231218527L;
    protected boolean hasSpinner;
    private Locale locale;
    private int month;
    private int oldSpinnerValue;
    private JDayChooser dayChooser;
    private JYearChooser yearChooser;
    private JComboBox comboBox;
    private JSpinner spinner;
    private boolean initialized;
    private boolean localInitialize;
    
    public JMonthChooser() {
        this(true);
    }
    
    public JMonthChooser(final boolean hasSpinner) {
        this.oldSpinnerValue = 0;
        this.setName("JMonthChooser");
        this.hasSpinner = hasSpinner;
        this.setLayout(new BorderLayout());
        (this.comboBox = new JComboBox()).addItemListener(this);
        this.locale = Locale.getDefault();
        this.initNames();
        if (hasSpinner) {
            (this.spinner = new JSpinner() {
                private static final long serialVersionUID = 1L;
                private JTextField textField = new JTextField();
                
                @Override
                public Dimension getPreferredSize() {
                    final Dimension size = super.getPreferredSize();
                    return new Dimension(size.width, this.textField.getPreferredSize().height);
                }
            }).addChangeListener(this);
            this.spinner.setEditor(this.comboBox);
            this.comboBox.setBorder(new EmptyBorder(0, 0, 0, 0));
            this.updateUI();
            this.add(this.spinner, "West");
        }
        else {
            this.add(this.comboBox, "West");
        }
        this.initialized = true;
        this.setMonth(Calendar.getInstance().get(2));
    }
    
    public void initNames() {
        this.localInitialize = true;
        final DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(this.locale);
        final String[] monthNames = dateFormatSymbols.getMonths();
        if (this.comboBox.getItemCount() == 12) {
            this.comboBox.removeAllItems();
        }
        for (int i = 0; i < 12; ++i) {
            this.comboBox.addItem(monthNames[i]);
        }
        this.localInitialize = false;
        this.comboBox.setSelectedIndex(this.month);
    }
    
    @Override
    public void stateChanged(final ChangeEvent e) {
        final SpinnerNumberModel model = (SpinnerNumberModel)((JSpinner)e.getSource()).getModel();
        final int value = model.getNumber().intValue();
        final boolean increase = value > this.oldSpinnerValue;
        this.oldSpinnerValue = value;
        int month = this.getMonth();
        if (increase) {
            if (++month == 12) {
                month = 0;
                if (this.yearChooser != null) {
                    int year = this.yearChooser.getYear();
                    ++year;
                    this.yearChooser.setYear(year);
                }
            }
        }
        else if (--month == -1) {
            month = 11;
            if (this.yearChooser != null) {
                int year = this.yearChooser.getYear();
                --year;
                this.yearChooser.setYear(year);
            }
        }
        this.setMonth(month);
    }
    
    @Override
    public void itemStateChanged(final ItemEvent e) {
        if (e.getStateChange() == 1) {
            final int index = this.comboBox.getSelectedIndex();
            if (index >= 0 && index != this.month) {
                this.setMonth(index, false);
            }
        }
    }
    
    private void setMonth(final int newMonth, final boolean select) {
        if (!this.initialized || this.localInitialize) {
            return;
        }
        final int oldMonth = this.month;
        this.month = newMonth;
        if (select) {
            this.comboBox.setSelectedIndex(this.month);
        }
        if (this.dayChooser != null) {
            this.dayChooser.setMonth(this.month);
        }
        this.firePropertyChange("month", oldMonth, this.month);
    }
    
    public void setMonth(final int newMonth) {
        if (newMonth < 0 || newMonth == Integer.MIN_VALUE) {
            this.setMonth(0, true);
        }
        else if (newMonth > 11) {
            this.setMonth(11, true);
        }
        else {
            this.setMonth(newMonth, true);
        }
    }
    
    public int getMonth() {
        return this.month;
    }
    
    public void setDayChooser(final JDayChooser dayChooser) {
        this.dayChooser = dayChooser;
    }
    
    public void setYearChooser(final JYearChooser yearChooser) {
        this.yearChooser = yearChooser;
    }
    
    @Override
    public Locale getLocale() {
        return this.locale;
    }
    
    @Override
    public void setLocale(final Locale l) {
        if (!this.initialized) {
            super.setLocale(l);
        }
        else {
            this.locale = l;
            this.initNames();
        }
    }
    
    @Override
    public void setEnabled(final boolean enabled) {
        super.setEnabled(enabled);
        this.comboBox.setEnabled(enabled);
        if (this.spinner != null) {
            this.spinner.setEnabled(enabled);
        }
    }
    
    public Component getComboBox() {
        return this.comboBox;
    }
    
    public Component getSpinner() {
        return this.spinner;
    }
    
    public boolean hasSpinner() {
        return this.hasSpinner;
    }
    
    @Override
    public void setFont(final Font font) {
        if (this.comboBox != null) {
            this.comboBox.setFont(font);
        }
        super.setFont(font);
    }
    
    @Override
    public void updateUI() {
        final JSpinner testSpinner = new JSpinner();
        if (this.spinner != null) {
            if ("Windows".equals(UIManager.getLookAndFeel().getID())) {
                this.spinner.setBorder(testSpinner.getBorder());
            }
            else {
                this.spinner.setBorder(new EmptyBorder(0, 0, 0, 0));
            }
        }
    }
    
    public static void main(final String[] s) {
        final JFrame frame = new JFrame("MonthChooser");
        frame.getContentPane().add(new JMonthChooser());
        frame.pack();
        frame.setVisible(true);
    }
}
