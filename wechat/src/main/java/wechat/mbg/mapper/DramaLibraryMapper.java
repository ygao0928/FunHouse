package wechat.mbg.mapper;

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
 * @since 2020-11-25
 */
@Repository
public interface DramaLibraryMapper extends BaseMapper<DramaLibrary> {


    List<DramaLibraryVO> getAll(String keyword);
    //获取前10充值排行剧本
    List<DramaLibrary> showTopTenScripts();
}
