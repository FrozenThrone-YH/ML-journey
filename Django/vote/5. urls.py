"""
urls.py : 웹 프로젝트가 실행될때 웹클라이언트가 요청을 한 인터넷주소에
해당하는 뷰 클래스/함수를 호출하기 위한 등록 파일 
뷰클래스/함수를 등록할때는 urlpatterns 변수의 요소로 추가하면 됨
요소로 추가할때는 path함수를 사용(import되있음)

path(웹클라이언트가 요청할 url주소(문자열), 호출될 뷰클래스/함수이름)

"""

from django.contrib import admin
from django.urls import path
from vote.views import main, detail, vote, result

urlpatterns = [
    path('a1/', admin.site.urls),

    path('vote/',main),
    #127.0.0.1:8000/vote/숫자
    path('vote/<int:q_id>/',detail),
    path('vote/vote/',vote),
    path('vote/result/<int:c_id>/',result),
    
]

#사이트 접속할때 127.0.0.1:8000/vote/숫자 에서 
#숫자에 번호를 입력하면 그 번호에 맞는 Question 객체에 해당하는 것으로 넘어간다.
