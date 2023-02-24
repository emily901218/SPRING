<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Pages - Login</title>
   <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/write.css">
  <script src="/js/summernote/summernote-lite.js"></script> 
<script src="/js/summernote/lang/summernote-ko-KR.js"></script> 
<link rel="stylesheet" href="/css/summernote/summernote-lite.css">
     <script>
                     $(document).ready(function() {
                        //여기 아래 부분
                        $('#summernote').summernote({
                             height: 300,                 // 에디터 높이
                             minHeight: null,           // 에디터 최소 높이
                             maxHeight: null,          // 에디터 최대 높이
                             focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
                             lang: "ko-KR",            // 한글 설정
                             placeholder: '최대 2048자까지 쓸 수 있습니다', //placeholder 설정
                            		// 추가 부분
                            toolbar: [
                            		// [groupName, [list of button]]
                            		['fontname', ['fontname']],
                            		['fontsize', ['fontsize']],
                            		['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
                            		['color', ['forecolor','color']],
                            		['table', ['table']],
                            		['para', ['ul', 'ol', 'paragraph']],
                            		['height', ['height']],
                            		['insert',['picture','link','video']],
                            		['view', ['fullscreen', 'help']]
                            		],
                            fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕',
                            		'궁서','굴림체','굴림','돋움체','바탕체'] ,
                            fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72']

                        
                        });
                     });
                     </script>
</head>

<body>
  <header>
    <ul>
      <li>회원가입</li> <span>|</span>
      <li>로그인</li> <span>|</span>
      <li>고객행복센터</li> <span>|</span>
      <li>배송지역검색</li> <span>|</span>
      <li>기프트카드 등록</li>
    </ul>
  </header>

  <nav>
    <div class="logo"></div>

    <div id="search">
      <div class="search"></div><br>
      <span>메뉴찾기</span>
    </div>

    <div id="cart">
      <div class="cart"></div><br>
      <span>장바구니</span>
    </div>

    <div class="nav-menu">
      <ul>
        <li>COOKIT소개</li>
        <li>COOKIT 메뉴</li>
        <li>리뷰</li>
        <li>이벤트</li>
        <li>MY쿡킷</li>
      </ul>  
    </div>
  </nav>

  <section>
    <h1>관리자 글쓰기</h1>
    <hr>

    <form action="/write" name="write" method="post">
      <table>
        <colgroup>
          <col width="15%">
          <col width="85%">
        </colgroup>
        <tr>
          <th>분류</th>
          <td>
            <div class="category-wrapper">
              <select name="category" id="category">
                <option value="notice">공지</option>
                <option value="event">이벤트</option>
              </select>  
            </div>
          </td>
        </tr>
        <tr>
          <th>제목</th>
          <td>
            <input type="text" name="title">
          </td>
        </tr>
        <tr>
          <th>내용</th>
          <td>
            <textarea name="content" id="summernote" cols="50" rows="10">
            	
            </textarea>
          </td>
        </tr>
        <tr>
          <th>이미지 표시</th>
          <td>
            <input type="file" name="file" id="file">
          </td>
        </tr>
      </table>
      <hr>
      <div class="button-wrapper">
        <button type="submit" class="write">작성완료</button>
        <button type="button" class="cancel">취소</button>
      </div>
    </form>

  </section>

  <footer>
    <div class="wrapper">
      <div class="footer-left">
        <div class="footer-logo"></div>
        <div class="copyright">© COOKIT ALL RIGHTS RESERVED</div>
      </div>
  
      <div class="footer-center">
        <ul class="footer-nav">
          <li class="first-list">이용약관</li>
          <li class="green">개인정보처리 방침</li>
          <li>법적고지</li>
          <li>사업자정보 확인</li>
        </ul>
  
        <ul class="footer-info">
          <li class="first-list">씨제이제일제당(주)</li>
          <li>대표이사 : 손경식,강신호,신현재</li>
          <li>사업자등록번호 : 104-86-09535</li>
          <li class="first-list">주소 : 서울 중구 동호로 330 CJ제일제당 센터 (우) 04560</li>
          <li>통신판매업신고 중구 제 07767호</li>
          <li class="first-list">개인정보보호책임자 : 조영민</li>
          <li>이메일 : cjon@cj.net</li>
          <li>호스팅제공자 : CJ올리브네트웍스㈜</li>
        </ul>
  
        <div id="check">고객님은 안전거래를 위해 현금등으로 결제시 LG U+ 전자 결제의 매매보호(에스크로) 서비스를 이용하실 수 있습니다. <span class="check">가입 사실 확인</span></div>
      </div>
  
      <div class="footer-right">
        <div id="shortcut">
          <span>CJ그룹계열사 바로가기</span>
          <div class="shortcut"></div>
        </div>
  
        <div class="call">고객행복센터 1668-1920</div>
        <div class="inquery">1:1 문의</div>
      </div>
  
    </div>
  </footer>
</body>
</html>