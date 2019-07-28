from django.shortcuts import render
from customlogin.forms import SigninForm,SignupForm
from django.contrib.auth.models import User
from django.http.response import HttpResponseRedirect
from django.urls.base import reverse
# Create your views here.


'''회원가입'''
def signup(request):
#Get - 사용자에게 빈 회원가입란을 제공하는 HTML파일 전달
    if request.method == "GET":
        #SignupForm에서 입력할 수 있는 공간을 input태그로 변환
        result = SignupForm().as_table()
        return render(request,"cl/signup.html",{'result':result})
#POST - 사용자 입력을 바탕으로 회원가입 진행
    elif request.method == "POST":
        #사용자 입력을 바탕으로 객체 생성하고 
        form = SignupForm(request.POST)
        #사용자의 입력이 유효한 값이 있는지 확인(아이디 중목, e-mail 형식, 비밀번호 형식 확인)
        # -> is_valid() 함수 호출 결과가 True면 정상입력, False면 유효하지 않은 값 
        if form.is_valid():
            #is_valid함수의 결과가 True인 경우, form.cleaned_data변수로 원본 데이터를 접근할 수 있음
            #안그러면 회원가입란에 데이터베이스에 접근하는 문법을 치면 데이터가 수정이 되니까
            #비밀번호 란과 비밀번호 확인란이 같은 값이 있는지 확인
            if form.cleaned_data['password'] == form.cleaned_data['password_check'] :
                #User 객체 생성 및 데이터베이스에 저장
                #노가다가 좀 필요함 
                #User 모델 클래스는 비밀번호가 원본데이터가 아닌 암호화된 데이터를 저장한다.
                #새로운 User 객체를 생성할때 원본 비밀번호를 암호화해 객체생성해주는 함수를 사용해야한다.  
                # = > User.objects.create_user 함수를 사용하는 이유
                #create_user(id문자열, 이메일, 원본비밀번호 문자열)
                # = > 원본 비밀번호는 암호화된 상태로 새로운 User객체를 생성 및 반환
                new_user = User.objects.create_user(form.cleaned_data['username'],
                                         form.cleaned_data['email'],
                                         form.cleaned_data['password'])
                
                #성과 이름 저장변수에 사용자 입력을 대입 시킨다.
                new_user.first_name = form.cleane_data['first_name']
                new_user.last_name = form.cleane_data['last_name']
                
                #변경된 사항을 데이터베이스에게 통보
                new_user.save()
                
                #main 페이지로 이동 
                return HttpResponseRedirect(reverse('main'))
