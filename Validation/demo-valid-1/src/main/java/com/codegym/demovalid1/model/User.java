package com.codegym.demovalid1.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class User {
    @NotEmpty // không được để trống
    @Size(min = 3, max = 30) // giới hạn độ dài ký tự: ít nhất 3 ký tự, nhiều nhất 30 ký tự
    private String name;

    @Min(18) // giới hạn giá trị nhỏ nhất = 18. Ở đây, giới hạn độ tuổi từ 18 tuổi trở lên
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
