import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Maquinita {

	/**
	 * La maquinita sera como el servidor
	 * 
	 * @param args
	 */

	private static int puerto = 8000;
	private static Socket paciente;

	public static void main(String[] args) {

		try {
			ServerSocket maquinita = new ServerSocket(puerto);
			System.out.println("Servidor iniciado ...");

			while (true) {
				Socket paciente = new Socket();
				paciente = maquinita.accept();
				System.out.println("pacinete aceptado");
				HiloServidor hilo = new HiloServidor(paciente);
				
				hilo.start();

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
