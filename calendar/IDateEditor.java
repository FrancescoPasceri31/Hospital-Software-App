// 
// Decompiled by Procyon v0.5.36
// 

package calendar;

import java.beans.PropertyChangeListener;
import java.util.Locale;
import javax.swing.JComponent;
import java.util.Date;

public interface IDateEditor
{
    Date getDate();
    
    void setDate(final Date p0);
    
    void setDateFormatString(final String p0);
    
    String getDateFormatString();
    
    void setSelectableDateRange(final Date p0, final Date p1);
    
    Date getMaxSelectableDate();
    
    Date getMinSelectableDate();
    
    void setMaxSelectableDate(final Date p0);
    
    void setMinSelectableDate(final Date p0);
    
    JComponent getUiComponent();
    
    void setLocale(final Locale p0);
    
    void setEnabled(final boolean p0);
    
    void addPropertyChangeListener(final PropertyChangeListener p0);
    
    void addPropertyChangeListener(final String p0, final PropertyChangeListener p1);
    
    void removePropertyChangeListener(final PropertyChangeListener p0);
    
    void removePropertyChangeListener(final String p0, final PropertyChangeListener p1);
}
