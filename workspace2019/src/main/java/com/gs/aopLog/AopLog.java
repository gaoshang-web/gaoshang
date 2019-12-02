package com.gs.aopLog;

import com.gs.entity.LogInfo;
import com.gs.entity.UserInfo;
import com.gs.service.log.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class AopLog {

    //切到日志的service层
    @Autowired
    private LogService logService;

    //切点表达式
    @Pointcut("execution(* com.gs.controller.*.*(..))")
    public void pointCut(){

    }

    /*//前置通知
    @Before("pointCut()")
    public void before(JoinPoint joinPoint){
        System.out.println("前置通知方法执行!");
    }

    //后置通知
    @After("pointCut()")
    public void after(JoinPoint joinPoint){
        System.out.println("后置通知方法执行!");
    }

    //异常通知
    @AfterThrowing(pointcut = "pointCut()", throwing = "exception")
    public void exception(JoinPoint joinPoint, Exception exception){
        System.out.println("抛出异常后通知!"+exception.getMessage());
    }*/

    @Around("pointCut()&&@annotation(logAnnotation)")
    public Object around(ProceedingJoinPoint joinPoint, LogAnnotation logAnnotation, HttpServletRequest requeste){
        //前置通知
        System.out.println("前置通知");
        //获取当前(开始)时间
        Long startTime=System.currentTimeMillis();

        //实例化logInfo
        LogInfo logInfo = new LogInfo();

        Object obj = null;
        try {
            obj = joinPoint.proceed();
            //获取request
            HttpServletRequest request = ((ServletRequestAttributes)(RequestContextHolder.currentRequestAttributes())).getRequest();

            //方法所在路径
            String className = joinPoint.getTarget().getClass().getName();
            System.out.println("方法所在的类路径:"+className);
            logInfo.setClassUrl(className);

            //方法名称
            String methodName = joinPoint.getSignature().getName();
            System.out.println("方法名称:"+methodName);
            logInfo.setMethodName(methodName);

            //当前时间
            SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            System.out.println("当前时间为:"+sim.format(date));
            logInfo.setCurrentTime(date);

            //ip地址
            String ipAddr = request.getRemoteAddr();
            System.out.println("ip地址:"+ipAddr);
            logInfo.setIpAddr(ipAddr);

            //方法描述
            String methodMessage = logAnnotation.value();
            System.out.println("方法描述:"+methodMessage);
            logInfo.setMethodMessage(methodMessage);

            //日志的状态,设置成默认'正常':1
            logInfo.setStatus(1);

        } catch (Throwable throwable) {
            throwable.printStackTrace();
            //出现异常,则将日志状态设置成'异常':2
            logInfo.setStatus(2);
            //异常通知
            System.out.println("异常通知");
        }finally {
        //后置通知

            //获取request
            HttpServletRequest request = ((ServletRequestAttributes)(RequestContextHolder.currentRequestAttributes())).getRequest();
            //通过request从session里面取出用户的数据
            UserInfo userInfo = (UserInfo) request.getSession().getServletContext().getAttribute("userInfo");

            //用户名,判断如果操作人名不为空,则将其设置成从request获取到的用户名,如果为空,则将其设置成一个默认值,不然会报空指针异常
            System.out.println("操作人:"+userInfo.getUserName());
            logInfo.setOperationUser(userInfo.getUserName());

            //耗时
            //获取当前(结束)时间
            Long endTime = System.currentTimeMillis();
            //结束时间与开始时间(在前置通知中获取)的时间差便是"耗时"
            Long consumeTime=endTime-startTime;
            System.out.println("耗时:"+consumeTime);
            logInfo.setConsumeTime(consumeTime);

        }
        //调用新增方法执行新增
        logService.saveLog(logInfo);
        return obj;
    }
}
