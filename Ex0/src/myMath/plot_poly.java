package myMath;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.BitmapEncoder.BitmapFormat;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
public class plot_poly {
	
	//this part of the project uses XChart from github and it needs to be added in order for it to work: https://github.com/knowm/XChart
	
	
	public static void main(String[] args) throws IOException { 
		Polynom test = new Polynom ("0.2*X^4-1.5*X^3+3.0*X^2-1*X^1-5");
		double eps = 0.01;
		double start = -2;
		double end = 6;
		ArrayList<Double> xxdata = new ArrayList<Double>();
		ArrayList<Double> yydata = new ArrayList<Double>();
		ArrayList<String> minX = new ArrayList<String>();
		ArrayList<String> minY = new ArrayList<String>();
		ArrayList<String> maxX = new ArrayList<String>();
		ArrayList<String> maxY = new ArrayList<String>();
		while (start <= end) {
			xxdata.add(start);
			yydata.add(test.f(start)); //testing for min max points
			if ((test.f(start-eps) >= test.f(start) && test.f(start+eps) >= test.f(start))) {
				xxdata.add(start);
				yydata.add(test.f(start) + 0.5);
				xxdata.add(start);
				yydata.add(test.f(start) - 0.5);
				xxdata.add(start);
				yydata.add(test.f(start));
				DecimalFormat df = new DecimalFormat("#.##");
				minX.add(df.format(start));
				minY.add(df.format(test.f(start)));
			}
			if ((test.f(start-eps) <= test.f(start) && test.f(start+eps) <= test.f(start))) {
				xxdata.add(start);
				yydata.add(test.f(start) + 0.5);
				xxdata.add(start);
				yydata.add(test.f(start) - 0.5);
				xxdata.add(start);
				yydata.add(test.f(start));
				DecimalFormat df = new DecimalFormat("###.##");
				maxX.add(df.format(start));
				maxY.add(df.format(test.f(start)));
			}
			start = start + eps;
		}
		System.out.println(xxdata);
		System.out.println(yydata);
		Iterator<String> iterMinX = minX.iterator();
		Iterator<String> iterMinY = minY.iterator();
		Iterator<String> iterMaxX = maxX.iterator();
		Iterator<String> iterMaxY = maxY.iterator();
		String min = "";
		String max = "";
		while(iterMinX.hasNext()) {
			min = min + "(" + iterMinX.next() + "," + iterMinY.next() + "), ";
		}
		while(iterMaxX.hasNext()) {
			max = max + "(" + iterMaxX.next() + "," + iterMaxY.next() + "), ";
		}
 		double[] xData = new double[xxdata.size()];
		double[] yData = new double[xxdata.size()];
		Iterator<Double> iterX = xxdata.iterator();
		Iterator<Double> iterY = yydata.iterator();
		for (int i = 0; i<xxdata.size(); i++) {
			xData[i] = iterX.next();
			yData[i] = iterY.next();
		}
		System.out.println("the area as asked is: "+test.area(-0.941, 4.831, 0.01));
		DecimalFormat dfArea = new DecimalFormat("###.####");
		String area = dfArea.format(test.area(-0.941, 4.831, 0.01))+"";

		// Create Chart
		XYChart chart = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)" + "\n"+ "Min points: " + min + "\n" + "Max points: " + max + "\n" + "Area as asked: " + area, xData, yData);

		// Show it
		new SwingWrapper(chart).displayChart();

		// Save it
		BitmapEncoder.saveBitmap(chart, "./Sample_Chart", BitmapFormat.PNG);

		// or save it in high-res
		BitmapEncoder.saveBitmapWithDPI(chart, "./Sample_Chart_300_DPI", BitmapFormat.PNG, 300);
	}
	}