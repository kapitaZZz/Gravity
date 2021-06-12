package com.example.gravity.classes;

import com.example.my_framework.CoreFW;
import com.example.my_framework.GraphicsFW;
import com.example.gravity.utilits.UtilResource;

import java.util.ArrayList;

public class LoaderAssets {
    public LoaderAssets(CoreFW coreFW, GraphicsFW graphicsFW) {
        loadTexture(graphicsFW);
        loadSpritePlayer(graphicsFW);
        loadSpriteEnemy(graphicsFW);
        loadOther(graphicsFW);
        loadAudio(coreFW);
    }

    private void loadAudio(CoreFW coreFW) {
        UtilResource.gameMusic = coreFW.getAudioFW().newMusic("music.mp3");
    }

    private void loadOther(GraphicsFW graphicsFW) {
        UtilResource.shieldHitEnemy = graphicsFW.newSprite(UtilResource.textureAtlas,
                0, 128, 64, 64);
    }

    private void loadSpriteEnemy(GraphicsFW graphicsFW) {
        UtilResource.spriteEnemy = new ArrayList<>();

        UtilResource.spriteEnemy.add(graphicsFW.newSprite(UtilResource.textureAtlas, 256, 0,
                64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.newSprite(UtilResource.textureAtlas, 320, 0,
                64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.newSprite(UtilResource.textureAtlas, 384, 0,
                64, 64));
        UtilResource.spriteEnemy.add(graphicsFW.newSprite(UtilResource.textureAtlas, 448, 0,
                64, 64));
    }

    private void loadSpritePlayer(GraphicsFW graphicsFW) {
        UtilResource.spritePlayer = new ArrayList<>();
        UtilResource.spritePlayerBoost = new ArrayList<>();
        UtilResource.spriteExplosionPlayer = new ArrayList<>();

        UtilResource.spriteExplosionPlayer.add(graphicsFW.newSprite(UtilResource.textureAtlas,
                256, 256,
                64, 64));
        UtilResource.spriteExplosionPlayer.add(graphicsFW.newSprite(UtilResource.textureAtlas,
                320, 256,
                64, 64));
        UtilResource.spriteExplosionPlayer.add(graphicsFW.newSprite(UtilResource.textureAtlas,
                384, 256,
                64, 64));
        UtilResource.spriteExplosionPlayer.add(graphicsFW.newSprite(UtilResource.textureAtlas,
                448, 256,
                64, 64));

        UtilResource.spritePlayer.add(graphicsFW.newSprite(UtilResource.textureAtlas, 0, 0,
                64, 64));
        UtilResource.spritePlayer.add(graphicsFW.newSprite(UtilResource.textureAtlas, 64, 0,
                64, 64));
        UtilResource.spritePlayer.add(graphicsFW.newSprite(UtilResource.textureAtlas, 128, 0,
                64, 64));
        UtilResource.spritePlayer.add(graphicsFW.newSprite(UtilResource.textureAtlas, 192, 0,
                64, 64));

        UtilResource.spritePlayerBoost.add(graphicsFW.newSprite(UtilResource.textureAtlas, 0, 64,
                64, 64));
        UtilResource.spritePlayerBoost.add(graphicsFW.newSprite(UtilResource.textureAtlas, 64, 64,
                64, 64));
        UtilResource.spritePlayerBoost.add(graphicsFW.newSprite(UtilResource.textureAtlas, 128, 64,
                64, 64));
        UtilResource.spritePlayerBoost.add(graphicsFW.newSprite(UtilResource.textureAtlas, 192, 64,
                64, 64));

    }

    private void loadTexture(GraphicsFW graphicsFW) {
        UtilResource.textureAtlas = graphicsFW.newTexture("texture_atlas.png");
    }
}
