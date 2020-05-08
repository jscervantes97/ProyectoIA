package AppSudoku;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
/**
 * @author imssbora
 */
public class XYLineChartExample extends JFrame {
    private static final long serialVersionUID = 6294689542092367723L;

    public XYLineChartExample(String title,double[] datos) {
        super(title);

        // Create dataset
        XYDataset dataset = createDataset(datos);

        // Create chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Resultados",
                "Numero de Generacion",
                "Aptitud",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        // Create Panel
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private XYDataset createDataset(double[] datos) {
        XYSeriesCollection dataset = new XYSeriesCollection();

        XYSeries series = new XYSeries("Mejor Aptitud por generacion");
        for(int j = 0 ; j < datos.length; j++){
            series.add((j+1), datos[j]);
        }


        //Add series to dataset
        dataset.addSeries(series);

        return dataset;
    }

    public static void main(String[] args) {

    }
}