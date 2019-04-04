package com.wxiip.domain;

import java.io.Serializable;

/**
 * @Author:HuangHua
 * @Descirption:
 * @Date: Created by huanghua on 2018/10/23.
 * @Modified By:
 */
public class ImageVision implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private String imgName;

    private float accuracy;

    private float topLeftX;

    private float topLeftY;

    private float botRightX;

    private float BotRightY;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public float getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(float accuracy) {
        this.accuracy = accuracy;
    }

    public float getTopLeftX() {
        return topLeftX;
    }

    public void setTopLeftX(float topLeftX) {
        this.topLeftX = topLeftX;
    }

    public float getTopLeftY() {
        return topLeftY;
    }

    public void setTopLeftY(float topLeftY) {
        this.topLeftY = topLeftY;
    }

    public float getBotRightX() {
        return botRightX;
    }

    public void setBotRightX(float botRightX) {
        this.botRightX = botRightX;
    }

    public float getBotRightY() {
        return BotRightY;
    }

    public void setBotRightY(float botRightY) {
        BotRightY = botRightY;
    }
}
