import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class HiloPacienteRecibir extends Thread {

	DataInputStream flujoEntrada;

	
	public HiloPacienteRecibir(DataInputStream flujoEntrada) {
		super();
		this.flujoEntrada = flujoEntrada;
	}


	@Override
	public void run() {
		// tarea a realizar cin cada paciente
		try {
		

			String cadena = "";
			while (true) {
				cadena = flujoEntrada.readUTF(); // obtenmos la cadena
				System.out.println(cadena);
				
			}

		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

}
