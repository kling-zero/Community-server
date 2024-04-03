package com.zeroone.star.project.utils.po;

import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author iceberg-work
 */
public class ToObjUtils {

    /**
     * 将一个对象转换成另一个对象(po->obj)
     *
     * @param pc
     * @param po
     * @param oc
     * @param obj
     * @throws Exception
     */
    public static void toPo(Class pc, Object po, Class oc, Object obj) throws Exception {
        //获取实体类的全部属性
        Field[] dcFields = oc.getDeclaredFields();
        Field[] pcFields = pc.getDeclaredFields();

        for (Field dcField : dcFields) {
            //AccessibleTest 类中的成员变量为private
            //取消属性的访问权限控制，即使private属性也可以进行访问
            dcField.setAccessible(true);
            String dcName = dcField.getName();
            //屏蔽序列化的字段
            if ("serialVersionUID".equals(dcName)) {
                continue;
            }
            //遍历entity
            for (Field pcField : pcFields) {
                pcField.setAccessible(true);
                String pcName = pcField.getName();
                if (dcName.equals(pcName)) {
                    String pcMethodName = "get" + StringUtils.capitalize(pcName);
                    Method pcMethod = pc.getDeclaredMethod(pcMethodName);
                    dcField.set(obj, pcMethod.invoke(po));
                }
            }
        }
    }

    public static void toVO(Class pc, Object po, Class vc, Object vo) throws Exception {
        toPo(pc, po, vc, vo);
    }

    public static void toEntity(Class pc, Object po, Class ec, Object entity) throws Exception {
        toPo(pc, po, ec, entity);
    }

    public static void toDto(Class pc, Object po, Class dc, Object dto) throws Exception {
        toPo(pc, po, dc, dto);
    }

    public static <IN,OUT> OUT toAllDto(IN in,Class<OUT> clazz) {
        OUT out = null;
        try {
            out= clazz.newInstance();
            toDto(in.getClass(), in, out.getClass(), out);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return out;
    }
}
