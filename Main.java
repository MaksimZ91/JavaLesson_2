package org.example;

public class Main {
    public static void main(String[] args) {
        //Напишите программу, чтобы найти вхождение в строке (содержащей все символы другой строки).
        String str1 = "Строка — объект, что представляет последовательность символов.";
        String str2 = "Строка — объект";
        System.out.println(str1.contains(str2));

        //Напишите программу, чтобы проверить, являются ли две данные строки вращением друг друга (вхождение в обратном порядке).
        String str3 = "строка";
        String str4 = "акортс";
        System.out.println(stringReversAndCheckContains(str3, str4));

        //*Напишите программу, чтобы перевернуть строку с помощью рекурсии.
        System.out.println(revers(str3, str3.length()-1));

        //Дано два числа, например 3 и 56, необходимо составить следующие строки: 3 + 56 = 59 3 – 56 = -53 3 * 56 = 168 Используем метод StringBuilder.append().
        int a = 3;
        int b = 56;
        StringBuilder sum = new StringBuilder().append(a).append("+").append(b).append("=").append(a+b);
        StringBuilder dif = new StringBuilder().append(a).append("-").append(b).append("=").append(a-b);
        StringBuilder mult = new StringBuilder().append(a).append("*").append(b).append("=").append(a*b);
        System.out.println(sum);
        System.out.println(dif);
        System.out.println(mult);
        StringBuilder [] math = {sum, dif, mult};

        //Замените символ “=” на слово “равно”. Используйте методы StringBuilder.insert(),StringBuilder.deleteCharAt().
        replaceFirstMethod(math);

        //Замените символ “=” на слово “равно”. Используйте методы StringBuilder.replace().
        //replaceSecondMethod(math);
        System.out.println(sum);
        System.out.println(dif);
        System.out.println(mult);

        //**Сравнить время выполнения пунка 6 со строкой содержащей 10000 символов "=" средствами String и StringBuilder.
        String newStr = "=".repeat(10000);

        long start = System.currentTimeMillis();
        String resultString = replaceStringMethod(newStr);
        long end = System.currentTimeMillis();
        System.out.printf("Время выполнения с помощью методов String: %d \n", end-start);

        StringBuilder str5 = new StringBuilder(newStr);

        long start2 = System.currentTimeMillis();
        replaceStringBuilderMethod(str5, str5.length()-1);
        long end2 = System.currentTimeMillis();
        System.out.printf("Время выполнения с помощью методов StringBuilder: %d\n", end2-start2);

    }

    private static boolean stringReversAndCheckContains(String str1, String str2){
        StringBuilder builder = new StringBuilder(str2);
        return str1.equals(builder.reverse().toString());
    }

    private static String revers(String str, int stringLength){
        if (stringLength == 0){
            return str.charAt(0) + "";
        }
        char buff = str.charAt(stringLength);
        return   buff + revers(str, stringLength-1);
    }

    private static void replaceFirstMethod(StringBuilder[] args){
        for (int i = 0; i <= args.length-1; i++){
            args[i].deleteCharAt(4).insert(4, " равно ");
        }
    }
    private static void replaceSecondMethod(StringBuilder[] args){
        for (int i = 0; i <= args.length-1; i++){
            args[i].replace(4, 5, " равно ");
        }
    }

    private static String replaceStringMethod(String str){
        return  str.replace("=", "равно");
    }

    private static void replaceStringBuilderMethod(StringBuilder str, int count){

        for (int i = 0, j=0; i <= count; i++, j+=5){
            str.replace(j, j+5, "равно");
        }
    }



}