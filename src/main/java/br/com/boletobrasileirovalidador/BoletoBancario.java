package br.com.boletobrasileirovalidador;

import java.util.Arrays;
import java.util.regex.Pattern;

public class BoletoBancario {

	public static boolean boletoBancarioCodigoBarras(String codigo) {
        String cod = Utils.clearMask(codigo);
        if (!Pattern.matches("^[0-9]{44}$", cod)) return false;
        char DV = cod.charAt(4);
        String bloco = cod.substring(0, 4) + cod.substring(5);
        return Modulo.modulo11Bancario(bloco) == Character.getNumericValue(DV);
    }

    public static boolean boletoBancarioLinhaDigitavel(String codigo) {
        return boletoBancarioLinhaDigitavel(codigo, false);
    }

    public static boolean boletoBancarioLinhaDigitavel(String codigo, boolean validarBlocos) {
        String cod = Utils.clearMask(codigo);
        if (!Pattern.matches("^[0-9]{47}$", cod)) return false;
        String[] blocos = {
                cod.substring(0, 10),
                cod.substring(10, 21),
                cod.substring(21, 32)
        };
        boolean validBlocos = validarBlocos ? Arrays.stream(blocos).allMatch(e -> Modulo.modulo10(e.substring(0,e.length()-1)) == Character.getNumericValue(e.charAt(e.length() - 1))) : true;
        boolean validDV = boletoBancarioCodigoBarras(Conversor.convertToBoletoBancarioCodigoBarras(cod));
        return validBlocos && validDV;
    }

    public static boolean boletoBancario(String codigo) {
        return boletoBancario(codigo,false);
    }
    public static boolean boletoBancario(String codigo, boolean validarBlocos) {
        String cod = Utils.clearMask(codigo);
        if (cod.length() == 44) return boletoBancarioCodigoBarras(cod);
        if (cod.length() == 47) return boletoBancarioLinhaDigitavel(codigo, validarBlocos);
        return false;
    }
    
}
