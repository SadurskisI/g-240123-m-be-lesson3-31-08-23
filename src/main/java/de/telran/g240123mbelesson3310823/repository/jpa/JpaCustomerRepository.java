package de.telran.g240123mbelesson3310823.repository.jpa;

import de.telran.g240123mbelesson3310823.domain.entity.jpa.JpaCustomer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JpaCustomerRepository extends JpaRepository<JpaCustomer,Integer> {

    @Transactional
    void deleteByName(String name);

    @Query(value = "select sum(price) from product;", nativeQuery = true)
    double getTotalPrice();
}
