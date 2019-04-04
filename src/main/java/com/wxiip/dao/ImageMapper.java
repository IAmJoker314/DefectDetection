package com.wxiip.dao;

import com.wxiip.domain.ImageDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:HuangHua
 * @Descirption:
 * @Date: Created by huanghua on 2018/10/24.
 * @Modified By:
 */
@Mapper
@Repository
public interface ImageMapper {

    /**查询**/
    List<ImageDto> query(ImageDto image);

    /**获取总条数**/
    int count(ImageDto image);
}
