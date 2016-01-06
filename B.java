public class B {

    //DEBUGEE

    static int aNumber = 0;

    public void inc(){
        aNumber = aNumber + aNumber * 3 + 1;
        if(aNumber > 100000) aNumber = 1;
        System.out.println(aNumber);
    }

}
