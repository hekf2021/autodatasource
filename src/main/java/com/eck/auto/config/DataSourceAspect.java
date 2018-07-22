package com.eck.auto.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Aspect
@Order(1)
@Configuration
public class DataSourceAspect {
    private static final String dsNo="dsNo";//数据库编号 从header中取

    /**
     * 切入点,放在controller的每个方法上进行切入,更新数据源
     */
    @Pointcut("execution(* com.eck.auto.controller..*.*(..))")
    private void anyMethod(){}//定义一个切入点
    @Before("anyMethod()")
    public void dataSourceChange()
    {
        //请求头head中获取对应数据库编号
        String no = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader(dsNo);
        System.out.print("当前数据源编号:"+no);
        if(StringUtils.isEmpty(no)){
            //TODO 根据业务抛异常
        }
        DataSourceHolder.setDataSource(no);
        /*这里数据库项目编号来更改对应的数据源*/
    }
}
