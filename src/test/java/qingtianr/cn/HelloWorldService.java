package qingtianr.cn;

/**
 * Created by jack on 2017/9/23.
 */
public class HelloWorldService {

    private String text;

    private OutputService outputService;

    public void helloworld(){
        outputService.output(text);
    }

    public void setText(String text) {
        this.text = text;
    }

    public OutputService getOutputService() {
        return outputService;
    }

    public void setOutputService(OutputService outputService) {
        this.outputService = outputService;
    }
}
