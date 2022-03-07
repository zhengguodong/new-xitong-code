package com.zgd.config;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration 标注的类相当于xml配置文件
//分页的配置
@Configuration
public class page {
    /*
     * 定义方法，返回值是Java对象，该对象是放到spring容器中
     * */
//    @Bean
//    public PaginationInnerInterceptor paginationInnerInterceptor(){
//        return new PaginationInnerInterceptor();
//    }
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

}
