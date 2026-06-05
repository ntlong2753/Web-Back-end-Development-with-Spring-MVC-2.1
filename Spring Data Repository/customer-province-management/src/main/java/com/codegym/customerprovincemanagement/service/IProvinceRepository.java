package com.codegym.customerprovincemanagement.service;

import com.codegym.customerprovincemanagement.model.Province;
import org.springframework.data.repository.CrudRepository;

public interface IProvinceRepository extends CrudRepository<Province, Long> {
}