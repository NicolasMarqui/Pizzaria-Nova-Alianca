package control;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;

public class Masks {
    private static MaskFormatter dateMask;
    private static MaskFormatter cpfmask;
    
    public static MaskFormatter dateMask() throws ParseException {
        if( dateMask == null ) { // inicializa
            dateMask = new MaskFormatter( "##/##/##" );
            dateMask.setPlaceholderCharacter( '_' );
        }
        return dateMask;
    }
    
    public static MaskFormatter cpfmask() throws ParseException {
        if( cpfmask == null ) { // inicializa
        	cpfmask = new MaskFormatter( "###.###.###-##" );
        	cpfmask.setPlaceholderCharacter( '_' );
        }
        return cpfmask;
    }
}