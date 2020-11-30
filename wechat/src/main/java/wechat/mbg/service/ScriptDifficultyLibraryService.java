package wechat.mbg.service;

import wechat.mbg.entity.ScriptDifficultyLibrary;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Kevin
 * @since 2020-11-28
 */
public interface ScriptDifficultyLibraryService extends IService<ScriptDifficultyLibrary> {
    /**
     * 获取所有的剧本难度
     * @return
     */
    List<ScriptDifficultyLibrary> getAll();
}
