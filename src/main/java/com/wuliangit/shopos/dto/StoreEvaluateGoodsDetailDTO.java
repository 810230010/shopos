package com.wuliangit.shopos.dto;

/**
 * @author boom
 * @description ${DESCRIPTION}
 * @create 2017-05-27 22:07
 **/
public class StoreEvaluateGoodsDetailDTO {

    private Integer evaluateGoodsId;

    private String content;

    private String images;

    public StoreEvaluateGoodsDetailDTO() {
    }

    public StoreEvaluateGoodsDetailDTO(Integer evaluateGoodsId, String content, String images) {
        this.evaluateGoodsId = evaluateGoodsId;
        this.content = content;
        this.images = images;
    }

    public Integer getEvaluateGoodsId() {
        return evaluateGoodsId;
    }

    public void setEvaluateGoodsId(Integer evaluateGoodsId) {
        this.evaluateGoodsId = evaluateGoodsId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
