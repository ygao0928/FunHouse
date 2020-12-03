package wechat.utils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import wechat.mbg.entity.User;

import java.util.List;

/**
 * @Author sean.Wang
 * @Date 2020/3/19 11:23
 * @Version 1.0
 **/
public class PageUtils {
    /**
     * 将分页信息封装到统一的接口
     *
     * @param pageInfo
     * @return
     */
    public static PageResult getPageResult(PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }

    /**
     * 将分页信息封装到统一的接口
     *
     * @param pageInfo
     * @return
     */
    public static PageResult getPageResult(PageInfo<?> pageInfo, Integer count, List<User> users) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        pageResult.setCount(count);
        pageResult.setPhoneMainList(users);
        return pageResult;
    }

    /**
     * 分页方法
     *
     * @param pageRequest
     * @return
     */
    public static Page<Object> getPage(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        return PageHelper.startPage(pageNum, pageSize);
    }
}
