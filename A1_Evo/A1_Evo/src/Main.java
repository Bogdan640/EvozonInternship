
import Domain.Calculator;
import Domain.LogicalOp;

import java.util.*;

//
//public class Main {
//    public static void main(String[] args) {
//
//        Calculator calculator = new Calculator();
//
//        System.out.println("Hello");
//        System.out.println("Bogdan");
//        System.out.println(5+14);
//        System.out.println((float)10/4);
//        System.out.println(-5+8*6);
//        System.out.println((55+9) % 9);
//        System.out.println(20 + -3*5 / 8);
//        System.out.println(5 + 15 / 3 * 2 - 8 % 3);
//
//
//        e1(); calculator.sum(); calculator.divide(); calculator.e4(); calculator.e5(); calculator.e6(); calculator.e7();
//        print_model();
//        System.out.println(calculator.avg(1,2,3));
//        System.out.println(calculator.mod(11,2));
//        System.out.println(calculator.fahrengheit_to_celsius(35));
//        System.out.println(calculator.inch_to_meters(10));
//        calculator.calculate_speed(300000, 3, 30, 0);
//        calculator.circle();
//        LogicalOp op = new LogicalOp();
//        System.out.println(op.checkBiggerNumber(5, 10));
//        System.out.println(op.isEvozon("evozon"));
//        System.out.println(op.isEvozon_number("Evozon", 6));
//        System.out.println(op.ex6(8));
//        System.out.println(op.ex7(4));
//        op.ex8(5);
//        System.out.println(op.isNumberEven(3));
//        System.out.println(op.max_from_3(2,5,3));
//        calculator.count_to_100(1);
//        calculator.count_to_neg_100(-45);
//        calculator.count_between(1, 10);
//        calculator.count_by_verif(99, 66);
//        calculator.count_even();
//        calculator.count_odd();
//        System.out.println(calculator.sum_100(10));
//        System.out.println(calculator.average_100(10));
//        calculator.print_pattern();
//        calculator.countTo100(90);
//        calculator.countToNeg100(-50);
//        calculator.countBetween(1,6);
//        calculator.countVerif(6,1);
//        calculator.countEven();
//        calculator.countOdd();
//        calculator.sum_and_avg();
//        System.out.println(calculator.avg_div_7(1,100));
//        calculator.fib();
//        calculator.CozaLozaWoza();
//        calculator.e4();
//        calculator.e4(2, 8, 6);
//        calculator.e4(new int[]{-5, 8, 6});
//
//        calculator.e5();
//        calculator.e5(55, 9);
//        calculator.e5(new int[]{55, 9});
//
//        calculator.e6();
//        calculator.e6(20, -3, 5, 8);
//        calculator.e6(new int[]{20, -3, 5, 8});
//
//        calculator.e7();
//        calculator.e7(5, 15, 3);
//        calculator.e7(new int[]{5, 15, 3});
//
//        /// ///////////
//        /// ARRAYS ///
//        /////////////
//
//        System.out.println(calculator.add(10, 20));
//        System.out.println(calculator.add(10, 20, 30));
//        System.out.println(calculator.add(new int[]{1, 2, 3}));
//
//        System.out.println(calculator.sub(50, 10));
//        System.out.println(calculator.sub(100, 20, 5));
//        System.out.println(calculator.sub(new int[]{50, 10, 5}));
//
//        System.out.println(calculator.mul(5, 6));
//        System.out.println(calculator.mul(2, 3, 4));
//        System.out.println(calculator.mul(new int[]{2, 3, 4}));
//
//        System.out.println(calculator.div(100, 5));
//        System.out.println(calculator.div(100, 2, 5));
//        System.out.println(calculator.div(new int[]{100, 2, 5}));
//
//        System.out.println(calculator.avg(10, 20, 30));
//        System.out.println(calculator.avg(10, 20, 30, 40));
//        System.out.println(calculator.avg(new int[]{10, 20, 30}));
//
//        System.out.println(calculator.mod(10, 3));
//        System.out.println(calculator.mod(100, 3, 2));
//        System.out.println(calculator.mod(new int[]{100, 3, 2}));
//
//        System.out.println(calculator.fahrengheit_to_celsius(68));
//        System.out.println(calculator.fahrengheit_to_celsius(new float[]{68, 77}));
//
//        System.out.println(calculator.inch_to_meters(10));
//        System.out.println(calculator.inch_to_meters(10.5));
//        System.out.println(calculator.inch_to_meters(new int[]{10, 20}));
//
//        calculator.calculate_speed(10000, 1, 30, 0);
//        calculator.calculate_speed(10000, 1.5);
//        calculator.calculate_speed(new double[]{10000, 5000}, 1.5);
//
//        calculator.circle(10.0f);
//        calculator.circle(new float[]{5.0f, 10.0f});
//
//        calculator.count_to_100(95);
//        calculator.count_to_100();
//        calculator.count_to_100(new int[]{90, 98});
//
//        calculator.count_to_neg_100(-5);
//        calculator.count_to_neg_100();
//        calculator.count_to_neg_100(new int[]{-5, -10});
//
//        calculator.count_between(5, 10);
//        calculator.count_by_verif(10, 5);
//
//
//        System.out.println(calculator.sum_100(95));
//        System.out.println(calculator.average_100(95));
//
//        calculator.countTo100(97);
//        calculator.countToNeg100(-97);
//
//        /// ARRAYS EX 2:
//        op.populate_array();
//        int [] arr1 = new int[51];
//        arr1 = op.populate_array_even(arr1);
//        for (int i = 0; i < arr1.length; i++) {
//            System.out.print(arr1[i] + " ");
//        }
//        System.out.println();
//        System.out.println(op.avg_sum_array(arr1));
//        String [] str = {"a", "b", "c", "d"};
//        System.out.println(op.exist( "t", str));
//        int []arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        System.out.println(op.where_number(arr, 5) );
//        op.grid_array();
//        op.remove_number(arr, 2);
//        for (int num : arr) {
//            System.out.print(num + " ");
//        }
//        System.out.println();
//        System.out.println(op.second_smallest(arr));
//        int []arr_copy = new int[arr.length];
//        op.copy(arr, arr_copy);
//        for(var num : arr_copy) {
//            System.out.print(num + " ");
//        }
//
//        /// //////////
//        /// LISTS ///
//        /////////////
        //1.
