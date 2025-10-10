/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fizzbuzz;

import java.util.Scanner;

/**
 *
 * @author raissa
 */
public class FizzBuzz {


   
    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
  
    
        System.out.println("Digite um número: ");
        int n = num.nextInt();
   for (int i = 0; i < n; i++){
    if (i % 3 ==0) {
    System.out.println("Fizz");
    }else if (i % 3 ==0 && i%5==0){
           System.out.println("FizzBuzz");
    }else if (i%5==0){
        System.out.println("Buzz");
    }else {
        System.out.println(i);
            }
        }
    }  
}

