public class Appp {
    public static void main(String[] args) {
        System.out.println("Hello from simple Java app running in Docker & Kubernetes!");

        while (true) {
            try {
                Thread.sleep(5000);
                System.out.println("App is running...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
