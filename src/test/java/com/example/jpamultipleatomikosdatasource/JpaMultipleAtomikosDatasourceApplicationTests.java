package com.example.jpamultipleatomikosdatasource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.PlatformTransactionManager;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaMultipleAtomikosDatasourceApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private BaseService baseService;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Test
    public void saveA() {
        String nameA1 = "nameA1";
        String nameA2 = "nameA2";
//        String nameA2 = null;
        baseService.saveA(nameA1, nameA2);
    }

    @Test
    public void saveB() {
        String nameB1 = "nameB1";
        String nameB2 = "nameB2";
//        String nameB2 = null;
        baseService.saveB(nameB1, nameB2);
    }

    @Test
    public void save() {
        String nameA1 = "nameA1";
        String nameB1 = "nameB1";
        String nameA2 = "nameA2";
        String nameB2 = "nameB2";
//        String nameB2 = null;
        baseService.save(nameA1, nameB1, nameA2, nameB2);
    }

}
