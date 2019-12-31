// 
// Decompiled by Procyon v0.5.36
// 

package avvio;

import oggetti.Reparto;
import java.io.File;
import utility.ControlloOs;
import oggetti.Segreteria;
import utility.Login;
import frame.FrameLogin;

public class App
{
    protected static FrameLogin frameLogin;
    public static Login login;
    public static Segreteria segreteria;
    
    public App() {
        final File f;
        if (!(f = new File(String.valueOf(ControlloOs.controlloOs()) + "Ospedale")).exists()) {
            new File(String.valueOf(ControlloOs.controlloOs()) + "Ospedale").mkdir();
        }
        App.login = new Login();
        (App.segreteria = new Segreteria()).deserializzazioneArrayListReparto();
        App.segreteria.deserializzazioneArrayListReparto();
        for (int i = 0; i < Segreteria.getListaReparti().size(); ++i) {
            Segreteria.getListaReparti().get(i).deserializzazioneArrayListAppuntamento();
            Segreteria.getListaReparti().get(i).deserializzazioneArrayListMedico();
            Segreteria.getListaReparti().get(i).deserializzazioneArrayListPaziente();
            Segreteria.getListaReparti().get(i).deserializzazioneOrario();
        }
        App.login.deserializzaMappaLoginMedico();
        App.login.deserializzaMappaLoginPaziente();
        (App.frameLogin = new FrameLogin(App.login)).setVisible(true);
    }
    
    public static void main(final String[] args) {
        final App app = new App();
        System.out.print(App.login.getMappaLoginMedico());
    }
}
