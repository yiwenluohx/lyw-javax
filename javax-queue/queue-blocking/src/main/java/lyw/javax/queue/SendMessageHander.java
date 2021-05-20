package lyw.javax.queue;

import lyw.javax.service.SendMessageService;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: luohx
 * @Description: 消费
 * @Date: 2021/2/3 11:16
 */
public class SendMessageHander extends CallableTemplate<Map<String, String>> {

    private String email;
    private String content;

    public SendMessageHander(String email, String content) {
        this.email = email;
        this.content = content;
    }

    @Override
    public Map<String, String> process() throws Exception {
        SendMessageService messageService = new SendMessageService();
        messageService.sendMessage(email, content);
        Map<String, String> map = new HashMap<>(16);
        map.put(email, content);
        return map;
    }
}
