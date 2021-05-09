package wechat.service;

import org.springframework.transaction.annotation.Transactional;
import wechat.mbg.entity.ConsumptionLog;

import java.util.List;

/**
 * @author Kevin Gao
 * @version 1.0.0
 * @ClassName WXCommonService.java
 * @date 2020/12/13 16:35
 * @Description
 * @Content:
 */
public interface WXCommonService {
    /**
     * 用户买单操作
     * @param phone
     * @param money
     * @return
     */
    @Transactional
    String generatorConsumption(String phone, Integer money);

    /**
     * 获取所有的消费记录
     * @param openId
     * @return
     */
    List<ConsumptionLog> getAllConsumption(String openId);
}
