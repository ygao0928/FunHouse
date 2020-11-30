package wechat.mbg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import wechat.mbg.entity.ScriptFormLibrary;
import wechat.mbg.mapper.ScriptFormLibraryMapper;
import wechat.mbg.service.ScriptFormLibraryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Kevin
 * @since 2020-11-28
 */
@Service
public class ScriptFormLibraryServiceImpl extends ServiceImpl<ScriptFormLibraryMapper, ScriptFormLibrary> implements ScriptFormLibraryService {
    @Autowired
    private ScriptFormLibraryMapper scriptFormLibraryMapper;

    @Override
    public List<ScriptFormLibrary> getAll() {
        return scriptFormLibraryMapper.selectList(null);
    }
}
