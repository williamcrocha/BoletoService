package br.com.boletobrasileirovalidador;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoletoTest {
    @Test
    void testeGeral() {
        Assertions.assertAll(
                "Grupo de testes do Boleto",
                () -> Assertions.assertTrue(Boleto.boleto("23793.38128 60007.827136 95000.063305 9 75520000370000"), "validar linha digitável do boleto"),
                () -> Assertions.assertTrue(Boleto.boleto("23793.38128 60007.827136 95000.063305 9 75520000370000", true), "validar blocos da linha digitável do boleto"),
                () -> Assertions.assertTrue(Boleto.boleto("00193373700000001000500940144816060680935031"), "validar código de barras do boleto"),
                () -> Assertions.assertTrue(Boleto.boleto("85890000460-9 52460179160-5 60759305086-5 83148300001-0"), "validar linha digitável do boleto de arrecadação"),
                () -> Assertions.assertTrue(Boleto.boleto("83620000000667800481001809756573100158963608"), "validar código de barras do boleto de arrecadação"),
                () -> Assertions.assertFalse(Boleto.boleto("836200000000481001809756573100158963608"), "formato de boleto não identificado")
        );
    }
}
