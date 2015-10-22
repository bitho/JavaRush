package com.javarush.test.level24.lesson14.big01;

/**
 * Created by ��������� on 08.10.2015.
 */
/**
 * ����� ��� ������� "������".
 */
public class Brick extends BaseObject
{
    //�������� ��� ���������
    private static int[][] matrix = {
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
    };

    public Brick(double x, double y)
    {
        super(x,y,3);
    }

    /**
     * ������ ���� �� ������
     */
    @Override
    public void draw(Canvas canvas)
    {
        canvas.drawMatrix(x - radius + 1, y, matrix, 'H');
    }

    /**
     * ������ �� ������ - ������ ����������
     */
    @Override
    public void move()
    {
        //do nothing
    }
}