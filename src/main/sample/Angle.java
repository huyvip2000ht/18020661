package main.sample;

public class Angle {

    public static double degree(int x1, int y1, int x2, int y2) {
        // x1,y1 là gốc
        int vectorX = x2 - x1;
        int vectorY = y2 - y1;
        double up = vectorY * -1;
        double down = Math.sqrt(vectorX * vectorX + vectorY * vectorY);
        double okok = (Math.acos(up / down)) / Math.PI * 180;
        if (vectorX >= 0) return okok;
        return 360 - okok;

    }

    public static double transX(double angle) {
        if (angle <= 90) {
            return Math.sin(angle / 180 * Math.PI);

        } else if (angle <= 180) {
            return Math.cos((angle - 90) / 180 * Math.PI);

        } else if (angle <= 270) {
            return Math.sin((angle - 180) / 180 * Math.PI);

        }

        return Math.cos((angle - 270) / 180 * Math.PI);
    }

    public static double transY(double angle) {
        if (angle <= 90) {

            return Math.cos(angle / 180 * Math.PI);
        } else if (angle <= 180) {

            return Math.sin((angle - 90) / 180 * Math.PI);
        } else if (angle <= 270) {

            return Math.cos((angle - 180) / 180 * Math.PI);
        } else {

            return Math.sin((angle - 270) / 180 * Math.PI);
        }
    }


}

