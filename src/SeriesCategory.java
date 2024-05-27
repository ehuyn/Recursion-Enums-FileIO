enum SeriesCategory{
    ARITHMETIC, GEOMETRIC, FIBONACCI, HARMONIC;

    public static void printSeriesCategories(){
        String display = "";
        for (SeriesCategory series : SeriesCategory.values()){
            display += (series + ", ");
        }
        display = display.substring(0, display.length()-2);
        System.out.println(display);
    }
}