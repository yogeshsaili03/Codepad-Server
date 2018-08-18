package server;

import Database.Connect;
import Mail.SendSMTP;
import SMS.SMS;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import static server.Server.al;
import static server.Server.model;

/**
 *
 * @author Yogesh
 */
public class Server extends javax.swing.JFrame {

    public static ArrayList<online> al;
    public static myonlinetablemodel model;

    public Server() {
        initComponents();
        al = new ArrayList<>();
        model = new myonlinetablemodel();
        Table.setModel(model);
        model.fireTableDataChanged();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnstart = new javax.swing.JButton();
        lblstart = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Server", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        btnstart.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnstart.setText("Start");
        btnstart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnstartActionPerformed(evt);
            }
        });

        lblstart.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblstart.setText("Click to Start Server");

        Table.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Username", "IP Address", "Port No."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Table);
        Table.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(lblstart))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(btnstart)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(lblstart, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnstart)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnstartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnstartActionPerformed
        try {
            btnstart.setEnabled(false);
            lblstart.setText("       Server On");

            ServerThread st = new ServerThread();
            st.start();

        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }//GEN-LAST:event_btnstartActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JButton btnstart;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblstart;
    // End of variables declaration//GEN-END:variables
}

class ServerThread extends Thread {

    Socket cs = null;

    ServerSocket ss = null;

