package wechat.mbg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import wechat.mbg.entity.ScriptThemeLibrary;
import wechat.mbg.mapper.ScriptThemeLibraryMapper;
import wechat.mbg.service.ScriptThemeLibraryService;
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
public class ScriptThemeLibraryServiceImpl extends ServiceImpl<ScriptThemeLibraryMapper, ScriptThemeLibrary> implements ScriptThemeLibraryService {
@Autowired
private ScriptThemeLibraryMapper scriptThemeLibraryMapper;
    @Override
    public List<ScriptThemeLibrary> getAll() {
        return scriptThemeLibraryMapper.selectList(null);
    }
}
