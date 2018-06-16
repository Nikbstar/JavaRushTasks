package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

public class UsersView implements View {

    private Controller controller;

    public void fireEventShowAllUsers() {
        this.controller.onShowAllUsers();
    }

    public void fireEventShowDeletedUsers() {
        this.controller.onShowAllDeletedUsers();
    }

    public void fireEventOpenUserEditForm(long id) {
        this.controller.onOpenUserEditForm(id);
    }

    @Override
    public void refresh(ModelData modelData) {
        String print = modelData.isDisplayDeletedUserList() ? "All deleted users:" : "All users:";
        System.out.println(print);
        for (User user : modelData.getUsers()) {
            System.out.printf("%c%s%s", '\t', user, System.lineSeparator());
        }
        System.out.println("===================================================");
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

}
