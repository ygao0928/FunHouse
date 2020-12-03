package ltd.ygao.wechat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;

@SpringBootTest
class WechatApplicationTests {

	static final String formatStr="yyyy-MM-dd";

	static final SimpleDateFormat sdf=new SimpleDateFormat(formatStr);
	@Test
	void contextLoads() {
		System.out.println(sdf.format(""));
	}

}
