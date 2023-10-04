package br.com.boletobrasileirovalidador;

public class Modulo {
	
	/*
	  A representa��o num�rica do c�digo de barras � composta, por cinco campos, sendo os
	  tr�s primeiros amarrados por DVs e calculados pelo m�dulo 10, conforme segue:
	    a) O m�dulo 10 dever� ser utilizado para calcular o DV dos 03 (tr�s) primeiros campos
	    da linha digit�vel;
	    b) Os multiplicadores come�am com o n�mero 2 (dois), sempre pela direita, alternandose
	    1 e 2;
	    c) Multiplicar cada algarismo que comp�e o n�mero pelo seu respectivo peso
	    (multiplicador):
	    d) Caso o resultado da multiplica��o seja maior que 9 (nove) dever�o ser somados os
	    algarismos do produto, at� reduzi-lo a um �nico algarismo:
	    a. Exemplo: Resultado igual a 18, ent�o 1+8 = 9
	    e) Subtrair o total apurado no item anterior, da dezena imediatamente superior ao total
	    apurado:
	    a. Exemplo: Resultado da soma igual a 25, ent�o 30 - 25
	    f) O resultado obtido ser� o d�gito verificador do n�mero;
	    a. Exemplo: 30-25 = 5 ent�o 5 � o D�gito Verificador
	    g) Se o resultado da subtra��o for igual a 10 (dez), o d�gito verificador ser� igual a 0
	    (zero)
	*/
	public static int modulo10(String bloco) {
        char[] codigo = new StringBuilder(bloco).reverse().toString().toCharArray();
        int somatorio = 0;
        for (int i = 0; i < codigo.length; i++) {
            int soma = Character.getNumericValue(codigo[i]) * (((i + 1) % 2) + 1);
            soma = (soma > 9 ? (soma / 10) + (soma % 10) : soma);
            somatorio += soma;
        }
        return (int) (Math.ceil(somatorio / 10.0) * 10) - somatorio;
    }
	
	/*
	  Por defini��o do BACEN, na 5� posi��o do c�digo de barras, deve ser indicado,
	  obrigatoriamente, o �d�gito verificador� (DV), do C�digo de Barras, calculado pelo m�dulo
	  11, conforme segue:
	    a) O c�digo de barras possui 44 (quarenta e quatro) posi��es, incluindo o DV;
	    b) Para calcular o DV considerar 43 posi��es do C�digo de Barras sendo da posi��o 1
	    a 4 e da posi��o 6 a 44;
	    c) Multiplicar cada algarismo que comp�e o n�mero pelo seu respectivo multiplicador
	    (peso), iniciando-se pela 44a posi��o e saltando a 5a posi��o;
	    d) Os multiplicadores (pesos) variam de 2 a 9;
	    e) O primeiro d�gito da direita para a esquerda dever� ser multiplicado por 2, o segundo
	    por 3 e assim sucessivamente;
	    f) Os resultados das multiplica��es devem ser somados:
	    a. Exemplo:(6 X 2) + (3 X 1) + (4 X 8) + ... + (4 X 0) = 712;
	    g) O total da soma dever� ser dividido por 11:
	    a. Exemplo: 712/11 = 64. Resto igual a 8;
	    h) O resto da divis�o dever� ser subtra�do de 11:
	    a. Exemplo: 11 - 8 = 3, Portando �3� � o D�gito verificador
	    i) Se o resultado da subtra��o for:
	      I - igual a 0.....................D.V. igual a 1
	      II - igual a 10....................D.V. igual a 1
	      III - igual a 11....................D.V. igual a 1
	      IV - diferente de 10 e 11..........D.V. ser� o pr�prio d�gito, no caso do exemplo �3�
	*/
	public static int modulo11Bancario(String bloco) {
	        char[] codigo = new StringBuilder(bloco).reverse().toString().toCharArray();
	        int multiplicador = 2;
	        int somatorio = 0;
	        for (char current : codigo) {
	            int soma = Character.getNumericValue(current) * multiplicador;
	            multiplicador = multiplicador == 9 ? 2 : multiplicador + 1;
	            somatorio += soma;
	        }
	        int restoDivisao = somatorio % 11;
	        int DV = 11 - restoDivisao;
	        if (DV == 0 || DV == 10 || DV == 11) return 1;
	        return DV;
	    }
	
	/*
	  O DAC (D�gito de Auto-Confer�ncia) m�dulo 11, de um n�mero � calculado multiplicando
	  cada algarismo, pela seq��ncia de multiplicadores 2,3,4,5,6,7,8,9,2,3,4....
	  posicionados da direita para a esquerda.

	  A soma dos produtos dessa multiplica��o � dividida por 11, obt�m-se o resto da divis�o, este
	  resto deve ser subtra�do de 11, o produto da subtra��o � o DAC.

	  Observa��o: Quando o resto da divis�o for igual a 0 ou 1, atribu�-se ao DV o digito �0�,
	  e quando for 10, atribu�-se ao DV o digito �1�.
	*/
	public static int modulo11Arrecadacao(String bloco) {
        char[] codigo = new StringBuilder(bloco).reverse().toString().toCharArray();
        int multiplicador = 2;
        int somatorio = 0;
        for (char current : codigo) {
            int soma = Character.getNumericValue(current) * multiplicador;
            multiplicador = multiplicador == 9 ? 2 : multiplicador + 1;
            somatorio += soma;
        }
        int restoDivisao = somatorio % 11;
        if (restoDivisao == 0 || restoDivisao == 1) {
            return 0;
        }
        if (restoDivisao == 10) {
            return 1;
        }
        int DV = 11 - restoDivisao;
        return DV;
    }

}
