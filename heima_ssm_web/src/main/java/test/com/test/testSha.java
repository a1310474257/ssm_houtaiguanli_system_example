package test.com.test;

import org.junit.jupiter.api.Test;
import org.springframework.util.DigestUtils;

public class testSha {

    @Test
    public void test(){
        String s = DigestUtils.md5DigestAsHex("strRe1313ad".getBytes());
     byte[] a =  DigestUtils.md5Digest("834e4675bec1bdae93e15099b4534849".getBytes());
       // String a = new String("strRead".getBytes());
        System.out.printf(new String(s));
    }
}
