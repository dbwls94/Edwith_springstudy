package or.kr.connect;

import org.junit.Test;
import org.junit.Before;

public class CountTest {
    private int count = 0; //이게 static이 되면 count는 갱신되지않고 계속 증가
    @Before //test before
    public void setUp() {
        System.out.print(count++);
    }

    @Test //test method
    public void testPlus() {
        System.out.print(count++);
    }

    @Test //test method
    public void increase (){
        System.out.print(count++);
    }
}