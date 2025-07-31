package Domain;

import java.util.Scanner;

public class Calculator {

    public void Hello_user() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hey, what's your name?");
        String name = sc.nextLine();
        System.out.println("Hello " + name + "!");
    }

    public void Hello_user(String name) {
        System.out.println("Hello " + name + "!");
    }

    public void Hello_user(String[] names) {
        for (String name : names) {
            System.out.println("Hello " + name + "!");
        }
    }

    public void sum() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two numbers for the pattern a + b = ? :");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(a + b);
    }

    public void sum(int a, int b) {
        System.out.println(a + " + " + b + " = " + (a + b));
    }

    public void sum(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        System.out.println("Sum of array: " + sum);
    }

    public void divide() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two numbers for the pattern a / b = ? :");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println((float)a / b);
    }

    public void divide(int a, int b) {
        System.out.println(a + " / " + b + " = " + ((float)a / b));
    }

    public void divide(int[] numbers) {
        if (numbers.length >= 2) {
            float result = (float)numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                result /= numbers[i];
            }
            System.out.println("Division result: " + result);
        }
    }

    public void e4() {
        System.out.println(-5 + 8 * 6);
    }

    public void e4(int a, int b, int c) {
        System.out.println(a + " + " + b * 6 +  " = " + (a + b * c));
    }

    public void e4(int[] values) {
        if (values.length >= 3) {
            System.out.println(values[0] + " + " + values[1] * values[2] + " = " + (values[0] + values[1] * values[2]));
        }
    }

    public void e5() {
        System.out.println((55 + 9) % 9);
    }

    public void e5(int a, int b) {
        System.out.println("(" + a + " + " + b + ") % " + b + " = " + ((a + b) % b));
    }

    public void e5(int[] values) {
        if (values.length >= 2) {
            System.out.println("(" + values[0] + " + " + values[1] + ") % " + values[1] + " = " +
                    ((values[0] + values[1]) % values[1]));
        }
    }

    public void e6() {
        System.out.println(20 + -3 * 5 / 8);
    }

    public void e6(int a, int b, int c, int d) {
        System.out.println(a + " + " + b + " * " + c + d + " = " + (a + b * c / d));
    }

    public void e6(int[] values) {
        if (values.length >= 4) {
            System.out.println(values[0] + " + " + values[1] + " * " + values[2] + " / " +values[3] +" = " +
                    (values[0] + values[1] * values[2] / values[3]));
        }
    }

    public void e7() {
        System.out.println(5 + 15 / 3 * 2 - 8 % 3);
    }

    public void e7(int a, int b, int c) {
        System.out.println(a + " + " + b + " / " + c + " * 2 - 8 % 3 = " +
                (a + b / c * 2 - 8 % 3));
    }

    public void e7(int[] values) {
        if (values.length >= 3) {
            System.out.println(values[0] + " + " + values[1] + " / " + values[2] + " * 2 - 8 % 3 = " +
                    (values[0] + values[1] / values[2] * 2 - 8 % 3));
        }
    }

    public long add(int a, int b) {
        return a + b;
    }

    public long add(int a, int b, int c) {
        return a + b + c;
    }

    public long add(int[] numbers) {
        long sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    public long sub(int a, int b) {
        return a - b;
    }

    public long sub(int a, int b, int c) {
        return a - b - c;
    }

    public long sub(int[] numbers) {
        if (numbers.length == 0)
            return 0;
        long result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result -= numbers[i];
        }
        return result;
    }

    public long mul(int a, int b) {
        return (long) a * b;
    }

    public long mul(int a, int b, int c) {
        return (long) a * b * c;
    }

    public long mul(int[] numbers) {
        if (numbers.length == 0)
            return 0;
        long result = 1;
        for (int num : numbers) {
            result *= num;
        }
        return result;
    }

    public long div(int a, int b) {
        return a / b;
    }

    public long div(int a, int b, int c) {
        return a / b / c;
    }

    public double div(int[] numbers) {
        if (numbers.length == 0)
            return 0;
        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] != 0) {
                result /= numbers[i];
            }
        }
        return result;
    }

    public int avg(int a, int b, int c) {
        return (a + b + c) / 3;
    }

    public int avg(int a, int b, int c, int d) {
        return (a + b + c + d) / 4;
    }

    public double avg(int[] numbers) {
        if (numbers.length == 0)
            return 0;
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return (double) sum / numbers.length;
    }

    public int mod(int a, int b) {
        return (a % b);
    }

    public int mod(int a, int b, int c) {
        return (a % b % c);
    }

    public int mod(int[] numbers) {
        if (numbers.length < 2)
            return 0;
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] != 0) {
                result %= numbers[i];
            }
        }
        return result;
    }

    public  float fahrengheit_to_celsius(int fahrenheit) {
        return  (float) 5 / 9 * (fahrenheit - 32) ;
    }
    public float fahrengheit_to_celsius(float[] fahrenheit) {
        float sum = 0;
        for (float f : fahrenheit) {
            sum += (5f / 9f * (f - 32));
        }
        return sum;
    }

    public  float inch_to_meters(int inch) {
        return (float) (inch * 0.0254);
    }

    public float inch_to_meters(double inch) {
        return (float) (inch * 0.0254);
    }

    public float inch_to_meters(int[] inches) {
        float totalMeters = 0;
        for (int inch : inches) {
            totalMeters += inch * 0.0254;
        }
        return totalMeters;
    }

    public  void calculate_speed(double distance, int hours, int minutes, int seconds) {
        double time_in_sec = hours * 3600 + minutes * 60 + seconds;
        double mps = distance / time_in_sec;
        double kph = mps * 3.6;
        double mph = mps * 3600 / 1609;
        System.out.println(" meters/second: " + mps);
        System.out.println(" km/h: " + kph);
        System.out.println(" miles/hour: " + mph);
    }


    public void calculate_speed(double distance, double totalHours) {
        double time_in_sec = totalHours * 3600;
        double mps = distance / time_in_sec;
        double kph = mps * 3.6;
        double mph = mps * 3600 / 1609;
        System.out.println(" meters/second: " + mps);
        System.out.println(" km/h: " + kph);
        System.out.println(" miles/hour: " + mph);
    }

    public void calculate_speed(double[] distances, double totalHours) {
        for (double distance : distances) {
            double time_in_sec = totalHours * 3600;
            double mps = distance / time_in_sec;
            double kph = mps * 3.6;
            double mph = mps * 3600 / 1609;
            System.out.println("Distance: " + distance);
            System.out.println(" meters/second: " + mps);
            System.out.println(" km/h: " + kph);
            System.out.println(" miles/hour: " + mph);
        }
    }



    public  void circle(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the radius of the circle:");
        float radius = sc.nextFloat();
        double   area = Math.PI * radius * radius;
        double circumference = 2 * Math.PI * radius;
        System.out.println("Area: " + area);
        System.out.println("Circumference: " + circumference);
    }

    public void circle(float radius) {
        double area = Math.PI * radius * radius;
        double circumference = 2 * Math.PI * radius;
        System.out.println("Area: " + area);
        System.out.println("Circumference: " + circumference);
    }

    public void circle(float[] radii) {
        for (float radius : radii) {
            double area = Math.PI * radius * radius;
            double circumference = 2 * Math.PI * radius;
            System.out.println("Radius: " + radius);
            System.out.println("Area: " + area);
            System.out.println("Circumference: " + circumference);
        }
    }


    public void count_to_100(int number) {
        for (int i = number; i <= 100; i++) {
            System.out.println(i);
        }
    }


    public void count_to_100() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(i);
        }
    }

    public void count_to_100(int[] starting_points) {
        for (int start : starting_points) {
            for (int i = start; i <= 100; i++) {
                System.out.println(i);
            }
        }
    }

    public void count_to_neg_100(int number) {
        for (int i = number; i >= -100; i--) {
            System.out.println(i);
        }
    }

    public void count_to_neg_100() {
        for (int i = 0; i >= -100; i--) {
            System.out.println(i);
        }
    }

    public void count_to_neg_100(int[] starting_points) {
        for (int start : starting_points) {
            for (int i = start; i >= -100; i--) {
                System.out.println(i);
            }
        }
    }

    //Cam pe aici m am prins ca trebuia facut overloading numai la alea cu operatiile de baza (sper) :(

    public void count_between(int x, int y) {
        for (int i = x; i <= y; i++) {
            System.out.println(i);
        }
    }

    public void count_by_verif(int x, int y) {
        if (x > y) {
            for (int i = y; i <= x; i++) {
                System.out.println(i);
            }
        } else {
            for (int i = x; i <= y; i++) {
                System.out.println(i);
            }
        }
    }

    public void count_even() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

    public void count_odd() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
    }

    public int sum_100(int number) {
        int sum = 0;
        for (int i = number; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }

    public float average_100(int number) {
        int sum = 0;
        int count = 0;
        for (int i = number; i <= 100; i++) {
            sum += i;
            count++;
        }
        return (float) sum / count;
    }

    public void print_pattern() {
        for (int i = 0; i < 7; i++) {
            for (int j = 7; j > i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }




    public void countTo100(int number) {
        for (int i = number; i <= 100; i++) {
            System.out.println(i);
        }
    }

    public void countToNeg100(int number) {
        for (int i = number; i >= -100; i--) {
            System.out.println(i);
        }
    }

    public void countBetween(int x, int y) {
        for (int i = x; i <= y; i++) {
            System.out.println(i);
        }
    }

    public void countVerif(int x, int y) {
        if (x > y) {
            for (int i = y; i <= x; i++) {
                System.out.println(i);
            }
        } else {
            for (int i = x; i <= y; i++) {
                System.out.println(i);
            }
        }
    }

    public void countEven() {
        for (int i = 2; i <= 100; i += 2) {
            System.out.println(i);
        }
    }

    public void countOdd() {
        for (int i = 1; i <= 100; i += 2) {
            System.out.println(i);
        }
    }

    public void sum_and_avg() {
        int sum = 0;
        int count = 0;
        for (int i = 111; i <= 8899; i++) {
            sum += i;
            count++;
        }
        System.out.println("Sum is: " + sum);
        float average = (float) sum / count;
        System.out.println("Avg is: " + average);
    }

    public float avg_div_7(int x, int y) {
        int sum = 0;
        int count = 0;
        for (int i = x; i <= y; i++) {
            if (i % 7 == 0) {
                sum += i;
                count++;
            }
        }
        return (float) sum / count;
    }

    public void fib() {
        int fisrt = 0;
        int second = 1;
        System.out.print(fisrt + " " + second + " ");

        for (int i = 2; i < 20; i++) {
            int next = fisrt + second;
            System.out.print(next + " ");
            fisrt = second;
            second = next;
        }
        System.out.println();
    }

    public void CozaLozaWoza() {
        for (int i = 1; i <= 110; i++) {
            String output = "";
            if (i % 3 == 0) {
                output += "Coza";
            }
            if (i % 5 == 0) {
                output += "Loza";
            }
            if (i % 7 == 0) {
                output += "Woza";
            }

            if (output.isEmpty()) {
                System.out.print(i);
            } else {
                System.out.print(output);
            }

            if (i % 11 == 0) {
                System.out.println();
            } else {
                System.out.print(" ");
            }
        }
    }

}
