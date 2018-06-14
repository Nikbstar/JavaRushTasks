package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;

public class FakeModel implements Model {

    private ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData() {
        return this.modelData;
    }

    @Override
    public void loadUsers() {
        this.modelData.setUsers(new ArrayList<>());
        this.modelData.getUsers().add(new User("A", 1, 1));
        this.modelData.getUsers().add(new User("B", 2, 1));
    }

}
