// 
// Decompiled by Procyon v0.5.36
// 

package calendar.components;

import java.awt.Component;
import javax.swing.JFrame;
import java.awt.event.ItemEvent;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.JComponent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;

public class JLocaleChooser extends JComboBox implements ItemListener
{
    private static final long serialVersionUID = 8152430789764877431L;
    protected JComponent component;
    private Locale[] locales;
    private Locale locale;
    private int localeCount;
    
    public JLocaleChooser() {
        this((JComponent)null);
    }
    
    @Override
    public String getName() {
        return "JLocaleChoose";
    }
    
    public JLocaleChooser(final JComponent component) {
        this.component = component;
        this.addItemListener(this);
        this.locales = Calendar.getAvailableLocales();
        this.localeCount = this.locales.length;
        for (int i = 0; i < this.localeCount; ++i) {
            if (this.locales[i].getCountry().length() > 0) {
                this.addItem(this.locales[i].getDisplayName());
            }
        }
        this.setLocale(Locale.getDefault());
    }
    
    @Override
    public void itemStateChanged(final ItemEvent iEvt) {
        String item;
        int i;
        for (item = (String)iEvt.getItem(), i = 0; i < this.localeCount && !this.locales[i].getDisplayName().equals(item); ++i) {}
        this.setLocale(this.locales[i], false);
    }
    
    private void setLocale(final Locale l, final boolean select) {
        final Locale oldLocale = this.locale;
        this.locale = l;
        int n = 0;
        if (select) {
            for (int i = 0; i < this.localeCount; ++i) {
                if (this.locales[i].getCountry().length() > 0) {
                    if (this.locales[i].equals(this.locale)) {
                        this.setSelectedIndex(n);
                    }
                    ++n;
                }
            }
        }
        this.firePropertyChange("locale", oldLocale, this.locale);
        if (this.component != null) {
            this.component.setLocale(l);
        }
    }
    
    @Override
    public void setLocale(final Locale l) {
        this.setLocale(l, true);
    }
    
    @Override
    public Locale getLocale() {
        return this.locale;
    }
    
    public static void main(final String[] s) {
        final JFrame frame = new JFrame("LocaleChooser");
        frame.getContentPane().add(new JLocaleChooser());
        frame.pack();
        frame.setVisible(true);
    }
}
