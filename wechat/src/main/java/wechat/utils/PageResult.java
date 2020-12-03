package wechat.utils;

import lombok.Data;

import java.util.List;

/**
 * @Author sean.Wang
 * @Date 2020/3/19 11:22
 * @Version 1.0
 **/
@Data
public class PageResult {
    /**
     * 当前页码
     */
    private int pageNum;
    /**
     * 每页数量
     */
    private int pageSize;
    /**
     * 记录总数
     */
    private long totalSize;
    /**
     * 页码总数
     */
    private int totalPages;
    /**
     * 数据模型
     */
    private List<?> content;

    /**
     * 待接收的个数
     */
    private Integer count;
    /**
     * 待接收的电话维保转过来的数据
     */
    private List<?> phoneMainList;



}
