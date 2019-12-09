/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author PC
 */
public class sembarang implements classInterface{
    public void test(){
        System.out.println("Ini di dalam method test dan di dalam class sembarang");
    }
    public static void main(String[] args) {
        classInterface test = new sembarang();
        test.test();
    }
}
