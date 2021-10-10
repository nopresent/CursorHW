package com.cursorhw.hw3;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class Groshi {

    public static void main(String[] args) {

        double d = 1239.15;
        String delimiter = "---------------------";
        CoreMoney CoreMoney = new CoreMoney();
        CoreMoney.setMoney(d);

        System.out.println("Записываем число " + CoreMoney.printMoney(CoreMoney.getMoney()) + " в 2 поля");
        System.out.println("Целое, грн.: " + CoreMoney.getHrn());
        System.out.println("Дробное, коп.: " + CoreMoney.getKop());
        System.out.println(delimiter);

        double d1 = 12_346.56;
        System.out.println("Прибавим " + d1);
        CoreMoney.Math("+", d1);
        System.out.println("-> Ответ: " + CoreMoney.printMoney(CoreMoney.getMoney()));
        System.out.println(delimiter);

        double d2 = 1.102;
        System.out.println("Уможим на " + d2);
        CoreMoney.Math("*", d2);
        System.out.println("-> Ответ: " + CoreMoney.printMoney(CoreMoney.getMoney()));
        System.out.println(delimiter);

        double d3 = 0.5;
        System.out.println("Разделим на " + d3);
        CoreMoney.Math("/", d3);
        System.out.println("-> Ответ: " + CoreMoney.printMoney(CoreMoney.getMoney()));
        System.out.println(delimiter);

        double d4 = 100_001.55;
        System.out.println("Что больше? " + CoreMoney.printMoney(d4) + " или " + CoreMoney.printMoney(CoreMoney.getMoney()));
        System.out.println("-> Ответ: " + CoreMoney.Compare(">", d4));
        System.out.println(delimiter);

//        double c = 1239.15;
//        System.out.println("Сравним " + CoreMoney.printMoney(d4) + " или " + CoreMoney.printMoney(CoreMoney.getMoney()));
//        System.out.println(CoreMoney.Compare("==", c));



    }


}

class CoreMoney {

    private long hrn;
    private byte kop;
    final private String unknownOperation = "Не известная операция!";

    public void setMoney(double money) {
        BigDecimal bd = BigDecimal.valueOf(money).setScale(0, RoundingMode.DOWN);
        double kop = (money - bd.doubleValue()) * 100;
        this.hrn = (int) money;
        this.kop = (byte) Math.round(kop);
    }

    public double getMoney() {
        return Double.valueOf(getHrn() + "." + getKop());
    }

    public String printMoney(Double getMoney) {
        return getMoney.toString().replace(".", ",");
    }

    public long getHrn() {
        return this.hrn;
    }

    public byte getKop() {
        return this.kop;
    }

    public void Math(String math, double value) {
        Double money = getMoney();
        switch (math) {
            case "+":
                money += value;
                break;
            case "-":
                money -= value;
                break;
            case "/":
                money = money / value;
                break;
            case "*":
                money = money * value;

                break;

            default:
                System.out.println(unknownOperation);
                break;
        }
        setMoney(money);
    }

    public String Compare(String compare, Double value1) {
        Double money = getMoney();
        String answer = "";
//        if (!equals(value1)) {
//
//        } else {
//
//        }
        switch (compare) {
            case ">":
                answer = printMoney(value1) + " больше";
                if (money > value1)
                    answer = printMoney(money) + " больше";
                break;
            case "<":
                answer = printMoney(value1) + " меньше";
                if (money > value1)
                    answer = printMoney(money) + " меньше";
                break;
            case "==":
                answer = "Числа НЕ равны";
                if (equals(value1))
                    answer = "Числа равны";
                break;
            default:
                answer += unknownOperation;
                break;
        }
        return answer;
    }

    private boolean equals (Double money) {
        return getMoney() == money;
    }
}
