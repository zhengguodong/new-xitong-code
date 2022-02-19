// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space
// Source File Name:   GeneratorAPP.java

package com.zgd;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class GeneratorAPP
{

    public GeneratorAPP()
    {
    }

    public static void main(String args[])
    {
        AutoGenerator mpg = new AutoGenerator();
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir((new StringBuilder()).append(projectPath).append("/src/main/java").toString());
        gc.setOpen(false);
        gc.setSwagger2(true);
        gc.setBaseResultMap(true);
        gc.setEntityName("%s");
        gc.setServiceName("%sService");
        gc.setXmlName("%sMapper");
        gc.setServiceImplName("%sServiceImpl");
        gc.setFileOverride(true);
        mpg.setGlobalConfig(gc);
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=Asia/Shanghai");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("19991008");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.zgd");
        mpg.setPackageInfo(pc);
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        mpg.setStrategy(strategy);
        mpg.execute();
    }
}
