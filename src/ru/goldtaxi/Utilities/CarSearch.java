package ru.goldtaxi.Utilities;

import ru.goldtaxi.Entity.*;

import java.util.ArrayList;


public class CarSearch {
    public static void searchFreeCar(ArrayList<Car> CarArrayList, Order order) {
        boolean selection = true;
        int index = 0;
        while(selection){
            if(index == CarArrayList.size()){
                selection = false;
                System.out.println("В данный момент нет подходящего для вас автомобиля, " +
                        "заявка ожидает подходящего, освободившегося автомобиля");
                continue;
        }
            if(CarArrayList.get(index).isHaveBabySeat() != order.isNeedBabySeat()){
                index++;
                continue;
            }
            if(CarArrayList.get(index).isSmokeCar() != order.isNeedSmokeCar()){
                index++;
                continue;
            }
            if(CarArrayList.get(index).getCarClass() != order.getNeedCarClass()){
                index++;
                continue;
            }
            if(CarArrayList.get(index).getCarStatus() == Car.TYPE_OF_STATUS_RESERVED){
                index++;
                continue;
            }
            selection = false;
            CarArrayList.get(index).setCarStatus(Car.TYPE_OF_STATUS_RESERVED);
            System.out.println("К вам подъедет автомобиль: \n" +
                    "номер: " + CarArrayList.get(index).getCarNumber() + "\n" +
                    "марка: " + CarArrayList.get(index).getCarMark() + "\n" +
                    "данные водителя: " + CarArrayList.get(index).getCarDriver().getName() + "|" +
                    " контактный номер: " + CarArrayList.get(index).getCarDriver().getTelephone() + "\n");

    }
}

}
