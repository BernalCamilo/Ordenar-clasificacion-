package model;

public class Paises implements Comparable<Paises>{
	private String name;
	private int medallasOroMasculino;
	private int medallasPlataMasculino;
	private int medallasBronceMasculino;
	private int medallasOroFemenino;
	private int medallasPlataFemenino;
	private int medallasBronceFemenino;
	
	public Paises(String name, int medallasOroHombre, int medallasPlataHombre, int medallasBronceHombre,
			int medallasOroFemenino, int medallasPlataFemenino, int medallasBronceFemenino) {
		super();
		this.name = name;
		this.medallasOroMasculino = medallasOroHombre;
		this.medallasPlataMasculino = medallasPlataHombre;
		this.medallasBronceMasculino = medallasBronceHombre;
		this.medallasOroFemenino = medallasOroFemenino;
		this.medallasPlataFemenino = medallasPlataFemenino;
		this.medallasBronceFemenino = medallasBronceFemenino;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMedallasOroHombre() {
		return medallasOroMasculino;
	}

	public void setMedallasOroHombre(int medallasOroHombre) {
		this.medallasOroMasculino = medallasOroHombre;
	}

	public int getMedallasPlataHombre() {
		return medallasPlataMasculino;
	}

	public void setMedallasPlataHombre(int medallasPlataHombre) {
		this.medallasPlataMasculino = medallasPlataHombre;
	}

	public int getMedallasBronceHombre() {
		return medallasBronceMasculino;
	}

	public void setMedallasBronceHombre(int medallasBronceHombre) {
		this.medallasBronceMasculino = medallasBronceHombre;
	}

	public int getMedallasOroFemenino() {
		return medallasOroFemenino;
	}

	public void setMedallasOroFemenino(int medallasOroFemenino) {
		this.medallasOroFemenino = medallasOroFemenino;
	}

	public int getMedallasPlataFemenino() {
		return medallasPlataFemenino;
	}

	public void setMedallasPlataFemenino(int medallasPlataFemenino) {
		this.medallasPlataFemenino = medallasPlataFemenino;
	}

	public int getMedallasBronceFemenino() {
		return medallasBronceFemenino;
	}

	public void setMedallasBronceFemenino(int medallasBronceFemenino) {
		this.medallasBronceFemenino = medallasBronceFemenino;
	}

	@Override
	public int compareTo(Paises o) {
		Paises A = this;
		Paises B = o;
		if (A.getMedallasOroFemenino()-B.medallasOroFemenino  == 0) {
			if (A.getMedallasPlataFemenino()-B.getMedallasPlataFemenino() == 0) {
				if (A.getMedallasBronceFemenino()-B.getMedallasBronceFemenino() == 0) {
					return (A.getName().compareTo(B.getName()))*-1;
				} else {
					return A.getMedallasBronceFemenino()-B.getMedallasBronceFemenino();
				}
			} else {
				return A.getMedallasPlataFemenino()-B.getMedallasPlataFemenino();
			}
		} else {
			return A.getMedallasOroFemenino()-B.medallasOroFemenino;
		}
		
	}
}
