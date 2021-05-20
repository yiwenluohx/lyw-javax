package lyw.javax.controller;

import lombok.extern.slf4j.Slf4j;
import lyw.javax.queue.CallableTaskFrameWork;
import lyw.javax.queue.CallableTemplate;
import lyw.javax.queue.ICallableTaskFrameWork;
import lyw.javax.queue.SendMessageHander;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @Author: luohx
 * @Description: 上传图片
 * @Date: 2021/1/27 19:02
 */
@Slf4j
@RequestMapping("file")
@RestController
public class FileOperController {
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("upload")
    public ResponseEntity upload(@RequestParam("file") MultipartFile file) throws Exception {
        HttpHeaders headers = getHeader();
        MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
        form.add("file", file.getResource());
        form.add("filename", file.getName());

        HttpEntity<MultiValueMap<String, Object>> files = new HttpEntity<>(form, headers);
        ResponseEntity<String> ss = restTemplate.postForEntity("http://10.254.1.56:38080/apiOss/file/upload", files, String.class);
        return ResponseEntity.ok("");
    }

    private HttpHeaders getHeader() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("multipart/form-data");
        headers.setContentType(type);
        headers.add("Authorization", "Bearer 945c119f-945f-4d27-af84-1dbed11caf89");
        return headers;
    }

    @GetMapping("get")
    public ResponseEntity getId() throws Exception {
        ICallableTaskFrameWork callableTaskFrameWork = new CallableTaskFrameWork();
        List<CallableTemplate<Map<String, String>>> tasks = new ArrayList<>();
        SendMessageHander sendMessageHander = null;
        // 将需要发送邮件的邮件地址及内容组装好，放在一个集合中
        for (int i = 0; i < 1000; i++) {
            sendMessageHander = new SendMessageHander("email" + i, "content" + i);
            tasks.add(sendMessageHander);
        }
        //通过多线程一次性发起邮件，并拿到返回结果集
        List<Map<String, String>> results = callableTaskFrameWork
                .submitsAll(tasks);
        // 解析返回结果集
        for (Map<String, String> map : results) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                System.out.println(entry.getKey() + "\t" + entry.getValue());
//                log.info(entry.getKey() + "\t" + entry.getValue());
            }
        }
        return ResponseEntity.ok("111");
    }

    @GetMapping("queue")
    public ResponseEntity queue() throws Exception {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(100);
        ExecutorService executor = new ThreadPoolExecutor(2, 4, 60, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(20));
        Runnable task = new Runnable() {
            @Override
            public void run() {

            }
        };
        executor.submit(task);
        return ResponseEntity.ok("222");
    }


}
