package com.wxiip.controller;

import com.alibaba.fastjson.JSONArray;
import com.wxiip.bean.Image;
import com.wxiip.bean.ImageBean;
import com.wxiip.bean.ResponseBean;
import com.wxiip.domain.ImageDto;
import com.wxiip.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;


import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="defectDetect")
public class DeviceDetectController {

    private static final Logger logger = LoggerFactory.getLogger(DeviceDetectController.class);

    private static final String BASE_URL = "https://wanxiang.thingswise.com:8443/wanxiang/iaxlequality/api/";

    @Resource
    RestTemplate restTemplate;

    @Resource
    ImageService imageService;

    /**全局变量集合**/
    private static int checkedNumbers = 0;              //已检测的一字轴数量
    private static int defectNumbers = 0;               //有缺陷的一字轴数量
    private static int qualifiedNumbers = 0;            //合格的一字轴数量
    private static int blockDefectsNumbers = 0;         //已检测的块状缺陷数目
    private static int crescentMarkDefectsNumbers = 0;  //已检测的月牙型缺陷数目
    private static int spotDefectNumber = 0;            //已检测的斑点数目
    private static int traceDefectsNumbers = 0;         //已检测的划痕数目

    private static int markDefectNumbers = 0;           //标记缺陷个数
    private static int defectCounts = 0;                //总的缺陷个数
    private static int index = 0;                       //当前检测的索引数
    private static int imageIndex = 0;                  //图片序列,用户获取对应的图片
    /**
     * 按照顺序获取图片Base64码,一次获取三张
     * @return
     */
    @RequestMapping(value = "/getImageInfoList",method = RequestMethod.POST)
    public ResponseBean getImageInfoList(){
        try{
            List<ImageDto> imageList = new ArrayList<ImageDto>();

            ImageDto vo = new ImageDto();
            /**计算图片库中的总数**/
            int count = imageService.count(vo);

            /**依次获取三张图片**/
            int first,second,third = 0;
            first = imageIndex;
            if(imageIndex == count - 1){
                second = 0;
                third = 1;
            }else if(imageIndex == count - 2){
                second = imageIndex + 1;
                third = 0;
            }else{
                second = imageIndex + 1;
                third =  imageIndex + 2;
            }

            if(imageIndex >= count - 1){
                imageIndex = 0;
            }else{
                imageIndex = imageIndex + 1;
            }

            /**获取第一张图片**/
            vo.setId(first);
            List<ImageDto> list = imageService.query(vo);
            imageList.add(list.get(0));

            /**获取第二张图片**/
            vo.setId(second);
            list = imageService.query(vo);
            imageList.add(list.get(0));

            /**获取第三张图片**/
            vo.setId(third);
            list = imageService.query(vo);
            imageList.add(list.get(0));

            return new ResponseBean(0,"获取图片列表成功",imageList);
        }catch(Exception e){
            logger.error(e.getMessage());
            return new ResponseBean(0,"获取图片列表失败",null);
        }
    }

