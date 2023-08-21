package Presentacion;

import javax.swing.*;
import java.awt.*;

public class FrmHome extends JFrame{
    JLabel jlTitle;
    JLabel jlSubTitle;
    private String name="";

    public FrmHome(String user){
        this.name=user;
        initGUI();
        //define un absolute layout
        getContentPane().setLayout(null);
        jlTitle = new JLabel("Inicio");
        jlSubTitle = new JLabel("Bienvenido " +this.name);
        jlTitle.setBackground(Color.cyan);
        jlSubTitle.setBackground(Color.cyan);
        jlTitle.setBounds(250,10,100,30);
        jlSubTitle.setBounds(250,30,200,30);
        add(jlTitle);
        add(jlSubTitle);
    }
    private void initGUI(){
        setTitle("HOME DE "+ this.name.toUpperCase());
        setSize(600, 500);
    }
}
