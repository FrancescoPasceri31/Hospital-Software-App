// 
// Decompiled by Procyon v0.5.36
// 

package calendar;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.UIManager;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.util.Locale;
import java.awt.event.FocusEvent;
import javax.swing.event.CaretEvent;
import javax.swing.JComponent;
import java.text.ParseException;
import java.text.DateFormat;
import java.util.Calendar;
import java.awt.Color;
import javax.swing.text.MaskFormatter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import javax.swing.event.CaretListener;
import javax.swing.JFormattedTextField;

public class JTextFieldDateEditor extends JFormattedTextField implements IDateEditor, CaretListener, FocusListener, ActionListener
{
    private static final long serialVersionUID = -8901842591101625304L;
    protected Date date;
    protected SimpleDateFormat dateFormatter;
    protected MaskFormatter maskFormatter;
    protected String datePattern;
    protected String maskPattern;
    protected char placeholder;
    protected Color darkGreen;
    protected DateUtil dateUtil;
    private boolean isMaskVisible;
    private boolean ignoreDatePatternChange;
    private int hours;
    private int minutes;
    private int seconds;
    private int millis;
    private Calendar calendar;
    
    public JTextFieldDateEditor() {
        this(false, null, null, ' ');
    }
    
    public JTextFieldDateEditor(final String datePattern, final String maskPattern, final char placeholder) {
        this(true, datePattern, maskPattern, placeholder);
    }
    
    public JTextFieldDateEditor(final boolean showMask, final String datePattern, final String maskPattern, final char placeholder) {
        (this.dateFormatter = (SimpleDateFormat)DateFormat.getDateInstance(2)).setLenient(false);
        this.setDateFormatString(datePattern);
        if (datePattern != null) {
            this.ignoreDatePatternChange = true;
        }
        this.placeholder = placeholder;
        if (maskPattern == null) {
            this.maskPattern = this.createMaskFromDatePattern(this.datePattern);
        }
        else {
            this.maskPattern = maskPattern;
        }
        this.setToolTipText(this.datePattern);
        this.setMaskVisible(showMask);
        this.addCaretListener(this);
        this.addFocusListener(this);
        this.addActionListener(this);
        this.darkGreen = new Color(0, 150, 0);
        this.calendar = Calendar.getInstance();
        this.dateUtil = new DateUtil();
    }
    
    @Override
    public Date getDate() {
        try {
            this.calendar.setTime(this.dateFormatter.parse(this.getText()));
            this.calendar.set(11, this.hours);
            this.calendar.set(12, this.minutes);
            this.calendar.set(13, this.seconds);
            this.calendar.set(14, this.millis);
            this.date = this.calendar.getTime();
        }
        catch (ParseException e) {
            this.date = null;
        }
        return this.date;
    }
    
    @Override
    public void setDate(final Date date) {
        this.setDate(date, true);
    }
    
