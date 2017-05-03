package Models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


import Exceptions.ElementNotAllowedException;
import Exceptions.ListSizeOverflownException;

public class ListaOrdenada<E> extends ArrayList<E> {
		private ArrayList<E> Lista;
		private Comparator<E> Comparador;
		private final byte MAX_SIZE = 100;
		
		/**
		 * Constructor al cual pasamos un comparador
		 * @param comp
		 */
		public ListaOrdenada(Comparator<E> comp){
			this.Comparador = comp;
			this.Lista = new ArrayList<E>();
		}
		/**
		 * Si el elemento no es nulo entra en el primer if, si el tamaño de la lista
		 * es menor que MAX_Size entre en el if y añade el elemento y lo ordena, si no
		 * lanza una excepcion ListSizeOverflownException. Si no entre en el primer if
		 * lanza la excepcion ElementNotAllowedException
		 */
		@Override
		public boolean add(E element) {
			if(element != null){
				if(this.size() < MAX_SIZE){
					boolean estado = this.Lista.add(element);
					this.Lista.sort(Comparador);
					return estado;
				}
				else {
					throw new ListSizeOverflownException();
				}
			}
			else{
				throw new ElementNotAllowedException();
			}
		}
		
		@Override
		public boolean addAll(Collection<? extends E> coleccion) {
			if (coleccion.size() < MAX_SIZE) {
				return this.Lista.addAll(coleccion);
			} else {
				throw new ListSizeOverflownException();
			}
		}
		
		
		
		/**
		 * Muestra de forma inversa la lista con el metodo reverse.Order()
		 */
		public void Reverse(){
		Comparator<E> revers = Collections.reverseOrder();
		Collections.sort(this.Lista, revers);
			
		}
		
		/**
		 * Muestra el elemento menor
		 */
		public void min(){
			Collections.sort(this.Lista, new Comparator<E>(){
				@Override
				public int compare(E o1, E o2) {
					return this.reversed().compare(o2, o1);
				};
				
			});
			
		}
		
		/**
		 * Muestra el elemento mayor
		 * @return 
		 */
		public void max(){
			Collections.sort(this.Lista, new Comparator<E>(){
				@Override
				public int compare(E o1, E o2) {
					return this.compare(o1, o2);
				};
				
			});
			
	
			
		}
		
}
