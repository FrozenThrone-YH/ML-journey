from django.db import models

# Create your models here.
#django에서 제공하는 회원모델 클래스
#1명의 User가 여러개의 글을 작성할수 있도록 외래키 설정
from django.contrib.auth.models import User

#글 카테고리 
class Category(models.Model):
    #카테고리명
    #CharField의 첫번째 매개변수는 별칭
    #CharField의 두번째 매개변수는 글자수(자동완성하면 안됨)
    name = models.CharField('카테고리',max_length=10)
    
    pass

#글 내용을 저장
