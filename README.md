<h2>Описание проекта "Авиакомпания"</h2>

- [Summary](#summary)
- [Stack](#stack)
- [MVP](#mvp)
- [Backlog](#backlog)
- [Структура проекта](#структура-проекта)
    - [Бэкенд](#бэкенд)
    - [Фронтенд](#фронтенд)
- [Работа на проекте](#работа-на-проекте)
    - [С чего начинать](#с-чего-начинать)
    - [О таскборде](#о-таскборде)
    - [Как выполнять задачи](#как-выполнять-задачи)
    - [Проверка задач](#проверка-задач)
    - [Требования к коду](#требования-к-коду)
    - [Созвоны по проекту](#созвоны-по-проекту)


### Summary

Реализуем функционал авиакомпании на основе прототипа - [S7 Airlines](https://s7.ru/ru).

Проект рассчитан на студентов, успешно завершивших этап Pre-Project в Kata Academy.

### Stack

Проект пишется на базе `Java 11`, `Spring Boot 2`, `Maven` и архитектуре REST. Работаем с базой данных `MySQL` через `Hibernate`.

Чтобы не писать boilerplate-код, используем на проекте [Lombok](https://projectlombok.org/features/all).

Все контроллеры и их методы нужно сразу описывать аннотациями [Swagger](https://docs.swagger.io/swagger-core/v1.5.0/apidocs/allclasses-noframe.html).
Swagger UI при запущенном приложении крутится [здесь](http://localhost:8888/swagger-ui.html).

Таск-борд находится прямо на [Gitlab](https://gitlab.com/devs_hub/p_mf_airline_2/-/boards/4500816).

Dev-stand будем поднимать и разворачивать через Docker, а настраивать CI/CD - через Gitlab.

### MVP

[MVP](https://ru.wikipedia.org/wiki/%D0%9C%D0%B8%D0%BD%D0%B8%D0%BC%D0%B0%D0%BB%D1%8C%D0%BD%D0%BE_%D0%B6%D0%B8%D0%B7%D0%BD%D0%B5%D1%81%D0%BF%D0%BE%D1%81%D0%BE%D0%B1%D0%BD%D1%8B%D0%B9_%D0%BF%D1%80%D0%BE%D0%B4%D1%83%D0%BA%D1%82) - API (полностью описанное в Swagger), которое будет уметь продавать, менять, возвращать авиабилеты.
Работать с таким API можно будет через веб-интерфейс Swagger и Postman.

### Backlog

Фичи:
<ul>
<li>диверсификация перевозок (багаж, животные, oversized-вещи, грузы)</li>
<li>создание личного кабинета пассажира, добавление аутентификации через логин/пароль, Google, социальные сети</li>
<li>реализация функционала обратной связи с пассажиром через e-mail и Telegram</li>
<li>создание личного кабинета администратора</li>
<li>внедрение бонусной системы (мили), кэшбека и акций</li>
<li>внедрение проверок пассажиров по стоп-листам - общение с микросервисом "МВД"</li>
<li>добавление смежных сервисов - подбора гостиниц, аренды квартир, тренферов, каршеринга, экскурсий. Все - микросервисы.</li>
</ul>

Импрувменты:

<ul>
<li>логирование через Slf4j + log4j2</li>
<li>юнит-тесты и интеграционные тесты</li>
<li>анализ качества кода через SonarQube</li>
</ul>


## Структура проекта
### Бэкенд

Проект основан на архетипе webapp.
Слои:
<ul>
<li><code>config</code> конфигурационные классы, в т.ч. Spring Security, инструменты аутентификации</li>
<li><code>entities</code> сущности базы данных</li>
<li><code>repositories</code> dao-слой приложения, реализуем в виде интерфейсов Spring Data, имплементирующих JpaRepository.</li>
<li><code>services</code> бизнес-логика приложения, реализуем в виде интерфейсов и имплементирующих их классов.</li>
<li><code>controllers</code> обычные и rest-контроллеры приложения.</li>
<li><code>util</code> пакет для утилитных классов: валидаторов, шаблонов, хэндлеров.</li>
</ul>

### Фронтенд
Вьюшки будем писать на html и js (AJAX/FetchJS). Красоту наводить - с помощью Bootstrap или (если будет настроение) - Material UI.

## Работа на проекте
### С чего начинать

0. Доступы. Если ты читаешь это, значит доступ к проекту у тебя уже есть :)
<ol>
<li>загрузи проект себе в среду разработки</li>
<li>изучи весь проект - начни с pom, properties файлов и конфигурационных классов</li>
<li>создай локальную базу данных с названием <code>airline_db</code></li>
<li>добейся успешного запуска проекта. <a href="http://localhost:8888/"> Проверить</a>.</li>
<li>изучи <a href="https://gitlab.com/devs_hub/p_mf_airline_2/-/boards/4500816">таск-борд</a>
</ol>

### О таскборде

Таск-борд строится по принципу Kanban - он разделён на столбцы, каждый из которых соответствует определённому этапу работы с задачей:
<ul>
<li><code>Backlog / Future</code> задачи на <b>новый функционал</b>, выполнение которых отложено на более отдалённый срок</li>
<li><code>Postponed</code> НЕ БРАТЬ. Это задачи, которые будут перенесены в TODO позже. Они технически и/или хронологически зависят от выполнения каких-то задач, которые сейчас в TODO.</li>
<li><code>TODO</code> задачи, требующие выполнения</li>
<li><code>In Progress</code> выполняемые в данный момент задачи</li>
<li><code>Cross-review </code> задачи на этапе перекрёстной проверки студентами</li>
<li><code>Final Review</code> задачи на проверке у техлида</li>
<li><code>In Reworking</code> задачи, направленные на доработку</li>
<li><code>Closed</code> выполненные задачи</li>
</ul>


### Как выполнять задачи

<ul>
<li>в графе <code>TODO</code> на таск-борде выбери карточку с задачей и назначь её себе для исполнения</li>
<li>загрузи себе последнюю версию ветки <code>dev</code></li>
<li>создай от <code>dev</code> свою собственную ветку для выполнения взятой задачи. Свою ветку назови так, чтобы было понятно, чему посвящена задача. В начале имени ветки проставь номер задачи с Gitlab. Например, <code>313_adding_new_html_pages</code></li>
<li>выполни задачу, оттестируй и, если всё ок, залей её в репозиторий проекта</li>
<li>создай на своей ветке merge request, в теле реквеста укажи <code><i>Closes #здесь-номер-таски"</i></code>. Например, <code>Closes #313</code></li>
<li>перенеси задачу в столбец <code>Cross-review</code></li>
</ul>

### Проверка задач

На этапе кросс-ревью студенты проверяют задачи, выполненные друг другом.
В случае, если к коду есть замечания, проверяющий как можно более подробно описывает их в комментарии к карточке задачи и переносит её в столбец `In Reworking`.
Если к коду претензий нет, проверяющий студент ставит к карточке лайк.

**Каждая карточка (студенческая задача) должна быть проверена как минимум 2 другими студентами и одобрена ими (т.е. собрать не менее 2 лайков).**

Только после этого карточку можно переносить в столбец `Final Review`.

Затем код проверяет техлид (ментор) и в случае обнаружения ошибок переносит её в столбец `In Reworking`.
Если всё ок - merge request принимается, ветка студента сливается с основной веткой проекта, а карточка переносится в столбец `Done`.

### Требования к коду

- сделайте себе понятные никнеймы (имя + фамилия) в Git. Не хочу гадать, кто, где и что писал.
- для каждого класса и его содержимого пишите комментарии в формате <b>Javadoc</b>:
    - над классом: что это за класс, зачем нужен. Описывайте поля.
    - над методом: что делает, какие параметры принимает (и что это такое), что возвращает.
- свободно создавайте собственные вспомогательные классы в пакете Util - типа утилиток для страховки от null и типа того.
- в REST-контроллерах пользоваться аннотациями Swagger - причём как сами контроллеры в целом, так и их отдельные методы.
- на полях сущностей можно и нужно расставлять констрейнты для проверки формата, длины введённых значений, проверки чисел на положительность и т.д.
- пишите Commit message как можно более подробно! Желательно на анлгийском, но если никак - можно и на русском.

Если в процессе разработки вы пришли к пониманию того, что требуется создать какую-то ещё сущность - создавайте карточку и вперёд)

### Требования к логированию работы контроллеров:

1. В каждый метод необходимо добавить логирование с описанием произведенной операции на уровне info.

2. Если объект не найден, вывести сообщение уровня warning ("not found" или "does not exist") с описанием произведенной операции.

### Созвоны по проекту

Созвоны проходят по вторникам и четвергам оговорённое время.
Регламент:
- длительность до 15 минут
- формат: доклады по 3 пунктам:
    - что сделано с прошлого созвона
    - какие были/есть трудности
    - что будешь делать до следующего созвона
- техлид (ментор) на созвонах код не ревьюит

Любые другие рабочие созвоны команда проводит без ограничений, т.е. в любое время без участия техлида. 
Договаривайтесь сами :) 
