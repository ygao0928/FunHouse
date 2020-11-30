package wechat;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
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
    /**
     * 获取项目路径
     */
    private static String canonicalPath = null;

    /**
     * 基本包名
     */
    private static String basePackage = "wechat.mbg";

    /**
     * 作者
     */
    private static String authorName = "Kevin";

    /**
     * 要生成的表名
     */
    private static String[] tables = {};

    /** table前缀 */
    // private static String prefix = "bg_";

    /**
     * 数据库类型
     */
    private static DbType dbType = DbType.MYSQL;
    private static String driverName = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/funhouse?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
    private static String username = "root";
    private static String password = "123456";

    public static void main(String[] args) {
        AutoGenerator gen = new AutoGenerator();

        String projectPath = System.getProperty("user.dir");
        /** 全局配置 */
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(projectPath + "/wechat/src/main/java");
        canonicalPath=projectPath + "/wechat/src/main";
        System.out.println("生成地址:"+projectPath + "/wechat/src/main/java");
        globalConfig.setFileOverride(true);
        globalConfig.setActiveRecord(true);
        globalConfig.setEnableCache(false);
        globalConfig.setBaseResultMap(true);
        globalConfig.setBaseColumnList(true);
        globalConfig.setOpen(false);
        globalConfig.setActiveRecord(false);
        globalConfig.setAuthor(authorName);
        globalConfig.setMapperName("%sMapper");
        globalConfig.setXmlName("%sMapper");
        globalConfig.setServiceName("%sService");
        globalConfig.setServiceImplName("%sServiceImpl");
        globalConfig.setXmlName("%sMapper");
        gen.setGlobalConfig(globalConfig);
        /** 数据库配置 */
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDriverName(driverName);
        dataSourceConfig.setDbType(dbType);
        dataSourceConfig.setUrl(url);
        dataSourceConfig.setUsername(username);
        dataSourceConfig.setPassword(password);
        gen.setDataSource(dataSourceConfig);
        /** 策略配置 */
        StrategyConfig strategyConfig = new StrategyConfig();
        //strategyConfig.setTablePrefix(new String[]{prefix});
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setInclude(tables);
        strategyConfig.setEntityBuilderModel(true);
        strategyConfig.setEntityLombokModel(true);
        gen.setStrategy(strategyConfig);
        /** 包配置 */
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(basePackage);
        packageConfig.setModuleName(null);
        packageConfig.setEntity("entity");
        packageConfig.setMapper("mapper");
        packageConfig.setService("service");
        packageConfig.setServiceImpl("service.impl");
        gen.setPackageInfo(packageConfig);
        /** 注入自定义配置   注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值 */
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-rb");
                this.setMap(map);
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {

            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                if (StringUtils.isEmpty(packageConfig.getModuleName())) {
                    return canonicalPath + "/resources/mbg.mapper/" + tableInfo.getXmlName() + StringPool.DOT_XML;
                } else {
                    return canonicalPath + "/resources/mbg.mapper/" + packageConfig.getModuleName() + "/" + tableInfo.getXmlName() + StringPool.DOT_XML;
                }
            }
        });
        cfg.setFileOutConfigList(focList);
        gen.setCfg(cfg);
        /** 模板配置 */
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        templateConfig.setController("");
        gen.setTemplate(templateConfig);

        /** 执行生成 */
        gen.setTemplateEngine(new FreemarkerTemplateEngine());
        gen.execute();
    }

}
