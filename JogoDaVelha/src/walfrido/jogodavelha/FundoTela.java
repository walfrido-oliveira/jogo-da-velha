/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package walfrido.jogodavelha;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;


/**
 *
 * @author Supervisor
 */
public class FundoTela extends javax.swing.JPanel {
    
    BufferedImage b;
    Rectangle2D rect;
    
    public FundoTela(){
        try{
        b = ImageIO.read(getClass().getResourceAsStream("/imagens/tercos.jpg"));
        rect = new Rectangle(0,0,326,350);
        
        }catch(IOException ex){
            System.out.println(ex.toString());
        }
        
    }

    @Override
    public void paintComponent(Graphics g){
        
        TexturePaint p = new TexturePaint(b, rect);
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(p);
        g2.fillRect(0, 0, this.getWidth(), this.getHeight());
    }
}
