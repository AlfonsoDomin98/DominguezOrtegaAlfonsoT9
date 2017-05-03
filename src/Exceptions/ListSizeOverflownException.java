package Exceptions;

public class ListSizeOverflownException extends RuntimeException {
	public ListSizeOverflownException(){
		super("[HA SOBREPASADO EL TAMAÑO LIMITE]");
	}
}
