package com.study.javax;

import com.study.javax.test01.Calculate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.function.Predicate;

/**
 * @author luohx
 */
@SpringBootApplication
public class JavaxFuncApplication {

    public static void main(String[] args) {
        record(() -> System.out.println("函数式编程")
                , "数据异常,请排查");

        SpringApplication.run(JavaxFuncApplication.class, args);
    }

    /**
     * 记录
     *
     * @param calculate 计算
     * @param errorInfo 错误信息
     */
    private static void record(Calculate calculate, String errorInfo) {
        try {
            calculate.process();
        } catch (Exception e) {
            throw e;
        }
    }

    private static void test_Predicate() {
        //① 使用Predicate接口实现方法,只有一个test方法，传入一个参数，返回一个bool值
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if (integer > 5) {
                    return true;
                }
                return false;
            }
        };

        System.out.println(predicate.test(6));

        System.out.println("********************");

        //② 使用lambda表达式，
        predicate = (t) -> t > 5;
        System.out.println(predicate.test(1));

        //3 学习
        Predicate<Integer> predicate01 = (t) -> t > 0;
        System.out.println("断言：" + predicate01.test(-2));

    }

}
