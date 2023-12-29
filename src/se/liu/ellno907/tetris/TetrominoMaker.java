package se.liu.ellno907.tetris;

public class TetrominoMaker
{
    public int getNumberOfTypes(){
	int numberoftypes = SquareType.values().length;
	return numberoftypes;
    }

    public Poly getPoly(int n){

	SquareType[] a = SquareType.values();
	if (n > SquareType.values().length){
	    throw new IllegalArgumentException("Invalid index: " + n);
	}
	SquareType type = a[n];
	SquareType[][] newarray = new SquareType[0][0];
	Poly newpoly = new Poly(newarray);
	switch (type) {
	    case I:
		newarray = polyI(type);
		break;
	    case O:
		newarray = polyO(type);
		break;
	    case T:
		newarray = polyT(type);
		break;
	    case S:
		newarray = polyS(type);
		break;
	    case Z:
		newarray = polyZ(type);
		break;
	    case J:
		newarray = polyJ(type);
		break;
	    case L:
		newarray = polyL(type);
		break;
	    default:
		break;
	}
	newpoly = new Poly(newarray);
	return newpoly;
    }

    public SquareType[][] polyI(SquareType type){
	SquareType[][] newpoly = new SquareType[4][4];
	for (int i = 0; i < 4; i++) {
	    for (int j = 0; j < 4; j++) {
		if (i == 1){
		    newpoly[i][j] = type;
		}
		else{
		    newpoly[i][j] = SquareType.EMPTY;
		}
	    }
	}
	return newpoly;
    }

    public static SquareType[][] polyO(SquareType type){
	SquareType[][] newpoly = new SquareType[2][2];
	newpoly[0][0] = type;
	newpoly[0][1] = type;
	newpoly[1][0] = type;
	newpoly[1][1] = type;
	return newpoly;
    }

    public static SquareType[][] polyT(SquareType type){
	SquareType[][] newpoly = new SquareType[3][3];
	for (int i = 0; i < 3; i++) {
	    for (int j = 0; j < 3; j++) {
		if (i == 1 || i == 0 && j == 1){
		    newpoly[i][j] = type;
		}
		else{
		    newpoly[i][j] = SquareType.EMPTY;
		}
	    }
	}
	return newpoly;
    }

    public static SquareType[][] polyS(SquareType type){
	SquareType[][] newpoly = new SquareType[3][3];
	for (int i = 0; i < 3; i++) {
	    for (int j = 0; j < 3; j++) {
		if (i == 1 && j != 2 || i == 0 && j != 0){
		    newpoly[i][j] = type;
		}
		else{
		    newpoly[i][j] = SquareType.EMPTY;
		}
	    }
	}
	return newpoly;
    }

    public static SquareType[][] polyZ(SquareType type){
	SquareType[][] newpoly = new SquareType[3][3];
	for (int i = 0; i < 3; i++) {
	    for (int j = 0; j < 3; j++) {
		if (i == 0 && j != 2 || i == 1 && j != 0){
		    newpoly[i][j] = type;
		}
		else{
		    newpoly[i][j] = SquareType.EMPTY;
		}
	    }
	}
	return newpoly;
    }

    public static SquareType[][] polyJ(SquareType type){
	SquareType[][] newpoly = new SquareType[3][3];
	for (int i = 0; i < 3; i++) {
	    for (int j = 0; j < 3; j++) {
		if (i == 1 || i == 0 && j == 0){
		    newpoly[i][j] = type;
		}
		else{
		    newpoly[i][j] = SquareType.EMPTY;
		}
	    }
	}
	return newpoly;
    }

    public static SquareType[][] polyL(SquareType type){
	SquareType[][] newpoly = new SquareType[3][3];
	for (int i = 0; i < 3; i++) {
	    for (int j = 0; j < 3; j++) {
		if (i == 1 || i == 0 && j == 2){
		    newpoly[i][j] = type;
		}
		else{
		    newpoly[i][j] = SquareType.EMPTY;
		}
	    }
	}
	return newpoly;
    }

    public StringBuilder polyToTextConverter(Poly newpoly2) {
	StringBuilder textpoly = new StringBuilder();
	for (int i = 0; i < newpoly2.getPolyLength(); i++) {
	    if (i > 0) {
		textpoly.append("\n");
	    }
	    for (int j = 0; j < newpoly2.getPolyLength(); j++) {
		if (newpoly2.getTypeAtCord(i, j) == SquareType.EMPTY) {
		    textpoly.append("+");
		} else {
		    textpoly.append(newpoly2.getTypeAtCord(i, j));
		}
	    }
	}
	return textpoly;
    }
}
