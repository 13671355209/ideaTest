public class lalala {
    public static void main(String[] args) {
        for (int i = 0; i < 200 ; i++) {

            new Thread(){//1111请问请问1111
                public void run(){
                    test0916.INSTANCE.getceshi();
                }
            }.start();
        }
    }
}
