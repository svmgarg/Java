package datatypes.longTest;

public class LongTest {
    public static void main(String arsg[]) {

        Long l = 127L;
        Long l1 = 127L;
        /**
         * Reference Comaprison of 127
         * To Improve the performance of java,
         * Internally JVM will use same reference of Long -128 to 127  if it is not created with "new" operator
         */
        //So It will be true
        System.out.println("Reference(==) comparion 127 : " + (l == l1));


        Long l2 = 128L;
        Long l3 = 128L;
        /**
         * Reference Comaprison of 128
         * To Improve the performance of java,
         * Internally JVM will use same reference of Long -128 to 127  if it is not created with "new" operator
         */
        //So wit will be false
        System.out.println("Reference(==) comparion  128 : " + (l2 == l3));


        Long l4 = -128L;
        Long l5 = -128L;
        /**
         * Reference Comaprison of -128
         * To Improve the performance of java,
         * Internally JVM will use same reference of Long -128 to 127  if it is not created with "new" operator
         */
        //so it will be true
        System.out.println("comparing -128 : " + (l4 == l5));

        Long l6 = -129L;
        Long l7 = -129L;

        /**
         * Reference Comaprison of -129
         * To Improve the performance of java,
         * Internally JVM will use same reference of Long -128 to 127  if it is not created with "new" operator
         */
        //So it will be false
        System.out.println("comparing -129 : " + (l6 == l7));

        Long l8 = new Long(0);
        Long l9 = new Long(0);
        /**
         * Reference Comaprison of 127
         * To Improve the performance of java,
         * Internally JVM will use same reference of Long -128 to 127  if it is not created with "new" operator
         * Hence It will be false as it is created by new operator
         */
        System.out.println("comparing 0: " + (l8 == l9));



    }
}