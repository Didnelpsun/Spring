package org.didnelpsun.entity.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
    public String url;
    public String username;
    public String password;
    public UserDAO(){
        System.out.println("UserDAOClass");
    }
}
