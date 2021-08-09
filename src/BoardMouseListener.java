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
        // determine which destination square is selected (endx and endy)
        int endx = e.getX()/Chess.PIECESIZE;
        int endy = e.getY()/Chess.PIECESIZE;

        // limiting movements:
            // can't move off board
                // make sure startx starty endx endy are all in the range 0 to 7
        if(startx<0 || startx>=8 || starty<0 || starty>=8 || endx<0 || endx>=8 || endy<0 || endy>=8) {
            return;
        }
            // don't let the person move a piece to its own square
        if(Chess.position[startx][starty]!=null && Chess.position[endx][endy]!=null && Chess.position[endx][endy].isBlackPlayer==Chess.position[startx][starty].isBlackPlayer) {
            return;
        }
            // if startx==endx and starty==endy then don't do the move
        if(startx==endx && starty==endy) {
            return;
        }
            // can't choose a square that has no piece
        if(Chess.position[startx][starty]==null) {
            return;
        }
            // can't move black pieces
        if(Chess.position[startx][starty].isBlackPlayer) {
            return;
        }
            // only allow valid moves
        if(!Chess.position[startx][starty].canMove(startx, starty, endx, endy)) {
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
            // only allow valid moves
            if(!Chess.position[startx][starty].canMove(startx, starty, endx, endy)) {
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
