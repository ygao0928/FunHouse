package wechat.mbg.mapper;

import org.springframework.stereotype.Repository;
import wechat.config.vo.DramaLibraryVO;
import wechat.mbg.entity.DramaLibrary;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Kevin
 * @since 2020-11-25
 */
@Repository
public interface DramaLibraryMapper extends BaseMapper<DramaLibrary> {

    List<DramaLibraryVO> getAll(String keyword);

}
