/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arq;


import java.io.File;

public class CalculoConvencional {

  public static long calcular(File file) {
    long size = 0;

    if (file.isFile()) {
      size = file.length();
    } else {
        
      File[] arqs = file.listFiles();
      if (arqs != null) {
        for (File arq : arqs) {
          size += CalculoConvencional.calcular(arq);
        }
      }
    }
    return size;
  }
}
