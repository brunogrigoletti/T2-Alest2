package app;
public class Main {
    public static void main(String[] args) {
        App app = new App();
        app.readFile();
        long start = System.currentTimeMillis();
        app.getHydrogenCount();
        long end = System.currentTimeMillis();
        System.out.println("Tempo de execução: " + (end - start) + "ms" + "\n");
        System.out.println("Grafo: " + "\n");
        app.digraph();
    }
}