package wechat.mbg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import wechat.mbg.entity.ScriptDifficultyLibrary;
import wechat.mbg.mapper.ScriptDifficultyLibraryMapper;
import wechat.mbg.service.ScriptDifficultyLibraryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Kevin
 * @since 2020-11-28
 */
@Service
public class ScriptDifficultyLibraryServiceImpl extends ServiceImpl<ScriptDifficultyLibraryMapper, ScriptDifficultyLibrary> implements ScriptDifficultyLibraryService {
@Autowired
private ScriptDifficultyLibraryMapper scriptDifficultyLibraryMapper;
    @Override
    public List<ScriptDifficultyLibrary> getAll() {
        return scriptDifficultyLibraryMapper.selectList(null);
    }
}
