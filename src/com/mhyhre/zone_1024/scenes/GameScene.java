/*
 * Copyright (C) 2013-2014 Andrey Tulyakov
 * @mail: mhyhre@gmail.com
 */

package com.mhyhre.zone_1024.scenes;

import org.andengine.entity.scene.background.Background;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.font.IFont;

import android.util.Log;

import com.mhyhre.zone_1024.MainActivity;
import com.mhyhre.zone_1024.R;
import com.mhyhre.zone_1024.touch.TouchMotionDetector;
import com.mhyhre.zone_1024.touch.TouchMotionsHunter;
import com.mhyhre.zone_1024.touch.TouchDirections;

public class GameScene extends SimpleScene implements TouchMotionsHunter {

    private Background background;
    private Text textEntityScores;
    private Sprite spriteMenu;
    
    private TouchMotionDetector motionDetector;;
    
    
    public GameScene() {
        
        background = new Background(0.2f, 0.6f, 0.7f);
        setBackground(background);
        setBackgroundEnabled(true);   
        
        motionDetector = new TouchMotionDetector(this);
        
        
        // Creating sprites
        spriteMenu = new Sprite(0, 0, MainActivity.resources.getTextureRegion("Button1"), MainActivity.Me.getVertexBufferObjectManager()) {
            @Override
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
                if (pSceneTouchEvent.getAction() == TouchEvent.ACTION_DOWN) {

                    Log.i(MainActivity.DEBUG_ID, "Pressed menu icon");
                    MainActivity.vibrate(30);
                }
                return true;
            }
        };
        attachChild(spriteMenu);
        registerTouchArea(spriteMenu);
        
        
        String textScores = MainActivity.Me.getString(R.string.scores);
        
        // Text
        final IFont usedFont = MainActivity.resources.getFont("Furore");      
        textEntityScores = new Text(0, 0, usedFont, textScores, MainActivity.Me.getVertexBufferObjectManager());
        attachChild(textEntityScores);
    }
    
    
    @Override
    public boolean onSceneTouchEvent(final TouchEvent pSceneTouchEvent) {
        
        if(pSceneTouchEvent.isActionDown()) {
            Log.i(MainActivity.DEBUG_ID, "onSceneTouchEvent: Touched!");
        }
        
        motionDetector.onTouchEvent(pSceneTouchEvent);
        return super.onSceneTouchEvent(pSceneTouchEvent);
    }

    @Override
    protected void onManagedUpdate(float pSecondsElapsed) {

        super.onManagedUpdate(pSecondsElapsed);
    }


    @Override
    public void onDetectedMotionEvent(TouchDirections move) {
        
        switch(move) {
        case DOWN:
            Log.i(MainActivity.DEBUG_ID, "onDetectedMotionEvent: DOWN!");
            break;
            
        case LEFT:
            Log.i(MainActivity.DEBUG_ID, "onDetectedMotionEvent: LEFT!");
            break;
            
        case RIGHT:
            Log.i(MainActivity.DEBUG_ID, "onDetectedMotionEvent: RIGHT!");
            break;
            
        case UP:
            Log.i(MainActivity.DEBUG_ID, "onDetectedMotionEvent: UP!");
            break;
            
        default:
            break;
        }
    }

}