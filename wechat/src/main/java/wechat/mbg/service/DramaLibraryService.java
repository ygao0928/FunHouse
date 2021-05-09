package wechat.mbg.service;

import org.springframework.transaction.annotation.Transactional;
import wechat.mbg.entity.DramaLibrary;
import com.baomidou.mybatisplus.extension.service.IService;
import wechat.vo.DramaLibraryVO;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Kevin
 * @since 2020-12-14
 */
public interface DramaLibraryService extends IService<DramaLibrary> {
    /**
     * 查询所有
     *
     * @param key
     * @param fromId
     * @param diffId
     * @param numberRe
     * @param backId
     * @param typeId
     * @return
     */
    List getAll(String key, Integer fromId, Integer diffId, Integer numberRe, Integer backId, Integer typeId);

    /**
     * 新增
     *
     * @param dramaLibrary
     * @return
     */
    Boolean addDrama(DramaLibrary dramaLibrary);

    /**
     * 查看详情
     *
     * @param id
     * @return
     */
    DramaLibrary getDramaDetailById(Integer id);

    /**
     * 更新剧本
     *
     * @param dramaLibrary
     * @return
     */
    @Transactional
    String updateDrama(DramaLibrary dramaLibrary);

    /**
     * 删除剧本
     * @param id
     * @return
     */
    String deleteDrama(Integer id);

    /**
     * 利用名字查询剧本
     * @param name
     * @return
     */
    List<DramaLibrary> getByName(String name);
}
