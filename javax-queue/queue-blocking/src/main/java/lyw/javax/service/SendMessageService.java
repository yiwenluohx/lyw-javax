package lyw.javax.service;

import org.springframework.stereotype.Service;

/**
 * @Author: luohx
 * @Description: 发送邮件
 * @Date: 2021/2/3 11:13
 */
@Service
public class SendMessageService {
    public void sendMessage(String email,String content){
        System.out.println("发送邮件。。。");
    }
}
