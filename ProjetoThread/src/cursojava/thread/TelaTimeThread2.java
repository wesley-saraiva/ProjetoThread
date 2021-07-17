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
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author wesle
 */
public class TelaTimeThread2 extends JDialog {

    private JPanel jpanel = new JPanel(new GridBagLayout());//Painel de componentes

    private JLabel descricaoHora = new JLabel("Nome");
    private JTextField tempo = new JTextField();

    private JLabel descricaoHora2 = new JLabel("Email");
    private JTextField tempo2 = new JTextField();

    private JButton jbutton = new JButton("Gerar");
    private JButton jbutton2 = new JButton("Stop");

    private ImplementacaoFilaThread fila = new ImplementacaoFilaThread();

    public TelaTimeThread2() {//Executa o que tiver dentro no momento da abertura ou execução

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

        jpanel.add(tempo, gridBagConstraints);

        descricaoHora2.setPreferredSize(new Dimension(200, 25));
        gridBagConstraints.gridy++;
        jpanel.add(descricaoHora2, gridBagConstraints);

        tempo2.setPreferredSize(new Dimension(200, 25));
        gridBagConstraints.gridy++;

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
                if(fila == null){
                fila = new ImplementacaoFilaThread();
                fila.start();
                }
                for (int i = 0; i < 1; i++) {
                    ObjetoFilaThread filaThread = new ObjetoFilaThread();
                    filaThread.setNome(tempo.getText());
                    filaThread.setEmail(tempo2.getText() + " - " + (i + 1));

                    fila.add(filaThread);
                }
            }
        });
        jbutton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                fila.stop();
                fila = null;
            }
        });

        fila.start();

        add(jpanel, BorderLayout.WEST);
        //Sempre será o ulitmo comando
        setVisible(true);//Torna a tela visivel para o usuario

    }
}
