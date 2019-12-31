// 
// Decompiled by Procyon v0.5.36
// 

package listener;

import frame.FrameLogin;
import avvio.App;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import java.awt.event.MouseListener;

public class Logout implements MouseListener
{
    JFrame f;
    
    public Logout(final JFrame f) {
        this.f = f;
    }
    
    @Override
    public void mouseClicked(final MouseEvent arg0) {
        if (arg0.getButton() == 1) {
            final Frame[] arrayFrameDaChiudere = Frame.getFrames();
            Frame[] array;
            for (int length = (array = arrayFrameDaChiudere).length, i = 0; i < length; ++i) {
                final Frame frame = array[i];
                frame.dispose();
            }
            this.f.dispose();
            final FrameLogin frameDoc = new FrameLogin(App.login);
            frameDoc.setVisible(true);
        }
    }
    
    @Override
    public void mouseEntered(final MouseEvent arg0) {
    }
    
    @Override
    public void mouseExited(final MouseEvent arg0) {
    }
    
    @Override
    public void mousePressed(final MouseEvent arg0) {
    }
    
    @Override
    public void mouseReleased(final MouseEvent arg0) {
    }
}
