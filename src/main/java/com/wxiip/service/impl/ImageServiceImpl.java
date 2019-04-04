package com.wxiip.service.impl;

import com.wxiip.dao.ImageMapper;
import com.wxiip.domain.ImageDto;
import com.wxiip.service.ImageService;
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
public class ImageServiceImpl implements ImageService {

    @Resource
    ImageMapper imageMapper;

    @Override
    public List<ImageDto> query(ImageDto image) {
        return imageMapper.query(image);
    }

    @Override
    public int count(ImageDto imageDto) {
        return imageMapper.count(imageDto);
    }
}
