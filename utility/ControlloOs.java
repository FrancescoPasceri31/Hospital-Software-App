// 
// Decompiled by Procyon v0.5.36
// 

package utility;

public class ControlloOs
{
    public static String controlloOs() {
        final String os = System.getProperty("os.name");
        final String uname = System.getProperty("user.name");
        if (os.equalsIgnoreCase("Linux")) {
            return "//home//" + uname + "//";
        }
        if (os.substring(0, 7).equalsIgnoreCase("Windows")) {
            return "C://Users//" + uname + "//Desktop//";
        }
        return null;
    }
}
