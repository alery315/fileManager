package util;

public class Size {

    private static String[] postfixes = {"b", "kb", "mb", "G", "T"};

    public static String formatSize(String size) {
        int idx = 0;
        double sizeDouble = Long.valueOf(size);
        while (sizeDouble >= 1000) {
            sizeDouble /= 1000;
            idx++;
        }
        return idx == 0 ? (int)sizeDouble + postfixes[idx] : String.format("%.2f", sizeDouble) + postfixes[idx];
    }

    public static void main(String[] args) {

        System.out.println(formatSize("200"));
        System.out.println(formatSize("2000"));
        System.out.println(formatSize("2000000"));
        System.out.println(formatSize("2000000000"));
        System.out.println(formatSize("2000000000000"));
        System.out.println(System.getProperties().getProperty("file.separator"));
        System.out.println(System.getProperties().getProperty("os.name"));
        System.getProperties().list(System.out);
    }


}
