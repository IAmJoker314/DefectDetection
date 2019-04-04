package com.wxiip.service;

import com.wxiip.domain.ImageVision;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:HuangHua
 * @Descirption:
 * @Date: Created by huanghua on 2018/10/23.
 * @Modified By:
 */
@Mapper
@Repository
public interface ImageVisionService {

    /**获取**/
    List<ImageVision> getImageVisionList(ImageVision imageVision);
}
