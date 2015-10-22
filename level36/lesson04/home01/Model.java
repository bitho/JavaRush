package com.javarush.test.level36.lesson04.home01;

/**
 * Created by Александр on 19.10.2015.
 */
import java.util.List;


public class Model
{
    private Service service = new Service();
    public List<String> getStringDataList() {

        return service.getData();
    }
}