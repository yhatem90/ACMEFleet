package com.vehicle;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle")
public class Vehicle {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) int id;
	@Column(name = "vin")
	private String VIN;
	@Column(name = "make")
	private String make;
	@Column(name = "model")
	private String model;
	@Column(name = "year")
	private int year;
	@Column(name = "seatcapacity")
	private int seatCapacity;
	@Column(name = "roofrackavailable")
	private boolean roofRackAvailable;
	@Column(name = "haulcapacity")
	private int haulCapacity;
	@Column(name = "sidecaravailable")
	private boolean sideCarAvailable;
	@Column(name = "type")
	private String  type;

//	public enum vType {
//		CAR("CAR"), TRUCK("TRUCK"), MOTORCYCLE("MOTORCYCLE");
//
//		private String value;
//
//		public String getVehicleType() {
//			return value;
//		}
//
//		vType(String value) {
//			this.value = value;
//		}
//	}

	Vehicle() {
	}

	public Vehicle(String vin, String make, String model, int year, int seatCapacity, boolean roofrack, boolean sidecar,
			int hault, String type) {
		super();
		this.VIN = vin;
		this.make = make;
		this.model = model;
		this.year = year;
		this.seatCapacity = seatCapacity;
		this.roofRackAvailable = roofrack;
		this.sideCarAvailable = sidecar;
		this.haulCapacity = hault;
		this.type = type;
	}

	public String getVIN() {
		return VIN;
	}

	public void setVIN(String vIN) {
		VIN = vIN;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	public boolean getRoofRackAvailable() {
		return roofRackAvailable;
	}

	public void setRoofRackAvailable(boolean roofRackAvailable) {
		this.roofRackAvailable = roofRackAvailable;
	}

	public int getHaulCapacity() {
		return haulCapacity;
	}

	public void setHaulCapacity(int haulCapacity) {
		this.haulCapacity = haulCapacity;
	}

	public boolean getSideCarAvailable() {
		return sideCarAvailable;
	}

	public void setSideCarAvailable(boolean sidecCarAvailable) {
		this.sideCarAvailable = sidecCarAvailable;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;
		if (!(o instanceof Vehicle))
			return false;
		Vehicle vehicle = (Vehicle) o;
		return Objects.equals(this.VIN, vehicle.VIN) && Objects.equals(this.make, vehicle.make)
				&& Objects.equals(this.model, vehicle.model) && Objects.equals(this.year, vehicle.year)
				&& Objects.equals(this.seatCapacity, vehicle.seatCapacity);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.VIN, this.make, this.model, this.year, this.seatCapacity);
	}

	@Override
	public String toString() {
		return "Vehicle{" + "VIN=" + this.VIN + ", make='" + this.make + '\'' + ", model='" + this.model + '\'' + '}';
	}

}