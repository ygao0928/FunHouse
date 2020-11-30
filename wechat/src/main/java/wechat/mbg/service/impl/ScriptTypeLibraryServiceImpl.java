package wechat.mbg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import wechat.mbg.entity.ScriptTypeLibrary;
import wechat.mbg.mapper.ScriptTypeLibraryMapper;
import wechat.mbg.service.ScriptTypeLibraryService;
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
public class ScriptTypeLibraryServiceImpl extends ServiceImpl<ScriptTypeLibraryMapper, ScriptTypeLibrary> implements ScriptTypeLibraryService {
    @Autowired
    private ScriptTypeLibraryMapper scriptTypeLibraryMapper;

    @Override
    public List<ScriptTypeLibrary> getAll() {
        return scriptTypeLibraryMapper.selectList(null);
    }
}
