package webserver;

import static org.junit.Assert.*;

import org.junit.Test;

public class RequestLineTest {

	RequestLine url = new RequestLine("GET /user/create?userId=bae&password=password&name=%EB%B0%95%EC%9E%AC%EC%84%B1&email=javajigi%40slipp.net HTTP/1.1");
	
//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}

	@Test
	public void urlCheckTest(){
		assertEquals("/user/create", url.urlCheck());
	}
	
	@Test
	public void getParameterTest(){
		url.urlCheck();
		String userId = url.getParameter("userId");
		assertEquals("bae", userId);
	}
	
	@Test
	public void getParameterTest2(){
		url.urlCheck();
		String password = url.getParameter("password");
		assertEquals("password", password);
	}
	
	@Test
	public void getParameterTest3(){
		url.urlCheck();
		String email = url.getParameter("email");
		assertEquals("javajigi%40slipp.net", email);
	}
	
	
}