//        System.out.println();
//        System.out.println("Lists : 1.");
//        System.out.println();
//
//        List<Object> list = Arrays.asList("Ana", 8, true, 3.14, 'c', "Evozon");
//        op.print_list(list);
//
//        //2.
//        System.out.println();
//        System.out.println("Lists : 2.");
//        System.out.println();
//
//
//        List<Number> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
//        op.add_first(numbers, 10);
//        for (Number number : numbers) {
//            System.out.print(number + " ");
//        }
//
//        //3.
//        System.out.println();
//        System.out.println("\nLists : 3.");
//        System.out.println();
//
//        op.print_from_index(list,1);
//
//        //4.
//        System.out.println();
//        System.out.println("Lists : 4.");
//        System.out.println();
//
//        op.print_from_last(list);
//
//        //5.
//        System.out.println();
//        System.out.println("Lists : 5.");
//        System.out.println();
//        List<String> strings = new ArrayList<>(Arrays.asList("Ana", "Javra", "castravete", "Tecuci"));
//        op.add_at_index(strings, 2, "perisoare");
//        for (String str : strings) {
//            System.out.print(str + " ");
//        }
//
//        //6.
//        System.out.println();
//        System.out.println("\nLists : 6.");
//        System.out.println();
//        List<Object> object_list = new ArrayList<>(Arrays.asList("Ana", 8, true, 3.14, 'c', "Evozon"));
//        op.add_at_begining(object_list, "Cheloo");
//        for (Object item : object_list) {
//            System.out.print(item + " ");
//        }
//
//        //7.
//        System.out.println();
//        System.out.println("\nLists : 7.");
//        System.out.println();
//
//        op.print_pos_and_value(object_list);
//
//        //8.
//        System.out.println();
//        System.out.println("Lists : 8.");
//        System.out.println();
//        List<Integer> integer_list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
//        op.print_max(integer_list);

