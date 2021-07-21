/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arq;

import java.io.File;
import java.util.concurrent.ForkJoinPool;

public class CalculoTeste {

    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        long size = CalculoConvencional.calcular(new File("C:\\Users\\Gabriel\\Documents\\Facul"));
        long gastou = System.currentTimeMillis() - inicio;
        System.out.println("Modo convencional: ");
        System.out.println(size / 1024 + " Gastou: " + gastou);
        
        
        inicio = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool();
        size = pool.invoke(new CalculoParalelo(new File("C:\\Users\\Gabriel\\Documents\\Facul")));
        gastou = System.currentTimeMillis() - inicio;
        System.out.println("Modo paralelo: ");
        System.out.println(size / 1024 + " Gastou: "+gastou);
                
    }

}