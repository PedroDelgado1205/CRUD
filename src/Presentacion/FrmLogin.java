package Presentacion;

import com.mysql.cj.xdevapi.Table;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class FrmLogin {

    String usuario = "root";
    String contrasena = "pemildebra";
    String ruta = "jdbc:mysql://localhost:3306/biblioteca_wissen";

    Connection con ;

    Statement st;

    ResultSet rs;



    public FrmLogin(int anc, int alt) {

        try {
            //Class.forName(jdbc);
            con = DriverManager.getConnection(ruta, usuario, contrasena);
            System.out.println("Conexion exitosa"+con.toString());
            st = con.createStatement();

        } catch (SQLException error) {
            System.out.println("Error mysql: "+error.getMessage());
            //} catch (ClassNotFoundException ex) {
            //    System.out.println("Error jdbc: "+ex.getMessage());
        }
        JFrame miVentana = new JFrame("LOGIN");
        miVentana.getContentPane().setLayout(null);
        miVentana.setSize(anc, alt);
        JPanel miPanel = new JPanel();
        JLabel miLabel1 = new JLabel("Usuario:");
        JTextField txtuser = new JTextField();
        JLabel miLabel2 = new JLabel("Contraseña:");
        //JTextField miTexto2 = new JTextField();
        JPasswordField txtpasw = new JPasswordField();
        Button miBoton = new Button("Login");
        Button btningre = new Button("Insertar");
        Button btnedit = new Button("Editar");
        Button btndelet = new Button("Eliminar");
        Button btnmostr = new Button("Mostrar");



        miLabel1.setBounds(70,50,70,30);
        miLabel2.setBounds(70,90,70,30);
        txtuser.setBounds(160,50,100,30);
        txtpasw.setBounds(160,90,100,30);
        miBoton.setBounds(100,140,50,30);
        btningre.setBounds(170, 140, 50, 30);
        btnedit.setBounds(240, 140, 50, 30);
        btndelet.setBounds(310, 140, 50, 30);
        btnmostr.setBounds(380, 140, 50, 30);
        miVentana.add(miLabel1);
        miVentana.add(txtuser);
        miVentana.add(miLabel2);
        miVentana.add(txtpasw);
        miVentana.add(miBoton);
        miVentana.add(btningre);
        miVentana.add(btnedit);
        miVentana.add(btndelet);
        miVentana.add(btnmostr);
        //Agregando el evento click a miBotn
        btndelet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID a eliminar: "));
                try {
                    String sql = "delete from usuario where id_usuario = ?;";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setInt(1, id);
                    if(ps.executeUpdate()>0){
                        JOptionPane.showMessageDialog(null, "Datos eliminados", "Datos eliminados", 1);
                    }else {
                        JOptionPane.showMessageDialog(null, "ID no encontrado", "no se puede eliminar", 1);
                    }
                }catch (SQLException er) {
                    System.out.println("Error: "+er.getMessage());
                }
            }
        });
        btnedit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID a editar: "));
                String user = txtuser.getText();
                String pasw = txtpasw.getText();

                try {
                    String sqlcla = "UPDATE usuario SET usu_nombre = ?, usu_clave = ? WHERE (id_usuario = ?);";
                    PreparedStatement ps = con.prepareStatement(sqlcla);
                    ps.setString(1, user);
                    ps.setString(2, pasw);
                    ps.setInt(3, id);
                    if(ps.executeUpdate()>0){
                        JOptionPane.showMessageDialog(null, "Datos editados", "Datos editados", 1);
                    }else {
                        JOptionPane.showMessageDialog(null, "ID no encontrado", "no se puede editar", 1);
                    }
                }catch (SQLException er) {
                    System.out.println("Error: "+er.getMessage());
                }
            }
        });
        btningre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               String user = txtuser.getText();
               String pasw = txtpasw.getText();
               try {
                   String sql = "insert into usuario(usu_nombre, usu_clave) values (?, ?);";
                   PreparedStatement ps = con.prepareStatement(sql);
                   ps.setString(1, user);
                   ps.setString(2, pasw);
                   if(ps.executeUpdate()>0){
                       JOptionPane.showMessageDialog(null, "Datos insertados", "Datos insertados", 1);
                   }
               }catch (SQLException er) {
                   System.out.println("Error: "+er.getMessage());
               }
            }
        });
        miBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ResultSet rs = null;
                Boolean existe=false;
                try {

                    String sql = "Select * from usuario where usu_nombre = '"+txtuser.getText()+"' and usu_clave = '"+txtpasw.getText()+"';";
                    System.out.println(sql);
                    rs = st.executeQuery(sql);
                    System.out.println(st.execute(sql));

                    while (rs.next()){
                        existe=true;
                       System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
                    }

                } catch (SQLException error) {
                    System.out.println("Error mysql: "+error.getMessage());
                //} catch (ClassNotFoundException ex) {
                //    System.out.println("Error jdbc: "+ex.getMessage());
                }
                //JOptionPane.showMessageDialog(null, "Hola: "+txtuser.getText().toString()+" = "+user, "Mensaje", 1);
                //if ((user.equals(txtuser.getText()))&& (pasw.equals(txtpasw.getText()))){
                if (existe = true){
                    FrmHome frmHome = new FrmHome(txtuser.getText());
                    frmHome.setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null, "Datos incorrectos", "Mensaje", 2);
                }
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
