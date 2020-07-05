package com.ivona.picturescombinator;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class PictureManager {
    private Bitmap mainPicture;
    private int WIDTH = 100;
    private int HEIGHT = 100;
    private Canvas canvas;

    public PictureManager(){
        initBackground();
    }

    private void initBackground() {
        mainPicture = Bitmap.createBitmap(WIDTH, HEIGHT, Bitmap.Config.ALPHA_8);
        mainPicture.eraseColor(Color.alpha(Color.TRANSPARENT));
        canvas = new Canvas(mainPicture);
    }

    public void addPictureTo(Bitmap picture, int positionX, int positionY) {
        canvas.drawBitmap(picture, positionX, positionY, null);
    }

    public void savePicture(String path){
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(path);
            mainPicture.compress(Bitmap.CompressFormat.PNG,80, outputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Bitmap getMainPicture(){
        return mainPicture;
    }

}
