<h2>Задание 1: тема для курсовой работы и структура окон</h2>
<p>Группа для выполнения курсовой: Бигун Александр Олегович и Зубанич Михаил Юрьевич из группы НАИ-196</p>
<p>Тема курсовой: мобильная 2D игра в жанре аркады</p>
<h3>Структура окон</h3>
Структура окон представлена в виде activity-диаграммы:
<img src="https://github.com/St1r3S/Mobile-Devices-Programming/blob/main/Lab3/images/activities.jpg" width="800">
В <b>AuthorizationActivity</b> происходит авторизация пользователя. После удачной авторизации он попадает в <b>MainMenuActivity</b>, из которой может попасть в другие 3
activity: <b>GameActivity</b>, где и будет реализован весь игровой процесс, <b>LeaderBoardActivity</b>, где можно просмотреть список лидеров, и <b>ProfileActivity</b>, где находятся данные пользователя. После того, как игрок проигрывает, он попадает в <b>GameOverActivity</b>, из которой 
может вернуться в игру(GameActivity), или в главное меню(MainMenuActivity)
<h2>Задание 2: приложение для отправки селфи на почту</h2>
<p>Для лабораторной работы №3 было разработано мобильную программу, в которой есть возможность сделать селфи, выбрать картинку из галереи, просмотреть выбранную картинку в
приложении, а также отправить её на почту</p>
<img src="https://github.com/St1r3S/Mobile-Devices-Programming/blob/main/Lab3/images/1.jpg" width="200">
По нажатию на кнопку <b>Take a shot</b> появляется возможность сделать фото, после чего его можно увидеть над кнопками:
<img src="https://github.com/St1r3S/Mobile-Devices-Programming/blob/main/Lab3/images/2.jpg" width="200">
По нажатию на кнопку <b>Send a selfie</b> появляется возможность выбрать приложение, с помощью которого Вы хотите отправить фото::
<img src="https://github.com/St1r3S/Mobile-Devices-Programming/blob/main/Lab3/images/3.jpg" width="200">
Выбрав <b>Gmail</b>, пользователь переходит к письму, к которому прикреплено его фото. Потом письмо можно отправить:
<img src="https://github.com/St1r3S/Mobile-Devices-Programming/blob/main/Lab3/images/4.jpg" width="200">
