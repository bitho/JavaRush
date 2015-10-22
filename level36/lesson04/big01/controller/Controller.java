package com.javarush.test.level36.lesson04.big01.controller;

/**
 * Created by Александр on 19.10.2015.
 */
import com.javarush.test.level36.lesson04.big01.dao.mock.DataSource;
import com.javarush.test.level36.lesson04.big01.model.FakeModel;
import com.javarush.test.level36.lesson04.big01.model.Model;
import com.javarush.test.level36.lesson04.big01.model.ModelData;
import com.javarush.test.level36.lesson04.big01.view.EditUserView;
import com.javarush.test.level36.lesson04.big01.view.UsersView;

/**
 * Created by Admin on 20.07.15.
 */
public class Controller
{
    private Model model;
    private UsersView usersView;
    EditUserView editUserView;

    public void setEditUserView(EditUserView editUserView)
    {
        this.editUserView = editUserView;
    }



    public void setModel(Model model) {
        this.model = model;
    }

    public void setUsersView(UsersView usersView) {
        this.usersView = usersView;
    }

    public void onShowAllUsers()
    {

        model.loadUsers();
        usersView.refresh(model.getModelData());

    }

    public void onShowAllDeletedUsers() {
        model.loadDeletedUsers();
        usersView.refresh(model.getModelData());
    }
    public void onOpenUserEditForm(long userId) {
        model.loadUserById(userId);
        editUserView.refresh(model.getModelData());
    }
    public void onUserDelete(long id){
        model.deleteUserById(id);
        editUserView.refresh(model.getModelData());
        usersView.refresh(model.getModelData());
    }

}