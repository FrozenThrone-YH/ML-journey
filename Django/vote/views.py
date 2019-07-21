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



