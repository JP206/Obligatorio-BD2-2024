# Obligatorio Bases de Datos 2 - 2024
### Juan Cosentino, Santiago Ferraro, Bianca Luzzatto

# Para correr la aplicación
### API y backend
- Es necesario tener instalado JDK 8 o superior
- Descargar Maven de la siguiente URL: https://maven.apache.org/download.cgi
- Seguir los pasos de instalación de Maven: https://maven.apache.org/install.html
- Para crear una variable de entorno como dice la instalación, se puede correr la siguiente línea en la consola: set PATH="c:\ruta donde se descomprimió\apache-maven-3.x.y\bin";%PATH%
- Para más información del paso anterior, verificar la segunda respuesta en: https://stackoverflow.com/questions/45119595/how-to-add-maven-to-the-path-variable
- En la consola, dirigirse al directorio "api". Una vez dentro, para iniciar la API se debe ejecutar: mvn spring-boot:run
- Debería verse así el final de la consola:
![consola api](comando-api.png)
- Marcado en rojo indica el puerto en el que corre la API
### Frontend
- Es necesario tener instalado Node.js, el cual puede ser descargado de la siguiente URL: https://nodejs.org/en
- Es necesario tener instalada la CLI de Angular. Para hacerlo, se debe abrir una terminal y ejecutar: npm install -g @angular/cli
- Es necesario tener instalado node modules. Para esto, desde la consola navegar hasta el directorio raíz del proyecto de Angular y ejecutar: npm install
- Para iniciar el frontend, en una consola ubicada en la carpeta ObligatorioBD2-Angular, ejecutar: ng serve --open
- Con la bandera --open la aplicación se iniciará un navegador (o se abrirá una nueva pestaña en caso de que esté abierto el navegador) y se dirigirá a la URL del proyecto automáticamente
- La aplicación utiliza Bootstrap para los estilos. Debería instalarse por defecto con npm install, en caso de que no sea así (los componentes de la página fallan) se debe instalar abriendo una terminal en el directorio raíz y ejecutando: npm install bootstrap
### Docker con la base de datos
- Es necesario tener Docker instalado. Se puede descargar de la siguiente URL: https://www.docker.com/products/docker-desktop/
- En el directorio raíz de este repositorio hay un archivo docker-compose.yml. Desde la terminal y en este directorio ejecutar: docker-compose up 


# PencaUCU Copa América 2024

![Copa america](logo-copa-america.jpg)

Cada día falta menos para poder volver a disfrutar de nuestros jugadores y volver a 
vestir la Celeste del Alma. Ya se puede comenzar a palpitar la Copa América 2024. 
Mientras Bielsa arma el listado de jugadores que va a reservar para representarnos de 
la mejor manera, la UCU está pensando como incentivar a los alumnos a participar de 
la PencaUCU, penca para los alumnos que pertenecen a la universidad. 


Luego de varias reuniones de coordinación, se decidió que se otorgará un premio al 
primer puesto que gane la Penca (Camiseta autografiada por los jugadores de la 
selección) y un premio al segundo puesto (Pelota similar a la que se utilizará en la 
Copa). El puesto final de todos los participantes se obtendrá mediante un listado de 
puntos conseguidos durante toda la Copa. 


Para ser más justo se pensó en una manera de premiar a los que acierten con los 
resultados más exactos. ¿Cómo se otorgarán los puntos? Se otorgarán 4 puntos por 
resultado exacto de un partido, y 2 puntos por resultado correcto. También se 
otorgarán 10 puntos por campeón y 5 por subcampeón, ambos datos se deberán 
cargar al momento de crear el usuario y no podrán modificarlo luego, por lo cual 
tendrán que estar muy seguros de lo que ingresan. Se contará con un registro de 
usuarios, así como con un usuario administrador para cargar los resultados de los 
partidos jugados. Vale recordar que el usuario administrador no podrá ser un alumno, 
ya que el mismo no podría participar de la penca. 


Cada día, antes del primer partido de la etapa, se le enviará una notificación a los 
usuarios participantes que deben ingresar sus jugadas, si no lo han hecho aún. Podrán 
ingresar sus predicciones una hora antes de que comience el partido. Como hay 
alumnos que son muy aplicados y ya tiene todos los posibles resultados en su mente, 
pueden ingresar los resultados en cualquier momento y modificarlo también, siempre 
que se cumpla que no falte una hora para el partido.


Se podrá visualizar la lista de participantes con sus puntajes para cotejo de todos, así 
como el fixture del campeonato, el cual se actualizará en cada etapa. ¿Cómo 
funcionaría? Empecemos por registrarnos e ingresar predicciones para los partidos 
(obviamente no podré ingresar más de una predicción por partido). Deberé otorgar a 
cada usuario la posibilidad de ver sus predicciones ingresadas y los puntos obtenidos 
en cada una (si ya se ha jugado el partido). Esta aplicación debería poder ser usada 
inicialmente por todos los alumnos de la UCU que se hayan registrado en la misma.  
El Sistema debe tener en cuenta que a futuro puede interesar sacar estadísticas de 
como son los porcentajes de acierto de los alumnos teniendo en cuenta la Carrera que 
cursan.


Las funcionalidades de esta app estarán limitadas solo por su imaginación, y en ello 
residirá el valor que tenga. Mínimamente deberá contemplar factores como los 
descriptos previamente, multiusuario, obviamente que, en una base de datos, 
programado con SQL.
