package com.javarush.test.level36.lesson04.big01.model;

/**
 * Created by Александр on 19.10.2015.
 */
import com.javarush.test.level36.lesson04.big01.bean.User;

import java.util.ArrayList;
import java.util.List;


public class ModelData {
    List<User> users = new ArrayList<>();
    User activeUser;
    boolean displayDeletedUserList;

    public boolean isDisplayDeletedUserList()
    {
        return displayDeletedUserList;
    }

    public void setDisplayDeletedUserList(boolean displayDeletedUserList)
    {
        this.displayDeletedUserList = displayDeletedUserList;
    }

    public void setActiveUser(User activeUser)
    {
        this.activeUser = activeUser;
    }

    public User getActiveUser()
    {

        return activeUser;
    }


    public List<User> getUsers() {
        return users;
    }


    public void setUsers(List<User> users) {
        this.users = users;
    }

}