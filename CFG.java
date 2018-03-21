/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfg;

import java.util.Scanner;

/**
 *
 * @author Kaustubh
 */
public class CFG {
    static int np = 0;
    static String  grammer[][] = {{"S", "AB", "BC"}, {"A", "BA", "a"}, {"B", "CC", "b"}, {"C", "AB", "a"}};
    /**
     * @param args the command line arguments
     */
    static String check(String a){
        String to_ret = "";
        int count = 0;
        for(int i = 0; i < np; i++){
//            count = 1;
//            while(grammer[i][count] != ""){
            for(count = 0; count < grammer[i].length; count++){
                if(grammer[i][count].equals(a)){
                    to_ret += grammer[i][0];
                }
//                count++;
            }
        }
        return to_ret;
    }
    
    static String combinat(String a, String b){
//        System.out.println("Got " + a + " and " + b + " in Combinat");
        String to_ret = "", temp = "";
            for(int i = 0; i < a.length(); i++){
                for(int j = 0; j < b.length(); j++){
                    temp = "";
                    temp += a.charAt(i) + "" +  b.charAt(j);
                    to_ret += check(temp);
                }
            }
        return to_ret;
    }
    public static void main(String[] args) {
        String start;
        int n = 0;
        Scanner in = new Scanner(System.in);
//        Scanner in2 = new Scanner(System.in);
//        System.out.println("Enter Starting variable >>");
        start = "S";
        System.out.println("Enter no of productions >>");
        np = Integer.parseInt(in.nextLine());
//        in.nextLine();
//        grammer = new String[np][10];
        String temp;
//        for(int i = 0; i < np; i++){
//            System.out.println("Enter rule >>");
//            temp = in.nextLine();
//            grammer[i][0] = temp.substring(0, temp.indexOf("->"));
//            String rhs[] = temp.substring(temp.indexOf("->") + 2, temp.length()).split("\\|");
////            System.out.println(rhs);
////            String rhs_break[] = rhs
//            for(int j = 0; j < rhs.length; j++){
//                grammer[i][j + 1] = rhs[j];
//                System.out.println(rhs[j]);
//            }
//        }
        System.out.println("Enter the string to be checked >>");
        String str = in.nextLine(), st = "", r = "";
        int count;
        String ans_mat[][] = new String[10][10];
//        for(int i = 0; i < grammer.length; i++){
//            for(int j = 0; j < grammer[i].length; j++){
//                System.out.print(grammer[i][j] + " ");
//            }
//            System.out.println();
//        }
        for(int i = 0; i < str.length(); i++){
            r = "";
            st = "" + str.charAt(i);
            for(int j = 0; j < np; j++){
//                count = 1;
//                while(grammer[j][count] != "" || grammer[j][count] != null){
                for(count = 1; count < grammer[j].length; count++){
//                    System.out.println("st = " + st + "  grammer found = " + grammer[j][count]);
                    if(grammer[j][count].equals(st)){
//                        System.out.println("Found Match");
                        r += grammer[j][0];
                    }
//                    count++;
                }
                      
            }
            ans_mat[i][i] = r;
        }
        
        
        
        for(int i = 1; i < str.length(); i++){
            for(int j = i; j < str.length(); j++){
                r = "";
                for(int k = j - i; k < j; k++){
                    r += combinat(ans_mat[j - i][k], ans_mat[k + 1][j]);
                }
                ans_mat[j - i][j] = r;
            }
        }
        
        if(ans_mat[0][str.length() - 1].indexOf(start) >= 0){
            accept();
        }
        else{
            reject();
        }
        
        
//        for(int i = 0; i < 10; i++){
//            for(int j = 0; j < 10; j++){
//                System.out.print(ans_mat[i][j] + "\t");
//            }
//            System.out.println();
//        }

    }
    
    public static void accept(){
        System.out.println("String is accepted");
        System.exit(0);
    }
    public static void reject(){
        System.out.println("String is rejected");
        System.exit(0);
    }
    
}
