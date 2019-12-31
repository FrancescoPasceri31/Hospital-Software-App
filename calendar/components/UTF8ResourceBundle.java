// 
// Decompiled by Procyon v0.5.36
// 

package calendar.components;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.Locale;

public abstract class UTF8ResourceBundle
{
    public static final ResourceBundle getBundle(final String baseName, final Locale locale) {
        final ResourceBundle bundle = ResourceBundle.getBundle(baseName, locale);
        if (!(bundle instanceof PropertyResourceBundle)) {
            return bundle;
        }
        return new UTF8PropertyResourceBundle((PropertyResourceBundle)bundle, null);
    }
    
    private static class UTF8PropertyResourceBundle extends ResourceBundle
    {
        PropertyResourceBundle propertyResourceBundle;
        
        private UTF8PropertyResourceBundle(final PropertyResourceBundle bundle) {
            this.propertyResourceBundle = bundle;
        }
        
        @Override
        public Enumeration getKeys() {
            return this.propertyResourceBundle.getKeys();
        }
        
        @Override
        protected Object handleGetObject(final String key) {
            final String value = (String)this.propertyResourceBundle.handleGetObject(key);
            if (value != null) {
                try {
                    return new String(value.getBytes("ISO-8859-1"), "UTF-8");
                }
                catch (UnsupportedEncodingException exception) {
                    throw new RuntimeException("UTF-8 encoding is not supported.", exception);
                }
            }
            return null;
        }
    }
}
