/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package walfrido.jogodavelha;

import javax.swing.JOptionPane;

/**
 *
 * @author Supervisor
 */
public class TelaJogoDaVelha extends javax.swing.JFrame {

    /**
     * Creates new form TelaJogoDaVelha
     */
    
    private boolean  bolinhaVez = true; 
    private boolean  travado00 = false;
    private boolean  travado01 = false;
    private boolean  travado02 = false;
    private boolean  travado10 = false;
    private boolean  travado11 = false;
    private boolean  travado12 = false;
    private boolean  travado20 = false;
    private boolean  travado21 = false;
    private boolean  travado22 = false;
    private int vitorias1;
    private int vitorias2;
    private String jogador1 = "Jogador1";
    private String jogador2 = "Jogador2";
    private int empate;
    private final  int[][] jogoVelha = new int[3][3]; 
    
    
    private int verificaLinhas(){
        
        for(int linha = 0; linha < 3; linha++){
            if(jogoVelha[linha][0]==1 && jogoVelha[linha][1]==1 && jogoVelha[linha][2]==1){
                return 1;
            }
            
            if(jogoVelha[linha][0]==0 && jogoVelha[linha][1]==0 && jogoVelha[linha][2]==0){
                return 0;
            }
        }      
           
        return -1;  
    }
    
    private int verificaColunas(){
        
        for(int colunas = 0; colunas < 3; colunas++){
            if(jogoVelha[0][colunas]==1 && jogoVelha[1][colunas]==1 && jogoVelha[2][colunas]==1){
                return 1;
            }
            if(jogoVelha[0][colunas]==0 && jogoVelha[1][colunas]==0 && jogoVelha[2][colunas]==0){
                return 0;
            }
        }      
           
        return -1;  
    }
      
    private int verificaDiagonais(){
        
         if( jogoVelha[0][0] == 1 && jogoVelha[1][1] == 1 &&  jogoVelha[2][2] == 1)
            return 1;
        if( jogoVelha[0][0] == 0 && jogoVelha[1][1] == 0 && jogoVelha[2][2] == 0)
            return 0;
        if( jogoVelha[0][2] == 1 && jogoVelha[1][1] == 1 && jogoVelha[2][0] == 1)
            return 1;
        if(  jogoVelha[0][2] == 0 && jogoVelha[1][1] == 0 && jogoVelha[2][0] == 0)
            return 0;
        
        return -1;
    } 
    
    private boolean verificaFinal(){
        
        int verificador = 0;
        
        for(int colunas = 0; colunas < 3; colunas++){
            for(int linhas = 0; linhas < 3; linhas++){
                if(jogoVelha[colunas][linhas] != -1)
                    verificador++;
            }
        }
        
        return verificador == 9;
    }
    
    private void zeraJogo(){
        
        bolinhaVez = true;
        travado00  = false;
        travado01  = false;
        travado02  = false;
        travado10  = false;
        travado11  = false;
        travado12  = false;
        travado20  = false;
        travado21  = false;
        travado22  = false;
           
        lbl00.setIcon(null); // NOI18N
        lbl01.setIcon(null); // NOI18N
        lbl02.setIcon(null); // NOI18N
        lbl10.setIcon(null); // NOI18N
        lbl11.setIcon(null); // NOI18N
        lbl12.setIcon(null); // NOI18N
        lbl20.setIcon(null); // NOI18N
        lbl21.setIcon(null); // NOI18N
        lbl22.setIcon(null); // NOI18N
      
       
        zeraMatriz();
        
        
    }
    
    private void zeraMatriz(){
         int x = 0;
        int z = 0;
        
        while(x < 3){
           while(z<3){
            jogoVelha[x][z] = -1;
            z++;
            }
         z = 0 ;
         x++;
        }
    }
    
    private void verificaVencedor(){
       
       if(verificaLinhas() == 1 || verificaColunas() == 1 || verificaDiagonais() == 1){
            JOptionPane.showMessageDialog(null, "Parabéns "  + getJogador1() + "! Você ganhou!!!");
            zeraJogo();
            setVitorias1(getVitorias1()+1);
            lblValue1.setText(Integer.toString(getVitorias1()));
            
       }else if(verificaLinhas() == 0 || verificaColunas() == 0 || verificaDiagonais() == 0){
           JOptionPane.showMessageDialog(null, "Parabéns "  + getJogador2() + "! Você ganhou!!!");
           zeraJogo();
           setVitorias2(getVitorias2()+1);
           lblValue2.setText(Integer.toString(getVitorias2()));
       }else{
           if(verificaFinal()){
               JOptionPane.showMessageDialog(null, "Jogo empatado!");
               zeraJogo();
               setEmpate(getEmpate()+1);
               lblEmpateValue.setText(Integer.toString(getEmpate()));
           }
       }
       
   }
    
