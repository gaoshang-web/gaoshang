import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class AnnoTest {
    @Test
    public void test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        User user=new User();
        user.setId(1);
        delete(user);
    }

    public void delete(Object obj) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Class clazz = obj.getClass();
        //获取表名
        TableName tableName = (TableName) clazz.getAnnotation(TableName.class);
        //创建一个空的字符串,将获取到的表名当成字符串放里面
        String tableAnno="";
        //判断当表名不为空时……
        if(tableName != null){
            tableAnno=tableName.value();
        }
        //使用StringBuffer的append()方法来拼接字符串
        StringBuffer stringBuffer=new StringBuffer("delete from ").append(tableAnno).append(" where ");
        //获取字段名
        //1.(Field:主要用于调用系统(数据库字段)之类的内容)
        //2.getFields()与getDeclaredFields()区别:
        //  getFields()只能访问类中声明为公有的字段,私有的字段它无法访问，能访问从其它类继承来的公有方法
        //  getDeclaredFields()能访问类中所有的字段,与public,private,protect无关，不能访问从其它类继承来的方法
        Field field = clazz.getDeclaredField("id");
        if(field!=null){
            String id = field.getAnnotation((ColumnName.class)).value();
        }
        //创建一个字符串List集合
        List<String> list=new ArrayList<String>();
        //接着遍历上一步获取的字符串数组
        /*for (int i = 0; i < declaredFields.length; i ++){
            //通过字段的注解取出数组中的字段,放到一个新的字段对象里面
            ColumnName columnName=declaredFields[0].getAnnotation(ColumnName.class);
            //判断取出的字符串不为空
            if(columnName!=null){
                //将字段名称拼接至我们的StringBuffer里面
                stringBuffer.append(columnName.value());
                //获取属性名
                String name = declaredFields[i].getName();
                //拼接获取字段值并放在list集合中去
                list.add("get"+name.substring(0,1).toUpperCase()+name.substring(1));
                if (i==0){
                    stringBuffer.append("="+list.get(i));
                }
            }
        }*/
        System.out.println(stringBuffer);
        for(int j = 0; j < list.size(); j++){
            Method method=clazz.getMethod(list.get(0));
            Object object=method.invoke(obj);
        }
    }
}
