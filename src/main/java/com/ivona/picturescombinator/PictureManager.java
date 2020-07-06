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

    public void addPicture(Bitmap picture, int positionX, int positionY) {
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
    
    public void addPicture(Resources resources, int id, int positionX, int positionY){
        addPicture(BitmapFactory.decodeResource(resources, id), positionX, positionY);
    }

    public void addScaledPicture(Resources resources, int id, int positionX, int positionY, int width, int height){
        Bitmap image = BitmapFactory.decodeResource(resources, id);
        addPicture(Bitmap.createScaledBitmap(image, width, height, false), positionX, positionY);
    }

    public void addText(String text, int size, int color, int positionX, int positionY){
        paint.setColor(color);
        paint.setTextSize(size);
        canvas.drawText(text, positionX, positionY, paint);
    }

}
