package com.wxiip.service;

import com.wxiip.domain.ImageVision;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:HuangHua
 * @Descirption:
 * @Date: Created by huanghua on 2018/10/24.
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ImageVisionServiceTest {

    @Resource
    ImageVisionService imageVisionService;

    @Test
    public void Test(){
        ImageVision vo = new ImageVision();
        vo.setImgName("20180823-173057-0191_1");
        List<ImageVision> list = imageVisionService.getImageVisionList(vo);

        System.out.println(list);
        System.out.println(list);
    }
}
