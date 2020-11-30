package wechat.mbg.service;

import wechat.mbg.entity.ScriptThemeLibrary;
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
public interface ScriptThemeLibraryService extends IService<ScriptThemeLibrary> {
    /**
     * 获取所有的剧本剧情
     * @return
     */
    List<ScriptThemeLibrary> getAll();
}
