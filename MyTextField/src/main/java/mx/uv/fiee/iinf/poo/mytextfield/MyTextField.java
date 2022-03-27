/*
 */
package mx.uv.fiee.iinf.poo.mytextfield;


import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author Windows
 */
public class MyTextField extends JTextField implements KeyListener {
    
    public MyTextField () {
        this.addKeyListener (this);
    }
    
    @Override
    public void keyTyped( KeyEvent e ) {
        
        if ( (!((e.getKeyChar () >= '0' && e.getKeyChar () <= '9') || 
                (e.getKeyChar () == '(' || e.getKeyChar () == ')' ) ||
                 e.getKeyChar() == ' ' )) ||
                (e.getKeyChar () == '(' && this.getText ().contains ("(")) || 
                (e.getKeyChar () == ')' && this.getText ().contains (")")) ||
                (e.getKeyChar () == ' ' && this.getText ().contains (" ")) ) {
            e.consume ();
        }
        
        
        
        
        if(this.getText().length()>=13){
            e.consume();
        }
            
    }

    @Override
    public void keyPressed (KeyEvent e) {
    }

    @Override
    public void keyReleased (KeyEvent e) {
        
        Pattern pattern = Pattern.compile ("\\(\\d{3}\\)\\s{1}\\d{7}");
        Matcher matcher = pattern.matcher (this.getText());
        
        if (matcher.find ()) {
            System.out.println (matcher.group ()); // imprimimos la cadena buscada
            this.setBackground(Color.WHITE);
            this.setForeground(Color.BLACK);
        }else{
            this.setBackground(Color.RED);
            this.setForeground(Color.WHITE); 
        }
    }
    
    
    @Override
    public void paint (Graphics g) {
        super.paint (g);

//        g.setColor (Color.red);
//        g.drawRect (getSize ().width - 25, getSize ().height - 30, 20, 20);
//
//        g.setColor(Color.red);
//        g.fillRect (getSize ().width - 25, getSize ().height - 30, 20, 20);
//
//        g.dispose ();

        try {
            URL url = getClass ().getResource ("/images/ico.png");
            File file = new File (url.getPath ());
            BufferedImage img = ImageIO.read (file);
            g.drawImage (img, getSize ().width - 22, getSize ().height - 22, null);
        }
        catch (IOException ex) {
            System.out.println (ex.getMessage ());
        }
    }

    
    
    
}




