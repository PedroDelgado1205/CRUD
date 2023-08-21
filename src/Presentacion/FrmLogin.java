package Presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    public Ventana(int anc, int alt) {
        JFrame miVentana = new JFrame("hola");
        miVentana.getContentPane().setLayout(null);
        miVentana.setSize(anc, alt);
        JPanel miPanel = new JPanel();
        JLabel miLabel1 = new JLabel("Usuario:");
        JTextField miTexto1 = new JTextField();
        JLabel miLabel2 = new JLabel("Contraseña:");
        //JTextField miTexto2 = new JTextField();
        JPasswordField miTexto2 = new JPasswordField();
        Button miBoton = new Button("Login");
        miLabel1.setBounds(50,50,175,30);
        miTexto1.setBounds(250,50,175,30);
        miLabel2.setBounds(50,150,175,30);
        miTexto2.setBounds(250,150,175,30);
        miBoton.setBounds(200,250,75,30);
        miVentana.add(miLabel1);
        miVentana.add(miTexto1);
        miVentana.add(miLabel2);
        miVentana.add(miTexto2);
        miVentana.add(miBoton);
        //Agregando el evento click a miBotn
        miBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Hola", "Mensaje", 2);
            }
        });
        //miTexto1.setPreferredSize(new Dimension(100, 20));
        //miTexto2.setPreferredSize(new Dimension(100,20));
//        miPanel.add(miBoton);
//        miPanel.add(miTexto2);
//        miPanel.add(miLabel2);
//        miPanel.add(miTexto1);
//        miPanel.add(miLabel1);
//        miVentana.add(miPanel);
        miVentana.setVisible(true);
    }
}
