'''  vote만들때 만든 urlspy에 아래 내용 추가'''


from django.urls import path, include
#include : 다른 URLConf 파일을 등록할 때 사용하는 함수 
#path(시작문자열, include(urls.py가 있는 위치))
# -> 시작문자열로 요청하는 모든 인터넷 주소는 include안에 있는 
#Urls.py가 처리할 수 있도록 등록
#ex) path('test/', include('vote.urls'))
# -> 127.0.0.1:8000/test로 시작하는 모든 요청들을 vote폴더에 
#urls.py에서 처리할 수 있도록 등록 

