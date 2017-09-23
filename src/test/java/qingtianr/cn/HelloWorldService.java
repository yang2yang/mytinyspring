package qingtianr.cn;

/**
 * Created by jack on 2017/9/23.
 */
public class HelloWorldService {

    private String text;

    public void helloworld(){
        System.out.println(text);
    }

    public void setText(String text) {
        this.text = text;
    }
}
