package se.liu.ellno907.tetris;

public class BoardToTextConverter {

    private String converter;

    public BoardToTextConverter(final String converter) {
        this.converter = converter;
    }

    public String convertToText(Board board){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < board.getWidth(); i++) {
            for (int j = 0; j < board.getHeight(); j++) {
                if (j == board.getHeight() - 1){
                    builder.append("\n");
                    continue;
                }
                SquareType square = board.getVisibleSquareAt(i,j);
                if (square == null){
                    continue;
                }
                switch (square) {
                    case EMPTY:
                        builder.append("-");
                        break;
                    case I:
                        builder.append("#");
                        break;
                    case O:
                        builder.append("¤");
                        break;
                    case T:
                        builder.append("%");
                        break;
                    case S:
                        builder.append("&");
                        break;
                    case Z:
                        builder.append("(");
                        break;
                    case J:
                        builder.append(")");
                        break;
                    case L:
                        builder.append("?");
                        break;
                    case OUTSIDE:
                        builder.append("+");
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
