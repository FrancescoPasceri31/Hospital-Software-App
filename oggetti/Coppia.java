// 
// Decompiled by Procyon v0.5.36
// 

package oggetti;

import java.io.Serializable;

public class Coppia implements Serializable
{
    private static final long serialVersionUID = 1L;
    private Medico a;
    private Medico b;
    private Medico c;
    private Medico d;
    private String s;
    private int h;
    
    public Coppia(final Medico a, final Medico b) {
        this.a = a;
        this.b = b;
    }
    
    public Coppia(final Medico a, final Medico b, final Medico c, final Medico d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public Coppia(final int a) {
        this.h = a;
    }
    
    public Coppia(final String s) {
        this.s = s;
    }
    
    public Medico getA() {
        return this.a;
    }
    
    public Medico getB() {
        return this.b;
    }
    
    public Medico getC() {
        return this.c;
    }
    
    public Medico getD() {
        return this.d;
    }
    
    @Override
    public String toString() {
        if (this.a == null && this.b == null && this.c == null && this.d == null && this.h == 0) {
            return this.s;
        }
        if (this.b == null && this.c == null && this.d == null && this.h != 0) {
            return String.valueOf(this.h);
        }
        if (this.c == null & this.d == null) {
            return String.valueOf(this.a.getCognome()) + " , " + this.b.getCognome();
        }
        return String.valueOf(this.a.getCognome()) + " , " + this.b.getCognome() + " , " + this.c.getCognome() + " , " + this.d.getCognome();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = 31 * result + ((this.a == null) ? 0 : this.a.hashCode());
        result = 31 * result + ((this.b == null) ? 0 : this.b.hashCode());
        result = 31 * result + ((this.c == null) ? 0 : this.c.hashCode());
        result = 31 * result + ((this.d == null) ? 0 : this.d.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Coppia)) {
            return false;
        }
        final Coppia other = (Coppia)obj;
        if (this.a == null) {
            if (other.a != null) {
                return false;
            }
        }
        else if (!this.a.equals(other.a)) {
            return false;
        }
        if (this.b == null) {
            if (other.b != null) {
                return false;
            }
        }
        else if (!this.b.equals(other.b)) {
            return false;
        }
        if (this.c == null) {
            if (other.c != null) {
                return false;
            }
        }
        else if (!this.c.equals(other.c)) {
            return false;
        }
        if (this.d == null) {
            if (other.d != null) {
                return false;
            }
        }
        else if (!this.d.equals(other.d)) {
            return false;
        }
        return true;
    }
}
