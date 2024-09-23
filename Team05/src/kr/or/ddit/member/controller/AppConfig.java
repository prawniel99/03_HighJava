package kr.or.ddit.member.controller;

/**
 * 애플리케이션 설정 리스너
 * 
 * 이 클래스는 웹 애플리케이션의 시작과 종료 시 실행되는 리스너입니다.
 * 주요 목적은 애플리케이션 전역 설정을 초기화하는 것입니다.
 * 
 * 주요 기능:
 * 1. 애플리케이션 시작 시 baseURL 초기화
 * 2. 애플리케이션 종료 시 필요한 정리 작업 수행 (현재는 구현되지 않음)
 * 
 * 데이터 흐름:
 * 1. 웹 애플리케이션 시작 -> AppConfig.contextInitialized() 호출
 * 2. ServletContext에 baseURL 설정
 * 3. 웹 애플리케이션 전체에서 baseURL 사용 가능
 * - 정석진 2024-09-23- 
 */
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppConfig implements ServletContextListener {

	// 웹 애플리케이션 시작 시 호출되는 메서드
	// baseURL을 초기화하여 ServletContext에 설정합니다.
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		context.setInitParameter("baseURL", "http://localhost/Team05");
	}

	// 웹 애플리케이션 종료 시 호출되는 메서드
	// 현재는 특별한 작업을 수행하지 않지만, 필요한 경우 정리 작업을 추가할 수 있습니다.
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// 필요한 경우 정리 작업 애플리케이션 요구사항 추가 자리
	}
}