package br.com.williamrocha.validadorBoleto.resource;

import br.com.boletobrasileirovalidador.Boleto;
import br.com.boletobrasileirovalidador.BoletoArrecadacao;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Tag(name = "Boleto service",description = "API de validação de boletos")
public class BoletoController {

    @GetMapping("/boleto")
    @Operation(summary = "Para validar qualquer tipo de boleto, com ou sem máscara")
    public ResponseEntity validarBoleto(@RequestParam(name="codigo",required = true)
                                        @Parameter(description = "Código do boleto bancário ou de arrecadação (luz, água, etc.)") String codigoBarra,
                                        @RequestParam(name="validarBloco",required = false)
                                        @Parameter(description = "Indica se deseja validar cada bloco numérico do boleto")
                                        Boolean validarBloco) {
        boolean resultado = Boleto.boleto(codigoBarra,validarBloco==null?false:validarBloco);
        return new ResponseEntity(resultado, resultado?HttpStatus.OK:HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/boletoArrecadacao")
    @Operation(summary = "Para validar boleto de arrecadação, com ou sem máscara")
    public ResponseEntity validarBoletoArrecadacao(@RequestParam(name="codigo",required = true)
                                                   @Parameter(description = "Código do boleto de arrecadação (luz, água, etc.)") String codigoBarra,
                                                   @RequestParam(name="validarBloco",required = false)
                                                   @Parameter(description = "Indica se deseja validar cada bloco numérico do boleto")
                                                   Boolean validarBloco) {
        boolean resultado = BoletoArrecadacao.boletoArrecadacao(codigoBarra,validarBloco==null?false:validarBloco);
        return new ResponseEntity(resultado, resultado?HttpStatus.OK:HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/boletoArrecadacaoCodigoBarras")
    @Operation(summary = "Para validar o código de barras do boleto de arrecadação")
    public ResponseEntity validarBoletoArrecadacaoCodigoBarras(@RequestParam(name="codigo",required = true)
                                                   @Parameter(description = "Código de barras do boleto de arrecadação (luz, água, etc.)") String codigoBarra) {
        boolean resultado = BoletoArrecadacao.boletoArrecadacaoCodigoBarras(codigoBarra);
        return new ResponseEntity(resultado, resultado?HttpStatus.OK:HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/boletoArrecadacaoLinhaDigitavel")
    @Operation(summary = "Para validar a linha digitável do boleto de arrecadação, com ou sem máscara")
    public ResponseEntity validarBoletoArrecadacaoLinhaDigitavel(@RequestParam(name="codigo",required = true)
                                                   @Parameter(description = "Código digitavel do boleto de arrecadação (luz, água, etc.)") String codigoBarra,
                                                   @RequestParam(name="validarBloco",required = false)
                                                   @Parameter(description = "Indica se deseja validar cada bloco numérico do boleto")
                                                   Boolean validarBloco) {
        boolean resultado = BoletoArrecadacao.boletoArrecadacaoLinhaDigitavel(codigoBarra,validarBloco==null?false:validarBloco);
        return new ResponseEntity(resultado, resultado?HttpStatus.OK:HttpStatus.BAD_REQUEST);
    }
}
