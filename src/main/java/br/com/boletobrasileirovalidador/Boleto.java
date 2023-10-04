package br.com.boletobrasileirovalidador;

public class Boleto {

    public static boolean boleto(String codigo) {
        return boleto(codigo,false);
    }

	public static boolean boleto(String codigo, boolean validarBlocos) {
        String cod = Utils.clearMask(codigo);
        if (Integer.parseInt(String.valueOf(cod.charAt(0))) == 8) {
            return BoletoArrecadacao.boletoArrecadacao(cod, validarBlocos);
        } else {
        	return BoletoBancario.boletoBancario(codigo, validarBlocos);
        }
    }
}
