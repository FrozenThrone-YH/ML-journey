#step1. 질문과 답 만들기

#메인화면 - 데이터 베이스에 저장된 Question객체를 바탕으로 HTML을 전달

def main(request):
    #데이터베이스에 저장된 모든 Question 객체를 추출
    '''
    Question.object : 데이터 베이스에 저장된 Question객체들을
    접근할때 사용하는 변수 
    객체를 접근할때는 4가지 함수로 접근할 수 있음.
    all():데이터 베이스에 저장된 모든 객체를 리스트형태로 추출
    get(조건):데이터 베이스에 저장된 객체 중 조건을 만족하는 객체 1개를 추출
    filter(조건) : 데이터베이스에 저장된 객체 중 조건을 만족하는 모든 객체를 리스트형태로 추출
    exclude(조건) : 데이터베이스에 저장된 객체 중 조건을 만족하지 않는 객체를 리스트형태로 추출 
    '''
    q = Question.objects.all()
    print(q)
    #추출된 Question 객체를 HTML 편집에 사용할 수 있도록 전달
    return render(request,"vote/main.html",{'q':q})

#웹 클라이언트가 요청한 Question객체 한개와 연결된 choice객체 추출 
#q_id : 웹클라이언트가 요청한 Question 객체의 id변수 값 
def detail(request,q_id):
    #Question 객체를 한개 추출 - id변수값이 q_id와 같은 조건에 맞는
    q = Question.objects.get(id=q_id)
    #추출한 Question객체와 연동된 Choice객체들을 추출
    #외래키로 연결된 Question객체가 Choice객체들을 대상으로 
    #추출함수를 사용하려면 객체.choice_set.추출함수로 추출
    #외래키로 연결된 객체.외래키로 연결한 모델클래스명_set.all,get 
    c = q.choice_set.all()
    print(q)
    print(c)
    #HTML코드로 추출한 객체들 전달 
    return render(request,"vote/detail.html",{'q':q,'c':c})





