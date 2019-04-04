package com.wxiip.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * 图片类
 */
public class Image implements Serializable {

    private static final long serialVersionUID = 1L;

    private String objectkey;

    private int blockDefects;

    private int crescentMarkDefects;

    private int spotDefects;

    private int traceDefects;

    private int markDefects;

    private int defectCount;

    private int timestamp;

    private String productionLineId;

    private int imageHeight;

    private int imageWidth;

    @JSONField(name="objectkey")
    public String getObjectkey() {
        return objectkey;
    }

    @JSONField(name="objectkey")
    public void setObjectkey(String objectkey) {
        this.objectkey = objectkey;
    }

    @JSONField(name="block_defects")
    public int getBlockDefects() {
        return blockDefects;
    }

    @JSONField(name="block_defects")
    public void setBlockDefects(int blockDefects) {
        this.blockDefects = blockDefects;
    }

    @JSONField(name="crescent_mark_defects")
    public int getCrescentMarkDefects() {
        return crescentMarkDefects;
    }

    @JSONField(name="crescent_mark_defects")
    public void setCrescentMarkDefects(int crescentMarkDefects) {
        this.crescentMarkDefects = crescentMarkDefects;
    }

    @JSONField(name="spot_defects")
    public int getSpotDefects() {
        return spotDefects;
    }

    @JSONField(name="spot_defects")
    public void setSpotDefects(int spotDefects) {
        this.spotDefects = spotDefects;
    }

    @JSONField(name="trace_defects")
    public int getTraceDefects() {
        return traceDefects;
    }

    @JSONField(name="trace_defects")
    public void setTraceDefects(int traceDefects) {
        this.traceDefects = traceDefects;
    }

    @JSONField(name="mark_defects")
    public int getMarkDefects() {
        return markDefects;
    }

    @JSONField(name="mark_defects")
    public void setMarkDefects(int markDefects) {
        this.markDefects = markDefects;
    }

    @JSONField(name="defect_count")
    public int getDefectCount() {
        return defectCount;
    }

    @JSONField(name="defect_count")
    public void setDefectCount(int defectCount) {
        this.defectCount = defectCount;
    }

    @JSONField(name="timestamp")
    public int getTimestamp() {
        return timestamp;
    }

    @JSONField(name="timestamp")
    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    @JSONField(name="production_line_id")
    public String getProductionLineId() {
        return productionLineId;
    }

    @JSONField(name="production_line_id")
    public void setProductionLineId(String productionLineId) {
        this.productionLineId = productionLineId;
    }

    @JSONField(name="image_height")
    public int getImageHeight() {
        return imageHeight;
    }

    @JSONField(name="image_height")
    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    @JSONField(name="image_width")
    public int getImageWidth() {
        return imageWidth;
    }

    @JSONField(name="image_width")
    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }
}
