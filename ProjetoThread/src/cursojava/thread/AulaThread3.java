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
public class AulaThread3 {

    public static void main(String[] args) throws InterruptedException {

        JOptionPane.showMessageDialog(null, "Executando o sistema");

        Thread threadEmail = new Thread(thread1);
        threadEmail.start();

        Thread threadNome = new Thread(thread2);
        threadNome.start();

    }
    private static Runnable thread1 = new Runnable() {
        @Override
        public void run() {
            for (int k = 0; k < 1; k++) {
                String thread1 = JOptionPane.showInputDialog("Digite seu email");

                for (int i = 0; i < 1; i++) {
                    System.out.println("Email:" + (i + 1) + " = " + thread1);
                }
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    };
    private static Runnable thread2 = new Runnable() {
        @Override
        public void run() {
            for (int k = 0; k < 1; k++) {
                String thread2 = JOptionPane.showInputDialog("Digite seu nome");
                for (int j = 0; j < 1; j++) {
                    System.out.println("Nome:" + (j + 1) + " = " + thread2);
                }
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    };
}
