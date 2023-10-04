package br.com.boletobrasileirovalidador;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConversorTest {
    @Test
    void testeGeral() {
        Assertions.assertAll(
                "Grupo de testes do Conversor",
                () -> Assertions.assertEquals("23799755200003700003381260007827139500006330",Conversor.convertToBoletoBancarioCodigoBarras("23793381286000782713695000063305975520000370000"), "converte linha digitável para código de barras do boleto bancário"),
                () -> Assertions.assertEquals("83620000000667800481001809756573100158963608",Conversor.convertToBoletoArrecadacaoCodigoBarras("836200000005 667800481000 180975657313 001589636081"), "converte linha digitável para código de barras do boleto de arrecadação")
        );
    }
}
