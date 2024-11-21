package pe.edu.newhorizons.composer;

import java.util.Arrays;

import org.zkoss.chart.Charts;
import org.zkoss.chart.Point;
import org.zkoss.chart.Series;
import org.zkoss.chart.plotOptions.DataLabels;
import org.zkoss.chart.plotOptions.DataLabelsFilter;
import org.zkoss.chart.plotOptions.SeriesPlotOptions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Window;
import pe.edu.newhorizons.model.LineBasicData;


public class PieBasicComposer extends SelectorComposer<Window> {

    @Wire
    Charts chart;
   
    public void doAfterCompose(Window comp) throws Exception {
        super.doAfterCompose(comp);

        chart.getTooltip().setValueSuffix("%");

        chart.setSubtitle("Source:<a href=\"https://www.mdpi.com/2072-6643/11/3/684/htm\" target=\"_default\">MDPI</a>");

        SeriesPlotOptions plotOptions = chart.getPlotOptions().getSeries();
        plotOptions.setAllowPointSelect(true);
        plotOptions.setCursor("pointer");

        DataLabels[] dataLabels = new DataLabels[] {new DataLabels(), new DataLabels()};
        dataLabels[0].setEnabled(true);
        dataLabels[0].setDistance(20);
        dataLabels[1].setEnabled(true);
        dataLabels[1].setDistance(-40);
        dataLabels[1].setFormat("{point.percentage:.1f}%");
        dataLabels[1].setStyle("fontSize: '1.2em'; textOutline: 'none'; opacity: 0.7");
        DataLabelsFilter filter = dataLabels[1].getFilter();
        filter.setOperator(">");
        filter.setProperty("percentage");
        filter.setValue(10);
        plotOptions.setDataLabels(Arrays.asList(dataLabels));

        Series series = chart.getSeries();
        series.setName("Percentage");
        series.setColorByPoint(true);
        series.addPoint("Water", 55.02);
        Point fat = new Point("Fat", 26.71);
        fat.setSliced(true);
        fat.setSelected(true);
        series.addPoint(fat);
        series.addPoint("Carbohydrates", 1.09);
        series.addPoint("Protein", 15.5);
        series.addPoint("Ash", 1.68);        
       
    }
}