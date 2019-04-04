package com.wxiip.bean;

import java.io.Serializable;

/**
 * ImageBean实体
 * 包括id和Image
 */
public class ImageBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private Image image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
