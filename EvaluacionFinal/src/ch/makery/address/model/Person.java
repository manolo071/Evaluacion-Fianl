package ch.makery.address.model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model class for a Person.
 *
 * @author Marco Jakob
 */
public class Person {

	private final StringProperty Nombre;
	private final StringProperty Apellido;
	private final StringProperty Calle;
	private final IntegerProperty Codigopostal;
	private final StringProperty Ciudad;
	private final ObjectProperty<LocalDate> Nacimiento;

	/**
	 * Default constructor.
	 */
	public Person() {
		this(null, null);
	}
	
	/**
	 * Constructor with some initial data.
	 * 
	 * @param Nombre
	 * @param Apellido
	 */
	public Person(String Nombre, String Apellido) {
		this.Nombre = new SimpleStringProperty(Nombre);
		this.Apellido = new SimpleStringProperty(Apellido);
		
		// Some initial dummy data, just for convenient testing.
		this.Calle = new SimpleStringProperty("some Calle");
		this.Codigopostal = new SimpleIntegerProperty(1234);
		this.Ciudad = new SimpleStringProperty("some Ciudad");
		this.Nacimiento = new SimpleObjectProperty<>(LocalDate.of(1999, 2, 21));
	}
	
	public String getNombre() {
		return Nombre.get();
	}

	public void setNombre(String Nombre) {
		this.Nombre.set(Nombre);
	}
	
	public StringProperty NombreProperty() {
		return Nombre;
	}

	public String getApellido() {
		return Apellido.get();
	}

	public void setApellido(String Apellido) {
		this.Apellido.set(Apellido);
	}
	
	public StringProperty ApellidoProperty() {
		return Apellido;
	}

	public String getCalle() {
		return Calle.get();
	}

	public void setCalle(String Calle) {
		this.Calle.set(Calle);
	}
	
	public StringProperty CalleProperty() {
		return Calle;
	}

	public int getCodigopostal() {
		return Codigopostal.get();
	}

	public void setCodigopostal(int Codigopostal) {
		this.Codigopostal.set(Codigopostal);
	}
	
	public IntegerProperty CodigopostalProperty() {
		return Codigopostal;
	}

	public String getCiudad() {
		return Ciudad.get();
	}

	public void setCiudad(String Ciudad) {
		this.Ciudad.set(Ciudad);
	}
	
	public StringProperty CiudadProperty() {
		return Ciudad;
	}

	public LocalDate getNacimiento() {
		return Nacimiento.get();
	}

	public void setNacimiento(LocalDate Nacimiento) {
		this.Nacimiento.set(Nacimiento);
	}
	
	public ObjectProperty<LocalDate> NacimientoProperty() {
		return Nacimiento;
	}
}