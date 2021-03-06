package com.stylefeng.guns.rest.order.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetailVO implements Serializable {
    String orderId;
    String filmName;
    String fieldTime;
    String cinemaName;
    String seatsName;
    String orderPrice;
    String orderTimestamp;
}
