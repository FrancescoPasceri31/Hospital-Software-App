// 
// Decompiled by Procyon v0.5.36
// 

package utility;

public class ControlloStringhe
{
    public static boolean controllaCodFiscale(final String nomeS, final String cognomeS, final String codFiscaleS, String dataS, final String sessoS) {
        if (codFiscaleS.length() < 16) {
            return false;
        }
        if (dataS.length() == 10) {
            dataS = "0" + dataS;
        }
        final String regexCodFiscale = "^[a-zA-Z]{6}[0-9]{2}[abcdehlmprstABCDEHLMPRST]{1}[0-9]{2}([a-zA-Z]{1}[0-9]{3})[a-zA-Z]{1}$";
        if (!codFiscaleS.matches(regexCodFiscale)) {
            return false;
        }
        for (int i = 0; i < codFiscaleS.length(); ++i) {
            if (i < 3 && cognomeS.toLowerCase().indexOf(codFiscaleS.toLowerCase().charAt(i)) == -1) {
                return false;
            }
            if (i >= 3 && i < 6 && nomeS.toLowerCase().indexOf(codFiscaleS.toLowerCase().charAt(i)) == -1) {
                return false;
            }
            if ((i == 6 || i == 7) && ((i == 6 && codFiscaleS.toLowerCase().charAt(i) != dataS.charAt(dataS.length() - 2)) || (i == 7 && codFiscaleS.toLowerCase().charAt(i) != dataS.charAt(dataS.length() - 1)))) {
                return false;
            }
            if (i == 8) {
                if (dataS.length() == 10) {
                    if (!controllaCorrispondenzaLetteraMese(dataS.substring(2, 5), codFiscaleS.toLowerCase().charAt(i))) {
                        return false;
                    }
                }
                else if (!controllaCorrispondenzaLetteraMese(dataS.substring(3, 6), codFiscaleS.toLowerCase().charAt(i))) {
                    return false;
                }
            }
            if (i == 9) {
                if (sessoS.equalsIgnoreCase("Maschio")) {
                    if (codFiscaleS.toLowerCase().charAt(i) != dataS.toLowerCase().charAt(0)) {
                        return false;
                    }
                }
                else if (sessoS.equalsIgnoreCase("Femmina")) {
                    if (codFiscaleS.toLowerCase().charAt(i) != '4' && codFiscaleS.toLowerCase().charAt(i) != '5' && codFiscaleS.toLowerCase().charAt(i) != '6' && codFiscaleS.toLowerCase().charAt(i) != '7') {
                        return false;
                    }
                    if (codFiscaleS.toLowerCase().charAt(i) == '4' && dataS.toLowerCase().charAt(0) != '0') {
                        return false;
                    }
                    if (codFiscaleS.toLowerCase().charAt(i) == '5' && dataS.toLowerCase().charAt(0) != '1') {
                        return false;
                    }
                    if (codFiscaleS.toLowerCase().charAt(i) == '6' && dataS.toLowerCase().charAt(0) != '2') {
                        return false;
                    }
                    if (codFiscaleS.toLowerCase().charAt(i) == '7' && dataS.toLowerCase().charAt(0) != '3') {
                        return false;
                    }
                }
            }
            if (i == 10 && codFiscaleS.toLowerCase().charAt(i) != dataS.toLowerCase().charAt(1)) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean controllaCorrispondenzaLetteraMese(final String mese, final char letteraMese) {
        final String lowerCase;
        switch (lowerCase = mese.toLowerCase()) {
            case "ago": {
                return letteraMese == 'm';
            }
            case "apr": {
                return letteraMese == 'd';
            }
            case "feb": {
                return letteraMese == 'b';
            }
            case "gen": {
                return letteraMese == 'a';
            }
            case "giu": {
                return letteraMese == 'h';
            }
            case "lug": {
                return letteraMese == 'l';
            }
            case "mag": {
                return letteraMese == 'e';
            }
            case "mar": {
                return letteraMese == 'c';
            }
            case "nov": {
                return letteraMese == 's';
            }
            case "ott": {
                return letteraMese == 'r';
            }
            case "set": {
                return letteraMese == 'p';
            }
            default:
                break;
        }
        return letteraMese == 't';
    }
}