//
//
//
//
//
//    }
//
//    public static void e1(){
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Hey, what's your name?");
//        String name = sc.nextLine();
//        System.out.println("Hello " + name + "!");
//    }
//
//
//
//
//
//
//    public static void print_model() {
//        System.out.println(" +\"\"\"\"\"+");
//        System.out.println("[| o o |]");
//        System.out.println(" |  ^  |");
//        System.out.println(" | '-' |");
//        System.out.println(" +-----+");
//    }
////
//
//}


import Domain.Calculator;
import Domain.LogicalOp;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        LogicalOp op = new LogicalOp();

        System.out.println();
        System.out.println("Assignment 1 : 1.");
        System.out.println();


        calculator.Hello_user();
        calculator.Hello_user("Bogdan");
        calculator.Hello_user(new String[]{"Bogdan", "Ana", "Maria"});


        calculator.sum();
        calculator.sum(5, 10);
        calculator.sum(new int[]{1, 2, 3, 4});


        calculator.divide();
        calculator.divide(20, 4);
        calculator.divide(new int[]{100, 2, 5});


        calculator.e4();
        calculator.e4(5, 8, 6);
        calculator.e4(new int[]{5, 8, 6});


        calculator.e5();
        calculator.e5(55, 9);
        calculator.e5(new int[]{55, 9});


        calculator.e6();
        calculator.e6(20, -3, 5, 8);
        calculator.e6(new int[]{20, -3, 5, 8});


        calculator.e7();
        calculator.e7(5, 15, 3);
        calculator.e7(new int[]{5, 15, 3});


        System.out.println();
        System.out.println("Assignment 1 : 2.");
        System.out.println();

        System.out.println(calculator.add(2, 3));
        System.out.println(calculator.add(2, 3, 4));
        System.out.println(calculator.add(new int[]{1, 2, 3}));


        System.out.println(calculator.sub(10, 3));
        System.out.println(calculator.sub(20, 5, 2));
        System.out.println(calculator.sub(new int[]{20, 5, 2}));


        System.out.println(calculator.mul(2, 3));
        System.out.println(calculator.mul(2, 3, 4));
        System.out.println(calculator.mul(new int[]{2, 3, 4}));


        System.out.println(calculator.div(20, 2));
        System.out.println(calculator.div(100, 5, 2));
        System.out.println(calculator.div(new int[]{100, 2, 5}));

        System.out.println();
        System.out.println("Assignment 1 : 3.");
        System.out.println();

        print_model();

        System.out.println();
        System.out.println("Assignment 1 : 4.");
        System.out.println();

        System.out.println(calculator.avg(3, 6, 9));
        System.out.println(calculator.avg(4, 6, 8, 10));
        System.out.println(calculator.avg(new int[]{1, 2, 3, 4}));

        System.out.println();
        System.out.println("Assignment 1 : 5.");
        System.out.println();


        System.out.println(calculator.mod(10, 3));
        System.out.println(calculator.mod(100, 30, 5));
        System.out.println(calculator.mod(new int[]{100, 30, 5}));




        System.out.println();
        System.out.println("Assignment 1 : 6.");
        System.out.println();

        System.out.println(calculator.fahrengheit_to_celsius(98));
        System.out.println(calculator.fahrengheit_to_celsius(new float[]{98.6f, 100f}));

        System.out.println();
        System.out.println("Assignment 1 : 7.");
        System.out.println();


        System.out.println(calculator.inch_to_meters(10));
        System.out.println(calculator.inch_to_meters(25.4));
        System.out.println(calculator.inch_to_meters(new int[]{10, 20}));

        System.out.println();
        System.out.println("Assignment 1 : 8.");
        System.out.println();


        calculator.calculate_speed(1000, 0, 2, 30);
        calculator.calculate_speed(1000, 0.0417);
        calculator.calculate_speed(new double[]{1000, 2000}, 0.0417);

        System.out.println();
        System.out.println("Assignment 1 : 9.");
        System.out.println();

        calculator.circle();
        calculator.circle(5);
        calculator.circle(new float[]{3, 4, 5});


        System.out.println();
        System.out.println("Assignment 2 : 3");
        System.out.println();

        System.out.println(op.checkBiggerNumber(10, 5));
        System.out.println(op.checkBiggerNumber(3, 7));

        System.out.println();
        System.out.println("Assignment 2 : 4");
        System.out.println();

        System.out.println(op.isEvozon("Evozon"));
        System.out.println(op.isEvozon("evozon"));

        System.out.println();
        System.out.println("Assignment 2 : 5");
        System.out.println();

        System.out.println(op.isEvozon_number("Evozon", 2));
        System.out.println(op.isEvozon_number("evozon", 5));
        System.out.println(op.isEvozon_number("covrig", 3));

        System.out.println();
        System.out.println("Assignment 2 : 6");
        System.out.println();

        System.out.println(op.ex6(10));
        System.out.println(op.ex6(4));


        System.out.println();
        System.out.println("Assignment 2 : 7");
        System.out.println();

        System.out.println(op.ex7(5));
        System.out.println(op.ex7(4));
        System.out.println(op.ex7(2));

        System.out.println();
        System.out.println("Assignment 2 : 8");
        System.out.println();

        op.ex8(4);
        op.ex8(10);

        System.out.println();
        System.out.println("Assignment 2 : 9");
        System.out.println();

        System.out.println(op.isNumberEven(4));
        System.out.println(op.isNumberEven(7));

        System.out.println();
        System.out.println("Assignment 2 : 10");
        System.out.println();

        System.out.println(op.isMajor(20));
        System.out.println(op.isMajor(17));

        System.out.println();
        System.out.println("Assignment 2 : 11");
        System.out.println();

        System.out.println(op.max_from_3(3, 7, 5));
        System.out.println(op.max_from_3(9, 1, 4));


        System.out.println();
        System.out.println("For loops : 1");
        System.out.println();

        calculator.count_to_100();
        calculator.count_to_100(95);
        calculator.count_to_100(new int[]{97, 98});

        System.out.println();
        System.out.println("For loops : 2");
        System.out.println();

        calculator.count_to_neg_100();
        calculator.count_to_neg_100(-95);
        calculator.count_to_neg_100(new int[]{-90, -85});

        System.out.println();
        System.out.println("For loops : 3");
        System.out.println();


        calculator.count_between(90, 100);
        calculator.count_between(100, 105);

        System.out.println();
        System.out.println("For loops : 4");
        System.out.println();

        calculator.count_by_verif(105, 100);
        calculator.count_by_verif(90, 95);

        System.out.println();
        System.out.println("For loops : 5");
        System.out.println();

        calculator.count_even();

        System.out.println();
        System.out.println("For loops : 6");
        System.out.println();

        calculator.count_odd();

        System.out.println();
        System.out.println("For loops : 7");
        System.out.println();


        System.out.println(calculator.sum_100(90));
        System.out.println(calculator.sum_100(100));

        System.out.println();
        System.out.println("For loops : 8");
        System.out.println();


        System.out.println(calculator.average_100(90));
        System.out.println(calculator.average_100(100));

        System.out.println();
        System.out.println("For loops : 9");
        System.out.println();


        calculator.print_pattern();



        System.out.println();
        System.out.println("While loop : 1");
        System.out.println();

        calculator.countTo100(95);

        System.out.println();
        System.out.println("While loop : 2");
        System.out.println();


        calculator.countToNeg100(-90);

        System.out.println();
        System.out.println("While loop : 3");
        System.out.println();


        calculator.countBetween(90, 95);

        System.out.println();
        System.out.println("While loop : 4");
        System.out.println();

        calculator.countVerif(105, 100);
        calculator.countVerif(90, 95);

        System.out.println();
        System.out.println("While loop : 5");
        System.out.println();

        calculator.countEven();

        System.out.println();
        System.out.println("While loop : 6");
        System.out.println();


        calculator.countOdd();

        System.out.println();
        System.out.println("While loop : 7");
        System.out.println();

        calculator.sum_and_avg();

        System.out.println();
        System.out.println("While loop : 8");
        System.out.println();

        System.out.println(calculator.avg_div_7(1, 100));

        System.out.println();
        System.out.println("While loop : 9");
        System.out.println();

        calculator.fib();

        System.out.println();
        System.out.println("While loop : 10");
        System.out.println();

        calculator.CozaLozaWoza();



        System.out.println();
        System.out.println("Arrays : 1");
        System.out.println();

        op.populate_array();


        System.out.println();
        System.out.println("Arrays : 2");
        System.out.println();

        int[] array = new int[51];
        op.populate_array_even(array);
        for (int val : array) {
            System.out.print(val + " ");
        }
        System.out.println();

        System.out.println();
        System.out.println("Arrays : 3");
        System.out.println();

        System.out.println();
        System.out.println("Arrays : 4");
        System.out.println();

        System.out.println(op.avg_sum_array(array));

        System.out.println();
        System.out.println("Arrays : 5");
        System.out.println();

        String[] stringArray = {"a", "b", "c", "d"};
        System.out.println(op.exist("t", stringArray));

        System.out.println();
        System.out.println("Arrays : 6");
        System.out.println();

        int[] numberArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(op.where_number(numberArray, 5));

        System.out.println();
        System.out.println("Arrays : 7");
        System.out.println();

        op.grid_array();

        System.out.println();
        System.out.println("Arrays : 8");
        System.out.println();

        op.remove_number(numberArray, 2);
        for (int val : numberArray) {
            System.out.print(val + " ");
        }
        System.out.println();

        System.out.println();
        System.out.println("Arrays : 9");
        System.out.println();

        System.out.println(op.second_smallest(numberArray));

        System.out.println();
        System.out.println("Arrays : 10");
        System.out.println();

        int[] copyArray = new int[numberArray.length];
        op.copy(numberArray, copyArray);
        for (int val : copyArray) {
            System.out.print(val + " ");
        }
        System.out.println();



        //1.
        System.out.println();
        System.out.println("Lists : 1.");
        System.out.println();

        List<Object> list = Arrays.asList("Ana", 8, true, 3.14, 'c', "Evozon");
        op.print_list(list);

