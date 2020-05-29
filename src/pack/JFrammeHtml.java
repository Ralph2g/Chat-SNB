package pack;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.net.StandardProtocolFamily;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JFrammeHtml extends javax.swing.JFrame {
    public static final String MCAST_ADDR  = "230.0.0.1"; //dir clase D valida, grupo al que nos vamos a unir
    public static final int MCAST_PORT = 4000;//puerto multicast
    public static final int DGRAM_BUF_LEN=2000; //tamaño del buffer
    public static String nickname = "";
    public static DatagramChannel s;
    public static SocketAddress remote = null;
    public static ByteBuffer b = ByteBuffer.allocate(DGRAM_BUF_LEN);
    public static ArrayList <String> usuariosConectados = new ArrayList<>();
    ByteBuffer b2 = null;
    
    public JFrammeHtml() {
        try {
            //Conectandose al canal
            nickname = JOptionPane.showInputDialog("Ingrese su nickname");
            b.clear();
            String conexion = "<inicio>"+nickname;
            b.put(ByteBuffer.wrap (conexion.getBytes()));
            b.flip();
            s.send(b, remote);
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
        txtEstado.setText(nickname);
        mostrarUsuarios();
        String []tipo = {"Publico", "Privado"};
        comboTipo.setModel (new DefaultComboBoxModel <>(tipo));
        TextPane.setContentType("text/html");
    }

    public static void mostrarUsuarios (){
        int tamanio = usuariosConectados.size();
        String [][]users = new String [tamanio][1];
        for (int i = 0; i < tamanio; i++){
            users [i][0] = usuariosConectados.get(i);
        }
        String []tipo = new String [tamanio];
        for (int i = 0; i < tamanio;i++){
            tipo [i] = usuariosConectados.get(i);
        }
        if (usuariosConectados.size() > 0){
            tableUsuarios.setModel(new DefaultTableModel(users, new String []{"Nombre usuario"}));
            comboPrivado.setModel (new DefaultComboBoxModel <>(tipo));
        }
    }
    
    public static void eliminaUsuario (String deleteUser){
        for (int i = 0; i < usuariosConectados.size(); i++){
            if (deleteUser.equals(usuariosConectados.get(i))){
                usuariosConectados.remove(i);
                break;
            }
        }
        mostrarUsuarios();
    }
    
    public static void finChat (){
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TextPane = new javax.swing.JTextPane();
        btonEnviar = new javax.swing.JButton();
        textEnviar = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableUsuarios = new javax.swing.JTable();
        txtEstado = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox<>();
        comboPrivado = new javax.swing.JComboBox<>();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane2.setViewportView(TextPane);

        btonEnviar.setText("Enviar");
        btonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btonEnviarActionPerformed(evt);
            }
        });

        tableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tableUsuarios);

        txtEstado.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtEstado.setEnabled(false);

        jLabel1.setText("Nickname:");

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboPrivado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin usuarios" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btonEnviar)))
                        .addGap(0, 8, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(comboPrivado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboPrivado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btonEnviar)
                            .addComponent(textEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btonEnviarActionPerformed
        // TODO add your handling code here:
        String datosNuevos = textEnviar.getText();
        String type = (String)comboTipo.getSelectedItem();
        try {
            if (datosNuevos.equals("SALIR")){
                String dato = "<fin>"+nickname;
                    b.clear();
                    byte []mm = dato.getBytes();
                    b2 = ByteBuffer.wrap (mm);
                    b.put(b2);
                    b.flip();
                    s.send(b, remote);
                    b.clear();
            }else{
                if (type.equals("Privado")){
                    String persona = (String)comboPrivado.getSelectedItem();
                    String dato = "<privado><"+nickname+"><"+persona+">"+datosNuevos;
                    b.clear();
                    byte []mm = dato.getBytes();
                    b2 = ByteBuffer.wrap (mm);
                    b.put(b2);
                    b.flip();
                    s.send(b, remote);
                    b.clear();
                }else{
                    String dato = "<msj><"+nickname+">"+datosNuevos;
                    b.clear();
                    byte []mm = dato.getBytes();
                    b2 = ByteBuffer.wrap (mm);
                    b.put(b2);
                    b.flip();
                    s.send(b, remote);
                    b.clear();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        textEnviar.setText("");
    }//GEN-LAST:event_btonEnviarActionPerformed

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
            java.util.logging.Logger.getLogger(JFrammeHtml.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrammeHtml.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrammeHtml.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrammeHtml.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrammeHtml().setVisible(true);
            }
        });
                            
    try {          
        NetworkInterface ni = NetworkInterface.getByName("wlan1");
        InetSocketAddress dir = new InetSocketAddress(MCAST_PORT);
	try {
            remote = new InetSocketAddress(MCAST_ADDR, MCAST_PORT);
        } catch (Exception e) {
            e.printStackTrace();
	}
        s = DatagramChannel.open(StandardProtocolFamily.INET);
            s.setOption(StandardSocketOptions.SO_REUSEADDR, true);
            s.setOption(StandardSocketOptions.IP_MULTICAST_IF, ni);
            InetAddress group = InetAddress.getByName (MCAST_ADDR);
            s.join(group, ni);
            s.configureBlocking(false);
            s.socket().bind(dir);
            Selector sel = Selector.open();
            s.register(sel, SelectionKey.OP_READ);
            System.out.println("Servidor listo.. Esperando datagramas...");
            String cadenaPane = "";
            while (true){
                sel.select();
                Iterator <SelectionKey> it = sel.selectedKeys().iterator();
                while (it.hasNext()){
                    SelectionKey k = (SelectionKey)it.next();
                    it.remove();
                    if (k.isReadable()){
                        DatagramChannel ch = (DatagramChannel)k.channel();
                        b.clear();
                        SocketAddress emisor = ch.receive(b);
                        b.flip();
                        String eco = "";
                        eco = new String (b.array (), 0, b.limit ());
                        eco = eco.replace(":o", "<img src=\"file:src\\Imagenes\\imagen_beso.jpg\" width=30 height=30/>");
                        eco = eco.replace(";)", "<img src=\"file:src\\Imagenes\\imagen_guino.jpg\" width=30 height=30/>");
                        eco = eco.replace(":S", "<img src=\"file:src\\Imagenes\\imagen_gesto.jpg\" width=30 height=30/>");
                        eco = eco.replace("_Perro_", "<img src=\"file:src\\Imagenes\\perro.gif\" width=100 height=100/>");
                        eco = eco.replace("_Homero_", "<img src=\"http://tusimagenesde.com/wp-content/uploads/2015/01/gifs-animados-5.gif\"/>");
                        if (eco.contains("<inicio>")&&!eco.contains("<inicio>"+nickname)){
                            String usuario = eco.replace("<inicio>", "");
                            boolean verifica = false;
                            int tamanio = usuariosConectados.size();
                            for (int j = 0; j < tamanio; j++){
                                if (usuariosConectados.get(j).equals(usuario)){
                                    verifica = true;
                                }
                            }
                            if (!verifica){
                                System.out.println("User: "+usuario);
                                usuariosConectados.add(usuario);
                                mostrarUsuarios();
                                cadenaPane += usuario+" se ha conectado.<br/>";
                                TextPane.setText (cadenaPane);
                            }
                        }else if (eco.contains("<msj>")){
                            eco = eco.replace("<msj>", "").replaceFirst("<", "").replaceFirst(">", ": ")+"<br />";
                            cadenaPane += eco;
                            String name = eco.substring(0,eco.indexOf(":"));
                            boolean verifica = false;
                            int tamanio = usuariosConectados.size();
                            System.out.println("Nombre de user: "+name);
                            if (!name.contains(nickname)){
                                for (int j = 0; j < tamanio; j++){
                                    if (usuariosConectados.get(j).equals(name)){
                                        verifica = true;
                                    }
                                }
                            }else{
                                verifica = true;
                            }
                            if (!verifica){
                                usuariosConectados.add(name);
                                mostrarUsuarios();
                            }
                            eco = "";
                            TextPane.setText(cadenaPane);
                        }else if (eco.contains("<privado>")&&eco.contains("<"+nickname+">")){
                            eco = eco.replace("<privado>", "");
                            eco = eco.replaceFirst("<", "");
                            eco = eco.replaceFirst(">", ": ");
                            System.out.println(eco);
                            int first = eco.indexOf("<");
                            int second = eco.indexOf(">")+1;
                            String name = eco.substring(first, second);
                            System.out.println(eco);
                            eco = eco.replace(name, "");
                            eco = eco+"<br />";
                            cadenaPane += eco;
                            eco = "";
                            TextPane.setText (cadenaPane);
                        }else if(eco.contains ("<fin>")){
                            String user = eco.replace("<fin>", "");
                            if (user.contains(nickname)){
                                k.interestOps(SelectionKey.OP_READ);
                                k.cancel();
                                ch.close();
                                System.exit(0);
                            }else{
                                eliminaUsuario(user);
                                cadenaPane += user+" se ha desconectado.<br/>";
                                TextPane.setText (cadenaPane);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }              
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextPane TextPane;
    private javax.swing.JButton btonEnviar;
    private static javax.swing.JComboBox<String> comboPrivado;
    private static javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private static javax.swing.JTable tableUsuarios;
    private static javax.swing.JTextField textEnviar;
    private javax.swing.JTextField txtEstado;
    // End of variables declaration//GEN-END:variables
}
