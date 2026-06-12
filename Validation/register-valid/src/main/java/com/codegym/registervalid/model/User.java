package com.codegym.registervalid.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

public class User {
    @NotEmpty(message = "{name.empty}")
    @Size(min = 2, max = 20, message = "{name.length}")
    private String firstName;

    @NotEmpty(message = "{name.empty}")
    @Size(min = 2, max = 20, message = "{name.length}")
    private String lastName;

    @NotNull(message = "{age.empty}")
    @Min(value = 18, message = "{age.min}")
    @Max(value = 100, message = "{age.max}")
    private Integer age;

    @NotEmpty(message = "{phone.empty}")
    @Size(min = 10, max = 11, message = "{phone.length}")
    @Pattern(regexp = "0[0-9]*", message = "{phone.startsWith}")
    private String phone;

    public User() {

    }

    public User(String name, String phone, int age) {
        this.firstName = name;
        this.phone = phone;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

