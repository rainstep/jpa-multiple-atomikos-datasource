package com.example.jpamultipleatomikosdatasource.dao.a;

import com.example.jpamultipleatomikosdatasource.model.a.TableA2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableA2Dao extends JpaRepository<TableA2, Integer> {
}
