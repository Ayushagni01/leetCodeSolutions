package com.location.web.flight.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.location.web.flight.entities.Reservation;

@Component
public class PDFGenerator {

	private static final org.slf4j.Logger LOGGER=LoggerFactory.getLogger(PDFGenerator.class);

	public void generateItinerary(Reservation res,String filepath) {
	LOGGER.info("Generating document inside generateItinerary method");
		Document d=new Document();
		try {
			PdfWriter.getInstance(d, new FileOutputStream(filepath));
			d.open();
			d.add(generateTable(res));
			d.close();
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
	}

	private PdfPTable generateTable(Reservation res) {
		PdfPTable table = new PdfPTable(2);
		
		//creating table coloumns
		
		PdfPCell cell;
		cell=new PdfPCell(new Phrase("Flight Itinerary"));
		cell.setColspan(2);
		table.addCell(cell);
		
		cell=new PdfPCell(new Phrase("Flight Details"));
		cell.setColspan(2);
		table.addCell(cell);
		
		
		table.addCell("Airlines ");
		table.addCell(res.getFlight().getOperatingAirlines());  
		
		table.addCell("Departure City");
		table.addCell(res.getFlight().getDepartureCity());  
		
		table.addCell("Arrival City");
		table.addCell(res.getFlight().getArrivalCity());  
		
		table.addCell("Flight Number");
		table.addCell(res.getFlight().getFlightNumber()); 
		
		
		table.addCell("Departure Date");
		table.addCell(res.getFlight().getDateOfDeparture().toString()); 
		
		table.addCell("Departure Time");
		table.addCell(res.getFlight().getEstimatedDepartureTime().toString());
		
		
		//addinf passenger details
		
		cell=new PdfPCell(new Phrase("Passenger Details"));
		cell.setColspan(2);
		table.addCell(cell);
		
		table.addCell("First Name");
		table.addCell(res.getPassenger().getFirstName());  
		
		table.addCell("Last Name");
		table.addCell(res.getPassenger().getLastName());  
		
		
		table.addCell("Email");
		table.addCell(res.getPassenger().getEmail());  
		
		
		table.addCell("Phone Number");
		table.addCell(res.getPassenger().getPhone());  
		
		return table;
	}
	
}
