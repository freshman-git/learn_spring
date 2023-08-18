package org.example.dao.impl;

import org.example.dao.UserDao;
import org.springframework.stereotype.Repository;


@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser() {
        System.out.println("yes");
    }
}
