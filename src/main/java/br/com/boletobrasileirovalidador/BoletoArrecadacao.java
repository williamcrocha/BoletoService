package br.com.boletobrasileirovalidador;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class BoletoArrecadacao {
	
	private static class Bloco {
	    String num;
	    String DV;

	    public Bloco(String num, String DV) {
	      this.num = num;
	      this.DV = DV;
	    }
	  }

	public static boolean boletoArrecadacao(String codigo) {
		return boletoArrecadacao(codigo,false);
	}

	public static boolean boletoArrecadacao(String codigo, boolean validarBlocos) {
		String cod = Utils.clearMask(codigo);
		if (cod.length() == 44) return boletoArrecadacaoCodigoBarras(cod);
		if (cod.length() == 48) return boletoArrecadacaoLinhaDigitavel(codigo, validarBlocos);
		return false;
	}

	public static boolean boletoArrecadacaoCodigoBarras(String codigo) {
	    String cod = Utils.clearMask(codigo);
	    if (!Pattern.matches("^[0-9]{44}$", cod) || Integer.parseInt(String.valueOf(cod.charAt(0))) != 8) return false;
	    int codigoMoeda = Integer.parseInt(String.valueOf(cod.charAt(2)));
	    int DV = Integer.parseInt(String.valueOf(cod.charAt(3)));
	    String bloco = cod.substring(0, 3) + cod.substring(4);
	    return isDigitoVerificadorValido(codigoMoeda, bloco, DV);
	  }

	public static boolean boletoArrecadacaoLinhaDigitavel(String codigo) {
		return boletoArrecadacaoLinhaDigitavel(codigo,false);
	}

	public static boolean boletoArrecadacaoLinhaDigitavel(String codigo, boolean validarBlocos) {
	    String cod = Utils.clearMask(codigo);
	    if (!Pattern.matches("^[0-9]{48}$", cod) || Integer.parseInt(String.valueOf(cod.charAt(0))) != 8) return false;
	    boolean validDV = boletoArrecadacaoCodigoBarras(Conversor.convertToBoletoArrecadacaoCodigoBarras(cod));
	    if (!validarBlocos) return validDV;
	    int codigoMoeda = Integer.parseInt(String.valueOf(cod.charAt(2)));
	    List<Bloco> blocos = new ArrayList<>();
	    for (int index = 0; index < 4; index++) {
	      int start = (11 * (index)) + index;
	      int end = (11 * (index + 1)) + index;
	      blocos.add(new Bloco(cod.substring(start, end), cod.substring(end, end + 1)));
	    }
	    boolean validBlocos = blocos.stream().allMatch(e -> isDigitoVerificadorValido(codigoMoeda, e.num, Integer.parseInt(e.DV)));
	    return validBlocos && validDV;
	  }
	  
	  private static boolean isDigitoVerificadorValido(int codigoMoeda,String bloco, int DVesperado) {
		  if (codigoMoeda == 6 || codigoMoeda == 7) {
		    	return Modulo.modulo10(bloco) == DVesperado;
		    } else if (codigoMoeda == 8 || codigoMoeda == 9) {
		    	return Modulo.modulo11Arrecadacao(bloco) == DVesperado;
		    } else {
		    	return false;
		    }
	  }
}
