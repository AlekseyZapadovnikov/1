import java.util.Random;


public class Main {
    public static void main(String[] args) {
        int[] sl2 = new int[]{10, 12, 13, 14, 15};
        int[] z = new int[10];
        int max = 0;
        for (int i = 9; i >= 0; i--) {
            z[9 - i] = (i + 6);
        }
        Random rand = new Random();
        float[] x = new float[18];
        for (int i = 0; i <= 17; i++) {
            x[i] = Math.min((rand.nextFloat(-15.0, 9.0)), 8);
        }
        float[][] z1 = new float[10][18];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 18; j++) {
                if (z[i] == 7) {
                    z1[i][j] = method1(x[j]);
                } else {
                    if (inMassiv(z[i], sl2)) {
                        z1[i][j] = method2(x[j]);
                    } else {
                        z1[i][j] = method3(x[j]);
                    }
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 18; j++) {
                String stro = String.format("%10.3f ", z1[i][j]);
                System.out.printf(stro);
            }
            System.out.println();
        }
        //printZ1();
    }


    public static float method1(float x) {
        float rt = (float) Math.pow(((1-Math.tan(x/2))/Math.asin(Math.cos(x))), 3);
        if (rt > Math.pow(10, 6)){
            rt = (float) Double.POSITIVE_INFINITY;
        }else {
            if (rt < (-1 * Math.pow(10, 6))){
                rt = (float) Double.NEGATIVE_INFINITY;
            }
        }
        return rt;
    }

    public static float method2(float ar2) {
        float abs = -1 * Math.abs(ar2);
        float pw = (float) Math.pow(Math.exp(1), abs);
        float as = (float) Math.asin(pw);
        float rt = (float) Math.pow(as, 3);
        if (rt > Math.pow(10, 6)){
            rt = (float) Double.POSITIVE_INFINITY;
        }else {
            if (rt < (-1 * Math.pow(10, 6))){
                rt = (float) Double.NEGATIVE_INFINITY;
            }
        }
        return rt;
    }

    public static float method3(float ar) {
        float abs = Math.abs(ar);
        float ln = (float) Math.log(abs);
        float tg_ln = (float) Math.tan(ln) + 1;
        float sqrt = (float) Math.pow((2 * Math.pow(ln, 1/3)), 2);
        float cs = (float) Math.cos(ar);
        float as = (float) (2 * Math.pow(Math.asin(cs) + 1, 2));
        float rt = (float) Math.pow(tg_ln / as, sqrt);
        if (rt > Math.pow(10, 6)){
            rt = (float) Double.POSITIVE_INFINITY;
        }else {
            if (rt < (-1 * Math.pow(10, 6))){
                rt = (float) Double.NEGATIVE_INFINITY;
            }
        }
        return rt;
    }
    public static boolean inMassiv(int x, int[] aray) {
        Boolean flag = Boolean.FALSE;
        for (int i : aray) {
            if (i == x) {
                flag = Boolean.TRUE;
                break;
            }
        }
        return flag;
    }
}
