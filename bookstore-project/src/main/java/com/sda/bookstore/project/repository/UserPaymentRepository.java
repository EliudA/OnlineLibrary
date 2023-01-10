package com.sda.bookstore.project.repository;


import com.sda.bookstore.project.model.UserPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserPaymentRepository extends JpaRepository<UserPayment, Long> {

}
