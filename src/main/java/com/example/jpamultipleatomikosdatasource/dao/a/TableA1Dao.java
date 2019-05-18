package com.example.jpamultipleatomikosdatasource.dao.a;

import com.example.jpamultipleatomikosdatasource.model.a.TableA1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableA1Dao extends JpaRepository<TableA1, Integer> {
}
