package gg.letsgo.boutframework;

public class HelloWorld {
    private String text;
    private OutputService outputService;

    public void helloWorld() {
        outputService.output(text);
    }
}
