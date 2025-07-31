package Domain;

import java.util.Arrays;
import java.util.List;

public class LogicalOp {

    public int checkBiggerNumber(int a, int b) {
        if (a >= b) {
            return a;
        } else  {
            return b;
        }
    }

    public String isEvozon(String name){
        if (name.equals("Evozon")) {
            return "Learning text comparison";
        } else {
            return "Got to try some more";
        }
    }

    public String isEvozon_number(String name, int number){
        if (name.equals("Evozon") && number <= 3) {
            return name + number;
        } else if (!name.equals("Evozon") && number >= 4) {
            return number + name;
        }
        return "No match found";
    }

    public String ex6(int number){
        if (number >=8 || number == 6){
            return "The amount of snow this winter was " + number + "(cm)";
        }
        else
            return "The forecast snow is " + number + "(cm)";
    }

    public String ex7(int number){
        if (number >3 && number != 4){
            return "The number is greater than 3 and not equal to 4";
        }
        else if (number == 4){
            return "The number is equal to 4";
        }
        else {
            return "The number is lower than 3";
        }
    }

    public void ex8 (int number) {
        switch (number) {
            case 1:
                System.out.println("The number is: 1 !");
                break;
            case 2:
                System.out.println("The number is: 2 !");
                break;
            case 3:
                System.out.println("The number is: 3 !");
                break;
            case 4:
                System.out.println("The number is: 4 !");
                break;
            case 5:
                System.out.println("The number is: 5 !");
                break;
            case 6:
                System.out.println("The number is: 6 !");
                break;
            case 7:
                System.out.println("The number is: 7 !");
                break;
            case 8:
                System.out.println("The number is: 8 !");
                break;
            case 9:
                System.out.println("The number is: 9 !");
                break;
            case 0:
                System.out.println("The number is: 0 !");
            default:
                System.out.println("The number is not between 0 and 9 !");
                break;
        }
    }

    public String isNumberEven(int number) {
        if (number % 2 == 0) {
            return "true";
        } else {
            return "false";
        }
    }

    public String isMajor(int number){
        if (number >= 18) {
            return "true";
        } else {
            return "false";
        }
    }

    public int max_from_3 (int a, int b, int c){
        if (a >= b && a >= c) {
            return a;
        } else if (b >= a && b >= c) {
            return b;
        } else {
            return c;
        }
    }


    //////////////////////////////////////////////////////////
    ///                ARRAYS              //////////////////
    ////////////////////////////////////////////////////////



    public void populate_array() {
        int [] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
            System.out.println(arr[i]);
        }
    }

    public int[] populate_array_even(int[] arr){
        int j=0;
        for (int i=0; i<=100; i++){
            if(i % 2 == 0){
                arr[j] = i;
                j++;
            }
        }
        return arr;
    }


    public int avg_sum_array(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int avg = sum / arr.length;
        return avg;
    }


    public boolean exist(String name, String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(name)) {
                return true;
            }
        }
        return false;
    }

    public int where_number (int[] arr, int number) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                return i;
            }
        }
        return -1;
    }


    public void grid_array(){
        char[] gridArray = new char[100];
        Arrays.fill(gridArray, '-');
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int index = i * 10 + j;
                System.out.print(gridArray[index] + " ");
            }
            System.out.println();
        }

    }

    public  int[] remove_number(int[] arr, int num) {
        int n = arr.length;
        int i = 0;

        while (i < n) {
            if (arr[i] == num) {
                for (int j = i; j < n - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                n--;
            } else {
                i++;
            }
        }

        for (int k = n; k < arr.length; k++) {
            arr[k] = 0;
        }
        return arr;
    }

    public int second_smallest (int []arr){
        if (arr.length < 2) {
            return -1;
        }

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num < first) {
                second = first;
                first = num;
            } else if (num < second && num != first) {
                second = num;
            }
        }

        if (second != Integer.MAX_VALUE) {
            return second;
        } else {
            return -1;
        }
    }

    public void copy(int []arr, int []arr_copy){
        for (int i = 0; i < arr.length; i++) {
            arr_copy[i] = arr[i];
        }
    }

    //////////////////////////////////
    ///     LISTS      //////////////
    ////////////////////////////////

    public void print_list(List<?> list) {
        for (Object item : list) {
            System.out.println(item);
        }
    }

    public void add_first(List<Number> list, Number number) {
        list.addFirst(number);
    }

    public void print_from_index(List<?> list, int index) {
        if (index < 0 || index >= list.size()) {
            System.out.println("Invalid index: " + index);
            return;
        }

        for (int i = index; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public void print_from_last(List<?> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i));
        }
    }

    public void add_at_index(List<String> list, int index, String string) {
        if (index < 0 || index > list.size()) {
            System.out.println("Invalid index: " + index);
            return;
        }
        list.add(index, string);
    }


    public void add_at_begining(List<Object> list, Object object) {
        list.addFirst(object);
    }

    public void print_pos_and_value(List<?> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Position: " + i + ", Value: " + list.get(i));
        }
    }

    public void print_max (List<Integer> list){
        if (list.isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }

        int max = list.get(0);
        for (Integer number : list) {
            if (number > max) {
                max = number;
            }
        }
        System.out.println("The max is: " + max);
    }







}
