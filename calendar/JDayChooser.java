// 
// Decompiled by Procyon v0.5.36
// 

package calendar;

import java.awt.event.MouseListener;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.util.Iterator;
import java.text.DateFormatSymbols;
import java.util.Date;
import java.awt.Component;
import java.awt.Insets;
import javax.swing.UIManager;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Calendar;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class JDayChooser extends JPanel implements ActionListener, KeyListener, FocusListener
{
    private static final long serialVersionUID = 5876398337018781820L;
    protected JButton[] days;
    protected JButton[] weeks;
    protected JButton selectedDay;
    protected JPanel weekPanel;
    protected JPanel dayPanel;
    protected int day;
    protected Color oldDayBackgroundColor;
    protected Color selectedColor;
    protected Color sundayForeground;
    protected Color weekdayForeground;
    protected Color decorationBackgroundColor;
    protected String[] dayNames;
    protected Calendar calendar;
    protected Calendar today;
    protected Locale locale;
    protected boolean initialized;
    protected boolean weekOfYearVisible;
    protected boolean decorationBackgroundVisible;
    protected boolean decorationBordersVisible;
    protected boolean dayBordersVisible;
    private boolean alwaysFireDayProperty;
    protected int maxDayCharacters;
    protected List dateEvaluators;
    protected MinMaxDateEvaluator minMaxDateEvaluator;
    
    public JDayChooser() {
        this(false);
    }
    
    public JDayChooser(final boolean weekOfYearVisible) {
        this.decorationBackgroundVisible = true;
        this.setName("JDayChooser");
        this.setBackground(Color.blue);
        this.dateEvaluators = new ArrayList(1);
        this.addDateEvaluator(this.minMaxDateEvaluator = new MinMaxDateEvaluator());
        this.weekOfYearVisible = weekOfYearVisible;
        this.locale = Locale.getDefault();
        this.days = new JButton[49];
        this.selectedDay = null;
        this.calendar = Calendar.getInstance(this.locale);
        this.today = (Calendar)this.calendar.clone();
        this.setLayout(new BorderLayout());
        (this.dayPanel = new JPanel()).setLayout(new GridLayout(7, 7));
        this.sundayForeground = new Color(164, 0, 0);
        this.weekdayForeground = new Color(0, 90, 164);
        this.decorationBackgroundColor = new Color(210, 228, 238);
        for (int y = 0; y < 7; ++y) {
            for (int x = 0; x < 7; ++x) {
                final int index = x + 7 * y;
                if (y == 0) {
                    this.days[index] = new DecoratorButton();
                }
                else {
                    (this.days[index] = new JButton("x") {
                        private static final long serialVersionUID = -7433645992591669725L;
                        
                        @Override
                        public void paint(final Graphics g) {
                            if ("Windows".equals(UIManager.getLookAndFeel().getID()) && JDayChooser.this.selectedDay == this) {
                                g.setColor(JDayChooser.this.selectedColor);
                                g.fillRect(0, 0, this.getWidth(), this.getHeight());
                            }
                            super.paint(g);
                        }
                    }).addActionListener(this);
                    this.days[index].addKeyListener(this);
                    this.days[index].addFocusListener(this);
                }
                this.days[index].setMargin(new Insets(0, 0, 0, 0));
                this.days[index].setFocusPainted(false);
                this.dayPanel.add(this.days[index]);
            }
        }
        (this.weekPanel = new JPanel()).setLayout(new GridLayout(7, 1));
        this.weeks = new JButton[7];
        for (int i = 0; i < 7; ++i) {
            (this.weeks[i] = new DecoratorButton()).setMargin(new Insets(0, 0, 0, 0));
            this.weeks[i].setFocusPainted(false);
            this.weeks[i].setForeground(new Color(100, 100, 100));
            if (i != 0) {
                this.weeks[i].setText("0" + (i + 1));
            }
            this.weekPanel.add(this.weeks[i]);
        }
        this.init();
        this.setDay(Calendar.getInstance().get(5));
        this.add(this.dayPanel, "Center");
        if (weekOfYearVisible) {
            this.add(this.weekPanel, "West");
        }
        this.initialized = true;
        this.updateUI();
    }
    
    protected void init() {
        final JButton testButton = new JButton();
        this.oldDayBackgroundColor = testButton.getBackground();
        this.selectedColor = new Color(160, 160, 160);
        final Date date = this.calendar.getTime();
        (this.calendar = Calendar.getInstance(this.locale)).setTime(date);
        this.drawDayNames();
        this.drawDays();
    }
    
    private void drawDayNames() {
        final int firstDayOfWeek = this.calendar.getFirstDayOfWeek();
        final DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(this.locale);
        this.dayNames = dateFormatSymbols.getShortWeekdays();
        int day = firstDayOfWeek;
        for (int i = 0; i < 7; ++i) {
            if (this.maxDayCharacters > 0 && this.maxDayCharacters < 5 && this.dayNames[day].length() >= this.maxDayCharacters) {
                this.dayNames[day] = this.dayNames[day].substring(0, this.maxDayCharacters);
            }
            this.days[i].setText(this.dayNames[day]);
            if (day == 1) {
                this.days[i].setForeground(this.sundayForeground);
            }
            else {
                this.days[i].setForeground(this.weekdayForeground);
            }
            if (day < 7) {
                ++day;
            }
            else {
                day -= 6;
            }
        }
    }
    
    protected void initDecorations() {
        for (int x = 0; x < 7; ++x) {
            this.days[x].setContentAreaFilled(this.decorationBackgroundVisible);
            this.days[x].setBorderPainted(this.decorationBordersVisible);
            this.days[x].invalidate();
            this.days[x].repaint();
            this.weeks[x].setContentAreaFilled(this.decorationBackgroundVisible);
            this.weeks[x].setBorderPainted(this.decorationBordersVisible);
            this.weeks[x].invalidate();
            this.weeks[x].repaint();
        }
    }
    
    protected void drawWeeks() {
        final Calendar tmpCalendar = (Calendar)this.calendar.clone();
        for (int i = 1; i < 7; ++i) {
            tmpCalendar.set(5, i * 7 - 6);
            final int week = tmpCalendar.get(3);
            String buttonText = Integer.toString(week);
            if (week < 10) {
                buttonText = "0" + buttonText;
            }
            this.weeks[i].setText(buttonText);
            if (i == 5 || i == 6) {
                this.weeks[i].setVisible(this.days[i * 7].isVisible());
            }
        }
    }
    
    protected void drawDays() {
        final Calendar tmpCalendar = (Calendar)this.calendar.clone();
        tmpCalendar.set(11, 0);
        tmpCalendar.set(12, 0);
        tmpCalendar.set(13, 0);
        tmpCalendar.set(14, 0);
        final int firstDayOfWeek = tmpCalendar.getFirstDayOfWeek();
        tmpCalendar.set(5, 1);
        int firstDay = tmpCalendar.get(7) - firstDayOfWeek;
        if (firstDay < 0) {
            firstDay += 7;
        }
        int i;
        for (i = 0; i < firstDay; ++i) {
            this.days[i + 7].setVisible(false);
            this.days[i + 7].setText("");
        }
        tmpCalendar.add(2, 1);
        final Date firstDayInNextMonth = tmpCalendar.getTime();
        tmpCalendar.add(2, -1);
        Date day = tmpCalendar.getTime();
        int n = 0;
        final Color foregroundColor = this.getForeground();
        while (day.before(firstDayInNextMonth)) {
            this.days[i + n + 7].setText(Integer.toString(n + 1));
            this.days[i + n + 7].setVisible(true);
            if (tmpCalendar.get(6) == this.today.get(6) && tmpCalendar.get(1) == this.today.get(1)) {
                this.days[i + n + 7].setForeground(this.sundayForeground);
            }
            else {
                this.days[i + n + 7].setForeground(foregroundColor);
            }
            if (n + 1 == this.day) {
                this.days[i + n + 7].setBackground(this.selectedColor);
                this.selectedDay = this.days[i + n + 7];
            }
            else {
                this.days[i + n + 7].setBackground(this.oldDayBackgroundColor);
            }
            final Iterator iterator = this.dateEvaluators.iterator();
            this.days[i + n + 7].setEnabled(true);
            while (iterator.hasNext()) {
                final IDateEvaluator dateEvaluator = iterator.next();
                if (dateEvaluator.isSpecial(day)) {
                    this.days[i + n + 7].setForeground(dateEvaluator.getSpecialForegroundColor());
                    this.days[i + n + 7].setBackground(dateEvaluator.getSpecialBackroundColor());
                    this.days[i + n + 7].setToolTipText(dateEvaluator.getSpecialTooltip());
                    this.days[i + n + 7].setEnabled(true);
                }
                if (dateEvaluator.isInvalid(day)) {
                    this.days[i + n + 7].setForeground(dateEvaluator.getInvalidForegroundColor());
                    this.days[i + n + 7].setBackground(dateEvaluator.getInvalidBackroundColor());
                    this.days[i + n + 7].setToolTipText(dateEvaluator.getInvalidTooltip());
                    this.days[i + n + 7].setEnabled(false);
                }
            }
            ++n;
            tmpCalendar.add(5, 1);
            day = tmpCalendar.getTime();
        }
        for (int k = n + i + 7; k < 49; ++k) {
            this.days[k].setVisible(false);
            this.days[k].setText("");
        }
        this.drawWeeks();
    }
    
    @Override
    public Locale getLocale() {
        return this.locale;
    }
    
    @Override
    public void setLocale(final Locale locale) {
        if (!this.initialized) {
            super.setLocale(locale);
        }
        else {
            super.setLocale(this.locale = locale);
            this.init();
        }
    }
    
    public void setDay(int d) {
        if (d < 1) {
            d = 1;
        }
        final Calendar tmpCalendar = (Calendar)this.calendar.clone();
        tmpCalendar.set(5, 1);
        tmpCalendar.add(2, 1);
        tmpCalendar.add(5, -1);
        final int maxDaysInMonth = tmpCalendar.get(5);
        if (d > maxDaysInMonth) {
            d = maxDaysInMonth;
        }
        final int oldDay = this.day;
        this.day = d;
        if (this.selectedDay != null) {
            this.selectedDay.setBackground(this.oldDayBackgroundColor);
            this.selectedDay.repaint();
        }
        for (int i = 7; i < 49; ++i) {
            if (this.days[i].getText().equals(Integer.toString(this.day))) {
                (this.selectedDay = this.days[i]).setBackground(this.selectedColor);
                break;
            }
        }
        if (this.alwaysFireDayProperty) {
            this.firePropertyChange("day", 0, this.day);
        }
        else {
            this.firePropertyChange("day", oldDay, this.day);
        }
    }
    
    public void setAlwaysFireDayProperty(final boolean alwaysFire) {
        this.alwaysFireDayProperty = alwaysFire;
    }
    
    public int getDay() {
        return this.day;
    }
    
    public void setMonth(final int month) {
        this.calendar.set(2, month);
        final int maxDays = this.calendar.getActualMaximum(5);
        if (this.day > maxDays) {
            this.day = maxDays;
        }
        this.drawDays();
    }
    
    public void setYear(final int year) {
        this.calendar.set(1, year);
        this.drawDays();
    }
    
    public void setCalendar(final Calendar calendar) {
        this.calendar = calendar;
        this.drawDays();
    }
    
    @Override
    public void setFont(final Font font) {
        if (this.days != null) {
            for (int i = 0; i < 49; ++i) {
                this.days[i].setFont(font);
            }
        }
        if (this.weeks != null) {
            for (int i = 0; i < 7; ++i) {
                this.weeks[i].setFont(font);
            }
        }
    }
    
    @Override
    public void setForeground(final Color foreground) {
        super.setForeground(foreground);
        if (this.days != null) {
            for (int i = 7; i < 49; ++i) {
                this.days[i].setForeground(foreground);
            }
            this.drawDays();
        }
    }
    
    @Override
    public void actionPerformed(final ActionEvent e) {
        final JButton button = (JButton)e.getSource();
        final String buttonText = button.getText();
        final int day = new Integer(buttonText);
        this.setDay(day);
    }
    
    @Override
    public void focusGained(final FocusEvent e) {
    }
    
    @Override
    public void focusLost(final FocusEvent e) {
    }
    
    @Override
    public void keyPressed(final KeyEvent e) {
        final int offset = (e.getKeyCode() == 38) ? -7 : ((e.getKeyCode() == 40) ? 7 : ((e.getKeyCode() == 37) ? -1 : ((e.getKeyCode() == 39) ? 1 : 0)));
        final int newDay = this.getDay() + offset;
        if (newDay >= 1 && newDay <= this.calendar.getMaximum(5)) {
            this.setDay(newDay);
        }
    }
    
    @Override
    public void keyTyped(final KeyEvent e) {
    }
    
    @Override
    public void keyReleased(final KeyEvent e) {
    }
    
    @Override
    public void setEnabled(final boolean enabled) {
        super.setEnabled(enabled);
        for (short i = 0; i < this.days.length; ++i) {
            if (this.days[i] != null) {
                this.days[i].setEnabled(enabled);
            }
        }
        for (short i = 0; i < this.weeks.length; ++i) {
            if (this.weeks[i] != null) {
                this.weeks[i].setEnabled(enabled);
            }
        }
    }
    
    public boolean isWeekOfYearVisible() {
        return this.weekOfYearVisible;
    }
    
    public void setWeekOfYearVisible(final boolean weekOfYearVisible) {
        if (weekOfYearVisible == this.weekOfYearVisible) {
            return;
        }
        if (weekOfYearVisible) {
            this.add(this.weekPanel, "West");
        }
        else {
            this.remove(this.weekPanel);
        }
        this.weekOfYearVisible = weekOfYearVisible;
        this.validate();
        this.dayPanel.validate();
    }
    
    public JPanel getDayPanel() {
        return this.dayPanel;
    }
    
    public Color getDecorationBackgroundColor() {
        return this.decorationBackgroundColor;
    }
    
    public void setDecorationBackgroundColor(final Color decorationBackgroundColor) {
        this.decorationBackgroundColor = decorationBackgroundColor;
        if (this.days != null) {
            for (int i = 0; i < 7; ++i) {
                this.days[i].setBackground(decorationBackgroundColor);
            }
        }
        if (this.weeks != null) {
            for (int i = 0; i < 7; ++i) {
                this.weeks[i].setBackground(decorationBackgroundColor);
            }
        }
    }
    
    public Color getSundayForeground() {
        return this.sundayForeground;
    }
    
    public Color getWeekdayForeground() {
        return this.weekdayForeground;
    }
    
    public void setSundayForeground(final Color sundayForeground) {
        this.sundayForeground = sundayForeground;
        this.drawDayNames();
        this.drawDays();
    }
    
    public void setWeekdayForeground(final Color weekdayForeground) {
        this.weekdayForeground = weekdayForeground;
        this.drawDayNames();
        this.drawDays();
    }
    
    public void setFocus() {
        if (this.selectedDay != null) {
            this.selectedDay.requestFocus();
        }
    }
    
    public boolean isDecorationBackgroundVisible() {
        return this.decorationBackgroundVisible;
    }
    
    public void setDecorationBackgroundVisible(final boolean decorationBackgroundVisible) {
        this.decorationBackgroundVisible = decorationBackgroundVisible;
        this.initDecorations();
    }
    
    public boolean isDecorationBordersVisible() {
        return this.decorationBordersVisible;
    }
    
    public boolean isDayBordersVisible() {
        return this.dayBordersVisible;
    }
    
    public void setDecorationBordersVisible(final boolean decorationBordersVisible) {
        this.decorationBordersVisible = decorationBordersVisible;
        this.initDecorations();
    }
    
    public void setDayBordersVisible(final boolean dayBordersVisible) {
        this.dayBordersVisible = dayBordersVisible;
        if (this.initialized) {
            for (int x = 7; x < 49; ++x) {
                if ("Windows".equals(UIManager.getLookAndFeel().getID())) {
                    this.days[x].setContentAreaFilled(dayBordersVisible);
                }
                else {
                    this.days[x].setContentAreaFilled(true);
                }
                this.days[x].setBorderPainted(dayBordersVisible);
            }
        }
    }
    
    @Override
    public void updateUI() {
        super.updateUI();
        this.setFont(Font.decode("Dialog Plain 11"));
        if (this.weekPanel != null) {
            this.weekPanel.updateUI();
        }
        if (this.initialized) {
            if ("Windows".equals(UIManager.getLookAndFeel().getID())) {
                this.setDayBordersVisible(false);
                this.setDecorationBackgroundVisible(true);
                this.setDecorationBordersVisible(false);
            }
            else {
                this.setDayBordersVisible(true);
                this.setDecorationBackgroundVisible(this.decorationBackgroundVisible);
                this.setDecorationBordersVisible(this.decorationBordersVisible);
            }
        }
    }
    
    public void setSelectableDateRange(final Date min, final Date max) {
        this.minMaxDateEvaluator.setMaxSelectableDate(max);
        this.minMaxDateEvaluator.setMinSelectableDate(min);
        this.drawDays();
    }
    
    public Date setMaxSelectableDate(final Date max) {
        final Date maxSelectableDate = this.minMaxDateEvaluator.setMaxSelectableDate(max);
        this.drawDays();
        return maxSelectableDate;
    }
    
    public Date setMinSelectableDate(final Date min) {
        final Date minSelectableDate = this.minMaxDateEvaluator.setMinSelectableDate(min);
        this.drawDays();
        return minSelectableDate;
    }
    
    public Date getMaxSelectableDate() {
        return this.minMaxDateEvaluator.getMaxSelectableDate();
    }
    
    public Date getMinSelectableDate() {
        return this.minMaxDateEvaluator.getMinSelectableDate();
    }
    
    public int getMaxDayCharacters() {
        return this.maxDayCharacters;
    }
    
    public void setMaxDayCharacters(final int maxDayCharacters) {
        if (maxDayCharacters == this.maxDayCharacters) {
            return;
        }
        if (maxDayCharacters < 0 || maxDayCharacters > 4) {
            this.maxDayCharacters = 0;
        }
        else {
            this.maxDayCharacters = maxDayCharacters;
        }
        this.drawDayNames();
        this.drawDays();
        this.invalidate();
    }
    
    public static void main(final String[] s) {
        final JFrame frame = new JFrame("JDayChooser");
        frame.getContentPane().add(new JDayChooser());
        frame.pack();
        frame.setVisible(true);
    }
    
    public void addDateEvaluator(final IDateEvaluator dateEvaluator) {
        this.dateEvaluators.add(dateEvaluator);
    }
    
    public void removeDateEvaluator(final IDateEvaluator dateEvaluator) {
        this.dateEvaluators.remove(dateEvaluator);
    }
    
    class DecoratorButton extends JButton
    {
        private static final long serialVersionUID = -5306477668406547496L;
        
        public DecoratorButton() {
            this.setBackground(JDayChooser.this.decorationBackgroundColor);
            this.setContentAreaFilled(JDayChooser.this.decorationBackgroundVisible);
            this.setBorderPainted(JDayChooser.this.decorationBordersVisible);
        }
        
        @Override
        public void addMouseListener(final MouseListener l) {
        }
        
        @Override
        public boolean isFocusable() {
            return false;
        }
        
        @Override
        public void paint(final Graphics g) {
            if ("Windows".equals(UIManager.getLookAndFeel().getID())) {
                if (JDayChooser.this.decorationBackgroundVisible) {
                    g.setColor(JDayChooser.this.decorationBackgroundColor);
                }
                else {
                    g.setColor(JDayChooser.this.days[7].getBackground());
                }
                g.fillRect(0, 0, this.getWidth(), this.getHeight());
                if (this.isBorderPainted()) {
                    this.setContentAreaFilled(true);
                }
                else {
                    this.setContentAreaFilled(false);
                }
            }
            super.paint(g);
        }
    }
}
