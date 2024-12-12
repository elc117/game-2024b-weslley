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
   
4. **Implementação mais avançada:**
   Ocorreu deu tentar implementar um sistema mais complexo com as respostas, o que deu muito errado e em quanto eu tentava concertar, acabei subescrevendo todo o meu codigo `quiz` e com isso tive que escreve-lo do 0.


![Diagrama de Classes](diagrama1.png)

# Estrutura do Projeto

## **Main**
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

## **Dino**
- Representa o personagem jogável.
- Responsabilidades:
  - Movimentação.
  - Verificação de colisões (usado por `GameScreen` e `InteractiveObjectManager`).

---

## **InteractiveObjectManager**
- Cria e gerencia **`InteractiveObject`**.
- Detecta colisões com `Dino`.

---

## **InteractiveObject**
- Contém:
  - Perguntas.
  - Opções de resposta.
- **Usado por:**
  - `InteractiveObjectManager` para criar objetos interativos.
  - `QuizManager` para exibir quizzes.

---

## **QuizManager**
- Gerencia o estado do quiz:
  - Perguntas.
  - Respostas.
- Interage diretamente com **`InteractiveObject`**.

---

## **GameRenderer**
- Renderiza o estado visual do jogo, incluindo:
  - **`Dino`**
  - **`InteractiveObjectManager`**

---

## **Outras Telas**
### **MenuScreen**, **VictoryScreen**, **GameOverScreen**
- Herdam de `Screen`.
- Usadas pelo **`Main`**.

   ## Jogo Rodando: https://youtu.be/OCFOK5X6tuo



   ## Referencias:
   ### Conteúdos usados para o desenvolvimento do jogo:
   - Material da disciplina: https://github.com/andreaInfUFSM/elc117-2024b)
   - Documentação da LibGDX: https://libgdx.com/dev/
   - Welsiton Ferreira - Desenvolvedor Indie: https://www.youtube.com/playlist?list=PLwlysxDPhB-9uWQBnjGenhONQXS6gzvOp
   - ChatGpt (para consulta de alguns bugs relacionados a LibGDX)
   - Terminal Root: https://www.youtube.com/watch?v=2bmvlwvnirk
   - Brent Aureli Codes: https://www.youtube.com/playlist?list=PLZm85UZQLd2SXQzsF-a0-pPF6IWDDdrXt
   - Sprites gerados por I.A. - https://chatgpt.com/g/g-pmuQfob8d-image-generator

   ### Inspirações e informações das perguntas e respostas do quiz:
   - GeoParque Quarta Colônia: https://www.geoparquequartacolonia.com.br/home
   - GeoParque Caçapava: https://geoparquecacapava.com.br/
   - Distrito Criativo Centro-Gare: http://www.distritocentrogare.com.br/index.php/pt/
   - Jardim Botânico da UFSM: https://www.ufsm.br/orgaos-suplementares/jardim-botanico
