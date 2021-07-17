/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursojava.thread;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author wesle
 */
public class AulaThread {

    public static void main(String[] args) throws InterruptedException {

        //Thread procesando em paralelo do envio de email
        Thread threadEmail = new Thread(thread1);
        threadEmail.start();
       
//Start liga a Thread que fica procesando paralelamente por trás

        //=====================================================================
        Thread threadNotaFiscal = new Thread(thread2);
        threadNotaFiscal.start();
        //Thread procesando em paralelo do envio de nota fiscal
      

        //Codico da rotina que eu quero executar em pararelo
   
        //Codico do sistema do usuario continua com o fluxo de trabalho
        System.out.println("Chegou ao fim do codico");
        //Fluxo do sistema, cadastro de venda algo do tipo
        JOptionPane.showMessageDialog(null, "Sistema continua executando para o usuario");

    }
    private static Runnable thread2 = new Runnable() {
        @Override
            public void run() {//Executa o que queremos
                for (int i = 0; i < 10; i++) {

                    //Quero executar esse envio a comum tempo de parada, ou com um tempo determinado;
                    System.out.println("Executando um envio de nota fiscal: " + (i + 1));
                    try {
                        Thread.sleep(1000);//Dá um tempo
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                //Fim do codico em pararelo
          
        }
    };
    private static Runnable thread1 = new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {

                //Quero executar esse envio a comum tempo de parada, ou com um tempo determinado;
                System.out.println("Executando um valor: " + (i + 1));
                try {
                    Thread.sleep(1000);//Dá um tempo
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            //Fim do codico em pararelo
        }
    };
}
