package com.terminalroot.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;

// Classe que gerencia o sistema de perguntas e múltiplas respostas
public class Quiz {
    private String pergunta; 
    private String[] options; // Opções de resposta, está em ingles por que se não fica opicao.
    private int indiceCorreto; 
    private int respostaSelec; // Resposta selecionada pelo usuário
    private boolean ativo; // para determinar se o quiz está ativo
    private Rectangle[] optionAreas; // Áreas de clique para cada opção

    public Quiz(String pergunta, String[] options, int indiceCorreto) {
        this.pergunta = pergunta;
        this.options = options; 
        this.indiceCorreto = indiceCorreto; 
        this.respostaSelec = -1; 
        this.ativo = false;
        this.optionAreas = new Rectangle[options.length];
    }

    // Método para ativar o quiz
    public void ativa() {
        this.ativo = true; // Ativa o quiz
        this.respostaSelec = -1; // Reseta a resposta selecionada ao ativar o quiz
    }

    // Método para desativar o quiz
    public void desativa() {
        this.ativo = false; // Desativa o quiz
    }

    // Verificar se a resposta está correta
    public boolean taCorreto() {
        return respostaSelec == indiceCorreto; // Verifica se a resposta selecionada é a correta
    }

    // Método para renderizar o quiz
    public void render(SpriteBatch batch, BitmapFont font) {
        if (ativo) {
            font.draw(batch, pergunta, 100, 450); // Desenha a pergunta
            for (int i = 0; i < options.length; i++) {
                float y = 350 - (i * 40);
                font.draw(batch, (i + 1) + ". " + options[i], 100, y); // Desenha cada opção de resposta
                // Define as áreas de clique para cada opção
                optionAreas[i] = new Rectangle(100, y - 30, font.getData().lineHeight * options[i].length(), font.getData().lineHeight);
            }
        }
    }

    // Método para lidar com a entrada do usuário
    public boolean lidaInput() {
        if (Gdx.input.isTouched()) {
            float x = Gdx.input.getX();
            float y = Gdx.graphics.getHeight() - Gdx.input.getY(); // Ajuste de coordenadas
            for (int i = 0; i < optionAreas.length; i++) {
                if (optionAreas[i].contains(x, y)) {
                    respostaSelec = i; // Seleciona a resposta com base no clique do usuário
                    return taCorreto(); // Verifica se a opção selecionada é correta
                }
            }
        }
        return false;
    }

    public boolean taAtivo() {
        return ativo; // Retorna se o quiz está ativo
    }
}