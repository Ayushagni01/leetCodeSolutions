package com.location.web.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.springframework.stereotype.Component;

@Component
public class ReportUtilImpl implements ReportUtil {

	@Override
	public void generatePieeChart(String path, List<Object[]> data) {
	
		
		//getting dataset
		DefaultPieDataset dataset = new DefaultPieDataset();
		
		for (Object[] objects : data) {
			dataset.setValue(objects[0].toString(), new Double(objects[1].toString()));
			
		}
		
		//create a jfreechart
		
		JFreeChart charts = ChartFactory.createPieChart3D("Location Type Report", dataset );
		//converted into jpec image
		
		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/pieChart.jpeg"), charts, 300, 300);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}

}
