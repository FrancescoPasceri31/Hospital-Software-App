// 
// Decompiled by Procyon v0.5.36
// 

package calendar;

import java.util.ResourceBundle;
import java.awt.GridLayout;
import calendar.components.UTF8ResourceBundle;
import java.awt.Font;
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import java.util.Date;
import javax.swing.JButton;
import java.util.Locale;
import java.util.Calendar;
import java.beans.PropertyChangeListener;
import javax.swing.JPanel;

public class JCalendar extends JPanel implements PropertyChangeListener
{
    private static final long serialVersionUID = 8913369762644440133L;
    private Calendar calendar;
    private boolean initialized;
    private final JPanel monthYearPanel;
    private final JPanel specialButtonPanel;
    private boolean isTodayButtonVisible;
    private boolean isNullDateButtonVisible;
    private final String defaultTodayButtonText = "Today";
    private final String defaultNullDateButtonText = "No Date";
    private String todayButtonText;
    private String nullDateButtonText;
    protected JDayChooser dayChooser;
    protected boolean weekOfYearVisible;
    protected Locale locale;
    protected JMonthChooser monthChooser;
    protected JYearChooser yearChooser;
    private final JButton todayButton;
    private final JButton nullDateButton;
    
    public JCalendar() {
        this(null, null, true, true);
    }
    
    public JCalendar(final Date date) {
        this(date, null, true, true);
    }
    
    public JCalendar(final Calendar calendar) {
        this(null, null, true, true);
        this.setCalendar(calendar);
    }
    
    public JCalendar(final Locale locale) {
        this(null, locale, true, true);
    }
    
    public JCalendar(final Date date, final Locale locale) {
        this(date, locale, true, true);
    }
    
    public JCalendar(final Date date, final boolean monthSpinner) {
        this(date, null, monthSpinner, true);
    }
    
    public JCalendar(final Locale locale, final boolean monthSpinner) {
        this(null, locale, monthSpinner, true);
    }
    
    public JCalendar(final boolean monthSpinner) {
        this(null, null, monthSpinner, true);
    }
    
