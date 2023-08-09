package com.study.javax;

import com.study.javax.test01.Calculate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

}
