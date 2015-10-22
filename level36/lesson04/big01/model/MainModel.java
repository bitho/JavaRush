package com.javarush.test.level36.lesson04.big01.model;

/**
 * Created by Александр on 19.10.2015.
 */
import com.javarush.test.level36.lesson04.big01.bean.User;
import com.javarush.test.level36.lesson04.big01.model.service.UserService;
import com.javarush.test.level36.lesson04.big01.model.service.UserServiceImpl;


import java.util.List;


public class MainModel implements Model
{
    UserService userService = new UserServiceImpl();
    ModelData modelData = new ModelData();
    @Override
    public ModelData getModelData()
    {
        return modelData;
    }

    @Override
    public void loadUsers() {
        modelData.setUsers(userService.getUsersBetweenLevels(1, 100));
        modelData.setDisplayDeletedUserList(false);
    }

    public void loadDeletedUsers() {
        List<User> users = userService.getAllDeletedUsers();
        modelData.setUsers(users);
        modelData.setDisplayDeletedUserList(true);
    }

    @Override
    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }
    @Override
    public void deleteUserById(long id){
        User user = userService.deleteUser(id);
        modelData.setActiveUser(user);
        //List<User> users = modelData.getUsers();
        //List<User> usersActive = MainModel.getActiveUsers(user);
        //modelData.setUsers(usersActive);
        modelData.setDisplayDeletedUserList(false);
    }
    private List<User> getActiveUsers(List<User> userList){
        return userService.filterOnlyActiveUsers(userList);
    }
}