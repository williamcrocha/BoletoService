package br.com.boletobrasileirovalidador;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoletoBancarioTest {
	
	@Test
	void testeGeral() {
		Assertions.assertAll(
				"Grupo de testes do Boleto de Bancário",
				() -> Assertions.assertTrue(BoletoBancario.boletoBancarioLinhaDigitavel("23793.38128 60007.827136 95000.063305 9 75520000370000"), "validação da linha digitável do boleto válido com máscara"),
				() -> Assertions.assertTrue(BoletoBancario.boletoBancarioLinhaDigitavel("23793381286000782713695000063305975520000370000"), "validação da linha digitável do boleto válido sem máscara"),
				() -> Assertions.assertTrue(BoletoBancario.boletoBancarioLinhaDigitavel("23793381286000782713695000063305975520000370000"), "validação da linha digitável do boleto com blocos válidos"),
				() -> Assertions.assertFalse(BoletoBancario.boletoBancarioLinhaDigitavel("23793.38128 60007.827136 95000.063305 4 75520000370000"), "validação da linha digitável do boleto inválido"),
				() -> Assertions.assertFalse(BoletoBancario.boletoBancarioLinhaDigitavel("23793.38128 6007.827136 95000.063305 4 75520000370000"), "validação da linha digitável do boleto com tamanho inválido"),
				() -> Assertions.assertTrue(BoletoBancario.boletoBancarioCodigoBarras("00193373700000001000500940144816060680935031"), "validação do código de barras do boleto válido"),
				() -> Assertions.assertFalse(BoletoBancario.boletoBancarioCodigoBarras("00153373700000001000500940144816060680935031"), "validação do código de barras do boleto inválido"),
				() -> Assertions.assertFalse(BoletoBancario.boletoBancarioCodigoBarras("0015337300000001000500940144816060680935031"), "validação do código de barras do boleto com tamanho inválido"),
				() -> Assertions.assertTrue(BoletoBancario.boletoBancario("23793381286000782713695000063305975520000370000"), "validação do boleto"),
				() -> Assertions.assertTrue(BoletoBancario.boletoBancario("23793381286000782713695000063305975520000370000"), "validação do boleto com blocos válidos"),
				() -> Assertions.assertFalse(BoletoBancario.boletoBancario("2379338128600078271369500006975520000370000"), "validação do boleto inválido")
				);
	}
}
