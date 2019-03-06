import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Paciente {

	private static int puerto = 8000;
	static DataInputStream flujoEntrada;
	static ObjectOutputStream flujoSalida;
	

	/**
	 * Paciente seria como el cliente
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			Socket paciente = new Socket("localhost", puerto);
			// creamos el flujo de salida a la maquina y el flujo de entrada de la maquina
			flujoEntrada = new DataInputStream(paciente.getInputStream());
			flujoSalida = new ObjectOutputStream(paciente.getOutputStream());
			
			HiloPacienteRecibir hiloRecibir = new HiloPacienteRecibir(flujoEntrada);
			HiloPacienteEnviar hiloEnviar = new HiloPacienteEnviar(flujoSalida);
			
			hiloRecibir.start();
			hiloEnviar.start();
			
						
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
