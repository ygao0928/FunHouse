package wechat.mbg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import wechat.mbg.entity.DramaLibrary;
import wechat.mbg.mapper.DramaLibraryMapper;
import wechat.mbg.service.DramaLibraryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wechat.vo.DramaLibraryVO;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Kevin
 * @since 2020-12-14
 */
@Service
public class DramaLibraryServiceImpl extends ServiceImpl<DramaLibraryMapper, DramaLibrary> implements DramaLibraryService {
    @Autowired
    private DramaLibraryMapper dramaLibraryMapper;
    @Override
    public List getAll(String key,Integer fromId,Integer diffId,Integer numberRe,Integer backId,Integer typeId) {
        return dramaLibraryMapper.getAll(key,fromId,diffId,numberRe,backId,typeId);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean addDrama(DramaLibrary dramaLibrary) {
        dramaLibrary.setCreationDate(new Date());
        dramaLibrary.setDeleteFlage(0);
        int i = dramaLibraryMapper.insert(dramaLibrary);
        return i == 0 ? false : true;
    }

    @Override
    public DramaLibrary getDramaDetailById(Integer id) {
        return dramaLibraryMapper.selectById(id);

    }

    @Override
    public String updateDrama(DramaLibrary dramaLibrary) {
        int i = dramaLibraryMapper.update(dramaLibrary, new QueryWrapper<DramaLibrary>().lambda().eq(DramaLibrary::getId, dramaLibrary.getId()));
        if (i > 0) {
            return "操作成功";
        }
        return "操作失败";
    }

    @Override
    public String deleteDrama(Integer id) {
        int i = dramaLibraryMapper.deleteById(id);
        if (i > 0) {
            return "删除成功";
        }
        return "删除失败";
    }

    @Override
    public List<DramaLibrary> getByName(String name) {
        List<DramaLibrary> libraries = dramaLibraryMapper.selectList(new QueryWrapper<DramaLibrary>().lambda().like(DramaLibrary::getDramaName, name));
        return libraries;
    }

}
