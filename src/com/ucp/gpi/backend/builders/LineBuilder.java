package com.ucp.gpi.backend.builders;

import com.ucp.gpi.backend.model.Canton;
import com.ucp.gpi.backend.model.Line;
import com.ucp.gpi.backend.model.Station;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

/**
 * 
 * @author matthieu
 * 23/01/2018
 *
 */
public class LineBuilder {
	
	private static final String[] LINERERMAPPING = {"Code_UIC", "Libelle_point_arret", "train", "RER", "tram", "bus", "A", "B", "C", "D", "E", "F", "H", "J", "K", "L", "N", "P", "R", "U", "T4", "TER", "T11"};
	private static final String LINERERPATH = System.getProperty("user.dir") + "/src/com/ucp/gpi/backend/res/lignes-par-gare-sur-le-reseau-transilien.csv";

	
	public LineBuilder() {
		
	}
	
	public Line creatLineFromFile(String line_name) {
		
		System.out.println(LINERERPATH);

		Line line = new Line();
		//name and ID
		line.setName("Ligne " + line_name);
		line.setID(UUID.randomUUID().toString());
		
		
		StationBuilder sBuilder = new StationBuilder();
		CantonBuilder cBuilder = new CantonBuilder();
		
		//array list of stations from CSV file
		try {
			FileReader fileReader = new FileReader(new File(LINERERPATH));
			CSVFormat format = CSVFormat.DEFAULT.withHeader(LINERERMAPPING).withDelimiter(';');
			CSVParser reader = new CSVParser(fileReader, format);
			
			ArrayList<CSVRecord> csvRecords = new ArrayList<CSVRecord>();
			csvRecords = (ArrayList<CSVRecord>) reader.getRecords();
			
			int i;
			for(i=1; i<csvRecords.size(); i++){
				CSVRecord record = csvRecords.get(i);
				
				if(record.get(line_name).equals("1")) {
					Station newStation = sBuilder.CreatStation((String)record.get("Libelle_point_arret"), record.get("Code_UIC"));
					line.getStations().add(newStation);
				}
				
			}
			reader.close();
			fileReader.close();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
		line.setNb_stations(line.getStations().size());
		
		//array list of canton
		for(int i=0; i<line.getNb_stations()-1; i++) {
			Canton canton = cBuilder.creatCanton(line.getStations().get(i), line.getStations().get(i+1));
			line.getCantons().add(canton);
		}
		
		line.setNb_cantons(line.getCantons().size());
		
		//array list of train
			//nothing, will be create by a other process
		
		
		
		return line;
	}

	/**
	 * This method will create a Line object that will be useful for the tests
	 * @param ID is the new ID of the line
	 * @param Name is the new name of the line
	 * @param nbStation is the number of station of the line
	 * @param nbCanton is the number of canton of the line
	 * @param Color is the color of the line
	 * @param nbTrain is the number of train of the line
	 * @param Capacity is the capacity of the line
	 * @param nbUser is the number of user of the line
	 * @return a line object that will be used in the testLine class
	 */
	public Line testLine(String ID,String Name,int nbStation,int nbCanton, String Color,int nbTrain,int Capacity,int nbUser){
		Line line = new Line();
		line.setID(ID);
		line.setName(Name);
		line.setNb_cantons(nbCanton);
		line.setNb_stations(nbStation);
		line.setCapacity(Capacity);
		line.setNbUser(nbUser);
		line.setColor(Color);
		line.setNb_train(nbTrain);

		return line;
	}
}
