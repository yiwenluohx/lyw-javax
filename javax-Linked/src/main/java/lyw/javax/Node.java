package lyw.javax;

import lombok.Data;

/**
 * @Author: luohx
 * @Description: 链表节点
 * @Date: 2021/2/24  16:04
 */
@Data
public class Node {
    private int value;
    private Node next;

    public Node(int data) {
        this.value = data;
    }
}