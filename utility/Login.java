// 
// Decompiled by Procyon v0.5.36
// 

package utility;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import frameFunzionali.WindowLoginSbagliato;
import avvio.App;
import java.io.IOException;
import java.io.File;
import oggetti.Medico;
import oggetti.Paziente;
import java.util.TreeMap;
import java.awt.event.KeyAdapter;

public class Login extends KeyAdapter
{
    private String user;
    private String pass;
    private static TreeMap<String, Paziente> loginPaziente_map;
    private static TreeMap<String, Medico> loginMedico_map;
    
    public Login() {
        try {
            final File f;
            if (!(f = new File(String.valueOf(ControlloOs.controlloOs()) + "Ospedale//loginPaziente_file.txt")).exists()) {
                Login.loginPaziente_map = new TreeMap<String, Paziente>();
                f.createNewFile();
                this.serializzaMappaLoginPaziente(Login.loginPaziente_map = Login.loginPaziente_map);
            }
            final File M;
            if (!(M = new File(String.valueOf(ControlloOs.controlloOs()) + "Ospedale//loginMedico_file.txt")).exists()) {
                Login.loginMedico_map = new TreeMap<String, Medico>();
                M.createNewFile();
                this.serializzaMappaLoginMedico(Login.loginMedico_map = Login.loginMedico_map);
            }
        }
        catch (IOException ex) {}
    }
    
    public TreeMap<String, Paziente> getMappaLoginPaziente() {
        return Login.loginPaziente_map;
    }
    
    public TreeMap<String, Medico> getMappaLoginMedico() {
        return Login.loginMedico_map;
    }
    
    public boolean controlloLoginPaziente(final String username, final String password) {
        if (App.login.getMappaLoginPaziente().containsKey(username) && Login.loginPaziente_map.get(username).getPassword().equalsIgnoreCase(password)) {
            return true;
        }
        final WindowLoginSbagliato hoScrittoMale = new WindowLoginSbagliato();
        hoScrittoMale.setVisible(true);
        return false;
    }
    
    public boolean controlloLoginMedico(final String username, final String password) {
        if (Login.loginMedico_map.containsKey(username.toLowerCase()) && Login.loginMedico_map.get(username).getPassword().equalsIgnoreCase(password)) {
            return true;
        }
        final WindowLoginSbagliato hoScrittoMale = new WindowLoginSbagliato();
        hoScrittoMale.setVisible(true);
        return false;
    }
    
    public Paziente getPaziente(final String username) {
        if (Login.loginPaziente_map.containsKey(username)) {
            return Login.loginPaziente_map.get(username);
        }
        return null;
    }
    
    public Medico getMedico(final String username) {
        if (Login.loginMedico_map.containsKey(username)) {
            return Login.loginMedico_map.get(username);
        }
        return null;
    }
    
    public void serializzaMappaLoginPaziente(final TreeMap<String, Paziente> MappaLogin) {
        try {
            final FileOutputStream fileOut = new FileOutputStream(String.valueOf(ControlloOs.controlloOs()) + "Ospedale//loginPaziente_file.txt");
            final ObjectOutputStream oos = new ObjectOutputStream(fileOut);
            oos.writeObject(MappaLogin);
            oos.flush();
            oos.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void serializzaMappaLoginMedico(final TreeMap<String, Medico> MappaLogin) {
        try {
            final FileOutputStream fileOut = new FileOutputStream(String.valueOf(ControlloOs.controlloOs()) + "Ospedale//loginMedico_file.txt");
            final ObjectOutputStream oos = new ObjectOutputStream(fileOut);
            oos.writeObject(MappaLogin);
            oos.flush();
            oos.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void deserializzaMappaLoginPaziente() {
        try {
            final FileInputStream fileIn = new FileInputStream(String.valueOf(ControlloOs.controlloOs()) + "Ospedale//loginPaziente_file.txt");
            final ObjectInputStream ois = new ObjectInputStream(fileIn);
            final TreeMap<String, Paziente> mappanuova = Login.loginPaziente_map = (TreeMap<String, Paziente>)ois.readObject();
            ois.close();
        }
        catch (ClassNotFoundException | IOException ex2) {
            final Exception ex;
            final Exception e = ex;
            e.printStackTrace();
        }
    }
    
    public void deserializzaMappaLoginMedico() {
        try {
            final FileInputStream fileIn = new FileInputStream(String.valueOf(ControlloOs.controlloOs()) + "Ospedale//loginMedico_file.txt");
            final ObjectInputStream ois = new ObjectInputStream(fileIn);
            Login.loginMedico_map = (TreeMap<String, Medico>)ois.readObject();
            ois.close();
        }
        catch (IOException | ClassNotFoundException ex2) {
            final Exception ex;
            final Exception e = ex;
            e.printStackTrace();
        }
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final Login other = (Login)obj;
        if (this.pass == null) {
            if (other.pass != null) {
                return false;
            }
        }
        else if (!this.pass.equals(other.pass)) {
            return false;
        }
        if (this.user == null) {
            if (other.user != null) {
                return false;
            }
        }
        else if (!this.user.equals(other.user)) {
            return false;
        }
        return true;
    }
}
