package com.javarush.test.level36.lesson04.home01;

/**
 * Created by Александр on 19.10.2015.
 */
public class View
{
    private Controller controller = new Controller();
    public void fireEventShowData() {
        System.out.println(controller.onDataListShow());
    }
}