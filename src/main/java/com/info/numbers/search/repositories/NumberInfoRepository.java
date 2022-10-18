package com.info.numbers.search.repositories;


import com.info.numbers.search.models.Number;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NumberInfoRepository extends JpaRepository <Number, Integer> {
}
