package wechat.mbg.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wechat.mbg.entity.DramaLibrary;
import wechat.mbg.entity.MemberInfo;
import wechat.mbg.mapper.DramaLibraryMapper;
import wechat.mbg.service.DramaLibraryService;
import wechat.vo.DramaLibraryVO;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Kevin
 * @since 2020-11-25
 */
@Service
public class DramaLibraryServiceImpl extends ServiceImpl<DramaLibraryMapper, DramaLibrary> implements DramaLibraryService {
@Autowired
private DramaLibraryMapper dramaLibraryMapper;
    @Override
    public List<DramaLibraryVO> getAll(String key) {
        return dramaLibraryMapper.getAll(key);
    }
@Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean addDrama(DramaLibrary dramaLibrary) {
    dramaLibrary.setCreationDate(new Date());
    dramaLibrary.setDeleteFlage(0);
    int i = dramaLibraryMapper.insert(dramaLibrary);
    return i==0?false:true;
    }

    //获取前10充值排行剧本
    @Override
    public List<MemberInfo> showTopTenScripts() {
        return null;
    }
}
