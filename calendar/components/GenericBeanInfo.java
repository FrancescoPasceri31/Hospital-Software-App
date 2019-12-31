// 
// Decompiled by Procyon v0.5.36
// 

package calendar.components;

import java.beans.PropertyEditorManager;
import java.util.Locale;
import java.awt.Image;
import java.beans.SimpleBeanInfo;

public class GenericBeanInfo extends SimpleBeanInfo
{
    protected Image iconColor16;
    protected Image iconColor32;
    protected Image iconMono16;
    protected Image iconMono32;
    
    public GenericBeanInfo(final String bean, final boolean registerLocaleEditor) {
        try {
            this.iconColor16 = this.loadImage("images/" + bean + "Color16.gif");
            this.iconColor32 = this.loadImage("images/" + bean + "Color32.gif");
            this.iconMono16 = this.loadImage("images/" + bean + "Mono16.gif");
            this.iconMono32 = this.loadImage("images/" + bean + "Mono32.gif");
        }
        catch (RuntimeException e) {
            System.out.println("GenericBeanInfo.GenericBeanInfo(): " + e);
        }
        if (registerLocaleEditor) {
            PropertyEditorManager.registerEditor(Locale.class, LocaleEditor.class);
        }
    }
    
    @Override
    public Image getIcon(final int iconKind) {
        switch (iconKind) {
            case 1: {
                return this.iconColor16;
            }
            case 2: {
                return this.iconColor32;
            }
            case 3: {
                return this.iconMono16;
            }
            case 4: {
                return this.iconMono32;
            }
            default: {
                return null;
            }
        }
    }
}
