package gg.letsgo.boutframework;

public class PrintService implements OutputService {
    @Override
    public void output(String text) {
        System.out.println(text);
    }
}
