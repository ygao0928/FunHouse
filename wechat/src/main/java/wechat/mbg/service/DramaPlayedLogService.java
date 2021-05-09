package wechat.mbg.service;

import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.service.IService;
import wechat.mbg.entity.DramaPlayedLog;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Kevin
 * @since 2020-12-16
 */
public interface DramaPlayedLogService extends IService<DramaPlayedLog> {
    /**
     * 获取
     * @param openId
     * @return
     */
    List<DramaPlayedLog> getOwnPlayed(String openId);

    /**
     * 新增
     * @param openId
     * @param dramaId
     * @return
     */
    @Transactional
    Boolean addOwnPlayed(String openId, List<Integer> dramaId);
}
