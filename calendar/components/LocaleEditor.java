// 
// Decompiled by Procyon v0.5.36
// 

package calendar.components;

import java.util.Calendar;
import java.util.Locale;
import java.beans.PropertyEditorSupport;

public class LocaleEditor extends PropertyEditorSupport
{
    private Locale[] locales;
    private String[] localeStrings;
    private Locale locale;
    private int length;
    
    public LocaleEditor() {
        this.locale = Locale.getDefault();
        this.locales = Calendar.getAvailableLocales();
        this.length = this.locales.length;
        this.localeStrings = new String[this.length];
    }
    
    @Override
    public String[] getTags() {
        for (int i = 0; i < this.length; ++i) {
            this.localeStrings[i] = this.locales[i].getDisplayName();
        }
        return this.localeStrings;
    }
    
    @Override
    public void setAsText(final String text) throws IllegalArgumentException {
        for (int i = 0; i < this.length; ++i) {
            if (text.equals(this.locales[i].getDisplayName())) {
                this.setValue(this.locale = this.locales[i]);
                break;
            }
        }
    }
    
    @Override
    public String getAsText() {
        return this.locale.getDisplayName();
    }
}
