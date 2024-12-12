package com.terminalroot.game;
import com.terminalroot.game.Quiz;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import java.util.Iterator;



public class ArquiLogic extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture fundo, tCarro, tDino, tPa, entrar;
    private Sprite carro, pa;
    private float posicaoX, posicaoY, velocidade, paX, paY;
    private boolean ataque, gameover, iniciar;
    private Array <Rectangle> dinos;
    private long tempoSurgeDino;
    private int pontos, vidas, spownInimigos;
    private BitmapFont bitmap;
    private Quiz quiz; 

    @Override
    public void create() {
        batch = new SpriteBatch();
        fundo = new Texture("terreno.png");
        tCarro = new Texture("jeep.png");
        tPa = new Texture("pa.png");
        tDino = new Texture("dino.png");
        entrar = new Texture("inicio.png");
        carro = new Sprite(tCarro);
        pa = new Sprite(tPa);
        dinos = new Array <Rectangle>();
        posicaoX = 0;
        posicaoY = 340;
        paX = posicaoX;
        paY = posicaoY;
        velocidade = 10;
        tempoSurgeDino = 0;
        pontos = 0;
        vidas = 3;
        spownInimigos = 1500000000;
        ataque = false;
        gameover = false;
        iniciar = true;

        bitmap = new BitmapFont(Gdx.files.internal("fonte.fnt"));

        quiz = new Quiz("Qual conceito da POO representa a ideia de esconder os detalhes\ne mostrar apenas a funcionalidade necessária?", 
            new String[] {"Herança", "Abstração", "Emcapsulamento", "Polimorfismo"}, 
            2);
    }

    @Override
    public void render() {

        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.draw(fundo, 0, 0);

        if(iniciar){
            batch.draw(entrar, Gdx.graphics.getWidth() / 2 - entrar.getWidth() / 2, Gdx.graphics.getHeight() / 2 - entrar.getHeight() / 2);
            if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) { // Usa isKeyJustPressed para capturar apenas uma vez
                iniciar = false;
            }
        } else {

            this.moverCarro();
            this.movePa();
            this.moveDino();

            if (!gameover) {
                if (ataque) {
                    batch.draw(pa, paX + carro.getWidth() / 2, paY + carro.getHeight() / 2 - 14);
                }
                batch.draw(carro, posicaoX, posicaoY);
                for (Rectangle dino : dinos) {
                    batch.draw(tDino, dino.x, dino.y);
                }
                bitmap.draw(batch, "Score: " + pontos,
                            20, Gdx.graphics.getHeight() - 20);
                bitmap.draw(batch, "Life: " + vidas,
                            Gdx.graphics.getWidth() - 200,
                            Gdx.graphics.getHeight() - 20);
                
            } else if (gameover) {

                if (!quiz.taAtivo()) {
                    quiz.ativa(); // Ativa o quiz
                } else {
                    if (quiz.lidaInput()) {
                        // Jogador respondeu corretamente
                        quiz.desativa();
                        gameover = false;       // Reseta o estado de gameover
                        pontos = 0;             // Reinicia a pontuação
                        vidas = 3;              // Reinicia as vidas
                        posicaoX = 0;
                        posicaoY = 340;
                        spownInimigos = 1500000000; // Ajusta o tempo de spawn dos inimigos
                        dinos = new Array <Rectangle>();
                    }
                }
                quiz.render(batch, bitmap); // Renderiza o quiz na tela

            
            }
        }
        


        
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        fundo.dispose();
        tCarro.dispose();
    }

    private void nasceDino() {
        Rectangle dino = new Rectangle(Gdx.graphics.getWidth(),
            MathUtils.random(0, Gdx.graphics.getHeight() - tDino.getHeight()),
            tDino.getWidth(), tDino.getHeight()
        );
        dinos.add(dino);
        tempoSurgeDino = TimeUtils.nanoTime();
    }

    private void moverCarro()  {
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)) {
            if(posicaoX < Gdx.graphics.getWidth() - carro.getWidth()) {
                posicaoX += velocidade;
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)) {
            if(posicaoX > 0) {
                posicaoX -= velocidade;
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W)) {
            if(posicaoY < Gdx.graphics.getHeight() - carro.getHeight()) {
                posicaoY += velocidade;
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S)) {
            if(posicaoY > 0) {
                posicaoY -= velocidade;
            }
        }
    }

    private void movePa() {

        if(Gdx.input.isKeyPressed(Input.Keys.SPACE) && !ataque) {
            ataque = true;
            paY = posicaoY;
        }

        if(ataque) {
            if(paX < Gdx.graphics.getWidth()) {
               paX += 20; 
            } else {
                paX = posicaoX;
                ataque = false;
            }
            
        } else {
            paX = posicaoX;
            paY = posicaoY;
        }
        
    }

    private void moveDino() {
        if (TimeUtils.nanoTime() - tempoSurgeDino > spownInimigos){
            this.nasceDino();
        }
            
        for (Iterator<Rectangle> iter = dinos.iterator(); iter.hasNext();) {
            Rectangle dino = iter.next();
            dino.x -= 400 * Gdx.graphics.getDeltaTime();

             // colisão com a pá
            if (colidiu(paX, paY, pa.getWidth(), pa.getHeight(), dino.x, dino.y, dino.width, dino.height) && ataque) {
                pontos += 10;
                if (pontos % 100 == 0 && spownInimigos > 0) {
                    spownInimigos -= 100;
                }
                paX = posicaoX;
                ataque = false;
                iter.remove();
                
             // Colisão com a nave 
            } else if (colidiu(posicaoX, posicaoY, carro.getWidth(), carro.getHeight(), dino.x, dino.y, dino.width, dino.height) && !gameover) {
                --vidas;
                if (vidas < 0) {
                    gameover = true;
                }

                pontos -= 30;
                iter.remove();
            }

            if (dino.x + tDino.getWidth() < 0) {
                iter.remove();
            }
        }
    }   

    private boolean colidiu(float x1, float y1, float larg1, float alt1, float x2, float y2, float larg2, float alt2){
        if (x1 + larg1 > x2 && x1 < x2 + larg2 && y1 + alt1 > y2 && y1 < y2 + alt2) {
            return true;
        }
        return false;
    }   
    
}