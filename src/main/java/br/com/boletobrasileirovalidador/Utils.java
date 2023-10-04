package br.com.boletobrasileirovalidador;

public class Utils {
	
	public static String clearMask(String codigo) {
        return codigo.replaceAll("[ .-]", "");
    }

}