    public JCalendar(final Date date, final Locale locale, final boolean monthSpinner, final boolean weekOfYearVisible) {
        this.initialized = false;
        this.weekOfYearVisible = true;
        this.setName("JCalendar");
        this.dayChooser = null;
        this.monthChooser = null;
        this.yearChooser = null;
        this.weekOfYearVisible = weekOfYearVisible;
        if (locale == null) {
            this.locale = Locale.getDefault();
        }
        else {
            this.locale = locale;
        }
        this.calendar = Calendar.getInstance(this.locale);
        this.setLayout(new BorderLayout());
        (this.monthYearPanel = new JPanel()).setLayout(new BorderLayout());
        this.monthChooser = new JMonthChooser(monthSpinner);
        this.yearChooser = new JYearChooser();
        this.monthChooser.setYearChooser(this.yearChooser);
        this.monthChooser.setLocale(this.locale);
        this.monthYearPanel.add(this.monthChooser, "West");
        this.monthYearPanel.add(this.yearChooser, "Center");
        this.monthYearPanel.setBorder(BorderFactory.createEmptyBorder());
        (this.dayChooser = new JDayChooser(weekOfYearVisible)).addPropertyChangeListener(this);
        this.dayChooser.setLocale(this.locale);
        this.monthChooser.setDayChooser(this.dayChooser);
        this.monthChooser.addPropertyChangeListener(this);
        this.yearChooser.setDayChooser(this.dayChooser);
        this.yearChooser.addPropertyChangeListener(this);
        this.add(this.monthYearPanel, "North");
        this.add(this.dayChooser, "Center");
        this.specialButtonPanel = new JPanel();
        (this.todayButton = new JButton()).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                JCalendar.this.setDate(new Date());
            }
        });
        (this.nullDateButton = new JButton()).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                JCalendar.this.dayChooser.firePropertyChange("day", 0, -1);
            }
        });
        this.specialButtonPanel.setVisible(false);
        this.add(this.specialButtonPanel, "South");
        if (date != null) {
            this.calendar.setTime(date);
        }
        this.initialized = true;
        this.setCalendar(this.calendar);
    }
    
    public static void main(final String[] s) {
        final JFrame frame = new JFrame("JCalendar");
        final JCalendar jcalendar = new JCalendar();
        frame.getContentPane().add(jcalendar);
        frame.pack();
        frame.setVisible(true);
    }
    
    public Calendar getCalendar() {
        return this.calendar;
    }
    
    public JDayChooser getDayChooser() {
        return this.dayChooser;
    }
    
    @Override
    public Locale getLocale() {
        return this.locale;
    }
    
    public JMonthChooser getMonthChooser() {
        return this.monthChooser;
    }
    
    public JYearChooser getYearChooser() {
        return this.yearChooser;
    }
    
    public boolean isWeekOfYearVisible() {
        return this.dayChooser.isWeekOfYearVisible();
    }
    
    @Override
    public void propertyChange(final PropertyChangeEvent evt) {
        if (this.calendar != null) {
            final Calendar c = (Calendar)this.calendar.clone();
            if (evt.getPropertyName().equals("day")) {
                c.set(5, (int)evt.getNewValue());
                this.setCalendar(c, false);
            }
            else if (evt.getPropertyName().equals("month")) {
                c.set(2, (int)evt.getNewValue());
                this.setCalendar(c, false);
            }
            else if (evt.getPropertyName().equals("year")) {
                c.set(1, (int)evt.getNewValue());
                this.setCalendar(c, false);
            }
            else if (evt.getPropertyName().equals("date")) {
                c.setTime((Date)evt.getNewValue());
                this.setCalendar(c, true);
            }
        }
    }
    
    @Override
    public void setBackground(final Color bg) {
        super.setBackground(bg);
        if (this.dayChooser != null) {
            this.dayChooser.setBackground(bg);
        }
    }
    
    public void setCalendar(final Calendar c) {
        this.setCalendar(c, true);
    }
    
    private void setCalendar(final Calendar c, final boolean update) {
        if (c == null) {
            this.setDate(null);
        }
        final Calendar oldCalendar = this.calendar;
        this.calendar = c;
        if (update) {
            this.yearChooser.setYear(c.get(1));
            this.monthChooser.setMonth(c.get(2));
            this.dayChooser.setDay(c.get(5));
        }
        this.firePropertyChange("calendar", oldCalendar, this.calendar);
    }
    
    @Override
    public void setEnabled(final boolean enabled) {
        super.setEnabled(enabled);
        if (this.dayChooser != null) {
            this.dayChooser.setEnabled(enabled);
            this.monthChooser.setEnabled(enabled);
            this.yearChooser.setEnabled(enabled);
        }
    }
    
    @Override
    public boolean isEnabled() {
        return super.isEnabled();
    }
    
    @Override
    public void setFont(final Font font) {
        super.setFont(font);
        if (this.dayChooser != null) {
            this.dayChooser.setFont(font);
            this.monthChooser.setFont(font);
            this.yearChooser.setFont(font);
        }
    }
    
    @Override
    public void setForeground(final Color fg) {
        super.setForeground(fg);
        if (this.dayChooser != null) {
            this.dayChooser.setForeground(fg);
            this.monthChooser.setForeground(fg);
            this.yearChooser.setForeground(fg);
        }
    }
    
    @Override
    public void setLocale(final Locale l) {
        if (!this.initialized) {
            super.setLocale(l);
        }
        else {
            final Locale oldLocale = this.locale;
            this.locale = l;
            this.dayChooser.setLocale(this.locale);
            this.monthChooser.setLocale(this.locale);
            this.relayoutSpecialButtonPanel();
            this.firePropertyChange("locale", oldLocale, this.locale);
        }
    }
    
    public void setWeekOfYearVisible(final boolean weekOfYearVisible) {
        this.dayChooser.setWeekOfYearVisible(weekOfYearVisible);
        this.setLocale(this.locale);
    }
    
    public boolean isDecorationBackgroundVisible() {
        return this.dayChooser.isDecorationBackgroundVisible();
    }
    
    public void setDecorationBackgroundVisible(final boolean decorationBackgroundVisible) {
        this.dayChooser.setDecorationBackgroundVisible(decorationBackgroundVisible);
        this.setLocale(this.locale);
    }
    
    public boolean isDecorationBordersVisible() {
        return this.dayChooser.isDecorationBordersVisible();
    }
    
    public void setDecorationBordersVisible(final boolean decorationBordersVisible) {
        this.dayChooser.setDecorationBordersVisible(decorationBordersVisible);
        this.setLocale(this.locale);
    }
    
    public Color getDecorationBackgroundColor() {
        return this.dayChooser.getDecorationBackgroundColor();
    }
    
    public void setDecorationBackgroundColor(final Color decorationBackgroundColor) {
        this.dayChooser.setDecorationBackgroundColor(decorationBackgroundColor);
    }
    
    public Color getSundayForeground() {
        return this.dayChooser.getSundayForeground();
    }
    
    public Color getWeekdayForeground() {
        return this.dayChooser.getWeekdayForeground();
    }
    
    public void setSundayForeground(final Color sundayForeground) {
        this.dayChooser.setSundayForeground(sundayForeground);
    }
    
    public void setWeekdayForeground(final Color weekdayForeground) {
        this.dayChooser.setWeekdayForeground(weekdayForeground);
    }
    
    public Date getDate() {
        return new Date(this.calendar.getTimeInMillis());
    }
    
    public void setDate(final Date date) {
        final Date oldDate = this.calendar.getTime();
        this.calendar.setTime(date);
        final int year = this.calendar.get(1);
        final int month = this.calendar.get(2);
        final int day = this.calendar.get(5);
        this.yearChooser.setYear(year);
        this.monthChooser.setMonth(month);
        this.dayChooser.setCalendar(this.calendar);
        this.dayChooser.setDay(day);
        this.firePropertyChange("date", oldDate, date);
    }
    
    public void setSelectableDateRange(final Date min, final Date max) {
        this.dayChooser.setSelectableDateRange(min, max);
    }
    
    public Date getMaxSelectableDate() {
        return this.dayChooser.getMaxSelectableDate();
    }
    
    public Date getMinSelectableDate() {
        return this.dayChooser.getMinSelectableDate();
    }
    
    public void setMaxSelectableDate(final Date max) {
        this.dayChooser.setMaxSelectableDate(max);
    }
    
    public void setMinSelectableDate(final Date min) {
        this.dayChooser.setMinSelectableDate(min);
    }
    
    public int getMaxDayCharacters() {
        return this.dayChooser.getMaxDayCharacters();
    }
    
    public void setMaxDayCharacters(final int maxDayCharacters) {
        this.dayChooser.setMaxDayCharacters(maxDayCharacters);
    }
    
    public void setTodayButtonVisible(final boolean isTodayButtonVisible) {
        this.isTodayButtonVisible = isTodayButtonVisible;
        this.relayoutSpecialButtonPanel();
    }
    
    public boolean isTodayButtonVisible() {
        return this.isTodayButtonVisible;
    }
    
    public void setNullDateButtonVisible(final boolean isNullDateButtonVisible) {
        this.isNullDateButtonVisible = isNullDateButtonVisible;
        this.relayoutSpecialButtonPanel();
    }
    
    public boolean isNullDateButtonVisible() {
        return this.isNullDateButtonVisible;
    }
    
    private void relayoutSpecialButtonPanel() {
        ResourceBundle resourceBundle = null;
        try {
            resourceBundle = UTF8ResourceBundle.getBundle("calendar.jcalendar", this.locale);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        this.specialButtonPanel.removeAll();
        int buttonCount = 0;
        if (this.isTodayButtonVisible) {
            String text = this.todayButtonText;
            if (text == null && resourceBundle != null) {
                try {
                    text = resourceBundle.getString("todayButton.text");
                }
                catch (Exception ex) {}
            }
            if (text == null) {
                text = "Today";
            }
            this.todayButton.setText(text);
            this.specialButtonPanel.add(this.todayButton);
            ++buttonCount;
        }
        if (this.isNullDateButtonVisible) {
            String text = this.nullDateButtonText;
            if (text == null && resourceBundle != null) {
                try {
                    text = resourceBundle.getString("nullDateButton.text");
                }
                catch (Exception ex2) {}
            }
            if (text == null) {
                text = "No Date";
            }
            this.nullDateButton.setText(text);
            this.specialButtonPanel.add(this.nullDateButton);
            ++buttonCount;
        }
        this.specialButtonPanel.setLayout(new GridLayout(1, buttonCount));
        if (this.isTodayButtonVisible) {
            this.specialButtonPanel.add(this.todayButton);
        }
        if (this.isNullDateButtonVisible) {
            this.specialButtonPanel.add(this.nullDateButton);
        }
        this.specialButtonPanel.setVisible(this.isNullDateButtonVisible || this.isTodayButtonVisible);
        this.todayButton.invalidate();
        this.todayButton.repaint();
        this.nullDateButton.invalidate();
        this.nullDateButton.repaint();
        this.specialButtonPanel.invalidate();
        this.specialButtonPanel.doLayout();
        this.specialButtonPanel.repaint();
        this.invalidate();
        this.repaint();
    }
    
    public String getTodayButtonText() {
        return this.todayButtonText;
    }
    
    public void setTodayButtonText(final String todayButtonText) {
        if (todayButtonText != null & todayButtonText.trim().length() == 0) {
            this.todayButtonText = null;
        }
        else {
            this.todayButtonText = todayButtonText;
        }
        this.relayoutSpecialButtonPanel();
    }
    
    public String getNullDateButtonText() {
        return this.nullDateButtonText;
    }
    
    public void setNullDateButtonText(final String nullDateButtonText) {
        if (nullDateButtonText != null & nullDateButtonText.trim().length() == 0) {
            this.nullDateButtonText = null;
        }
        else {
            this.nullDateButtonText = nullDateButtonText;
        }
        this.relayoutSpecialButtonPanel();
    }
}
