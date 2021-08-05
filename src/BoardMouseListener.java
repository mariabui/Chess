import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.InputMismatchException;

public class BoardMouseListener implements MouseListener {
    private int startx, starty;

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        // save selected piece and store the coordinates in field variables startx and starty
        startx = e.getX()/Chess.PIECESIZE;
        starty = e.getY()/Chess.PIECESIZE;
    }

    public void mouseReleased(MouseEvent e) {
        // determine which destination square is selected (endx and endy) and move the piece
        int endx = e.getX()/Chess.PIECESIZE;
        int endy = e.getY()/Chess.PIECESIZE;

        // illegal conditions
            // move off board
        if(startx<0 || startx>=8 || starty<0 || endx<0 || endx>=8 || endy<0 || endy>=8) {
            return;
        }
            // move onto own color
        if(Chess.position[startx][starty]!=null && Chess.position[endx][endy]!=null && Chess.position[endx][endy].isBlackPlayer==Chess.position[startx][starty].isBlackPlayer) {
            return;
        }

            // move onto self
        if(startx==endx && starty==endy) {
            return;
        }
            // choose a square that has no piece
        if(Chess.position[startx][starty] == null) {
            return;
        }

        Chess.position[endx][endy] = Chess.position[startx][starty];
        // set the old position[][] entry to null
        Chess.position[startx][starty] = null;
        // repaint to show the move
        Chess.boardcomponent.repaint();

        // make a random computer player
        while(true) {
            // choose a startx, starty, endx, endy using Math.random()
            startx = (int)(Math.random()*8);
            starty = (int)(Math.random()*8);
            endx = (int)(Math.random()*8);
            endy = (int)(Math.random()*8);
            // if Chess.position[startx][starty] is null, call continue to try again
            if(Chess.position[startx][starty]==null) {
                continue;
            }
            // if startx==endx and starty==endy, call continue to try again
            if(startx==endx && starty==endy) {
                continue;
            }
            // if the piece is white, call continue to try again
            if(!Chess.position[startx][starty].isBlackPlayer) {
                continue;
            }
            // do not move black piece on black piece
            if(Chess.position[startx][starty]!=null && Chess.position[endx][endy]!=null && Chess.position[endx][endy].isBlackPlayer==Chess.position[startx][starty].isBlackPlayer) {
                continue;
            }
            // do the movement, call repaint, and break from the loop
            Chess.position[endx][endy] = Chess.position[startx][starty];
            // set the old position[][] entry to null
            Chess.position[startx][starty] = null;
            // repaint to show the move
            Chess.boardcomponent.repaint();
            break;
        }
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}
