package wechat.utils;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author sean.Wang
 * @Date 2020/3/19 11:20
 * @Version 1.0
 **/
@Getter
@Setter
public class PageRequest {
    /**
     * 当前页码
     */
    private int pageNum;
    /**
     * 每页数量
     */
    private int pageSize;

    /**
     * 关键词查询
     */
    private String key;
    /**
     * 查询开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date beginTime;
    /**
     * 查询开结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date endTime;
    /**
     * 电话维保用到此type,1投诉,2售后,3服务,4市场分析,5服务站
     */
    private Integer type;

   //private String cunfangAddress;
}
