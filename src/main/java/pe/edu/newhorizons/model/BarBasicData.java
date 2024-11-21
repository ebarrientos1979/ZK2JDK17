package pe.edu.newhorizons.model;

import org.zkoss.chart.model.CategoryModel;
import org.zkoss.chart.model.DefaultCategoryModel;



public class BarBasicData {
    private static CategoryModel model;
    static {
        model = new DefaultCategoryModel();
        model.setValue("Year 1990", "Africa", 632);
        model.setValue("Year 1990", "America", 727);
        model.setValue("Year 1990", "Asia", 3202);
        model.setValue("Year 1990", "Europe", 721);
        model.setValue("Year 2000", "Africa", 814);
        model.setValue("Year 2000", "America", 841);
        model.setValue("Year 2000", "Asia", 3714);
        model.setValue("Year 2000", "Europe", 726);
        model.setValue("Year 2021", "Africa", 1393);
        model.setValue("Year 2021", "America", 1031);
        model.setValue("Year 2021", "Asia", 4695);
        model.setValue("Year 2021", "Europe", 745);
    }

    public static CategoryModel getCategoryModel() {
        return model;
    }
}