package wechat.mbg.service;

import org.springframework.transaction.annotation.Transactional;
import wechat.mbg.entity.RechargeRecord;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Kevin
 * @since 2020-12-14
 */
public interface RechargeRecordService extends IService<RechargeRecord> {
    @Transactional
    Boolean insert(String phone, Integer money);

    /**
     * 后台生成消费记录
     * @param phone
     * @param money
     * @param payMethod
     * @return
     */
    @Transactional
    String generatorConsumption(String phone, Integer money, Integer payMethod, List<Integer> ids);

}
