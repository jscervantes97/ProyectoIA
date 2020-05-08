package AppSudoku;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.IntervalXYDataset;

public class HistogramFrame extends JFrame {

    static double[] red;


    public HistogramFrame(String title, double[]     red) {
        super(title);
        HistogramFrame.red = red;

        JFreeChart jfreechart = ChartFactory.createHistogram("Resultados Obtenidos", null, null, createDataset(), PlotOrientation.VERTICAL, true, true, false);
        XYPlot xyplot = (XYPlot) jfreechart.getPlot();
        xyplot.setForegroundAlpha(0.85F);
        XYBarRenderer xybarrenderer = (XYBarRenderer) xyplot.getRenderer();
        xybarrenderer.setBarPainter(new StandardXYBarPainter());
        //xybarrenderer.setDrawBarOutline(false);
        Paint[] paintArray = {              //code related to translucent colors begin here
                new Color(0x80ff0000, true),
                new Color(0x8000ff00, true),
                new Color(0x800000ff, true)
        };

        xyplot.setDrawingSupplier(new DefaultDrawingSupplier(
                paintArray,
                DefaultDrawingSupplier.DEFAULT_FILL_PAINT_SEQUENCE,
                DefaultDrawingSupplier.DEFAULT_OUTLINE_PAINT_SEQUENCE,
                DefaultDrawingSupplier.DEFAULT_STROKE_SEQUENCE,
                DefaultDrawingSupplier.DEFAULT_OUTLINE_STROKE_SEQUENCE,
                DefaultDrawingSupplier.DEFAULT_SHAPE_SEQUENCE));

        JPanel jpanel = new ChartPanel(jfreechart);
        jpanel.setPreferredSize(new Dimension(1000, 600));
        setContentPane(jpanel);
    }

    private static IntervalXYDataset createDataset() {
        HistogramDataset histogramdataset = new HistogramDataset();
        histogramdataset.addSeries("Red histogram", red, 256);

        return histogramdataset;
    }

}