package lyw.javax.testFlatMap;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author luohx
 * @version 1.0.0
 * @date: 2023/7/6 下午3:40
 * @menu
 */
public class Main {
    public static void main(String[] args) throws Exception {
        //flatMap
        List<String> fun1 = Arrays.asList("one", "two", "three");
        List<String> fun2 = Arrays.asList("four", "five", "six");
        List<List<String>> nestedList = Arrays.asList(fun1, fun2);
        nestedList.stream().flatMap(x -> x.stream()).map(x -> x.toUpperCase()).forEach(x -> System.out.println(x));

        List<User> userList = new ArrayList<>();
        userList.add(new User(1L, "志诚", "123"));
        userList.add(new User(2L, "楠神", "456"));
        List<User> userList1 = new ArrayList<>();
        userList1.add(new User(11L, "冲哥", "789"));
        userList1.add(new User(22L, "清波", "021"));

        List<List<User>> userLL = new ArrayList<>();
        userLL.add(userList);
        userLL.add(userList1);
        System.out.println("userLL数据格式：" + JSON.toJSONString(userLL));

        userLL.stream().flatMap(k -> k.stream()).forEach(j -> {
            System.out.println("用户数据如下："+ JSON.toJSONString(j));
        });


    }
}
