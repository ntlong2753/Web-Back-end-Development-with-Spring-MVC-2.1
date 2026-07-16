package com.codegym.shoppingcart.model;

import java.util.Map;

public class Cart {
    private Map<Product, Integer> products;

    public Cart(){
    }

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    // kiem tra san pham trong gio hang co ton tai hay khong
    public boolean checkItemInCart(Product product){
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().equals(product.getId())) {
                return true;
            }
        }
        return false;
    }

    // kiểm tra xem sản phẩm đã có trong giỏ hàng hay chưa.
    private Map.Entry<Product, Integer> selectItemInCart(Product product){
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if(entry.getKey().getId().equals(product.getId())){
                return entry;
            }
        }
        return null;
    }

    // sử dụng để thêm sản phẩm vào giỏ hàng.
    public void addProduct(Product product){
        if (!checkItemInCart(product)){
            products.put(product,1);
        } else {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            Integer newQuantity = itemEntry.getValue() + 1;
            products.replace(itemEntry.getKey(),newQuantity);
        }
    }

    // sử dụng để đếm số lượng sản phẩm trong giỏ hàng.
    public Integer countProductQuantity(){
        Integer productQuantity = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    // sử dụng để đếm tổng số lượng sản phẩm hiện có trong giỏ hàng.
    public Integer countItemQuantity(){
        return products.size();
    }

    // sử dụng để tính tổng tiền cần thanh toán của giỏ hàng.
    public Float countTotalPayment(){
        float payment = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }

}