//2.
        System.out.println();
        System.out.println("Lists : 2.");
        System.out.println();


        List<Number> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        op.add_first(numbers, 10);
        for (Number number : numbers) {
            System.out.print(number + " ");
        }

//3.
        System.out.println();
        System.out.println("\nLists : 3.");
        System.out.println();

        op.print_from_index(list,1);

//4.
        System.out.println();
        System.out.println("Lists : 4.");
        System.out.println();

        op.print_from_last(list);

//5.
        System.out.println();
        System.out.println("Lists : 5.");
        System.out.println();
        List<String> strings = new ArrayList<>(Arrays.asList("Ana", "Javra", "castravete", "Tecuci"));
        op.add_at_index(strings, 2, "perisoare");
        for (String str : strings) {
            System.out.print(str + " ");
        }

//6.
        System.out.println();
        System.out.println("\nLists : 6.");
        System.out.println();
        List<Object> object_list = new ArrayList<>(Arrays.asList("Ana", 8, true, 3.14, 'c', "Evozon"));
        op.add_at_begining(object_list, "Cheloo");
        for (Object item : object_list) {
            System.out.print(item + " ");
        }

//7.
        System.out.println();
        System.out.println("\nLists : 7.");
        System.out.println();

        op.print_pos_and_value(object_list);

//8.
        System.out.println();
        System.out.println("Lists : 8.");
        System.out.println();
        List<Integer> integer_list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        op.print_max(integer_list);


    }


    public static void print_model() {
        System.out.println(" +\"\"\"\"\"+");
        System.out.println("[| o o |]");
        System.out.println(" |  ^  |");
        System.out.println(" | '-' |");
        System.out.println(" +-----+");








    }
}

