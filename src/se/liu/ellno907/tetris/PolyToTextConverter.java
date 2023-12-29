package se.liu.ellno907.tetris;

public class PolyToTextConverter
{
    private String converter;

    public PolyToTextConverter(final String converter) {
	this.converter = converter;
    }

    public String convertToText(Poly board){ //Hur får man den att inte vara static?
	StringBuilder builder = new StringBuilder();
	for (int i = 0; i < board.getPolyLength(); i++) {
	    for (int j = 0; j < board.getPolyLength(); j++) {
		if (j == board.getPolyLength()-1){
		    builder.append("\n");
		    continue;
		}
		SquareType square = board.getPolySquares()[i][j];
		if (square == null){
		    continue;
		}
		switch (square) {
		    case EMPTY:
			builder.append("+");
			break;
		    case I:
			builder.append("I");
			break;
		    case O:
			builder.append("O");
			break;
		    case T:
			builder.append("T");
			break;
		    case S:
			builder.append("S");
			break;
		    case Z:
			builder.append("Z");
			break;
		    case J:
			builder.append("J");
			break;
		    case L:
			builder.append("L");
			break;
		    default:
			break;
		}
	    }
	}
	String result = builder.toString();
	return result;
    }
}
