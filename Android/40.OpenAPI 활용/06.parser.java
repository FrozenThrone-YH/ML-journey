package com.example.mynaveractivity;

// 변환 클래스
// 어떤 데이터를 받았을 때, API를 통해 가져온 데이터들을 사용할 수 있는 형태로
// 가공하는 클래스

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private BookModel vo;
    private String myQuery = ""; //검색어

    public ArrayList<BookModel> connectNaver(int start,ArrayList<BookModel> list){
      //API 검색 - 책에서 query랑 start 볼 것.
      //start는 검색했을때 검색의 시작지점, display는 기본값 10, 검색하면 10개 검색
        try{
            //인터넷상에서 확인할 수 있는 형태로 변환
            //검색어 인코딩
            myQuery = URLEncoder.encode(MainActivity.search.getText().toString(),"UTF8");
            int count = 10; //검색 결과 10건 표시

            // GET방식 : 주소를 통해 값을 전달하는 방식= 주소 끝에 ?요청변수명=값&요청변수명=값
            // POST방식 : header를 통해 값을 전달하는 방식
            // 검색 주소 설정
            String urlstr =
                    "https://openapi.naver.com/v1/search/book.xml?query="+myQuery+"&start="+start+"&display="+count;

            //URL클래스를 통해 접근할 경로 설정.
            URL url = new URL(urlstr);

            //URL클래스의 연결 정보를 connection에 전달 => 연결시킨다.
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            //메서드 방식 설정 : GET방식
            connection.setRequestMethod("GET");

            //어느 패키지에서 무엇을 쓰는 건지 알려줘야한다.
            //발급받은 ID와 secret을 등록
            connection.setRequestProperty(
                    "X-Naver-Client-Id","네이버에서 찾아서 쓰기"
            );
            connection.setRequestProperty(
                    "X-Naver-Client-Secret","네이버에서 찾아서 쓰기"
            );

            //출력 포멧 지정
            connection.setRequestProperty(
                    "Cotent-Type","application/xml"
            );

            //위의 URL수행하여 받은 자원을 파싱(xml에 대입)할 객체를 준비시킨다.

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();

            //위에서 생성된 factory를 가지고 파서 객체를 생성
            XmlPullParser parser = factory.newPullParser();

            //connection을 통해 파싱을 한다. null값 셋팅해도 된다.
            parser.setInput(connection.getInputStream(),null);
            //이렇게 셋팅하면 데이터 받은 것이다.

            //parser를 통해 각요소(Element)들을 반복 수행처리 한다.
            int parserEvent = parser.getEventType();

            //parser이벤트안에 데이터가 있는 상태이므로
            //반복문을 통해 요소 값을 뺴와야 한다
            while(parserEvent != XmlPullParser.END_DOCUMENT){
                //xml문서의 끝이 아닐때까지 반복한다.
                if(parserEvent == XmlPullParser.START_TAG){
                    //시작 태그일때만 태그의 이름을 알아 낸다.
                    String tagName = parser.getName(); //xml 처음 시작했을때 태그 이름 받는 것
                    //이거 가지고 데이터 구분 지을 것이다.
                    //출력 결과를 띄울 것인데, 사이트에 정의되어 있다.
                    if(tagName.equalsIgnoreCase("title")){
                        //equalsIgnoreCase() : 대소문자 상관없이 맞냐? 대소문자 상관없이 title이면 맞다.
                        vo = new BookModel();
                        String title = parser.nextText(); //title에 parser한 내용 집어 넣기

                        //네이버에서는 검색어가 들어간 단어에
                        //<b> 태그가 들어가 있다. 글자 굵게 한다는 뜻
                        //이것을 제거하기 위해 정규 표현식을 써야 한다.

                        Pattern pattern = Pattern.compile("<.*?>");
                        Matcher matcher = pattern.matcher(title);
                        if(matcher.find()){
                            //matcher가 찾았으면
                            String s_title = matcher.replaceAll("");
                            //이렇게 하면 태그 부분이 다 사라진다.
                            vo.setB_title(s_title);
                        }else{
                            vo.setB_title(title);
                        }
                    }else if(tagName.equalsIgnoreCase("image")){
                        String img = parser.nextText();
                        vo.setB_img(img);
                    }else if(tagName.equalsIgnoreCase("author")){
                        String author = parser.nextText();
                        vo.setB_author(author);
                    }else if(tagName.equalsIgnoreCase("price")){
                        String price = parser.nextText();
                        vo.setB_price(price);
                        list.add(vo);
                    }//데이터 순서가 위에 정의한 순서와 같다.
                }
                parserEvent = parser.next(); //다음요소를 검색하다가 while문 돌아가면서 검색하다가
                //끝이면 끝난다.
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        //현재 영역에 오변 서버로부터 받은 xml자원이 모두
        //BookModel객체로 생성되어 list안에 추가 되었다.
        //이것을 반환
        return list;
    };

}
