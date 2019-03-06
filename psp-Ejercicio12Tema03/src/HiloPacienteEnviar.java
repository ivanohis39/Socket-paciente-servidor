import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

public class HiloPacienteEnviar extends Thread {

	ObjectOutputStream flujoSalida;

	

	public HiloPacienteEnviar(ObjectOutputStream flujoSalida) {
		super();
		this.flujoSalida = flujoSalida;
	}



	@Override
	public void run() {
		Random rd = new Random();
		int aleatorio = rd.nextInt(10);

		System.out.println(aleatorio);
		
		while (true) {
			try {
				ConstantesYVitales cosntantes = new ConstantesYVitales(aleatorio);
				flujoSalida.writeObject(cosntantes);
				flujoSalida.flush();
				flujoSalida.reset();
	
				sleep(10000);

				
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
