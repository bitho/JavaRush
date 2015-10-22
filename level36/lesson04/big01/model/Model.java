package com.javarush.test.level36.lesson04.big01.model;

/**
 * Created by Александр on 19.10.2015.
 */
public interface Model {
    ModelData getModelData();
    void loadUsers();
    void loadDeletedUsers();
    void loadUserById(long userId);
    void deleteUserById(long userId);

}