    protected void setDate(final Date date, final boolean firePropertyChange) {
        final Date oldDate = this.date;
        this.date = date;
        if (date == null) {
            this.setText("");
        }
        else {
            this.calendar.setTime(date);
            this.hours = this.calendar.get(11);
            this.minutes = this.calendar.get(12);
            this.seconds = this.calendar.get(13);
            this.millis = this.calendar.get(14);
            final String formattedDate = this.dateFormatter.format(date);
            try {
                this.setText(formattedDate);
            }
            catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
        if (date != null && this.dateUtil.checkDate(date)) {
            this.setForeground(Color.BLACK);
        }
        if (firePropertyChange) {
            this.firePropertyChange("date", oldDate, date);
        }
    }
    
    @Override
    public void setDateFormatString(final String dateFormatString) {
        if (this.ignoreDatePatternChange) {
            return;
        }
        try {
            this.dateFormatter.applyPattern(dateFormatString);
        }
        catch (RuntimeException e) {
            (this.dateFormatter = (SimpleDateFormat)DateFormat.getDateInstance(2)).setLenient(false);
        }
        this.setToolTipText(this.datePattern = this.dateFormatter.toPattern());
        this.setDate(this.date, false);
    }
    
    @Override
    public String getDateFormatString() {
        return this.datePattern;
    }
    
    @Override
    public JComponent getUiComponent() {
        return this;
    }
    
    @Override
    public void caretUpdate(final CaretEvent event) {
        final String text = this.getText().trim();
        final String emptyMask = this.maskPattern.replace('#', this.placeholder);
        if (text.length() == 0 || text.equals(emptyMask)) {
            this.setForeground(Color.BLACK);
            return;
        }
        try {
            final Date date = this.dateFormatter.parse(this.getText());
            if (this.dateUtil.checkDate(date)) {
                this.setForeground(this.darkGreen);
            }
            else {
                this.setForeground(Color.RED);
            }
        }
        catch (Exception e) {
            this.setForeground(Color.RED);
        }
    }
    
    @Override
    public void focusLost(final FocusEvent focusEvent) {
        this.checkText();
    }
    
    private void checkText() {
        try {
            final Date date = this.dateFormatter.parse(this.getText());
            this.setDate(date, true);
        }
        catch (Exception ex) {}
    }
    
    @Override
    public void focusGained(final FocusEvent e) {
    }
    
    @Override
    public void setLocale(final Locale locale) {
        if (locale == this.getLocale() || this.ignoreDatePatternChange) {
            return;
        }
        super.setLocale(locale);
        this.dateFormatter = (SimpleDateFormat)DateFormat.getDateInstance(2, locale);
        this.setToolTipText(this.dateFormatter.toPattern());
        this.setDate(this.date, false);
        this.doLayout();
    }
    
    public String createMaskFromDatePattern(final String datePattern) {
        final String symbols = "GyMdkHmsSEDFwWahKzZ";
        String mask = "";
        for (int i = 0; i < datePattern.length(); ++i) {
            final char ch = datePattern.charAt(i);
            boolean symbolFound = false;
            for (int n = 0; n < symbols.length(); ++n) {
                if (symbols.charAt(n) == ch) {
                    mask = String.valueOf(mask) + "#";
                    symbolFound = true;
                    break;
                }
            }
            if (!symbolFound) {
                mask = String.valueOf(mask) + ch;
            }
        }
        return mask;
    }
    
    public boolean isMaskVisible() {
        return this.isMaskVisible;
    }
    
    public void setMaskVisible(final boolean isMaskVisible) {
        this.isMaskVisible = isMaskVisible;
        if (isMaskVisible && this.maskFormatter == null) {
            try {
                (this.maskFormatter = new MaskFormatter(this.createMaskFromDatePattern(this.datePattern))).setPlaceholderCharacter(this.placeholder);
                this.maskFormatter.install(this);
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public Dimension getPreferredSize() {
        if (this.datePattern != null) {
            return new JTextField(this.datePattern).getPreferredSize();
        }
        return super.getPreferredSize();
    }
    
    @Override
    public void actionPerformed(final ActionEvent e) {
        this.checkText();
    }
    
    @Override
    public void setEnabled(final boolean b) {
        super.setEnabled(b);
        if (!b) {
            super.setBackground(UIManager.getColor("TextField.inactiveBackground"));
        }
    }
    
    @Override
    public Date getMaxSelectableDate() {
        return this.dateUtil.getMaxSelectableDate();
    }
    
    @Override
    public Date getMinSelectableDate() {
        return this.dateUtil.getMinSelectableDate();
    }
    
    @Override
    public void setMaxSelectableDate(final Date max) {
        this.dateUtil.setMaxSelectableDate(max);
        this.checkText();
    }
    
    @Override
    public void setMinSelectableDate(final Date min) {
        this.dateUtil.setMinSelectableDate(min);
        this.checkText();
    }
    
    @Override
    public void setSelectableDateRange(final Date min, final Date max) {
        this.dateUtil.setSelectableDateRange(min, max);
        this.checkText();
    }
    
    public static void main(final String[] s) {
        final JFrame frame = new JFrame("JTextFieldDateEditor");
        final JTextFieldDateEditor jTextFieldDateEditor = new JTextFieldDateEditor();
        jTextFieldDateEditor.setDate(new Date());
        frame.getContentPane().add(jTextFieldDateEditor);
        frame.pack();
        frame.setVisible(true);
    }
}
