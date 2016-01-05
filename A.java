public class A {

    //-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=7777

    static int somthing;
    static String word;

    public static void main(String[] args){
        int localthing = 0;

        B b = new B();

        while(true) {
            localthing++;
            b.inc();

            somthing++;
            word = word + "lol";
            System.out.println(somthing);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