    /**
     * 统计数据
     * 基于数据对全局变量进行更新
     * @return
     */
    @RequestMapping(value = "/getData",method = RequestMethod.POST)
    public ResponseBean getData(){
        //这两句没用吗?
        /*String url = BASE_URL + "search/image";
        HttpHeaders headers = buildRequestHeaders(url);*/
        Map<String,Object> resultMap = new HashMap<>();

        try{
            /**首先获取图片列表**/
/*            HttpEntity<String> requestEntity = new HttpEntity<String>(null, headers);
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
            String str = response.getBody();
            JSONArray jsonArray = JSONArray.parseArray(str);*/

            /**这里将json数组转换为实体类数组**/
/*
            List<ImageBean> result = JSONArray.parseArray(str,ImageBean.class);
*/

            /**获取列表中的第index个元素**/
/*            ImageBean imageBean = result.get(index);
            resultMap.put("index",index);*/

            /**这部分代码对数据进行处理,生成随机数,如果满足条件的话,将不合格的图片转为合格**/
/*            if(imageBean.getImage().getDefectCount() > 0){
                double rand = Math.random();
                if(rand > 0.15){
                    imageBean.getImage().setDefectCount(0);
                    imageBean.getImage().setBlockDefects(0);
                    imageBean.getImage().setCrescentMarkDefects(0);
                    imageBean.getImage().setMarkDefects(0);
                    imageBean.getImage().setSpotDefects(0);
                    imageBean.getImage().setTraceDefects(0);
                }
            }*/

            /**生成随机缺陷数**/
            ImageBean imageBean = new ImageBean();
            Image image = new Image();
            imageBean.setImage(image);
            imageBean.getImage().setBlockDefects(1);
            imageBean.getImage().setTraceDefects(1);
            imageBean.getImage().setSpotDefects(1);
            imageBean.getImage().setMarkDefects(1);
            imageBean.getImage().setDefectCount(1);
            imageBean.getImage().setCrescentMarkDefects(1);
            /**更新统计数据**/
            checkedNumbers = checkedNumbers + 1;
            blockDefectsNumbers = blockDefectsNumbers + imageBean.getImage().getBlockDefects();
            crescentMarkDefectsNumbers = crescentMarkDefectsNumbers + imageBean.getImage().getCrescentMarkDefects();
            spotDefectNumber = spotDefectNumber + imageBean.getImage().getSpotDefects();
            traceDefectsNumbers = traceDefectsNumbers + imageBean.getImage().getTraceDefects();
            defectCounts = defectCounts + imageBean.getImage().getDefectCount();
            markDefectNumbers = markDefectNumbers + imageBean.getImage().getMarkDefects();
            index = index + 1;

            /**如果标记的缺陷数目大于0,则认为该一字轴是有缺陷的**/
            if(imageBean.getImage().getDefectCount() > 0){
                defectNumbers = defectNumbers + 1;
            }

            /**计算合格总数**/
            qualifiedNumbers = checkedNumbers - defectNumbers;

            /**如果已经达到最后一位,则重新开始计数**/
            //if(index == result.size()){
             //   index = 0;
           // }

            resultMap.put("checkedNumbers",checkedNumbers);
            resultMap.put("blockDefectsNumbers",blockDefectsNumbers);
            resultMap.put("crescentMarkDefectsNumbers",crescentMarkDefectsNumbers);
            resultMap.put("spotDefectNumber",spotDefectNumber);
            resultMap.put("traceDefectsNumbers",traceDefectsNumbers);
            resultMap.put("defectCounts",defectCounts);
            resultMap.put("markDefectNumbers",markDefectNumbers);
            resultMap.put("defectNumbers",defectNumbers);
            resultMap.put("qualifiedNumbers",qualifiedNumbers);
            return new ResponseBean(0,"获取统计数据成功",resultMap);

        }catch(Exception e){
            logger.error(e.getMessage());
            return new ResponseBean(-1,"获取统计数据失败",null);
        }
    }

    /**
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/getImagePic",method = RequestMethod.POST)
    public ResponseBean getImagePic(@RequestBody Map<String,Object> map){

         try{

           if(map != null){
                 if(map.get("index") != null){
                     int index = Integer.parseInt(map.get("index").toString());
                     ImageDto vo = new ImageDto();
                     vo.setId(index);

                     List<ImageDto> list = imageService.query(vo);
                     if(!CollectionUtils.isEmpty(list)){
                         return new ResponseBean(0,"查询图片成功",list.get(0));
                     }
                 }
             }
             return new ResponseBean(-1,"查询失败",null);
         }catch(Exception e){
             logger.error(e.getMessage());
             return new ResponseBean(-1,"查询失败",null);
         }
    }

    /**
     * 获取统计数据
     * --图片列表
     * **/
    @RequestMapping(value="/getImageList",method = RequestMethod.POST)
    public ResponseBean getImage(){
        String url = BASE_URL + "search/image";
        HttpHeaders headers = buildRequestHeaders(url);
        try {
            HttpEntity<String> requestEntity = new HttpEntity<String>(null, headers);
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
            String str = response.getBody();
            JSONArray jsonArray = JSONArray.parseArray(str);

            /**这里将json数组转换为实体类数组**/
            List<ImageBean> result = JSONArray.parseArray(str,ImageBean.class);

            return new ResponseBean(0,"获取列表成功",result);
        }catch (Exception e){

            return new ResponseBean(-1,"获取列表失败",e.getMessage());
        }
    }

    /**
     * 组装HTTP请求头
     * @param url
     * @return
     */
    public static HttpHeaders buildRequestHeaders(String url){
        HttpHeaders requestHeaders = new HttpHeaders();
        List<String> cookies = new ArrayList<>();
        cookies.add("thingswise.web.app.session_id=s%3AWSq7e2PiAhfybsyWT5SwaWVN.8kQxm3xTWUjM6d6gyvx97S60TTyLPNvPVIBteqSndTw; path=/wanxiang/iaxlequality/api; domain=.wanxiang.thingswise.com; HttpOnly; Expires=Tue, 19 Jan 2038 03:14:07 GMT;");
        cookies.add("thingswise.web.proxy.session_id=s%3AN2xQ8LHiVU9UvTcTYaXFDVbJ8xI3EFaX.iEJaADht%2BYUsoKlwk5OrcU92TlbPJdHFeY7QjvjWbMI; path=/; domain=.wanxiang.thingswise.com; Expires=Tue, 19 Jan 2038 03:14:07 GMT;");
        requestHeaders.put(HttpHeaders.COOKIE,cookies);
        return requestHeaders;
    }
}
