package com.company;
import java.util.Scanner;

///Создание простой дроби (с заданным числителем и знаменателем)
//Создание простой дроби по умолчанию (числитель 1, знаменатель 1)
///Операция сложения (2 варианта: в первом - функция возвращает результат сложения двух дробей, указанных как аргументы, во втором - аргумент только один)
//Операция вычитания (2 варианта: в первом - функция возвращает результат вычитания двух дробей, указанных как аргументы, во втором - аргумент только один)
//Операция умножения (2 варианта: в первом - функция возвращает результат умножения двух дробей, указанных как аргументы, во втором - аргумент только один)
//Операция деления (2 варианта: в первом - функция возвращает результат деления двух дробей, указанных как аргументы, во втором - аргумент только один)
public class Fraction {
    protected int numerator;
    protected int denominator;

    public Fraction(int num, int den){
        this.numerator = num/gcd(num, den);
        this.denominator = den/gcd(num, den);
    }
    public Fraction(){
        this.numerator = 1;
        this.denominator = 1;
    }

    public static int gcd(int numerator, int denominator) { //greatest common divisor - gcd
        while (denominator != 0) {
            int temp = denominator;
            denominator = numerator % denominator;
            numerator = temp;
        }
        return numerator;
    }

    public static int lcm(int numerator, int denominator) { //least common multiple - lcm
        return numerator / gcd(numerator, denominator) * denominator;
    }


    public static Fraction sum(Fraction firstFraction, Fraction secondFraction){ //Summation or addition
        int rDenominator = lcm(firstFraction.denominator, secondFraction.denominator);
        int rNumerator = firstFraction.numerator * (rDenominator / firstFraction.denominator) +
                secondFraction.numerator * (rDenominator / secondFraction.denominator);

        return new Fraction(rNumerator, rDenominator);
    }

    public static Fraction sub(Fraction firstFraction, Fraction secondFraction){ //Subtraction
        int rDenominator = lcm(firstFraction.denominator, secondFraction.denominator);
        int rNumerator = firstFraction.numerator * (rDenominator /firstFraction.denominator) -
                secondFraction.numerator * (rDenominator / secondFraction.denominator);
        return new Fraction(rNumerator, rDenominator);
    }

    public static Fraction multi(Fraction firstFraction, Fraction secondFraction){ //Multiplication
        int rNumerator = firstFraction.numerator * secondFraction.numerator;
        int rDenominator = firstFraction.denominator * secondFraction.denominator;
        return new Fraction(rNumerator, rDenominator);
    }

    public static Fraction div(Fraction firstFraction, Fraction secondFraction){ //Division
        int rNumerator = firstFraction.numerator * secondFraction.denominator;
        int rDenominator = firstFraction.denominator * secondFraction.numerator;
        return new Fraction(rNumerator, rDenominator);
    }

    public Fraction sum(Fraction secondFraction){
        int rDenominator = lcm(denominator, secondFraction.denominator);
        int rNumerator = numerator * (rDenominator /denominator) +
                secondFraction.numerator * (rDenominator / secondFraction.denominator);
        return new Fraction(rNumerator, rDenominator);
    }

    public Fraction sub(Fraction secondFraction){
        int rDenominator = lcm(denominator, secondFraction.denominator);
        int rNumerator = numerator * (rDenominator /denominator) -
                secondFraction.numerator * (rDenominator / secondFraction.denominator);
        return new Fraction(rNumerator, rDenominator);
    }

    public Fraction multi(Fraction secondFraction){
        int rNumerator = numerator * secondFraction.numerator;
        int rDenominator = denominator * secondFraction.denominator;
        return new Fraction(rNumerator, rDenominator);
    }

    public Fraction div(Fraction secondFraction){
        int rNumerator = numerator * secondFraction.denominator;
        int rDenominator = denominator * secondFraction.numerator;
        return new Fraction(rNumerator, rDenominator);
    }

    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(System.in);

        System.out.println("Введите числитель первой дроби:");
        if ((in.hasNext("0")) || (!in.hasNextInt())){
            System.out.println("Ожидалось целое число или отсутствие 0");
            throw new Exception();
        }
        int numerator1 = in.nextInt();

        System.out.println("Введите знаменатель первой дроби:");
        if ((in.hasNext("0")) || (!in.hasNextInt())){
            System.out.println("Ожидалось целое число или отсутствие 0");
            throw new Exception();
        }
        int denominator1 = in.nextInt();

        System.out.println("Введите числитель второй дроби:");
        if ((in.hasNext("0")) || (!in.hasNextInt())){
            System.out.println("Ожидалось целое число или отсутствие 0");
            throw new Exception();
        }
        int numerator2 = in.nextInt();

        System.out.println("Введите знаменатель второй дроби:");
        if ((in.hasNext("0")) || (!in.hasNextInt())){
            System.out.println("Ожидалось целое число или отсутствие 0");
            throw new Exception();
        }
        int denominator2 = in.nextInt();

        Fraction firstFraction = new Fraction(numerator1,denominator1);
        Fraction secondFraction = new Fraction(numerator2, denominator2);
        Fraction resultFraction;

        if (numerator1 < 0 && denominator1 < 0){
            numerator1 *= -1;
            denominator1 *= -1;
        } if (numerator2 < 0 && denominator2 < 0){
            numerator2 *= -1;
            denominator2 *= -1;
        }

        resultFraction = sum(firstFraction, secondFraction);
        System.out.println("Сумма дробей = "+resultFraction.numerator+"/"+resultFraction.denominator);

        resultFraction = sub(firstFraction, secondFraction);
        System.out.println("Разность дробей = "+resultFraction.numerator+"/"+resultFraction.denominator);

        resultFraction = multi(firstFraction, secondFraction);
        System.out.println("Произведение дробей = "+resultFraction.numerator+"/"+resultFraction.denominator);

        resultFraction = div(firstFraction, secondFraction);
        System.out.println("Частное дробей = "+resultFraction.numerator+"/"+resultFraction.denominator);

        resultFraction = firstFraction.sum(secondFraction);
        System.out.println("Сумма дробей = (1 аргумент) "+resultFraction.numerator+"/"+resultFraction.denominator);

        resultFraction = firstFraction.sub(secondFraction);
        System.out.println("Разность дробей (1 аргумент) = "+resultFraction.numerator+"/"+resultFraction.denominator);

        resultFraction = firstFraction.multi(secondFraction);
        System.out.println("Произведение дробей (1 аргумент) = "+resultFraction.numerator+"/"+resultFraction.denominator);

        resultFraction = firstFraction.div(secondFraction);
        System.out.println("Частное дробей (1 аргумент) = "+resultFraction.numerator+"/"+resultFraction.denominator);
        in.close();
    }
}