package com.heller.jmockit;

import java.util.Locale;

import mockit.Expectations;
import org.junit.Assert;
import org.junit.Test;

public class HelloJMockitTest {

    private HelloJMockit helloJMockit = new HelloJMockit();

    /**
     * 普通测试用例
     */
    @Test
    public void testSayHello() {
        Assert.assertEquals("Hello, JMockit!", helloJMockit.sayHello());
        Assert.assertNotEquals("你好，JMockIt！", helloJMockit.sayHello());
    }
    
    /**
     * 测试场景：当前是在中国
     */
    @Test
    public void testSayHelloAtChina() {
        new Expectations(Locale.class) {{
            Locale.getDefault();
            result = Locale.CHINA;
        }};
        Assert.assertEquals("你好，JMockIt！", helloJMockit.sayHello());
    }
    
    /**
     * 测试场景：当前是在美国
     */
    @Test
    public void testSayHelloAtUS() {
        new Expectations(Locale.class) {{
            Locale.getDefault();
            result = Locale.US;
        }};
        Assert.assertEquals("Hello, JMockit!", helloJMockit.sayHello());
    }
    
}
