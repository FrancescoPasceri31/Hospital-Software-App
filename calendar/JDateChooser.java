// 
// Decompiled by Procyon v0.5.36
// 

package calendar;

import javax.swing.JFrame;
import javax.swing.JComponent;
import java.awt.Font;
import java.util.Locale;
import javax.swing.SwingUtilities;
import java.beans.PropertyChangeEvent;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.MenuElement;
import javax.swing.MenuSelectionManager;
import javax.swing.event.ChangeEvent;
import java.awt.Component;
import java.awt.Insets;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import javax.swing.event.ChangeListener;
import java.util.Date;
import javax.swing.JPopupMenu;
import javax.swing.JButton;
import java.beans.PropertyChangeListener;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class JDateChooser extends JPanel implements ActionListener, PropertyChangeListener
{
    private static final long serialVersionUID = -4306412745720670722L;
    protected IDateEditor dateEditor;
    protected JButton calendarButton;
    protected JCalendar jcalendar;
    protected JPopupMenu popup;
    protected boolean isInitialized;
    protected boolean dateSelected;
    protected Date lastSelectedDate;
    private ChangeListener changeListener;
    
    public JDateChooser() {
        this(null, null, null, null);
    }
    
    public JDateChooser(final IDateEditor dateEditor) {
        this(null, null, null, dateEditor);
    }
    
    public JDateChooser(final Date date) {
        this(date, null);
    }
    
    public JDateChooser(final Date date, final String dateFormatString) {
        this(date, dateFormatString, null);
    }
    
    public JDateChooser(final Date date, final String dateFormatString, final IDateEditor dateEditor) {
        this(null, date, dateFormatString, dateEditor);
    }
    
    public JDateChooser(final String datePattern, final String maskPattern, final char placeholder) {
        this(null, null, datePattern, new JTextFieldDateEditor(datePattern, maskPattern, placeholder));
    }
    
    public JDateChooser(final JCalendar jcal, final Date date, final String dateFormatString, final IDateEditor dateEditor) {
        this.setName("JDateChooser");
        this.dateEditor = dateEditor;
        if (this.dateEditor == null) {
            this.dateEditor = new JTextFieldDateEditor();
        }
        this.dateEditor.addPropertyChangeListener("date", this);
        if (jcal == null) {
            this.jcalendar = new JCalendar(date);
        }
        else {
            this.jcalendar = jcal;
            if (date != null) {
                this.jcalendar.setDate(date);
            }
        }
        this.setLayout(new BorderLayout());
        this.jcalendar.getDayChooser().addPropertyChangeListener("day", this);
        this.jcalendar.getDayChooser().setAlwaysFireDayProperty(true);
        this.setDateFormatString(dateFormatString);
        this.setDate(date);
        (this.calendarButton = new JButton(new ImageIcon(JDateChooser.class.getResource("/calendar/images/JDateChooserColor16.gif"))) {
            private static final long serialVersionUID = -1913767779079949668L;
            
            @Override
            public boolean isFocusable() {
                return false;
            }
        }).setMargin(new Insets(0, 0, 0, 0));
        this.calendarButton.addActionListener(this);
        this.calendarButton.setMnemonic(67);
        this.add(this.calendarButton, "East");
        this.add(this.dateEditor.getUiComponent(), "Center");
        this.calendarButton.setMargin(new Insets(0, 0, 0, 0));
        (this.popup = new JPopupMenu() {
            private static final long serialVersionUID = -6078272560337577761L;
            
            @Override
            public void setVisible(final boolean b) {
                final Boolean isCanceled = (Boolean)this.getClientProperty("JPopupMenu.firePopupMenuCanceled");
                if (b || (!b && JDateChooser.this.dateSelected) || (isCanceled != null && !b && isCanceled)) {
                    super.setVisible(b);
                }
            }
        }).setLightWeightPopupEnabled(true);
        this.popup.add(this.jcalendar);
        this.lastSelectedDate = date;
        this.changeListener = new ChangeListener() {
            boolean hasListened = false;
            
            @Override
            public void stateChanged(final ChangeEvent e) {
                if (this.hasListened) {
                    this.hasListened = false;
                    return;
                }
                if (JDateChooser.this.popup.isVisible() && JDateChooser.this.jcalendar.monthChooser.getComboBox().hasFocus()) {
                    final MenuElement[] me = MenuSelectionManager.defaultManager().getSelectedPath();
                    final MenuElement[] newMe = new MenuElement[me.length + 1];
                    newMe[0] = JDateChooser.this.popup;
                    for (int i = 0; i < me.length; ++i) {
                        newMe[i + 1] = me[i];
                    }
                    this.hasListened = true;
                    MenuSelectionManager.defaultManager().setSelectedPath(newMe);
                }
            }
        };
        MenuSelectionManager.defaultManager().addChangeListener(this.changeListener);
        this.isInitialized = true;
    }
    
    @Override
    public void actionPerformed(final ActionEvent e) {
        final int x = this.calendarButton.getWidth() - (int)this.popup.getPreferredSize().getWidth();
        final int y = this.calendarButton.getY() + this.calendarButton.getHeight();
        final Calendar calendar = Calendar.getInstance();
        final Date date = this.dateEditor.getDate();
        if (date != null) {
            calendar.setTime(date);
        }
        this.jcalendar.setCalendar(calendar);
        this.popup.show(this.calendarButton, x, y);
        this.dateSelected = false;
    }
    
    @Override
    public void propertyChange(final PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("day")) {
            if (this.popup.isVisible()) {
                this.dateSelected = true;
                this.popup.setVisible(false);
                if ((int)evt.getNewValue() > 0) {
                    this.setDate(this.jcalendar.getCalendar().getTime());
                }
                else {
                    this.setDate(null);
                }
            }
        }
        else if (evt.getPropertyName().equals("date")) {
            if (evt.getSource() == this.dateEditor) {
                this.firePropertyChange("date", evt.getOldValue(), evt.getNewValue());
            }
            else {
                this.setDate((Date)evt.getNewValue());
            }
        }
    }
    
    @Override
    public void updateUI() {
        super.updateUI();
        this.setEnabled(this.isEnabled());
        if (this.jcalendar != null) {
            SwingUtilities.updateComponentTreeUI(this.popup);
        }
    }
    
    @Override
    public void setLocale(final Locale l) {
        super.setLocale(l);
        this.dateEditor.setLocale(l);
        this.jcalendar.setLocale(l);
    }
    
    public String getDateFormatString() {
        return this.dateEditor.getDateFormatString();
    }
    
    public void setDateFormatString(final String dfString) {
        this.dateEditor.setDateFormatString(dfString);
        this.invalidate();
    }
    
    public Date getDate() {
        return this.dateEditor.getDate();
    }
    
    public void setDate(final Date date) {
        this.dateEditor.setDate(date);
        if (this.getParent() != null) {
            this.getParent().invalidate();
        }
    }
    
    public Calendar getCalendar() {
        final Date date = this.getDate();
        if (date == null) {
            return null;
        }
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
    
    public void setCalendar(final Calendar calendar) {
        if (calendar == null) {
            this.dateEditor.setDate(null);
        }
        else {
            this.dateEditor.setDate(calendar.getTime());
        }
    }
    
    @Override
    public void setEnabled(final boolean enabled) {
        super.setEnabled(enabled);
        if (this.dateEditor != null) {
            this.dateEditor.setEnabled(enabled);
            this.calendarButton.setEnabled(enabled);
        }
    }
    
    @Override
    public boolean isEnabled() {
        return super.isEnabled();
    }
    
    public void setIcon(final ImageIcon icon) {
        this.calendarButton.setIcon(icon);
    }
    
    @Override
    public void setFont(final Font font) {
        if (this.isInitialized) {
            this.dateEditor.getUiComponent().setFont(font);
            this.jcalendar.setFont(font);
        }
        super.setFont(font);
    }
    
    public JCalendar getJCalendar() {
        return this.jcalendar;
    }
    
    public JButton getCalendarButton() {
        return this.calendarButton;
    }
    
    public IDateEditor getDateEditor() {
        return this.dateEditor;
    }
    
    public void setSelectableDateRange(final Date min, final Date max) {
        this.jcalendar.setSelectableDateRange(min, max);
        this.dateEditor.setSelectableDateRange(this.jcalendar.getMinSelectableDate(), this.jcalendar.getMaxSelectableDate());
    }
    
    public void setMaxSelectableDate(final Date max) {
        this.jcalendar.setMaxSelectableDate(max);
        this.dateEditor.setMaxSelectableDate(max);
    }
    
    public void setMinSelectableDate(final Date min) {
        this.jcalendar.setMinSelectableDate(min);
        this.dateEditor.setMinSelectableDate(min);
    }
    
    public Date getMaxSelectableDate() {
        return this.jcalendar.getMaxSelectableDate();
    }
    
    public Date getMinSelectableDate() {
        return this.jcalendar.getMinSelectableDate();
    }
    
    public void cleanup() {
        MenuSelectionManager.defaultManager().removeChangeListener(this.changeListener);
        this.changeListener = null;
    }
    
    @Override
    public boolean requestFocusInWindow() {
        if (this.dateEditor instanceof JComponent) {
            return ((JComponent)this.dateEditor).requestFocusInWindow();
        }
        return super.requestFocusInWindow();
    }
    
    public static void main(final String[] s) {
        final JFrame frame = new JFrame("JDateChooser");
        final JDateChooser dateChooser = new JDateChooser();
        frame.getContentPane().add(dateChooser);
        frame.pack();
        frame.setVisible(true);
        dateChooser.requestFocusInWindow();
    }
}
