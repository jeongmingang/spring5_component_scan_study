package spring5_component_scan_study.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberInfoPrinter {
	//세터메서드를 사용해서 의존 주입을 하지 않더라도 스프링컨테이너가 @Autowired를 붙인 필드에
	//자동으로 해당 타입의 빈 객체를 주입(즉 세터 생략 가능)
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberPrinter printer;
	
	public void printMemberInfo(String email) {
		Member member = memberDao.selectByEmail(email);
		if (member == null) {
			throw new MemberNotFoundException("데이터 없음\n");
		}
		printer.print(member);
		System.out.println();
	}
}
