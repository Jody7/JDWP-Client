public class A {

    //DEBUGEE

    //-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=7777

    static int somthing;
    static String word;

    public static void main(String[] args){
        int localthing = 2;

        B b = new B();

        while(true) {
            localthing = localthing * 2;
            b.inc();

            somthing++;
            word = word + "lol";
            //System.out.println(somthing);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
