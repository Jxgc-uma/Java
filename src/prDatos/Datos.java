package prDatos;

import java.util.Arrays;

public class Datos {

	private double datos[];
	private String[] errores;
	private double min, max;

	public Datos(String[] mis_datos, double minimo, double maximo) {
		min = minimo;
		max = maximo;
		int j = 0, k = 0;
		int l = mis_datos.length;

		double[] temp_datos = new double[l];
		String[] temp_errores = new String[l];

		for (int i = 0; i < mis_datos.length; i++) {
			try {
				temp_datos[j] = Double.parseDouble(mis_datos[i]);
				j += 1;
			}

			catch (NumberFormatException e) {

				temp_errores[k] = mis_datos[i];
				k += 1;
			}
		}
		datos = Arrays.copyOf(temp_datos, j);
		errores = Arrays.copyOf(temp_errores, k);
	}

	public double calcMedia() throws DatosException {
		int cont = 0;
		int longitud = 0;
		for (int i = 0; i < datos.length; i++) {
			if (datos[i] >= min && datos[i] <= max) {
				cont += datos[i];
				longitud += 1;
			}
			else { new DatosException("No hay datos en el rango especificado");}

		}
		double media = cont / longitud;
		return media;

	}

	public double calcDesvTipica() throws DatosException {
		double desTip = 0, cont = 0, sum = 0, potencia = 0, resta = 0, media = 0;
		media = calcMedia();
		for (int i = 0; i < datos.length; i++) {
			if (datos[i] >= min && datos[i] <= max) {
				resta = datos[i] - media;
				potencia = Math.pow(resta, 2);
				sum = sum + potencia;
				cont += 1;
			}
		}
		desTip = Math.sqrt(potencia/cont);
		return desTip;
	}
	
	public void setRango(String s) throws DatosException{
		int  ind = 0;
		ind = s.indexOf(";");
		min = Integer.parseInt(s.substring(0, ind));
		max = Integer.parseInt(s.substring(ind, ind + 1));
	}

}











































