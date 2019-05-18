package com.example.jpamultipleatomikosdatasource;

import com.example.jpamultipleatomikosdatasource.dao.a.TableA1Dao;
import com.example.jpamultipleatomikosdatasource.dao.a.TableA2Dao;
import com.example.jpamultipleatomikosdatasource.dao.b.TableB1Dao;
import com.example.jpamultipleatomikosdatasource.dao.b.TableB2Dao;
import com.example.jpamultipleatomikosdatasource.model.a.TableA1;
import com.example.jpamultipleatomikosdatasource.model.a.TableA2;
import com.example.jpamultipleatomikosdatasource.model.b.TableB1;
import com.example.jpamultipleatomikosdatasource.model.b.TableB2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class BaseService {
    @Autowired
    TableA1Dao tableA1Dao;
    @Autowired
    TableA2Dao tableA2Dao;
    @Autowired
    TableB1Dao tableB1Dao;
    @Autowired
    TableB2Dao tableB2Dao;


    public void addA1(String name) {
        TableA1 tableA1 = new TableA1();
        tableA1.setName(name);
        tableA1Dao.save(tableA1);
    }

    public void addA2(String name) {
        TableA2 tableA2 = new TableA2();
        tableA2.setName(name);
        tableA2Dao.save(tableA2);
    }

    public void addB1(String name) {
        TableB1 tableB1 = new TableB1();
        tableB1.setName(name);
        tableB1Dao.save(tableB1);
    }

    public void addB2(String name) {
        TableB2 tableB2 = new TableB2();
        tableB2.setName(name);
        tableB2Dao.save(tableB2);
    }

    @Transactional
    public void saveA(String nameA1, String nameA2) {
        this.addA1(nameA1);
        this.addA2(nameA2);
    }

    @Transactional
    public void saveB(String nameB1, String nameB2) {
        this.addB1(nameB1);
        this.addB2(nameB2);
    }

    @Transactional
    public void save(String nameA1, String nameB1, String nameA2, String nameB2) {
        this.addA1(nameA1);
        this.addB1(nameB1);
        this.addA2(nameA2);
        this.addB2(nameB2);
    }
}
