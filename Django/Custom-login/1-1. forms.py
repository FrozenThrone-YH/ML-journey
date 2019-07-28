#Django에서 기본적으로 제공해주는 회원관리 어플리케이션에서 
#User 모델클래스를 연동해 회원가입, 로그인 폼을 정의 
#django.contrib.auth 이걸 불러 올 것이다.
#python - lib(라이브러리) - site- packages(웹에서 다운 받은 라이브)
# - django - contrib - auth -> 여러 py와 폴더들이 있다.
# 그중에 models.py에 있는 class에 접근할 것.

#django.contrib.auth.models : 장고에서 회원관리를 하는 어플리케이션 경로

from django.contrib.auth.models import User
# User.is_authenticated: 지금 접속해 있는지 아닌지 판단

'''회원가입 폼'''
from django import forms 
class SignupForm(forms.ModelForm):
    #ModelForm를 상속 받으면 Meta 클래스를 재정의 해줘야한다.
    #지정된 변수들을 사용해야한다. 
    
    '''모델클래스의 변수 외에 비밀번호 확인란을 추가'''
    #forms.XXXXField : 폼클래스에 사용자 입력공간을 정의할때 사용
    #모델클래스에서 사용한 models.XXXField와 기능과 이름이 유사함
    #label 매개변수 : 해당 입력공간의 설명란을 정의하는 매개변수 
    #기본 값은 변수명으로 설정됨 
    password_check = forms.CharField(max_length = 100, label='비밀번호 확인')
    
    class Meta:
        model = User
        #User에 무슨 변수가 있는지 확인 (ctrl key + User 클릭)
        fields = ['username','password','last_name','firts_name',
                  'email']
        #비밀번호 확인란은 class에 없고, 단순히 password가 같은지만 보면 되니까
        
'''로그인에 사용할 폼클래스 정의'''
class SigninForm(forms.ModelForm):
    class Meta:
        model = User
        fields = ['username','password'] 
