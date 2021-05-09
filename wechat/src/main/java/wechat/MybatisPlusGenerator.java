package wechat;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.springframework.util.SocketUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Kevin Gao
 * @version 1.0.0
 * @ClassName wechat.MybatisPlusGenerator.java
 * @date 2020/10/24 12:19
 * @Description
 * @Content: 代码生成器
 */
public class MybatisPlusGenerator {
    public static void main(String[] args) {
        // 模块名
        String moduleName = "wechat.mbg";

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        // 获取当前项目根路径
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir("C:/wechat"+"/src/main/java");
        gc.setAuthor("Kevin");
        gc.setOpen(false); //不打开生产的文件
        gc.setFileOverride(true); //不覆盖之前生成的文件
        gc.setServiceName("%sService");
        gc.setMapperName("%sMapper");
        gc.setServiceImplName("%sServiceImpl");
        gc.setXmlName("%sMapper");
        gc.setIdType(IdType.AUTO);// 主键策略 自增  注意要和数据库中表实际情况对应
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(true);//自动开启swagger2的支持
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        /*jdbc:mysql://47.100.3.219:3306/funhouse?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai*/
        dsc.setUrl("jdbc:mysql://localhost:3306/funhouse?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(null);
        pc.setParent(moduleName);
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setInclude("t_user");
        //可以用同配符号:表示生成t_开头的对应库下所有表
        //strategy.setInclude("t"+"_\\w*");
        strategy.setNaming(NamingStrategy.underline_to_camel);// 下划线转驼峰
       // strategy.setTablePrefix("t_");//去掉t_这个前缀后生成类名
        strategy.setEntityLombokModel(true);// 自动生成lombok注解  记住要有lombok依赖和对应的插件哈
        strategy.setLogicDeleteFieldName("delete_flage");//设置逻辑删除字段 要和数据库中表对应哈

        // 设置创建时间和更新时间自动填充策略
        TableFill created_date = new TableFill("created_date", FieldFill.INSERT);
        TableFill updated_date = new TableFill("updated_date", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(created_date);
        tableFills.add(updated_date);
        strategy.setTableFillList(tableFills);

        // 乐观锁策略
        strategy.setVersionFieldName("version");
        strategy.setRestControllerStyle(true);//采用restful 风格的api
        strategy.setControllerMappingHyphenStyle(true); // controller 请求地址采用下划线代替驼峰
        mpg.setStrategy(strategy);

        // 执行
        mpg.execute();
    }

}
