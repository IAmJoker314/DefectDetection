package com.wxiip.service.impl;

import com.wxiip.dao.ImageVisionMapper;
import com.wxiip.domain.ImageVision;
import com.wxiip.service.ImageVisionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:HuangHua
 * @Descirption:
 * @Date: Created by huanghua on 2018/10/24.
 * @Modified By:
 */
@Service
public class ImageVisionServiceImpl implements ImageVisionService {

    @Resource
    ImageVisionMapper imageVisionMapper;

    @Override
    public List<ImageVision> getImageVisionList(ImageVision imageVision) {
        return imageVisionMapper.query(imageVision);
    }
}
