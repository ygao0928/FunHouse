package wechat.mbg.service;
import wechat.mbg.entity.DramaLibrary;
import com.baomidou.mybatisplus.extension.service.IService;
import  wechat.vo.DramaLibraryVO;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Kevin
 * @since 2020-11-25
 */
public interface DramaLibraryService extends IService<DramaLibrary> {

    List<DramaLibraryVO> getAll(String key);

    Boolean addDrama(DramaLibrary dramaLibrary);
}