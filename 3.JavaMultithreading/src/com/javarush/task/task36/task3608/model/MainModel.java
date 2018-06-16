package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;
import com.javarush.task.task36.task3608.bean.User;

import java.util.List;

public class MainModel implements Model {

    private ModelData modelData = new ModelData();
    private UserService userService = new UserServiceImpl();

    private List<User> getAllUsers() {
        return this.userService.filterOnlyActiveUsers(this.userService.getUsersBetweenLevels(1, 100));
    }

    @Override
    public ModelData getModelData() {
        return this.modelData;
    }

    @Override
    public void loadUsers() {
        List<User> users = this.getAllUsers();
        this.modelData.setUsers(users);
        this.modelData.setDisplayDeletedUserList(false);
    }

    @Override
    public void loadDeletedUsers() {
        List<User> users = this.userService.getAllDeletedUsers();
        this.modelData.setUsers(users);
        this.modelData.setDisplayDeletedUserList(true);
    }

    @Override
    public void loadUserById(long userId) {
        User user = this.userService.getUsersById(userId);
        this.modelData.setActiveUser(user);
    }

    @Override
    public void deleteUserById(long id) {
        this.userService.deleteUser(id);
        this.modelData.setUsers(this.getAllUsers());
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        this.userService.createOrUpdateUser(name, id, level);
        this.modelData.setUsers(this.getAllUsers());
    }

}
