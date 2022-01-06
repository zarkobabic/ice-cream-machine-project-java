
# ice-cream-machine-project-java
Project for Object Oriented Programming 2 class



<b>ЕЛЕКТРОТЕХНИЧКИ ФАКУЛТЕТ
Одсеци за СИ, ИР, ОС и ОФ Београд 27.05.2021.</b>

Трећи домаћи задатак из
Објектно оријентисаног програмирања 2


<hr>



Саставити на језику Java следећи пакет класа:

• <b><i>Укус</i></b> се ствара са задатим називом и бојом </i>(Color)</i>. Сви параметри могу да се дохвате. Могуће је 
упоредити два укуса на једнакост. Два укуса су једнака уколико су им имена једнака. Могуће је 
саставити текстуални опис укуса у облику <b><i>[име]</i></b>.

• <b><i>Сладолед</i></b> у чаши се састоји од произвољног броја укуса. За сваки укус се памти и количина у 
милилитрима. Сладолед се ствара празан са задатом величином чаше у милилитрима. Могуће је 
додати задату количину задатог укуса. Уколико би се таквим додавањем превазишла величина
чаше, додаје се одговарајућа количина до пуне чаше. Додавањем већ постојећег укуса ажурира се 
само његова количина у сладоледу. Текстуални опис сладоледа је у облику укуси, где су укуси сви 
садржани укуси и њихове количине, раздвојени размацима, у облику количина<b><i> ml </i></b>укус.

•  <b><i>Место за точење</i></b> сладоледа је активно платно <i>(Canvas)</i>. Ствара се са задатим апаратом за 
точење (видети ниже) који је власник места за точење и садржи сладолед који може да се 
дохвати. Место за точење циклично исцртава прогрес точења укуса у сладолед на сваких 0.5 
секунди. У свакој итерацији исцртава се правоугаоник у боји укуса који се тренутно точи у 
сладолед, додаје се количина од 20ml тог укуса у сладолед и поставља се текст натписа  <i>(лабеле)</i> у 
апарату (видети ниже). Правоугаоници се исцртавају од доње ка горњој ивици платна једни изнад 
других. Висина правоугаоника се добија као процентуални део висине платна који одговара 
количини од 20ml у односу на величину чаше. Точење се завршава када се исцрта целокупан 
прогрес точења до врха и тада се апарату за точење омогућава продаја (видети ниже). Могуће је 
покренути точење при чему се тада креира сладолед од 200ml. Могуће је привремено зауставити, 
наставити или завршити точење. Могуће је испитати да ли је точење у току. Могуће је поставити 
тренутни укус који се точи у сладолед.

•  <b><i>Апарат за точење</i></b> је панел који садржи место за точење, панел са произвољним бројем
доступних укуса, дугме за продају сладоледа које је иницијално неактивно и лабелу за приказ 
сладоледа из места за точење, чији је текст могуће поставити. Панел са доступним укусима 
садржи дугмад у формату решетке. Натпис дугмета одговара тексту укуса. Могуће је додати ново 
дугме за задати укус у панел са доступним укусима. Грешка је 
уколико укус већ постоји. Притиском тастера миша на дугме
доступног укуса, месту за точење се поставља тренутни укус
на основу притиснутог дугмета и покреће точење уколико није 
покренуто, односно наставља већ започето точење. 
Отпуштањем тастера миша привремено се зауставља точење.
Могуће је омогућити продају сладоледа и тада дугме за 
продају постаје активно. Притиском на дугме за продају, 
завршава се точење и брише цртеж на месту за точење
<i>(канвасу)</i>, сладолед на месту за точење се исписује на 
стандардном излазу и дугме за продају постаје поново 
неактивно. 

•  <b><i>Сладоледџиница</i></b> је главни прозор апликације (са слике) који садржи апарат за точење и панел за 
додавање новог укуса у апарат за точење. Боја укуса који се додаје се задаје у хексадецималном 
формату.


![image](https://user-images.githubusercontent.com/92127059/148450153-77e28df1-818e-4c80-99ad-193cc2443e2e.png)
