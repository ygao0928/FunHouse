package wechat.mbg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import wechat.mbg.entity.ScriptBackgroundLibrary;
import wechat.mbg.mapper.ScriptBackgroundLibraryMapper;
import wechat.mbg.service.ScriptBackgroundLibraryService;
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
public class ScriptBackgroundLibraryServiceImpl extends ServiceImpl<ScriptBackgroundLibraryMapper, ScriptBackgroundLibrary> implements ScriptBackgroundLibraryService {
    @Autowired
    private ScriptBackgroundLibraryMapper scriptBackgroundLibraryMapper;

    /**
     * 获取所有的剧本背景数据
     *
     * @return
     */
    @Override
    public List<ScriptBackgroundLibrary> getAll() {
        return scriptBackgroundLibraryMapper.selectList(null);
    }
}
