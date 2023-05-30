package com.alepsdev.performance.repository;

import com.alepsdev.performance.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<Data, Long> {
}
