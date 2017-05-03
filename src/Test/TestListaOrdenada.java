package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Exceptions.ListSizeOverflownException;
import Models.*;

public class TestListaOrdenada {

	private ListaOrdenada<Integer> c;

	@Test
	public void AddSuccess() {
		Setup();
		assert (c.add(9)); // ASSERT ASEGURA QUE SE HA AÑADIDO 9, SI SE AÑADE DEVUELVE TRUE SI NO FALLA LA PRUEBA
		
	}
	
	@Test
	public void AddFail(){
		Setup();
		for(int i = 0; i< 10; i++){
			c.add(i);
		}
		// PARA CAPTURAR LA EXCsEPCION
		try{
			c.add(10);
		}
		catch(ListSizeOverflownException e){
			assert (c.size() == 10);
			assert (!c.contains(10));
		}
	}
	
	@Test
	public void AddAllSuccess(){
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(2);
		a.add(1);
		assert(c.addAll(a));
	}
	@Test
	public void ReverseSucces(){
		c.add(2);
		c.add(23);
		c.Reverse();
	}
	
	@Test
	public void minSuccess(){
		Setup();
		c.add(10);
		c.add(1);
		c.min();
	}
	
	@Test
	public void maxSuccess(){
		Setup();
		c.add(10);
		c.add(1);
		c.max();
	}
	
	@Before
	public void Setup(){
		c = new ListaOrdenada<Integer>((Integer a, Integer b)-> a-b);
		
	}

}
