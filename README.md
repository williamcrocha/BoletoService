# validadorBoleto

**ATENÇÃO!!!** Esta é uma implementação Spring Rest API do projeto original [boleto-brasileiro-validador](https://github.com/mcrvaz/boleto-brasileiro-validator/tree/master) 
para validar boletos. 

Suporta boletos de arrecadação e boletos bancários, tanto a representação do código de barras como a linha digitável.

**Todas as validações podem ser feitas com ou sem máscara.**

## Exemplos de boletos

## Arrecadação
![Represetação visual do código de barras do boleto de arrecadação](https://i.imgur.com/AQmEn0S.png)
### Arrecadação - Código de barras
    85890000460 52460179160 60759305086 83148300001
### Arrecadação - Linha digitável
    85890000460-9 52460179160-5 60759305086-5 83148300001-0

## Bancário
![Represetação visual do código de barras do boleto bancário](https://i.imgur.com/FfCdC1Y.png)
### Bancário - Código de barras
    84890000000404201622018060519042958603411122
### Bancário - Linha digitável
    23793.38128 60007.827136 95000.063305 9 75520000370000

# Como usar

Você pode usar a IDE de sua preferência para executar o projeto ou através do terminal. Para executar via terminal certifique-se de estar usando o java na versão 17 e execute o seguinte comando: **mvn spring-boot:run** 

Com a aplicação em execução acesse o seguinte link no browser: http://localhost:8080/swagger-ui/index.html

No formulário disponibilizado é possível executar testes acessando diretamente cada endpoint do projeto.

# Regras de Validação
Regras para validação de boletos bancários: [Especificações Técnicas
para Confecção de Boleto de Cobrança
do Banco do Brasil](http://www.bb.com.br/docs/pub/emp/empl/dwn/Doc5175Bloqueto.pdf)

Regras para validação de boletos de arrecadação: [FEBRABAN - "Layout" Padrão de Arrecadação/Recebimento
com Utilização do Código de Barras](https://cmsportal.febraban.org.br/Arquivos/documentos/PDF/Layout%20-%20C%C3%B3digo%20de%20Barras%20ATUALIZADO.pdf)

# Mais detalhes?

Acesse o projeto original em Javascript no link [boleto-brasileiro-validador](https://github.com/mcrvaz/boleto-brasileiro-validator/tree/master) 
