#최종 setting.py 코드 
#신규 추가 : 47~50번째줄/77~79번째줄/136번째 줄 이후 

"""
Django settings for mysite7 project.

Generated by 'django-admin startproject' using Django 2.1.7.

For more information on this file, see
https://docs.djangoproject.com/en/2.1/topics/settings/

For the full list of settings and their values, see
https://docs.djangoproject.com/en/2.1/ref/settings/
"""

import os

# Build paths inside the project like this: os.path.join(BASE_DIR, ...)
BASE_DIR = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))


# Quick-start development settings - unsuitable for production
# See https://docs.djangoproject.com/en/2.1/howto/deployment/checklist/

# SECURITY WARNING: keep the secret key used in production secret!
SECRET_KEY = 'fli!h@e(b)28^&=-&s!q43x)mv0q)h=p#p0b*vm_-$_0=%x+=x'

# SECURITY WARNING: don't run with debug turned on in production!
DEBUG = True

ALLOWED_HOSTS = []


# Application definition
# 해당 웹프로젝트에서 실행할 어플리케이션 목록을 저장하는 변수
# 다른 개발자가 만든 어플리케이션이나 스스로 만든 어플리케이션을 
# 등록해야 사용가능하다. 
INSTALLED_APPS = [
    'django.contrib.admin',
    'django.contrib.auth',
    'django.contrib.contenttypes',
    'django.contrib.sessions',
    'django.contrib.messages',
    'django.contrib.staticfiles',
    'vote',
    'customlogin',
    #소셜로그인처리하는 어플리케이션
    #social-auth-app-django 모듈을 pip로 설치해야 사용가능
    #우리 사이트에 꼭 회원가입을 하지 않더라도 사용할 수 있게하는 라이브러리
    'social_django',
    
]

MIDDLEWARE = [
    'django.middleware.security.SecurityMiddleware',
    'django.contrib.sessions.middleware.SessionMiddleware',
    'django.middleware.common.CommonMiddleware',
    'django.middleware.csrf.CsrfViewMiddleware',
    'django.contrib.auth.middleware.AuthenticationMiddleware',
    'django.contrib.messages.middleware.MessageMiddleware',
    'django.middleware.clickjacking.XFrameOptionsMiddleware',
]

ROOT_URLCONF = 'mysite7.urls'

TEMPLATES = [
    {
        'BACKEND': 'django.template.backends.django.DjangoTemplates',
        'DIRS': [],
        'APP_DIRS': True,
        'OPTIONS': {
            'context_processors': [
                'django.template.context_processors.debug',
                'django.template.context_processors.request',
                'django.contrib.auth.context_processors.auth',
                'django.contrib.messages.context_processors.messages',
                #social.django기능을 사용하기 위한 설정
                'social_django.context_processors.backends',
                'social_django.context_processors.login_redirect',
            ],
        },
    },
]

WSGI_APPLICATION = 'mysite7.wsgi.application'


# Database
# https://docs.djangoproject.com/en/2.1/ref/settings/#databases

DATABASES = {
    'default': {
        'ENGINE': 'django.db.backends.sqlite3',
        'NAME': os.path.join(BASE_DIR, 'db.sqlite3'),
    }
}


# Password validation
# https://docs.djangoproject.com/en/2.1/ref/settings/#auth-password-validators

AUTH_PASSWORD_VALIDATORS = [
    {
        'NAME': 'django.contrib.auth.password_validation.UserAttributeSimilarityValidator',
    },
    {
        'NAME': 'django.contrib.auth.password_validation.MinimumLengthValidator',
    },
    {
        'NAME': 'django.contrib.auth.password_validation.CommonPasswordValidator',
    },
    {
        'NAME': 'django.contrib.auth.password_validation.NumericPasswordValidator',
    },
]


# Internationalization
# https://docs.djangoproject.com/en/2.1/topics/i18n/

LANGUAGE_CODE = 'ko'

TIME_ZONE = 'UTC'

USE_I18N = True

USE_L10N = True

USE_TZ = True


# Static files (CSS, JavaScript, Images)
# https://docs.djangoproject.com/en/2.1/howto/static-files/

STATIC_URL = '/static/'
#social-django에서 인증절차에 사용되는 클래스 등록
AUTHENTICATION_BACKENDS = (
    'social_core.backends.open_id.OpenIdAuth',
    #구글 로그인 기능을 사용하기 위한 클래스 등록
    'social_core.backends.google.GoogleOpenId',
    'social_core.backends.google.GoogleOAuth2',
    'social_core.backends.google.GoogleOAuth',
    # 구글 로그인 정보를 django User 모델클래스에 연동하기 위한 클래스 등록 
    'django.contrib.auth.backends.ModelBackend',
)
#구글 로그인하기에 사용할 요청 ID
#지정된 변수를 사용해야한다. 
SOCIAL_AUTH_GOOGLE_OAUTH2_KEY ='612069233261-e9jfgn7qov3dgtlupu8q5nh2b8p3uf4n.apps.googleusercontent.com'
#요청 PASSWORD
SOCIAL_AUTH_GOOGLE_OAUTH2_SECRET ='pVz-ExrPVp94u-Foc-btPur8'
