package Lesson_5;

public class Main {
    public static void main(String[] args) {

        metod_1();
        metod_2();

    }
     static private void metod_1() {
            final int size = 10000000;
            float[] arr = new float[size];
            for (float g:arr) {g = 1;}

            long a = System.currentTimeMillis();

            for (int i = 0; i < size ; i++) {
                arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }

          System.out.println(System.currentTimeMillis() - a);
    }

    static private void metod_2() {
        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];
        for (float g:arr) {g = 1;}
        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);

        new Thread(()-> {
            for (int i = 0; i < h ; i++) {
                arr1[i] = (float)(arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }).start();

        new Thread(()-> {
            for (int i = 0; i < h ; i++) {
                arr2[i] = (float)(arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }).start();

        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);

        System.out.println(System.currentTimeMillis()-a);

    }


}