package com.example.quliang.myapplication.runtimeann;

import android.util.Log;

import java.lang.reflect.Method;

/**
 * Created by quliang on 18-3-21.
 */

public class AnnotationUtils {


    //使用反射通过类名获取类的相关信息
    public static void getClassInfo(String className) {
        Object[] objects=null;
        try {
            Class c = Class.forName(className);
//            Log.i("Tag","进来了:"+c.getName());
            //获取所有公共的方法
            Method[] methods = c.getMethods();


            for(Method m : methods) {

//                Log.i("Tag","Method_name:"+m.getName());

                Class<CalcuRuningtime> ctClass = CalcuRuningtime.class;
                if(m.isAnnotationPresent(ctClass)){
                    Log.i("Tag","进来了");
                    CalcuRuningtime anno = m.getAnnotation(ctClass);
                    //当前方法包含查询时间的注解时
                    if(anno != null){
                        long beginTime = System.currentTimeMillis();

                        m.invoke(c.newInstance(),objects);
                        long endTime = System.currentTimeMillis();
                        long time = endTime - beginTime;
                        Log.i("Tag",anno.methodName()+"方法执行所需要时间：" + time + "ms");
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
