package org.example.dao.impl;

import org.example.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser() {
        System.out.println("save success");
    }
}
