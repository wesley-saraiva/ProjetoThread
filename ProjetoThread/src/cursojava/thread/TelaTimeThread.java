/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursojava.thread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author wesle
 */
public class TelaTimeThread extends JDialog {

    private JPanel jpanel = new JPanel(new GridBagLayout());//Painel de componentes

    private JLabel descricaoHora = new JLabel("Time Thread 1");
    private JTextField tempo = new JTextField();

    private JLabel descricaoHora2 = new JLabel("Time Thread 2");
    private JTextField tempo2 = new JTextField();

    private JButton jbutton = new JButton("Start");
    private JButton jbutton2 = new JButton("Stop");

    private Runnable thread = new Runnable() {
        @Override
        public void run() {
            while (true) {//Fica sempre rodando
                tempo.setText(new SimpleDateFormat("dd/mm/yyyy  hh:mm:ss").
                        format(Calendar.getInstance().getTime()));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    };

    private Runnable thread2 = new Runnable() {
        @Override
        public void run() {
            while (true) {//Fica sempre rodando
                tempo2.setText(new SimpleDateFormat("dd-mm-yyyy  hh:mm:ss").
                        format(Calendar.getInstance().getTime()));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    };

    private Thread thread1Time;
    private Thread thread2Time;

    public TelaTimeThread() {//Executa o que tiver dentro no momento da abertura ou execução

        setTitle("Minha tela de time com thread");
        setSize(new Dimension(260, 240));
        setLocationRelativeTo(null);
        setResizable(false);
        //Primeira parte concluida

        GridBagConstraints gridBagConstraints = new GridBagConstraints();//Compilador de posicionamento de componentes
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new Insets(5, 10, 5, 5);
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        descricaoHora.setPreferredSize(new Dimension(200, 25));
        jpanel.add(descricaoHora, gridBagConstraints);

        tempo.setPreferredSize(new Dimension(200, 25));
        gridBagConstraints.gridy++;
        tempo.setEditable(false);
        jpanel.add(tempo, gridBagConstraints);

        descricaoHora2.setPreferredSize(new Dimension(200, 25));
        gridBagConstraints.gridy++;
        jpanel.add(descricaoHora2, gridBagConstraints);

        tempo2.setPreferredSize(new Dimension(200, 25));
        gridBagConstraints.gridy++;
        tempo2.setEditable(false);
        jpanel.add(tempo2, gridBagConstraints);

        gridBagConstraints.gridwidth = 1;
        jbutton.setPreferredSize(new Dimension(92, 25));
        gridBagConstraints.gridy++;
        jpanel.add(jbutton, gridBagConstraints);

        //============================================
        jbutton2.setPreferredSize(new Dimension(92, 25));
        gridBagConstraints.gridx++;
        jpanel.add(jbutton2, gridBagConstraints);

        jbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                thread1Time = new Thread(thread);
                thread1Time.start();
                
                thread2Time = new Thread(thread2);
                thread2Time.start();
                
                jbutton.setEnabled(false);
                jbutton2.setEnabled(true);
            }
        });
        jbutton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                thread1Time.stop();
                thread2Time.stop();
                
                jbutton.setEnabled(true);
                jbutton2.setEnabled(false);
            }
        });

        jbutton2.setEnabled(false);
      
        add(jpanel, BorderLayout.WEST);
        //Sempre será o ulitmo comando
        setVisible(true);//Torna a tela visivel para o usuario

    }

}
