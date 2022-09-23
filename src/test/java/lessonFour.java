public class lessonFour {
    public static void main(String[] args) {
        //string
        String a = "bla-bla";
        //True or False
        boolean verity = false;
        // byte (-128 to 127, 1 byte)
        byte solid;
        //short (-32768 to 32767, 2 bytes)
        short small;
        //int (-2147483648 to 2147483647, 4 bytes)
        int together;
        //long (–9223372036854775808 до 9223372036854775807, 8 bytes)
        long big;
        //double (±4.9*10-324 to ±1.7976931348623157*10308, 8 bytes)
        double ambiguity;
        //float (-3.4*1038 to 3.4*1038, 4 bytes)
        float ship;
        //char (0 to 65535, UTF-16, 1 symbol, 0 to 65535,2 bytes)
        char alpha='f';

        System.out.println(a+" No-No-No");
        System.out.println(verity==true);
        solid = 3;
        System.out.println(solid+1);
        small=6;
        System.out.println(small/2);
        together=8;
        System.out.println(together*7);
        big=12;
        System.out.println(big*3);
        ambiguity=39.0f;
        System.out.println(ambiguity-9);
        ship=10f;
        System.out.println(ship*15);
        System.out.println(alpha);

        int MAX = Integer.MAX_VALUE;
        System.out.println(MAX+1);

        boolean da=true;
        boolean net=false;
        System.out.println(da&net);
        System.out.println(da|net);
        System.out.println(da&&net);
        System.out.println(da||net);
        System.out.println(!da);
        System.out.println(!net);
        System.out.println(!da^net);


    }
}
