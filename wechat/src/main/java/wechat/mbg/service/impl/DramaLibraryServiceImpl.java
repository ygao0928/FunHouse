package wechat.mbg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import wechat.mbg.entity.DramaLibrary;
import wechat.mbg.mapper.DramaLibraryMapper;
import wechat.mbg.service.DramaLibraryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
    public List<DramaLibrary> getAll() {
        return dramaLibraryMapper.selectList(null);
    }
@Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean addDrama(DramaLibrary dramaLibrary) {
    dramaLibrary.setCreationDate(new Date());
    int i = dramaLibraryMapper.insert(dramaLibrary);
    return i==0?false:true;
    }
}
