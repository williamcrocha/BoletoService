package br.com.boletobrasileirovalidador;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoletoArrecadacaoTest{
	
	@Test
	void testeGeral() {
		Assertions.assertAll(
				"Grupo de testes do Boleto de Arrecadação",
			  	() -> Assertions.assertTrue(BoletoArrecadacao.boletoArrecadacaoLinhaDigitavel("836200000005 667800481000 180975657313 001589636081"), "validação da linha digitável do boleto de arrecadação válido módulo 10 com máscara"),
				() -> Assertions.assertTrue(BoletoArrecadacao.boletoArrecadacaoLinhaDigitavel("836200000005667800481000180975657313001589636081"), "validação da linha digitável do boleto de arrecadação com blocos módulo 10 válidos"),
				() -> Assertions.assertFalse(BoletoArrecadacao.boletoArrecadacaoLinhaDigitavel("836200000005667800481800180975657313001589636081"), "validação da linha digitável do boleto de arrecadação inválido módulo 10"),
				() -> Assertions.assertTrue(BoletoArrecadacao.boletoArrecadacaoLinhaDigitavel("85890000460-9 52460179160-5 60759305086-5 83148300001-0"), "validação da linha digitável do boleto de arrecadação válido módulo 11 com máscara"),
				() -> Assertions.assertTrue(BoletoArrecadacao.boletoArrecadacaoLinhaDigitavel("848900000002404201622015806051904292586034111220"), "validação da linha digitável do boleto de arrecadação válido módulo 11 sem máscara"),
				() -> Assertions.assertFalse(BoletoArrecadacao.boletoArrecadacaoLinhaDigitavel("848900000002404201622015809051904292586034111220"), "validação da linha digitável do boleto de arrecadação inválido módulo 11"),
				() -> Assertions.assertFalse(BoletoArrecadacao.boletoArrecadacaoLinhaDigitavel("536400000011331201380002812884627116080136181551"), "validação da linha digitável do boleto de arrecadação com identificação inválida"),
				() -> Assertions.assertFalse(BoletoArrecadacao.boletoArrecadacaoLinhaDigitavel("842900000002404201622015806051904292586034111220"), "validação da linha digitável do boleto de arrecadação com moeda inválida"),
				() -> Assertions.assertFalse(BoletoArrecadacao.boletoArrecadacaoLinhaDigitavel("53640000001133120180002812884627116080136181551"), "validação da linha digitável do boleto de arrecadação com tamanho inválido"),
				() -> Assertions.assertTrue(BoletoArrecadacao.boletoArrecadacaoCodigoBarras("83620000000667800481001809756573100158963608"), "validação do código de barras do boleto de arrecadação válido módulo 10"),
				() -> Assertions.assertTrue(BoletoArrecadacao.boletoArrecadacaoCodigoBarras("84890000000404201622018060519042958603411122"), "validação do código de barras do boleto de arrecadação válido módulo 11"),
				() -> Assertions.assertFalse(BoletoArrecadacao.boletoArrecadacaoCodigoBarras("83620000000667800481001809756573800158963608"), "validação do código de barras do boleto de arrecadação inválido"),
				() -> Assertions.assertFalse(BoletoArrecadacao.boletoArrecadacaoCodigoBarras("54640000000873500240300150349033470804040612"), "validação do código de barras do boleto de arrecadação com identificação inválida"),
				() -> Assertions.assertFalse(BoletoArrecadacao.boletoArrecadacaoCodigoBarras("84240000000873500240300150349033470804040612"), "validação do código de barras do boleto de arrecadação com moeda inválida"),
				() -> Assertions.assertFalse(BoletoArrecadacao.boletoArrecadacaoCodigoBarras("8464000000087350024030015034903370804040612"), "validação do código de barras do boleto de arrecadação com tamanho inválido"),
				() -> Assertions.assertTrue(BoletoArrecadacao.boletoArrecadacao("836200000005667800481000180975657313001589636081"), "validação do boleto de arrecadação"),
				() -> Assertions.assertTrue(BoletoArrecadacao.boletoArrecadacao("836200000005667800481000180975657313001589636081"), "validação do boleto de arrecadação com blocos válidos"),
				() -> Assertions.assertFalse(BoletoArrecadacao.boletoArrecadacao("836200000007800481000180975657313001589636081"), "validação do boleto de arrecadação inválido"),
				() -> Assertions.assertTrue(BoletoArrecadacao.boletoArrecadacao("858000000070438403281922630720192528304729600523"), "validação do boleto de arrecadação com modulo11 específico")
				);
	}
}
