/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursojava.thread;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wesle
 */
public class ImplementacaoFilaThread extends Thread {

    private static ConcurrentLinkedQueue<ObjetoFilaThread> pilha_fila
            = new ConcurrentLinkedQueue<>();

    public static void add(ObjetoFilaThread objetoFilaThread) {
        pilha_fila.add(objetoFilaThread);
    }

    public void run() {

        System.out.println("fila rodando:");

        while (true) {

            synchronized (pilha_fila) {//Bloquear o acesso  a essa lista por outro processos;
                Iterator interacao = pilha_fila.iterator();
                while (interacao.hasNext()) {//Enquanto conter dados na lista irá processar

                    //Pega objeto atual
                    ObjetoFilaThread processar = (ObjetoFilaThread) interacao.next();

                    /*Procesar 10 mil notas fiscais
              Gerar uma lista enorme de PDF
              Gerar um envio em massa de email  
                     */
                    System.out.println("=============================");
                    System.out.println("Nome:"+processar.getNome());
                    System.out.println("Email:"+processar.getEmail());

                    interacao.remove();

                    try {
                        Thread.sleep(5000);//Dar um tempo pra descarga de memoria
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    try {
                        Thread.sleep(1000);//procesou toda a lista dá um tempo pra limpeza de memory
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }

            }
        }

    }

}
