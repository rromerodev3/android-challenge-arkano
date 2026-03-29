Roger Romero Gonzalez - Code Challenge Arkano (Android Mobile Developer)

Decisiones técnicas tomadas:

Clean Architecture:
El proyecto fue estructurado bajo el principio de Clean Architecture, organizando el código en capas principalmente: Presentation (código relacionado a UI), Domain (código relacionado al funcionamiento del negocio) y Data (código relacionado a datos). Adicionalmente se agregaron otras capas más específicas propias del entorno de Android como por ejemplo la capa app y la capa di para la inyeccion de dependencias. Esto nos permite que el proyecto tenga una mejor organización, legibilidad y por lo tanto será más fácil su mantenimiento.

Compose:
El proyecto utiliza compose que es el nuevo framework oficial para el desarrollo de UI, separando los componentes de las diferentes pantallas en composables reutilizables y agregando preview de los mismos, las cadenas y dimensiones se almacenaron en su archivo correspondiente para poder facilitar el cambio de idioma y de dimensiones  respectivamente.


MVVM:
El proyecto se desarrolló con la arquitectura Model-View-ViewModel (MVVM) ya que es la arquitectura oficial recomendada, está arquitectura consta de Modelo (representación de los datos), vista (es la ui) y viewmodel (se encarga de preparar el modelo y notificar a la ui), está arquitectura destaca por su característica reactiva donde la UI se suscribe a eventos en tiempo real dentro del viewmodel que notifica los cambios en tiempo real. La clase viewmodel utilizada es la oficial por lo que cuenta con soporte para Android por lo que está diseñado para manejar el ciclo de vida de las Activities así como los cambios de configuración.

Estado:
El manejo del estado se gestiona de manera reactiva creando una clase con los diferentes estados de la pantalla dentro del viewmodel, despues se crea un MutableStateFlow con una instancia del estado despues el composable principal es el encargado de subscribirse a el MutableStateFlow por lo que cada vez que se modifique se creara una recomposicion y la Ui se actualizara con el nuevo estado obtenido y con los datos del mismo de ser el caso, de esta menera el codigo de la pantalla es mas legible y mantenible.

Patrones de diseño
En el proyecto se utilizaron diferentes patrones de diseño oficiales recomendados dentro de los cuales los que se pueden destacar es el patron Repository, Inyection de Dependencias, Singleton y Observer.

Dependency Injection:
En el proyecto se utilizó este patron para definir las instancias que deberan de ser proporcionadas a las clases que las necesiten como usecases, repositorios y data sources, esto nos facilita el testing, el manteamiento del proyecto y la estabilidad del mismo.

Hilt:
Para la inyección de dependencias se utilizó hilt que es un framework basado en Dagger y que además es el framework oficial recomendado para inyección de dependencias en android por lo que cuenta con soporte para Compose asi como para clases de android como actividades y fragmentos.


Principios SOLID:
Para respetar el principio Responsabilidad unica, las clases tienen un unico objetivo y responsabilidades unicas, los composables solo renderizan la ui, el viewmodel obtiene y actualiza el estado y los repositorios acceden a los datos necesarios.
Al utilizar interfaces como parametros de repositorios y de datasources no dependemos directamente de implementaciones si no de abstracciones de esta manera respetamos el principio de Inversion de Dependencias.
Las interfaces solo definen los metodos estrictamente necesarios para su funcionamiento, de esta manera respetamos el principio de segregacion de interfaces.

Manejo de estado:
Para manejar el estado de la pantalla se utilizo un enfoque reactivo en la aplicación por lo que se utilizó la clase Mutable State Flow que es la clase correspondiente para que se ejecute la recomposición cuando algún valor observado modifique su valor lo cual ocasiona que compose vuelva a ejecutar los composables correspondientes para actualizar la UI. El estado reside dentro del viewmodel por lo que por default se maneja el ciclo de vida de la actividad contenedora.


Corrutinas
Para las operaciones en segundo plano se utilizaron corrutinas de kotlin, ya que estas nos permiten ejecutar tareas asíncronas y una vez que tenemos el resultado esperado podemos notificar el hilo principal sobre los detalles a mostrar, de esta manera el hilo principal solo se encarga de mantener la interfaz actualizada y sin ningún tipo de delay.


Gitflow   
El repositorio del proyecto utiliza Gitflow como estrategia para el manejo de branching, esta estrategia define ramas para versiones específicas como por ejemplo development, feature y release. Una vez que una versión esta lista se crea un tag con la version correspondiente, toda la elaboración del challengue fue realizada con gitflow y se podrá validar al analizar el repositorio.
url del repositorio: https://github.com/rromerodev3/android-challenge-arkano


----------------------------------------------------------------------------------------------- 

Qué quedó fuera por falta de tiempo:
CI/CD
Testing Unitario, Testing de Integracion y Testing de Ui.

---------------------------------------------------------------------------------------------------- 

Qué mejorarías con más tiempo:
Implementaria Material Design 3 y mejoraria el look and feel de la App.

---------------------------------------------------------------------------------------------------- 

Si utilizaste AI, en qué partes y cómo:
Par el uso de IA, personalmente prefiero delegar actividades repetitivas y hacer consultas específicas.
La arquitectura, decisiones tecnicas y logica prefiero definirlas yo, en resumen, prefiero utilizar IA mas como una herramienta de productividad como complemento.
Implementaria Material Design 3 en los composables y mejoraria el look and feel de la app.