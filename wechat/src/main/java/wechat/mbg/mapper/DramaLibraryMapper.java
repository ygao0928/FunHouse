package wechat.mbg.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import wechat.mbg.entity.DramaLibrary;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import wechat.vo.DramaLibraryVO;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Kevin
 * @since 2020-12-14
 */
@Repository
public interface DramaLibraryMapper extends BaseMapper<DramaLibrary> {

    List<DramaLibraryVO> getAll(@Param("key") String key, @Param("fromId") Integer fromId, @Param("diffId") Integer diffId, @Param("numberRe") Integer numberRe, @Param("backId") Integer backId, @Param("typeId") Integer typeId);

    DramaLibraryVO getDramaDetailById(@Param("id") Integer id);
}
