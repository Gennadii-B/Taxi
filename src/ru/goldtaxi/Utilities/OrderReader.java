package ru.goldtaxi.Utilities;

import ru.goldtaxi.Entity.Car;
import ru.goldtaxi.Entity.Order;
import java.io.*;

public class OrderReader {
    private OrderReader(){};
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static OrderReader instance = new OrderReader();
    public static OrderReader getInstance(){
        return instance;
    }

    public static Order orderRead() throws Exception {

        try {
            System.out.println("Введите начальную точку вашего маршрута:");
            String start = reader.readLine();

            System.out.println("Введите конечную точку вашего маршрута:");
            String end = reader.readLine();

            System.out.println("нужно ли вам детское сиденье? Y/N :");
            boolean babyseat;
            String a = reader.readLine();
            if(a.equals("Y") || a.equals("N"));
                else throw new ExceptionOfDataInput();
            if (a.equals("Y")) babyseat = true;
            else babyseat = false;

            System.out.println("будете ли вы курить в дороге? Y/N :");
            boolean smoke;
            String b = reader.readLine();
            if(b.equals("Y") || b.equals("N"));
            else throw new ExceptionOfDataInput();
            if (b.equals("Y")) smoke = true;
            else smoke = false;

            System.out.println("какой уровень удобства вам нужен?\n " +
                    "введите '1' если вам важен комфорт\n" +
                    "введите '0' если вас интересует эконом класс:");
            String c = reader.readLine();
            if(c.equals("1") || c.equals("0"));
            else throw new ExceptionOfDataInput();
            int d = Integer.parseInt(c);
            int carclass = d;


            Order client = new Order(start, end, babyseat, smoke, carclass);
            return client;
        }
        catch(ExceptionOfDataInput exc) {
            System.out.println(exc);
            return orderRead();
        }

    }
}
