package br.com.boletobrasileirovalidador;

public class Conversor {

	public static String convertToBoletoArrecadacaoCodigoBarras(String codigo) {
        String cod = Utils.clearMask(codigo);
        String codigoBarras = "";
        for (int index = 0; index < 4; index++) {
            int start = (11 * (index)) + index;
            int end = (11 * (index + 1)) + index;
            codigoBarras += cod.substring(start, end);
        }
        return codigoBarras;
    }

    public static String convertToBoletoBancarioCodigoBarras(String codigo) {
        String cod = Utils.clearMask(codigo);
        String codigoBarras = "";
        codigoBarras += cod.substring(0, 3); // Identifica��o do banco
        codigoBarras += cod.substring(3, 4); // C�digo da moeda
        codigoBarras += cod.substring(32, 33); // DV
        codigoBarras += cod.substring(33, 37); // Fator Vencimento
        codigoBarras += cod.substring(37, 47); // Valor nominal
        codigoBarras += cod.substring(4, 9); // Campo Livre Bloco 1
        codigoBarras += cod.substring(10, 20); // Campo Livre Bloco 2
        codigoBarras += cod.substring(21, 31); // Campo Livre Bloco 3
        return codigoBarras;
    }
    
}
