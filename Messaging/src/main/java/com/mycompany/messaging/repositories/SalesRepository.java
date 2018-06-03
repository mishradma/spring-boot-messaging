package com.mycompany.messaging.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.messaging.domain.Sales;

@Repository
public interface SalesRepository extends PagingAndSortingRepository<Sales, Long> {

}
