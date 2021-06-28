package com.example.gravity.tasks;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Build;

import androidx.core.content.res.ResourcesCompat;

import com.example.gravity.R;
import com.example.gravity.interf.TaskCompleteListener;
import com.example.gravity.scenes.LoaderResourceScene;
import com.example.gravity.utilits.SettingsGame;
import com.example.gravity.utilits.UtilResource;
import com.example.my_framework.CoreFW;
import com.example.my_framework.GraphicsFW;

import java.util.ArrayList;

public class LoaderTask extends AsyncTask<Void, Integer, Void> {

    @SuppressLint("StaticFieldLeak")
    private final CoreFW coreFW;
    private final TaskCompleteListener taskCompleteListener;

    public LoaderTask(CoreFW coreFW, TaskCompleteListener taskCompleteListener) {
        this.coreFW = coreFW;
        this.taskCompleteListener = taskCompleteListener;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        LoaderResourceScene.setProgressLoader(values[0]);
    }

    @Override
    protected Void doInBackground(Void... voids) {
        loaderAssets();
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        taskCompleteListener.onComplete();
    }

    private void loaderAssets() {
        loadTexture(coreFW.getGraphicsFW());
        publishProgress(100);
        loadSpritePlayer(coreFW.getGraphicsFW());
        publishProgress(300);
        loadSpriteEnemy(coreFW.getGraphicsFW());
        publishProgress(500);
        loadOther(coreFW.getGraphicsFW());
        publishProgress(600);
        loadAudio(coreFW);
        loadSpritePlayerShieldsOn(coreFW.getGraphicsFW());
        publishProgress(700);
        loadGifts(coreFW.getGraphicsFW());
        publishProgress(800);
    }

    private void loadGifts(GraphicsFW graphicsFW) {
        UtilResource.spriteProtector = new ArrayList<>();

        UtilResource.spriteProtector.add(graphicsFW.newSprite(UtilResource.textureAtlas,
                256, 192, 32, 32));
        UtilResource.spriteProtector.add(graphicsFW.newSprite(UtilResource.textureAtlas,
                288, 192, 32, 32));
        UtilResource.spriteProtector.add(graphicsFW.newSprite(UtilResource.textureAtlas,
                320, 192, 32, 32));
        UtilResource.spriteProtector.add(graphicsFW.newSprite(UtilResource.textureAtlas,
                352, 192, 32, 32));
    }

    private void loadSpritePlayerShieldsOn(GraphicsFW graphicsFW) {
        UtilResource.spritePlayerShieldsOn = new ArrayList<>();
        UtilResource.spritePlayerShieldsOnBoost = new ArrayList<>();

        UtilResource.spritePlayerShieldsOn.add(graphicsFW.newSprite(UtilResource.textureAtlas,
                0, 128, 64, 64));
        UtilResource.spritePlayerShieldsOn.add(graphicsFW.newSprite(UtilResource.textureAtlas,
                64, 128, 64, 64));
        UtilResource.spritePlayerShieldsOn.add(graphicsFW.newSprite(UtilResource.textureAtlas,
                128, 128, 64, 64));
        UtilResource.spritePlayerShieldsOn.add(graphicsFW.newSprite(UtilResource.textureAtlas,
                192, 128, 64, 64));

        UtilResource.spritePlayerShieldsOnBoost.add(graphicsFW.newSprite(UtilResource.textureAtlas,
                0, 192, 64, 64));
        UtilResource.spritePlayerShieldsOnBoost.add(graphicsFW.newSprite(UtilResource.textureAtlas,
                64, 192, 64, 64));
        UtilResource.spritePlayerShieldsOnBoost.add(graphicsFW.newSprite(UtilResource.textureAtlas,
                128, 192, 64, 64));
        UtilResource.spritePlayerShieldsOnBoost.add(graphicsFW.newSprite(UtilResource.textureAtlas,
                192, 192, 64, 64));

    }

    private void loadAudio(CoreFW coreFW) {
        UtilResource.gameMusic = coreFW.getAudioFW().newMusic("music.mp3");
        UtilResource.hit = coreFW.getAudioFW().newSound("hit.ogg");
        UtilResource.explode = coreFW.getAudioFW().newSound("explode.ogg");
        UtilResource.touch = coreFW.getAudioFW().newSound("touch.ogg");
    }

    private void loadOther(GraphicsFW graphicsFW) {
        UtilResource.shieldHitEnemy = graphicsFW.newSprite(UtilResource.textureAtlas,
                0, 128, 64, 64);
        SettingsGame.loadSettings(coreFW);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            UtilResource.mainMenuFont = coreFW.getResources().getFont(R.font.comfortaa);
        } else {
            UtilResource.mainMenuFont = ResourcesCompat.getFont(coreFW.getApplicationContext(), R.font.comfortaa);
        }
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
