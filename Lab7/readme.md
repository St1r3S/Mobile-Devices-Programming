<h1>Лабораторная работа №7</h1>
<p>Целью данной лабораторной работи есть изучение работы с широковещательными сообщениями. В программе должно быть реализовано обработку таких событий: низкий заряд батареи, режим в самолёте и нажатие на кнопку камеры. Реализовать вывод сообщения сначала через диалоговые окна, а потом и через уведомления</p>

<h2>Задание №1</h2>
<h3>Классы Receiver</h3>
<p>Было создано классы приёмников для каждого события: <b>BatteryReceiver</b>, <b>AirplaneModeReceiver</b>, <b>CameraButtonReceiver</b>.</p>

<p>В методе <b>onReceive</b> идет проверка на то, что произошло то событие, на которое нам следует отреагировать. 
  Реакцией на определённое событие должен быть вызов диалогового окна, но диалоговое окно можно вызвать только из Активити, поэтому создаем
  Intent для перехода к DialogActivity, в котором уже и будет вызвано то или иное диалоговое окно.</p>

<h3>Регистрация ресиверов</h3>
<p>Чтобы ресиверы могли отработать, сначала их нужно зарегистрировать. Делается это напрямую в контексте MainActivity. В методе <b>onStart</b> регистрируется 3 ресивера. 
  Также для регистрации ресиверу нужен соответствующий фильтр для реакции на определенные события.
  Также в методе <b>onStop</b> ресиверы убираются из зарегистрированных.</p>

<h3>Диалоговые окна</h3>
<p>Диалоговые окна нужны лишь для оповещения пользователя о том, что какое-то событие уже произошло. 
  Также по нажатию на кнопку ОК вызывается функция <b>returnToMain</b> для возвращения в MainActivity.</p>

<h3>DialogActivity</h3>
<p>Внутри <b>DialogActivity</b> проверяется значение <b>dialog_id</b>, в зависимости от которого вызывается то или иное диалоговое окно. 
  Из приемника низкой зарядки отправляется значение 1, режима в самолете - 2, а из нажатия на кнопку камеры соответственно 3.</p>

<h3>Скриншоты выполнения программы</h3>
<p>Включение режима в самолете:</p>
<img src="https://github.com/St1r3S/Mobile-Devices-Programming/blob/main/Lab7/images/Screenshot_1.png" width="300"></img>
<p>Выключение режима в самолете:</p>
<img src="https://github.com/St1r3S/Mobile-Devices-Programming/blob/main/Lab7/images/Screenshot_2.png" width="300"></img>
<p>Низкий уровень заряда телефона:</p>
<img src="https://github.com/St1r3S/Mobile-Devices-Programming/blob/main/Lab7/images/Screenshot_3.png" width="300"></img>
<p>Нажатие на кнопку камеры:</p>
<img src="https://github.com/St1r3S/Mobile-Devices-Programming/blob/main/Lab7/images/Screenshot_4.png" width="300"></img>


<h2>Задание №2</h2>

<h3>Notification channels</h3>
<p>Для создания уведомлений необходимо создать каналы оповещения. Это делается в методе <b>onCreate</b> в MainActivity. Создаем каналы <b>batteryChannel</b>, <b>airplaneModeChannel</b>, <b>cameraButtonChannel</b>. 
  Для каждого оповещения указываем его id, нажвание и приоритет</p>

<h3>Ресивер</h3>
<p>Оповещения можно вызывать напрямую из класса ресивера, что даёт возможность избавиться от дополнительного <b>Activity</b>, в случае 1го задания - <b>DialogActivity</b>. 
  В методе <b>onReceive</b> создаётся Builder, в котором задаётся содержимое нашего оповещения: 
  иконка, название, текст и приоритет оповещения. После этого вызывается само оповещение.</p>

<h3>Скриншоты выполнения программы</h3>
<p>Включение режима в самолете:</p>
<img src="https://github.com/St1r3S/Mobile-Devices-Programming/blob/main/Lab7/images/Screenshot_5.png" width="300"></img>
<p>Выключение режима в самолете:</p>
<img src="https://github.com/St1r3S/Mobile-Devices-Programming/blob/main/Lab7/images/Screenshot_6.png" width="300"></img>
<p>Низкий уровень заряда телефона:</p>
<img src="https://github.com/St1r3S/Mobile-Devices-Programming/blob/main/Lab7/images/Screenshot_7.png" width="300"></img>
<p>Нажатие на кнопку камеры:</p>
<img src="https://github.com/St1r3S/Mobile-Devices-Programming/blob/main/Lab7/images/Screenshot_8.png" width="300"></img>





