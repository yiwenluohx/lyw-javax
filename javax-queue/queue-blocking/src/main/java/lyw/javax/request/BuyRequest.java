package lyw.javax.request;

import lombok.Data;
import lyw.javax.entity.OrderEntity;

/**
 * @Author: luohx
 * @Description: 请求对象
 * @Date: 2021/1/18 16:26
 */
@Data
public class BuyRequest {
    /**
     * 商品id
     */
    private int good_id;
    /**
     * 用户id
     */
    private int user_id;
    /**
     * 订单id
     */
    private int order_id;
    /**
     * 订单信息
     */
    private OrderEntity order;
    /**
     * 请求处理状态（0:未处理;1:正常;2:异常）
     */
    private int response_status;
}