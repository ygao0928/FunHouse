package wechat.mbg.service.impl;


import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wechat.mbg.entity.ConsumptionSettlement;
import wechat.mbg.entity.User;
import wechat.mbg.mapper.ConsumptionSettlementMapper;
import wechat.mbg.mapper.UserMapper;
import wechat.mbg.service.ConsumptionSettlementService;
import wechat.utils.PageRequest;
import wechat.utils.PageResult;
import wechat.utils.PageUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 杨阳
 * @since 2020-12-02
 */
@Service
public class ConsumptionSettlementServiceImpl implements ConsumptionSettlementService {

    @Autowired
    private ConsumptionSettlementMapper consumptionSettlementMapper;

    static final String formatStr="yyyy-MM-dd";

    static final SimpleDateFormat sdf=new SimpleDateFormat(formatStr);
    //根据用户openId查询积分和消费情况
    @Override
    public PageResult showIntegralAndConsumptionByIdInfo(PageRequest pageRequest, String openId) {
        PageUtils.getPage(pageRequest);
        List<ConsumptionSettlement> consumptionSettlements = consumptionSettlementMapper.showIntegralAndConsumptionById(openId);
        return PageUtils.getPageResult(new PageInfo<>(consumptionSettlements));
    }

    //列表显示消费记录
    @Override
    public PageResult showConsumptionInfo(PageRequest pageRequest) {
        PageUtils.getPage(pageRequest);
        String beginTime = sdf.format(pageRequest.getBeginTime());
        String endTime = sdf.format(pageRequest.getEndTime());

        List<ConsumptionSettlement> consumptionSettlementList = consumptionSettlementMapper.showConsumptionList(beginTime, endTime);
        return PageUtils.getPageResult(new PageInfo<>(consumptionSettlementList));
    }

}
