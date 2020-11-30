package wechat.mbg.service;

import wechat.mbg.entity.ScriptTypeLibrary;
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
public interface ScriptTypeLibraryService extends IService<ScriptTypeLibrary> {
    /**
     * 获取所有的类型
     * @return
     */
    List<ScriptTypeLibrary> getAll();
}
