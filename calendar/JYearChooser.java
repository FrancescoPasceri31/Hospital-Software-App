// 
// Decompiled by Procyon v0.5.36
// 

package calendar;

import java.awt.Component;
import javax.swing.JFrame;
import java.util.Calendar;
import calendar.components.JSpinField;

public class JYearChooser extends JSpinField
{
    private static final long serialVersionUID = 2648810220491090064L;
    protected JDayChooser dayChooser;
    protected int oldYear;
    protected int startYear;
    protected int endYear;
    
    public JYearChooser() {
        this.setName("JYearChooser");
        final Calendar calendar = Calendar.getInstance();
        this.dayChooser = null;
        this.setMinimum(calendar.getMinimum(1));
        this.setMaximum(calendar.getMaximum(1));
        this.setValue(calendar.get(1));
    }
    
    public void setYear(final int y) {
        super.setValue(y, true, false);
        if (this.dayChooser != null) {
            this.dayChooser.setYear(this.value);
        }
        this.spinner.setValue(new Integer(this.value));
        this.firePropertyChange("year", this.oldYear, this.value);
        this.oldYear = this.value;
    }
    
    @Override
    public void setValue(final int value) {
        this.setYear(value);
    }
    
    public int getYear() {
        return super.getValue();
    }
    
    public void setDayChooser(final JDayChooser dayChooser) {
        this.dayChooser = dayChooser;
    }
    
    public int getEndYear() {
        return this.getMaximum();
    }
    
    public void setEndYear(final int endYear) {
        this.setMaximum(endYear);
    }
    
    public int getStartYear() {
        return this.getMinimum();
    }
    
    public void setStartYear(final int startYear) {
        this.setMinimum(startYear);
    }
    
    public static void main(final String[] s) {
        final JFrame frame = new JFrame("JYearChooser");
        frame.getContentPane().add(new JYearChooser());
        frame.pack();
        frame.setVisible(true);
    }
}
