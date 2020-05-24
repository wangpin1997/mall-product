//package cn.wpin.mall.product.cnofig;
//
//import org.apache.ibatis.executor.Executor;
//import org.apache.ibatis.mapping.MappedStatement;
//import org.apache.ibatis.plugin.*;
//import org.apache.ibatis.session.ResultHandler;
//import org.apache.ibatis.session.RowBounds;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Properties;
//
///**
// * mybatis SQL拦截器
// *
// * @author wangpin
// */
//@Configuration
//@Intercepts({@Signature(type = Executor.class, method = "query", args = {MappedStatement.class, MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
//})
//public class SqlStatementInterceptor implements Interceptor {
//
//    @Override
//    public Object intercept(Invocation invocation) throws Throwable {
//        long st = System.currentTimeMillis();
//        invocation.getArgs();
//        return invocation.proceed();
//    }
//
//    @Override
//    public Object plugin(Object target) {
//        return Plugin.wrap(target, this);
//    }
//
//    @Override
//    public void setProperties(Properties properties) {
//        properties.setProperty("name", "wpin");
//    }
//}
