# 🛻🦖 ArquioLogic 🦖🛻

## Sobre o Jogo
**ArquioLogic** é um jogo interativo no qual o jogador deve sobreviver e atacar os dinossauros que vem em sua direção, ele acaba por ser uma representação inpirada no antigo jogo de navezinha espacial que matava aliens e como parte de "quis" optei por tornar necessario responder uma pergunta após morrer para retornar ao jogo.

---

## Autoria
**Nome:** Weslley H. de B. Menezes
**Curso:** Sistemas de Informação - Universidade Federal de Santa Maria (UFSM)

---

## Comentários sobre o Processo de Desenvolvimento
### Planejamento e Ideia
O dessenvolvimento do jogo começou com a ideia de criar um scaperoom mas com o tempo optei por um jogo mais fácil e intuitivo de se criar após alguns imprevistos.

### Tecnologias Utilizadas
- **Linguagem:** Java
- **Framework:** LibGDX
- **IDE:** VSCode
- **Controle de Versão:** Git e GitHub

### Desafios Encontrados
1. **Renderização de Textos:** 
   quando estava quase terminando e fui compilar a versão em html ocorreu um erro com a biblioteca que eu estava usando e isso acabou por me fazer correr atras até achar uma biblioteca chamada `BitmapFont`, para a parte de font e escrita.
2. **Onde implementar o quiz:**
   Uma grande dificuldade foi conseguir implementar o quiz neste jogo mas optei por deichalo no final para voltar para o jogo.
3. **Implementação mais avançada:**
   Ocorreu deu tentar implementar um sistema mais complexo com as respostas, o que deu muito errado e em quanto eu tentava concertar, acabei subescrevendo todo o meu codigo `quiz` e com isso tive que escreve-lo do 0.
4. **mobilização de inicio e fim:**
   Demorei para conceguir anexar a logica do jogo parar nos momentos de inicio e de fim de jogo pois necessitava um condicionamento mais rígido.
5. **A biblioteca:**
   demorei muito para encontrar os comandos e os `inports` necessários dentre tantos que a gdx e ainda mais que a linguaem disponibiliza, porem aguns estavão dando conflito.
   
![Diagrama de Classes](PLJ1Rjim3BtxAuIU7CmvBCTwA9fsA52WXsxPOSMm0oCphW1PScdAIplitqSvjcF71cn9ZmJvnFVWsuQ1E5GsqHQQHdqBvaFzJPGyQxLZCgvKDL8P7CCC_VLR-PgDTqqF6yVo5aRZlIT2zXESiAczTDgXHTtZU-yjWbF0fXrolwDcSAN5iVgM49ga2t_goAKNfB85dsn9PTKNYBqW7Ku5DdE0eSzFLzS3lpv4w0gaT5UJORm3rgzg7x-PkZDSGVtWfUT1FaCjQmfuT7NWPIs6RRppDF0lwUU_fRTWddnfz5c5ovvv7_Y1Hmw4wX1SuJF5zq0Krw_6nULPPeEE2IYVLLBwb5V3W1-i1rQYaD7WVsR3xYLJBLglvIO5nlmOWfTy8I2y1OcNKA5laUByZJRdjbiYUFyoQdkZ2Y7O357hHKt6glQxG2L6yld4EhNCr8kchR2GHNpqnpqwKvdoN68YmRxR3e7EpJBGZtomKEjDeRIOYd6KlSDwWMTOOQ9jBn8TDBfZEOUhUFLEWIN-34jiLc4OfVPY6nFIao37pralpVkuiq3bU03Bu_wu6PCtq-JD97cpYaQRM6ozlZdDw5fTbIWZ4DckabiPXVmH_WC0)

# Estrutura do Projeto

## **Arquiolog**
- Gerencia todas as telas (`MenuScreen`, `GameScreen`, `VictoryScreen`, `GameOverScreen`).
- Possui métodos de controle como:
  - `startGame()`
  - `decrementLives()`
  - `incrementCorrectAnswers()`

---

## **GameScreen**
- **Usa:**
  - **`Dino`**: Responsável pela movimentação e colisão.
  - **`InteractiveObjectManager`**: Gerencia os objetos interativos.
  - **`QuizManager`**: Gerencia os quizzes.
  - **`GameRenderer`**: Renderiza o estado atual do jogo.
- Interage com `Main` para:
  - Ajustar vidas.
  - Controlar o progresso do jogo.

---





   ## Referencias:
   ### Conteúdos usados para o desenvolvimento do jogo:
   - Material da disciplina: https://github.com/andreaInfUFSM/elc117-2024b)
   - Documentação da LibGDX: https://libgdx.com/dev/
   - Terminal Root: https://www.youtube.com/watch?v=2bmvlwvnirk
   - ChatGpt (para consulta de alguns bugs relacionados a LibGDX e para consultar funcionalidades de bibliotecas)
   - Sprites gerados por I.A. - https://chatgpt.com/g/g-pmuQfob8d-image-generator

   ### Inspirações e informações das perguntas e respostas do quiz:
   - Material da disciplina: https://github.com/andreaInfUFSM/elc117-2024b)
   - compilado de videos do Terminal Root: https://www.youtube.com/watch?v=2bmvlwvnirk&list=PLUJBQEDDLNclxZvKTT2Icq9aVBPqLRMCA
