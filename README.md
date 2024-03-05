# TALLER 6: TALLER DE TRABAJO INDIVIDUAL EN PATRONES ARQUITECTURALES
#### Hecho por: Daniel Santiago Gómez Zabala

Servidor web Java que replique la funcionalidad de Spark sin usar frameworks como Spark o Spring. Deberá permitir el registro de servicios GET y POST utilizando funciones lambda, configurar directorios de archivos estáticos y cambiar el tipo de respuesta del encabezado HTTP.

Además, la aplicación web que permita a los usuarios consultar información sobre películas y series. La aplicación constará de un campo de entrada de texto y un botón que enviará la solicitud al servidor. El servidor deberá manejar estas solicitudes consultando un servicio de API externo de OMDb para obtener la información solicitada, y también deberá implementar un caché tolerante a concurrencia para mejorar el rendimiento.

En resumen, se necesita desarrollar un servidor web en Java desde cero, utilizando solo el API básico de Java. Este servidor debe admitir las funcionalidades mencionadas y comunicarse con el servicio de OMDb para proporcionar información sobre películas y series a través de una aplicación web simple.

## GETTING STARTED

1. Debe tener instalado Maven en su computador para poder ejecutar los comandos que se le indicarán más adelante.
2. Debe contar con GITHUB para poder hacer uso del repositorio donde se alberga el laboratorio.
3. Debe tener un ambiente de java para poder visualizar y ejecutar el codigo.

## INSTALLING

Debe clonar el respositorio para poder hacer uso de la app con el comando que se encuentra a continuación

```
git clone https://github.com/sagomezab/Taller3_AREP.git
```

Para hacer uso de la aplicación debe dirigirse a la carpeta *Taller4_AREP* y dese el CMD o Símbolo del Sistema ejecute el siguiente comando.

```
java -cp "target/classes" edu.escuelaing.arem.ASE.app.WebApp.MyWebServices

```

Después ingrese al siguiente link para comprobar el funcionamiento de la aplicación

```

http://127.0.0.1:35000/

```

![](img/PruebaFuncionamiento.png)

## Test

Para ejecutar las pruebas debe correr los siguiente comandos por el CMD o Símbolo del Sistema:

```
java -cp "target/classes" edu.escuelaing.arem.ASE.app.RunTest edu.escuelaing.arem.ASE.app.Foo
```

Y se ven de la siguiente manera :

![](img/PruebasFOO.png)

Para ejecutar las otras pruebas realizadas se ingresa el siguiente comando:

```
java -cp "target/classes" edu.escuelaing.arem.ASE.app.RunTest edu.escuelaing.arem.ASE.app.Faa
```
y se ven asi:

![](img/PruebasFAA.png)

## Clarifications and Desing

El proyecto cuenta con una clase llamada HttpServer que actúa como la fachada del servidor web, gestionando las solicitudes de los clientes y proporcionando un mecanismo para manejarlas. Esta clase también incluye un caché tolerante a concurrencia para almacenar las solicitudes al API externo y minimizar el tiempo y los recursos necesarios para futuras solicitudes.

Se ha simplificado la estructura del proyecto eliminando las interfaces de servicios REST y clases específicas para manejar recursos HTML, CSS, JavaScript e imágenes. Ahora, existe una clase llamada StaticFiles que gestiona las solicitudes y busca archivos estáticos en el disco del servidor, y otra clase llamada HttpResponse que configura los encabezados y el cuerpo de los paquetes HTTP a enviar.

Además, se ha añadido la capacidad de configurar manualmente servicios web tipo GET y POST mediante funciones lambda.

## Built With

* [Maven](https://maven.apache.org/) - Administrador de dependencias

## Version

1.0
## Author

Daniel Santiago Gómez Zabala [SAGOMEZAB](https://github.com/sagomezab)

## Acknowledgments

Extensibilidad: El usuario puede buscar cualquier tipo de archivo que exista dentro de resources, incluyendo carpetas o directorios internos. El uso de funciones lambda nos permite hacer la creación y uso de diferentes servicios.

Patrones usados: Se usa el patrón de Fachada y el patrón de Singleton

Modularización: Todas clases implementan metodos los cuales singuel el principio de unica responsabilidad, lo cual nos permite extender el codigo de ser necesario en dado caso que se necesite