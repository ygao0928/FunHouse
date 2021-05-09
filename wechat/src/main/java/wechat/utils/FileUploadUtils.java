package wechat.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @Author Sean.Wang
 * @Date 2020/7/31 9:18
 * @Version 1.0
 **/
@Slf4j
public class FileUploadUtils {

    private static   String uploadPath="/workspace/funhouse/fileupload/file/";
    private  static String sonPath="/file/";
    //获取主机端口
    private static String post = "8080";
    //获取本机ip
    private static String host = "127.0.0.1/";
    //远程Ip
    /*private static String host = "112.80.41.34";*/


    /**
     *
     * @param file
     * @return
     */
    //文件上传
    public static Map<String,Object> upload(MultipartFile file) {
        Map<String,Object> result=new HashMap<>();
        try {
            if (file.isEmpty()) {
                result.put("statue","文件为空");
                return result;
            }
            //获取文件名
            String fileName = file.getOriginalFilename();

            DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
            String formatDate = format.format(new Date());
            //获取文件的前缀
            String prefixName =fileName.substring(0, fileName.lastIndexOf("."));
            System.out.println(prefixName+"prefixName");
            log.info("上传的文件名：" + fileName);
            //获取文件后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            log.info("文件后缀名：" + suffixName);
            fileName = formatDate + suffixName;
            //设置文件存储路径,写入的路径
            String filePath = uploadPath;
            File dest = new File(filePath + fileName);
            //数据库存储的路径总路径 ip+端口+文件名
            //String path = (host + ":" + post + sonPath + fileName);
            //根据前端将路径改为文件夹加文件名/file/200.jpg
            String path = (sonPath + fileName);
            //检测是否存在该目录
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            //写入文件
            file.transferTo(dest);
            result.put("name",prefixName);
            result.put("url",path);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        result.put("statue","上传失败");
        return result;
    }


}
