import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class HiloServidor extends Thread {

	ObjectInputStream flujoEntrada;
	DataOutputStream flujoSalida;
	ConstantesYVitales constantes;
	Socket paciente = null;

	public HiloServidor(Socket socket) {
		this.paciente = socket;
		// inicializamos los flujos de entrada y de salida
		try {
			flujoSalida = new DataOutputStream(socket.getOutputStream());
			flujoSalida.flush();
			flujoEntrada = new ObjectInputStream(socket.getInputStream());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// tarea a realizar con cada cliente
		try {
	
			while (true) {
				System.out.println("COMUNICO CON: " + paciente.toString());
				constantes = (ConstantesYVitales) flujoEntrada.readObject();
				System.out.println(constantes.toString());
				int valor = constantes.controlarValores();

				if (valor > 0) {
					flujoSalida.writeUTF(constantes.mostrarAlarma(valor));
				}
			}

		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
