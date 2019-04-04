package com.wxiip.service;

import com.wxiip.domain.ImageDto;

import java.util.List;

/**
 * @Author:HuangHua
 * @Descirption:
 * @Date: Created by huanghua on 2018/10/24.
 * @Modified By:
 */
public interface ImageService {

    List<ImageDto> query(ImageDto image);

    /**统计总数**/
    int count(ImageDto imageDto);
}
