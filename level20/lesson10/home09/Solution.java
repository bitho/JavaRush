package com.javarush.test.level20.lesson10.home09;

import java.util.*;
import java.io.*;

/* Знакомство с графами
Прочитать в дополнительных материалах о сериализации графов.
Дан ориентированный плоский граф Solution, содержащий циклы и петли.
Пример, http://edu.nstu.ru/courses/saod/images/graph1.gif
Сериализовать Solution.
Все данные должны сохранить порядок следования.
*/
public class Solution implements Serializable {
    private static final long serialVersionUID = 1L;
    int node;
    List<Solution> edges = new LinkedList<>();
}
