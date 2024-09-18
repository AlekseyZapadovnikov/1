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
            x[i] = (rand.nextLong((long) (-15 * Math.pow(2, 54)), (long) Math.pow(2, 57) + 1)) / ((long) Math.pow(2, 54));
        }
        float[][] z1 = new float[10][18];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 18; j++) {
                if (z[i] == 7) {
                    z1[i][j] = method1(x[j]);
                    max = Math.max((int) z1[i][j] + 1, max);
                } else {
                    if (inMassiv(z[i], sl2)) {
                        z1[i][j] = method2(x[j]);
                        max = Math.max((int) z1[i][j] + 1, max);
                    } else {
                        z1[i][j] = method3(x[j]);
                        max = Math.max((int) z1[i][j] + 1, max);
                    }
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 18; j++) {
                System.out.printf("%20.3f ", z1[i][j]);
            }
            System.out.println("");
        }
    }


    public static float method1(float ar) {
        Float tg = (float) Math.tan(ar / 2);
        Float cs = (float) Math.cos(ar);
        Float as = (float) Math.asin(cs);
        return (float) Math.pow((1 - tg) / as, 3);
    }

    public static float method2(float ar2) {
        float abs = -1 * Math.abs(ar2);
        float pw = (float) Math.pow(Math.exp(1), abs);
        float as = (float) Math.asin(pw);
        return (float) Math.pow(as, 3);
    }

    public static float method3(float ar) {
        float abs = Math.abs(ar);
        float ln = (float) Math.log(abs);
        float tg_ln = (float) Math.tan(ln) + 1;
        float sqrt = (float) Math.pow((2 * Math.pow(ln, 1/3)), 2);
        float cs = (float) Math.cos(ar);
        float as = (float) (2 * Math.pow(Math.asin(cs) + 1, 2));
        return (float) Math.pow(tg_ln / as, sqrt);
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
