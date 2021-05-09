package wechat.mbg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import wechat.mbg.entity.DramaLibrary;
import wechat.mbg.entity.DramaPlayedLog;
import wechat.mbg.mapper.DramaLibraryMapper;
import wechat.mbg.mapper.DramaPlayedLogMapper;
import wechat.mbg.service.DramaPlayedLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Kevin
 * @since 2020-12-16
 */
@Service
public class DramaPlayedLogServiceImpl extends ServiceImpl<DramaPlayedLogMapper, DramaPlayedLog> implements DramaPlayedLogService {
    @Autowired
    private DramaPlayedLogMapper playedLogMapper;
    @Autowired
    private DramaLibraryMapper dramaLibraryMapper;

    @Override
    public List<DramaPlayedLog> getOwnPlayed(String openId) {
        QueryWrapper<DramaPlayedLog> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(DramaPlayedLog::getOpenid, openId);
        List<DramaPlayedLog> playedLogs = playedLogMapper.selectList(wrapper);
        return playedLogs;
    }

    @Override
    public Boolean addOwnPlayed(String openId, List<Integer> dramaIds) {
        if (dramaIds.size()>0){
            for (int i = 0; i < dramaIds.size(); i++) {
                DramaPlayedLog log = new DramaPlayedLog();
                log.setDramaId(dramaIds.get(i));
                log.setCreateTime(new Date());
                log.setOpenid(openId);
                DramaLibrary dramaLibrary = dramaLibraryMapper.selectById(dramaIds.get(i));
                log.setDramaName(dramaLibrary.getDramaName());
                int i2 = playedLogMapper.insert(log);
                if (i2 == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
