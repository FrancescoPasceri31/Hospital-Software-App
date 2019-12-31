// 
// Decompiled by Procyon v0.5.36
// 

package utility;

import java.util.Random;
import oggetti.Reparto;
import oggetti.Medico;
import java.util.ArrayList;
import oggetti.Coppia;
import java.io.Serializable;

public class OrarioMatrice implements Serializable
{
    private static final long serialVersionUID = 1L;
    private Coppia[][] M;
    private int nrighe;
    private int ncolonne;
    private int index;
    private ArrayList<Medico> copiaListaMediciReparto;
    
    public OrarioMatrice(final Reparto r) {
        this.nrighe = 25;
        this.ncolonne = 8;
        this.copiaListaMediciReparto = r.getListaMedici();
        final String[] giorni = { " Ora ", "LUNEDI'", "MARTEDI'", "MERCOLEDI'", "GIOVEDI'", "VENERDI'", "SABATO", "DOMENICA" };
        final String[] ore = { "00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00" };
        final Coppia[][] M = new Coppia[this.nrighe][this.ncolonne];
        final int orarioInizioNotte = 1;
        final int orarioFineNotte = 8;
        final int orarioInizioGiorno = 9;
        final int orarioFineGiorno = 16;
        final int orarioInizioSera = 17;
        final int orarioFineSera = 24;
        for (int i = 1; i < M.length; ++i) {
            M[i][0] = new Coppia(ore[i - 1]);
            for (int j = 0; j < M[0].length; ++j) {
                M[0][j] = new Coppia(giorni[j]);
            }
        }
        for (int k = 1; k < M[0].length; ++k) {
            final Coppia medicinotte = new Coppia(this.prendiInt(this.copiaListaMediciReparto), this.prendiInt(this.copiaListaMediciReparto));
            for (int l = orarioInizioNotte; l <= orarioFineNotte; ++l) {
                M[l][k] = medicinotte;
            }
            Coppia medici;
            for (medici = new Coppia(this.prendiInt(this.copiaListaMediciReparto), this.prendiInt(this.copiaListaMediciReparto), this.prendiInt(this.copiaListaMediciReparto), this.prendiInt(this.copiaListaMediciReparto)); M[8][k].getA() == medici.getA() || M[8][k].getB() == medici.getB() || M[8][k].getA() == medici.getC() || M[8][k].getB() == medici.getD(); medici = new Coppia(this.prendiInt(this.copiaListaMediciReparto), this.prendiInt(this.copiaListaMediciReparto), this.prendiInt(this.copiaListaMediciReparto), this.prendiInt(this.copiaListaMediciReparto))) {}
            for (int m = orarioInizioGiorno; m <= orarioFineGiorno; ++m) {
                M[m][k] = medici;
            }
            for (medici = new Coppia(this.prendiInt(this.copiaListaMediciReparto), this.prendiInt(this.copiaListaMediciReparto), this.prendiInt(this.copiaListaMediciReparto), this.prendiInt(this.copiaListaMediciReparto)); M[8][k].getA() == medici.getA() || M[8][k].getB() == medici.getB() || M[8][k].getA() == medici.getC() || M[8][k].getB() == medici.getD(); medici = new Coppia(this.prendiInt(this.copiaListaMediciReparto), this.prendiInt(this.copiaListaMediciReparto), this.prendiInt(this.copiaListaMediciReparto), this.prendiInt(this.copiaListaMediciReparto))) {}
            for (int m = orarioInizioSera; m <= orarioFineSera; ++m) {
                M[m][k] = medici;
            }
        }
        this.M = M;
    }
    
    public Medico prendiInt(final ArrayList<Medico> copiaListaMediciReparto) {
        final Random rand = new Random();
        final int index1 = 0;
        final Medico questo = copiaListaMediciReparto.get(index1);
        copiaListaMediciReparto.remove(index1);
        copiaListaMediciReparto.trimToSize();
        copiaListaMediciReparto.add(questo);
        return questo;
    }
    
    public String[][] getOrario() {
        final String[][] s = new String[this.nrighe][this.ncolonne];
        for (int i = 0; i < this.M.length; ++i) {
            for (int j = 0; j < this.M[0].length; ++j) {
                s[i][j] = this.M[i][j].toString();
            }
        }
        return s;
    }
    
    public Coppia[][] getMatrice() {
        return this.M;
    }
    
    public int getNumeroColonne() {
        return this.ncolonne;
    }
    
    public int getNumeroRighe() {
        return this.nrighe;
    }
}
