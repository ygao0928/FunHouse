package wechat.mbg.service;

import wechat.mbg.entity.ScriptBackgroundLibrary;
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
public interface ScriptBackgroundLibraryService extends IService<ScriptBackgroundLibrary> {

    List<ScriptBackgroundLibrary> getAll();

}
