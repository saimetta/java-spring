package com.saimetta.cloudnativejava.chapter2.boot;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
