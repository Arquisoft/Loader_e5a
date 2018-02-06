package model;

/**
 * Clase que guarda la localizacion de los usuarios
 * @author Tania Alvarez Diaz
 *
 */
public class Location {
	
	private double latitude; //0° y 90 °: Hemisferio Norte; 0° y -90°: Hemisferio Sur
	private double longitud; //0° y 180°: Al este del meridiano de Greenwich; 0° y -180°: Al oeste del meridiano de Greenwich
	
	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}
	
	/**
	 * @param latitude the latitude to set
	 */
	private void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	/**
	 * @return the longitud
	 */
	public double getLongitud() {
		return longitud;
	}
	
	/**
	 * @param longitud the longitud to set
	 */
	private void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	/**
	 * @param latitude
	 * @param longitud
	 */
	public Location(double latitude, double longitud) {
		setLatitude(latitude);
		setLongitud(longitud);
	}
}
