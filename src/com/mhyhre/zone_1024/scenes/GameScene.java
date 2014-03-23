/*
 * Copyright (C) 2013-2014 Andrey Tulyakov
 * @mail: mhyhre@gmail.com
 */

package com.mhyhre.zone_1024.scenes;

import org.andengine.entity.scene.background.Background;
import org.andengine.entity.text.Text;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.font.IFont;
import com.mhyhre.zone_1024.MainActivity;
import com.mhyhre.zone_1024.game.logic.GameControllable;
import com.mhyhre.zone_1024.game.logic.GameManager;

public class GameScene extends SimpleScene {

    private Background background;
    private Text textEntityScores;
    private GameControllable gameManager;
    private GameField gameField;

    public GameScene(GameControllable gameManager) {

        this.gameManager = gameManager;

        background = new Background(0.0f, 0.0f, 0.0f);
        setBackground(background);
        setBackgroundEnabled(true);

        gameField = new GameField(gameManager.getGrid().getSize());
        attachChild(gameField);

        // Text
        final IFont font = MainActivity.resources.getFont("WhiteMono32");

        textEntityScores = new Text(0, 0, font, "", 32, MainActivity.Me.getVertexBufferObjectManager());
        textEntityScores.setPosition(MainActivity.getHalfWidth(), MainActivity.getHeight() - 40);
        attachChild(textEntityScores);
    }


    @Override
    protected void onManagedUpdate(float pSecondsElapsed) {

        textEntityScores.setText("Scores: " + GameManager.getInstance().getScore());
        gameField.update(gameManager.getGrid());
        super.onManagedUpdate(pSecondsElapsed);
    }

}