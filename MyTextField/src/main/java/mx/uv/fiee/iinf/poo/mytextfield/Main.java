/*
 */
package mx.uv.fiee.iinf.poo.mytextfield;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Windows
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame( "Numero de Telefono");
        frame.setSize( 300, 100 );
        frame.setLayout( new FlowLayout( FlowLayout.CENTER, 20, 20 ));
        frame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE);
        
        MyTextField mf = new MyTextField( );
        mf.setColumns( 20 );
        frame.add( mf );
        frame.setVisible( true );
        
    }
    
}
