package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

public class EditUserView implements View {

    private Controller controller;

    public void fireEventUserDeleted(long id) {
        this.controller.onUserDelete(id);
    }

    public void fireEventUserChanged(String name, long id, int level) {
        this.controller.onUserChange(name, id, level);
    }

    @Override
    public void refresh(ModelData modelData) {
        System.out.println("User to be edited:");
        System.out.printf("%c%s%s", '\t', modelData.getActiveUser(), System.lineSeparator());
        System.out.println("===================================================");
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

}
