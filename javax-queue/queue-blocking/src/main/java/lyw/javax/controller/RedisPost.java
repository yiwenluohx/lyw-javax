package lyw.javax.controller;

import lyw.javax.utils.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author: luohx
 * @Description: 初始redis数据
 * @Date: 2021/1/18 14:45
 */
@Component
public class RedisPost {

    @Autowired
    private RedisRepository redisRepository;

    @PostConstruct
    public void initData() {
        redisRepository.set("goods_1", "128");
        //表中获取库存，填充到redis
//        List<DictModel> dictItems = sysDictService.queryDictItemsByCode(configCode);
//        if (dictItems != null && dictItems.size() >= 4) {
//            baseMap = JSON.parseObject(dictItems.get(0).getValue(), HashMap.class);
//            payMap = JSON.parseObject(dictItems.get(1).getValue(), HashMap.class);
//            collectMap = JSON.parseObject(dictItems.get(2).getValue(), HashMap.class);
//            symbolMap = JSON.parseObject(dictItems.get(3).getValue(), HashMap.class);
//        }
    }
}
