package com.userservice.users.repository;

import com.userservice.users.entity.CustomerEntity;
import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, ObjectId> {
    Optional<CustomerEntity> findByCustomerBillNo(String CustomerBillNo);

    Optional<CustomerEntity> findByCustomerEmail(String customerEmail);

    Optional<CustomerEntity> findByCustomerUserName(String customerUserName);
}

