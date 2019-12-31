// 
// Decompiled by Procyon v0.5.36
// 

package utility;

import frameFunzionali.FrameRecuperaPassword;
import frameFunzionali.FrameTablePazienti;
import frameFunzionali.FrameTableMedici;
import frameFunzionali.FrameTableReparti;
import java.awt.Frame;
import java.awt.Window;
import javax.swing.JWindow;

public class ControlloWindowUnica
{
    public static void controlloWindowUnica(final JWindow windowDaGestire) {
        final Window[] arrayAperti = Window.getWindows();
        for (int i = 0; i < arrayAperti.length; ++i) {
            if (arrayAperti[i] instanceof JWindow) {
                arrayAperti[i].dispose();
            }
        }
    }
    
    public static void chiudiAltre(final String indicaFrameReparto) {
        final Frame[] arrayAperti = Frame.getFrames();
        Frame[] array;
        for (int length = (array = arrayAperti).length, i = 0; i < length; ++i) {
            final Frame frame = array[i];
            if (frame instanceof FrameTableReparti) {
                frame.dispose();
            }
        }
    }
    
    public static void chiudiAltre(final String indicaFrameMedico, final int medico) {
        final Frame[] arrayAperti = Frame.getFrames();
        Frame[] array;
        for (int length = (array = arrayAperti).length, i = 0; i < length; ++i) {
            final Frame frame = array[i];
            if (frame instanceof FrameTableMedici) {
                frame.dispose();
            }
        }
    }
    
    public static void chiudiAltre(final String frameDaChiudere, final double paziente) {
        final Frame[] arrayAperti = Frame.getFrames();
        Frame[] array;
        for (int length = (array = arrayAperti).length, i = 0; i < length; ++i) {
            final Frame frame = array[i];
            if (frame instanceof FrameTablePazienti) {
                frame.dispose();
            }
        }
    }
    
    public static void chiudiAltre(final FrameRecuperaPassword frameRecuperaPassword) {
        final Frame[] arrayAperti = Frame.getFrames();
        Frame[] array;
        for (int length = (array = arrayAperti).length, i = 0; i < length; ++i) {
            final Frame frame = array[i];
            if (frame instanceof FrameRecuperaPassword) {
                frame.dispose();
            }
        }
    }
}
