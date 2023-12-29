package se.liu.ellno907.tetris;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * A class to start and run a game of tetris
 */
public class BoardTester
{
    public static void main(String[] args) {
	Board newboard = new Board(15,10);
	TetrisComponent component = new TetrisComponent(newboard);
	TetrisViewer viewer = new TetrisViewer(newboard);
	newboard.addBoardListener(component);
	viewer.show(component);
	final Action doOneStep = new AbstractAction() {
	    public void actionPerformed(ActionEvent e) {
		newboard.tick();
	    }
	};
	final Timer clockTimer = new Timer(400, doOneStep);
	clockTimer.setCoalesce(true);
	clockTimer.start();
    }
}
