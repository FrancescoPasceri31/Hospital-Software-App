// 
// Decompiled by Procyon v0.5.36
// 

package calendar;

import javax.swing.event.ChangeEvent;
import javax.swing.UIManager;
import java.awt.event.FocusEvent;
import java.util.Locale;
import javax.swing.JComponent;
import java.text.DateFormat;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerDateModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.event.ChangeListener;
import java.awt.event.FocusListener;
import javax.swing.JSpinner;

public class JSpinnerDateEditor extends JSpinner implements IDateEditor, FocusListener, ChangeListener
{
    private static final long serialVersionUID = 5692204052306085316L;
    protected Date date;
    protected String dateFormatString;
    protected SimpleDateFormat dateFormatter;
    
    public JSpinnerDateEditor() {
        super(new SpinnerDateModel());
        this.dateFormatter = (SimpleDateFormat)DateFormat.getDateInstance(2);
        ((DateEditor)this.getEditor()).getTextField().addFocusListener(this);
        final DateUtil dateUtil = new DateUtil();
        this.setMinSelectableDate(dateUtil.getMinSelectableDate());
        this.setMaxSelectableDate(dateUtil.getMaxSelectableDate());
        ((DateEditor)this.getEditor()).getTextField().setFocusLostBehavior(3);
        this.addChangeListener(this);
    }
    
    @Override
    public Date getDate() {
        if (this.date == null) {
            return null;
        }
        return ((SpinnerDateModel)this.getModel()).getDate();
    }
    
    @Override
    public void setDate(final Date date) {
        this.setDate(date, true);
    }
    
    public void setDate(final Date date, final boolean updateModel) {
        final Date oldDate = this.date;
        this.date = date;
        if (date == null) {
            ((DateEditor)this.getEditor()).getFormat().applyPattern("");
            ((DateEditor)this.getEditor()).getTextField().setText("");
        }
        else if (updateModel) {
            if (this.dateFormatString != null) {
                ((DateEditor)this.getEditor()).getFormat().applyPattern(this.dateFormatString);
            }
            ((SpinnerDateModel)this.getModel()).setValue(date);
        }
        this.firePropertyChange("date", oldDate, date);
    }
    
    @Override
    public void setDateFormatString(final String dateFormatString) {
        try {
            this.dateFormatter.applyPattern(dateFormatString);
        }
        catch (RuntimeException e) {
            (this.dateFormatter = (SimpleDateFormat)DateFormat.getDateInstance(2)).setLenient(false);
        }
        this.setToolTipText(this.dateFormatString = this.dateFormatter.toPattern());
        if (this.date != null) {
            ((DateEditor)this.getEditor()).getFormat().applyPattern(this.dateFormatString);
        }
        else {
            ((DateEditor)this.getEditor()).getFormat().applyPattern("");
        }
        if (this.date != null) {
            final String text = this.dateFormatter.format(this.date);
            ((DateEditor)this.getEditor()).getTextField().setText(text);
        }
    }
    
    @Override
    public String getDateFormatString() {
        return this.dateFormatString;
    }
    
    @Override
    public JComponent getUiComponent() {
        return this;
    }
    
    @Override
    public void setLocale(final Locale locale) {
        super.setLocale(locale);
        this.dateFormatter = (SimpleDateFormat)DateFormat.getDateInstance(2, locale);
        this.setEditor(new DateEditor(this, this.dateFormatter.toPattern()));
        this.setDateFormatString(this.dateFormatter.toPattern());
    }
    
    @Override
    public void focusLost(final FocusEvent focusEvent) {
        final String text = ((DateEditor)this.getEditor()).getTextField().getText();
        if (text.length() == 0) {
            this.setDate(null);
        }
    }
    
    @Override
    public void focusGained(final FocusEvent e) {
    }
    
    @Override
    public void setEnabled(final boolean b) {
        super.setEnabled(b);
        if (!b) {
            ((DateEditor)this.getEditor()).getTextField().setBackground(UIManager.getColor("TextField.inactiveBackground"));
        }
    }
    
    @Override
    public Date getMaxSelectableDate() {
        return (Date)((SpinnerDateModel)this.getModel()).getEnd();
    }
    
    @Override
    public Date getMinSelectableDate() {
        return (Date)((SpinnerDateModel)this.getModel()).getStart();
    }
    
    @Override
    public void setMaxSelectableDate(final Date max) {
        ((SpinnerDateModel)this.getModel()).setEnd(max);
    }
    
    @Override
    public void setMinSelectableDate(final Date min) {
        ((SpinnerDateModel)this.getModel()).setStart(min);
    }
    
    @Override
    public void setSelectableDateRange(final Date min, final Date max) {
        this.setMaxSelectableDate(max);
        this.setMinSelectableDate(min);
    }
    
    @Override
    public void stateChanged(final ChangeEvent e) {
        this.setDate(((SpinnerDateModel)this.getModel()).getDate(), false);
    }
}
