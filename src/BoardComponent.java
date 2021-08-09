import javax.swing.*;
import java.awt.*;

public class BoardComponent extends JComponent {
    protected void paintComponent(Graphics g) {
        // make color objects for tiles
        Color lightbrown=new Color(233,174,95);
        Color darkbrown=new Color(177,113,24);

        // draw the 64 tiles
            // use fillRect: needs top-left corner, width, height
                // top left is 0,0
                // width and height? Chess.PIECESIZE or 44
            // make a nested for x and for y loop
                // if x and y are both even (x%2==0) or both odd, then draw a dark square
                // otherwise draw a light one
        for(int x=0; x<8; x++) {
            for(int y=0; y<8; y++) {
                if(x%2==y%2){
                    g.setColor(lightbrown);
                }
                else {
                    g.setColor(darkbrown);
                }
                g.fillRect(x*Chess.PIECESIZE, y*Chess.PIECESIZE, Chess.PIECESIZE, Chess.PIECESIZE);
            }
        }

        // go through each position entry and call drawPiece if the entry contains a valid (not null) piece
        for(int x=0; x<8; x++) {
            for(int y=0; y<8; y++){
                if(Chess.position[x][y]!=null) {
                    Piece.drawPiece(x, y, g);
                }
            }
        }
    }
}
