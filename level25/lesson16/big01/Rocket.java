package com.javarush.test.level25.lesson16.big01;

/**
 * Created by Александр on 08.10.2015.
 */
/**
 * Класс для объектов-ракета
 */
public class Rocket  extends BaseObject
{

    public Rocket(double x, double y)
    {
        super(x, y, 1);
    }

    /**
     * Метод рисует свой объект на "канвасе".
     */
    @Override
    public void draw(Canvas canvas)
    {
        canvas.setPoint(x,y,'R');
    }

    /**
     * Двигаем себя вверх на один ход.
     */
    @Override
    public void move()
    {
        y--;
    }
}
