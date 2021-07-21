/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arq;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 *
 * @author Gabriel
 */
public class CalculoParalelo  extends RecursiveTask<Long>{
    
    private File file;

    public CalculoParalelo(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public CalculoParalelo(File[] file) {
        
    }
    

    @Override
    protected Long compute() {
        if(file.isFile()){
            return file.length();
        }else{
            File[] arqs = file.listFiles();
            if(arqs != null){
                return CalculoParalelo.invokeAll(criarSubtarefas(arqs)).stream().mapToLong(CalculoParalelo::join).sum();
            }
        }
        return null;
    }
    
    private Collection<CalculoParalelo> criarSubtarefas(File[] arqs) {
        
        List<CalculoParalelo> subtarefas = new ArrayList<>();
        
        for(int i = 0; i < arqs.length; i++){
            subtarefas.add(new CalculoParalelo(arqs[i])); 
        }
        
        
        
        return subtarefas;
    }
    
    
}
