# 🛻🦖 ArquioLogic 🦖🛻

## Sobre o Jogo
**ArquioLogic** é um jogo interativo no qual o jogador precisa sobreviver enquanto enfrenta dinossauros que vêm em sua direção. Inspirado nos clássicos jogos de nave espacial, o diferencial é a necessidade de responder a perguntas de um quiz após ser derrotado para retornar ao jogo.

---

## Autoria
- **Autor:** Weslley H. de B. Menezes  
- **Curso:** Sistemas de Informação - Universidade Federal de Santa Maria (UFSM)

---

## Comentários sobre o Processo de Desenvolvimento

### Planejamento e Ideia
O desenvolvimento começou com a ideia de criar um escape room , um jogo que desafiaria os jogadores a resolver quebra-cabeças e enigmas para escapar de um ambiente fechado. No entanto, devido a imprevistos, como limitações de tempo, recursos e a complexidade envolvidos na implementação de um sistema de lógica robusto para enigmas, decidindo redirecionar o projeto para um jogo mais simples e intuitivo.

Uma nova abordagem focada em um jogo de ação em 2D, onde o jogador controla um veículo para enfrentar desafios e obstáculos em um cenário dinâmico. Esse formato mantém elementos de desafio e interatividade, mas é mais acessível tanto para desenvolvimento quanto para jogabilidade. Além disso, a escolha permite explorar conceitos fundamentais de programação de jogos, como entrega de personagens, detecção de colisões, lógica de pontuação de jogo e mecânicas de jogo.

### Tecnologias Utilizadas
- **Linguagem:** Java  
- **Framework:** LibGDX  
- **IDE:** VSCode  
- **Controle de Versão:** Git e GitHub  

### Desafios Encontrados
1. **Renderização de Textos:**  
   Encontrei problemas na compilação da versão HTML devido à biblioteca de fontes. Resolvi utilizando a `BitmapFont`.
2. **Implementação do Quiz:**  
   Houve dificuldades em integrar o quiz ao jogo, especialmente ao condicionar a continuidade do jogo à resposta correta.
3. **Sobrescrita de Código:**  
   Durante a implementação avançada, acidentalmente sobrescrevi meu código do quiz e precisei reescrevê-lo do zero.
4. **Paradas do Jogo:**  
   Configurar a lógica para início e fim do jogo foi desafiador por exigir um controle rigoroso.
5. **Exploração da LibGDX:**  
   Achar os comandos corretos e lidar com conflitos de imports consumiu tempo, mas foi superado com pesquisa e prática.
6. **conversão html:**
   Tive bastante dificuldade na parte de aplicar o comando `./gradlew html:dist` pois eu estava aplicando o comando `./gradlew html:superDev` na verdade, o que ocasionou em vaios bug inclusive no processo de desligamento automatico do meu PC.
7. **Perca do meu codigo inicial:**
   este foi o principal problema, no sabado (07/12) eu estava codando, pois comecei tarde o projeto e acabei por baixar uma biblioteca que ou arquivo que corrompeu meus arquivos e subescrevel as pastas que estavam no meu vs, o que acabou por apagar todo o meu progreço, então tive que recomeçar o programa do 0, tendo apenas 2 dias quando conversei com a professora.

---

![Diagrama de Classes](assets/diagrama.png).

## Estrutura do Projetotarde 

### **Arquiolog**
- Gerencia as telas (`MenuScreen`, `GameScreen`, `VictoryScreen`, `GameOverScreen`).
- Métodos principais:
  - `startGame()`
  - `decrementLives()`
  - `incrementCorrectAnswers()`

### **GameScreen**
- **Componentes Utilizados:**
  - `Dino`: Lida com movimentação e colisão dos dinossauros.
  - `InteractiveObjectManager`: Gerencia os objetos interativos.
  - `QuizManager`: Administra o quiz.
  - `GameRenderer`: Renderiza o estado do jogo.
- **Integrações com `Arquiolog`:**
  - Ajusta vidas e controla progresso do jogo.

---

## Conclusão

Apesar das dificuldades enfrentadas ao longo do desenvolvimento da ArquioLogic , o projeto serviu como uma experiência rica de aprendizado. Desde os desafios técnicos, como a renderização de textos e a integração de diferentes componentes, até os imprevistos, como a perda de código e a necessidade de recomeçar o trabalho com tempo limitado, cada obstáculo contribuído para o amadurecimento técnico e pessoal no contexto da programação de jogos .

Embora o resultado final apresente limitações e a qualidade do código ainda possa ser aprimorado, o processo em si foi revelado extremamente importante. Ele proporcionou um aprofundamento nas tecnologias utilizadas, especialmente na biblioteca LibGDX, e consolidou a capacidade de resolver problemas sob pressão. Além disso, declarou a importância do planejamento, da organização e do uso de boas práticas em projetos de software.

O jogo final, com sua simplicidade e criatividade, reflete um esforço dedicado em superar adversidades e transformar uma ideia complexa inicial em um produto funcional. Assim, ArquioLogic representa não apenas um marco acadêmico, mas também um lembrete de que, mesmo em meio a contratempos, é possível criar algo significativo e crescer com a experiência.

---

## Referências
1. **Material da disciplina:** [GitHub da ELC117](https://github.com/andreaInfUFSM/elc117-2024b)  
2. **Documentação da LibGDX:** [libgdx.com](https://libgdx.com/dev/)  
3. **Inspirações e tutoriais:**  
   - [Canal Terminal Root](https://www.youtube.com/watch?v=2bmvlwvnirk)  
   - Sprites gerados por IA ([ChatGPT](https://chatgpt.com/g/g-pmuQfob8d-image-generator))  
4. **Quiz:** Baseado no material do curso e vídeos do canal Terminal Root.

---
