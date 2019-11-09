package main.sample;

public class Angle {

        double angl;
        public Angle(){

        }
        public Angle(double angle){
            this.angl=angle;
        }
        public static double degree(int x1,int y1,int x2,int y2){
                // x1,y1 là gốc
            int vectorX=x2-x1;
            int vectorY=y2-y1;
            double up=vectorY*-1;
            double down=Math.sqrt(vectorX*vectorX+vectorY*vectorY);
            double okok=(Math.acos(up/down))/Math.PI*180;
            if(vectorX>=0) return okok;
            return 360-okok;

        }

   /* public static void main(String[] args) {
        System.out.println(degree(0,0,0,-1));
        System.out.println(degree(0,0,1,-1));
        System.out.println(degree(0,0,1, 0));
        System.out.println(degree(0,0,1, 1));
        System.out.println(degree(0,0,0, 1));
        System.out.println(degree(0,0,-1,1));
        System.out.println(degree(0,0,-1,0));
        System.out.println(degree(0,0,-1,-1));



    }*/
}

