package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PaisesData {
	public ArrayList<Paises> paisesData;

	public PaisesData() {
		paisesData = new ArrayList<>();
		load();
	}
	
	public void load() {
		try {
			FileInputStream is;
			is = new FileInputStream(new File("listaPaises.txt"));
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			String line;
			String json="";
			while ((line= reader.readLine())!= null) {
				String[] datosSeparados = line.split(";");
				//las tres primeras son de masculino(oro, plata, bronce) las siguientes tres son femeninas(oro, plata, bronce)
				int[] medallas = new int [6]; 
				for (int i = 1; i<datosSeparados.length; i++) {
					medallas[i-1]=Integer.parseInt(datosSeparados[i]);
				}
				paisesData.add(new Paises(datosSeparados[0], medallas[0], medallas[1], medallas[2], medallas[3], medallas[4], medallas[5]));
			}
			
		} catch (Exception e) {
			
		} 
	}
	public void bubbleSort() {
		for(int i = 0; i<paisesData.size()-1;i++) {
			for (int j=0; j<paisesData.size()-1; j++) {
				int medallasOroA = paisesData.get(j).getMedallasOroFemenino()+paisesData.get(j).getMedallasOroHombre();
				int medallasOroB = paisesData.get(j+1).getMedallasOroFemenino()+paisesData.get(j+1).getMedallasOroHombre();
				if (medallasOroA==medallasOroB) {
					
					int medallasPlataA = paisesData.get(j).getMedallasPlataFemenino()+paisesData.get(j).getMedallasPlataHombre();
					int medallasPlataB = paisesData.get(j+1).getMedallasPlataFemenino()+paisesData.get(j+1).getMedallasPlataHombre();
					
					if (medallasPlataA==medallasPlataB) {
						
						int medallasBronceA = paisesData.get(j).getMedallasBronceFemenino()+paisesData.get(j).getMedallasBronceHombre();
						int medallasBronceB = paisesData.get(j+1).getMedallasBronceFemenino()+paisesData.get(j+1).getMedallasBronceHombre();
						
						if (medallasBronceA==medallasBronceB) {
							int z = paisesData.get(j).getName().compareTo(paisesData.get(j).getName());
							if (z==-1) {
								Collections.swap(paisesData, j, j+1);
							}
						} else {
							if (medallasBronceA<medallasBronceB) {
								Collections.swap(paisesData, j, j+1);
							}
						}
					}else {
						if(medallasPlataA<medallasPlataB) {
							Collections.swap(paisesData, j, j+1);
						}
					}
				} else {
					if(medallasOroA<medallasOroB) {
						Collections.swap(paisesData, j, j+1);
					}
				}
			}
		}
	}
	
	public void compareMasculino() {
		Collections.sort(paisesData, new Comparator<Paises>(){

			@Override
			public int compare(Paises o1, Paises o2) {
				if(o1.getMedallasOroHombre()-o2.getMedallasOroHombre() == 0) {
					if (o1.getMedallasPlataHombre()-o2.getMedallasPlataHombre() == 0) {
						if (o1.getMedallasBronceHombre()-o2.getMedallasBronceHombre() == 0) {
							return o1.getName().compareTo(o2.getName());
						} else {
							return (o1.getMedallasBronceHombre()-o2.getMedallasBronceHombre())*-1;
						}
					} else {
						return (o1.getMedallasPlataHombre()-o2.getMedallasPlataHombre())*-1;
					}
				} else { 
					return (o1.getMedallasOroHombre()-o2.getMedallasOroHombre())*-1;
				}
				
			};
			
		});
	}
	
	public void stringData() {
		//masculino
		compareMasculino();
		System.out.println("Masculino");
		for(Paises p: paisesData) {
			System.out.println(p.getName()+" "+p.getMedallasOroHombre()+" "+p.getMedallasPlataHombre()+" "+p.getMedallasBronceHombre());
		}
		
		//femeninos
		System.out.println("----------");
		System.out.println("Femenino");
		Collections.sort(paisesData);
		for (Paises p: paisesData) {
			System.out.println(p.getName()+" "+p.getMedallasOroFemenino()+" "+p.getMedallasPlataFemenino()+" "+p.getMedallasBronceFemenino());
		}
		
		//Global
		System.out.println("----------");
		System.out.println("Combinado");
		bubbleSort();
		for (Paises p: paisesData) {
			int oro = p.getMedallasOroHombre()+p.getMedallasOroFemenino();
			int plata = p.getMedallasPlataFemenino()+p.getMedallasPlataHombre();
			int bronce = p.getMedallasBronceFemenino()+p.getMedallasBronceHombre();
			System.out.println(p.getName()+" "+oro+" "+plata+" "+bronce);
		}
	} 
	
	
}
