import java.io.Serializable;

public class ConstantesYVitales implements Serializable {
	private static final long serialVersionUID = 1542746089406143732L;
	private static final int MAX_TEMPERATURA = 42;
	private static final int MIN_TEMPERATURA = 35;
	private static final int MIN_PULSO = 60;
	private static final int MAX_PULSO = 100;
	private static final int MIN_SISTOLICA = 120;
	private static final int MAX_SISTOLICA = 140;
	private static final int MIN_DIASTOLICA = 70;
	private static final int MAX_DIASTOLICA = 90;
	private static final int TEMP_ALTA = 1; // 0001
	private static final int PULSO_ALTO = 2;// 0010
	private static final int SISTOLICA_ALTA = 4; // 0100
	private static final int DIASTOLICA_ALTA = 8;// 1000

	private double temperatura;
	private double pulso;// frecuencia cardiaca
	private double presion_sistolica;
	private double presion_diastolica;

	public ConstantesYVitales(int valor) {
		this.temperatura = Math.round((Math.random() * (MAX_TEMPERATURA - MIN_TEMPERATURA) + MIN_TEMPERATURA) * 100)
				/ 100d;
		this.pulso = Math.round((Math.random() * (MAX_PULSO + valor - MIN_PULSO) + MIN_PULSO) * 100) / 100d;
		this.presion_sistolica = Math
				.round((Math.random() * (MAX_SISTOLICA + valor - MIN_SISTOLICA) + MIN_SISTOLICA) * 100) / 100d;
		this.presion_diastolica = Math
				.round((Math.random() * (MAX_DIASTOLICA + valor - MIN_DIASTOLICA) + MIN_DIASTOLICA) * 100) / 100d;

	}

	public ConstantesYVitales(double temperatura, double pulso, double presion_sistolica, double presion_diastolica) {
		this.temperatura = temperatura;
		this.pulso = pulso;
		this.presion_sistolica = presion_sistolica;
		this.presion_diastolica = presion_diastolica;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	public double getPulso() {
		return pulso;
	}

	public void setPulso(double pulso) {
		this.pulso = pulso;
	}

	public double getPresion_sistolica() {
		return presion_sistolica;
	}

	public void setPresion_sistolica(double presion_sistolica) {
		this.presion_sistolica = presion_sistolica;
	}

	public double getPresion_diastolica() {
		return presion_diastolica;
	}

	public void setPresion_diastolica(double presion_diastolica) {
		this.presion_diastolica = presion_diastolica;
	}

	@Override
	public String toString() {
		return "ConstantesVitales [temperatura=" + temperatura + ", pulso=" + pulso + ", presion_sistolica="
				+ presion_sistolica + ", presion_diastolica=" + presion_diastolica + "]";
	}

	public int controlarValores() {
		// si se supera el valor máximo, sumamos a total el valor correspondiente a
		// dicha constante (temperatura alta, pulso alto,..)
		int total = 0;
		total += (this.temperatura >= MAX_TEMPERATURA) ? TEMP_ALTA : 0;
		total += (this.pulso >= MAX_PULSO) ? PULSO_ALTO : 0;
		total += (this.presion_sistolica >= MAX_SISTOLICA) ? SISTOLICA_ALTA : 0;
		total += (this.presion_diastolica >= MAX_DIASTOLICA) ? DIASTOLICA_ALTA : 0;

		return total;

	}

	/**
	 * 
	 * @param valores: es un entero con la suma de todas aquellas constantes vitales
	 *        que están muy altas
	 * @return retorna un mensaje de todas aquellas constantes que están muy altas.
	 */
	public String mostrarAlarma(int valores) {// realizamos una operación AND a nivel de bit para saber si está incluida
												// esa constante vital o no
		String mensaje = "";
		mensaje += (valores > 0) ? "****** PELIGRO, los siguientes valores son muy altos: " : "";
		mensaje += ((valores & TEMP_ALTA) == TEMP_ALTA) ? "[TEMPERATURA:" + this.temperatura + "] " : "";
		mensaje += ((valores & PULSO_ALTO) == PULSO_ALTO) ? "[PULSO:" + this.pulso + "] " : "";
		mensaje += ((valores & SISTOLICA_ALTA) == SISTOLICA_ALTA) ? "[SISTOLICA:" + this.presion_sistolica + "] " : "";
		mensaje += ((valores & DIASTOLICA_ALTA) == DIASTOLICA_ALTA) ? "[DIASTOLICA:" + this.presion_diastolica + "]"
				: "";
		return mensaje;

	}
}
