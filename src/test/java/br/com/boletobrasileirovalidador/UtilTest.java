package br.com.boletobrasileirovalidador;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UtilTest {
    @Test
    void testeGeral() {
        Assertions.assertAll(
                "Grupo de testes do Util",
                () -> Assertions.assertEquals("",Utils.clearMask(".."), "'remove pontos"),
                () -> Assertions.assertEquals("",Utils.clearMask("--"), "'remove hífens"),
                () -> Assertions.assertEquals("",Utils.clearMask("  "), "'remove espaços")
        );
    }
}
