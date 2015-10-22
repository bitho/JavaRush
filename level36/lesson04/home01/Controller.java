package com.javarush.test.level36.lesson04.home01;

/**
 * Created by Александр on 19.10.2015.
 */
import java.util.List;


public class Controller
{
    private Model model = new Model();
    public List<String> onDataListShow() {
        return model.getStringDataList();
    }
}