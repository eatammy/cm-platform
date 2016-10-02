package cn.eatammy.common.utils.excel;

import cn.eatammy.common.anno.ExcelAnnotation;

/**
 * Created by 郭旭辉 on 2016/9/28.
 */
public class ExcelDto {

    @ExcelAnnotation(columnName = "商品名称")
    private String name;

    @ExcelAnnotation(columnName = "单价")
    private double price;

    @ExcelAnnotation(columnName = "所属类别")
    private Long categoryId;

    @ExcelAnnotation(columnName = "库存")
    private Integer stock;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}

