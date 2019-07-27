   from vote.views import q_registe,
   
 
   urlpatterns = [
   #127.0.0.1:8000 vote/qr/
    path('vote/qr/',q_registe, name='qr'),
    ]
