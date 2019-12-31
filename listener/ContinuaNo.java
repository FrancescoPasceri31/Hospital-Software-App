// 
// Decompiled by Procyon v0.5.36
// 

package listener;

import frame.FrameDoc;
import frame.FrameSegreteria;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import oggetti.Medico;
import javax.swing.JFrame;
import javax.swing.JWindow;
import java.awt.event.MouseListener;

public class ContinuaNo implements MouseListener
{
    private JWindow wc;
    private boolean aggiornaFrame;
    private JFrame frame;
    private Medico m;
    
    public ContinuaNo(final JWindow windowScelta) {
        this.wc = windowScelta;
        this.aggiornaFrame = false;
    }
    
    public ContinuaNo(final JWindow windowScelta, final JFrame frameS) {
        this.wc = windowScelta;
        this.frame = frameS;
        this.m = null;
        this.aggiornaFrame = true;
    }
    
    public ContinuaNo(final JWindow windowScelta, final JFrame frame, final Medico m) {
        this.wc = windowScelta;
        this.frame = frame;
        this.m = m;
        this.aggiornaFrame = true;
    }
    
    @Override
    public void mouseClicked(final MouseEvent e) {
        if (e.getButton() == 1) {
            this.wc.dispose();
            if (this.aggiornaFrame) {
                if (this.m == null) {
                    final Frame[] frames = Frame.getFrames();
                    this.frame.dispose();
                    Frame[] array;
                    for (int length = (array = frames).length, i = 0; i < length; ++i) {
                        final Frame frame1 = array[i];
                        frame1.dispose();
                    }
                    new FrameSegreteria().setVisible(true);
                }
                else if (this.m != null) {
                    final Frame[] frames = Frame.getFrames();
                    this.frame.dispose();
                    Frame[] array2;
                    for (int length2 = (array2 = frames).length, j = 0; j < length2; ++j) {
                        final Frame frame1 = array2[j];
                        frame1.dispose();
                    }
                    new FrameDoc(this.m).setVisible(true);
                }
            }
        }
    }
    
    @Override
    public void mouseEntered(final MouseEvent e) {
    }
    
    @Override
    public void mouseExited(final MouseEvent e) {
    }
    
    @Override
    public void mousePressed(final MouseEvent e) {
    }
    
    @Override
    public void mouseReleased(final MouseEvent e) {
    }
}