    public TelaJogoDaVelha() {
        
        this.setContentPane(new FundoTela());
        initComponents();
        
        setJogador1(JOptionPane.showInputDialog("Informe o nome do primeiro jogador"));
        setJogador2(JOptionPane.showInputDialog("Informe o nome do segundo jogador"));
        lblJogador1.setText(jogador1);
        lblJogador2.setText(jogador2);
        zeraMatriz();
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl02 = new javax.swing.JLabel();
        lbl01 = new javax.swing.JLabel();
        lbl00 = new javax.swing.JLabel();
        lbl12 = new javax.swing.JLabel();
        lbl11 = new javax.swing.JLabel();
        lbl10 = new javax.swing.JLabel();
        lbl22 = new javax.swing.JLabel();
        lbl21 = new javax.swing.JLabel();
        lbl20 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblJogador1 = new javax.swing.JLabel();
        lblJogador2 = new javax.swing.JLabel();
        lblEmpate = new javax.swing.JLabel();
        lblValue1 = new javax.swing.JLabel();
        lblValue2 = new javax.swing.JLabel();
        lblEmpateValue = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jogo da Velha");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        lbl02.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl02MouseClicked(evt);
            }
        });

        lbl01.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl01MouseClicked(evt);
            }
        });

        lbl00.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl00MouseClicked(evt);
            }
        });

        lbl12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl12MouseClicked(evt);
            }
        });

        lbl11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl11MouseClicked(evt);
            }
        });

        lbl10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl10MouseClicked(evt);
            }
        });

        lbl22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl22MouseClicked(evt);
            }
        });

        lbl21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl21MouseClicked(evt);
            }
        });

        lbl20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl20MouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblJogador1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblJogador1.setForeground(new java.awt.Color(255, 0, 0));
        lblJogador1.setText("jLabel1");

        lblJogador2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblJogador2.setForeground(new java.awt.Color(0, 0, 204));
        lblJogador2.setText("jLabel2");

        lblEmpate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEmpate.setForeground(new java.awt.Color(51, 51, 51));
        lblEmpate.setText("Empate");

        lblValue1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblValue1.setText("0");

        lblValue2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblValue2.setText("0");

        lblEmpateValue.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEmpateValue.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblEmpate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblEmpateValue))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblJogador2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblValue2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblJogador1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblValue1)))
                .addGap(47, 47, 47))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValue1)
                    .addComponent(lblJogador1))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJogador2)
                    .addComponent(lblValue2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmpate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmpateValue))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl00, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl10, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl20, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl21, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(lbl22, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(16, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl01, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl02, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl11, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl12, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lbl00, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl01, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl02, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl10, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl11, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl12, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl20, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl22, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl21, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl00MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl00MouseClicked
        // TODO add your handling code here:
        if(!travado00) {
            if (bolinhaVez) {
                lbl00.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/circulo.png"))); // NOI18N
                lbl00.setText(""); 
                travado00 = true;
                bolinhaVez = false;
                jogoVelha[0][0] = 1;
            } else{
                lbl00.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x.png"))); // NOI18N
                lbl00.setText(""); 
                travado00 = true;
                bolinhaVez = true;
                jogoVelha[0][0] = 0;
            }
        }
        verificaVencedor();
    }//GEN-LAST:event_lbl00MouseClicked

    private void lbl01MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl01MouseClicked
        // TODO add your handling code here:
        if(!travado01) {
            if (bolinhaVez) {
                lbl01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/circulo.png"))); // NOI18N
                lbl01.setText(""); 
                travado01 = true;
                bolinhaVez = false;
                jogoVelha[0][1] = 1;
            } else{
                lbl01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x.png"))); // NOI18N
                lbl01.setText(""); 
                travado01 = true;
                bolinhaVez = true;
                jogoVelha[0][1] = 0;
            }
        }
        verificaVencedor();
    }//GEN-LAST:event_lbl01MouseClicked

    private void lbl20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl20MouseClicked
        // TODO add your handling code here:
        if(!travado20) {
            if (bolinhaVez) {
                lbl20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/circulo.png"))); // NOI18N
                lbl20.setText(""); 
                travado20 = true;
                bolinhaVez = false;
                jogoVelha[2][0] = 1;
            } else{
                lbl20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x.png"))); // NOI18N
                lbl20.setText(""); 
                travado20 = true;
                bolinhaVez = true;
                jogoVelha[2][0] = 0;
            }
        }
        verificaVencedor();
    }//GEN-LAST:event_lbl20MouseClicked

    private void lbl22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl22MouseClicked
        // TODO add your handling code here:
          if(!travado22) {
            if (bolinhaVez) {
                lbl22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/circulo.png"))); // NOI18N
                lbl22.setText(""); 
                travado22 = true;
                bolinhaVez = false;
                jogoVelha[2][2] = 1;
            } else{
                lbl22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x.png"))); // NOI18N
                lbl22.setText(""); 
                travado22 = true;
                bolinhaVez = true;
                jogoVelha[2][2] = 0;
            }
        }
          verificaVencedor();
    }//GEN-LAST:event_lbl22MouseClicked

    private void lbl21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl21MouseClicked
        // TODO add your handling code here:
          if(!travado21) {
            if (bolinhaVez) {
                lbl21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/circulo.png"))); // NOI18N
                lbl21.setText(""); 
                travado21 = true;
                bolinhaVez = false;
                jogoVelha[2][1] = 1;
            } else{
                lbl21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x.png"))); // NOI18N
                lbl21.setText(""); 
                travado21 = true;
                bolinhaVez = true;
                jogoVelha[2][1] = 0;
            }
        }
          verificaVencedor();
    }//GEN-LAST:event_lbl21MouseClicked

    private void lbl10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl10MouseClicked
        // TODO add your handling code here:
          if(!travado10) {
            if (bolinhaVez) {
                lbl10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/circulo.png"))); // NOI18N
                lbl10.setText(""); 
                travado10 = true;
                bolinhaVez = false;
                jogoVelha[1][0] = 1;
            } else{
                lbl10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x.png"))); // NOI18N
                lbl10.setText(""); 
                travado10 = true;
                bolinhaVez = true;
                jogoVelha[1][0] = 0;
            }
        }
         verificaVencedor();
    }//GEN-LAST:event_lbl10MouseClicked

    private void lbl11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl11MouseClicked
        // TODO add your handling code here:
         if(!travado11) {
            if (bolinhaVez) {
                lbl11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/circulo.png"))); // NOI18N
                lbl11.setText(""); 
                travado11 = true;
                bolinhaVez = false;
                jogoVelha[1][1] = 1;
            } else{
                lbl11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x.png"))); // NOI18N
                lbl11.setText(""); 
                travado11 = true;
                bolinhaVez = true;
                jogoVelha[1][1] = 0;
            }
        }
         verificaVencedor();
    }//GEN-LAST:event_lbl11MouseClicked

    private void lbl12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl12MouseClicked
        // TODO add your handling code here:
        if(!travado12) {
            if (bolinhaVez) {
                lbl12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/circulo.png"))); // NOI18N
                lbl12.setText(""); 
                travado12 = true;
                bolinhaVez = false;
                jogoVelha[1][2] = 1;
            } else{
                lbl12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x.png"))); // NOI18N
                lbl12.setText(""); 
                travado12 = true;
                bolinhaVez = true;
                jogoVelha[1][2] = 0;
            }
        }
       verificaVencedor();
    }//GEN-LAST:event_lbl12MouseClicked

    private void lbl02MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl02MouseClicked
        // TODO add your handling code here:
          if(!travado02) {
            if (bolinhaVez) {
                lbl02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/circulo.png"))); // NOI18N
                lbl02.setText(""); 
                travado02 = true;
                bolinhaVez = false;
                jogoVelha[0][2] = 1;
            } else{
                lbl02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/x.png"))); // NOI18N
                lbl02.setText(""); 
                travado02 = true;
                bolinhaVez = true;
                jogoVelha[0][2] = 0;
            }
        }
         verificaVencedor();
    }//GEN-LAST:event_lbl02MouseClicked

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
            java.util.logging.Logger.getLogger(TelaJogoDaVelha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaJogoDaVelha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaJogoDaVelha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaJogoDaVelha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaJogoDaVelha().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl00;
    private javax.swing.JLabel lbl01;
    private javax.swing.JLabel lbl02;
    private javax.swing.JLabel lbl10;
    private javax.swing.JLabel lbl11;
    private javax.swing.JLabel lbl12;
    private javax.swing.JLabel lbl20;
    private javax.swing.JLabel lbl21;
    private javax.swing.JLabel lbl22;
    private javax.swing.JLabel lblEmpate;
    private javax.swing.JLabel lblEmpateValue;
    private javax.swing.JLabel lblJogador1;
    private javax.swing.JLabel lblJogador2;
    private javax.swing.JLabel lblValue1;
    private javax.swing.JLabel lblValue2;
    // End of variables declaration//GEN-END:variables

    public String getJogador1() {
        return jogador1;
    }

    public String getJogador2() {
        return jogador2;
    }
    
    private void setJogador1(String jogador1) {
        if(jogador1 == null || jogador1.isEmpty())
            this.jogador1 = "Jogador1";
        else        
            this.jogador1 = jogador1;
    }

    private void setJogador2(String jogador2) {
        if(jogador2 == null || jogador2.isEmpty())
            this.jogador2 = "Jogador2";
        else        
            this.jogador2 = jogador2;
        
    }

    public void setVitorias1(int vitorias1) {
        this.vitorias1 = vitorias1;
    }

    public void setVitorias2(int vitorias2) {
        this.vitorias2 = vitorias2;
    }

    public int getVitorias1() {
        return vitorias1;
    }

    public int getVitorias2() {
        return vitorias2;
    }
    
    public void setEmpate(int empate) {
        this.empate = empate;
    }

    public int getEmpate() {
        return empate;
    }
}
