package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UserDAO {

	private Connection conn;//자바와 데이터 베이스 연결
	private PreparedStatement pstmt; //쿼리문 대기 및 설정
	private ResultSet rs;//결과값 받아오기
	
	//생성자 메소드마다 반복되는(중복되는) 코드를 간소화 시킴
	public UserDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/board";
			String dbID = "root";//아이디를 따로 만들수 있다 그러나 권한을 부여해야함
			String dbPassword = "1234";
			Class.forName("com.mysql.cj.jdbc.Driver");
			//
			//마리아 db를 사용할 경우 Class.forName("org.mariadb.jdbc.Driver);
			//JDBC연결 클래스를 'String'타입으로 불러옵니다
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			//드라이버 매니저에 미리 정장했던 연결 URL과 DB계정 정보를 담아 연결설정을 한다
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*로그인 메서드
	로그인 성공(1) 패스워드틀림(0), 아이디 없음(-1), -2(오류)
	SQL => Structured Query Language
	select 선택 update 수정, delete 삭제, Insert 삽입 
	Select Statement
	:데이터베이스에서 데이터를 선택하는데 사용됩니다
	where 레코드를 필터링(지정된 조건을 충족하는 레코드만 추출) 하는데 사용됩니다
	select * from Country(테이블명) where city='seoul';
	Create(insert) Read(select) Update Delete
	*/
	public int login(String userID, String userPassword) {//매개변수로 id, pw
		
		String sql = "select userPassword from user where userID = ?";
		//선택된 유저아이디에 패스워드를 선택 sql변수 = sql쿼리문이다
		try {
			
			pstmt = conn.prepareStatement(sql);//sql쿼리문을 대기
			pstmt.setString(1, userID);//첫번째 '?'에 매개변수로 받아온 'userID'를 대입			
			rs=pstmt.executeQuery();//쿼리실행한 결과를 rs에 저장
			/*가지고 있는 값을 리턴할때는 executeQuery(crud에서 read[list, view] 그외 쓰기 ,수정 ,삭제 일때는 executeUpdate*/
			
			if(rs.next()) {//만약 결과값이 존재한다면 해당 결과값을 얻을수 있다 getString(1)컬럼인덱스
				if(rs.getString(1).equals(userPassword)) {//선택한 userID에 패스워드값이 일치한다면
					return 1;//로그인 성공
				}else
					return 0;//비밀번호 틀림 실패
			}
			return -1;//아이디 없음
		}catch(Exception e) {
			e.printStackTrace();//오류를 면밀히 분석
		}
		return -2;//장치드라이버나 mysql에 테이블 미설정이나 오타
	}
	/*jsp모델 1 과 모델2 차이점 아파치 서브버전을 사용하는것 모델2 jsp 프레임워크 스프링
	아파치 서브버전 (메이븐 과 그라델)
	spring legacy[모델1과 동일하게 톰켓{메이븐}], spring boot[톰켓이 내장되어 있음{그라델}]
	jsp를 사용안하는것이 아니라 jsp모델2 프레임워크를 사용한다
	시청같은 관공서는 spring legacy가 대부분..
	최근에 새로 시스템을 만들때 스프링부트를 사용함
	
	스프링 레거시 주로 오라클 사용
	스프링 부트 국내db와 jpa (클래스로 db를 설정)
	
	개발을 하다가 순정자바를 원했음...
	Plain Oid Java Object => 다른 클래스를 상속받아서 만들어야 하는 클래스가 아닌 순수한 형태의 자바 클래스
	Inversion Of Control => 제어의 역전이란 말로 개발자가 직접 객체를 언제 생성하고 없앨지를 결정하는것이
	아니라 컨테이너에 맡긴다는 뜻
	POJO객체의 생성에서 생명주기(프로젝트의 생성 소멸등..)의 관리까지
	IOC컨테이너에 담당시킴으로서 (XML[태그를 만들수 있음]) 개발에 있어서 편의성과 재사용성의 극대화를 추구하는
	DRY  불필요한 코드량을 줄이고 컴포넌트화 시켜서 언제든 재사용
	Aspect Oriented Programming => 관점 지향 프로그래밍으로 기존의 객체지향언어에 의해 추구된
	모듈화애 따라 많아진 중복된 코드라던지 공통된 처리에 관한것들을 관점으로 뽑아내어 공통으로 처리하는 방식
	
	Model(자바 백앤드) View(프론트 엔드) Controller(모델과 뷰를 조정함)
	
	리턴 -2 db오류
	- 장치드라이버 클래스명이 다르거나 상이한걸 사용했을때 mysql장치드라이버인데
	오라클 장치드라이버명 (x), 마리아 db장치명
	- mysql접속 아이디나 패스워드가 다를때
	- 사용하는 필드명이 상이할때 mysql과 접근제어자 그리고 DAO에 필드명이 상이할때
	- WEB-INF에 장치드라이버 를 빌드하지 않았을때
	
	 * */
	//회원가입 기능을 담당하는 'join'메소드 추가
	public int join(User user) {//(클래스명 커멘드)
		//sql명령
		String sql = "insert into user values(?,?,?,?,?)";
		//테이블에 다섯개에 항목을 insert
		 try {
			 pstmt = conn.prepareStatement(sql);//sql쿼리문을 대기
			 pstmt.setString(1, user.getUserID());//(파라미터 인덱스, 얻는 값)
			 pstmt.setString(2, user.getUserPassword());
			 pstmt.setString(3, user.getUserName());
			 pstmt.setString(4, user.getUserGender());
			 pstmt.setString(5, user.getUserEmail());
			 return pstmt.executeUpdate();
		 }catch(Exception e) {//오류가 생겼을 경우 캐치
			 e.printStackTrace();
		 }
		 return -1;//데이터 넣기 실패
	}
	
	
	
	
	
	
	
	
}
