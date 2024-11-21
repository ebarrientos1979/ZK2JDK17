package pe.edu.newhorizons.composer;

import org.zkoss.chart.Charts;
import org.zkoss.chart.Legend;
import org.zkoss.chart.YAxis;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Window;

import pe.edu.newhorizons.model.BarBasicData;


public class BarBasicComposer extends SelectorComposer<Window> {

    @Wire
    Charts chart;
    
    public void doAfterCompose(Window comp) throws Exception {
        super.doAfterCompose(comp);

        chart.getTitle().setAlign("left");
        chart.setSubtitle("Source: <a " +
                "href=\"https://en.wikipedia.org/wiki/List_of_continents_and_continental_subregions_by_population\"" +
                "target=\"_blank\">Wikipedia.org</a>");
        chart.getSubtitle().setAlign("left");
        
        chart.setModel(BarBasicData.getCategoryModel());
        chart.getXAxis().setTitle("");
        chart.getXAxis().setGridLineWidth(1);
        chart.getXAxis().setLineWidth(0);
        
        YAxis yAxis = chart.getYAxis();
        yAxis.setMin(0);
        yAxis.setTitle("Population (millions)");
        yAxis.getTitle().setAlign("high");
        yAxis.getLabels().setOverflow("justify");
        yAxis.setGridLineWidth(0);
        
        chart.getTooltip().setValueSuffix(" millions");
        chart.getPlotOptions().getBar().setBorderRadius("50%");
        chart.getPlotOptions().getBar().getDataLabels().setEnabled(true);
        chart.getPlotOptions().getBar().setGroupPadding(0.1);

        Legend legend = chart.getLegend();
        legend.setLayout("vertical");
        legend.setAlign("right");
        legend.setVerticalAlign("top");
        legend.setX(-40);
        legend.setY(80);
        legend.setFloating(true);
        legend.setBorderWidth(1);
        legend.setBackgroundColor("#FFFFFF");
        legend.setShadow(true);
        
        chart.getCredits().setEnabled(false);
    }
}
