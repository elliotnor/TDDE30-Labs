package se.liu.ellno907.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TetrisViewer
{
    private Board board;
    private JFrame frame;

    public TetrisViewer(Board board) {
	this.board = board;
	frame = new JFrame();
	initializeInputs();
    }

    private class MoveAction extends AbstractAction
    {
	private final Direction direction;

	private MoveAction(Direction direction) {
	    this.direction = direction;
	}

	@Override public void actionPerformed(final ActionEvent e) {
	    if (direction == Direction.LEFT || direction == Direction.RIGHT) {
		board.move(direction);
	    }
	}
    }

    private class RotateAction extends AbstractAction
    {
	private final Direction direction;

	private RotateAction(Direction direction) {
	    this.direction = direction;
	}

	@Override public void actionPerformed(final ActionEvent e) {
	    if (direction == Direction.LEFT || direction == Direction.RIGHT) {
		board.rotate(direction);
	    }

	}
    }

    /**
     * Defines the different type of keystrokes and
     * which action it corresponds to
     */
    public void initializeInputs(){
	JComponent pane = frame.getRootPane();
	InputMap inputs = pane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	inputs.put(KeyStroke.getKeyStroke("LEFT"), "left");
	inputs.put(KeyStroke.getKeyStroke("RIGHT"), "right");
	inputs.put(KeyStroke.getKeyStroke("UP"), "rightrotate");
	inputs.put(KeyStroke.getKeyStroke("DOWN"), "leftrotate");
	ActionMap actions = pane.getActionMap();
	actions.put("left", new MoveAction(Direction.LEFT));
	actions.put("right", new MoveAction(Direction.RIGHT));
	actions.put("leftrotate", new RotateAction(Direction.LEFT));
	actions.put("rightrotate", new RotateAction(Direction.RIGHT));
    }

    public void show(TetrisComponent comp){
	frame.add(comp,BorderLayout.CENTER);
	frame.pack();
	frame.setVisible(true);
    }
}
