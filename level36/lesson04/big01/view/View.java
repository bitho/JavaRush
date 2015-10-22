package com.javarush.test.level36.lesson04.big01.view;

/**
 * Created by Александр on 19.10.2015.
 */
import com.javarush.test.level36.lesson04.big01.controller.Controller;
import com.javarush.test.level36.lesson04.big01.model.ModelData;

public interface View {
    void refresh(ModelData modelData);
    void setController(Controller controller);
}