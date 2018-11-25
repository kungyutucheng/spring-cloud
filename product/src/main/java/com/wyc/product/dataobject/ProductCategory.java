package com.wyc.product.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author: wyc
 * @date: 2018/11/25
 */
@Entity
@Data
public class ProductCategory {

    @Id
    private Integer categoryId;

    private String categoryName;

    private Integer categoryType;

    private Date createTime;

    private Date updateTime;
}