    @Override
    public void run() {

        try {
            ss = new ServerSocket(1234);
            while (true) {
                cs = ss.accept();
                // System.err.println(cs);
                System.out.println("fgshdmfh" + cs.getPort());
                System.out.println(cs.getInetAddress());
                InetAddress iAddress = InetAddress.getLocalHost();
                String Ip = iAddress.getHostAddress();
                System.out.println("Server Ip " + Ip);
                ClientHandler ch = new ClientHandler();
                ch.ClientHandler(cs);
                System.out.println(cs.getLocalAddress().getHostAddress());

            }
        } catch (IOException e) {
            System.out.println("Exception " + e);
        } catch (SQLException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class ClientHandler {

    Socket cs;
    DataOutputStream dos;
    DataInputStream dis;
    Connection con;

    public void ClientHandler(Socket cs) throws SQLException {
        try {
            this.cs = cs;
            dos = new DataOutputStream(cs.getOutputStream());
            dis = new DataInputStream(cs.getInputStream());
            String btnName = dis.readUTF();
            if (btnName.equals("Forgot1")) {
                String username = dis.readUTF();
                try {
                    con = Connect.connect();

                    PreparedStatement pstmt = con.prepareStatement("select username,emailid from codepad where username='" + username + "'");

                    ResultSet rs = pstmt.executeQuery();
                    if (rs.next()) {
                        int a = (int) (Math.random() * 1000000);
                        System.out.println(a);
                        String result = SendSMTP.sendMail(rs.getString("emailid"), "Your requested OTP on CodePad is " + a + " and this is valid for current session only.", "Password Recovery");

                        if (result.equalsIgnoreCase("sent")) {
                            dos.writeUTF("send");

                            dos.writeUTF(Integer.toString(a));
                        } else {
                            dos.writeUTF("notsent");
                        }
                    } else if (!rs.next()) {
                        dos.writeUTF("notexist");
                    }

                } catch (IOException | SQLException e) {

                    System.out.println("Exception 123" + e);
                }
            }
            if (btnName.equals("Forgot2")) {
                String username = dis.readUTF();
                try {
                    con = Connect.connect();

                    PreparedStatement pstmt = con.prepareStatement("select username,mobile from codepad where username='" + username + "'");

                    ResultSet rs = pstmt.executeQuery();
                    if (rs.next()) {
                        int a = (int) (Math.random() * 1000000);
                        System.out.println(a);
                        String result = SMS.Sms(rs.getString("mobile"), "Your requested OTP on CodePad is " + a + " and this is valid for current session only.");

                        if (result.equalsIgnoreCase("sent")) {
                            dos.writeUTF("sendsms");
                            dos.writeUTF(Integer.toString(a));
                        } else if (result.equalsIgnoreCase("nosent")) {
                            dos.writeUTF("notsent");
                        }
                    } else if (!rs.next()) {
                        dos.writeUTF("notexist");
                    }

                } catch (IOException | SQLException e) {

                    System.out.println("Exception 123" + e);
                }
            }
            if (btnName.equals("ChangePass")) {
                String username = dis.readUTF();
                String Password = dis.readUTF();
                try {
                    con = Connect.connect();

                    PreparedStatement pstmt = con.prepareStatement("update codepad set password='" + Password + "' where username='" + username + "'");

                    int rs = pstmt.executeUpdate();
                    if (rs > 0) {
                        dos.writeUTF("Set");
                    } else {
                        dos.writeUTF("notsent");
                    }
                } catch (IOException | SQLException e) {

                    System.out.println("Exception 123" + e);
                }
            }
            if (btnName.equals("SignUp")) {
                String username = dis.readUTF();
                String password = dis.readUTF();
                String name = dis.readUTF();
                String mobile = dis.readUTF();
                String emailid = dis.readUTF();

                try {
                    con = Connect.connect();

                    PreparedStatement pstmt = con.prepareStatement("select * from codepad where username='" + username + "'");

                    ResultSet rs = pstmt.executeQuery();
                    if (rs.next()) {
                        dos.writeUTF("fail");
                    } else if (!rs.next()) {
                        PreparedStatement stmt = con.prepareStatement("insert into codepad(username,password,name,mobile,emailid) values(?,?,?,?,?)");
                        stmt.setString(1, username);
                        stmt.setString(2, password);
                        stmt.setString(3, name);
                        stmt.setString(4, mobile);
                        stmt.setString(5, emailid);
                        int result = stmt.executeUpdate();
                        if (result > 0) {
                            dos.writeUTF("done");
                        } else {
                            dos.writeUTF("nope");
                        }

                    }

                } catch (IOException | SQLException e) {

                    System.out.println("Exception 123" + e);
                }
            }

            if (btnName.equals("LogIn")) {
                String username = dis.readUTF();
                String password = dis.readUTF();
                int a = 0;
                myonlinetablemodel m = new myonlinetablemodel();
                for (int i = 0; i < al.size(); i++) {
                    String Name = m.getValueAt(i, 0);
                    System.out.println(i + " " + Name);
                    if ((Name.equalsIgnoreCase(username))) {
                        a++;
                        dos.writeUTF("AlreadyLog");
                    }
                }
                if (a == 0) {
                    try {
                        con = Connect.connect();

                        PreparedStatement stmt = con.prepareStatement("select * from codepad where username='" + username + "'");

                        ResultSet rs = stmt.executeQuery();

                        if (rs.next()) {

                            try {

                                String pass = rs.getString("password");
                                String name = rs.getString("name");
                                System.out.println(name);
                                if (pass.equals(password)) {
                                    String ip = cs.getInetAddress().getHostAddress();
                                    String port = Integer.toString(cs.getPort());
                                    Server.al.add(new online(username, ip, port));
                                    Server.model.fireTableDataChanged();

                                    dos.writeUTF("done");
                                    dos.writeUTF(name);
                                    System.out.println(port + " client port " + cs.getPort());
                                    dos.writeUTF(port);
                                } else {
                                    dos.writeUTF("wrongpass");
                                }

                            } catch (Exception e) {

                                System.out.println("Exception 123" + e);
                            }
                        } else {
                            dos.writeUTF("wronguser");
                        }

                    } catch (Exception e) {
                        System.out.println("Exception4651 " + e);
                    }
                }
            }

            if (btnName.equals("Search")) {
                String Username = dis.readUTF();
                System.out.println(Username);
                String Friend = dis.readUTF();
                System.out.println(Friend);
                try {
                    con = Connect.connect();
                    int a = 0;
                    PreparedStatement stmt = con.prepareStatement("select * from codepad where username!='" + Username + "'&& username like '" + Friend + "%'");

                    ResultSet rs = stmt.executeQuery();

                    while ((rs.next())) {
                        String friendname = rs.getString("username");
                        dos.writeUTF(friendname);
                        dos.writeUTF(rs.getString("emailid"));
                        PreparedStatement stmt1 = con.prepareStatement("select * from friend where username='" + Username + "'&& friendname= '" + friendname + "' || username='" + friendname + "'&& friendname='" + Username + "'");
                        PreparedStatement stmt2 = con.prepareStatement("select * from req where F='" + Username + "'&& T='" + friendname + "'");
                        PreparedStatement stmt3 = con.prepareStatement("select * from req where T='" + Username + "' && F='" + friendname + "'");
                        System.out.println(a);
                        a++;
                        ResultSet rs1 = stmt1.executeQuery();
                        ResultSet rs2 = stmt2.executeQuery();
                        ResultSet rs3 = stmt3.executeQuery();
                        if (rs1.next()) {
                            dos.writeUTF("Friend");
                        } else if (rs2.next()) {

                            dos.writeUTF("Friend Request Sent");
                        } else if (rs3.next()) {
                            dos.writeUTF("Pending Request");
                        } else if (!(rs1.next() && rs2.next() && rs.next())) {
                            dos.writeUTF("Send Friend Request");
                        }

                    }
                    if (a == 0) {
                        System.out.println("No records found");
                        dos.writeUTF("Not Exist");
                    }

                    dos.writeUTF("Done");
                } catch (Exception e) {
                    System.out.println("Search" + e);
                }
            }
            if (btnName.equals("Req")) {
                String from = dis.readUTF();
                System.out.println(from);
                String to = dis.readUTF();
                System.out.println(to);
                System.out.println("ABC");
                try {
                    con = Connect.connect();

                    PreparedStatement stmt = con.prepareStatement("insert into req(f,t) values(?,?)");
                    stmt.setString(1, from);
                    stmt.setString(2, to);
                    int result = stmt.executeUpdate();
                    if (result > 0) {
                        dos.writeUTF("done");
                    } else {
                        dos.writeUTF("nope");
                    }

                } catch (Exception e) {

                    System.out.println("Exception 123" + e);
                }

            }
            if (btnName.equals("FriReq")) {
                String username = dis.readUTF();
                System.out.println(username);

                System.out.println("ABC");
                try {
                    con = Connect.connect();
                    int a = 0;
                    PreparedStatement stmt = con.prepareStatement("select * from req where T='" + username + "'");
                    ResultSet rs = stmt.executeQuery();
                    while (rs.next()) {
                        a++;
                        String friendname = rs.getString("F");
                        System.out.println(friendname);
                        dos.writeUTF(friendname);
                    }
                    if (a == 0) {
                        System.out.println("No records found");
                        dos.writeUTF("No Request");
                    }

                    dos.writeUTF("Done");

                } catch (Exception e) {

                    System.out.println("Exception 123" + e);
                }

            }
            if (btnName.equals("Accept")) {
                String From = dis.readUTF();
                String To = dis.readUTF();
                System.out.println(From + " " + To);

                System.out.println("ABC");
                try {
                    con = Connect.connect();
                    int a = 0;
                    PreparedStatement stmt1 = con.prepareStatement("delete from req where F='" + From + "' && T='" + To + "'");
                    PreparedStatement stmt2 = con.prepareStatement("insert into friend(username,friendname) values(?,?)");
                    int rs = stmt1.executeUpdate();
                    if (rs > 0) {
                        stmt2.setString(1, From);
                        stmt2.setString(2, To);
                        int result = stmt2.executeUpdate();
                        if (result > 0) {
                            dos.writeUTF("Done");
                        } else {
                            dos.writeUTF("nope");
                        }
                    } else {
                        dos.writeUTF("nope");
                    }

                } catch (IOException | SQLException e) {

                    System.out.println("Exception 123" + e);
                }

            }
            if (btnName.equals("Delete")) {
                String From = dis.readUTF();
                String To = dis.readUTF();
                System.out.println(From + " " + To);

                System.out.println("ABC");
                try {
                    con = Connect.connect();
                    int a = 0;
                    PreparedStatement stmt1 = con.prepareStatement("delete from req where F='" + From + "' && T='" + To + "'");
                    int rs = stmt1.executeUpdate();
                    if (rs > 0) {
                        dos.writeUTF("Done");
                    } else {
                        dos.writeUTF("nope");
                    }

                } catch (IOException | SQLException e) {

                    System.out.println("Exception 123" + e);
                }

            }
            if (btnName.equals("SentReq")) {
                String username = dis.readUTF();
                System.out.println(username);

                System.out.println("Xyz");
                try {
                    con = Connect.connect();
                    int a = 0;
                    PreparedStatement stmt = con.prepareStatement("select * from req where F='" + username + "'");
                    ResultSet rs = stmt.executeQuery();
                    while (rs.next()) {
                        a++;
                        String friendname = rs.getString("T");
                        System.out.println(friendname);
                        dos.writeUTF(friendname);
                    }
                    if (a == 0) {
                        System.out.println("No records found");
                        dos.writeUTF("No Request");
                    }

                    dos.writeUTF("Done");

                } catch (IOException | SQLException e) {

                    System.out.println("Exception 123" + e);
                }

            }
            if (btnName.equals("Online")) {
                String username = dis.readUTF();
                System.out.println(username);
                System.out.println("Xyz");
                myonlinetablemodel m = new myonlinetablemodel();
                int a = 0;
                for (int i = 0; i < al.size(); i++) {
                    String Name = m.getValueAt(i, 0);
                    System.out.println(i + " " + Name);
                    if (!(Name.equalsIgnoreCase(username))) {
                        con = Connect.connect();
                        PreparedStatement stmt = con.prepareStatement("select * from friend where username='" + username + "'&& friendname= '" + Name + "' || username='" + Name + "'&& friendname='" + username + "'");
                        ResultSet rs = stmt.executeQuery();
                        if (rs.next()) {
                            a++;
                            dos.writeUTF(Name);
                        }
                    }
                }
                if (a == 0) {
                    dos.writeUTF("None");
                }
                dos.writeUTF("Done");

            }
            if (btnName.equals("Logout")) {
                String username = dis.readUTF();
                System.out.println(username);
                System.out.println("Xyz");
                myonlinetablemodel m = new myonlinetablemodel();
                int a = 0;
                for (int i = 0; i < al.size(); i++) {
                    String Name = m.getValueAt(i, 0);
                    System.out.println(i + " " + Name);
                    if ((Name.equalsIgnoreCase(username))) {
                        a++;
                        al.remove(i);
                        model.fireTableDataChanged();
                        dos.writeUTF("done");
                        break;
                    }
                }
                if (a == 0) {
                    dos.writeUTF("nope");
                }

            }
            if (btnName.equals("Invite")) {
                String From = dis.readUTF();
                String To = dis.readUTF();
                System.out.println(From + " " + To);
                myonlinetablemodel m = new myonlinetablemodel();
                for (int i = 0; i < al.size(); i++) {
                    String Name = m.getValueAt(i, 0);
                    System.out.println(i + " " + Name);
                    if ((Name.equalsIgnoreCase(To))) {
                        String ip = m.getValueAt(i, 1);
                        int port = Integer.parseInt(m.getValueAt(i, 2));

                        dos.writeUTF("done");
                     /*   System.out.println(ip + " " + port);
                        if (come.equals("done")) {
                            dos.writeUTF("done");
                            break;
                        } else {
                            dos.writeUTF("rejected");
                        }*/
                    } else {
                        dos.writeUTF("offline");
                    }
                }

            }

        } catch (IOException e) {
            System.out.println("Exception 3524" + e);
        }

    }

}

class myonlinetablemodel extends AbstractTableModel {

    @Override
    public int getRowCount() {
        return Server.al.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int i) {
        String title[] = {"Username", "IP Address", "Port No."};
        return title[i];
    }

    @Override
    public String getValueAt(int i, int j) {
        online o = Server.al.get(i);
        if (j == 0) {
            return o.name;
        } else if (j == 1) {
            return o.ip;
        } else {
            return o.port;
        }
    }

}

class online {

    String name, ip, port;

    public online(String name, String ip, String port) {
        this.name = name;
        this.port = port;
        this.ip = ip;
    }

}
