package wechat.mbg.service;

import wechat.mbg.entity.ScriptFormLibrary;
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
public interface ScriptFormLibraryService extends IService<ScriptFormLibrary> {
    /**
     * 获取所有的剧本类型
     * @return
     */
    List<ScriptFormLibrary> getAll();
}
