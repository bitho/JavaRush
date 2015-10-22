package com.javarush.test.level22.lesson18.big01;

/**
 * Created by јлександр on 08.10.2015.
 */
public class Figure
{
    //метрица котора€ определ€ет форму фигурки: 1 - клетка не пуста€, 0 - пуста€
    private int[][] matrix;
    //координаты
    private int x;
    private int y;

    public Figure(int x, int y, int[][] matrix)
    {
        this.x = x;
        this.y = y;
        this.matrix = matrix;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int[][] getMatrix()
    {
        return matrix;
    }

    /**
     * ѕоворачаиваем фигурку.
     * ƒл€ простоты - просто вокруг главной диагонали.
     */
    public void rotate()
    {
        int[][] matrix2 = new int[3][3];

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                matrix2[i][j] = matrix[j][i];
            }
        }

        matrix = matrix2;
    }

    /**
     * ƒвигаем фигурку влево.
     * ѕровер€ем не вылезла ли она за границу пол€ и/или не залезла ли на зан€тые клетки.
     */
    public void left()
    {
        x--;
        if (!isCurrentPositionAvailable())
            x++;
    }

    /**
     * ƒвигаем фигурку вправо.
     * ѕровер€ем не вылезла ли она за границу пол€ и/или не залезла ли на зан€тые клетки.
     */
    public void right()
    {
        x++;
        if (!isCurrentPositionAvailable())
            x--;
    }

    /**
     * ƒвигаем фигурку вверх.
     * »спользуетс€, если фигурка залезла на зан€тые клетки.
     */
    public void up()
    {
        y--;
    }

    /**
     * ƒвигаем фигурку вниз.
     */
    public void down()
    {
        y++;
    }

    /**
     * ƒвигаем фигурку вниз до тех пор, пока не залезем на кого-нибудь.
     */
    public void downMaximum()
    {
        while (isCurrentPositionAvailable())
        {
            y++;
        }

        y--;
    }

    /**
     * ѕровер€ем - может ли фигурка находитс€ на текущей позици:
     * а) не вылазиет ли она за границы пол€
     * б) не залазиет ли она на зан€тые клетки
     */
    public boolean isCurrentPositionAvailable()
    {
        Field field = Tetris.game.getField();

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (matrix[i][j] == 1)
                {
                    if (y + i >= field.getHeight())
                        return false;

                    Integer value = field.getValue(x + j, y + i);
                    if (value == null || value == 1)
                        return false;
                }
            }
        }

        return true;
    }

    /**
     * ѕриземл€ем фигурку - добавл€ем все ее непустые клетки к клеткам пол€.
     */
    public void landed()
    {
        Field field = Tetris.game.getField();

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (matrix[i][j] == 1)
                    field.setValue(x + j, y + i, 1);
            }
        }
    }
}