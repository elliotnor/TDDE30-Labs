package se.liu.ellno907.tetris;

import javax.swing.*;
import java.awt.*;

public class TetrisViewerOld
{
    private Board board;

    public TetrisViewerOld(Board board) {
	this.board = board;
    }

    public void show(){
	JFrame frame = new JFrame();
	JTextArea textarea = new JTextArea(board.getHeight(), board.getWidth());
	BoardToTextConverter textconvert = new BoardToTextConverter("");
	String convertedtext = textconvert.convertToText(board);
	textarea.setText(convertedtext);
	frame.setLayout(new BorderLayout());
	frame.add(textarea,BorderLayout.CENTER);
	textarea.setFont(new Font("Monospaced", Font.PLAIN, 20));
	frame.pack();
	frame.setVisible(true);
    }
}
